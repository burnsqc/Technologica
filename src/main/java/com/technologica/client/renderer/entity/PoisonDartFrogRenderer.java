package com.technologica.client.renderer.entity;

import com.technologica.client.model.PoisonDartFrogModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.PoisonDartFrog;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class PoisonDartFrogRenderer extends MobRenderer<PoisonDartFrog, PoisonDartFrogModel<PoisonDartFrog>> {
	// private static final ResourceLocation POISON_DART_FROG_TEXTURE = new TechnologicaLocation("textures/entity/poison_dart_frog3.png");

	public PoisonDartFrogRenderer(Context contextIn) {
		super(contextIn, new PoisonDartFrogModel<>(contextIn.bakeLayer(TechnologicaModelLayers.POISON_DART_FROG)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(PoisonDartFrog poisonDartFrogIn) {
		return poisonDartFrogIn.getVariant().texture();
	}
}