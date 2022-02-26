package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.CrabModel;
import com.technologica.world.entity.animal.CrabEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class CrabRenderer extends MobRenderer<CrabEntity, CrabModel<CrabEntity>> {
	private static final ResourceLocation CRAB_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/crab.png");

	public CrabRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CrabModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(CrabEntity entity) {
		return CRAB_TEXTURE;
	}
}
