package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.FrogModel;
import com.technologica.world.entity.animal.FrogEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class FrogRenderer extends MobRenderer<FrogEntity, FrogModel<FrogEntity>> {
	private static final ResourceLocation FROG_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/frog.png");

	public FrogRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new FrogModel<>(renderManagerIn.bakeLayer(null)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(FrogEntity entity) {
		return FROG_TEXTURE;
	}
}
