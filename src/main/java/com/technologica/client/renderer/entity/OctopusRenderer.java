package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.OctopusModel;
import com.technologica.entity.passive.OctopusEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class OctopusRenderer extends MobRenderer<OctopusEntity, OctopusModel<OctopusEntity>> {
	private static final ResourceLocation OCTOPUS_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/octopus.png");

	public OctopusRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new OctopusModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(OctopusEntity entity) {
		return OCTOPUS_TEXTURE;
	}
}
