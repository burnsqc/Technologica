package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.FlamingoModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Flamingo;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class FlamingoRenderer extends MobRenderer<Flamingo, FlamingoModel<Flamingo>> {
	private static final ResourceLocation FLAMINGO_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/flamingo.png");

	public FlamingoRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new FlamingoModel<>(renderManagerIn.bakeLayer(TechnologicaModelLayers.FLAMINGO)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(Flamingo entity) {
		return FLAMINGO_TEXTURE;
	}
}
