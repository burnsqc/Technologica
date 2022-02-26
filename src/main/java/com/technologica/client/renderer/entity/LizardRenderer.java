package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.LizardModel;
import com.technologica.world.entity.animal.LizardEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class LizardRenderer extends MobRenderer<LizardEntity, LizardModel<LizardEntity>> {
	private static final ResourceLocation LIZARD_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/lizard.png");

	public LizardRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new LizardModel<>(renderManagerIn.bakeLayer(null)), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(LizardEntity entity) {
		return LIZARD_TEXTURE;
	}
}
