package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.entity.passive.OstrichEntity;

import net.minecraft.client.renderer.entity.AbstractHorseRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.HorseModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public final class OstrichRenderer extends AbstractHorseRenderer<OstrichEntity, HorseModel<OstrichEntity>> {
	private static final ResourceLocation OSTRICH_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/ostrich.png");

   public OstrichRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new HorseModel<>(0.0F), 1.1F);
//      this.addLayer(new OstrichMarkingsLayer(this));
//      this.addLayer(new LeatherOstrichArmorLayer(this));
   }

   public ResourceLocation getEntityTexture(OstrichEntity entity) {
	      return OSTRICH_TEXTURE;
	   }
}