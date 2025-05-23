package net.wetnoodle.enderwild.registry;

import net.bunten.enderscape.Enderscape;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.BiFunction;
import java.util.function.Function;

public class EnderWildItems {
    private static ResourceKey<Item> createResourceKey(String name) {
        return ResourceKey.create(Registries.ITEM, Enderscape.id(name));
    }

    private static ResourceKey<Item> blockIdToItemId(ResourceKey<Block> resourceKey) {
        return ResourceKey.create(Registries.ITEM, resourceKey.location());
    }

    public static Item registerBlock(Block block) {
        return registerBlock(block, BlockItem::new, new Item.Properties());
    }

    public static Item registerBlock(Block block, BiFunction<Block, Item.Properties, Item> biFunction, Item.Properties properties) {
        return registerItem(blockIdToItemId(block.builtInRegistryHolder().key()), propertiesx -> biFunction.apply(block, propertiesx), properties.useBlockDescriptionPrefix());
    }

    public static Item registerItem(String string, Function<Item.Properties, Item> function, Item.Properties properties) {
        return registerItem(createResourceKey(string), function, properties);
    }

    public static Item registerItem(String string) {
        return registerItem(createResourceKey(string), Item::new, new Item.Properties());
    }

    public static Item registerItem(ResourceKey<Item> resourceKey, Function<Item.Properties, Item> function, Item.Properties properties) {
        Item item = function.apply(properties.setId(resourceKey));
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }

        return Registry.register(BuiltInRegistries.ITEM, resourceKey, item);
    }
}
