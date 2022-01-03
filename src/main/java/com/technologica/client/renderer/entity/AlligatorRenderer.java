package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.AlligatorModel;
import com.technologica.entity.passive.AlligatorEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class AlligatorRenderer extends MobRenderer<AlligatorEntity, AlligatorModel<AlligatorEntity>> {
	private static final ResourceLocation ALLIGATOR_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/alligator.png");

	public AlligatorRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new AlligatorModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getEntityTexture(AlligatorEntity entity) {
		return ALLIGATOR_TEXTURE;
	}
}
