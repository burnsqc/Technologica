package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.CrabModel;
import com.technologica.entity.passive.CrabEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class CrabRenderer extends MobRenderer<CrabEntity, CrabModel<CrabEntity>> {
	private static final ResourceLocation CRAB_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/crab.png");

	public CrabRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new CrabModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(CrabEntity entity) {
		return CRAB_TEXTURE;
	}
}
