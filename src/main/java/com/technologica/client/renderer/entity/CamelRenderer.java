package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.CamelModel;
import com.technologica.entity.passive.CamelEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class CamelRenderer extends MobRenderer<CamelEntity, CamelModel<CamelEntity>> {
	private static final ResourceLocation CAMEL_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/camel.png");

	public CamelRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new CamelModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(CamelEntity entity) {
		return CAMEL_TEXTURE;
	}
}
