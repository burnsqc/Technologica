package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.FrogModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Frog;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class FrogRenderer extends MobRenderer<Frog, FrogModel<Frog>> {
	private static final ResourceLocation FROG_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/frog.png");

	public FrogRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new FrogModel<>(renderManagerIn.bakeLayer(TechnologicaModelLayers.FROG)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(Frog entity) {
		return FROG_TEXTURE;
	}
}
