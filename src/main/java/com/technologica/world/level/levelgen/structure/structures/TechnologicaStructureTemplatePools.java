package com.technologica.world.level.levelgen.structure.structures;

import com.technologica.Technologica;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

public class TechnologicaStructureTemplatePools {
	public static final ResourceKey<StructureTemplatePool> DOME = ResourceKey.create(Registries.TEMPLATE_POOL, new ResourceLocation(Technologica.MODID, "dome"));
}
