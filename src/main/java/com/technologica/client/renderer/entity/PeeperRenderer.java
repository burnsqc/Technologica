package com.technologica.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.technologica.Technologica;
import com.technologica.entity.monster.PeeperEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.CreeperModel;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class PeeperRenderer extends MobRenderer<PeeperEntity, CreeperModel<PeeperEntity>> {
   private static final ResourceLocation PEEPER_TEXTURES = new ResourceLocation(Technologica.MODID, "textures/entity/peeper.png");

   public PeeperRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new CreeperModel<>(), 0.5F);
   }

   protected void preRenderCallback(CreeperEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
      float f = entitylivingbaseIn.getCreeperFlashIntensity(partialTickTime);
      float f1 = 1.0F + MathHelper.sin(f * 100.0F) * f * 0.01F;
      f = MathHelper.clamp(f, 0.0F, 1.0F);
      f = f * f;
      f = f * f;
      float f2 = (1.0F + f * 0.4F) * f1;
      float f3 = (1.0F + f * 0.1F) / f1;
      matrixStackIn.scale(f2, f3, f2);
   }

   protected float getOverlayProgress(CreeperEntity livingEntityIn, float partialTicks) {
      float f = livingEntityIn.getCreeperFlashIntensity(partialTicks);
      return (int)(f * 10.0F) % 2 == 0 ? 0.0F : MathHelper.clamp(f, 0.5F, 1.0F);
   }

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(PeeperEntity entity) {
      return PEEPER_TEXTURES;
   }
}
