package com.technologica.data.worldgen.features;

import java.util.List;

import com.technologica.data.worldgen.placement.TechnologicaTreePlacements;
import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class TechnologicaVegetationFeatures {
	public static Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_MODIFIED_JUNGLE;
	public static Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_MODIFIED_SAVANNA;
	public static Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_MODIFIED_JUNGLE_EDGE;
	public static Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_MODIFIED_BAMBOO_JUNGLE;
	public static Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_MODIFIED_FOREST;
	public static Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_MODIFIED_BIRCH_FOREST;
	public static Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_MODIFIED_WOODED_HILLS;
	public static Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_MODIFIED_BEACH;
	public static Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_MODIFIED_TAIGA;
	public static Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_MODIFIED_SNOWY_TAIGA;
	public static Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_MODIFIED_SWAMP;
	public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_BLACKBERRY_BUSH;
	public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_BLUEBERRY_BUSH;
	public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_RASPBERRY_BUSH;
	public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_STRAWBERRY_BUSH;

	public static void register() {
		TREES_MODIFIED_SAVANNA = FeatureUtils.register("trees_modified_savanna", Feature.RANDOM_SELECTOR, (new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreePlacements.ZEBRAWOOD_CHECKED, 0.8F)), TechnologicaTreePlacements.ZEBRAWOOD_CHECKED)));
		TREES_MODIFIED_JUNGLE = FeatureUtils.register("trees_modified_jungle", Feature.RANDOM_SELECTOR, (new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreePlacements.EBONY_CHECKED, 0.33F), new WeightedPlacedFeature(TechnologicaTreePlacements.KIWI_CHECKED, 0.33F)), TechnologicaTreePlacements.RUBBER_CHECKED)));
		TREES_MODIFIED_JUNGLE_EDGE = FeatureUtils.register("trees_modified_jungle_edge", Feature.RANDOM_SELECTOR, (new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreePlacements.TEAK_CHECKED, 0.8F)), TechnologicaTreePlacements.TEAK_CHECKED)));
		TREES_MODIFIED_BAMBOO_JUNGLE = FeatureUtils.register("trees_modified_bamboo_jungle", Feature.RANDOM_SELECTOR, (new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreePlacements.CHERRY_CHECKED, 0.5F)), TechnologicaTreePlacements.PLUM_CHECKED)));
		TREES_MODIFIED_FOREST = FeatureUtils.register("trees_modified_forest", Feature.RANDOM_SELECTOR, (new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreePlacements.CHESTNUT_CHECKED, 0.8F)), TechnologicaTreePlacements.CHESTNUT_CHECKED)));
		TREES_MODIFIED_BIRCH_FOREST = FeatureUtils.register("trees_modified_birch_forest", Feature.RANDOM_SELECTOR, (new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreePlacements.PEACH_CHECKED, 0.8F)), TechnologicaTreePlacements.PEACH_CHECKED)));
		TREES_MODIFIED_WOODED_HILLS = FeatureUtils.register("trees_modified_wooded_hills", Feature.RANDOM_SELECTOR, (new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreePlacements.ASPEN_CHECKED, 0.8F)), TechnologicaTreePlacements.ASPEN_CHECKED)));
		TREES_MODIFIED_BEACH = FeatureUtils.register("trees_modified_beach", Feature.RANDOM_SELECTOR, (new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreePlacements.COCONUT_CHECKED, 0.8F)), TechnologicaTreePlacements.COCONUT_CHECKED)));
		TREES_MODIFIED_TAIGA = FeatureUtils.register("trees_modified_taiga", Feature.RANDOM_SELECTOR, (new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreePlacements.APRICOT_CHECKED, 0.5F)), TechnologicaTreePlacements.PEAR_CHECKED)));
		TREES_MODIFIED_SNOWY_TAIGA = FeatureUtils.register("trees_modified_snowy_taiga", Feature.RANDOM_SELECTOR, (new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreePlacements.MAPLE_CHECKED, 0.5F)), TechnologicaTreePlacements.WALNUT_CHECKED)));
		TREES_MODIFIED_SWAMP = FeatureUtils.register("trees_modified_swamp", Feature.RANDOM_SELECTOR, (new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreePlacements.ORANGE_CHECKED, 0.8F)), TechnologicaTreePlacements.ORANGE_CHECKED)));
		PATCH_BLACKBERRY_BUSH = FeatureUtils.register("patch_blackberry_bush", Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(TechnologicaBlocks.BLACKBERRY_BUSH.get().defaultBlockState().setValue(SweetBerryBushBlock.AGE, Integer.valueOf(3)))), List.of(Blocks.GRASS_BLOCK)));
		PATCH_BLUEBERRY_BUSH = FeatureUtils.register("patch_blueberry_bush", Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(TechnologicaBlocks.BLUEBERRY_BUSH.get().defaultBlockState().setValue(SweetBerryBushBlock.AGE, Integer.valueOf(3)))), List.of(Blocks.GRASS_BLOCK)));
		PATCH_RASPBERRY_BUSH = FeatureUtils.register("patch_raspberry_bush", Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(TechnologicaBlocks.RASPBERRY_BUSH.get().defaultBlockState().setValue(SweetBerryBushBlock.AGE, Integer.valueOf(3)))), List.of(Blocks.GRASS_BLOCK)));
		PATCH_STRAWBERRY_BUSH = FeatureUtils.register("patch_strawberry_bush", Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(TechnologicaBlocks.STRAWBERRY_BUSH.get().defaultBlockState().setValue(SweetBerryBushBlock.AGE, Integer.valueOf(3)))), List.of(Blocks.GRASS_BLOCK)));
	}
}