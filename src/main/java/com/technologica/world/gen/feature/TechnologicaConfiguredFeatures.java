package com.technologica.world.gen.feature;

import com.google.common.collect.ImmutableList;
import com.technologica.block.TechnologicaBlocks;
import com.technologica.world.gen.foliageplacer.ConicalFoliagePlacer;
import com.technologica.world.gen.foliageplacer.CylindricalFoliagePlacer;
import com.technologica.world.gen.foliageplacer.DishFoliagePlacer;
import com.technologica.world.gen.foliageplacer.PalmFoliagePlacer;
import com.technologica.world.gen.foliageplacer.RedwoodFoliagePlacer;
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
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class TechnologicaConfiguredFeatures {
		
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> APRICOT_TREE_FEATURE = register(
			"apricot_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.APRICOT_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.APRICOT_LEAVES.get().defaultBlockState()),
					new ConicalFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ASPEN_TREE_FEATURE = register(
			"aspen_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.ASPEN_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.ASPEN_LEAVES.get().defaultBlockState()),
					new TeardropFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 6),
					new StraightTrunkPlacer(6, 2, 0), 
					new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> AVOCADO_TREE_FEATURE = register(
			"avocado_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.AVOCADO_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.AVOCADO_LEAVES.get().defaultBlockState()),
					new ConicalFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BANANA_TREE_FEATURE = register(
			"banana_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.BANANA_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.BANANA_LEAVES.get().defaultBlockState()),
					new PalmFoliagePlacer(FeatureSpread.fixed(4), FeatureSpread.fixed(1)),
					new StraightTrunkPlacer(5, 2, 0), 
					new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CHERRY_TREE_FEATURE = register(
			"cherry_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.CHERRY_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.CHERRY_LEAVES.get().defaultBlockState()),
					new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
					new StraightTrunkPlacer(5, 2, 0), 
					new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CHESTNUT_TREE_FEATURE = register(
			"chestnut_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.CHESTNUT_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.CHESTNUT_LEAVES.get().defaultBlockState()),
					new ConicalFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CINNAMON_TREE_FEATURE = register(
			"cinnamon_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.CINNAMON_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.CINNAMON_LEAVES.get().defaultBlockState()),
					new ConicalFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> COCONUT_TREE_FEATURE = register(
			"coconut_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.COCONUT_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.COCONUT_LEAVES.get().defaultBlockState()),
					new PalmFoliagePlacer(FeatureSpread.fixed(5), FeatureSpread.fixed(1)),
					new StraightTrunkPlacer(7, 5, 0), 
					new TwoLayerFeature(0, 0, 0))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> EBONY_TREE_FEATURE = register(
			"ebony_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.EBONY_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.EBONY_LEAVES.get().defaultBlockState()),
					new ConicalFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> KIWI_TREE_FEATURE = register(
			"kiwi_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.KIWI_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.KIWI_LEAVES.get().defaultBlockState()),
					new AcaciaFoliagePlacer(FeatureSpread.fixed(3), FeatureSpread.fixed(0)),
					new StraightTrunkPlacer(3, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> LEMON_TREE_FEATURE = register(
			"lemon_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.LEMON_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.LEMON_LEAVES.get().defaultBlockState()),
					new ConicalFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
					new StraightTrunkPlacer(2, 2, 0), 
					new TwoLayerFeature(1, 0, 2))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> LIME_TREE_FEATURE = register(
			"lime_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.LIME_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.LIME_LEAVES.get().defaultBlockState()),
					new ConicalFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
					new StraightTrunkPlacer(2, 2, 0), 
					new TwoLayerFeature(1, 0, 2))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MAHOGANY_TREE_FEATURE = register(
			"mahogany_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.MAHOGANY_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.MAHOGANY_LEAVES.get().defaultBlockState()),
					new ConicalFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MAPLE_TREE_FEATURE = register(
			"maple_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.MAPLE_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.MAPLE_LEAVES.get().defaultBlockState()),
					new ConicalFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> OLIVE_TREE_FEATURE = register(
			"olive_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.OLIVE_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.OLIVE_LEAVES.get().defaultBlockState()),
					new ConicalFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ORANGE_TREE_FEATURE = register(
			"orange_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.ORANGE_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.ORANGE_LEAVES.get().defaultBlockState()),
					new ConicalFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PEACH_TREE_FEATURE = register(
			"peach_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.PEACH_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.PEACH_LEAVES.get().defaultBlockState()),
					new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
					new StraightTrunkPlacer(5, 2, 0),  
					new TwoLayerFeature(1, 0, 2))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PEAR_TREE_FEATURE = register(
			"pear_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.PEAR_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.PEAR_LEAVES.get().defaultBlockState()),
					new TeardropFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 6),
					new StraightTrunkPlacer(5, 2, 0), 
					new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));

	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PLUM_TREE_FEATURE = register(
			"plum_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.PLUM_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.PLUM_LEAVES.get().defaultBlockState()),
					new ConicalFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> REDWOOD_TREE_FEATURE = register(
			"redwood_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.REDWOOD_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.REDWOOD_LEAVES.get().defaultBlockState()),
					new RedwoodFoliagePlacer(FeatureSpread.fixed(4), FeatureSpread.fixed(7)),
					new ThreeWideTrunkPlacer(18, 5, 19), 
					new TwoLayerFeature(1, 0, 2))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ROSEWOOD_TREE_FEATURE = register(
			"rosewood_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.ROSEWOOD_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.ROSEWOOD_LEAVES.get().defaultBlockState()),
					new ConicalFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> RUBBER_TREE_FEATURE = register(
			"rubber_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.RUBBER_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.RUBBER_LEAVES.get().defaultBlockState()),
					new ConicalFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> TEAK_TREE_FEATURE = register(
			"teak_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.TEAK_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.TEAK_LEAVES.get().defaultBlockState()),
					new ConicalFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> WALNUT_TREE_FEATURE = register(
			"walnut_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.WALNUT_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.WALNUT_LEAVES.get().defaultBlockState()),
					new ConicalFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ZEBRAWOOD_TREE_FEATURE = register(
			"zebrawood_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.ZEBRAWOOD_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.ZEBRAWOOD_LEAVES.get().defaultBlockState()),
					new ConicalFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
					new StraightTrunkPlacer(4, 1, 0), 
					new TwoLayerFeature(1, 0, 2))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> TOWERING_INFERNO_TREE_FEATURE = register(
			"towering_inferno_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.INFERNAL_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(Blocks.FIRE.defaultBlockState()),
					new CylindricalFoliagePlacer(FeatureSpread.fixed(9), FeatureSpread.fixed(0), 0),
					new StraightTrunkPlacer(10, 10, 0), 
					new TwoLayerFeature(0, 0, 0))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> THUNDEROUS_CONDUCTOR_TREE_FEATURE = register(
			"thunderous_conductor_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.CONDUCTIVE_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.CONDUCTIVE_LEAVES.get().defaultBlockState()),
					new DishFoliagePlacer(FeatureSpread.fixed(9), FeatureSpread.fixed(0), 3),
					new StraightTrunkPlacer(10, 10, 0), 
					new TwoLayerFeature(0, 0, 0))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CRYOGENIC_SPIRE_TREE_FEATURE = register(
			"cryogenic_spire_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.FROSTBITTEN_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.FROSTBITTEN_LEAVES.get().defaultBlockState()),
					new MegaPineFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(5), FeatureSpread.of(13, 4)),
					new StraightTrunkPlacer(10, 10, 0), 
					new TwoLayerFeature(0, 0, 0))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ANCIENT_AMBROSIA_TREE_FEATURE = register(
			"ancient_ambrosia_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.FRUITFUL_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.FRUITFUL_LEAVES.get().defaultBlockState()),
					new ConicalFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
					new StraightTrunkPlacer(4, 1, 0),
					new TwoLayerFeature(0, 0, 0))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> SERENDIPITOUS_APOTHECARY_TREE_FEATURE = register(
			"serendipitous_apothecary_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.ALCHEMICAL_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.ALCHEMICAL_LEAVES.get().defaultBlockState()),
					new ConicalFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
					new StraightTrunkPlacer(4, 1, 0),
					new TwoLayerFeature(0, 0, 0))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BENEVOLENT_APOTHECARY_TREE_FEATURE = register(
			"benevolent_apothecary_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.BENEVOLENT_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.BENEVOLENT_LEAVES.get().defaultBlockState()),
					new ConicalFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
					new StraightTrunkPlacer(4, 1, 0),
					new TwoLayerFeature(0, 0, 0))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MALEVOLENT_APOTHECARY_TREE_FEATURE = register(
			"malevolent_apothecary_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.MALEVOLENT_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.MALEVOLENT_LEAVES.get().defaultBlockState()),
					new ConicalFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
					new StraightTrunkPlacer(4, 1, 0),
					new TwoLayerFeature(0, 0, 0))).ignoreVines().build()));
	
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> NECROTIC_TREE_FEATURE = register(
			"necrotic_tree_feature",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(TechnologicaBlocks.NECROTIC_LOG.get().defaultBlockState()),
					new SimpleBlockStateProvider(TechnologicaBlocks.CURSED_LEAVES.get().defaultBlockState()),
					new ConicalFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
					new StraightTrunkPlacer(4, 1, 0),
					new TwoLayerFeature(0, 0, 0))).ignoreVines().build()));
	
	public static final ConfiguredFeature<?, ?> LAKE_BRINE_FEATURE = register("lake_brine_feature", TechnologicaFeatures.LAKE_BRINE.get().configured(new BlockStateFeatureConfig(States.BRINE_BLOCK)).decorated(Placement.WATER_LAKE.configured(new ChanceConfig(4))));
	public static final ConfiguredFeature<?, ?> OASIS_FEATURE = register("oasis_feature", TechnologicaFeatures.OASIS.get().configured(new BlockStateFeatureConfig(Blocks.WATER.defaultBlockState())).decorated(Placement.WATER_LAKE.configured(new ChanceConfig(100))));
	public static final ConfiguredFeature<?, ?> CRATER_FEATURE = register("crater_feature", TechnologicaFeatures.CRATER.get().configured(new BlockStateFeatureConfig(Blocks.AIR.defaultBlockState())).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	
	public static final ConfiguredFeature<?, ?> REDWOOD_FOREST_VEGETATION = register("redwood_forest_vegetation", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(TechnologicaConfiguredFeatures.REDWOOD_TREE_FEATURE.weighted(1.0F)), TechnologicaConfiguredFeatures.REDWOOD_TREE_FEATURE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	public static final ConfiguredFeature<?, ?> RAINFOREST_VEGETATION = register("rainforest_vegetation", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(TechnologicaConfiguredFeatures.ROSEWOOD_TREE_FEATURE.weighted(0.5F)), TechnologicaConfiguredFeatures.ROSEWOOD_TREE_FEATURE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	
	public static final class States {
		protected static final BlockState BRINE_BLOCK = TechnologicaBlocks.BRINE.get().defaultBlockState();
	}
	
	private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
	}
}
