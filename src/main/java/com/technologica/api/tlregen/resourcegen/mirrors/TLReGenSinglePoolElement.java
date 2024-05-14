package com.technologica.api.tlregen.resourcegen.mirrors;

import com.mojang.datafixers.util.Either;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

public class TLReGenSinglePoolElement extends SinglePoolElement {
	public TLReGenSinglePoolElement(Either<ResourceLocation, StructureTemplate> p_210415_, Holder<StructureProcessorList> p_210416_, StructureTemplatePool.Projection p_210417_) {
		super(p_210415_, p_210416_, p_210417_);
	}

	public TLReGenSinglePoolElement(ResourceLocation location, Holder<StructureProcessorList> processors, StructureTemplatePool.Projection projection) {
		super(Either.left(location), processors, projection);
	}
}