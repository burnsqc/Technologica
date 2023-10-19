package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.RaccoonModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.client.renderer.entity.layers.RaccoonHeldItemLayer;
import com.technologica.world.entity.animal.Raccoon;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class RaccoonRenderer extends MobRenderer<Raccoon, RaccoonModel<Raccoon>> {
	private static final ResourceLocation RACCOON_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/raccoon.png");

	public RaccoonRenderer(Context contextIn) {
		super(contextIn, new RaccoonModel<>(contextIn.bakeLayer(TechnologicaModelLayers.RACCOON)), 0.4F);
		this.addLayer(new RaccoonHeldItemLayer(this));
	}

	@Override
	public ResourceLocation getTextureLocation(Raccoon raccoonIn) {
		return RACCOON_TEXTURE;
	}
}