package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.OwlModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Owl;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public final class OwlRenderer extends MobRenderer<Owl, OwlModel<Owl>> {
	private static final ResourceLocation OWL_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/owl.png");

	public OwlRenderer(Context contextIn) {
		super(contextIn, new OwlModel<>(contextIn.bakeLayer(TechnologicaModelLayers.OWL)), 0.3F);
	}

	@Override
	public ResourceLocation getTextureLocation(Owl owlIn) {
		return OWL_TEXTURE;
	}

	@Override
	public float getBob(Owl owlIn, float partialTicksIn) {
		float f = Mth.lerp(partialTicksIn, owlIn.oFlap, owlIn.flap);
		float f1 = Mth.lerp(partialTicksIn, owlIn.oFlapSpeed, owlIn.flapSpeed);
		return (Mth.sin(f) + 1.0F) * f1;
	}
}
