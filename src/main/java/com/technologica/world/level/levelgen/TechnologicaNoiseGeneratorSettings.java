package com.technologica.world.level.levelgen;

import java.util.List;

import com.technologica.Technologica;
import com.technologica.data.worldgen.TechnologicaSurfaceRuleData;
import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.NoiseSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;

public record TechnologicaNoiseGeneratorSettings(NoiseSettings noiseSettings, BlockState defaultBlock, BlockState defaultFluid, NoiseRouter noiseRouter, SurfaceRules.RuleSource surfaceRule, List<Climate.ParameterPoint> spawnTarget, int seaLevel, boolean disableMobGeneration, boolean aquifersEnabled, boolean oreVeinsEnabled, boolean useLegacyRandomSource) {

	public static final ResourceKey<NoiseGeneratorSettings> MOON = ResourceKey.create(Registries.NOISE_SETTINGS, new ResourceLocation(Technologica.MODID, "moon"));

	public static NoiseGeneratorSettings moon(BootstapContext<?> p_256460_, boolean p_256427_, boolean p_256318_) {
		return new NoiseGeneratorSettings(TechnologicaNoiseSettings.MOON_NOISE_SETTINGS, TechnologicaBlocks.MOON_ROCK.get().defaultBlockState(), Blocks.WATER.defaultBlockState(), TechnologicaNoiseRouterData.moon(p_256460_.lookup(Registries.DENSITY_FUNCTION), p_256460_.lookup(Registries.NOISE), false, false), TechnologicaSurfaceRuleData.moon(), (new OverworldBiomeBuilder()).spawnTarget(), 0, false, false, false, false);
	}
}
