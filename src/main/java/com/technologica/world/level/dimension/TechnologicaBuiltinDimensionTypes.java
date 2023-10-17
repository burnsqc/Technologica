package com.technologica.world.level.dimension;

import com.technologica.Technologica;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.dimension.DimensionType;

public class TechnologicaBuiltinDimensionTypes {
	public static final ResourceKey<DimensionType> MOON = register("moon");
	public static final ResourceLocation MOON_EFFECTS = new ResourceLocation(Technologica.MODID, "moon");

	private static ResourceKey<DimensionType> register(String p_223548_) {
		return ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(Technologica.MODID, p_223548_));
	}
}
