package net.wetnoodle.enderwild.registry;

import net.bunten.enderscape.registry.EnderscapeBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.frozenblock.wilderwild.block.HollowedLogBlock;
import net.frozenblock.wilderwild.registry.WWBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.wetnoodle.enderwild.EnderWildConstants;

import java.util.function.Function;

import static net.bunten.enderscape.registry.EnderscapeBlocks.*;
import static net.wetnoodle.enderwild.EnderWildConstants.id;

public class EnderWildBlocks {
    private static final MapColor CELESTIAL_STEM_COLOR = EnderscapeBlocks.CELESTIAL_STEM.defaultMapColor();
    private static final MapColor STRIPPED_CELESTIAL_STEM_COLOR = EnderscapeBlocks.STRIPPED_CELESTIAL_STEM.defaultMapColor();
    private static final MapColor MURUBLIGHT_STEM_COLOR = EnderscapeBlocks.MURUBLIGHT_STEM.defaultMapColor();
    private static final MapColor STRIPPED_MURUBLIGHT_STEM_COLOR = EnderscapeBlocks.STRIPPED_MURUBLIGHT_STEM.defaultMapColor();
    private static final MapColor VEILED_BARK_COLOR = EnderscapeBlocks.VEILED_LOG.defaultMapColor();
    private static final MapColor STRIPPED_VEILED_LOG_COLOR = EnderscapeBlocks.STRIPPED_VEILED_LOG.defaultMapColor();

    public static final HollowedLogBlock HOLLOWED_CELESTIAL_STEM = register(true, "hollowed_celestial_stem",
            HollowedLogBlock::new,
            WWBlocks.hollowedStemProperties(CELESTIAL_STEM_COLOR)
    );

    public static final HollowedLogBlock STRIPPED_HOLLOWED_CELESTIAL_STEM = register(true, "stripped_hollowed_celestial_stem",
            HollowedLogBlock::new,
            WWBlocks.strippedHollowedStemProperties(STRIPPED_CELESTIAL_STEM_COLOR)
    );

    public static final HollowedLogBlock HOLLOWED_MURUBLIGHT_STEM = register(true, "hollowed_murublight_stem",
            HollowedLogBlock::new,
            WWBlocks.hollowedStemProperties(MURUBLIGHT_STEM_COLOR)
    );

    public static final HollowedLogBlock STRIPPED_HOLLOWED_MURUBLIGHT_STEM = register(true, "stripped_hollowed_murublight_stem",
            HollowedLogBlock::new,
            WWBlocks.strippedHollowedStemProperties(STRIPPED_MURUBLIGHT_STEM_COLOR)
    );

    public static final HollowedLogBlock HOLLOWED_VEILED_LOG = register(true, "hollowed_veiled_log",
            HollowedLogBlock::new,
            WWBlocks.hollowedLogProperties(STRIPPED_VEILED_LOG_COLOR, VEILED_BARK_COLOR)
    );

    public static final HollowedLogBlock STRIPPED_HOLLOWED_VEILED_LOG = register(true, "stripped_hollowed_veiled_log",
            HollowedLogBlock::new,
            WWBlocks.strippedHollowedLogProperties(STRIPPED_VEILED_LOG_COLOR)
    );

    public static void registerBlockPorperties() {
        registerStrippable();
        registerFlammable();
        registerFuels();
        registerAxe();
    }

    private static void registerStrippable() {
        StrippableBlockRegistry.register(HOLLOWED_CELESTIAL_STEM, STRIPPED_HOLLOWED_CELESTIAL_STEM);
        StrippableBlockRegistry.register(HOLLOWED_MURUBLIGHT_STEM, STRIPPED_HOLLOWED_MURUBLIGHT_STEM);
        StrippableBlockRegistry.register(HOLLOWED_VEILED_LOG, STRIPPED_HOLLOWED_VEILED_LOG);
    }

    private static void registerFlammable() {
        FlammableBlockRegistry flammableBlockRegistry = FlammableBlockRegistry.getDefaultInstance();
        flammableBlockRegistry.add(HOLLOWED_CELESTIAL_STEM, 5, 5);
        flammableBlockRegistry.add(STRIPPED_HOLLOWED_CELESTIAL_STEM, 5, 5);
        flammableBlockRegistry.add(HOLLOWED_MURUBLIGHT_STEM, 5, 5);
        flammableBlockRegistry.add(STRIPPED_HOLLOWED_MURUBLIGHT_STEM, 5, 5);
        flammableBlockRegistry.add(HOLLOWED_VEILED_LOG, 5, 5);
        flammableBlockRegistry.add(STRIPPED_HOLLOWED_VEILED_LOG, 5, 5);
    }

    private static void registerFuels() {
        FuelRegistryEvents.BUILD.register((builder, context) -> {
                    builder.add(HOLLOWED_CELESTIAL_STEM, 300);
                    builder.add(STRIPPED_HOLLOWED_CELESTIAL_STEM, 300);
                    builder.add(HOLLOWED_MURUBLIGHT_STEM, 300);
                    builder.add(STRIPPED_HOLLOWED_MURUBLIGHT_STEM, 300);
                    builder.add(HOLLOWED_VEILED_LOG, 300);
                    builder.add(STRIPPED_HOLLOWED_VEILED_LOG, 300);
                }
        );
    }

    private static void registerAxe() {
        HollowedLogBlock.registerAxeHollowBehavior(CELESTIAL_STEM, HOLLOWED_CELESTIAL_STEM);
        HollowedLogBlock.registerAxeHollowBehavior(STRIPPED_CELESTIAL_STEM, STRIPPED_HOLLOWED_CELESTIAL_STEM);
        HollowedLogBlock.registerAxeHollowBehavior(MURUBLIGHT_STEM, HOLLOWED_MURUBLIGHT_STEM);
        HollowedLogBlock.registerAxeHollowBehavior(STRIPPED_MURUBLIGHT_STEM, STRIPPED_HOLLOWED_MURUBLIGHT_STEM);
        HollowedLogBlock.registerAxeHollowBehavior(VEILED_LOG, HOLLOWED_VEILED_LOG);
        HollowedLogBlock.registerAxeHollowBehavior(STRIPPED_VEILED_LOG, STRIPPED_HOLLOWED_VEILED_LOG);
    }


    private static <T extends Block> T register(boolean hasItem, String string, Function<BlockBehaviour.Properties, T> function, BlockBehaviour.Properties properties) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, id(string));
        T block = function.apply(properties.setId(key));

        Registry.register(BuiltInRegistries.BLOCK, key, block);

        if (hasItem) EnderWildItems.registerBlock(block);

        return block;
    }
}
