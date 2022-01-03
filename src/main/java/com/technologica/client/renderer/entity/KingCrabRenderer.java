package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.KingCrabModel;
import com.technologica.entity.passive.KingCrabEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class KingCrabRenderer extends MobRenderer<KingCrabEntity, KingCrabModel<KingCrabEntity>> {
	private static final ResourceLocation KING_CRAB_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/king_crab.png");

	public KingCrabRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new KingCrabModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getEntityTexture(KingCrabEntity entity) {
		return KING_CRAB_TEXTURE;
	}
}
