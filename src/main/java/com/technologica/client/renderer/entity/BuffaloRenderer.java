package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.BuffaloModel;
import com.technologica.entity.passive.BuffaloEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class BuffaloRenderer extends MobRenderer<BuffaloEntity, BuffaloModel<BuffaloEntity>> {
	private static final ResourceLocation BUFFALO_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/buffalo.png");

	public BuffaloRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new BuffaloModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(BuffaloEntity entity) {
		return BUFFALO_TEXTURE;
	}
}
