package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.CobraModel;
import com.technologica.entity.passive.CobraEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class CobraRenderer extends MobRenderer<CobraEntity, CobraModel<CobraEntity>> {
	private static final ResourceLocation COBRA_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/cobra.png");

	public CobraRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new CobraModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getEntityTexture(CobraEntity entity) {
		return COBRA_TEXTURE;
	}
}
