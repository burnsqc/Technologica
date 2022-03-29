package com.technologica.data.worldgen.features;

import java.util.List;

import com.technologica.data.worldgen.placement.TechnologicaTreePlacements;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;

public class TechnologicaVegetationFeatures {
	 public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_MODIFIED_SAVANNA = FeatureUtils.register("trees_modified_savanna", Feature.RANDOM_SELECTOR, (new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreePlacements.ZEBRAWOOD_CHECKED, 0.8F)), TechnologicaTreePlacements.ZEBRAWOOD_CHECKED)));
	 public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_MODIFIED_JUNGLE = FeatureUtils.register("trees_modified_jungle", Feature.RANDOM_SELECTOR, (new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreePlacements.EBONY_CHECKED, 0.33F), new WeightedPlacedFeature(TechnologicaTreePlacements.KIWI_CHECKED, 0.33F)), TechnologicaTreePlacements.RUBBER_CHECKED)));
	 public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_MODIFIED_JUNGLE_EDGE = FeatureUtils.register("trees_modified_jungle_edge", Feature.RANDOM_SELECTOR, (new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreePlacements.TEAK_CHECKED, 0.8F)), TechnologicaTreePlacements.TEAK_CHECKED)));
	 public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_MODIFIED_BAMBOO_JUNGLE = FeatureUtils.register("trees_modified_bamboo_jungle", Feature.RANDOM_SELECTOR, (new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreePlacements.CHERRY_CHECKED, 0.5F)), TechnologicaTreePlacements.PLUM_CHECKED)));
	 public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_MODIFIED_FOREST = FeatureUtils.register("trees_modified_forest", Feature.RANDOM_SELECTOR, (new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreePlacements.CHESTNUT_CHECKED, 0.8F)), TechnologicaTreePlacements.CHESTNUT_CHECKED)));
	 public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_MODIFIED_BIRCH_FOREST = FeatureUtils.register("trees_modified_birch_forest", Feature.RANDOM_SELECTOR, (new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreePlacements.PEACH_CHECKED, 0.8F)), TechnologicaTreePlacements.PEACH_CHECKED)));
	 public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_MODIFIED_WOODED_HILLS = FeatureUtils.register("trees_modified_wooded_hills", Feature.RANDOM_SELECTOR, (new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreePlacements.ASPEN_CHECKED, 0.8F)), TechnologicaTreePlacements.ASPEN_CHECKED)));
	 public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_MODIFIED_BEACH = FeatureUtils.register("trees_modified_beach", Feature.RANDOM_SELECTOR, (new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreePlacements.COCONUT_CHECKED, 0.8F)), TechnologicaTreePlacements.COCONUT_CHECKED)));
	 public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_MODIFIED_TAIGA = FeatureUtils.register("trees_modified_taiga", Feature.RANDOM_SELECTOR, (new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreePlacements.APRICOT_CHECKED, 0.5F)), TechnologicaTreePlacements.PEAR_CHECKED)));
	 public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_MODIFIED_SNOWY_TAIGA = FeatureUtils.register("trees_modified_snowy_taiga", Feature.RANDOM_SELECTOR, (new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreePlacements.MAPLE_CHECKED, 0.5F)), TechnologicaTreePlacements.WALNUT_CHECKED)));
	 public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_MODIFIED_SWAMP = FeatureUtils.register("trees_modified_swamp", Feature.RANDOM_SELECTOR, (new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreePlacements.ORANGE_CHECKED, 0.8F)), TechnologicaTreePlacements.ORANGE_CHECKED)));
}