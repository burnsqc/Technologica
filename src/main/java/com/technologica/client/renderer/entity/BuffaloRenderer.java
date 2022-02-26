package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.BuffaloModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Buffalo;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class BuffaloRenderer extends MobRenderer<Buffalo, BuffaloModel<Buffalo>> {
	private static final ResourceLocation BUFFALO_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/buffalo.png");

	public BuffaloRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new BuffaloModel<>(renderManagerIn.bakeLayer(TechnologicaModelLayers.BUFFALO)), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(Buffalo entity) {
		return BUFFALO_TEXTURE;
	}
}
