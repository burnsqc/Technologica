package com.technologica.data.worldgen.features;

import java.util.List;

import com.technologica.Technologica;
import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class TechnologicaOreFeatures {
	public static final List<OreConfiguration.TargetBlockState> ORE_SPODUMENE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.SPODUMENE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.SPODUMENE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_BORAX_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.BORAX_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.BORAX_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_MAGNESITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.MAGNESITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.MAGNESITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_BAUXITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.BAUXITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.BAUXITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_APATITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.APATITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.APATITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_PHOSPHORITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.PHOSPHORITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.PHOSPHORITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_GADOLINITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.GADOLINITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.GADOLINITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_ILMENITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.ILMENITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.ILMENITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_CHROMITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.CHROMITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.CHROMITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_PYROLUSITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.PYROLUSITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.PYROLUSITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_COBALTITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.COBALTITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.COBALTITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_GARNIERITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.GARNIERITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.GARNIERITE_ORE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_PATRONITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TechnologicaBlocks.PATRONITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.PATRONITE_ORE.get().defaultBlockState()));

	public static Holder<ConfiguredFeature<?, ?>> ORE_SPODUMENE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_BORAX;
	public static Holder<ConfiguredFeature<?, ?>> ORE_MAGNESITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_BAUXITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_APATITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_PHOSPHORITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_GADOLINITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_ILMENITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_CHROMITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_PYROLUSITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_COBALTITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_GARNIERITE;
	public static Holder<ConfiguredFeature<?, ?>> ORE_PATRONITE;

	public static void register() {
		ORE_SPODUMENE = register("ore_spodumene", Feature.ORE, new OreConfiguration(ORE_SPODUMENE_TARGET_LIST, 17));
		ORE_BORAX = register("ore_borax", Feature.ORE, new OreConfiguration(ORE_BORAX_TARGET_LIST, 17));
		ORE_MAGNESITE = register("ore_magnesite", Feature.ORE, new OreConfiguration(ORE_MAGNESITE_TARGET_LIST, 17));
		ORE_BAUXITE = register("ore_bauxite", Feature.ORE, new OreConfiguration(ORE_BAUXITE_TARGET_LIST, 17));
		ORE_APATITE = register("ore_apatite", Feature.ORE, new OreConfiguration(ORE_APATITE_TARGET_LIST, 17));
		ORE_PHOSPHORITE = register("ore_phosphorite", Feature.ORE, new OreConfiguration(ORE_PHOSPHORITE_TARGET_LIST, 17));
		ORE_GADOLINITE = register("ore_gadolinite", Feature.ORE, new OreConfiguration(ORE_GADOLINITE_TARGET_LIST, 17));
		ORE_ILMENITE = register("ore_ilmenite", Feature.ORE, new OreConfiguration(ORE_ILMENITE_TARGET_LIST, 17));
		ORE_CHROMITE = register("ore_chromite", Feature.ORE, new OreConfiguration(ORE_CHROMITE_TARGET_LIST, 17));
		ORE_PYROLUSITE = register("ore_pyrolusite", Feature.ORE, new OreConfiguration(ORE_PYROLUSITE_TARGET_LIST, 17));
		ORE_COBALTITE = register("ore_cobaltite", Feature.ORE, new OreConfiguration(ORE_COBALTITE_TARGET_LIST, 17));
		ORE_GARNIERITE = register("ore_garnierite", Feature.ORE, new OreConfiguration(ORE_GARNIERITE_TARGET_LIST, 17));
		ORE_PATRONITE = register("ore_patronite", Feature.ORE, new OreConfiguration(ORE_PATRONITE_TARGET_LIST, 17));
	}

	public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<?, ?>> register(String stringIn, F featureIn, FC configurationIn) {
		return BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Technologica.MODID, stringIn), new ConfiguredFeature<>(featureIn, configurationIn));
	}
}
