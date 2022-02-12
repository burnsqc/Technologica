package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.OwlModel;
import com.technologica.entity.passive.OwlEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public final class OwlRenderer extends MobRenderer<OwlEntity, OwlModel<OwlEntity>> {
	private static final ResourceLocation OWL_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/owl.png");

	public OwlRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new OwlModel<>(), 0.3F);
	}

	@Override
	public ResourceLocation getEntityTexture(OwlEntity entity) {
		return OWL_TEXTURE;
	}
	
	@Override
	public float handleRotationFloat(OwlEntity livingBase, float partialTicks) {
		float f = MathHelper.lerp(partialTicks, livingBase.oFlap, livingBase.flap);
		float f1 = MathHelper.lerp(partialTicks, livingBase.oFlapSpeed, livingBase.flapSpeed);
		return (MathHelper.sin(f) + 1.0F) * f1;
	}
}
