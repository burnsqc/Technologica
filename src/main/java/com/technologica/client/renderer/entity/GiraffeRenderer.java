package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.GiraffeModel;
import com.technologica.world.entity.animal.Giraffe;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class GiraffeRenderer extends MobRenderer<Giraffe, GiraffeModel<Giraffe>> {
	private static final ResourceLocation GIRAFFE_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/giraffe.png");

	public GiraffeRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new GiraffeModel<>(), 1.4F);
	}

	public ResourceLocation getTextureLocation(Giraffe entity) {
		return GIRAFFE_TEXTURE;
	}
}

