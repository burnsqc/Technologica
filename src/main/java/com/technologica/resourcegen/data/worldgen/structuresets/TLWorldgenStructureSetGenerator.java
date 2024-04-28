package com.technologica.resourcegen.data.worldgen.structuresets;

import com.technologica.api.tlregen.resourcegen.data.worldgen.TLReGenWorldgenStructureSet;
import com.technologica.registration.key.TechnologicaStructureSets;
import com.technologica.registration.key.TechnologicaStructures;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

public class TLWorldgenStructureSetGenerator extends TLReGenWorldgenStructureSet {
	public static void bootstrap(BootstapContext<StructureSet> boostrapContextIn) {
		HolderGetter<Structure> structures = boostrapContextIn.lookup(Registries.STRUCTURE);
		boostrapContextIn.register(TechnologicaStructureSets.EL_DORADO, new StructureSet(structures.getOrThrow(TechnologicaStructures.EL_DORADO), new RandomSpreadStructurePlacement(24, 8, RandomSpreadType.LINEAR, 20083232)));
		boostrapContextIn.register(TechnologicaStructureSets.DOME, new StructureSet(structures.getOrThrow(TechnologicaStructures.DOME), new RandomSpreadStructurePlacement(24, 8, RandomSpreadType.LINEAR, 20083232)));
	}
}