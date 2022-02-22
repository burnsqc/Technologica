package com.technologica.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.technologica.Technologica;
import com.technologica.entity.passive.GrizzlyBearEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.PolarBearModel;
import net.minecraft.util.ResourceLocation;

public class GrizzlyBearRenderer extends MobRenderer<GrizzlyBearEntity, PolarBearModel<GrizzlyBearEntity>> {
   private static final ResourceLocation GRIZZLY_BEAR_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/grizzly_bear.png");

   public GrizzlyBearRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new PolarBearModel<>(), 0.9F);
   }

   @Override
   public ResourceLocation getTextureLocation(GrizzlyBearEntity entity) {
      return GRIZZLY_BEAR_TEXTURE;
   }

   @Override
   protected void scale(GrizzlyBearEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
      matrixStackIn.scale(1.2F, 1.2F, 1.2F);
      super.scale(entitylivingbaseIn, matrixStackIn, partialTickTime);
   }
}
