package com.technologica.registration.dynamic;

import com.technologica.Technologica;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;

public final class TechnologicaDensityFunctions {
	public static final ResourceKey<DensityFunction> CHALLENGER_DEEP_DEPTH = Technologica.DENSITY_FUNCTIONS.register("challenger_deep/depth", () -> DensityFunctions.yClampedGradient(0, 256, 1, 0));
}
