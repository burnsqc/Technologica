package com.technologica.world.level.block.grower;

import com.technologica.registration.key.TechnologicaConfiguredFeatures;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class ZebrawoodTreeGrower extends AbstractTreeGrower {
	@Override
	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean largeHiveIn) {
		return TechnologicaConfiguredFeatures.ZEBRAWOOD.key();
	}
}
