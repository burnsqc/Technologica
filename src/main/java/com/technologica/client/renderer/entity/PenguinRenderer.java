package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.PenguinModel;
import com.technologica.world.entity.animal.PenguinEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class PenguinRenderer extends MobRenderer<PenguinEntity, PenguinModel<PenguinEntity>> {
	private static final ResourceLocation PENGUIN_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/penguin.png");

	public PenguinRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PenguinModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(PenguinEntity entity) {
		return PENGUIN_TEXTURE;
	}
}
