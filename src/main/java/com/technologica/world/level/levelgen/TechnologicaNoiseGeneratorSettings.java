package com.technologica.world.level.levelgen;

import java.util.List;

import com.technologica.Technologica;
import com.technologica.data.registries.TechnologicaDatapackBuiltinEntriesProvider;
import com.technologica.data.worldgen.TechnologicaSurfaceRuleData;
import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.NoiseSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;

/**
 * <p>
 * This class contains Resource Keys for Noise Generator Settings, a bootstrap method, and Noise Generator Settings.
 * The corresponding Noise Generator Settings are created in json format during Data Generation via bootstrap in {@link TechnologicaDatapackBuiltinEntriesProvider}.
 * The structure of this class is a slight departure from the vanilla counterpart record as there is no use in this being a record as well.
 * </p>
 * 
 * @tl.status GREEN
 */
public class TechnologicaNoiseGeneratorSettings {

	public static final ResourceKey<NoiseGeneratorSettings> MOON = ResourceKey.create(Registries.NOISE_SETTINGS, new ResourceLocation(Technologica.MODID, "moon"));
	public static final ResourceKey<NoiseGeneratorSettings> CHALLENGER_DEEP = ResourceKey.create(Registries.NOISE_SETTINGS, new ResourceLocation(Technologica.MODID, "challenger_deep"));
	public static final ResourceKey<NoiseGeneratorSettings> OVERGROWTH = ResourceKey.create(Registries.NOISE_SETTINGS, new ResourceLocation(Technologica.MODID, "overgrowth"));

	/**
	 * <p>
	 * This method registers a Resource Key and Noise Generator Settings to the Noise Settings Registry.
	 * The structure of the Noise Generator Settings methods are a slight departure from the vanilla counterpart with the intent being ease of use.
	 * <p>
	 * 
	 * @param bootstrapContextIn of type NoiseGeneratorSettings
	 */
	public static void bootstrap(BootstapContext<NoiseGeneratorSettings> bootstrapContextIn) {
		bootstrapContextIn.register(MOON, moon(bootstrapContextIn));
		bootstrapContextIn.register(CHALLENGER_DEEP, challengerDeep(bootstrapContextIn));
		bootstrapContextIn.register(OVERGROWTH, overgrowth(bootstrapContextIn));
	}

	/**
	 * <p>
	 * This method controls the contents of the Noise Settings json file for the Moon.
	 * Variables are defined in the order they will appear in the json file.
	 * <p>
	 * 
	 * @param bootstrapContextIn of type NoiseGeneratorSettings
	 * @return NoiseGeneratorSettings for the Moon
	 */
	private static NoiseGeneratorSettings moon(BootstapContext<?> bootstrapContextIn) {
		boolean aquifersEnabled = false;
		BlockState defaultBlock = TechnologicaBlocks.MOON_ROCK.get().defaultBlockState();
		BlockState defaultFluid = Blocks.WATER.defaultBlockState();
		boolean disabledMobGeneration = false;
		boolean legacyRandomSource = false;
		NoiseSettings noise = TechnologicaNoiseSettings.MOON_NOISE_SETTINGS;
		NoiseRouter noiseRouter = TechnologicaNoiseRouterData.moon(bootstrapContextIn.lookup(Registries.DENSITY_FUNCTION), bootstrapContextIn.lookup(Registries.NOISE), false, false);
		boolean oreVeinsEnabled = false;
		int seaLevel = -64;
		List<Climate.ParameterPoint> spawnTarget = List.of();
		SurfaceRules.RuleSource surfaceRule = TechnologicaSurfaceRuleData.moon();

		return new NoiseGeneratorSettings(noise, defaultBlock, defaultFluid, noiseRouter, surfaceRule, spawnTarget, seaLevel, disabledMobGeneration, aquifersEnabled, oreVeinsEnabled, legacyRandomSource);
	}

	/**
	 * <p>
	 * This method controls the contents of the Noise Settings json file for the Challenger Deep.
	 * Variables are defined in the order they will appear in the json file.
	 * <p>
	 * 
	 * @param bootstrapContextIn of type NoiseGeneratorSettings
	 * @return NoiseGeneratorSettings for the Challenger Deep
	 */
	private static NoiseGeneratorSettings challengerDeep(BootstapContext<?> bootstrapContextIn) {
		boolean aquifersEnabled = false;
		BlockState defaultBlock = Blocks.STONE.defaultBlockState();
		BlockState defaultFluid = Blocks.WATER.defaultBlockState();
		boolean disabledMobGeneration = false;
		boolean legacyRandomSource = false;
		NoiseSettings noise = TechnologicaNoiseSettings.CHALLENGER_DEEP_NOISE_SETTINGS;
		NoiseRouter noiseRouter = TechnologicaNoiseRouterData.challengerDeep(bootstrapContextIn.lookup(Registries.DENSITY_FUNCTION), bootstrapContextIn.lookup(Registries.NOISE));
		boolean oreVeinsEnabled = false;
		int seaLevel = 384;
		List<Climate.ParameterPoint> spawnTarget = List.of();
		SurfaceRules.RuleSource surfaceRule = TechnologicaSurfaceRuleData.challengerDeep();

		return new NoiseGeneratorSettings(noise, defaultBlock, defaultFluid, noiseRouter, surfaceRule, spawnTarget, seaLevel, disabledMobGeneration, aquifersEnabled, oreVeinsEnabled, legacyRandomSource);
	}

	/**
	 * <p>
	 * This method controls the contents of the Noise Settings json file for the Overgrowth.
	 * Variables are defined in the order they will appear in the json file.
	 * <p>
	 * 
	 * @param bootstrapContextIn of type NoiseGeneratorSettings
	 * @return NoiseGeneratorSettings for the Overgrowth
	 */
	private static NoiseGeneratorSettings overgrowth(BootstapContext<?> bootstrapContextIn) {
		boolean aquifersEnabled = false;
		BlockState defaultBlock = Blocks.DIRT.defaultBlockState();
		BlockState defaultFluid = Blocks.WATER.defaultBlockState();
		boolean disabledMobGeneration = false;
		boolean legacyRandomSource = false;
		NoiseSettings noise = TechnologicaNoiseSettings.OVERGROWTH_NOISE_SETTINGS;
		NoiseRouter noiseRouter = TechnologicaNoiseRouterData.challengerDeep(bootstrapContextIn.lookup(Registries.DENSITY_FUNCTION), bootstrapContextIn.lookup(Registries.NOISE));
		boolean oreVeinsEnabled = false;
		int seaLevel = 32;
		List<Climate.ParameterPoint> spawnTarget = List.of();
		SurfaceRules.RuleSource surfaceRule = TechnologicaSurfaceRuleData.overgrowth();

		return new NoiseGeneratorSettings(noise, defaultBlock, defaultFluid, noiseRouter, surfaceRule, spawnTarget, seaLevel, disabledMobGeneration, aquifersEnabled, oreVeinsEnabled, legacyRandomSource);
	}
}