package com.technologica.world.gen.feature;

import com.google.common.collect.ImmutableList;
import com.technologica.block.TechnologicaBlocks;
import com.technologica.world.gen.foliageplacer.ConicalFoliagePlacer;
import com.technologica.world.gen.foliageplacer.CylindricalFoliagePlacer;
import com.technologica.world.gen.foliageplacer.DishFoliagePlacer;
import com.technologica.world.gen.foliageplacer.PalmFoliagePlacer;
import com.technologica.world.gen.foliageplacer.TeardropFoliagePlacer;
import com.technologica.world.gen.trunkplacer.ThreeWideTrunkPlacer;

import net.minecraft.block.BlockState;
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
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.MegaPineFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.GiantTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class TechnologicaConfiguredFeatures {
		
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> APRICOT_TREE_FEATURE = register(
			"apricot_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.APRICOT_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.APRICOT_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ASPEN_TREE_FEATURE = register(
			"aspen_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.ASPEN_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.ASPEN_LEAVES.get().getDefaultState()),
					new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
					new StraightTrunkPlacer(5, 2, 0), 
					new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> AVOCADO_TREE_FEATURE = register(
			"avocado_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.AVOCADO_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.AVOCADO_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BANANA_TREE_FEATURE = register(
			"banana_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.BANANA_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.BANANA_LEAVES.get().getDefaultState()),
					new PalmFoliagePlacer(FeatureSpread.create(4), FeatureSpread.create(1), 4),
					new StraightTrunkPlacer(5, 2, 0), 
					new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CHERRY_TREE_FEATURE = register(
			"cherry_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.CHERRY_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.CHERRY_LEAVES.get().getDefaultState()),
					new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
					new StraightTrunkPlacer(5, 2, 0), 
					new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CHESTNUT_TREE_FEATURE = register(
			"chestnut_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.CHESTNUT_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.CHESTNUT_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CINNAMON_TREE_FEATURE = register(
			"cinnamon_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.CINNAMON_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.CINNAMON_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> COCONUT_TREE_FEATURE = register(
			"coconut_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.COCONUT_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.COCONUT_LEAVES.get().getDefaultState()),
					new PalmFoliagePlacer(FeatureSpread.create(5), FeatureSpread.create(1), 5),
					new StraightTrunkPlacer(7, 5, 0), 
					new TwoLayerFeature(0, 0, 0))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> EBONY_TREE_FEATURE = register(
			"ebony_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.EBONY_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.EBONY_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> KIWI_TREE_FEATURE = register(
			"kiwi_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.KIWI_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.KIWI_LEAVES.get().getDefaultState()),
					new AcaciaFoliagePlacer(FeatureSpread.create(3), FeatureSpread.create(0)),
					new StraightTrunkPlacer(3, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> LEMON_TREE_FEATURE = register(
			"lemon_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.LEMON_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.LEMON_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(2, 2, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> LIME_TREE_FEATURE = register(
			"lime_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.LIME_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.LIME_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(2, 2, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MAHOGANY_TREE_FEATURE = register(
			"mahogany_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.MAHOGANY_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.MAHOGANY_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MAPLE_TREE_FEATURE = register(
			"maple_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.MAPLE_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.MAPLE_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> OLIVE_TREE_FEATURE = register(
			"olive_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.OLIVE_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.OLIVE_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ORANGE_TREE_FEATURE = register(
			"orange_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.ORANGE_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.ORANGE_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PEACH_TREE_FEATURE = register(
			"peach_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.PEACH_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.PEACH_LEAVES.get().getDefaultState()),
					new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
					new StraightTrunkPlacer(5, 2, 0),  
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PEAR_TREE_FEATURE = register(
			"pear_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.PEAR_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.PEAR_LEAVES.get().getDefaultState()),
					new TeardropFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 6),
					new StraightTrunkPlacer(5, 2, 0), 
					new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));

	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PLUM_TREE_FEATURE = register(
			"plum_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.PLUM_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.PLUM_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> REDWOOD_TREE_FEATURE = register(
			"redwood_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.REDWOOD_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(Blocks.AIR.getDefaultState()),
					new SpruceFoliagePlacer(FeatureSpread.create(2, 1), FeatureSpread.create(0, 2), FeatureSpread.create(1, 1)),
					new GiantTrunkPlacer(10, 5, 19), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ROSEWOOD_TREE_FEATURE = register(
			"rosewood_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.ROSEWOOD_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.ROSEWOOD_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> RUBBER_TREE_FEATURE = register(
			"rubber_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.RUBBER_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.RUBBER_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> TEAK_TREE_FEATURE = register(
			"teak_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.TEAK_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.TEAK_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> WALNUT_TREE_FEATURE = register(
			"walnut_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.WALNUT_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.WALNUT_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ZEBRAWOOD_TREE_FEATURE = register(
			"zebrawood_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.ZEBRAWOOD_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.ZEBRAWOOD_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> TOWERING_INFERNO_TREE_FEATURE = register(
			"towering_inferno_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.INFERNAL_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(Blocks.FIRE.getDefaultState()),
					new CylindricalFoliagePlacer(FeatureSpread.create(9), FeatureSpread.create(0), 0),
					new StraightTrunkPlacer(10, 10, 0), 
					new TwoLayerFeature(0, 0, 0))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> THUNDEROUS_CONDUCTOR_TREE_FEATURE = register(
			"thunderous_conductor_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.CONDUCTIVE_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.CONDUCTIVE_LEAVES.get().getDefaultState()),
					new DishFoliagePlacer(FeatureSpread.create(9), FeatureSpread.create(0), 3),
					new StraightTrunkPlacer(10, 10, 0), 
					new TwoLayerFeature(0, 0, 0))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CRYOGENIC_SPIRE_TREE_FEATURE = register(
			"cryogenic_spire_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.FROSTBITTEN_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.FROSTBITTEN_LEAVES.get().getDefaultState()),
					new MegaPineFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(5), FeatureSpread.create(13, 4)),
					new StraightTrunkPlacer(10, 10, 0), 
					new TwoLayerFeature(0, 0, 0))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ANCIENT_AMBROSIA_TREE_FEATURE = register(
			"ancient_ambrosia_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.FRUITFUL_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.FRUITFUL_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0),
					new TwoLayerFeature(0, 0, 0))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> SERENDIPITOUS_APOTHECARY_TREE_FEATURE = register(
			"serendipitous_apothecary_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.ALCHEMICAL_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.ALCHEMICAL_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0),
					new TwoLayerFeature(0, 0, 0))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BENEVOLENT_APOTHECARY_TREE_FEATURE = register(
			"benevolent_apothecary_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.BENEVOLENT_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.BENEVOLENT_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0),
					new TwoLayerFeature(0, 0, 0))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MALEVOLENT_APOTHECARY_TREE_FEATURE = register(
			"malevolent_apothecary_tree_feature",
			Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.MALEVOLENT_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.MALEVOLENT_LEAVES.get().getDefaultState()),
					new ConicalFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 2),
					new StraightTrunkPlacer(4, 1, 0),
					new TwoLayerFeature(0, 0, 0))).setIgnoreVines().build()));
	
	public static final ConfiguredFeature<?, ?> LAKE_BRINE_FEATURE = register("lake_brine_feature", TechnologicaFeatures.LAKE_BRINE.get().withConfiguration(new BlockStateFeatureConfig(States.BRINE_BLOCK)).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(4))));
	public static final ConfiguredFeature<?, ?> OASIS_FEATURE = register("oasis_feature", TechnologicaFeatures.OASIS.get().withConfiguration(new BlockStateFeatureConfig(Blocks.WATER.getDefaultState())).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(100))));
	public static final ConfiguredFeature<?, ?> CRATER_FEATURE = register("crater_feature", TechnologicaFeatures.CRATER.get().withConfiguration(new BlockStateFeatureConfig(Blocks.AIR.getDefaultState())).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	
	public static final ConfiguredFeature<?, ?> REDWOOD_FOREST_VEGETATION = register("redwood_forest_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(TechnologicaConfiguredFeatures.REDWOOD_TREE_FEATURE.withChance(1.0F)), TechnologicaConfiguredFeatures.REDWOOD_TREE_FEATURE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	public static final ConfiguredFeature<?, ?> RAINFOREST_VEGETATION = register("rainforest_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(TechnologicaConfiguredFeatures.ROSEWOOD_TREE_FEATURE.withChance(0.5F)), TechnologicaConfiguredFeatures.ROSEWOOD_TREE_FEATURE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	
	public static final class States {
		protected static final BlockState BRINE_BLOCK = TechnologicaBlocks.BRINE.get().getDefaultState();
	}
	
	private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
	}
}
