package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.LeopardSealModel;
import com.technologica.entity.passive.LeopardSealEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class LeopardSealRenderer extends MobRenderer<LeopardSealEntity, LeopardSealModel<LeopardSealEntity>> {
	private static final ResourceLocation LEOPARD_SEAL_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/leopard_seal.png");

	public LeopardSealRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new LeopardSealModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getEntityTexture(LeopardSealEntity entity) {
		return LEOPARD_SEAL_TEXTURE;
	}
}
