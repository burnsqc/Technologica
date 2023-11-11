package com.technologica.world.level.levelgen.structure;

import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.StructureSet;

public interface TechnologicaBuiltinStructureSets {
	ResourceKey<StructureSet> EL_DORADO = ResourceKey.create(Registries.STRUCTURE_SET, new TechnologicaLocation("el_dorado"));
	ResourceKey<StructureSet> DOME = ResourceKey.create(Registries.STRUCTURE_SET, new TechnologicaLocation("dome"));
}