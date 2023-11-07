package com.technologica.datagen.data.worldgen.structure;

import java.util.Map;

import com.technologica.tags.TechnologicaBiomeTags;
import com.technologica.world.level.levelgen.structure.TechnologicaBuiltinStructures;
import com.technologica.world.level.levelgen.structure.structures.ElDoradoStructure;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.structures.NetherFortressStructure;

public class StructureDataGenerator {
	public static void bootstrap(BootstapContext<Structure> boostrapContextIn) {
		HolderGetter<Biome> biomes = boostrapContextIn.lookup(Registries.BIOME);
		boostrapContextIn.register(TechnologicaBuiltinStructures.EL_DORADO, new ElDoradoStructure(new Structure.StructureSettings(biomes.getOrThrow(TechnologicaBiomeTags.HAS_EL_DORADO), Map.of(MobCategory.MONSTER, new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.PIECE, NetherFortressStructure.FORTRESS_ENEMIES)), GenerationStep.Decoration.UNDERGROUND_DECORATION, TerrainAdjustment.NONE)));
	}
}