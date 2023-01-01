package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.PenguinModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Penguin;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class PenguinRenderer extends MobRenderer<Penguin, PenguinModel<Penguin>> {
	private static final ResourceLocation PENGUIN_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/penguin.png");

	public PenguinRenderer(Context contextIn) {
		super(contextIn, new PenguinModel<>(contextIn.bakeLayer(TechnologicaModelLayers.PENGUIN)), 0.3F);
	}

	@Override
	public ResourceLocation getTextureLocation(Penguin peguinIn) {
		return PENGUIN_TEXTURE;
	}
}
