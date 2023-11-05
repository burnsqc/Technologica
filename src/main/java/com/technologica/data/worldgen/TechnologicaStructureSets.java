package com.technologica.data.worldgen;

import com.technologica.world.level.levelgen.structure.TechnologicaBuiltinStructureSets;
import com.technologica.world.level.levelgen.structure.TechnologicaBuiltinStructures;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

public interface TechnologicaStructureSets {
	static void bootstrap(BootstapContext<StructureSet> boostrapContextIn) {
		HolderGetter<Structure> structures = boostrapContextIn.lookup(Registries.STRUCTURE);
		boostrapContextIn.register(TechnologicaBuiltinStructureSets.EL_DORADO, new StructureSet(structures.getOrThrow(TechnologicaBuiltinStructures.EL_DORADO), new RandomSpreadStructurePlacement(24, 8, RandomSpreadType.LINEAR, 20083232)));
	}
}