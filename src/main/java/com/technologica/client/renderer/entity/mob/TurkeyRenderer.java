package com.technologica.client.renderer.entity.mob;

import com.technologica.client.model.TurkeyModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Turkey;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.Mth;

public final class TurkeyRenderer extends TechnologicaMobRenderer<Turkey, TurkeyModel<Turkey>> {
	public TurkeyRenderer(Context context) {
		super(context, new TurkeyModel<>(context.bakeLayer(TechnologicaModelLayers.TURKEY)), TechnologicaMobTextures.TURKEY, 0.4F);
	}

	@Override
	protected float getBob(Turkey turkey, float partialTicks) {
		float f = Mth.lerp(partialTicks, turkey.flapO, turkey.flap);
		float f1 = Mth.lerp(partialTicks, turkey.flapSpeedO, turkey.flapSpeed);
		return (Mth.sin(f) + 1.0F) * f1;
	}
}
