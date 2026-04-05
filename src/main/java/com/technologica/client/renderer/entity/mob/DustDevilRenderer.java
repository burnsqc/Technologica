package com.technologica.client.renderer.entity.mob;

import com.technologica.client.model.DustDevilModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.monster.DustDevil;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public final class DustDevilRenderer extends TechnologicaMobRenderer<DustDevil, DustDevilModel<DustDevil>> {
	public DustDevilRenderer(Context context) {
		super(context, new DustDevilModel<>(context.bakeLayer(TechnologicaModelLayers.DUST_DEVIL)), TechnologicaMobTextures.DUST_DEVIL, 0.5F);
	}

	@Override
	protected RenderType getRenderType(DustDevil dustDevil, boolean bodyVisible, boolean translucent, boolean glowing) {
		return RenderType.entityTranslucent(getTextureLocation(dustDevil));
	}
}
