package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.StingrayModel;
import com.technologica.world.entity.animal.StingrayEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class StingrayRenderer extends MobRenderer<StingrayEntity, StingrayModel<StingrayEntity>> {
	private static final ResourceLocation STINGRAY_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/stingray.png");

	public StingrayRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new StingrayModel<>(), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(StingrayEntity entity) {
		return STINGRAY_TEXTURE;
	}
}
