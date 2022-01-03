package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.LizardModel;
import com.technologica.entity.passive.LizardEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class LizardRenderer extends MobRenderer<LizardEntity, LizardModel<LizardEntity>> {
	private static final ResourceLocation LIZARD_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/lizard.png");

	public LizardRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new LizardModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getEntityTexture(LizardEntity entity) {
		return LIZARD_TEXTURE;
	}
}
