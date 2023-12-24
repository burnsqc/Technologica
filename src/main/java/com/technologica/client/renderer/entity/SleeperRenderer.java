package com.technologica.client.renderer.entity;

import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.monster.Sleeper;

import net.minecraft.client.model.CreeperModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SleeperRenderer extends MobRenderer<Sleeper, CreeperModel<Sleeper>> {
	private static final ResourceLocation PEEPER_TEXTURES = new TechnologicaLocation("textures/entity/sleeper.png");

	public SleeperRenderer(Context contextIn) {
		super(contextIn, new CreeperModel<>(contextIn.bakeLayer(TechnologicaModelLayers.SLEEPER)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(Sleeper peeperIn) {
		return PEEPER_TEXTURES;
	}
}