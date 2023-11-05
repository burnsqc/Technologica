package com.technologica.data.worldgen;

import java.util.Map;

import com.technologica.tags.TechnologicaBiomeTags;
import com.technologica.world.level.levelgen.structure.TechnologicaBuiltinStructures;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.structures.NetherFortressStructure;

public class TechnologicaStructures {
	private static Structure.StructureSettings structure(HolderSet<Biome> p_256015_, Map<MobCategory, StructureSpawnOverride> p_256297_, GenerationStep.Decoration p_255729_, TerrainAdjustment p_255865_) {
		return new Structure.StructureSettings(p_256015_, p_256297_, p_255729_, p_255865_);
	}

	public static void bootstrap(BootstapContext<Structure> boostrapContextIn) {
		HolderGetter<Biome> biomes = boostrapContextIn.lookup(Registries.BIOME);
		boostrapContextIn.register(TechnologicaBuiltinStructures.EL_DORADO, new NetherFortressStructure(structure(biomes.getOrThrow(TechnologicaBiomeTags.HAS_EL_DORADO), Map.of(MobCategory.MONSTER, new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.PIECE, NetherFortressStructure.FORTRESS_ENEMIES)), GenerationStep.Decoration.UNDERGROUND_DECORATION, TerrainAdjustment.NONE)));
	}
}
