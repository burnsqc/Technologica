package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.TurkeyModel;
import com.technologica.entity.passive.TurkeyEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class TurkeyRenderer extends MobRenderer<TurkeyEntity, TurkeyModel<TurkeyEntity>> {
	private static final ResourceLocation TURKEY_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/turkey.png");

	public TurkeyRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new TurkeyModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getEntityTexture(TurkeyEntity entity) {
		return TURKEY_TEXTURE;
	}
}
