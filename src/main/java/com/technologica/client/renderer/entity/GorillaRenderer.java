package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.GorillaModel;
import com.technologica.world.entity.animal.GorillaEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class GorillaRenderer extends MobRenderer<GorillaEntity, GorillaModel<GorillaEntity>> {
	private static final ResourceLocation GORILLA_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/gorilla.png");

	public GorillaRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new GorillaModel<>(renderManagerIn.bakeLayer(null)), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(GorillaEntity entity) {
		return GORILLA_TEXTURE;
	}
}
