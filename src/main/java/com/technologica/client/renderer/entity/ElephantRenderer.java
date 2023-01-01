package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.ElephantModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Elephant;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class ElephantRenderer extends MobRenderer<Elephant, ElephantModel<Elephant>> {
	private static final ResourceLocation ELEPHANT_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/elephant.png");

	public ElephantRenderer(Context contextIn) {
		super(contextIn, new ElephantModel<>(contextIn.bakeLayer(TechnologicaModelLayers.ELEPHANT)), 1.8F);
	}

	@Override
	public ResourceLocation getTextureLocation(Elephant elephantIn) {
		return ELEPHANT_TEXTURE;
	}
}
