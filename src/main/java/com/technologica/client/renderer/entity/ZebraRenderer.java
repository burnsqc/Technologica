package com.technologica.client.renderer.entity;

import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.animal.Zebra;

import net.minecraft.client.model.HorseModel;
import net.minecraft.client.renderer.entity.AbstractHorseRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public final class ZebraRenderer extends AbstractHorseRenderer<Zebra, HorseModel<Zebra>> {
	private static final ResourceLocation ZEBRA_TEXTURE = new TechnologicaLocation("textures/entity/zebra.png");

	public ZebraRenderer(Context contextIn) {
		super(contextIn, new HorseModel<>(contextIn.bakeLayer(TechnologicaModelLayers.ZEBRA)), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(Zebra zebraIn) {
		return ZEBRA_TEXTURE;
	}
}