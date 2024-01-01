package com.technologica.client.renderer.entity;

import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.monster.Weeper;

import net.minecraft.client.model.CreeperModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WeeperRenderer extends MobRenderer<Weeper, CreeperModel<Weeper>> {
	private static final ResourceLocation PEEPER_TEXTURES = new TechnologicaLocation("textures/entity/weeper.png");

	public WeeperRenderer(Context contextIn) {
		super(contextIn, new CreeperModel<>(contextIn.bakeLayer(TechnologicaModelLayers.WEEPER)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(Weeper peeperIn) {
		return PEEPER_TEXTURES;
	}
}