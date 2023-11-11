package com.technologica.client.renderer.entity;

import com.technologica.client.model.OstrichModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.animal.Ostrich;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class OstrichRenderer extends MobRenderer<Ostrich, OstrichModel<Ostrich>> {
	private static final ResourceLocation OSTRICH_TEXTURE = new TechnologicaLocation("textures/entity/ostrich.png");

	public OstrichRenderer(Context contextIn) {
		super(contextIn, new OstrichModel<>(contextIn.bakeLayer(TechnologicaModelLayers.OSTRICH)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(Ostrich ostrichIn) {
		return OSTRICH_TEXTURE;
	}
}