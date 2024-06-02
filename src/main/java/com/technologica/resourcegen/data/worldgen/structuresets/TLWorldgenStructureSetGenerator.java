package com.technologica.resourcegen.data.worldgen.structuresets;

import java.util.List;

import com.technologica.api.tlregen.resourcegen.data.worldgen.TLReGenWorldgenStructureSet;
import com.technologica.registration.key.TechnologicaStructureSets;
import com.technologica.registration.key.TechnologicaStructures;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.StructureSet.StructureSelectionEntry;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

public class TLWorldgenStructureSetGenerator extends TLReGenWorldgenStructureSet {
	public static void bootstrap(BootstapContext<StructureSet> structureSet) {
		HolderGetter<Structure> structures = structureSet.lookup(Registries.STRUCTURE);

		structureSet.register(TechnologicaStructureSets.EL_DORADO, structureSet(new RandomSpreadStructurePlacement(24, 8, RandomSpreadType.LINEAR, 20083232), List.of(new StructureSelectionEntry(structures.getOrThrow(TechnologicaStructures.EL_DORADO), 1))));
		structureSet.register(TechnologicaStructureSets.DOME, structureSet(new RandomSpreadStructurePlacement(24, 8, RandomSpreadType.LINEAR, 20083232), List.of(new StructureSelectionEntry(structures.getOrThrow(TechnologicaStructures.DOME), 1))));
		structureSet.register(TechnologicaStructureSets.WHALE_CARCASS, structureSet(new RandomSpreadStructurePlacement(24, 8, RandomSpreadType.LINEAR, 74784298), List.of(new StructureSelectionEntry(structures.getOrThrow(TechnologicaStructures.WHALE_CARCASS), 1))));
	}

	@Override
	protected void populate() {
		// TODO Auto-generated method stub

	}
}