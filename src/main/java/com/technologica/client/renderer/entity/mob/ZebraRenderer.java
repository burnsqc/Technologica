package com.technologica.client.renderer.entity.mob;

import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.client.renderer.entity.layers.ZebraArmorLayer;
import com.technologica.world.entity.animal.Zebra;

import net.minecraft.client.model.HorseModel;
import net.minecraft.client.renderer.entity.AbstractHorseRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public final class ZebraRenderer extends AbstractHorseRenderer<Zebra, HorseModel<Zebra>> {
	public ZebraRenderer(Context context) {
		super(context, new HorseModel<>(context.bakeLayer(TechnologicaModelLayers.ZEBRA)), 1.1F);
		this.addLayer(new ZebraArmorLayer(this, context.getModelSet()));
	}

	@Override
	public ResourceLocation getTextureLocation(Zebra zebra) {
		return TechnologicaMobTextures.ZEBRA;
	}
}
