package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.KingCrabModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.KingCrab;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class KingCrabRenderer extends MobRenderer<KingCrab, KingCrabModel<KingCrab>> {
	private static final ResourceLocation KING_CRAB_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/king_crab.png");

	public KingCrabRenderer(Context contextIn) {
		super(contextIn, new KingCrabModel<>(contextIn.bakeLayer(TechnologicaModelLayers.KING_CRAB)), 0.4F);
	}

	@Override
	public ResourceLocation getTextureLocation(KingCrab kingCrabIn) {
		return KING_CRAB_TEXTURE;
	}
}
