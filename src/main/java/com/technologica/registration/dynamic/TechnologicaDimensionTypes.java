package com.technologica.registration.dynamic;

import com.technologica.Technologica;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.dimension.DimensionType;

public final class TechnologicaDimensionTypes {
	public static final ResourceKey<DimensionType> MOON = Technologica.DIMENSION_TYPES.register("moon");
	public static final ResourceKey<DimensionType> CHALLENGER_DEEP = Technologica.DIMENSION_TYPES.register("challenger_deep");
	public static final ResourceKey<DimensionType> OVERGROWTH = Technologica.DIMENSION_TYPES.register("overgrowth");
	// TODO: Never really liked that ResourceLocations for effects are here. Determine where to move them.
	public static final ResourceLocation MOON_EFFECTS = new TechnologicaLocation("moon");
	public static final ResourceLocation CHALLENGER_DEEP_EFFECTS = new TechnologicaLocation("challenger_deep");
	public static final ResourceLocation OVERGROWTH_EFFECTS = new TechnologicaLocation("overgrowth");
}
