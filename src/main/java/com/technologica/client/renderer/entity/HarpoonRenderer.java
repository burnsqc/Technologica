package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.entity.projectile.HarpoonEntity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class HarpoonRenderer extends ArrowRenderer<HarpoonEntity> {
	public static final ResourceLocation HARPOON = new ResourceLocation(Technologica.MODID, "textures/entity/projectiles/harpoon.png");

	public HarpoonRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public ResourceLocation getEntityTexture(HarpoonEntity entity) {
		return HARPOON;
	}
}