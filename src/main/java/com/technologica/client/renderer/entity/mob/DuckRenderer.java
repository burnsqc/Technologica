package com.technologica.client.renderer.entity.mob;

import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Duck;

import net.minecraft.client.model.ChickenModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.Mth;

public final class DuckRenderer extends TechnologicaMobRenderer<Duck, ChickenModel<Duck>> {
	public DuckRenderer(Context context) {
		super(context, new ChickenModel<>(context.bakeLayer(TechnologicaModelLayers.DUCK)), TechnologicaMobTextures.DUCK, 0.3F);
	}

	@Override
	protected float getBob(Duck duck, float partialTicks) {
		float angle = Mth.lerp(partialTicks, duck.oFlap, duck.flap);
		float magnitude = Mth.lerp(partialTicks, duck.oFlapSpeed, duck.flapSpeed);
		return (Mth.sin(angle) + 1.0F) * magnitude;
	}
}
