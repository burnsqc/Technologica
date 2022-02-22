package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.ScorpionModel;
import com.technologica.entity.passive.ScorpionEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ScorpionRenderer<T extends ScorpionEntity> extends MobRenderer<T, ScorpionModel<T>> {
	private static final ResourceLocation SCORPION_TEXTURE = new ResourceLocation(Technologica.MODID,"textures/entity/scorpion.png");

	public ScorpionRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ScorpionModel<>(), 0.8F);
	}

	protected float getFlipDegrees(T entityLivingBaseIn) {
		return 180.0F;
	}

	public ResourceLocation getTextureLocation(T entity) {
		return SCORPION_TEXTURE;
	}
}
