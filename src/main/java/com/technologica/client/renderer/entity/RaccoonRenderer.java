package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.layers.RaccoonHeldItemLayer;
import com.technologica.client.renderer.entity.model.RaccoonModel;
import com.technologica.entity.passive.RaccoonEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class RaccoonRenderer extends MobRenderer<RaccoonEntity, RaccoonModel<RaccoonEntity>> {
	private static final ResourceLocation RACCOON_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/raccoon.png");

	public RaccoonRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new RaccoonModel<>(), 0.8F);
		this.addLayer(new RaccoonHeldItemLayer(this));
	}

	@Override
	public ResourceLocation getEntityTexture(RaccoonEntity entity) {
		return RACCOON_TEXTURE;
	}
}
