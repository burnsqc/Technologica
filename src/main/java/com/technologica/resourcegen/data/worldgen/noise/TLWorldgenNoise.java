package com.technologica.resourcegen.data.worldgen.noise;

import com.technologica.api.tlregen.resourcegen.data.worldgen.TLReGenWorldgenNoise;
import com.technologica.registration.dynamic.TechnologicaNoise;

import net.minecraft.world.level.levelgen.synth.NormalNoise.NoiseParameters;

public final class TLWorldgenNoise extends TLReGenWorldgenNoise {
	@Override
	protected void populate() {
		noise(TechnologicaNoise.TEST, new NoiseParameters(1, 1.0));
	}
}
