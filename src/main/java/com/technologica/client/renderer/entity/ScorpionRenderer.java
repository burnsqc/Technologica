package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.ScorpionModel;
import com.technologica.world.entity.animal.Scorpion;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ScorpionRenderer<T extends Scorpion> extends MobRenderer<T, ScorpionModel<T>> {
	private static final ResourceLocation SCORPION_TEXTURE = new ResourceLocation(Technologica.MODID,
			"textures/entity/scorpion.png");

	public ScorpionRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ScorpionModel<>(), 0.8F);
	}

	protected float getFlipDegrees(T entityLivingBaseIn) {
		return 180.0F;
	}

	public ResourceLocation getTextureLocation(T entity) {
		return SCORPION_TEXTURE;
	}
}
