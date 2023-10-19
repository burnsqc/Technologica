package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.FlamingoModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Flamingo;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class FlamingoRenderer extends MobRenderer<Flamingo, FlamingoModel<Flamingo>> {
	private static final ResourceLocation FLAMINGO_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/flamingo.png");

	public FlamingoRenderer(Context contextIn) {
		super(contextIn, new FlamingoModel<>(contextIn.bakeLayer(TechnologicaModelLayers.FLAMINGO)), 0.3F);
	}

	@Override
	public ResourceLocation getTextureLocation(Flamingo flamingoIn) {
		return FLAMINGO_TEXTURE;
	}
}