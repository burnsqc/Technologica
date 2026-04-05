package com.technologica.client.renderer.entity.mob;

import com.technologica.client.model.FlamingoModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Flamingo;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.Mth;

public final class FlamingoRenderer extends TechnologicaMobRenderer<Flamingo, FlamingoModel<Flamingo>> {
	public FlamingoRenderer(Context context) {
		super(context, new FlamingoModel<>(context.bakeLayer(TechnologicaModelLayers.FLAMINGO)), TechnologicaMobTextures.FLAMINGO, 0.3F);
	}

	@Override
	protected float getBob(Flamingo flamingo, float partialTicks) {
		float angle = Mth.lerp(partialTicks, flamingo.oFlap, flamingo.flap);
		float magnitude = Mth.lerp(partialTicks, flamingo.oFlapSpeed, flamingo.flapSpeed);
		return (Mth.sin(angle) + 1.0F) * magnitude;
	}
}
