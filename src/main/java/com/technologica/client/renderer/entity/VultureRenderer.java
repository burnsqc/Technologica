package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.VultureModel;
import com.technologica.entity.passive.VultureEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class VultureRenderer extends MobRenderer<VultureEntity, VultureModel<VultureEntity>> {
	private static final ResourceLocation VULTURE_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/vulture.png");

	public VultureRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new VultureModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getEntityTexture(VultureEntity entity) {
		return VULTURE_TEXTURE;
	}
}
