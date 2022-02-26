package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.MooseModel;
import com.technologica.world.entity.animal.MooseEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class MooseRenderer extends MobRenderer<MooseEntity, MooseModel<MooseEntity>> {
	private static final ResourceLocation MOOSE_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/moose.png");

	public MooseRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new MooseModel<>(), 1.1F);
	}

	public ResourceLocation getTextureLocation(MooseEntity entity) {
		return MOOSE_TEXTURE;
	}
}
