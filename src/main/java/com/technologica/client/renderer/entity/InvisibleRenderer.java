package com.technologica.client.renderer.entity;

import com.technologica.world.entity.decoration.InvisibleSeat;

import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class InvisibleRenderer extends EntityRenderer<InvisibleSeat> {

	public InvisibleRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager);
	}

	@Override
	public boolean shouldRender(InvisibleSeat entity, Frustum camera, double camX, double camY, double camZ) {
		return false;
	}

	@Override
	public ResourceLocation getTextureLocation(InvisibleSeat entity) {
		return null;
	}
}