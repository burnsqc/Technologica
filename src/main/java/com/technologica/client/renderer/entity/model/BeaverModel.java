package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import com.technologica.entity.passive.BeaverEntity;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class BeaverModel<T extends BeaverEntity> extends QuadrupedModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer head;
	/*
	
	private final ModelRenderer rabbitLeftFoot = new ModelRenderer(this, 26, 24);
	private final ModelRenderer rabbitRightFoot;
	private final ModelRenderer rabbitLeftThigh;
	private final ModelRenderer rabbitRightThigh;

	private final ModelRenderer rabbitLeftArm;
	private final ModelRenderer rabbitRightArm;
	private final ModelRenderer rabbitHead;
	private final ModelRenderer rabbitRightEar;
	private final ModelRenderer rabbitLeftEar;
	private final ModelRenderer rabbitTail;
	private final ModelRenderer rabbitNose;
	private float jumpRotation;
	*/

	public BeaverModel() {
		super(12, 0.0F, false, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		this.body = new ModelRenderer(this, 0, 32);
		this.body.addBox(-5.0F, 11.0F, -7.0F, 12.0F, 11.0F, 16.0F);
		this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
			   
		this.head = new ModelRenderer(this, 0, 32);
		this.head.addBox(-3.0F, 2.0F, -4.0F, 4.0F, 3.0F, 3.0F);
		this.head.setRotationPoint(0.0F, 19.0F, 8.0F);
		this.body.addChild(this.head);
	}

	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      
	}

	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	}

	@Override
	protected Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of(this.head);
	}
	
	@Override
	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.body);
	}
}