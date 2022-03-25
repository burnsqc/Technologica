package com.technologica.data.worldgen.features;

import com.technologica.world.level.levelgen.feature.TechnologicaFeature;

import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;

public class TechnologicaMiscOverworldFeatures {
	public static final ConfiguredFeature<BlockStateConfiguration, ?> OASIS = FeatureUtils.register("oasis", TechnologicaFeature.OASIS.get().configured(new BlockStateConfiguration(Blocks.WATER.defaultBlockState())));
}