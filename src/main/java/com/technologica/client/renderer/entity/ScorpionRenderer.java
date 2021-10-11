package com.technologica.client.renderer.entity;

import com.technologica.client.renderer.entity.model.ScorpionModel;
import com.technologica.entity.monster.ScorpionEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ScorpionRenderer<T extends ScorpionEntity> extends MobRenderer<T, ScorpionModel<T>> {
	private static final ResourceLocation SCORPION_TEXTURES = new ResourceLocation("textures/entity/spider/spider.png");

	   public ScorpionRenderer(EntityRendererManager renderManagerIn) {
	      super(renderManagerIn, new ScorpionModel<>(), 0.8F);
//	      this.addLayer(new SpiderEyesLayer<>(this));
	   }

	   protected float getDeathMaxRotation(T entityLivingBaseIn) {
	      return 180.0F;
	   }

	   /**
	    * Returns the location of an entity's texture.
	    */
	   public ResourceLocation getEntityTexture(T entity) {
	      return SCORPION_TEXTURES;
	   }
}
