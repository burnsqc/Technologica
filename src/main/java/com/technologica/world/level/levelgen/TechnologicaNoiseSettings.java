package com.technologica.world.level.levelgen;

import net.minecraft.world.level.levelgen.NoiseSettings;

public record TechnologicaNoiseSettings(int minY, int height, int noiseSizeHorizontal, int noiseSizeVertical) {
	protected static final NoiseSettings MOON_NOISE_SETTINGS = NoiseSettings.create(-64, 384, 1, 2);
	protected static final NoiseSettings CHALLENGER_DEEP_NOISE_SETTINGS = NoiseSettings.create(-64, 384, 1, 2);
}
