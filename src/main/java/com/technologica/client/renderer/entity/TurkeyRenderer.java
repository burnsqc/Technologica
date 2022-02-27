package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.TurkeyModel;
import com.technologica.world.entity.animal.Turkey;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public final class TurkeyRenderer extends MobRenderer<Turkey, TurkeyModel<Turkey>> {
	private static final ResourceLocation TURKEY_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/turkey.png");

	public TurkeyRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TurkeyModel<>(), 0.4F);
	}

	@Override
	public ResourceLocation getTextureLocation(Turkey entity) {
		return TURKEY_TEXTURE;
	}
	
	@Override
	protected float getBob(Turkey livingBase, float partialTicks) {
	      float f = Mth.lerp(partialTicks, livingBase.oFlap, livingBase.wingRotation);
	      float f1 = Mth.lerp(partialTicks, livingBase.oFlapSpeed, livingBase.destPos);
	      return (Mth.sin(f) + 1.0F) * f1;
	   }
}
