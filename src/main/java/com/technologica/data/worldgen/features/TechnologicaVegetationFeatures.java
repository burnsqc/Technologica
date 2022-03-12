package com.technologica.data.worldgen.features;

import java.util.List;

import com.technologica.data.worldgen.placement.TechnologicaTreePlacements;

import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;

public class TechnologicaVegetationFeatures {
	 public static final ConfiguredFeature<RandomFeatureConfiguration, ?> TREES__MODIFIED_SAVANNA = FeatureUtils.register("trees_modified_savanna", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreePlacements.ZEBRAWOOD_CHECKED, 0.8F)), TechnologicaTreePlacements.ZEBRAWOOD_CHECKED)));
}
