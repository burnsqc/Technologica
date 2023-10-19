package com.technologica.data.worldgen.features;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class TechnologicaFeatureUtils {
	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
		TechnologicaMiscOverworldFeatures.bootstrap(context);
		TechnologicaOreFeatures.bootstrap(context);
		TechnologicaTreeFeatures.bootstrap(context);
		TechnologicaVegetationFeatures.bootstrap(context);
	}
}