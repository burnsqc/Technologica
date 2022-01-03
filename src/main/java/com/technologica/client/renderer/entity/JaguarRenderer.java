package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.JaguarModel;
import com.technologica.entity.passive.JaguarEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class JaguarRenderer extends MobRenderer<JaguarEntity, JaguarModel<JaguarEntity>> {
	private static final ResourceLocation JAGUAR_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/jaguar.png");

	public JaguarRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new JaguarModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getEntityTexture(JaguarEntity entity) {
		return JAGUAR_TEXTURE;
	}
}
