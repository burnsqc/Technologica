package com.technologica.block.trees;

import java.util.Random;

import javax.annotation.Nullable;

import com.technologica.world.gen.feature.ModConfiguredFeatures;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class SerendipitousApothecaryTree extends Tree {
	@Nullable
	protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean largeHive) {
		new ModConfiguredFeatures();
		return ModConfiguredFeatures.SERENDIPITOUS_APOTHECARY_TREE_FEATURE;
	}
}