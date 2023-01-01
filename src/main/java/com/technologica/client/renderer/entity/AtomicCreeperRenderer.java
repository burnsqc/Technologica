package com.technologica.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.technologica.Technologica;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.monster.AtomicCreeper;

import net.minecraft.client.model.CreeperModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class AtomicCreeperRenderer extends MobRenderer<AtomicCreeper, CreeperModel<AtomicCreeper>> {
	private static final ResourceLocation ATOMIC_CREEPER_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/atomic_creeper.png");

	public AtomicCreeperRenderer(Context contextIn) {
		super(contextIn, new CreeperModel<>(contextIn.bakeLayer(TechnologicaModelLayers.ATOMIC_CREEPER)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(AtomicCreeper atomicCreeperIn) {
		return ATOMIC_CREEPER_TEXTURE;
	}
	
	@Override
	protected void scale(AtomicCreeper atomicCreeperIn, PoseStack poseStackIn, float floatIn) {
		float f = atomicCreeperIn.getSwelling(floatIn);
		float f1 = 1.0F + Mth.sin(f * 100.0F) * f * 0.01F;
		f = Mth.clamp(f, 0.0F, 1.0F);
		f *= f;
		f *= f;
		float f2 = (1.0F - f) * f1;
		float f3 = (1.0F - f) / f1;
		poseStackIn.scale(f2, f3, f2);
	}

	protected float getOverlayProgress(AtomicCreeper livingEntityIn, float partialTicks) {
		float f = livingEntityIn.getSwelling(partialTicks);
		return (int) (f * 10.0F) % 2 == 0 ? 0.0F : Mth.clamp(f, 0.5F, 1.0F);
	}
}
