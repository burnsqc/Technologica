package com.technologica.client.renderer.entity.mob;

import com.mojang.blaze3d.vertex.PoseStack;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.monster.AtomicCreeper;

import net.minecraft.client.model.CreeperModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.Mth;

public final class AtomicCreeperRenderer extends TechnologicaMobRenderer<AtomicCreeper, CreeperModel<AtomicCreeper>> {
	public AtomicCreeperRenderer(Context context) {
		super(context, new CreeperModel<>(context.bakeLayer(TechnologicaModelLayers.ATOMIC_CREEPER)), TechnologicaMobTextures.ATOMIC_CREEPER, 0.5F);
	}

	@Override
	protected void scale(AtomicCreeper atomicCreeper, PoseStack poseStack, float partialTicks) {
		float swellAmount = atomicCreeper.getSwelling(partialTicks);
		float swellAdjusted = 1.0F + Mth.sin(swellAmount * 100.0F) * swellAmount * 0.01F;
		swellAmount = Mth.clamp(swellAmount, 0.0F, 1.0F);
		swellAmount *= swellAmount;
		swellAmount *= swellAmount;
		float swellHorizontal = (1.0F - swellAmount) * swellAdjusted;
		float swellVertical = (1.0F - swellAmount) / swellAdjusted;
		poseStack.scale(swellHorizontal, swellVertical, swellHorizontal);
	}
}
