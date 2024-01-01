package com.technologica.client.renderer.entity;

import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.monster.Peeper;

import net.minecraft.client.model.CreeperModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PeeperRenderer extends MobRenderer<Peeper, CreeperModel<Peeper>> {
	private static final ResourceLocation PEEPER_TEXTURES = new TechnologicaLocation("textures/entity/peeper.png");

	public PeeperRenderer(Context contextIn) {
		super(contextIn, new CreeperModel<>(contextIn.bakeLayer(TechnologicaModelLayers.PEEPER)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(Peeper peeperIn) {
		return PEEPER_TEXTURES;
	}
}