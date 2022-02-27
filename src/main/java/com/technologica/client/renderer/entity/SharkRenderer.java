package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.SharkModel;
import com.technologica.world.entity.animal.Shark;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SharkRenderer extends MobRenderer<Shark, SharkModel<Shark>> {
	private static final ResourceLocation SHARK_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/shark.png");

	public SharkRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SharkModel<>(), 0.7F);
	}

	public ResourceLocation getTextureLocation(Shark entity) {
		return SHARK_TEXTURE;
	}
}
