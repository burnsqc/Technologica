package com.technologica.client.renderer.entity;

import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.animal.Duck;

import net.minecraft.client.model.ChickenModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class DuckRenderer extends MobRenderer<Duck, ChickenModel<Duck>> {
	private static final ResourceLocation DUCK_TEXTURE = new TechnologicaLocation("textures/entity/duck.png");

	public DuckRenderer(Context contextIn) {
		super(contextIn, new ChickenModel<>(contextIn.bakeLayer(TechnologicaModelLayers.DUCK)), 0.3F);
	}

	@Override
	public ResourceLocation getTextureLocation(Duck duckIn) {
		return DUCK_TEXTURE;
	}

	@Override
	protected float getBob(Duck duckIn, float partialTicksIn) {
		float f = Mth.lerp(partialTicksIn, duckIn.getoFlap(), duckIn.getWingRotation());
		float f1 = Mth.lerp(partialTicksIn, duckIn.getoFlapSpeed(), duckIn.getDestPos());
		return (Mth.sin(f) + 1.0F) * f1;
	}
}