package com.technologica.data.worldgen.features;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class TechnologicaFeatureUtils {
	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> p_255869_) {
		TechnologicaMiscOverworldFeatures.bootstrap(p_255869_);
		TechnologicaOreFeatures.bootstrap(p_255869_);
		TechnologicaTreeFeatures.bootstrap(p_255869_);
		TechnologicaVegetationFeatures.bootstrap(p_255869_);
	}
}