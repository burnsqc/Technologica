package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.OwlModel;
import com.technologica.world.entity.animal.OwlEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public final class OwlRenderer extends MobRenderer<OwlEntity, OwlModel<OwlEntity>> {
	private static final ResourceLocation OWL_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/owl.png");

	public OwlRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new OwlModel<>(), 0.3F);
	}

	@Override
	public ResourceLocation getTextureLocation(OwlEntity entity) {
		return OWL_TEXTURE;
	}
	
	@Override
	public float getBob(OwlEntity livingBase, float partialTicks) {
		float f = Mth.lerp(partialTicks, livingBase.oFlap, livingBase.flap);
		float f1 = Mth.lerp(partialTicks, livingBase.oFlapSpeed, livingBase.flapSpeed);
		return (Mth.sin(f) + 1.0F) * f1;
	}
}
