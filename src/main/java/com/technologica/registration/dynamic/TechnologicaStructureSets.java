package com.technologica.registration.dynamic;

import java.util.List;

import com.technologica.Technologica;
import com.tlregen.api.resourcegen.data.worldgen.TLReGenWorldgenStructureSet;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.StructureSet.StructureSelectionEntry;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;

public final class TechnologicaStructureSets {
	public static final ResourceKey<StructureSet> EL_DORADO = Technologica.STRUCTURE_SETS.register("el_dorado", () -> structureSet(new RandomSpreadStructurePlacement(24, 8, RandomSpreadType.LINEAR, 20083232), List.of(new StructureSelectionEntry(TLReGenWorldgenStructureSet.bootstrapContext.lookup(Registries.STRUCTURE).getOrThrow(TechnologicaStructures.EL_DORADO), 1))));
	public static final ResourceKey<StructureSet> DOME = Technologica.STRUCTURE_SETS.register("dome", () -> structureSet(new RandomSpreadStructurePlacement(24, 8, RandomSpreadType.LINEAR, 20083232), List.of(new StructureSelectionEntry(TLReGenWorldgenStructureSet.bootstrapContext.lookup(Registries.STRUCTURE).getOrThrow(TechnologicaStructures.DOME), 1))));
	public static final ResourceKey<StructureSet> WHALE_CARCASS = Technologica.STRUCTURE_SETS.register("whale_carcass", () -> structureSet(new RandomSpreadStructurePlacement(2, 1, RandomSpreadType.LINEAR, 74784298), List.of(new StructureSelectionEntry(TLReGenWorldgenStructureSet.bootstrapContext.lookup(Registries.STRUCTURE).getOrThrow(TechnologicaStructures.WHALE_CARCASS), 1))));

	protected static StructureSet structureSet(StructurePlacement placement, List<StructureSet.StructureSelectionEntry> structures) {
		return new StructureSet(structures, placement);
	}
}
