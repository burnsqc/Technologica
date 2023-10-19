package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.monster.Sweeper;

import net.minecraft.client.model.CreeperModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SweeperRenderer extends MobRenderer<Sweeper, CreeperModel<Sweeper>> {
	private static final ResourceLocation SWEEPER_TEXTURES = new ResourceLocation(Technologica.MODID, "textures/entity/sweeper.png");

	public SweeperRenderer(Context contextIn) {
		super(contextIn, new CreeperModel<>(contextIn.bakeLayer(TechnologicaModelLayers.SWEEPER)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(Sweeper sweeperIn) {
		return SWEEPER_TEXTURES;
	}
}