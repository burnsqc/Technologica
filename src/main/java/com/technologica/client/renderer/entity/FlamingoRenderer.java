package com.technologica.client.renderer.entity;

import com.technologica.client.model.FlamingoModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.animal.Flamingo;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public final class FlamingoRenderer extends MobRenderer<Flamingo, FlamingoModel<Flamingo>> {
	private static final ResourceLocation FLAMINGO_TEXTURE = new TechnologicaLocation("textures/entity/flamingo.png");

	public FlamingoRenderer(Context contextIn) {
		super(contextIn, new FlamingoModel<>(contextIn.bakeLayer(TechnologicaModelLayers.FLAMINGO)), 0.3F);
	}

	@Override
	public ResourceLocation getTextureLocation(Flamingo flamingoIn) {
		return FLAMINGO_TEXTURE;
	}

	@Override
	protected float getBob(Flamingo entity, float partialTicksIn) {
		float f = Mth.lerp(partialTicksIn, entity.oFlap, entity.flap);
		float f1 = Mth.lerp(partialTicksIn, entity.oFlapSpeed, entity.flapSpeed);
		return (Mth.sin(f) + 1.0F) * f1;
	}
}