package com.technologica.world.level.levelgen;

import com.technologica.Technologica;
import com.technologica.datagen.registries.TechnologicaDatapackBuiltinEntriesProvider;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

/**
 * <p>
 * This class contains Resource Keys for Noise Generator Settings.
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
}