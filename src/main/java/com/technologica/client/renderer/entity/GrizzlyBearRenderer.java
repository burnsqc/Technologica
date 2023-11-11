package com.technologica.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.animal.GrizzlyBear;

import net.minecraft.client.model.PolarBearModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GrizzlyBearRenderer extends MobRenderer<GrizzlyBear, PolarBearModel<GrizzlyBear>> {
	private static final ResourceLocation GRIZZLY_BEAR_TEXTURE = new TechnologicaLocation("textures/entity/grizzly_bear.png");

	public GrizzlyBearRenderer(Context contextIn) {
		super(contextIn, new PolarBearModel<>(contextIn.bakeLayer(TechnologicaModelLayers.GRIZZLY_BEAR)), 0.9F);
	}

	@Override
	public ResourceLocation getTextureLocation(GrizzlyBear grizzlyBearIn) {
		return GRIZZLY_BEAR_TEXTURE;
	}

	@Override
	protected void scale(GrizzlyBear grizzlyBearIn, PoseStack poseStackIn, float partialTicksIn) {
		poseStackIn.scale(1.2F, 1.2F, 1.2F);
		super.scale(grizzlyBearIn, poseStackIn, partialTicksIn);
	}
}