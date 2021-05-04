package com.technologica.client.renderer.entity;

import com.technologica.MainMod;
import com.technologica.client.renderer.entity.model.DuckModel;
import com.technologica.entity.passive.DuckEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DuckRenderer extends MobRenderer<DuckEntity, DuckModel<DuckEntity>> {
   private static final ResourceLocation DUCK_TEXTURE = new ResourceLocation(MainMod.MODID, "textures/entity/duck.png");

   public DuckRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new DuckModel<>(), 0.3F);
   }

   public ResourceLocation getEntityTexture(DuckEntity entity) {
      return DUCK_TEXTURE;
   }

   protected float handleRotationFloat(DuckEntity livingBase, float partialTicks) {
      float f = MathHelper.lerp(partialTicks, livingBase.oFlap, livingBase.wingRotation);
      float f1 = MathHelper.lerp(partialTicks, livingBase.oFlapSpeed, livingBase.destPos);
      return (MathHelper.sin(f) + 1.0F) * f1;
   }
}