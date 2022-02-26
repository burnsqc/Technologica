package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.AlligatorModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Alligator;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class AlligatorRenderer extends MobRenderer<Alligator, AlligatorModel<Alligator>> {
	private static final ResourceLocation ALLIGATOR_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/alligator.png");

	public AlligatorRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new AlligatorModel<>(renderManagerIn.bakeLayer(TechnologicaModelLayers.ALLIGATOR)), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(Alligator alligatorEntityIn) {
		return ALLIGATOR_TEXTURE;
	}
}
