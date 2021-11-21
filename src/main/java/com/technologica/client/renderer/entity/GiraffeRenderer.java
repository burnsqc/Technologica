package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.GiraffeModel;
import com.technologica.entity.passive.GiraffeEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class GiraffeRenderer extends MobRenderer<GiraffeEntity, GiraffeModel<GiraffeEntity>> {
	private static final ResourceLocation GIRAFFE_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/giraffe.png");

	public GiraffeRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new GiraffeModel<>(0.0F), 1.1F);
	}

	public ResourceLocation getEntityTexture(GiraffeEntity entity) {
		return GIRAFFE_TEXTURE;
	}
}

