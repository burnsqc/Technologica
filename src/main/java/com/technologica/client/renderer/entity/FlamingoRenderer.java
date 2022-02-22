package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.FlamingoModel;
import com.technologica.entity.passive.FlamingoEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class FlamingoRenderer extends MobRenderer<FlamingoEntity, FlamingoModel<FlamingoEntity>> {
	private static final ResourceLocation FLAMINGO_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/flamingo.png");

	public FlamingoRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new FlamingoModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(FlamingoEntity entity) {
		return FLAMINGO_TEXTURE;
	}
}
