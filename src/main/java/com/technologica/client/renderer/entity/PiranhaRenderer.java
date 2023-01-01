package com.technologica.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.technologica.Technologica;
import com.technologica.client.model.PiranhaModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Piranha;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public final class PiranhaRenderer extends MobRenderer<Piranha, PiranhaModel<Piranha>> {
	private static final ResourceLocation PIRANHA_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/piranha.png");

	public PiranhaRenderer(Context contextIn) {
		super(contextIn, new PiranhaModel<>(contextIn.bakeLayer(TechnologicaModelLayers.PIRANHA)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(Piranha piranhaIn) {
		return PIRANHA_TEXTURE;
	}

	@Override
	protected void setupRotations(Piranha piranhaIn, PoseStack matrixStackIn, float ageInTicksIn, float yawIn, float partialTicksIn) {
		super.setupRotations(piranhaIn, matrixStackIn, ageInTicksIn, yawIn, partialTicksIn);
		float f = 1.0F;
		float f1 = 1.0F;
		if (!piranhaIn.isInWater()) {
			f = 1.3F;
			f1 = 1.7F;
		}
		float f2 = f * 4.3F * Mth.sin(f1 * 0.6F * ageInTicksIn);
		matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(f2));
		matrixStackIn.translate(0.0D, 0.0D, -0.4F);
		if (!piranhaIn.isInWater()) {
			matrixStackIn.translate(0.2F, 0.1F, 0.0D);
			matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
		}
	}
}
