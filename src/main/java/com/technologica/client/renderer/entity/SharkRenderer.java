package com.technologica.client.renderer.entity;

import com.technologica.MainMod;
import com.technologica.client.renderer.entity.model.SharkModel;
import com.technologica.entity.monster.SharkEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SharkRenderer extends MobRenderer<SharkEntity, SharkModel<SharkEntity>> {
   private static final ResourceLocation SHARK_TEXTURE = new ResourceLocation(MainMod.MODID, "textures/entity/shark.png");

   public SharkRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new SharkModel<>(), 0.7F);
   }

   public ResourceLocation getEntityTexture(SharkEntity entity) {
      return SHARK_TEXTURE;
   }
}
