package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.world.entity.animal.DuckEntity;

import net.minecraft.client.model.ChickenModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class DuckRenderer extends MobRenderer<DuckEntity, ChickenModel<DuckEntity>> {
	private static final ResourceLocation DUCK_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/duck.png");

	public DuckRenderer(EntityRendererProvider.Context p_173952_) {
		super(p_173952_, new ChickenModel<>(p_173952_.bakeLayer(ModelLayers.CHICKEN)), 0.3F);
	}

	@Override
	public ResourceLocation getTextureLocation(DuckEntity entity) {
		return DUCK_TEXTURE;
	}

	@Override
	protected float getBob(DuckEntity livingBase, float partialTicks) {
		float f = Mth.lerp(partialTicks, livingBase.getoFlap(), livingBase.getWingRotation());
		float f1 = Mth.lerp(partialTicks, livingBase.getoFlapSpeed(), livingBase.getDestPos());
		return (Mth.sin(f) + 1.0F) * f1;
	}
}
