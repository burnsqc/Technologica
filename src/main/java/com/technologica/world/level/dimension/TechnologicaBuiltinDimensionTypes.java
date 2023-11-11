package com.technologica.world.level.dimension;

import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.dimension.DimensionType;

public class TechnologicaBuiltinDimensionTypes {
	public static final ResourceKey<DimensionType> MOON = ResourceKey.create(Registries.DIMENSION_TYPE, new TechnologicaLocation("moon"));
	public static final ResourceKey<DimensionType> CHALLENGER_DEEP = ResourceKey.create(Registries.DIMENSION_TYPE, new TechnologicaLocation("challenger_deep"));
	public static final ResourceKey<DimensionType> OVERGROWTH = ResourceKey.create(Registries.DIMENSION_TYPE, new TechnologicaLocation("overgrowth"));
	public static final ResourceLocation MOON_EFFECTS = new TechnologicaLocation("moon");
	public static final ResourceLocation CHALLENGER_DEEP_EFFECTS = new TechnologicaLocation("challenger_deep");
	public static final ResourceLocation OVERGROWTH_EFFECTS = new TechnologicaLocation("overgrowth");
}
