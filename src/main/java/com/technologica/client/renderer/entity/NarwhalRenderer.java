package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.NarwhalModel;
import com.technologica.world.entity.animal.NarwhalEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class NarwhalRenderer extends MobRenderer<NarwhalEntity, NarwhalModel<NarwhalEntity>> {
	private static final ResourceLocation NARWHAL_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/narwhal.png");

	public NarwhalRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new NarwhalModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(NarwhalEntity entity) {
		return NARWHAL_TEXTURE;
	}
}
