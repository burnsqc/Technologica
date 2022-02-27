package com.technologica.world.level.levelgen.feature;

import java.util.List;

import com.technologica.data.worldgen.features.TechnologicaTreeFeatures;
import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class TechnologicaConfiguredFeatures {
//	public static final ConfiguredFeature<?, ?> LAKE_BRINE_FEATURE = register("lake_brine_feature", TechnologicaFeatures.LAKE_BRINE.get().configured(new LakeFeature.Configuration(BlockStateProvider.simple(TechnologicaBlocks.BRINE.get().defaultBlockState()), BlockStateProvider.simple(Blocks.STONE.defaultBlockState()))));
//	public static final ConfiguredFeature<?, ?> OASIS_FEATURE = register("oasis_feature", TechnologicaFeatures.OASIS.get().configured(new BlockStateConfiguration(Blocks.WATER.defaultBlockState())));
//	public static final ConfiguredFeature<?, ?> CRATER_FEATURE = register("crater_feature", TechnologicaFeatures.CRATER.get().configured(new BlockStateConfiguration(Blocks.AIR.defaultBlockState())));
	
//	public static final ConfiguredFeature<?, ?> REDWOOD_FOREST_VEGETATION = register("redwood_forest_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreeFeatures.REDWOOD.placed(), 0.025F)), TreePlacements.OAK_CHECKED)));
//	public static final ConfiguredFeature<?, ?> RAINFOREST_VEGETATION = register("rainforest_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TechnologicaTreeFeatures.ROSEWOOD.placed(), 0.5F)), TreePlacements.OAK_CHECKED)));
	
	public static final class States {
		protected static final BlockState BRINE_BLOCK = TechnologicaBlocks.BRINE.get().defaultBlockState();
	}
	
	private static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
		return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key, configuredFeature);
	}
}
