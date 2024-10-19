package com.technologica.registration.dynamic;

import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public final class TechnologicaBiomeTags {
	public static final TagKey<Biome> HAS_EL_DORADO = TagKey.create(Registries.BIOME, new TechnologicaLocation("has_el_dorado"));
	public static final TagKey<Biome> HAS_DOME = TagKey.create(Registries.BIOME, new TechnologicaLocation("has_dome"));
	public static final TagKey<Biome> HAS_WHALE_CARCASS = TagKey.create(Registries.BIOME, new TechnologicaLocation("has_whale_carcass"));
}
