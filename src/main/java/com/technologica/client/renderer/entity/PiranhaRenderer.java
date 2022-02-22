package com.technologica.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.PiranhaModel;
import com.technologica.entity.passive.fish.PiranhaEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

public final class PiranhaRenderer extends MobRenderer<PiranhaEntity, PiranhaModel<PiranhaEntity>> {
	private static final ResourceLocation PIRANHA_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/piranha.png");

	public PiranhaRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new PiranhaModel<>(), 0.15F);
	}

	@Override
	public ResourceLocation getTextureLocation(PiranhaEntity entity) {
		return PIRANHA_TEXTURE;
	}

	@Override
	protected void setupRotations(PiranhaEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
		super.setupRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
		float f = 1.0F;
		float f1 = 1.0F;
		if (!entityLiving.isInWater()) {
			f = 1.3F;
			f1 = 1.7F;
		}

		float f2 = f * 4.3F * MathHelper.sin(f1 * 0.6F * ageInTicks);
		matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(f2));
		matrixStackIn.translate(0.0D, 0.0D, (double) -0.4F);
		if (!entityLiving.isInWater()) {
			matrixStackIn.translate((double) 0.2F, (double) 0.1F, 0.0D);
			matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
		}
	}
}
