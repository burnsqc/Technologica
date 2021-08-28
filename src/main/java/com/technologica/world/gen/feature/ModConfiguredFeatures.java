package com.technologica.world.gen.feature;

import com.technologica.block.ModBlocks;
import com.technologica.world.gen.foliageplacer.ConicalFoliagePlacer;
import com.technologica.world.gen.foliageplacer.CylindricalFoliagePlacer;
import com.technologica.world.gen.foliageplacer.DishFoliagePlacer;
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
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.MegaPineFoliagePlacer;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class ModConfiguredFeatures {
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> APRICOT_TREE_FEATURE = register(
			"apricot_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.APRICOT_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.APRICOT_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ASPEN_TREE_FEATURE = register(
			"aspen_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.ASPEN_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.ASPEN_LEAVES.get().getDefaultState()),
					new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
					new StraightTrunkPlacer(5, 2, 0), 
					new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> AVOCADO_TREE_FEATURE = register(
			"avacado_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.AVOCADO_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.AVOCADO_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BANANA_TREE_FEATURE = register(
			"banana_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.BANANA_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.BANANA_LEAVES.get().getDefaultState()),
					new PalmFoliagePlacer(FeatureSpread.create(4), FeatureSpread.create(1), 4),
					new StraightTrunkPlacer(5, 2, 0), 
					new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CHERRY_TREE_FEATURE = register(
			"cherry_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.CHERRY_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.CHERRY_LEAVES.get().getDefaultState()),
					new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
					new StraightTrunkPlacer(5, 2, 0), 
					new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CHESTNUT_TREE_FEATURE = register(
			"chestnut_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.CHESTNUT_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.CHESTNUT_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> COCONUT_TREE_FEATURE = register(
			"coconut_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.COCONUT_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.COCONUT_LEAVES.get().getDefaultState()),
					new PalmFoliagePlacer(FeatureSpread.create(5), FeatureSpread.create(1), 5),
					new StraightTrunkPlacer(7, 5, 0), 
					new TwoLayerFeature(0, 0, 0))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> EBONY_TREE_FEATURE = register(
			"ebony_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.EBONY_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.EBONY_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> KIWI_TREE_FEATURE = register(
			"kiwi_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.KIWI_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.KIWI_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(2, 2, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> LEMON_TREE_FEATURE = register(
			"lemon_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.LEMON_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.LEMON_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(2, 2, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> LIME_TREE_FEATURE = register(
			"lime_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.LIME_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.LIME_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(2, 2, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MAHOGANY_TREE_FEATURE = register(
			"mahogany_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.MAHOGANY_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.MAHOGANY_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MAPLE_TREE_FEATURE = register(
			"maple_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.MAPLE_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.MAPLE_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ORANGE_TREE_FEATURE = register(
			"orange_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.ORANGE_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.ORANGE_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PEACH_TREE_FEATURE = register(
			"peach_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.PEACH_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.PEACH_LEAVES.get().getDefaultState()),
					new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
					new StraightTrunkPlacer(5, 2, 0),  
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PEAR_TREE_FEATURE = register(
			"pear_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.PEAR_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.PEAR_LEAVES.get().getDefaultState()),
					new TeardropFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 6),
					new StraightTrunkPlacer(5, 2, 0), 
					new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));

	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PLUM_TREE_FEATURE = register(
			"plum_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.PLUM_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.PLUM_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> REDWOOD_TREE_FEATURE = register(
			"redwood_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.REDWOOD_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.REDWOOD_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ROSEWOOD_TREE_FEATURE = register(
			"rosewood_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.ROSEWOOD_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.ROSEWOOD_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> RUBBER_TREE_FEATURE = register(
			"rubber_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.RUBBER_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.RUBBER_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> TEAK_TREE_FEATURE = register(
			"teak_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.TEAK_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.TEAK_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> WALNUT_TREE_FEATURE = register(
			"walnut_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.WALNUT_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.WALNUT_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ZEBRAWOOD_TREE_FEATURE = register(
			"zebrawood_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.ZEBRAWOOD_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.ZEBRAWOOD_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> TOWERING_INFERNO_TREE_FEATURE = register(
			"towering_inferno_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.INFERNAL_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(Blocks.FIRE.getDefaultState()),
					new CylindricalFoliagePlacer(FeatureSpread.create(9), FeatureSpread.create(0), 0),
					new StraightTrunkPlacer(10, 10, 0), 
					new TwoLayerFeature(0, 0, 0))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> THUNDEROUS_CONDUCTOR_TREE_FEATURE = register(
			"thunderous_conductor_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.CONDUCTIVE_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.CONDUCTIVE_LEAVES.get().getDefaultState()),
					new DishFoliagePlacer(FeatureSpread.create(9), FeatureSpread.create(0), 3),
					new StraightTrunkPlacer(10, 10, 0), 
					new TwoLayerFeature(0, 0, 0))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CRYOGENIC_SPIRE_TREE_FEATURE = register(
			"cryogenic_spire_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.FROSTBITTEN_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.FROSTBITTEN_LEAVES.get().getDefaultState()),
					new MegaPineFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(5), FeatureSpread.create(13, 4)),
					new StraightTrunkPlacer(10, 10, 0), 
					new TwoLayerFeature(0, 0, 0))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ANCIENT_AMBROSIA_TREE_FEATURE = register(
			"ancient_ambrosia_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.FRUITFUL_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.FRUITFUL_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0),
					new TwoLayerFeature(0, 0, 0))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> SERENDIPITOUS_APOTHECARY_TREE_FEATURE = register(
			"serendipitous_apothecary_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.ALCHEMICAL_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.ALCHEMICAL_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0),
					new TwoLayerFeature(0, 0, 0))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BENEVOLENT_APOTHECARY_TREE_FEATURE = register(
			"benevolent_apothecary_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.BENEVOLENT_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.BENEVOLENT_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0),
					new TwoLayerFeature(0, 0, 0))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MALEVOLENT_APOTHECARY_TREE_FEATURE = register(
			"malevolent_apothecary_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.MALEVOLENT_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.MALEVOLENT_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0),
					new TwoLayerFeature(0, 0, 0))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<?, ?> OASIS_FEATURE = register("oasis_feature", ModFeatures.OASIS.get().withConfiguration(new BlockStateFeatureConfig(Blocks.WATER.getDefaultState())).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(100))));
	
	private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
	}
}
