package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.RaccoonModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.client.renderer.entity.layers.RaccoonHeldItemLayer;
import com.technologica.world.entity.animal.RaccoonEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class RaccoonRenderer extends MobRenderer<RaccoonEntity, RaccoonModel<RaccoonEntity>> {
	private static final ResourceLocation RACCOON_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/raccoon.png");

	public RaccoonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new RaccoonModel<>(renderManagerIn.bakeLayer(TechnologicaModelLayers.RACCOON)), 0.8F);
		this.addLayer(new RaccoonHeldItemLayer(this));
	}

	@Override
	public ResourceLocation getTextureLocation(RaccoonEntity entity) {
		return RACCOON_TEXTURE;
	}
}
