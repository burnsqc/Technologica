package com.technologica.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.technologica.Technologica;
import com.technologica.client.model.PiranhaModel;
import com.technologica.world.entity.animal.Piranha;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public final class PiranhaRenderer extends MobRenderer<Piranha, PiranhaModel<Piranha>> {
	private static final ResourceLocation PIRANHA_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/piranha.png");

	public PiranhaRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PiranhaModel<>(), 0.15F);
	}

	@Override
	public ResourceLocation getTextureLocation(Piranha entity) {
		return PIRANHA_TEXTURE;
	}

	@Override
	protected void setupRotations(Piranha entityLiving, PoseStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
		super.setupRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
		float f = 1.0F;
		float f1 = 1.0F;
		if (!entityLiving.isInWater()) {
			f = 1.3F;
			f1 = 1.7F;
		}

		float f2 = f * 4.3F * Mth.sin(f1 * 0.6F * ageInTicks);
		matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(f2));
		matrixStackIn.translate(0.0D, 0.0D, (double) -0.4F);
		if (!entityLiving.isInWater()) {
			matrixStackIn.translate((double) 0.2F, (double) 0.1F, 0.0D);
			matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
		}
	}
}
