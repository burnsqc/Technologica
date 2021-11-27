package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.OstrichModel;
import com.technologica.entity.passive.OstrichEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class OstrichRenderer extends MobRenderer<OstrichEntity, OstrichModel<OstrichEntity>> {
	private static final ResourceLocation OSTRICH_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/ostrich.png");

   public OstrichRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new OstrichModel<>(), 1.0F);
   }

   public ResourceLocation getEntityTexture(OstrichEntity entity) {
	      return OSTRICH_TEXTURE;
	   }
}