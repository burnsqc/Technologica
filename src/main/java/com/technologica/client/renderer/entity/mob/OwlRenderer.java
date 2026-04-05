package com.technologica.client.renderer.entity.mob;

import com.technologica.client.model.OwlModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Owl;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.Mth;

public final class OwlRenderer extends TechnologicaMobRenderer<Owl, OwlModel<Owl>> {
	public OwlRenderer(Context context) {
		super(context, new OwlModel<>(context.bakeLayer(TechnologicaModelLayers.OWL)), TechnologicaMobTextures.OWL, 0.3F);
	}

	@Override
	public float getBob(Owl owl, float partialTicks) {
		float f = Mth.lerp(partialTicks, owl.oFlap, owl.flap);
		float f1 = Mth.lerp(partialTicks, owl.oFlapSpeed, owl.flapSpeed);
		return (Mth.sin(f) + 1.0F) * f1;
	}
}
