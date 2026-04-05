package com.technologica.client.renderer.entity.decoration;

import com.technologica.world.entity.decoration.InvisibleSeat;

import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public final class InvisibleRenderer extends EntityRenderer<InvisibleSeat> {
	public InvisibleRenderer(Context context) {
		super(context);
	}

	@Override
	public ResourceLocation getTextureLocation(InvisibleSeat invisibleSeat) {
		return null;
	}

	@Override
	public boolean shouldRender(InvisibleSeat invisibleSeat, Frustum camera, double camX, double camY, double camZ) {
		return false;
	}
}
