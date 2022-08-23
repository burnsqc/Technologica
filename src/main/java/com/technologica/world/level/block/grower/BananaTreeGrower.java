package com.technologica.world.level.block.grower;

import com.technologica.data.worldgen.features.TechnologicaTreeFeatures;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class BananaTreeGrower extends AbstractTreeGrower {
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean largeHiveIn) {
		return TechnologicaTreeFeatures.BANANA;
	}
}
