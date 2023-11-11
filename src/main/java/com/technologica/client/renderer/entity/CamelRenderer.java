package com.technologica.client.renderer.entity;

import com.technologica.client.model.CamelModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.animal.Camel;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class CamelRenderer extends MobRenderer<Camel, CamelModel<Camel>> {
	private static final ResourceLocation CAMEL_TEXTURE = new TechnologicaLocation("textures/entity/camel.png");

	public CamelRenderer(Context contextIn) {
		super(contextIn, new CamelModel<>(contextIn.bakeLayer(TechnologicaModelLayers.CAMEL)), 0.7F);
	}

	@Override
	public ResourceLocation getTextureLocation(Camel camelIn) {
		return CAMEL_TEXTURE;
	}
}