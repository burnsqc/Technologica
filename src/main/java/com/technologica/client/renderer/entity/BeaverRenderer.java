package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.BeaverModel;
import com.technologica.entity.passive.BeaverEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class BeaverRenderer extends MobRenderer<BeaverEntity, BeaverModel<BeaverEntity>> {
	private static final ResourceLocation BEAVER_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/beaver.png");

	public BeaverRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new BeaverModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(BeaverEntity entity) {
		return BEAVER_TEXTURE;
	}
}
