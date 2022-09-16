package com.technologica.data.worldgen.features;

import java.util.List;

import com.technologica.Technologica;
import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class TechnologicaOreFeatures {
	public static final RuleTest NATURAL_STONE = new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD);
	public static final RuleTest STONE_ORE_REPLACEABLES = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
	public static final RuleTest DEEPSLATE_ORE_REPLACEABLES = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
	public static final List<OreConfiguration.TargetBlockState> ORE_GOLD_TARGET_LIST = List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, Blocks.GOLD_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> ORE_COAL_TARGET_LIST = List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, TechnologicaBlocks.SPODUMENE_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, TechnologicaBlocks.SPODUMENE_ORE.get().defaultBlockState()));

	public static Holder<ConfiguredFeature<?, ?>> ORE_SPODUMENE;

	public static void register() {
		ORE_SPODUMENE = register("ore_spodumene", Feature.ORE, new OreConfiguration(ORE_COAL_TARGET_LIST, 17));
	}

	public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<?, ?>> register(String stringIn, F featureIn, FC configurationIn) {
		return BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Technologica.MODID, stringIn), new ConfiguredFeature<>(featureIn, configurationIn));
	}
}
