package com.technologica.world.gen.feature;

import com.technologica.setup.Registration;
import com.technologica.world.gen.foliageplacer.ConicalFoliagePlacer;
import com.technologica.world.gen.foliageplacer.CylindricalFoliagePlacer;
import com.technologica.world.gen.foliageplacer.PalmFoliagePlacer;
import com.technologica.world.gen.foliageplacer.TeardropFoliagePlacer;

import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class ModFeatures extends Features {
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BANANA_TREE_FEATURE = register(
			"banana_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(Registration.BANANA_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(Registration.BANANA_LEAVES.get().getDefaultState()),
					new PalmFoliagePlacer(FeatureSpread.func_242252_a(4), FeatureSpread.func_242252_a(1), 4),
					new StraightTrunkPlacer(5, 2, 0), 
					new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CHERRY_TREE_FEATURE = register(
			"cherry_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(Registration.CHERRY_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(Registration.CHERRY_LEAVES.get().getDefaultState()),
					new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3),
					new StraightTrunkPlacer(5, 2, 0), 
					new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> COCONUT_TREE_FEATURE = register(
			"coconut_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(Registration.COCONUT_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(Registration.COCONUT_LEAVES.get().getDefaultState()),
					new PalmFoliagePlacer(FeatureSpread.func_242252_a(5), FeatureSpread.func_242252_a(1), 5),
					new StraightTrunkPlacer(7, 5, 0), 
					new TwoLayerFeature(0, 0, 0))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> KIWI_TREE_FEATURE = register(
			"kiwi_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(Registration.KIWI_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(Registration.KIWI_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.func_242252_a(0), FeatureSpread.func_242252_a(0), 2),
					new StraightTrunkPlacer(2, 2, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> LEMON_TREE_FEATURE = register(
			"lemon_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(Registration.LEMON_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(Registration.LEMON_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.func_242252_a(0), FeatureSpread.func_242252_a(0), 2),
					new StraightTrunkPlacer(2, 2, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> LIME_TREE_FEATURE = register(
			"lime_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(Registration.LIME_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(Registration.LIME_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.func_242252_a(0), FeatureSpread.func_242252_a(0), 2),
					new StraightTrunkPlacer(2, 2, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ORANGE_TREE_FEATURE = register(
			"orange_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(Registration.ORANGE_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(Registration.ORANGE_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.func_242252_a(0), FeatureSpread.func_242252_a(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PEACH_TREE_FEATURE = register(
			"peach_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(Registration.PEACH_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(Registration.PEACH_LEAVES.get().getDefaultState()),
					new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3),
					new StraightTrunkPlacer(5, 2, 0),  
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PEAR_TREE_FEATURE = register(
			"pear_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(Registration.PEAR_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(Registration.PEAR_LEAVES.get().getDefaultState()),
					new TeardropFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 6),
					new StraightTrunkPlacer(5, 2, 0), 
					new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));

	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> TOWERING_INFERNO_TREE_FEATURE = register(
			"towering_inferno_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(Blocks.COAL_BLOCK.getDefaultState()),
					new SimpleBlockStateProvider(Blocks.FIRE.getDefaultState()),
					new CylindricalFoliagePlacer(FeatureSpread.func_242252_a(9), FeatureSpread.func_242252_a(0), 0),
					new StraightTrunkPlacer(10, 10, 0), 
					new TwoLayerFeature(0, 0, 0))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<?, ?> OASIS_FEATURE = register(
			"oasis_feature", 
			Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(
					Blocks.WATER.getDefaultState()))
			.withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(4))));
	
	private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
	}
}