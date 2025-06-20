package net.wetnoodle.enderwild;

import net.fabricmc.api.ModInitializer;

import net.wetnoodle.enderwild.registry.EnderWildBlocks;
import net.wetnoodle.enderwild.registry.EnderWildInventorySorting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnderWild implements ModInitializer {

    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.

    @Override
    public void onInitialize() {
        EnderWildBlocks.registerBlockPorperties();
        EnderWildInventorySorting.init();
    }
}