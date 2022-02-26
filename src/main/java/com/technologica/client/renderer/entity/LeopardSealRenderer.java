package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.LeopardSealModel;
import com.technologica.world.entity.animal.LeopardSealEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class LeopardSealRenderer extends MobRenderer<LeopardSealEntity, LeopardSealModel<LeopardSealEntity>> {
	private static final ResourceLocation LEOPARD_SEAL_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/leopard_seal.png");

	public LeopardSealRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new LeopardSealModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(LeopardSealEntity entity) {
		return LEOPARD_SEAL_TEXTURE;
	}
}
