package com.technologica.world.level.levelgen.structure;

import com.technologica.Technologica;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.StructureSet;

public interface TechnologicaBuiltinStructureSets {
	ResourceKey<StructureSet> EL_DORADO = ResourceKey.create(Registries.STRUCTURE_SET, new ResourceLocation(Technologica.MODID, "el_dorado"));
}