package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.BeaverModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Beaver;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class BeaverRenderer extends MobRenderer<Beaver, BeaverModel<Beaver>> {
	private static final ResourceLocation BEAVER_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/beaver.png");

	public BeaverRenderer(Context contextIn) {
		super(contextIn, new BeaverModel<>(contextIn.bakeLayer(TechnologicaModelLayers.BEAVER)), 0.3F);
	}

	@Override
	public ResourceLocation getTextureLocation(Beaver beaverIn) {
		return BEAVER_TEXTURE;
	}
}
