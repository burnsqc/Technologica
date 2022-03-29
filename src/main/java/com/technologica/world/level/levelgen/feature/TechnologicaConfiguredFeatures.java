package com.technologica.world.level.levelgen.feature;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class TechnologicaConfiguredFeatures {
//	public static final ConfiguredFeature<?, ?> CRATER_FEATURE = register("crater_feature", TechnologicaFeature.CRATER.get().configured(new BlockStateConfiguration(Blocks.AIR.defaultBlockState())));
	
//	public static final ConfiguredFeature<?, ?> REDWOOD_FOREST_VEGETATION = register("redwood_forest_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreeFeatures.REDWOOD.placed(), 0.025F)), TreePlacements.OAK_CHECKED)));
//	public static final ConfiguredFeature<?, ?> RAINFOREST_VEGETATION = register("rainforest_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreeFeatures.ROSEWOOD.placed(), 0.5F)), TreePlacements.OAK_CHECKED)));
	
	private static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
		return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key, configuredFeature);
	}
}
