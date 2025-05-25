package net.wetnoodle.enderwild.block.termite;

import net.bunten.enderscape.registry.EnderscapeBlocks;
import net.frozenblock.wilderwild.WWConstants;
import net.frozenblock.wilderwild.block.termite.TermiteBlockBehavior;
import net.frozenblock.wilderwild.block.termite.TermiteBlockBehaviors;
import net.frozenblock.wilderwild.registry.WWSounds;
import net.frozenblock.wilderwild.registry.WilderWildRegistries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.wetnoodle.enderwild.EnderWildConstants;
import net.wetnoodle.enderwild.registry.EnderWildBlocks;
import org.jetbrains.annotations.NotNull;

public class EnderWildTermiteBlockBehaviors {
    private static @NotNull ResourceKey<TermiteBlockBehavior> createKey(String string) {
        return ResourceKey.create(WilderWildRegistries.TERMITE_BLOCK_BEHAVIOR, EnderWildConstants.id(string));
    }

    private static void registerPlayerOnly(
            @NotNull BootstrapContext<TermiteBlockBehavior> bootstrapContext,
            Block edibleBlock,
            @NotNull Block outputBlock
    ) {
        ResourceLocation edibleBlockLocation = BuiltInRegistries.BLOCK.getKey(edibleBlock);
        TermiteBlockBehaviors.register(
                bootstrapContext,
                createKey(edibleBlockLocation.getPath()),
                edibleBlock,
                outputBlock,
                true,
                false,
                true,
                null
        );
    }

    private static void registerNaturalAndPlayer(
            @NotNull BootstrapContext<TermiteBlockBehavior> bootstrapContext,
            Block edibleBlock,
            @NotNull Block outputBlock
    ) {
        ResourceLocation edibleBlockLocation = BuiltInRegistries.BLOCK.getKey(edibleBlock);
        TermiteBlockBehaviors.register(
                bootstrapContext,
                createKey(edibleBlockLocation.getPath()),
                edibleBlock,
                outputBlock,
                true,
                true,
                true,
                null
        );
    }

    private static void registerHollowed(
            @NotNull BootstrapContext<TermiteBlockBehavior> bootstrapContext,
            Block edibleBlock,
            @NotNull Block outputBlock
    ) {
        ResourceLocation edibleBlockLocation = BuiltInRegistries.BLOCK.getKey(edibleBlock);
        TermiteBlockBehaviors.register(
                bootstrapContext,
                createKey(edibleBlockLocation.getPath()),
                edibleBlock,
                outputBlock,
                true,
                false,
                true,
                WWSounds.LOG_HOLLOWED
        );
    }

    private static void registerBreakable(
            @NotNull BootstrapContext<TermiteBlockBehavior> bootstrapContext,
            Block edibleBlock
    ) {
        ResourceLocation edibleBlockLocation = BuiltInRegistries.BLOCK.getKey(edibleBlock);
        TermiteBlockBehaviors.register(
                bootstrapContext,
                createKey(edibleBlockLocation.getPath()),
                edibleBlock,
                null,
                false,
                false,
                true,
                null
        );
    }

    private static void registerBreakable(
            @NotNull BootstrapContext<TermiteBlockBehavior> bootstrapContext,
            String name,
            TagKey<Block> edibleBlocks
    ) {
        TermiteBlockBehaviors.register(
                bootstrapContext,
                createKey(name),
                edibleBlocks,
                null,
                false,
                false,
                true,
                null
        );
    }


    public static void bootstrap(BootstrapContext<TermiteBlockBehavior> bootstrapContext) {
        registerNaturalAndPlayer(bootstrapContext, EnderscapeBlocks.CELESTIAL_STEM, EnderscapeBlocks.STRIPPED_CELESTIAL_STEM);
        registerHollowed(bootstrapContext, EnderscapeBlocks.STRIPPED_CELESTIAL_STEM, EnderWildBlocks.STRIPPED_HOLLOWED_CELESTIAL_STEM);
        registerPlayerOnly(bootstrapContext, EnderWildBlocks.HOLLOWED_CELESTIAL_STEM, EnderWildBlocks.STRIPPED_HOLLOWED_CELESTIAL_STEM);
        registerNaturalAndPlayer(bootstrapContext, EnderscapeBlocks.CELESTIAL_HYPHAE, EnderscapeBlocks.STRIPPED_CELESTIAL_HYPHAE);
        registerBreakable(bootstrapContext, EnderscapeBlocks.CELESTIAL_CAP);
//        registerBreakable(bootstrapContext, EnderWildBlocks.STRIPPED_HOLLOWED_CELESTIAL_STEM);
    }
}
