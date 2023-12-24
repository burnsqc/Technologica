package com.technologica.client.renderer.entity;

import javax.annotation.Nullable;

import com.technologica.client.model.DustDevilModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.monster.DustDevil;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DustDevilRenderer extends MobRenderer<DustDevil, DustDevilModel<DustDevil>> {
	private static final ResourceLocation DUST_DEVIL_TEXTURE = new TechnologicaLocation("textures/entity/dust_devil.png");

	public DustDevilRenderer(Context contextIn) {
		super(contextIn, new DustDevilModel<>(contextIn.bakeLayer(TechnologicaModelLayers.DUST_DEVIL)), 0.5F);
	}

	@Override
	@Nullable
	protected RenderType getRenderType(DustDevil p_115322_, boolean p_115323_, boolean p_115324_, boolean p_115325_) {
		return RenderType.entityTranslucent(getTextureLocation(p_115322_));
	}

	@Override
	public ResourceLocation getTextureLocation(DustDevil sweeperIn) {
		return DUST_DEVIL_TEXTURE;
	}
}