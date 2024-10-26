package com.technologica.registration.dynamic;

import java.util.Map;

import com.technologica.Technologica;
import com.technologica.api.tlregen.resourcegen.data.worldgen.TLReGenWorldgenStructure;
import com.technologica.world.level.levelgen.structure.structures.DeepSeaStructure;
import com.technologica.world.level.levelgen.structure.structures.ElDoradoStructure;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;

public final class TechnologicaStructures {
	public static final ResourceKey<Structure> EL_DORADO = Technologica.STRUCTURES.register("el_dorado", () -> new ElDoradoStructure(new Structure.StructureSettings(TLReGenWorldgenStructure.bootstrapContext.lookup(Registries.BIOME).getOrThrow(TechnologicaBiomeTags.HAS_EL_DORADO), Map.of(), GenerationStep.Decoration.UNDERGROUND_DECORATION, TerrainAdjustment.NONE)));
	public static final ResourceKey<Structure> DOME = Technologica.STRUCTURES.register("dome", () -> new JigsawStructure(new Structure.StructureSettings(TLReGenWorldgenStructure.bootstrapContext.lookup(Registries.BIOME).getOrThrow(TechnologicaBiomeTags.HAS_DOME), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), TLReGenWorldgenStructure.bootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(TechnologicaStructureTemplatePools.DOME), 6, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Heightmap.Types.WORLD_SURFACE_WG));
	public static final ResourceKey<Structure> WHALE_CARCASS = Technologica.STRUCTURES.register("whale_carcass", () -> new DeepSeaStructure(new Structure.StructureSettings(TLReGenWorldgenStructure.bootstrapContext.lookup(Registries.BIOME).getOrThrow(TechnologicaBiomeTags.HAS_WHALE_CARCASS), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.NONE), UniformHeight.of(VerticalAnchor.absolute(6), VerticalAnchor.absolute(32))));
}
