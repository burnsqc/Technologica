package com.technologica.client.renderer.entity.mob;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.technologica.client.model.PiranhaModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Piranha;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.Mth;

public final class PiranhaRenderer extends TechnologicaMobRenderer<Piranha, PiranhaModel<Piranha>> {
	public PiranhaRenderer(Context context) {
		super(context, new PiranhaModel<>(context.bakeLayer(TechnologicaModelLayers.PIRANHA)), TechnologicaMobTextures.PIRANHA, 0.2F);
	}

	@Override
	protected void setupRotations(Piranha piranha, PoseStack poseStack, float ageInTicks, float yaw, float partialTicks) {
		super.setupRotations(piranha, poseStack, ageInTicks, yaw, partialTicks);
		float magnitude = 1.0F;
		float angle = 1.0F;
		if (!piranha.isInWater()) {
			magnitude = 1.3F;
			angle = 1.7F;
		}
		float rotY = magnitude * 4.3F * Mth.sin(angle * 0.6F * ageInTicks);
		poseStack.mulPose(Axis.YP.rotationDegrees(rotY));
		poseStack.translate(0.0D, 0.0D, -0.4F);
		if (!piranha.isInWater()) {
			poseStack.translate(0.2F, 0.1F, 0.0D);
			poseStack.mulPose(Axis.ZP.rotationDegrees(90.0F));
		}
	}
}
