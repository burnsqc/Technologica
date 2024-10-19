package com.technologica.registration.dynamic;

import com.technologica.Technologica;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.synth.NormalNoise.NoiseParameters;

public final class TechnologicaNoise {
	public static final ResourceKey<NoiseParameters> TEST = Technologica.NOISE.register("test");
}
