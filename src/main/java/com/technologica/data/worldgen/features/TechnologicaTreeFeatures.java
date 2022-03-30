package com.technologica.data.worldgen.features;

import com.technologica.Technologica;
import com.technologica.world.level.block.TechnologicaBlocks;
import com.technologica.world.level.levelgen.feature.foliageplacers.ConicalFoliagePlacer;
import com.technologica.world.level.levelgen.feature.foliageplacers.CylindricalFoliagePlacer;
import com.technologica.world.level.levelgen.feature.foliageplacers.DishFoliagePlacer;
import com.technologica.world.level.levelgen.feature.foliageplacers.PalmFoliagePlacer;
import com.technologica.world.level.levelgen.feature.foliageplacers.RedwoodFoliagePlacer;
import com.technologica.world.level.levelgen.feature.foliageplacers.TeardropFoliagePlacer;

import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class TechnologicaTreeFeatures {
	
	public static Holder<ConfiguredFeature<?, ?>> APRICOT;
	public static Holder<ConfiguredFeature<?, ?>> ASPEN;
	public static Holder<ConfiguredFeature<?, ?>> AVOCADO;
	public static Holder<ConfiguredFeature<?, ?>> BANANA;
	public static Holder<ConfiguredFeature<?, ?>> CHERRY;	
	public static Holder<ConfiguredFeature<?, ?>> CHESTNUT;
	public static Holder<ConfiguredFeature<?, ?>> CINNAMON;
	public static Holder<ConfiguredFeature<?, ?>> COCONUT;
	public static Holder<ConfiguredFeature<?, ?>> EBONY;
	public static Holder<ConfiguredFeature<?, ?>> KIWI;
	public static Holder<ConfiguredFeature<?, ?>> LEMON;
	public static Holder<ConfiguredFeature<?, ?>> LIME;
	public static Holder<ConfiguredFeature<?, ?>> MAHOGANY;
	public static Holder<ConfiguredFeature<?, ?>> MAPLE;
	public static Holder<ConfiguredFeature<?, ?>> OLIVE;
	public static Holder<ConfiguredFeature<?, ?>> ORANGE;
	public static Holder<ConfiguredFeature<?, ?>> PEACH;
	public static Holder<ConfiguredFeature<?, ?>> PEAR;
	public static Holder<ConfiguredFeature<?, ?>> PLUM ;
	public static Holder<ConfiguredFeature<?, ?>> REDWOOD;
	public static Holder<ConfiguredFeature<?, ?>> ROSEWOOD;
	public static Holder<ConfiguredFeature<?, ?>> RUBBER;
	public static Holder<ConfiguredFeature<?, ?>> TEAK;
	public static Holder<ConfiguredFeature<?, ?>> WALNUT;
	public static Holder<ConfiguredFeature<?, ?>> ZEBRAWOOD;
	
	public static Holder<ConfiguredFeature<?, ?>> ANCIENT_AMBROSIA;
	public static Holder<ConfiguredFeature<?, ?>> BENEVOLENT_APOTHECARY;
	public static Holder<ConfiguredFeature<?, ?>> CRYOGENIC_SPIRE;
	public static Holder<ConfiguredFeature<?, ?>> MALEVOLENT_APOTHECARY;
	public static Holder<ConfiguredFeature<?, ?>> NECROTIC;
	public static Holder<ConfiguredFeature<?, ?>> SERENDIPITOUS_APOTHECARY;
	public static Holder<ConfiguredFeature<?, ?>> THUNDEROUS_CONDUCTOR;
	public static Holder<ConfiguredFeature<?, ?>> TOWERING_INFERNO;

	public static void register() {
		APRICOT = register("apricot", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.APRICOT_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.APRICOT_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build());
		ASPEN = register("aspen", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.ASPEN_LOG.get().defaultBlockState()), new StraightTrunkPlacer(6, 2, 0), BlockStateProvider.simple(TechnologicaBlocks.ASPEN_LEAVES.get().defaultBlockState()), new TeardropFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 6), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build());
		AVOCADO = register("avocado", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.AVOCADO_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.AVOCADO_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build());
		BANANA = register("banana", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.BANANA_LOG.get().defaultBlockState()), new StraightTrunkPlacer(5, 2, 0), BlockStateProvider.simple(TechnologicaBlocks.BANANA_LEAVES.get().defaultBlockState()), new PalmFoliagePlacer(ConstantInt.of(4), ConstantInt.of(1)), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build());
		CHERRY = register("cherry", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.CHERRY_LOG.get().defaultBlockState()), new StraightTrunkPlacer(5, 2, 0), BlockStateProvider.simple(TechnologicaBlocks.CHERRY_LEAVES.get().defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build());
		CHESTNUT = register("chestnut", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.CHESTNUT_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.CHESTNUT_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build());
		CINNAMON = register("cinnamon", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.CINNAMON_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.CINNAMON_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build());
		COCONUT = register("coconut", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.COCONUT_LOG.get().defaultBlockState()), new StraightTrunkPlacer(7, 5, 0), BlockStateProvider.simple(TechnologicaBlocks.COCONUT_LEAVES.get().defaultBlockState()), new PalmFoliagePlacer(ConstantInt.of(5), ConstantInt.of(1)), new TwoLayersFeatureSize(0, 0, 0))).ignoreVines().build());
		EBONY = register("ebony", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.EBONY_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.EBONY_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build());
		KIWI = register("kiwi", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.KIWI_LOG.get().defaultBlockState()), new StraightTrunkPlacer(3, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.KIWI_LEAVES.get().defaultBlockState()), new AcaciaFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build());
		LEMON = register("lemon", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.LEMON_LOG.get().defaultBlockState()), new StraightTrunkPlacer(2, 2, 0), BlockStateProvider.simple(TechnologicaBlocks.LEMON_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build());
		LIME = register("lime", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.LIME_LOG.get().defaultBlockState()), new StraightTrunkPlacer(2, 2, 0), BlockStateProvider.simple(TechnologicaBlocks.LIME_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build());
		MAHOGANY = register("mahogany", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.MAHOGANY_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.MAHOGANY_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build());
		MAPLE = register("maple", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.MAPLE_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.MAPLE_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build());
		OLIVE = register("olive", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.OLIVE_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.OLIVE_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build());
		ORANGE = register("orange", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.ORANGE_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.ORANGE_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build());
		PEACH = register("peach", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.PEACH_LOG.get().defaultBlockState()), new StraightTrunkPlacer(5, 2, 0), BlockStateProvider.simple(TechnologicaBlocks.PEACH_LEAVES.get().defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build());
		PEAR = register("pear", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.PEAR_LOG.get().defaultBlockState()), new StraightTrunkPlacer(5, 2, 0), BlockStateProvider.simple(TechnologicaBlocks.PEAR_LEAVES.get().defaultBlockState()), new TeardropFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 6), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build());
		PLUM = register("plum", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.PLUM_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.PLUM_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build());
		REDWOOD = register("redwood", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.REDWOOD_LOG.get().defaultBlockState()), new StraightTrunkPlacer(18, 5, 19), BlockStateProvider.simple(TechnologicaBlocks.REDWOOD_LEAVES.get().defaultBlockState()), new RedwoodFoliagePlacer(ConstantInt.of(4), ConstantInt.of(7)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build());
		ROSEWOOD = register("rosewood", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.ROSEWOOD_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.ROSEWOOD_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build());
		RUBBER = register("rubber", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.RUBBER_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.RUBBER_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build());
		TEAK = register("teak", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.TEAK_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.TEAK_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build());
		WALNUT = register("walnut", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.WALNUT_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.WALNUT_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build());
		ZEBRAWOOD = register("zebrawood", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.ZEBRAWOOD_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.ZEBRAWOOD_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build());
		
		ANCIENT_AMBROSIA = register("ancient_ambrosia", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.FRUITFUL_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.FRUITFUL_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(0, 0, 0))).ignoreVines().build());
		BENEVOLENT_APOTHECARY = register("benevolent_apothecary", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.BENEVOLENT_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.BENEVOLENT_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(0, 0, 0))).ignoreVines().build());
		CRYOGENIC_SPIRE = register("cryogenic_spire", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.FROSTBITTEN_LOG.get().defaultBlockState()), new StraightTrunkPlacer(10, 10, 0), BlockStateProvider.simple(TechnologicaBlocks.FROSTBITTEN_LEAVES.get().defaultBlockState()), new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(5), UniformInt.of(4, 13)), new TwoLayersFeatureSize(0, 0, 0))).ignoreVines().build());
		MALEVOLENT_APOTHECARY = register("malevolent_apothecary", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.MALEVOLENT_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.MALEVOLENT_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(0, 0, 0))).ignoreVines().build());
		NECROTIC = register("necrotic", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.NECROTIC_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.CURSED_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(0, 0, 0))).ignoreVines().build());
		SERENDIPITOUS_APOTHECARY = register("serendipitous_apothecary", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.ALCHEMICAL_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.ALCHEMICAL_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(0, 0, 0))).ignoreVines().build());
		THUNDEROUS_CONDUCTOR = register("thunderous_conductor", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.CONDUCTIVE_LOG.get().defaultBlockState()), new StraightTrunkPlacer(10, 10, 0), BlockStateProvider.simple(TechnologicaBlocks.CONDUCTIVE_LEAVES.get().defaultBlockState()), new DishFoliagePlacer(ConstantInt.of(9), ConstantInt.of(0), 3), new TwoLayersFeatureSize(0, 0, 0))).ignoreVines().build());
		TOWERING_INFERNO = register("towering_inferno", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.INFERNAL_LOG.get().defaultBlockState()), new StraightTrunkPlacer(10, 10, 0), BlockStateProvider.simple(Blocks.FIRE.defaultBlockState()), new CylindricalFoliagePlacer(ConstantInt.of(9), ConstantInt.of(0), 0), new TwoLayersFeatureSize(0, 0, 0))).ignoreVines().build());
	}
	
	public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<?, ?>> register(String stringIn, F featureIn, FC configurationIn) {
		return BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Technologica.MODID, stringIn), new ConfiguredFeature<>(featureIn, configurationIn));
	}
}