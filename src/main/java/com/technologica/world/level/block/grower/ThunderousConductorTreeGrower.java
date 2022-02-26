package com.technologica.world.level.block.grower;

import java.util.Random;

import com.technologica.data.worldgen.features.TechnologicaTreeFeatures;

import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class ThunderousConductorTreeGrower extends AbstractTreeGrower {
	protected ConfiguredFeature<?, ?> getConfiguredFeature(Random randomIn, boolean largeHiveIn) {
		return TechnologicaTreeFeatures.THUNDEROUS_CONDUCTOR;
	}
}
