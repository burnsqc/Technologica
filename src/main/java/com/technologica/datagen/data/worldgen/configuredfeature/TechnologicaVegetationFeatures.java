package com.technologica.datagen.data.worldgen.configuredfeature;

import java.util.List;

import com.technologica.Technologica;
import com.technologica.datagen.data.worldgen.placedfeature.TechnologicaTreePlacements;
import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class TechnologicaVegetationFeatures {
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MODIFIED_JUNGLE = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Technologica.MODID, "trees_modified_savanna"));
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MODIFIED_SAVANNA = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Technologica.MODID, "trees_modified_jungle"));
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MODIFIED_JUNGLE_EDGE = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Technologica.MODID, "trees_modified_jungle_edge"));
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MODIFIED_BAMBOO_JUNGLE = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Technologica.MODID, "trees_modified_bamboo_jungle"));
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MODIFIED_FOREST = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Technologica.MODID, "trees_modified_forest"));
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MODIFIED_BIRCH_FOREST = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Technologica.MODID, "trees_modified_birch_forest"));
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MODIFIED_WOODED_HILLS = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Technologica.MODID, "trees_modified_wooded_hills"));
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MODIFIED_BEACH = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Technologica.MODID, "trees_modified_beach"));
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MODIFIED_TAIGA = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Technologica.MODID, "trees_modified_taiga"));
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MODIFIED_SNOWY_TAIGA = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Technologica.MODID, "trees_modified_snowy_taiga"));
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MODIFIED_SWAMP = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Technologica.MODID, "trees_modified_swamp"));
	public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BLACKBERRY_BUSH = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Technologica.MODID, "patch_blackberry_bush"));
	public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BLUEBERRY_BUSH = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Technologica.MODID, "patch_blueberry_bush"));
	public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_RASPBERRY_BUSH = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Technologica.MODID, "patch_raspberry_bush"));
	public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_STRAWBERRY_BUSH = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Technologica.MODID, "patch_strawberry_bush"));
	public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_COTTON_BUSH = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Technologica.MODID, "patch_cotton_bush"));
	public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_PEPPERCORN_BUSH = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Technologica.MODID, "patch_peppercorn_bush"));

	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> p_256132_) {
		// HolderGetter<ConfiguredFeature<?, ?>> holdergetter = p_256132_.lookup(Registries.CONFIGURED_FEATURE);
		HolderGetter<PlacedFeature> holdergetter1 = p_256132_.lookup(Registries.PLACED_FEATURE);
		Holder<PlacedFeature> holder = holdergetter1.getOrThrow(TechnologicaTreePlacements.ZEBRAWOOD_CHECKED);
		Holder<PlacedFeature> holder1 = holdergetter1.getOrThrow(TechnologicaTreePlacements.EBONY_CHECKED);
		Holder<PlacedFeature> holder2 = holdergetter1.getOrThrow(TechnologicaTreePlacements.KIWI_CHECKED);
		Holder<PlacedFeature> holder3 = holdergetter1.getOrThrow(TechnologicaTreePlacements.RUBBER_CHECKED);
		Holder<PlacedFeature> holder4 = holdergetter1.getOrThrow(TechnologicaTreePlacements.TEAK_CHECKED);
		Holder<PlacedFeature> holder5 = holdergetter1.getOrThrow(TechnologicaTreePlacements.CHERRY_CHECKED);
		Holder<PlacedFeature> holder6 = holdergetter1.getOrThrow(TechnologicaTreePlacements.PLUM_CHECKED);
		Holder<PlacedFeature> holder7 = holdergetter1.getOrThrow(TechnologicaTreePlacements.CHESTNUT_CHECKED);
		Holder<PlacedFeature> holder8 = holdergetter1.getOrThrow(TechnologicaTreePlacements.PEACH_CHECKED);
		Holder<PlacedFeature> holder9 = holdergetter1.getOrThrow(TechnologicaTreePlacements.ASPEN_CHECKED);
		Holder<PlacedFeature> holder10 = holdergetter1.getOrThrow(TechnologicaTreePlacements.COCONUT_CHECKED);
		Holder<PlacedFeature> holder11 = holdergetter1.getOrThrow(TechnologicaTreePlacements.APRICOT_CHECKED);
		Holder<PlacedFeature> holder12 = holdergetter1.getOrThrow(TechnologicaTreePlacements.PEAR_CHECKED);
		Holder<PlacedFeature> holder13 = holdergetter1.getOrThrow(TechnologicaTreePlacements.MAPLE_CHECKED);
		Holder<PlacedFeature> holder14 = holdergetter1.getOrThrow(TechnologicaTreePlacements.WALNUT_CHECKED);
		Holder<PlacedFeature> holder15 = holdergetter1.getOrThrow(TechnologicaTreePlacements.ORANGE_CHECKED);
		FeatureUtils.register(p_256132_, TREES_MODIFIED_SAVANNA, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder, 0.8F)), holder));
		FeatureUtils.register(p_256132_, TREES_MODIFIED_JUNGLE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder1, 0.33F), new WeightedPlacedFeature(holder2, 0.33F)), holder3));
		FeatureUtils.register(p_256132_, TREES_MODIFIED_JUNGLE_EDGE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder4, 0.8F)), holder4));
		FeatureUtils.register(p_256132_, TREES_MODIFIED_BAMBOO_JUNGLE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder5, 0.5F)), holder6));
		FeatureUtils.register(p_256132_, TREES_MODIFIED_FOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder7, 0.8F)), holder7));
		FeatureUtils.register(p_256132_, TREES_MODIFIED_BIRCH_FOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder8, 0.8F)), holder8));
		FeatureUtils.register(p_256132_, TREES_MODIFIED_WOODED_HILLS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder9, 0.8F)), holder9));
		FeatureUtils.register(p_256132_, TREES_MODIFIED_BEACH, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder10, 0.8F)), holder10));
		FeatureUtils.register(p_256132_, TREES_MODIFIED_TAIGA, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder11, 0.5F)), holder12));
		FeatureUtils.register(p_256132_, TREES_MODIFIED_SNOWY_TAIGA, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder13, 0.5F)), holder14));
		FeatureUtils.register(p_256132_, TREES_MODIFIED_SWAMP, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder15, 0.8F)), holder15));
		FeatureUtils.register(p_256132_, PATCH_BLACKBERRY_BUSH, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(TechnologicaBlocks.BLACKBERRY_BUSH.get().defaultBlockState().setValue(SweetBerryBushBlock.AGE, Integer.valueOf(3)))), List.of(Blocks.GRASS_BLOCK)));
		FeatureUtils.register(p_256132_, PATCH_BLUEBERRY_BUSH, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(TechnologicaBlocks.BLUEBERRY_BUSH.get().defaultBlockState().setValue(SweetBerryBushBlock.AGE, Integer.valueOf(3)))), List.of(Blocks.GRASS_BLOCK)));
		FeatureUtils.register(p_256132_, PATCH_RASPBERRY_BUSH, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(TechnologicaBlocks.RASPBERRY_BUSH.get().defaultBlockState().setValue(SweetBerryBushBlock.AGE, Integer.valueOf(3)))), List.of(Blocks.GRASS_BLOCK)));
		FeatureUtils.register(p_256132_, PATCH_STRAWBERRY_BUSH, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(TechnologicaBlocks.STRAWBERRY_BUSH.get().defaultBlockState().setValue(SweetBerryBushBlock.AGE, Integer.valueOf(3)))), List.of(Blocks.GRASS_BLOCK)));
		FeatureUtils.register(p_256132_, PATCH_COTTON_BUSH, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(TechnologicaBlocks.COTTON_BUSH.get().defaultBlockState().setValue(SweetBerryBushBlock.AGE, Integer.valueOf(3)))), List.of(Blocks.GRASS_BLOCK)));
		FeatureUtils.register(p_256132_, PATCH_PEPPERCORN_BUSH, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(TechnologicaBlocks.PEPPERCORNS.get().defaultBlockState().setValue(CropBlock.AGE, Integer.valueOf(3)))), List.of(Blocks.GRASS_BLOCK)));
	}
}
