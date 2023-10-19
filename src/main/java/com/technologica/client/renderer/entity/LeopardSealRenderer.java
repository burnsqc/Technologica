package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.LeopardSealModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.LeopardSeal;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class LeopardSealRenderer extends MobRenderer<LeopardSeal, LeopardSealModel<LeopardSeal>> {
	private static final ResourceLocation LEOPARD_SEAL_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/leopard_seal.png");

	public LeopardSealRenderer(Context contextIn) {
		super(contextIn, new LeopardSealModel<>(contextIn.bakeLayer(TechnologicaModelLayers.LEOPARD_SEAL)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(LeopardSeal leopardSealIn) {
		return LEOPARD_SEAL_TEXTURE;
	}
}