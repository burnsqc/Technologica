package com.technologica.registration.key;

import com.technologica.registration.key.util.MasterKeyCreator;
import com.technologica.resourcegen.data.worldgen.templatepool.TemplatePoolProvider;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

/**
 * <p>
 * This class contains Resource Keys for Structure Template Pools.
 * The corresponding Structure Template Pools are created in json format during Data Generation in {@link TemplatePoolProvider}.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaStructureTemplatePools extends MasterKeyCreator {
	public static final ResourceKey<StructureTemplatePool> DOME = structureTemplatePool("dome");
}