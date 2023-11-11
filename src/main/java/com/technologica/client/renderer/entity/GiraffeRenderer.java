package com.technologica.client.renderer.entity;

import com.technologica.client.model.GiraffeModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.animal.Giraffe;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class GiraffeRenderer extends MobRenderer<Giraffe, GiraffeModel<Giraffe>> {
	private static final ResourceLocation GIRAFFE_TEXTURE = new TechnologicaLocation("textures/entity/giraffe.png");

	public GiraffeRenderer(Context contextIn) {
		super(contextIn, new GiraffeModel<>(contextIn.bakeLayer(TechnologicaModelLayers.GIRAFFE)), 0.8F);
	}

	@Override
	public ResourceLocation getTextureLocation(Giraffe giraffeIn) {
		return GIRAFFE_TEXTURE;
	}
}