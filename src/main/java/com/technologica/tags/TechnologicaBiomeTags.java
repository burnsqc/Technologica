package com.technologica.tags;

import com.technologica.Technologica;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class TechnologicaBiomeTags {
	public static final TagKey<Biome> HAS_EL_DORADO = TagKey.create(Registries.BIOME, new ResourceLocation(Technologica.MODID, "has_el_dorado"));
	public static final TagKey<Biome> HAS_DOME = TagKey.create(Registries.BIOME, new ResourceLocation(Technologica.MODID, "has_dome"));
}