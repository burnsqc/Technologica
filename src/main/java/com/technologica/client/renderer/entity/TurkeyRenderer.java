package com.technologica.client.renderer.entity;

import com.technologica.client.model.TurkeyModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.animal.Turkey;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public final class TurkeyRenderer extends MobRenderer<Turkey, TurkeyModel<Turkey>> {
	private static final ResourceLocation TURKEY_TEXTURE = new TechnologicaLocation("textures/entity/turkey.png");

	public TurkeyRenderer(Context contextIn) {
		super(contextIn, new TurkeyModel<>(contextIn.bakeLayer(TechnologicaModelLayers.TURKEY)), 0.4F);
	}

	@Override
	public ResourceLocation getTextureLocation(Turkey turkeyIn) {
		return TURKEY_TEXTURE;
	}

	@Override
	protected float getBob(Turkey entity, float partialTicksIn) {
		float f = Mth.lerp(partialTicksIn, entity.oFlap, entity.flap);
		float f1 = Mth.lerp(partialTicksIn, entity.oFlapSpeed, entity.flapSpeed);
		return (Mth.sin(f) + 1.0F) * f1;
	}
}