package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.ElephantModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Elephant;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class ElephantRenderer extends MobRenderer<Elephant, ElephantModel<Elephant>> {
	private static final ResourceLocation ELEPHANT_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/elephant.png");

	public ElephantRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ElephantModel<>(renderManagerIn.bakeLayer(TechnologicaModelLayers.ELEPHANT)), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(Elephant entity) {
		return ELEPHANT_TEXTURE;
	}
}
