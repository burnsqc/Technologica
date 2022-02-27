package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.KingCrabModel;
import com.technologica.world.entity.animal.KingCrab;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class KingCrabRenderer extends MobRenderer<KingCrab, KingCrabModel<KingCrab>> {
	private static final ResourceLocation KING_CRAB_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/king_crab.png");

	public KingCrabRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new KingCrabModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(KingCrab entity) {
		return KING_CRAB_TEXTURE;
	}
}
