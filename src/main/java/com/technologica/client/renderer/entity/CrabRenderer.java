package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.CrabModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Crab;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CrabRenderer<T extends Crab> extends MobRenderer<T, CrabModel<T>> {
	private static final ResourceLocation CRAB_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/crab.png");

	public CrabRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CrabModel<>(renderManagerIn.bakeLayer(TechnologicaModelLayers.CRAB)), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(Crab entity) {
		return CRAB_TEXTURE;
	}
}