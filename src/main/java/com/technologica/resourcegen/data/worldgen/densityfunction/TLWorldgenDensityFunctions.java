package com.technologica.resourcegen.data.worldgen.densityfunction;

import com.technologica.api.tlregen.resourcegen.data.worldgen.TLReGenWorldgenDensityFunction;
import com.technologica.registration.key.TechnologicaDensityFunctions;

import net.minecraft.world.level.levelgen.DensityFunctions;

public final class TLWorldgenDensityFunctions extends TLReGenWorldgenDensityFunction {
	@Override
	protected void populate() {
		densityFunction(TechnologicaDensityFunctions.CHALLENGER_DEEP_DEPTH, DensityFunctions.yClampedGradient(0, 256, 1, 0));
	}
}
