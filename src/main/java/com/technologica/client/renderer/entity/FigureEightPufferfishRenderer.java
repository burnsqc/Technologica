package com.technologica.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.technologica.Technologica;
import com.technologica.client.model.FigureEightPufferfishBigModel;
import com.technologica.client.model.FigureEightPufferfishMidModel;
import com.technologica.client.model.FigureEightPufferfishSmallModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.FigureEightPufferfish;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class FigureEightPufferfishRenderer extends MobRenderer<FigureEightPufferfish, EntityModel<FigureEightPufferfish>> {
   private static final ResourceLocation PUFFER_LOCATION = new ResourceLocation(Technologica.MODID, "textures/entity/fish/figure_eight_pufferfish.png");
   private int puffStateO = 3;
   private final EntityModel<FigureEightPufferfish> small;
   private final EntityModel<FigureEightPufferfish> mid;
   private final EntityModel<FigureEightPufferfish> big = this.getModel();

   public FigureEightPufferfishRenderer(EntityRendererProvider.Context p_174358_) {
      super(p_174358_, new FigureEightPufferfishBigModel<>(p_174358_.bakeLayer(TechnologicaModelLayers.FIGURE_EIGHT_PUFFERFISH_BIG)), 0.2F);
      this.mid = new FigureEightPufferfishMidModel<>(p_174358_.bakeLayer(TechnologicaModelLayers.FIGURE_EIGHT_PUFFERFISH_MEDIUM));
      this.small = new FigureEightPufferfishSmallModel<>(p_174358_.bakeLayer(TechnologicaModelLayers.FIGURE_EIGHT_PUFFERFISH_SMALL));
   }

   @Override
public ResourceLocation getTextureLocation(FigureEightPufferfish p_115775_) {
      return PUFFER_LOCATION;
   }

   @Override
   public void render(FigureEightPufferfish p_115777_, float p_115778_, float p_115779_, PoseStack p_115780_, MultiBufferSource p_115781_, int p_115782_) {
      int i = p_115777_.getPuffState();
      if (i != this.puffStateO) {
         if (i == 0) {
            this.model = this.small;
         } else if (i == 1) {
            this.model = this.mid;
         } else {
            this.model = this.big;
         }
      }

      this.puffStateO = i;
      this.shadowRadius = 0.1F + 0.1F * i;
      super.render(p_115777_, p_115778_, p_115779_, p_115780_, p_115781_, p_115782_);
   }

   @Override
protected void setupRotations(FigureEightPufferfish p_115784_, PoseStack p_115785_, float p_115786_, float p_115787_, float p_115788_) {
      p_115785_.translate(0.0D, Mth.cos(p_115786_ * 0.05F) * 0.08F, 0.0D);
      super.setupRotations(p_115784_, p_115785_, p_115786_, p_115787_, p_115788_);
   }
}