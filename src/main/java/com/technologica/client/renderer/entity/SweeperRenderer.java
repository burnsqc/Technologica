package com.technologica.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.technologica.Technologica;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.monster.Sweeper;

import net.minecraft.client.model.CreeperModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.monster.Creeper;

public class SweeperRenderer extends MobRenderer<Sweeper, CreeperModel<Sweeper>> {
	private static final ResourceLocation SWEEPER_TEXTURES = new ResourceLocation(Technologica.MODID, "textures/entity/sweeper.png");

	public SweeperRenderer(EntityRendererProvider.Context p_173958_) {
		super(p_173958_, new CreeperModel<>(p_173958_.bakeLayer(TechnologicaModelLayers.SWEEPER)), 0.5F);
	}

	protected void scale(Creeper p_114046_, PoseStack p_114047_, float p_114048_) {
		float f = p_114046_.getSwelling(p_114048_);
		float f1 = 1.0F + Mth.sin(f * 100.0F) * f * 0.01F;
		f = Mth.clamp(f, 0.0F, 1.0F);
		f *= f;
		f *= f;
		float f2 = (1.0F + f * 0.4F) * f1;
		float f3 = (1.0F + f * 0.1F) / f1;
		p_114047_.scale(f2, f3, f2);
	}

	protected float getOverlayProgress(Creeper livingEntityIn, float partialTicks) {
		float f = livingEntityIn.getSwelling(partialTicks);
		return (int) (f * 10.0F) % 2 == 0 ? 0.0F : Mth.clamp(f, 0.5F, 1.0F);
	}

	/**
	 * Returns the location of an entity's texture.
	 */
	@Override
	public ResourceLocation getTextureLocation(Sweeper entity) {
		return SWEEPER_TEXTURES;
	}
}
