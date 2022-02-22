package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.CottonmouthModel;
import com.technologica.entity.passive.CottonmouthEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class CottonmouthRenderer extends MobRenderer<CottonmouthEntity, CottonmouthModel<CottonmouthEntity>> {
	private static final ResourceLocation COTTONMOUTH_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/cottonmouth.png");

	public CottonmouthRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new CottonmouthModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(CottonmouthEntity entity) {
		return COTTONMOUTH_TEXTURE;
	}
}
