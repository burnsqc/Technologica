package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.PoisonDartFrogModel;
import com.technologica.entity.passive.PoisonDartFrogEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class PoisonDartFrogRenderer extends MobRenderer<PoisonDartFrogEntity, PoisonDartFrogModel<PoisonDartFrogEntity>> {
	private static final ResourceLocation POISON_DART_FROG_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/poison_dart_frog.png");

	public PoisonDartFrogRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new PoisonDartFrogModel<>(), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(PoisonDartFrogEntity entity) {
		return POISON_DART_FROG_TEXTURE;
	}
}
