package com.technologica.client.renderer.entity;

import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.monster.Beeper;

import net.minecraft.client.model.CreeperModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BeeperRenderer extends MobRenderer<Beeper, CreeperModel<Beeper>> {
	private static final ResourceLocation PEEPER_TEXTURES = new TechnologicaLocation("textures/entity/beeper.png");

	public BeeperRenderer(Context contextIn) {
		super(contextIn, new CreeperModel<>(contextIn.bakeLayer(TechnologicaModelLayers.BEEPER)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(Beeper peeperIn) {
		return PEEPER_TEXTURES;
	}
}