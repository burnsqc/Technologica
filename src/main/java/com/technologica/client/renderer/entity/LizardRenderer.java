package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.LizardModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Lizard;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class LizardRenderer extends MobRenderer<Lizard, LizardModel<Lizard>> {
	private static final ResourceLocation LIZARD_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/lizard.png");

	public LizardRenderer(Context contextIn) {
		super(contextIn, new LizardModel<>(contextIn.bakeLayer(TechnologicaModelLayers.LIZARD)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(Lizard lizardIn) {
		return LIZARD_TEXTURE;
	}
}