package com.technologica.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.technologica.Technologica;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.monster.AtomicCreeper;

import net.minecraft.client.model.CreeperModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class AtomicCreeperRenderer extends MobRenderer<AtomicCreeper, CreeperModel<AtomicCreeper>> {
	private static final ResourceLocation ATOMIC_CREEPER_TEXTURES = new ResourceLocation(Technologica.MODID, "textures/entity/atomic_creeper.png");

	public AtomicCreeperRenderer(EntityRendererProvider.Context p_173958_) {
		super(p_173958_, new CreeperModel<>(p_173958_.bakeLayer(TechnologicaModelLayers.ATOMIC_CREEPER)), 0.5F);
	}

	@Override
	protected void scale(AtomicCreeper p_114046_, PoseStack p_114047_, float p_114048_) {
		float f = p_114046_.getSwelling(p_114048_);
		float f1 = 1.0F + Mth.sin(f * 100.0F) * f * 0.01F;
		f = Mth.clamp(f, 0.0F, 1.0F);
		f *= f;
		f *= f;
		float f2 = (1.0F + f) * f1;
		float f3 = (1.0F + f) / f1;
		p_114047_.scale(f2, f3, f2);
	}

	protected float getOverlayProgress(AtomicCreeper livingEntityIn, float partialTicks) {
		float f = livingEntityIn.getSwelling(partialTicks);
		return (int) (f * 10.0F) % 2 == 0 ? 0.0F : Mth.clamp(f, 0.5F, 1.0F);
	}

	@Override
	public ResourceLocation getTextureLocation(AtomicCreeper entity) {
		return ATOMIC_CREEPER_TEXTURES;
	}
}
