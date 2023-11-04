package com.technologica.world.level.dimension;

import com.technologica.Technologica;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.dimension.LevelStem;

public class TechnologicaLevelStem {
	public static final ResourceKey<LevelStem> MOON_STEM = ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation(Technologica.MODID, "moon"));
	public static final ResourceKey<LevelStem> CHALLENGER_DEEP_STEM = ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation(Technologica.MODID, "challenger_deep"));
	public static final ResourceKey<LevelStem> OVERGROWTH_STEM = ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation(Technologica.MODID, "overgrowth"));
}