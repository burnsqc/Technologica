package com.technologica.client.renderer.entity;

import com.technologica.client.model.CottonmouthModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.animal.Cottonmouth;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class CottonmouthRenderer extends MobRenderer<Cottonmouth, CottonmouthModel<Cottonmouth>> {
	private static final ResourceLocation COTTONMOUTH_TEXTURE = new TechnologicaLocation("textures/entity/cottonmouth.png");

	public CottonmouthRenderer(Context contextIn) {
		super(contextIn, new CottonmouthModel<>(contextIn.bakeLayer(TechnologicaModelLayers.COTTONMOUTH)), 0.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(Cottonmouth cottonmouthIn) {
		return COTTONMOUTH_TEXTURE;
	}
}