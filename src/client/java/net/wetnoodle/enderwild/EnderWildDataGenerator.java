package net.wetnoodle.enderwild;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.frozenblock.wilderwild.registry.WilderWildRegistries;
import net.minecraft.core.RegistrySetBuilder;
import net.wetnoodle.enderwild.block.termite.EnderWildTermiteBlockBehaviors;
import net.wetnoodle.enderwild.datagen.EnderWildRegistryProvider;
import net.wetnoodle.enderwild.datagen.loot.EnderWildBlockLootProvider;
import net.wetnoodle.enderwild.datagen.model.EnderWildModelProvider;
import net.wetnoodle.enderwild.datagen.tag.EnderWildBlockTagProvider;
import org.jetbrains.annotations.Nullable;

public class EnderWildDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
        final FabricDataGenerator.Pack pack = dataGenerator.createPack();

        // When adding a registry to generate, don't forget this!
        pack.addProvider(EnderWildRegistryProvider::new);

        pack.addProvider(EnderWildBlockTagProvider::new);
        pack.addProvider(EnderWildBlockLootProvider::new);

        // ASSETS

        pack.addProvider(EnderWildModelProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        EnderWildConstants.logUnstableWithModName("Generating dynamic registries for ");
        // Wilder Wild Registries
        registryBuilder.add(WilderWildRegistries.TERMITE_BLOCK_BEHAVIOR, EnderWildTermiteBlockBehaviors::bootstrap);
    }

    @Override
    public @Nullable String getEffectiveModId() {
        return EnderWildConstants.MOD_ID;
    }
}
