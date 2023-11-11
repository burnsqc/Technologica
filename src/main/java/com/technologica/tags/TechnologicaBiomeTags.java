package com.technologica.tags;

import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class TechnologicaBiomeTags {
	public static final TagKey<Biome> HAS_EL_DORADO = TagKey.create(Registries.BIOME, new TechnologicaLocation("has_el_dorado"));
	public static final TagKey<Biome> HAS_DOME = TagKey.create(Registries.BIOME, new TechnologicaLocation("has_dome"));
}