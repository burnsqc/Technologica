package com.technologica.data.worldgen.features;

import java.util.List;

import com.technologica.Technologica;
import com.technologica.world.level.block.TechnologicaBlocks;
import com.technologica.world.level.levelgen.feature.TechnologicaFeature;

import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class TechnologicaOreFeatures {
	public static final List<OreConfiguration.TargetBlockState> ORE_SPODUMENE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.SPODUMENE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_SPODUMENE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_BORAX_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.BORAX_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_BORAX_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_MAGNESITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.MAGNESITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_MAGNESITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_BAUXITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.BAUXITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_BAUXITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_APATITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.APATITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_APATITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_PHOSPHORITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.PHOSPHORITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_PHOSPHORITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_GADOLINITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.GADOLINITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_GADOLINITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_ILMENITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.ILMENITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_ILMENITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_PATRONITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.PATRONITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_PATRONITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_CHROMITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.CHROMITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_CHROMITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_PYROLUSITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.PYROLUSITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_PYROLUSITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_COBALTITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.COBALTITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_COBALTITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_GARNIERITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.GARNIERITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_GARNIERITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_ARSENOPYRITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.ARSENOPYRITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_ARSENOPYRITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_CROOKESITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.CROOKESITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_CROOKESITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_LEPIDOLITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.LEPIDOLITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_LEPIDOLITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_BASTNAESITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.BASTNAESITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_BASTNAESITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_TANTALITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.TANTALITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_TANTALITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_MOLYBDENITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.MOLYBDENITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_MOLYBDENITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_PENTLANDITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.PENTLANDITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_PENTLANDITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_ARGENTITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.ARGENTITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_ARGENTITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_GALENA_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.GALENA_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_GALENA_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_SYLVANITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.SYLVANITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_SYLVANITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_CASSITERITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.CASSITERITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_CASSITERITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_WOLFRAMITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.WOLFRAMITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_WOLFRAMITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_OSMIRIDIUM_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.OSMIRIDIUM_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_OSMIRIDIUM_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_PLATINUM_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.PLATINUM_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_PLATINUM_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_CINNABAR_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.CINNABAR_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_CINNABAR_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_THORIANITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.THORIANITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_THORIANITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_URANINITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.URANINITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_URANINITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_EMERALD_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, Blocks.EMERALD_ORE.defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, Blocks.DEEPSLATE_EMERALD_ORE.defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_RUBY_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.RUBY_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_SAPPHIRE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.SAPPHIRE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_TOPAZ_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.TOPAZ_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.DEEPSLATE_TOPAZ_ORE.get().defaultBlockState()));
	
	public static Holder<ConfiguredFeature<?, ?>> ORE_SPODUMENE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_BORAX;
	public static Holder<ConfiguredFeature<?, ?>> ORE_MAGNESITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_BAUXITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_APATITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_PHOSPHORITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_GADOLINITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_ILMENITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_PATRONITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_CHROMITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_PYROLUSITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_COBALTITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_GARNIERITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_ARSENOPYRITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_CROOKESITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_LEPIDOLITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_BASTNAESITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_TANTALITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_MOLYBDENITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_PENTLANDITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_ARGENTITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_GALENA;
	public static Holder<ConfiguredFeature<?, ?>> ORE_SYLVANITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_CASSITERITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_WOLFRAMITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_OSMIRIDIUM;
	public static Holder<ConfiguredFeature<?, ?>> ORE_PLATINUM;
	public static Holder<ConfiguredFeature<?, ?>> ORE_CINNABAR;
	public static Holder<ConfiguredFeature<?, ?>> ORE_THORIANITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_URANINITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_EMERALD;
	public static Holder<ConfiguredFeature<?, ?>> ORE_RUBY;
	public static Holder<ConfiguredFeature<?, ?>> ORE_SAPPHIRE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_TOPAZ;

	public static void register() {
		ORE_SPODUMENE = register("ore_spodumene", TechnologicaFeature.POLLUCITE_DECORATED_ORE.get(), new OreConfiguration(ORE_SPODUMENE_TARGET_LIST, 8));
		ORE_BORAX = register("ore_borax", TechnologicaFeature.ULEXITE_DECORATED_ORE.get(), new OreConfiguration(ORE_BORAX_TARGET_LIST, 8));
		ORE_MAGNESITE = register("ore_magnesite", TechnologicaFeature.DOLOMITE_DECORATED_ORE.get(), new OreConfiguration(ORE_MAGNESITE_TARGET_LIST, 8));
		ORE_BAUXITE = register("ore_bauxite", Feature.ORE, new OreConfiguration(ORE_BAUXITE_TARGET_LIST, 8));
		ORE_APATITE = register("ore_apatite", TechnologicaFeature.FLUORITE_DECORATED_ORE.get(), new OreConfiguration(ORE_APATITE_TARGET_LIST, 8));
		ORE_PHOSPHORITE = register("ore_phosphorite", TechnologicaFeature.CELESTINE_DECORATED_ORE.get(), new OreConfiguration(ORE_PHOSPHORITE_TARGET_LIST, 8));
		ORE_GADOLINITE = register("ore_gadolinite", TechnologicaFeature.XENOTIME_DECORATED_ORE.get(), new OreConfiguration(ORE_GADOLINITE_TARGET_LIST, 4));
		ORE_ILMENITE = register("ore_ilmenite", TechnologicaFeature.RUTILE_DECORATED_ORE.get(), new OreConfiguration(ORE_ILMENITE_TARGET_LIST, 8));
		ORE_PATRONITE = register("ore_patronite", TechnologicaFeature.VANADANITE_DECORATED_ORE.get(), new OreConfiguration(ORE_PATRONITE_TARGET_LIST, 8));
		ORE_CHROMITE = register("ore_chromite", TechnologicaFeature.ZIRCON_DECORATED_ORE.get(), new OreConfiguration(ORE_CHROMITE_TARGET_LIST, 8));
		ORE_PYROLUSITE = register("ore_pyrolusite", Feature.ORE, new OreConfiguration(ORE_PYROLUSITE_TARGET_LIST, 8));
		ORE_COBALTITE = register("ore_cobaltite", Feature.ORE, new OreConfiguration(ORE_COBALTITE_TARGET_LIST, 8));
		ORE_GARNIERITE = register("ore_garnierite", Feature.ORE, new OreConfiguration(ORE_GARNIERITE_TARGET_LIST, 8));
		ORE_ARSENOPYRITE = register("ore_arsenopyrite", TechnologicaFeature.SPHALERITE_DECORATED_ORE.get(), new OreConfiguration(ORE_ARSENOPYRITE_TARGET_LIST, 8));
		ORE_CROOKESITE = register("ore_crookesite", TechnologicaFeature.HUTCHINSONITE_DECORATED_ORE.get(), new OreConfiguration(ORE_CROOKESITE_TARGET_LIST, 8));
		ORE_LEPIDOLITE = register("ore_lepidolite", TechnologicaFeature.STRONTIANITE_DECORATED_ORE.get(), new OreConfiguration(ORE_LEPIDOLITE_TARGET_LIST, 8));
		ORE_BASTNAESITE = register("ore_bastnaesite", TechnologicaFeature.MONAZITE_DECORATED_ORE.get(), new OreConfiguration(ORE_BASTNAESITE_TARGET_LIST, 4));
		ORE_TANTALITE = register("ore_tantalite", TechnologicaFeature.COLUMBITE_DECORATED_ORE.get(), new OreConfiguration(ORE_TANTALITE_TARGET_LIST, 4));
		ORE_MOLYBDENITE = register("ore_molybdenite", TechnologicaFeature.WULFENITE_DECORATED_ORE.get(), new OreConfiguration(ORE_MOLYBDENITE_TARGET_LIST, 8));
		ORE_PENTLANDITE = register("ore_pentlandite", Feature.ORE, new OreConfiguration(ORE_PENTLANDITE_TARGET_LIST, 8));
		ORE_ARGENTITE = register("ore_argentite", Feature.ORE, new OreConfiguration(ORE_ARGENTITE_TARGET_LIST, 8));
		ORE_GALENA = register("ore_galena", TechnologicaFeature.BARYTE_DECORATED_ORE.get(), new OreConfiguration(ORE_GALENA_TARGET_LIST, 8));
		ORE_SYLVANITE = register("ore_sylvanite", TechnologicaFeature.TELLURITE_DECORATED_ORE.get(), new OreConfiguration(ORE_SYLVANITE_TARGET_LIST, 4));
		ORE_CASSITERITE = register("ore_cassiterite", TechnologicaFeature.BISMITHUNITE_DECORATED_ORE.get(), new OreConfiguration(ORE_CASSITERITE_TARGET_LIST, 8));
		ORE_WOLFRAMITE = register("ore_wolframite", TechnologicaFeature.SCHEELITE_DECORATED_ORE.get(), new OreConfiguration(ORE_WOLFRAMITE_TARGET_LIST, 8));
		ORE_OSMIRIDIUM = register("ore_osmiridium", Feature.ORE, new OreConfiguration(ORE_OSMIRIDIUM_TARGET_LIST, 4));
		ORE_PLATINUM = register("ore_platinum", Feature.ORE, new OreConfiguration(ORE_PLATINUM_TARGET_LIST, 4));
		ORE_CINNABAR = register("ore_cinnabar", TechnologicaFeature.STIBNITE_DECORATED_ORE.get(), new OreConfiguration(ORE_CINNABAR_TARGET_LIST, 8));
		ORE_THORIANITE = register("ore_thorianite", TechnologicaFeature.AUTUNITE_DECORATED_ORE.get(), new OreConfiguration(ORE_THORIANITE_TARGET_LIST, 8));
		ORE_URANINITE = register("ore_uraninite", TechnologicaFeature.AUTUNITE_DECORATED_ORE.get(), new OreConfiguration(ORE_URANINITE_TARGET_LIST, 8));
		ORE_EMERALD = register("ore_emerald", TechnologicaFeature.AQUAMARINE_DECORATED_ORE.get(), new OreConfiguration(ORE_EMERALD_TARGET_LIST, 3));
		ORE_RUBY = register("ore_ruby", Feature.ORE, new OreConfiguration(ORE_RUBY_TARGET_LIST, 3));
		ORE_SAPPHIRE = register("ore_sapphire", Feature.ORE, new OreConfiguration(ORE_SAPPHIRE_TARGET_LIST, 3));
		ORE_TOPAZ = register("ore_topaz", Feature.ORE, new OreConfiguration(ORE_TOPAZ_TARGET_LIST, 3));
	}

	public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<?, ?>> register(String stringIn, F featureIn, FC configurationIn) {
		return BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Technologica.MODID, stringIn), new ConfiguredFeature<>(featureIn, configurationIn));
	}
}
