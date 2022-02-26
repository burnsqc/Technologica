package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.DeerModel;
import com.technologica.world.entity.animal.DeerEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class DeerRenderer extends MobRenderer<DeerEntity, DeerModel<DeerEntity>> {
	private static final ResourceLocation DEER_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/deer.png");

	public DeerRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new DeerModel<>(), 1.1F);
	}

	public ResourceLocation getTextureLocation(DeerEntity entity) {
		return DEER_TEXTURE;
	}
}
