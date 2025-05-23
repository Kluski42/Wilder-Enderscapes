package net.wetnoodle.enderwild.registry;

import net.bunten.enderscape.Enderscape;
import net.bunten.enderscape.registry.EnderscapeItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import java.util.function.Function;

import static net.wetnoodle.enderwild.EnderWildConstants.id;

public class EnderWildBlocks {



    private static Block register(boolean hasItem, String string, Function<BlockBehaviour.Properties, Block> function, BlockBehaviour.Properties properties) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, id(string));
        Block block = function.apply(properties.setId(key));

        Registry.register(BuiltInRegistries.BLOCK, key, block);

        if (hasItem) EnderWildItems.registerBlock(block);

        return block;
    }
}
