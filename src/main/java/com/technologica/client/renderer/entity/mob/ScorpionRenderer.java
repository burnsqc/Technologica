package com.technologica.client.renderer.entity.mob;

import com.technologica.client.model.ScorpionModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.client.renderer.entity.layers.ScorpionEyesLayer;
import com.technologica.world.entity.animal.Scorpion;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public final class ScorpionRenderer extends TechnologicaMobRenderer<Scorpion, ScorpionModel<Scorpion>> {
	public ScorpionRenderer(Context context) {
		super(context, new ScorpionModel<>(context.bakeLayer(TechnologicaModelLayers.SCORPION)), TechnologicaMobTextures.SCORPION, 0.8F, renderer -> renderer.addLayer(new ScorpionEyesLayer<>(renderer)));
	}

	@Override
	protected float getFlipDegrees(Scorpion scorpion) {
		return 180.0F;
	}
}
