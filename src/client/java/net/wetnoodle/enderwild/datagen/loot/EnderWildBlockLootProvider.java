package net.wetnoodle.enderwild.datagen.loot;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

import static net.wetnoodle.enderwild.registry.EnderWildBlocks.*;

public final class EnderWildBlockLootProvider extends FabricBlockLootTableProvider {
    public EnderWildBlockLootProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        this.dropSelf(HOLLOWED_CELESTIAL_STEM);
        this.dropSelf(STRIPPED_HOLLOWED_CELESTIAL_STEM);
        this.dropSelf(HOLLOWED_MURUBLIGHT_STEM);
        this.dropSelf(STRIPPED_HOLLOWED_MURUBLIGHT_STEM);
        this.dropSelf(HOLLOWED_VEILED_LOG);
        this.dropSelf(STRIPPED_HOLLOWED_VEILED_LOG);
    }
}
