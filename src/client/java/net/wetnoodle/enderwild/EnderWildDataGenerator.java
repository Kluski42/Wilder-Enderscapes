package net.wetnoodle.enderwild;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.wetnoodle.enderwild.datagen.model.EnderWildModelProvider;

public class EnderWildDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
		final FabricDataGenerator.Pack pack = dataGenerator.createPack();

		// ASSETS

		pack.addProvider(EnderWildModelProvider::new);
	}
}
