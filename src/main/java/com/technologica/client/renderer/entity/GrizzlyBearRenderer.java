package com.technologica.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.GrizzlyBearModel;
import com.technologica.entity.passive.GrizzlyBearEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GrizzlyBearRenderer extends MobRenderer<GrizzlyBearEntity, GrizzlyBearModel<GrizzlyBearEntity>> {
   private static final ResourceLocation GRIZZLY_BEAR_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/grizzly_bear.png");

   public GrizzlyBearRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new GrizzlyBearModel<>(), 0.9F);
   }

   public ResourceLocation getEntityTexture(GrizzlyBearEntity entity) {
      return GRIZZLY_BEAR_TEXTURE;
   }

   protected void preRenderCallback(GrizzlyBearEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
      matrixStackIn.scale(1.2F, 1.2F, 1.2F);
      super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
   }
}