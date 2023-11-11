package com.technologica.client.renderer.entity;

import com.technologica.client.model.StingrayModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.animal.Stingray;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class StingrayRenderer extends MobRenderer<Stingray, StingrayModel<Stingray>> {
	private static final ResourceLocation STINGRAY_TEXTURE = new TechnologicaLocation("textures/entity/stingray.png");

	public StingrayRenderer(Context contextIn) {
		super(contextIn, new StingrayModel<>(contextIn.bakeLayer(TechnologicaModelLayers.STINGRAY)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(Stingray stingrayIn) {
		return STINGRAY_TEXTURE;
	}
}