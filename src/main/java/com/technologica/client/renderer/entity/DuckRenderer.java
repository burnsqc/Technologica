package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Duck;

import net.minecraft.client.model.ChickenModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class DuckRenderer extends MobRenderer<Duck, ChickenModel<Duck>> {
	private static final ResourceLocation DUCK_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/duck.png");

	public DuckRenderer(EntityRendererProvider.Context p_173952_) {
		super(p_173952_, new ChickenModel<>(p_173952_.bakeLayer(TechnologicaModelLayers.DUCK)), 0.3F);
	}

	@Override
	public ResourceLocation getTextureLocation(Duck entity) {
		return DUCK_TEXTURE;
	}

	@Override
	protected float getBob(Duck livingBase, float partialTicks) {
		float f = Mth.lerp(partialTicks, livingBase.getoFlap(), livingBase.getWingRotation());
		float f1 = Mth.lerp(partialTicks, livingBase.getoFlapSpeed(), livingBase.getDestPos());
		return (Mth.sin(f) + 1.0F) * f1;
	}
}
