package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.entity.passive.ZebraEntity;

import net.minecraft.client.renderer.entity.AbstractHorseRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.HorseModel;
import net.minecraft.util.ResourceLocation;

public final class ZebraRenderer extends AbstractHorseRenderer<ZebraEntity, HorseModel<ZebraEntity>> {
	private static final ResourceLocation ZEBRA_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/zebra.png");

	public ZebraRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new HorseModel<>(0.0F), 1.1F);
//      this.addLayer(new ZebraMarkingsLayer(this));
//      this.addLayer(new LeatherZebraArmorLayer(this));
	}

	public ResourceLocation getEntityTexture(ZebraEntity entity) {
		return ZEBRA_TEXTURE;
	}
}