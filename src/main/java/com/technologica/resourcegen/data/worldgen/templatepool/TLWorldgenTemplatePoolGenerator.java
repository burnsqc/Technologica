package com.technologica.resourcegen.data.worldgen.templatepool;

import java.util.List;

import com.technologica.api.tlregen.resourcegen.data.worldgen.TLReGenWorldgenTemplatePool;
import com.technologica.api.tlregen.resourcegen.mirrors.TLReGenSinglePoolElement;
import com.technologica.registration.dynamic.TechnologicaStructureTemplatePools;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class TLWorldgenTemplatePoolGenerator extends TLReGenWorldgenTemplatePool {
	public static void bootstrap(BootstapContext<StructureTemplatePool> templatePool) {
		Holder<StructureTemplatePool> fallback = templatePool.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY);
		Holder<StructureProcessorList> empty = templatePool.lookup(Registries.PROCESSOR_LIST).getOrThrow(ProcessorLists.EMPTY);

		templatePool.register(TechnologicaStructureTemplatePools.DOME, templatePool(List.of(new TLReGenElement(new TLReGenSinglePoolElement(new TechnologicaLocation("dome"), empty, StructureTemplatePool.Projection.RIGID), 1)), fallback));
		// templatePool.register(TechnologicaStructureTemplatePools.WHALE_CARCASS, templatePool(List.of(new TLReGenElement(new TLReGenSinglePoolElement(new TechnologicaLocation("whale_carcass"), empty, StructureTemplatePool.Projection.RIGID), 1)), fallback));
	}

	@Override
	protected void populate() {
		// TODO Auto-generated method stub
	}
}
