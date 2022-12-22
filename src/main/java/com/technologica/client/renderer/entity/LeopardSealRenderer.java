package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.LeopardSealModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.LeopardSeal;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class LeopardSealRenderer extends MobRenderer<LeopardSeal, LeopardSealModel<LeopardSeal>> {
	private static final ResourceLocation LEOPARD_SEAL_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/leopard_seal.png");

	public LeopardSealRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new LeopardSealModel<>(renderManagerIn.bakeLayer(TechnologicaModelLayers.LEOPARD_SEAL)), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(LeopardSeal entity) {
		return LEOPARD_SEAL_TEXTURE;
	}
}
