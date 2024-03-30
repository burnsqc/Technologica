package com.technologica.resourcegen.data.worldgen.templatepool;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.technologica.Technologica;
import com.technologica.api.tlregen.resourcegen.TLRGWorldgenTemplatePoolGenerator;
import com.technologica.registration.key.TechnologicaStructureTemplatePools;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class TLWorldgenTemplatePoolGenerator extends TLRGWorldgenTemplatePoolGenerator {
	public static void bootstrap(BootstapContext<StructureTemplatePool> boostrapContextIn) {
		HolderGetter<StructureTemplatePool> holdergetter1 = boostrapContextIn.lookup(Registries.TEMPLATE_POOL);
		Holder<StructureTemplatePool> holder1 = holdergetter1.getOrThrow(Pools.EMPTY);
		HolderGetter<StructureProcessorList> processors = boostrapContextIn.lookup(Registries.PROCESSOR_LIST);
		Holder<StructureProcessorList> empty = processors.getOrThrow(ProcessorLists.EMPTY);
		boostrapContextIn.register(TechnologicaStructureTemplatePools.DOME, new StructureTemplatePool(holder1, ImmutableList.of(Pair.of(StructurePoolElement.single(Technologica.MOD_ID + ":dome", empty), 1)), StructureTemplatePool.Projection.RIGID));
	}
}
