package com.technologica.client.renderer.entity;

import com.technologica.client.model.ScorpionModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.animal.Scorpion;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ScorpionRenderer extends MobRenderer<Scorpion, ScorpionModel<Scorpion>> {
	private static final ResourceLocation SCORPION_TEXTURE = new TechnologicaLocation("textures/entity/scorpion.png");

	public ScorpionRenderer(Context contextIn) {
		super(contextIn, new ScorpionModel<>(contextIn.bakeLayer(TechnologicaModelLayers.SCORPION)), 0.8F);
	}

	@Override
	public ResourceLocation getTextureLocation(Scorpion scorpionIn) {
		return SCORPION_TEXTURE;
	}

	@Override
	protected float getFlipDegrees(Scorpion scorpionIn) {
		return 180.0F;
	}
}