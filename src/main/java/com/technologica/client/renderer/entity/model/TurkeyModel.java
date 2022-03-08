package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.math.MathHelper;

public class TurkeyModel<T extends AnimalEntity> extends AgeableModel<T> {

	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftLeg;
	private final ModelRenderer rightWing;
	private final ModelRenderer leftWing;
	private final ModelRenderer bill;
	private final ModelRenderer chin;
	private final ModelRenderer tail;

	public TurkeyModel() {
		textureWidth = 64;
		textureHeight = 32;
		
		this.head = new ModelRenderer(this, 0, 16);
		this.head.addBox(-2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 4.0F);
		this.head.setRotationPoint(0.0F, 11.0F, -1.0F);
		
		this.bill = new ModelRenderer(this, 12, 16);
		this.bill.addBox(-2.0F, 0.0F, -6.0F, 4.0F, 2.0F, 2.0F);
		this.head.addChild(this.bill);
		
		this.chin = new ModelRenderer(this, 0, 0);
		this.chin.addBox(-1.0F, 2.0F, -4.0F, 2.0F, 3.0F, 1.0F);
		this.head.addChild(this.chin);
		
		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F);
		this.body.setRotationPoint(0.0F, 15.0F, 0.0F);
		
		this.rightLeg = new ModelRenderer(this, 34, 13);
		this.rightLeg.addBox(-1.0F, 0.0F, -3.0F, 3.0F, 5.0F, 3.0F);
		this.rightLeg.setRotationPoint(-2.0F, 19.0F, 1.0F);
		
		this.leftLeg = new ModelRenderer(this, 34, 13);
		this.leftLeg.addBox(-1.0F, 0.0F, -3.0F, 3.0F, 5.0F, 3.0F);
		this.leftLeg.setRotationPoint(1.0F, 19.0F, 1.0F);
		
		this.rightWing = new ModelRenderer(this, 24, 13);
		this.rightWing.addBox(-1.0F, -2.0F, 0.0F, 1.0F, 4.0F, 8.0F);
		this.rightWing.setRotationPoint(-4.0F, 13.0F, -2.0F);
		
		this.leftWing = new ModelRenderer(this, 24, 13);
		this.leftWing.addBox(0.0F, -2.0F, 0.0F, 1.0F, 4.0F, 8.0F);
		this.leftWing.setRotationPoint(4.0F, 13.0F, -2.0F);
		
		this.tail = new ModelRenderer(this, 32, 0);
		this.tail.addBox(0.0F, 0.0F, 0.0F, 12.0F, 12.0F, 1.0F);
		this.tail.setRotationPoint(0.0F, 4.0F, 4.0F);
		this.body.addChild(this.tail);
	}

	@Override
	protected Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of(this.head);
	}

	@Override
	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.body, this.rightLeg, this.leftLeg, this.rightWing, this.leftWing);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		
		this.rightWing.rotateAngleX = -(float) Math.PI / 4;
		this.leftWing.rotateAngleX = -(float) Math.PI / 4;
		this.tail.rotateAngleZ = -3 * (float) Math.PI / 4;
		this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
	    this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
	    
	    this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	    this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
	    this.rightWing.rotateAngleZ = ageInTicks;
	    this.leftWing.rotateAngleZ = -ageInTicks;
	}

}
