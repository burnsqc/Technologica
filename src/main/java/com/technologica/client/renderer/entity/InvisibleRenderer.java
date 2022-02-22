package com.technologica.client.renderer.entity;

import com.technologica.entity.item.InvisibleSeatEntity;

import net.minecraft.client.renderer.culling.ClippingHelper;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class InvisibleRenderer extends EntityRenderer<InvisibleSeatEntity> {

	public InvisibleRenderer(EntityRendererManager renderManager) {
		super(renderManager);
	}

	@Override
	public boolean shouldRender(InvisibleSeatEntity entity, ClippingHelper camera, double camX, double camY, double camZ) {
		return false;
	}

	@Override
	public ResourceLocation getTextureLocation(InvisibleSeatEntity entity) {
		return null;
	}

}
