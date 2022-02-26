package com.technologica.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.technologica.Technologica;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.GrizzlyBearEntity;

import net.minecraft.client.model.PolarBearModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GrizzlyBearRenderer extends MobRenderer<GrizzlyBearEntity, PolarBearModel<GrizzlyBearEntity>> {
   private static final ResourceLocation GRIZZLY_BEAR_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/grizzly_bear.png");

   public GrizzlyBearRenderer(EntityRendererProvider.Context p_174356_) {
	   super(p_174356_, new PolarBearModel<>(p_174356_.bakeLayer(TechnologicaModelLayers.GRIZZLY_BEAR)), 0.9F);
   }

   @Override
   public ResourceLocation getTextureLocation(GrizzlyBearEntity entity) {
      return GRIZZLY_BEAR_TEXTURE;
   }

   @Override
   protected void scale(GrizzlyBearEntity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
      matrixStackIn.scale(1.2F, 1.2F, 1.2F);
      super.scale(entitylivingbaseIn, matrixStackIn, partialTickTime);
   }
}
