package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.ZebraEntity;

import net.minecraft.client.model.HorseModel;
import net.minecraft.client.renderer.entity.AbstractHorseRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public final class ZebraRenderer extends AbstractHorseRenderer<ZebraEntity, HorseModel<ZebraEntity>> {
	private static final ResourceLocation ZEBRA_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/zebra.png");

	public ZebraRenderer(EntityRendererProvider.Context p_174167_) {
		super(p_174167_, new HorseModel<>(p_174167_.bakeLayer(TechnologicaModelLayers.ZEBRA)), 1.1F);
	}

	public ResourceLocation getTextureLocation(ZebraEntity entity) {
		return ZEBRA_TEXTURE;
	}
}