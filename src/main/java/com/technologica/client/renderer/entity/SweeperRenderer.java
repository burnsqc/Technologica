package com.technologica.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.technologica.Technologica;
import com.technologica.entity.monster.SweeperEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.CreeperModel;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SweeperRenderer extends MobRenderer<SweeperEntity, CreeperModel<SweeperEntity>> {
   private static final ResourceLocation SWEEPER_TEXTURES = new ResourceLocation(Technologica.MODID, "textures/entity/sweeper.png");

   public SweeperRenderer(EntityRendererManager renderManagerIn) {
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
   public ResourceLocation getEntityTexture(SweeperEntity entity) {
      return SWEEPER_TEXTURES;
   }
}
