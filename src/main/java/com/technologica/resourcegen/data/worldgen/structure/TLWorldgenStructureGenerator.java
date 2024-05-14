package com.technologica.resourcegen.data.worldgen.structure;

import java.util.Map;

import com.technologica.api.tlregen.resourcegen.data.worldgen.TLReGenWorldgenStructure;
import com.technologica.registration.key.TechnologicaBiomeTags;
import com.technologica.registration.key.TechnologicaStructureTemplatePools;
import com.technologica.registration.key.TechnologicaStructures;
import com.technologica.world.level.levelgen.structure.structures.ElDoradoStructure;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;

public final class TLWorldgenStructureGenerator extends TLReGenWorldgenStructure {
	public static void bootstrap(BootstapContext<Structure> boostrapContextIn) {
		HolderGetter<Biome> biomes = boostrapContextIn.lookup(Registries.BIOME);
		HolderGetter<StructureTemplatePool> templates = boostrapContextIn.lookup(Registries.TEMPLATE_POOL);

		boostrapContextIn.register(TechnologicaStructures.EL_DORADO, new ElDoradoStructure(new Structure.StructureSettings(biomes.getOrThrow(TechnologicaBiomeTags.HAS_EL_DORADO), Map.of(), GenerationStep.Decoration.UNDERGROUND_DECORATION, TerrainAdjustment.NONE)));
		boostrapContextIn.register(TechnologicaStructures.DOME, new JigsawStructure(new Structure.StructureSettings(biomes.getOrThrow(TechnologicaBiomeTags.HAS_DOME), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), templates.getOrThrow(TechnologicaStructureTemplatePools.DOME), 6, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Heightmap.Types.WORLD_SURFACE_WG));
		boostrapContextIn.register(TechnologicaStructures.WHALE_CARCASS, new JigsawStructure(new Structure.StructureSettings(biomes.getOrThrow(TechnologicaBiomeTags.HAS_WHALE_CARCASS), Map.of(), GenerationStep.Decoration.UNDERGROUND_STRUCTURES, TerrainAdjustment.NONE), templates.getOrThrow(TechnologicaStructureTemplatePools.WHALE_CARCASS), 6, UniformHeight.of(VerticalAnchor.absolute(6), VerticalAnchor.absolute(32)), false, Heightmap.Types.OCEAN_FLOOR_WG));
	}
}
