package com.technologica.client.renderer.entity;

import com.technologica.client.model.CobraModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.animal.Cobra;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class CobraRenderer extends MobRenderer<Cobra, CobraModel<Cobra>> {
	private static final ResourceLocation COBRA_TEXTURE = new TechnologicaLocation("textures/entity/cobra.png");

	public CobraRenderer(Context contextIn) {
		super(contextIn, new CobraModel<>(contextIn.bakeLayer(TechnologicaModelLayers.COBRA)), 0.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(Cobra cobraIn) {
		return COBRA_TEXTURE;
	}
}