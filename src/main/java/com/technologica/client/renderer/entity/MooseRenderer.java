package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.MooseModel;
import com.technologica.entity.passive.MooseEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class MooseRenderer extends MobRenderer<MooseEntity, MooseModel<MooseEntity>> {
	private static final ResourceLocation MOOSE_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/moose.png");

	public MooseRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new MooseModel<>(), 1.1F);
	}

	public ResourceLocation getTextureLocation(MooseEntity entity) {
		return MOOSE_TEXTURE;
	}
}
