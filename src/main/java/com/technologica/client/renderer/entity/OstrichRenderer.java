package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.OstrichModel;
import com.technologica.world.entity.animal.Ostrich;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class OstrichRenderer extends MobRenderer<Ostrich, OstrichModel<Ostrich>> {
	private static final ResourceLocation OSTRICH_TEXTURE = new ResourceLocation(Technologica.MODID,
			"textures/entity/ostrich.png");

	public OstrichRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new OstrichModel<>(), 1.0F);
	}

	public ResourceLocation getTextureLocation(Ostrich entity) {
		return OSTRICH_TEXTURE;
	}
}