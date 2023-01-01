package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.LionModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Lion;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class LionRenderer extends MobRenderer<Lion, LionModel<Lion>> {
	private static final ResourceLocation LION_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/lion.png");

	public LionRenderer(Context contextIn) {
		super(contextIn, new LionModel<>(contextIn.bakeLayer(TechnologicaModelLayers.LION)), 0.7F);
	}

	@Override
	public ResourceLocation getTextureLocation(Lion lionIn) {
		return LION_TEXTURE;
	}
}
