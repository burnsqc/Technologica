package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.DeerModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Deer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class DeerRenderer extends MobRenderer<Deer, DeerModel<Deer>> {
	private static final ResourceLocation DEER_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/deer.png");

	public DeerRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new DeerModel<>(renderManagerIn.bakeLayer(TechnologicaModelLayers.DEER)), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(Deer entity) {
		return DEER_TEXTURE;
	}
}
