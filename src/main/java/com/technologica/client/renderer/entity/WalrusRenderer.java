package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.WalrusModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Walrus;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class WalrusRenderer extends MobRenderer<Walrus, WalrusModel<Walrus>> {
	private static final ResourceLocation WALRUS_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/walrus.png");

	public WalrusRenderer(Context contextIn) {
		super(contextIn, new WalrusModel<>(contextIn.bakeLayer(TechnologicaModelLayers.WALRUS)), 0.8F);
	}

	@Override
	public ResourceLocation getTextureLocation(Walrus walrusIn) {
		return WALRUS_TEXTURE;
	}
}
