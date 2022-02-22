package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.PenguinModel;
import com.technologica.entity.passive.PenguinEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class PenguinRenderer extends MobRenderer<PenguinEntity, PenguinModel<PenguinEntity>> {
	private static final ResourceLocation PENGUIN_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/penguin.png");

	public PenguinRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new PenguinModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(PenguinEntity entity) {
		return PENGUIN_TEXTURE;
	}
}
