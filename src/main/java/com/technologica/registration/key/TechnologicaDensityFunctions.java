package com.technologica.registration.key;

import com.technologica.api.tlregen.registration.MasterKeyCreator;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.DensityFunction;

public final class TechnologicaDensityFunctions extends MasterKeyCreator {
	public static final ResourceKey<DensityFunction> CHALLENGER_DEEP_DEPTH = densityFunction("challenger_deep/depth");
}