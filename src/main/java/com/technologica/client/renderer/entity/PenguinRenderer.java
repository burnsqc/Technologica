package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.PenguinModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Penguin;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class PenguinRenderer extends MobRenderer<Penguin, PenguinModel<Penguin>> {
	private static final ResourceLocation PENGUIN_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/penguin.png");

	public PenguinRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PenguinModel<>(renderManagerIn.bakeLayer(TechnologicaModelLayers.PENGUIN)), 0.4F);
	}

	@Override
	public ResourceLocation getTextureLocation(Penguin entity) {
		return PENGUIN_TEXTURE;
	}
}
