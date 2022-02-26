package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.WalrusModel;
import com.technologica.world.entity.animal.WalrusEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class WalrusRenderer extends MobRenderer<WalrusEntity, WalrusModel<WalrusEntity>> {
	private static final ResourceLocation WALRUS_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/walrus.png");

	public WalrusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new WalrusModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(WalrusEntity entity) {
		return WALRUS_TEXTURE;
	}
}
