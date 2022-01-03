package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.OwlModel;
import com.technologica.entity.passive.OwlEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class OwlRenderer extends MobRenderer<OwlEntity, OwlModel<OwlEntity>> {
	private static final ResourceLocation OWL_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/owl.png");

	public OwlRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new OwlModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getEntityTexture(OwlEntity entity) {
		return OWL_TEXTURE;
	}
}
