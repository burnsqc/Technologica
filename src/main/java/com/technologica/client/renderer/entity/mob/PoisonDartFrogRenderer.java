package com.technologica.client.renderer.entity.mob;

import com.technologica.client.model.PoisonDartFrogModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.PoisonDartFrog;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class PoisonDartFrogRenderer extends MobRenderer<PoisonDartFrog, PoisonDartFrogModel<PoisonDartFrog>> {
	public PoisonDartFrogRenderer(Context context) {
		super(context, new PoisonDartFrogModel<>(context.bakeLayer(TechnologicaModelLayers.POISON_DART_FROG)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(PoisonDartFrog poisonDartFrog) {
		return poisonDartFrog.getVariant().texture();
	}
}
