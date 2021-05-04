package com.technologica.client.renderer.entity;

import com.technologica.MainMod;
import com.technologica.entity.passive.ZebraEntity;

import net.minecraft.client.renderer.entity.AbstractHorseRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.HorseModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public final class ZebraRenderer extends AbstractHorseRenderer<ZebraEntity, HorseModel<ZebraEntity>> {
	private static final ResourceLocation ZEBRA_TEXTURE = new ResourceLocation(MainMod.MODID, "textures/entity/zebra.png");

   public ZebraRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new HorseModel<>(0.0F), 1.1F);
//      this.addLayer(new ZebraMarkingsLayer(this));
//      this.addLayer(new LeatherZebraArmorLayer(this));
   }

   public ResourceLocation getEntityTexture(ZebraEntity entity) {
	      return ZEBRA_TEXTURE;
	   }
}