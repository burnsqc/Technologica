package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.FrogModel;
import com.technologica.entity.passive.FrogEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class FrogRenderer extends MobRenderer<FrogEntity, FrogModel<FrogEntity>> {
	private static final ResourceLocation FROG_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/frog.png");

	public FrogRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new FrogModel<>(), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(FrogEntity entity) {
		return FROG_TEXTURE;
	}
}
