package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.LionModel;
import com.technologica.world.entity.animal.Lion;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class LionRenderer extends MobRenderer<Lion, LionModel<Lion>> {
	private static final ResourceLocation LION_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/lion.png");

	public LionRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new LionModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(Lion entity) {
		return LION_TEXTURE;
	}
}
