package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.DeerModel;
import com.technologica.entity.passive.DeerEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class DeerRenderer extends MobRenderer<DeerEntity, DeerModel<DeerEntity>> {
	private static final ResourceLocation DEER_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/deer.png");

	public DeerRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new DeerModel<>(), 1.1F);
	}

	public ResourceLocation getEntityTexture(DeerEntity entity) {
		return DEER_TEXTURE;
	}
}
