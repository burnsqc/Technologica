package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.VultureModel;
import com.technologica.world.entity.animal.VultureEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class VultureRenderer extends MobRenderer<VultureEntity, VultureModel<VultureEntity>> {
	private static final ResourceLocation VULTURE_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/vulture.png");

	public VultureRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new VultureModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(VultureEntity entity) {
		return VULTURE_TEXTURE;
	}
}
