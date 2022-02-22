package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.ElephantModel;
import com.technologica.entity.passive.ElephantEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class ElephantRenderer extends MobRenderer<ElephantEntity, ElephantModel<ElephantEntity>> {
	private static final ResourceLocation ELEPHANT_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/elephant.png");

	public ElephantRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ElephantModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(ElephantEntity entity) {
		return ELEPHANT_TEXTURE;
	}
}
