package com.technologica.block.trees;

import java.util.Random;

import javax.annotation.Nullable;

import com.technologica.world.gen.feature.ModFeatures;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class AncientAmbrosiaTree extends Tree {
	@Nullable
	protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean largeHive) {
		new ModFeatures();
		return ModFeatures.ANCIENT_AMBROSIA_TREE_FEATURE;
	}
}