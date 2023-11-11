package com.technologica.client.renderer.entity;

import com.technologica.client.model.CrabModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.animal.Crab;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CrabRenderer extends MobRenderer<Crab, CrabModel<Crab>> {
	private static final ResourceLocation CRAB_TEXTURE = new TechnologicaLocation("textures/entity/crab.png");

	public CrabRenderer(Context contextIn) {
		super(contextIn, new CrabModel<>(contextIn.bakeLayer(TechnologicaModelLayers.CRAB)), 0.3F);
	}

	@Override
	public ResourceLocation getTextureLocation(Crab crabIn) {
		return CRAB_TEXTURE;
	}
}