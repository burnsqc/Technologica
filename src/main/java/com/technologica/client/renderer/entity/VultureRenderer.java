package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.VultureModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Vulture;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class VultureRenderer extends MobRenderer<Vulture, VultureModel<Vulture>> {
	private static final ResourceLocation VULTURE_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/vulture.png");

	public VultureRenderer(Context contextIn) {
		super(contextIn, new VultureModel<>(contextIn.bakeLayer(TechnologicaModelLayers.VULTURE)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(Vulture vultureIn) {
		return VULTURE_TEXTURE;
	}
}