package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.AlligatorModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Alligator;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class AlligatorRenderer extends MobRenderer<Alligator, AlligatorModel<Alligator>> {
	private static final ResourceLocation ALLIGATOR_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/alligator.png");

	public AlligatorRenderer(Context contextIn) {
		super(contextIn, new AlligatorModel<>(contextIn.bakeLayer(TechnologicaModelLayers.ALLIGATOR)), 0.6F);
	}

	@Override
	public ResourceLocation getTextureLocation(Alligator alligatorIn) {
		return ALLIGATOR_TEXTURE;
	}
}