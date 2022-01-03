package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.AnimalEntity;

public class PenguinModel<T extends AnimalEntity> extends AgeableModel<T> {

	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftLeg;
	private final ModelRenderer rightWing;
	private final ModelRenderer leftWing;
	private final ModelRenderer bill;

	public PenguinModel() {
		this.textureWidth = 32;
		this.textureHeight = 32;
		
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-2.0F, -12.0F, 2.0F, 4.0F, 4.0F, 4.0F, 0.0F);
		this.head.setRotationPoint(0.0F, 15.0F, -4.0F);
		this.bill = new ModelRenderer(this, 0, 8);
		this.bill.addBox(-1.0F, -10.0F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F);
		this.bill.setRotationPoint(0.0F, 15.0F, -4.0F);
		this.body = new ModelRenderer(this, 8, 9);
		this.body.addBox(-3.0F, -9.0F, -3.0F, 6.0F, 14.0F, 6.0F, 0.0F);
		this.body.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.rightLeg = new ModelRenderer(this, 18, 0);
		this.rightLeg.addBox(-1.0F, 2.0F, -3.0F, 3.0F, 3.0F, 3.0F);
		this.rightLeg.setRotationPoint(-2.0F, 19.0F, 1.0F);
		this.leftLeg = new ModelRenderer(this, 18, 0);
		this.leftLeg.addBox(-1.0F, 2.0F, -3.0F, 3.0F, 3.0F, 3.0F);
		this.leftLeg.setRotationPoint(1.0F, 19.0F, 1.0F);
		this.rightWing = new ModelRenderer(this, 0, 12);
		this.rightWing.addBox(0.0F, -4.0F, -1.0F, 1.0F, 8.0F, 3.0F);
		this.rightWing.setRotationPoint(-4.0F, 13.0F, 0.0F);
		this.leftWing = new ModelRenderer(this, 0, 12);
		this.leftWing.addBox(-1.0F, -4.0F, -1.0F, 1.0F, 8.0F, 3.0F);
		this.leftWing.setRotationPoint(4.0F, 13.0F, 0.0F);
	}

	@Override
	protected Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of(this.head, this.bill);
	}

	@Override
	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.body, this.rightLeg, this.leftLeg, this.rightWing, this.leftWing);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

}
