package com.technologica.block.trees;

import java.util.Random;

import javax.annotation.Nullable;

import com.technologica.world.gen.feature.TechnologicaConfiguredFeatures;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class MalevolentApothecaryTree extends Tree {
	@Nullable
	protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean largeHiveIn) {
		return TechnologicaConfiguredFeatures.MALEVOLENT_APOTHECARY_TREE_FEATURE;
	}
}
