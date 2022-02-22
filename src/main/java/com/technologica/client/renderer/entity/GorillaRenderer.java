package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.GorillaModel;
import com.technologica.entity.passive.GorillaEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class GorillaRenderer extends MobRenderer<GorillaEntity, GorillaModel<GorillaEntity>> {
	private static final ResourceLocation GORILLA_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/gorilla.png");

	public GorillaRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new GorillaModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(GorillaEntity entity) {
		return GORILLA_TEXTURE;
	}
}
