package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.WalrusModel;
import com.technologica.entity.passive.WalrusEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class WalrusRenderer extends MobRenderer<WalrusEntity, WalrusModel<WalrusEntity>> {
	private static final ResourceLocation WALRUS_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/walrus.png");

	public WalrusRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new WalrusModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(WalrusEntity entity) {
		return WALRUS_TEXTURE;
	}
}
