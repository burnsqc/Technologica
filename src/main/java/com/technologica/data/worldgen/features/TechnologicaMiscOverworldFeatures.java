package com.technologica.data.worldgen.features;

import com.google.common.collect.ImmutableSet;
import com.technologica.world.level.levelgen.feature.TechnologicaFeature;

import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SpringConfiguration;
import net.minecraft.world.level.material.Fluids;

public class TechnologicaMiscOverworldFeatures {
	public static final ConfiguredFeature<SpringConfiguration, ?> BRINE_POOL = FeatureUtils.register("brine_pool", TechnologicaFeature.BRINE_POOL.get().configured(new SpringConfiguration(Fluids.WATER.defaultFluidState(), true, 4, 1, ImmutableSet.of(Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE, Blocks.RED_SAND, Blocks.TERRACOTTA, Blocks.CALCITE, Blocks.DIRT))));
	public static final ConfiguredFeature<BlockStateConfiguration, ?> OASIS = FeatureUtils.register("oasis", TechnologicaFeature.OASIS.get().configured(new BlockStateConfiguration(Blocks.WATER.defaultBlockState())));
}