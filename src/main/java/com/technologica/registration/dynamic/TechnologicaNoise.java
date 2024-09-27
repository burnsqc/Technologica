package com.technologica.registration.dynamic;

import com.technologica.api.tlregen.registration.MasterKeyCreator;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.synth.NormalNoise.NoiseParameters;

public final class TechnologicaNoise extends MasterKeyCreator {
	public static final ResourceKey<NoiseParameters> TEST = noise("test");
}