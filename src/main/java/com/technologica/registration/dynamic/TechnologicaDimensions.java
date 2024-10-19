package com.technologica.registration.dynamic;

import com.technologica.Technologica;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.dimension.LevelStem;

public final class TechnologicaDimensions {
	public static final ResourceKey<LevelStem> MOON_STEM = Technologica.DIMENSIONS.register("moon");
	public static final ResourceKey<LevelStem> CHALLENGER_DEEP_STEM = Technologica.DIMENSIONS.register("challenger_deep");
	public static final ResourceKey<LevelStem> OVERGROWTH_STEM = Technologica.DIMENSIONS.register("overgrowth");
}
