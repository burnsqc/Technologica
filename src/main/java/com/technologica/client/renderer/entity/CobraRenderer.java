package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.CobraModel;
import com.technologica.world.entity.animal.Cobra;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class CobraRenderer extends MobRenderer<Cobra, CobraModel<Cobra>> {
	private static final ResourceLocation COBRA_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/cobra.png");

	public CobraRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CobraModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(Cobra entity) {
		return COBRA_TEXTURE;
	}
}
