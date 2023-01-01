package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.OctopusModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Octopus;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class OctopusRenderer extends MobRenderer<Octopus, OctopusModel<Octopus>> {
	private static final ResourceLocation OCTOPUS_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/octopus.png");

	public OctopusRenderer(Context contextIn) {
		super(contextIn, new OctopusModel<>(contextIn.bakeLayer(TechnologicaModelLayers.OCTOPUS)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(Octopus octopusIn) {
		return OCTOPUS_TEXTURE;
	}
}
