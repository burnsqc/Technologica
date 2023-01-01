package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.GorillaModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Gorilla;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class GorillaRenderer extends MobRenderer<Gorilla, GorillaModel<Gorilla>> {
	private static final ResourceLocation GORILLA_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/gorilla.png");

	public GorillaRenderer(Context contextIn) {
		super(contextIn, new GorillaModel<>(contextIn.bakeLayer(TechnologicaModelLayers.GORILLA)), 0.7F);
	}

	@Override
	public ResourceLocation getTextureLocation(Gorilla gorillaIn) {
		return GORILLA_TEXTURE;
	}
}
