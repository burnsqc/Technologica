package com.technologica.client.renderer.entity;

import com.technologica.client.model.DeerModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.animal.Deer;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class DeerRenderer extends MobRenderer<Deer, DeerModel<Deer>> {
	private static final ResourceLocation DEER_TEXTURE = new TechnologicaLocation("textures/entity/deer.png");

	public DeerRenderer(Context contextIn) {
		super(contextIn, new DeerModel<>(contextIn.bakeLayer(TechnologicaModelLayers.DEER)), 0.6F);
	}

	@Override
	public ResourceLocation getTextureLocation(Deer deerIn) {
		return DEER_TEXTURE;
	}
}