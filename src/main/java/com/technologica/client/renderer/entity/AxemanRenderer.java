package com.technologica.client.renderer.entity;

import javax.annotation.Nullable;

import com.technologica.client.model.AxemanModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.monster.Axeman;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class AxemanRenderer extends MobRenderer<Axeman, AxemanModel<Axeman>> {
	private static final ResourceLocation AXEMAN_TEXTURE = new TechnologicaLocation("textures/entity/axeman.png");

	public AxemanRenderer(Context contextIn) {
		super(contextIn, new AxemanModel<>(contextIn.bakeLayer(TechnologicaModelLayers.AXEMAN)), 0.5F);
	}

	@Override
	@Nullable
	protected RenderType getRenderType(Axeman p_115322_, boolean p_115323_, boolean p_115324_, boolean p_115325_) {
		return RenderType.entityTranslucent(getTextureLocation(p_115322_));
	}

	@Override
	public ResourceLocation getTextureLocation(Axeman sweeperIn) {
		return AXEMAN_TEXTURE;
	}
}