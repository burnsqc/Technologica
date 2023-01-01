package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.JaguarModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Jaguar;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class JaguarRenderer extends MobRenderer<Jaguar, JaguarModel<Jaguar>> {
	private static final ResourceLocation JAGUAR_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/jaguar.png");

	public JaguarRenderer(Context contextIn) {
		super(contextIn, new JaguarModel<>(contextIn.bakeLayer(TechnologicaModelLayers.JAGUAR)), 0.6F);
	}

	@Override
	public ResourceLocation getTextureLocation(Jaguar jaguarIn) {
		return JAGUAR_TEXTURE;
	}
}
