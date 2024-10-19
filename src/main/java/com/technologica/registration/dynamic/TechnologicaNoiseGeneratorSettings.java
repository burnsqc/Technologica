package com.technologica.registration.dynamic;

import com.technologica.Technologica;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

public final class TechnologicaNoiseGeneratorSettings {
	public static final ResourceKey<NoiseGeneratorSettings> MOON = Technologica.NOISE_GENERATOR_SETTINGS.register("moon");
	public static final ResourceKey<NoiseGeneratorSettings> CHALLENGER_DEEP = Technologica.NOISE_GENERATOR_SETTINGS.register("challenger_deep");
	public static final ResourceKey<NoiseGeneratorSettings> OVERGROWTH = Technologica.NOISE_GENERATOR_SETTINGS.register("overgrowth");
}
