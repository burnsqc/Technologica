package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.TurkeyModel;
import com.technologica.entity.passive.TurkeyEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public final class TurkeyRenderer extends MobRenderer<TurkeyEntity, TurkeyModel<TurkeyEntity>> {
	private static final ResourceLocation TURKEY_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/turkey.png");

	public TurkeyRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new TurkeyModel<>(), 0.4F);
	}

	@Override
	public ResourceLocation getTextureLocation(TurkeyEntity entity) {
		return TURKEY_TEXTURE;
	}
	
	@Override
	protected float getBob(TurkeyEntity livingBase, float partialTicks) {
	      float f = MathHelper.lerp(partialTicks, livingBase.oFlap, livingBase.wingRotation);
	      float f1 = MathHelper.lerp(partialTicks, livingBase.oFlapSpeed, livingBase.destPos);
	      return (MathHelper.sin(f) + 1.0F) * f1;
	   }
}
