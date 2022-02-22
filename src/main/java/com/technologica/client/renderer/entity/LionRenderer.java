package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.LionModel;
import com.technologica.entity.passive.LionEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class LionRenderer extends MobRenderer<LionEntity, LionModel<LionEntity>> {
	private static final ResourceLocation LION_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/lion.png");

	public LionRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new LionModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(LionEntity entity) {
		return LION_TEXTURE;
	}
}
