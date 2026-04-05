package com.technologica.registration.dynamic;

import java.util.ArrayList;
import java.util.List;

import com.mojang.datafixers.util.Pair;
import com.technologica.Technologica;
import com.technologica.util.text.TechnologicaLocation;
import com.tlregen.api.resourcegen.data.worldgen.TLReGenWorldgenTemplatePool;
import com.tlregen.api.resourcegen.util.TLReGenSinglePoolElement;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

public final class TechnologicaStructureTemplatePools {
	public static final ResourceKey<StructureTemplatePool> DOME = Technologica.STRUCTURE_TEMPLATE_POOL.register("dome", () -> templatePool(List.of(new TLReGenElement(new TLReGenSinglePoolElement(new TechnologicaLocation("dome"), TLReGenWorldgenTemplatePool.bootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(ProcessorLists.EMPTY), StructureTemplatePool.Projection.RIGID), 1)), TLReGenWorldgenTemplatePool.bootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY)));
	public static final ResourceKey<StructureTemplatePool> WHALE_CARCASS = Technologica.STRUCTURE_TEMPLATE_POOL.register("whale_carcass", () -> templatePool(List.of(new TLReGenElement(new TLReGenSinglePoolElement(new TechnologicaLocation("whale_carcass"), TLReGenWorldgenTemplatePool.bootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(ProcessorLists.EMPTY), StructureTemplatePool.Projection.RIGID), 1)), TLReGenWorldgenTemplatePool.bootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY)));

	protected static StructureTemplatePool templatePool(List<TLReGenElement> elements, Holder<StructureTemplatePool> fallback) {
		List<Pair<StructurePoolElement, Integer>> list = new ArrayList<>();
		for (TLReGenElement element : elements) {
			list.add(Pair.of(element.element, element.weight));
		}
		return new StructureTemplatePool(fallback, list);
	}

	public record TLReGenElement(StructurePoolElement element, int weight) {
	}
}
