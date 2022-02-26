package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.SharkModel;
import com.technologica.world.entity.animal.SharkEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SharkRenderer extends MobRenderer<SharkEntity, SharkModel<SharkEntity>> {
	private static final ResourceLocation SHARK_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/shark.png");

	public SharkRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SharkModel<>(), 0.7F);
	}

	public ResourceLocation getTextureLocation(SharkEntity entity) {
		return SHARK_TEXTURE;
	}
}
