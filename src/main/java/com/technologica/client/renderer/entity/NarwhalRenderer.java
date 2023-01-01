package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.NarwhalModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Narwhal;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class NarwhalRenderer extends MobRenderer<Narwhal, NarwhalModel<Narwhal>> {
	private static final ResourceLocation NARWHAL_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/narwhal.png");

	public NarwhalRenderer(Context contextIn) {
		super(contextIn, new NarwhalModel<>(contextIn.bakeLayer(TechnologicaModelLayers.NARWHAL)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(Narwhal narwhalIn) {
		return NARWHAL_TEXTURE;
	}
}
