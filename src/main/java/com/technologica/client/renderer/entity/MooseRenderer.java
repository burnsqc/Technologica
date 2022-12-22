package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.MooseModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Moose;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class MooseRenderer extends MobRenderer<Moose, MooseModel<Moose>> {
	private static final ResourceLocation MOOSE_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/moose.png");

	public MooseRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new MooseModel<>(renderManagerIn.bakeLayer(TechnologicaModelLayers.MOOSE)), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(Moose entity) {
		return MOOSE_TEXTURE;
	}
}
