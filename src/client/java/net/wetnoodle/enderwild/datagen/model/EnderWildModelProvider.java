package net.wetnoodle.enderwild.datagen.model;

import net.bunten.enderscape.registry.EnderscapeBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.frozenblock.wilderwild.datagen.model.WWModelHelper;
import net.frozenblock.wilderwild.registry.WWBlocks;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.world.level.block.Blocks;
import net.wetnoodle.enderwild.registry.EnderWildBlocks;

import static net.wetnoodle.enderwild.registry.EnderWildBlocks.*;
import static net.bunten.enderscape.registry.EnderscapeBlocks.*;

public final class EnderWildModelProvider extends FabricModelProvider {

    public EnderWildModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators generator) {
        WWModelHelper.createHollowedLog(generator, HOLLOWED_CELESTIAL_STEM, HOLLOWED_CELESTIAL_STEM, STRIPPED_CELESTIAL_STEM, CELESTIAL_STEM);
        WWModelHelper.createHollowedLog(generator, HOLLOWED_MURUBLIGHT_STEM, HOLLOWED_MURUBLIGHT_STEM, STRIPPED_MURUBLIGHT_STEM, MURUBLIGHT_STEM);
        WWModelHelper.createHollowedLog(generator, HOLLOWED_VEILED_LOG, HOLLOWED_VEILED_LOG, STRIPPED_VEILED_LOG, VEILED_LOG);

        WWModelHelper.createStrippedHollowedLog(generator, STRIPPED_HOLLOWED_CELESTIAL_STEM, STRIPPED_HOLLOWED_CELESTIAL_STEM, STRIPPED_CELESTIAL_STEM);
        WWModelHelper.createStrippedHollowedLog(generator, STRIPPED_HOLLOWED_MURUBLIGHT_STEM, STRIPPED_HOLLOWED_MURUBLIGHT_STEM, STRIPPED_MURUBLIGHT_STEM);
        WWModelHelper.createStrippedHollowedLog(generator, STRIPPED_HOLLOWED_VEILED_LOG, STRIPPED_HOLLOWED_VEILED_LOG, STRIPPED_VEILED_LOG);
    }

    @Override
    public void generateItemModels(ItemModelGenerators generator) {

    }
}
