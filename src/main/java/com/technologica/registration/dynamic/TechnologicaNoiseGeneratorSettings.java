package com.technologica.registration.dynamic;

import com.technologica.api.tlregen.registration.MasterKeyCreator;
import com.technologica.resourcegen.data.worldgen.noisesettings.TLWorldgenNoiseSettings;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

/**
 * <p>
 * This class contains Resource Keys for Noise Generator Settings.
 * The corresponding Noise Generator Settings are created in json format during Data Generation in {@link TLWorldgenNoiseSettings}.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaNoiseGeneratorSettings extends MasterKeyCreator {
	public static final ResourceKey<NoiseGeneratorSettings> MOON = noiseGeneratorSettings("moon");
	public static final ResourceKey<NoiseGeneratorSettings> CHALLENGER_DEEP = noiseGeneratorSettings("challenger_deep");
	public static final ResourceKey<NoiseGeneratorSettings> OVERGROWTH = noiseGeneratorSettings("overgrowth");
}