package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.ElephantModel;
import com.technologica.world.entity.animal.ElephantEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class ElephantRenderer extends MobRenderer<ElephantEntity, ElephantModel<ElephantEntity>> {
	private static final ResourceLocation ELEPHANT_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/elephant.png");

	public ElephantRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ElephantModel<>(renderManagerIn.bakeLayer(null)), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(ElephantEntity entity) {
		return ELEPHANT_TEXTURE;
	}
}
