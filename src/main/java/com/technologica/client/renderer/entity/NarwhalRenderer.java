package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.NarwhalModel;
import com.technologica.entity.passive.NarwhalEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class NarwhalRenderer extends MobRenderer<NarwhalEntity, NarwhalModel<NarwhalEntity>> {
	private static final ResourceLocation NARWHAL_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/narwhal.png");

	public NarwhalRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new NarwhalModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getEntityTexture(NarwhalEntity entity) {
		return NARWHAL_TEXTURE;
	}
}
