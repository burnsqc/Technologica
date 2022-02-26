package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.PoisonDartFrogModel;
import com.technologica.world.entity.animal.PoisonDartFrogEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class PoisonDartFrogRenderer extends MobRenderer<PoisonDartFrogEntity, PoisonDartFrogModel<PoisonDartFrogEntity>> {
	private static final ResourceLocation POISON_DART_FROG_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/poison_dart_frog.png");

	public PoisonDartFrogRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PoisonDartFrogModel<>(renderManagerIn.bakeLayer(null)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(PoisonDartFrogEntity entity) {
		return POISON_DART_FROG_TEXTURE;
	}
}
