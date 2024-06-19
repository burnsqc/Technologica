package com.technologica.resourcegen.data.worldgen.configuredfeature;

import java.util.List;

import com.technologica.api.tlregen.resourcegen.data.worldgen.TLReGenWorldgenConfiguredFeature;
import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.registration.deferred.TechnologicaFeatures;
import com.technologica.registration.key.TechnologicaConfiguredFeatures;
import com.technologica.registration.key.TechnologicaPlacedFeatures;
import com.technologica.world.level.levelgen.feature.foliageplacers.ConicalFoliagePlacer;
import com.technologica.world.level.levelgen.feature.foliageplacers.DishFoliagePlacer;
import com.technologica.world.level.levelgen.feature.foliageplacers.PalmFoliagePlacer;
import com.technologica.world.level.levelgen.feature.foliageplacers.RedwoodFoliagePlacer;
import com.technologica.world.level.levelgen.feature.foliageplacers.TeardropFoliagePlacer;
import com.technologica.world.level.levelgen.feature.trunkplacers.HugeTrunkPlacer;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ColumnFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ReplaceSphereConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

@SuppressWarnings("deprecation")
public class TLWorldgenConfiguredFeatures extends TLReGenWorldgenConfiguredFeature {

	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> configuredFeature) {
		RuleTest ruletest1 = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
		RuleTest ruletest2 = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

		List<OreConfiguration.TargetBlockState> ORE_SPODUMENE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.SPODUMENE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_SPODUMENE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_BORAX_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.BORAX_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_BORAX_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_MAGNESITE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.MAGNESITE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_MAGNESITE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_BAUXITE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.BAUXITE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_BAUXITE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_APATITE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.APATITE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_APATITE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_PHOSPHORITE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.PHOSPHORITE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_PHOSPHORITE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_GADOLINITE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.GADOLINITE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_GADOLINITE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_ILMENITE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.ILMENITE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_ILMENITE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_PATRONITE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.PATRONITE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_PATRONITE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_CHROMITE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.CHROMITE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_CHROMITE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_PYROLUSITE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.PYROLUSITE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_PYROLUSITE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_COBALTITE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.COBALTITE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_COBALTITE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_GARNIERITE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.GARNIERITE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_GARNIERITE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_ARSENOPYRITE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.ARSENOPYRITE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_ARSENOPYRITE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_CROOKESITE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.CROOKESITE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_CROOKESITE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_LEPIDOLITE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.LEPIDOLITE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_LEPIDOLITE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_BASTNAESITE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.BASTNAESITE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_BASTNAESITE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_TANTALITE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.TANTALITE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_TANTALITE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_MOLYBDENITE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.MOLYBDENITE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_MOLYBDENITE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_PENTLANDITE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.PENTLANDITE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_PENTLANDITE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_ARGENTITE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.ARGENTITE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_ARGENTITE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_GALENA_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.GALENA_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_GALENA_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_SYLVANITE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.SYLVANITE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_SYLVANITE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_CASSITERITE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.CASSITERITE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_CASSITERITE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_WOLFRAMITE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.WOLFRAMITE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_WOLFRAMITE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_OSMIRIDIUM_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.OSMIRIDIUM_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_OSMIRIDIUM_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_PLATINUM_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.PLATINUM_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_PLATINUM_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_CINNABAR_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.CINNABAR_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_CINNABAR_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_THORIANITE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.THORIANITE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_THORIANITE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_URANINITE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.URANINITE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_URANINITE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_EMERALD_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, Blocks.EMERALD_ORE.defaultBlockState()), OreConfiguration.target(ruletest2, Blocks.DEEPSLATE_EMERALD_ORE.defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_RUBY_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.RUBY_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_SAPPHIRE_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.SAPPHIRE_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState()));
		List<OreConfiguration.TargetBlockState> ORE_TOPAZ_TARGET_LIST = List.of(OreConfiguration.target(ruletest1, TechnologicaBlocks.TOPAZ_ORE.get().defaultBlockState()), OreConfiguration.target(ruletest2, TechnologicaBlocks.DEEPSLATE_TOPAZ_ORE.get().defaultBlockState()));

		HolderGetter<PlacedFeature> placedFeatures = configuredFeature.lookup(Registries.PLACED_FEATURE);
		Holder<PlacedFeature> holder = placedFeatures.getOrThrow(TechnologicaPlacedFeatures.ZEBRAWOOD_CHECKED);
		Holder<PlacedFeature> holder1 = placedFeatures.getOrThrow(TechnologicaPlacedFeatures.EBONY_CHECKED);
		Holder<PlacedFeature> holder2 = placedFeatures.getOrThrow(TechnologicaPlacedFeatures.KIWI_CHECKED);
		Holder<PlacedFeature> holder3 = placedFeatures.getOrThrow(TechnologicaPlacedFeatures.RUBBER_CHECKED);
		Holder<PlacedFeature> holder4 = placedFeatures.getOrThrow(TechnologicaPlacedFeatures.TEAK_CHECKED);
		Holder<PlacedFeature> holder5 = placedFeatures.getOrThrow(TechnologicaPlacedFeatures.CHERRY_CHECKED);
		Holder<PlacedFeature> holder6 = placedFeatures.getOrThrow(TechnologicaPlacedFeatures.PLUM_CHECKED);
		Holder<PlacedFeature> holder7 = placedFeatures.getOrThrow(TechnologicaPlacedFeatures.CHESTNUT_CHECKED);
		Holder<PlacedFeature> holder8 = placedFeatures.getOrThrow(TechnologicaPlacedFeatures.PEACH_CHECKED);
		Holder<PlacedFeature> holder9 = placedFeatures.getOrThrow(TechnologicaPlacedFeatures.ASPEN_CHECKED);
		Holder<PlacedFeature> holder10 = placedFeatures.getOrThrow(TechnologicaPlacedFeatures.COCONUT_CHECKED);
		Holder<PlacedFeature> holder11 = placedFeatures.getOrThrow(TechnologicaPlacedFeatures.APRICOT_CHECKED);
		Holder<PlacedFeature> holder12 = placedFeatures.getOrThrow(TechnologicaPlacedFeatures.PEAR_CHECKED);
		Holder<PlacedFeature> holder13 = placedFeatures.getOrThrow(TechnologicaPlacedFeatures.MAPLE_CHECKED);
		Holder<PlacedFeature> holder14 = placedFeatures.getOrThrow(TechnologicaPlacedFeatures.WALNUT_CHECKED);
		Holder<PlacedFeature> holder15 = placedFeatures.getOrThrow(TechnologicaPlacedFeatures.ORANGE_CHECKED);

		/*
		 * MISC
		 */

		configuredFeature.register(TechnologicaConfiguredFeatures.BRINE_POOL_CONFIGURED, new ConfiguredFeature<>(TechnologicaFeatures.BRINE_POOL.get(), new LakeFeature.Configuration(BlockStateProvider.simple(TechnologicaBlocks.BRINE.get().defaultBlockState()), BlockStateProvider.simple(TechnologicaBlocks.LITHIUM_CLAY.get().defaultBlockState()))));
		configuredFeature.register(TechnologicaConfiguredFeatures.NATURAL_GAS_DEPOSIT_CONFIGURED, new ConfiguredFeature<>(TechnologicaFeatures.NATURAL_GAS_DEPOSIT.get(), new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(TechnologicaBlocks.NATURAL_GAS.get()), BlockStateProvider.simple(TechnologicaBlocks.NATURAL_GAS.get()), BlockStateProvider.simple(TechnologicaBlocks.NATURAL_GAS.get()), BlockStateProvider.simple(TechnologicaBlocks.NATURAL_GAS.get()), BlockStateProvider.simple(TechnologicaBlocks.NATURAL_GAS.get()), List.of(Blocks.SMALL_AMETHYST_BUD.defaultBlockState(), Blocks.MEDIUM_AMETHYST_BUD.defaultBlockState(), Blocks.LARGE_AMETHYST_BUD.defaultBlockState(), Blocks.AMETHYST_CLUSTER.defaultBlockState()), BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS), new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D), new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true, UniformInt.of(4, 6), UniformInt.of(3, 4), UniformInt.of(1, 2), -16, 16, 0.05D, 1)));
		configuredFeature.register(TechnologicaConfiguredFeatures.OASIS_CONFIGURED, new ConfiguredFeature<>(TechnologicaFeatures.OASIS.get(), new BlockStateConfiguration(Blocks.WATER.defaultBlockState())));
		configuredFeature.register(TechnologicaConfiguredFeatures.OIL_WELL_CONFIGURED, new ConfiguredFeature<>(TechnologicaFeatures.OIL_WELL.get(), new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(TechnologicaBlocks.OIL.get()), BlockStateProvider.simple(TechnologicaBlocks.OIL.get()), BlockStateProvider.simple(TechnologicaBlocks.OIL.get()), BlockStateProvider.simple(TechnologicaBlocks.OIL.get()), BlockStateProvider.simple(TechnologicaBlocks.OIL.get()), List.of(Blocks.SMALL_AMETHYST_BUD.defaultBlockState(), Blocks.MEDIUM_AMETHYST_BUD.defaultBlockState(), Blocks.LARGE_AMETHYST_BUD.defaultBlockState(), Blocks.AMETHYST_CLUSTER.defaultBlockState()), BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS), new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D), new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true, UniformInt.of(4, 6), UniformInt.of(3, 4), UniformInt.of(1, 2), -16, 16, 0.05D, 1)));
		configuredFeature.register(TechnologicaConfiguredFeatures.NAVAL_MINE, new ConfiguredFeature<>(TechnologicaFeatures.NAVAL_MINE.get(), new NoneFeatureConfiguration()));

		/*
		 * ORE
		 */

		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_SPODUMENE, new ConfiguredFeature<>(TechnologicaFeatures.POLLUCITE_DECORATED_ORE.get(), new OreConfiguration(ORE_SPODUMENE_TARGET_LIST, 8)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_BORAX, new ConfiguredFeature<>(TechnologicaFeatures.ULEXITE_DECORATED_ORE.get(), new OreConfiguration(ORE_BORAX_TARGET_LIST, 8)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_MAGNESITE, new ConfiguredFeature<>(TechnologicaFeatures.DOLOMITE_DECORATED_ORE.get(), new OreConfiguration(ORE_MAGNESITE_TARGET_LIST, 8)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_BAUXITE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_BAUXITE_TARGET_LIST, 8)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_APATITE, new ConfiguredFeature<>(TechnologicaFeatures.FLUORITE_DECORATED_ORE.get(), new OreConfiguration(ORE_APATITE_TARGET_LIST, 8)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_PHOSPHORITE, new ConfiguredFeature<>(TechnologicaFeatures.CELESTINE_DECORATED_ORE.get(), new OreConfiguration(ORE_PHOSPHORITE_TARGET_LIST, 8)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_GADOLINITE, new ConfiguredFeature<>(TechnologicaFeatures.XENOTIME_DECORATED_ORE.get(), new OreConfiguration(ORE_GADOLINITE_TARGET_LIST, 4)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_ILMENITE, new ConfiguredFeature<>(TechnologicaFeatures.RUTILE_DECORATED_ORE.get(), new OreConfiguration(ORE_ILMENITE_TARGET_LIST, 8)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_PATRONITE, new ConfiguredFeature<>(TechnologicaFeatures.VANADANITE_DECORATED_ORE.get(), new OreConfiguration(ORE_PATRONITE_TARGET_LIST, 8)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_CHROMITE, new ConfiguredFeature<>(TechnologicaFeatures.ZIRCON_DECORATED_ORE.get(), new OreConfiguration(ORE_CHROMITE_TARGET_LIST, 8)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_PYROLUSITE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_PYROLUSITE_TARGET_LIST, 8)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_COBALTITE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_COBALTITE_TARGET_LIST, 8)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_GARNIERITE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_GARNIERITE_TARGET_LIST, 8)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_ARSENOPYRITE, new ConfiguredFeature<>(TechnologicaFeatures.SPHALERITE_DECORATED_ORE.get(), new OreConfiguration(ORE_ARSENOPYRITE_TARGET_LIST, 8)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_CROOKESITE, new ConfiguredFeature<>(TechnologicaFeatures.HUTCHINSONITE_DECORATED_ORE.get(), new OreConfiguration(ORE_CROOKESITE_TARGET_LIST, 8)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_LEPIDOLITE, new ConfiguredFeature<>(TechnologicaFeatures.STRONTIANITE_DECORATED_ORE.get(), new OreConfiguration(ORE_LEPIDOLITE_TARGET_LIST, 8)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_BASTNAESITE, new ConfiguredFeature<>(TechnologicaFeatures.MONAZITE_DECORATED_ORE.get(), new OreConfiguration(ORE_BASTNAESITE_TARGET_LIST, 4)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_TANTALITE, new ConfiguredFeature<>(TechnologicaFeatures.COLUMBITE_DECORATED_ORE.get(), new OreConfiguration(ORE_TANTALITE_TARGET_LIST, 4)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_MOLYBDENITE, new ConfiguredFeature<>(TechnologicaFeatures.WULFENITE_DECORATED_ORE.get(), new OreConfiguration(ORE_MOLYBDENITE_TARGET_LIST, 8)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_PENTLANDITE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_PENTLANDITE_TARGET_LIST, 8)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_ARGENTITE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_ARGENTITE_TARGET_LIST, 8)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_GALENA, new ConfiguredFeature<>(TechnologicaFeatures.BARYTE_DECORATED_ORE.get(), new OreConfiguration(ORE_GALENA_TARGET_LIST, 8)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_SYLVANITE, new ConfiguredFeature<>(TechnologicaFeatures.TELLURITE_DECORATED_ORE.get(), new OreConfiguration(ORE_SYLVANITE_TARGET_LIST, 4)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_CASSITERITE, new ConfiguredFeature<>(TechnologicaFeatures.BISMITHUNITE_DECORATED_ORE.get(), new OreConfiguration(ORE_CASSITERITE_TARGET_LIST, 8)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_WOLFRAMITE, new ConfiguredFeature<>(TechnologicaFeatures.SCHEELITE_DECORATED_ORE.get(), new OreConfiguration(ORE_WOLFRAMITE_TARGET_LIST, 8)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_OSMIRIDIUM, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_OSMIRIDIUM_TARGET_LIST, 4)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_PLATINUM, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_PLATINUM_TARGET_LIST, 4)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_CINNABAR, new ConfiguredFeature<>(TechnologicaFeatures.STIBNITE_DECORATED_ORE.get(), new OreConfiguration(ORE_CINNABAR_TARGET_LIST, 8)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_THORIANITE, new ConfiguredFeature<>(TechnologicaFeatures.AUTUNITE_DECORATED_ORE.get(), new OreConfiguration(ORE_THORIANITE_TARGET_LIST, 8)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_URANINITE, new ConfiguredFeature<>(TechnologicaFeatures.AUTUNITE_DECORATED_ORE.get(), new OreConfiguration(ORE_URANINITE_TARGET_LIST, 8)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_EMERALD, new ConfiguredFeature<>(TechnologicaFeatures.AQUAMARINE_DECORATED_ORE.get(), new OreConfiguration(ORE_EMERALD_TARGET_LIST, 3)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_RUBY, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_RUBY_TARGET_LIST, 3)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_SAPPHIRE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_SAPPHIRE_TARGET_LIST, 3)));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORE_TOPAZ, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_TOPAZ_TARGET_LIST, 3)));

		/*
		 * TREE
		 */

		configuredFeature.register(TechnologicaConfiguredFeatures.APRICOT, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.APRICOT_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.APRICOT_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.ASPEN, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.ASPEN_LOG.get().defaultBlockState()), new StraightTrunkPlacer(6, 2, 0), BlockStateProvider.simple(TechnologicaBlocks.ASPEN_LEAVES.get().defaultBlockState()), new TeardropFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 6), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.AVOCADO, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.AVOCADO_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.AVOCADO_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.BANANA, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.BANANA_LOG.get().defaultBlockState()), new StraightTrunkPlacer(5, 2, 0), BlockStateProvider.simple(TechnologicaBlocks.BANANA_LEAVES.get().defaultBlockState()), new PalmFoliagePlacer(ConstantInt.of(4), ConstantInt.of(1)), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.CHERRY, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.CHERRY_LOG.get().defaultBlockState()), new StraightTrunkPlacer(5, 2, 0), BlockStateProvider.simple(TechnologicaBlocks.CHERRY_LEAVES.get().defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.CHESTNUT, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.CHESTNUT_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.CHESTNUT_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.CINNAMON, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.CINNAMON_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.CINNAMON_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.COCONUT, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.COCONUT_LOG.get().defaultBlockState()), new StraightTrunkPlacer(7, 5, 0), BlockStateProvider.simple(TechnologicaBlocks.COCONUT_LEAVES.get().defaultBlockState()), new PalmFoliagePlacer(ConstantInt.of(5), ConstantInt.of(1)), new TwoLayersFeatureSize(0, 0, 0)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.EBONY, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.EBONY_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.EBONY_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.KIWI, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.KIWI_LOG.get().defaultBlockState()), new StraightTrunkPlacer(3, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.KIWI_LEAVES.get().defaultBlockState()), new AcaciaFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.LEMON, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.LEMON_LOG.get().defaultBlockState()), new StraightTrunkPlacer(2, 2, 0), BlockStateProvider.simple(TechnologicaBlocks.LEMON_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.LIME, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.LIME_LOG.get().defaultBlockState()), new StraightTrunkPlacer(2, 2, 0), BlockStateProvider.simple(TechnologicaBlocks.LIME_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.MAHOGANY, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.MAHOGANY_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.MAHOGANY_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.MAPLE, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.MAPLE_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.MAPLE_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.OLIVE, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.OLIVE_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.OLIVE_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.ORANGE, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.ORANGE_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.ORANGE_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.PEACH, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.PEACH_LOG.get().defaultBlockState()), new StraightTrunkPlacer(5, 2, 0), BlockStateProvider.simple(TechnologicaBlocks.PEACH_LEAVES.get().defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.PEAR, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.PEAR_LOG.get().defaultBlockState()), new StraightTrunkPlacer(5, 2, 0), BlockStateProvider.simple(TechnologicaBlocks.PEAR_LEAVES.get().defaultBlockState()), new TeardropFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 6), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.PLUM, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.PLUM_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.PLUM_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.REDWOOD, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.REDWOOD_LOG.get().defaultBlockState()), new HugeTrunkPlacer(18, 5, 19), BlockStateProvider.simple(TechnologicaBlocks.REDWOOD_LEAVES.get().defaultBlockState()), new RedwoodFoliagePlacer(ConstantInt.of(4), ConstantInt.of(7)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.ROSEWOOD, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.ROSEWOOD_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.ROSEWOOD_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.RUBBER, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.RUBBER_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.RUBBER_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.TEAK, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.TEAK_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.TEAK_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.WALNUT, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.WALNUT_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.WALNUT_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.ZEBRAWOOD, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.ZEBRAWOOD_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.ZEBRAWOOD_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.ANCIENT_AMBROSIA, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.FRUITFUL_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.FRUITFUL_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(0, 0, 0)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.BENEVOLENT_APOTHECARY, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.BENEVOLENT_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.BENEVOLENT_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(0, 0, 0)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.CRYOGENIC_SPIRE, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.FROSTBITTEN_LOG.get().defaultBlockState()), new StraightTrunkPlacer(10, 10, 0), BlockStateProvider.simple(TechnologicaBlocks.FROSTBITTEN_LEAVES.get().defaultBlockState()), new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(5), UniformInt.of(4, 13)), new TwoLayersFeatureSize(0, 0, 0)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.MALEVOLENT_APOTHECARY, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.MALEVOLENT_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.MALEVOLENT_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(0, 0, 0)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.NECROTIC, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.NECROTIC_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.CURSED_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(0, 0, 0)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.SERENDIPITOUS_APOTHECARY, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.ALCHEMICAL_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 1, 0), BlockStateProvider.simple(TechnologicaBlocks.ALCHEMICAL_LEAVES.get().defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new TwoLayersFeatureSize(0, 0, 0)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.THUNDEROUS_CONDUCTOR, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.CONDUCTIVE_LOG.get().defaultBlockState()), new StraightTrunkPlacer(10, 10, 0), BlockStateProvider.simple(TechnologicaBlocks.CONDUCTIVE_LEAVES.get().defaultBlockState()), new DishFoliagePlacer(ConstantInt.of(9), ConstantInt.of(0), 3), new TwoLayersFeatureSize(0, 0, 0)).ignoreVines().build()));
		configuredFeature.register(TechnologicaConfiguredFeatures.TOWERING_INFERNO, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologicaBlocks.INFERNAL_LOG.get().defaultBlockState()), new StraightTrunkPlacer(10, 10, 0), BlockStateProvider.simple(Blocks.FIRE.defaultBlockState()), new ConicalFoliagePlacer(ConstantInt.of(9), ConstantInt.of(0)), new TwoLayersFeatureSize(0, 0, 0)).ignoreVines().build()));

		/*
		 * VEGETATION
		 */

		configuredFeature.register(TechnologicaConfiguredFeatures.TREES_MODIFIED_SAVANNA, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder, 0.8F)), holder)));
		configuredFeature.register(TechnologicaConfiguredFeatures.TREES_MODIFIED_JUNGLE, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder1, 0.33F), new WeightedPlacedFeature(holder2, 0.33F)), holder3)));
		configuredFeature.register(TechnologicaConfiguredFeatures.TREES_MODIFIED_JUNGLE_EDGE, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder4, 0.8F)), holder4)));
		configuredFeature.register(TechnologicaConfiguredFeatures.TREES_MODIFIED_BAMBOO_JUNGLE, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder5, 0.5F)), holder6)));
		configuredFeature.register(TechnologicaConfiguredFeatures.TREES_MODIFIED_FOREST, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder7, 0.8F)), holder7)));
		configuredFeature.register(TechnologicaConfiguredFeatures.TREES_MODIFIED_BIRCH_FOREST, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder8, 0.8F)), holder8)));
		configuredFeature.register(TechnologicaConfiguredFeatures.TREES_MODIFIED_WOODED_HILLS, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder9, 0.8F)), holder9)));
		configuredFeature.register(TechnologicaConfiguredFeatures.TREES_MODIFIED_BEACH, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder10, 0.8F)), holder10)));
		configuredFeature.register(TechnologicaConfiguredFeatures.TREES_MODIFIED_TAIGA, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder11, 0.5F)), holder12)));
		configuredFeature.register(TechnologicaConfiguredFeatures.TREES_MODIFIED_SNOWY_TAIGA, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder13, 0.5F)), holder14)));
		configuredFeature.register(TechnologicaConfiguredFeatures.TREES_MODIFIED_SWAMP, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder15, 0.8F)), holder15)));
		configuredFeature.register(TechnologicaConfiguredFeatures.PATCH_BLACKBERRY_BUSH, new ConfiguredFeature<>(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(TechnologicaBlocks.BLACKBERRY_BUSH.get().defaultBlockState().setValue(SweetBerryBushBlock.AGE, Integer.valueOf(3)))), List.of(Blocks.GRASS_BLOCK))));
		configuredFeature.register(TechnologicaConfiguredFeatures.PATCH_BLUEBERRY_BUSH, new ConfiguredFeature<>(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(TechnologicaBlocks.BLUEBERRY_BUSH.get().defaultBlockState().setValue(SweetBerryBushBlock.AGE, Integer.valueOf(3)))), List.of(Blocks.GRASS_BLOCK))));
		configuredFeature.register(TechnologicaConfiguredFeatures.PATCH_RASPBERRY_BUSH, new ConfiguredFeature<>(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(TechnologicaBlocks.RASPBERRY_BUSH.get().defaultBlockState().setValue(SweetBerryBushBlock.AGE, Integer.valueOf(3)))), List.of(Blocks.GRASS_BLOCK))));
		configuredFeature.register(TechnologicaConfiguredFeatures.PATCH_STRAWBERRY_BUSH, new ConfiguredFeature<>(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(TechnologicaBlocks.STRAWBERRY_BUSH.get().defaultBlockState().setValue(SweetBerryBushBlock.AGE, Integer.valueOf(3)))), List.of(Blocks.GRASS_BLOCK))));
		configuredFeature.register(TechnologicaConfiguredFeatures.PATCH_COTTON_BUSH, new ConfiguredFeature<>(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(TechnologicaBlocks.COTTON_BUSH.get().defaultBlockState().setValue(SweetBerryBushBlock.AGE, Integer.valueOf(3)))), List.of(Blocks.GRASS_BLOCK))));
		configuredFeature.register(TechnologicaConfiguredFeatures.PATCH_PEPPERCORN_BUSH, new ConfiguredFeature<>(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(TechnologicaBlocks.PEPPERCORNS.get().defaultBlockState().setValue(CropBlock.AGE, Integer.valueOf(3)))), List.of(Blocks.GRASS_BLOCK))));

		configuredFeature.register(TechnologicaConfiguredFeatures.DEEP_KELP, new ConfiguredFeature<>(TechnologicaFeatures.DEEP_KELP.get(), new NoneFeatureConfiguration()));
		configuredFeature.register(TechnologicaConfiguredFeatures.DEEP_SEAGRASS, new ConfiguredFeature<>(TechnologicaFeatures.DEEP_SEAGRASS.get(), new ProbabilityFeatureConfiguration(0.8F)));
		configuredFeature.register(TechnologicaConfiguredFeatures.DEEP_BASALT_PILLAR, new ConfiguredFeature<>(TechnologicaFeatures.DEEP_BASALT_PILLAR.get(), new NoneFeatureConfiguration()));
		configuredFeature.register(TechnologicaConfiguredFeatures.HYDROTHERMAL_VENT, new ConfiguredFeature<>(TechnologicaFeatures.HYDROTHERMAL_VENT.get(), new ColumnFeatureConfiguration(ConstantInt.of(1), UniformInt.of(1, 4))));
		configuredFeature.register(TechnologicaConfiguredFeatures.DEEP_BASALT_BLOB, new ConfiguredFeature<>(Feature.REPLACE_BLOBS, new ReplaceSphereConfiguration(Blocks.STONE.defaultBlockState(), Blocks.BASALT.defaultBlockState(), UniformInt.of(3, 7))));
	}

	@Override
	protected void populate() {
		// TODO Auto-generated method stub
	}
}
