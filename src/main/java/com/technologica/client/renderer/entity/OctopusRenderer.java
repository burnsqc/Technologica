package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.OctopusModel;
import com.technologica.world.entity.animal.Octopus;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class OctopusRenderer extends MobRenderer<Octopus, OctopusModel<Octopus>> {
	private static final ResourceLocation OCTOPUS_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/octopus.png");

	public OctopusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new OctopusModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(Octopus entity) {
		return OCTOPUS_TEXTURE;
	}
}
