package com.technologica.data.worldgen;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.worldgen.PlainVillagePools;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.structures.StructurePoolElement;
import net.minecraft.world.level.levelgen.feature.structures.StructureTemplatePool;

public class TechnologicaPlainVillagePools {

	
	
	public static void bootstrap() {
//		PlainVillagePools.START.
	}

	static {
		Pools.register(new StructureTemplatePool(new ResourceLocation("village/plains/houses"),
				new ResourceLocation("village/plains/terminators"),
				ImmutableList.of(
						Pair.of(StructurePoolElement.legacy("village/plains/houses/plains_large_farm_1", TechnologicaProcessorLists.FARM_PLAINS_MODIFIED), 4),
						Pair.of(StructurePoolElement.legacy("village/plains/houses/plains_small_farm_1", TechnologicaProcessorLists.FARM_PLAINS_MODIFIED), 4)),
				StructureTemplatePool.Projection.RIGID));

	}
}