package com.technologica.world.level.levelgen.structure.structures;

import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

public class TechnologicaStructureTemplatePools {
	public static final ResourceKey<StructureTemplatePool> DOME = ResourceKey.create(Registries.TEMPLATE_POOL, new TechnologicaLocation("dome"));
}
