package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.CamelModel;
import com.technologica.world.entity.animal.CamelEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class CamelRenderer extends MobRenderer<CamelEntity, CamelModel<CamelEntity>> {
	private static final ResourceLocation CAMEL_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/camel.png");

	public CamelRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CamelModel<>(renderManagerIn.bakeLayer(null)), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(CamelEntity entity) {
		return CAMEL_TEXTURE;
	}
}
