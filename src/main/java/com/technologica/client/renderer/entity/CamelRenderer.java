package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.CamelModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Camel;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class CamelRenderer extends MobRenderer<Camel, CamelModel<Camel>> {
	private static final ResourceLocation CAMEL_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/camel.png");

	public CamelRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CamelModel<>(renderManagerIn.bakeLayer(TechnologicaModelLayers.CAMEL)), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(Camel entity) {
		return CAMEL_TEXTURE;
	}
}
