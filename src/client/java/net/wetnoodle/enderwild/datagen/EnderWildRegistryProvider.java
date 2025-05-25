package net.wetnoodle.enderwild.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.frozenblock.wilderwild.registry.WilderWildRegistries;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.wetnoodle.enderwild.EnderWild;
import net.wetnoodle.enderwild.EnderWildConstants;

import java.util.concurrent.CompletableFuture;

public class EnderWildRegistryProvider extends FabricDynamicRegistryProvider {
    public EnderWildRegistryProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider provider, Entries entries) {
        EnderWildConstants.logWithModName("Adding finalized termite block behaviors to datagen for");
        entries.addAll(asLookup(entries.getLookup(WilderWildRegistries.TERMITE_BLOCK_BEHAVIOR)));
    }

    public static <T> HolderLookup.RegistryLookup<T> asLookup(HolderGetter<T> getter) {
        return (HolderLookup.RegistryLookup<T>) getter;
    }

    @Override
    public String getName() {
        return "Ender Wild Dynamic Registries";
    }
}
