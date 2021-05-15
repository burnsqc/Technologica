package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.OstrichModel;
import com.technologica.entity.passive.OstrichEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public final class OstrichRenderer extends MobRenderer<OstrichEntity, OstrichModel<OstrichEntity>> {
	private static final ResourceLocation OSTRICH_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/ostrich.png");

   public OstrichRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new OstrichModel<>(0.0F), 1.1F);
//      this.addLayer(new OstrichMarkingsLayer(this));
//      this.addLayer(new LeatherOstrichArmorLayer(this));
   }

   public ResourceLocation getEntityTexture(OstrichEntity entity) {
	      return OSTRICH_TEXTURE;
	   }
}