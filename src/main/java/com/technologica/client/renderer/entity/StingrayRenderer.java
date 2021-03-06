package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.StingrayModel;
import com.technologica.entity.passive.StingrayEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class StingrayRenderer extends MobRenderer<StingrayEntity, StingrayModel<StingrayEntity>> {
	private static final ResourceLocation STINGRAY_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/stingray.png");

	public StingrayRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new StingrayModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getEntityTexture(StingrayEntity entity) {
		return STINGRAY_TEXTURE;
	}
}
