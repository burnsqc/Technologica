package com.technologica.datagen.data.worldgen.configuredfeature;

import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.level.block.TechnologicaBlocks;
import com.technologica.world.level.levelgen.feature.TechnologicaFeature;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

@SuppressWarnings("deprecation")
public class TechnologicaMiscOverworldFeatures {
	public static final ResourceKey<ConfiguredFeature<?, ?>> BRINE_POOL_CONFIGURED = ResourceKey.create(Registries.CONFIGURED_FEATURE, new TechnologicaLocation("brine_pool"));
	public static final ResourceKey<ConfiguredFeature<?, ?>> OASIS_CONFIGURED = ResourceKey.create(Registries.CONFIGURED_FEATURE, new TechnologicaLocation("oasis"));

	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> p_256346_) {
		FeatureUtils.register(p_256346_, BRINE_POOL_CONFIGURED, TechnologicaFeature.BRINE_POOL.get(), new LakeFeature.Configuration(BlockStateProvider.simple(TechnologicaBlocks.BRINE.get().defaultBlockState()), BlockStateProvider.simple(TechnologicaBlocks.LITHIUM_CLAY.get().defaultBlockState())));
		FeatureUtils.register(p_256346_, OASIS_CONFIGURED, TechnologicaFeature.OASIS.get(), new BlockStateConfiguration(Blocks.WATER.defaultBlockState()));
	}

}
