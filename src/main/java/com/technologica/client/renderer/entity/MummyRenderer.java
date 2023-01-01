package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.monster.Mummy;

import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MummyRenderer extends MobRenderer<Mummy, ZombieModel<Mummy>> {
	private static final ResourceLocation MUMMY_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/mummy.png");

	public MummyRenderer(Context contextIn) {
		super(contextIn, new ZombieModel<>(contextIn.bakeLayer(TechnologicaModelLayers.MUMMY)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(Mummy mummyIn) {
		return MUMMY_TEXTURE;
	}
}