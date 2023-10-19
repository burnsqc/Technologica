package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.SharkModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Shark;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SharkRenderer extends MobRenderer<Shark, SharkModel<Shark>> {
	private static final ResourceLocation SHARK_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/shark.png");

	public SharkRenderer(Context contextIn) {
		super(contextIn, new SharkModel<>(contextIn.bakeLayer(TechnologicaModelLayers.SHARK)), 0.7F);
	}

	@Override
	public ResourceLocation getTextureLocation(Shark sharkIn) {
		return SHARK_TEXTURE;
	}
}