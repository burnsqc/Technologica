package com.technologica.world.level.dimension;

import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.dimension.LevelStem;

public class TechnologicaLevelStem {
	public static final ResourceKey<LevelStem> MOON_STEM = ResourceKey.create(Registries.LEVEL_STEM, new TechnologicaLocation("moon"));
	public static final ResourceKey<LevelStem> CHALLENGER_DEEP_STEM = ResourceKey.create(Registries.LEVEL_STEM, new TechnologicaLocation("challenger_deep"));
	public static final ResourceKey<LevelStem> OVERGROWTH_STEM = ResourceKey.create(Registries.LEVEL_STEM, new TechnologicaLocation("overgrowth"));
}