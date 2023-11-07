package com.technologica.world.level.levelgen.structure;

import com.technologica.Technologica;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;

public class TechnologicaBuiltinStructures {
	public static final ResourceKey<Structure> EL_DORADO = ResourceKey.create(Registries.STRUCTURE, new ResourceLocation(Technologica.MODID, "el_dorado"));
	public static final ResourceKey<Structure> DOME = ResourceKey.create(Registries.STRUCTURE, new ResourceLocation(Technologica.MODID, "dome"));
}