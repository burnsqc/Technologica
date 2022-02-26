package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.BuffaloModel;
import com.technologica.world.entity.animal.BuffaloEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class BuffaloRenderer extends MobRenderer<BuffaloEntity, BuffaloModel<BuffaloEntity>> {
	private static final ResourceLocation BUFFALO_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/buffalo.png");

	public BuffaloRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new BuffaloModel<>(renderManagerIn.bakeLayer(null)), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(BuffaloEntity entity) {
		return BUFFALO_TEXTURE;
	}
}
