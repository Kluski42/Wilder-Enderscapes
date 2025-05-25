package net.wetnoodle.enderwild.registry;

import net.bunten.enderscape.Enderscape;
import net.bunten.enderscape.registry.EnderscapeBlocks;
import net.frozenblock.lib.item.api.FrozenCreativeTabs;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.ItemLike;
import net.wetnoodle.enderwild.EnderWildConstants;

public class EnderWildInventorySorting {

    public static ResourceKey<CreativeModeTab> ENDERSCAPE = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Enderscape.id("enderscape"));


    public static void init() {
        EnderWildConstants.logWithModName("Adding items to the creative menu for ");
        lazyFunction(EnderscapeBlocks.CELESTIAL_STEM, EnderWildBlocks.HOLLOWED_CELESTIAL_STEM);
        lazyFunction(EnderscapeBlocks.MURUBLIGHT_STEM, EnderWildBlocks.HOLLOWED_MURUBLIGHT_STEM);
        lazyFunction(EnderscapeBlocks.VEILED_LOG, EnderWildBlocks.HOLLOWED_VEILED_LOG);
        lazyFunction(EnderscapeBlocks.STRIPPED_CELESTIAL_STEM, EnderWildBlocks.STRIPPED_HOLLOWED_CELESTIAL_STEM);
        lazyFunction(EnderscapeBlocks.STRIPPED_MURUBLIGHT_STEM, EnderWildBlocks.STRIPPED_HOLLOWED_MURUBLIGHT_STEM);
        lazyFunction(EnderscapeBlocks.STRIPPED_VEILED_LOG, EnderWildBlocks.STRIPPED_HOLLOWED_VEILED_LOG);
    }

    private static void lazyFunction(ItemLike log, ItemLike hollowedLog) {
        FrozenCreativeTabs.addAfter(log, hollowedLog, CreativeModeTabs.BUILDING_BLOCKS);
        FrozenCreativeTabs.addAfter(log, hollowedLog, CreativeModeTabs.NATURAL_BLOCKS);
        FrozenCreativeTabs.addAfter(log, hollowedLog, ENDERSCAPE);
    }
}
