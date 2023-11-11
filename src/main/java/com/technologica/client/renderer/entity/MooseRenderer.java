package com.technologica.client.renderer.entity;

import com.technologica.client.model.MooseModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.animal.Moose;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class MooseRenderer extends MobRenderer<Moose, MooseModel<Moose>> {
	private static final ResourceLocation MOOSE_TEXTURE = new TechnologicaLocation("textures/entity/moose.png");

	public MooseRenderer(Context contextIn) {
		super(contextIn, new MooseModel<>(contextIn.bakeLayer(TechnologicaModelLayers.MOOSE)), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(Moose mooseIn) {
		return MOOSE_TEXTURE;
	}
}