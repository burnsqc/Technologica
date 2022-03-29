package com.technologica.data.worldgen.features;

import com.technologica.world.level.block.TechnologicaBlocks;
import com.technologica.world.level.levelgen.feature.TechnologicaFeature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.LakeFeature.Configuration;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

@SuppressWarnings("deprecation")
public class TechnologicaMiscOverworldFeatures {
	public static final Holder<ConfiguredFeature<Configuration, ?>> BRINE_POOL = FeatureUtils.register("brine_pool", TechnologicaFeature.BRINE_POOL.get(), (new LakeFeature.Configuration(BlockStateProvider.simple(TechnologicaBlocks.BRINE.get().defaultBlockState()), BlockStateProvider.simple(TechnologicaBlocks.LITHIUM_CLAY.get().defaultBlockState()))));
	public static final Holder<ConfiguredFeature<BlockStateConfiguration, ?>> OASIS = FeatureUtils.register("oasis", TechnologicaFeature.OASIS.get(), (new BlockStateConfiguration(Blocks.WATER.defaultBlockState())));
}