package com.technologica.registration.key;

import com.technologica.api.tlregen.registration.MasterKeyCreator;
import com.technologica.resourcegen.data.worldgen.templatepool.TLWorldgenTemplatePoolGenerator;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

/**
 * <p>
 * This class contains Resource Keys for Structure Template Pools.
 * The corresponding Structure Template Pools are created in json format during Data Generation in {@link TLWorldgenTemplatePoolGenerator}.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaStructureTemplatePools extends MasterKeyCreator {
	public static final ResourceKey<StructureTemplatePool> DOME = structureTemplatePool("dome");
	public static final ResourceKey<StructureTemplatePool> WHALE_CARCASS = structureTemplatePool("whale_carcass");
}