package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import com.technologica.entity.passive.LionEntity;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class LionModel<T extends LionEntity> extends AgeableModel<T> {
	protected final ModelRenderer legBackLeft;
	protected final ModelRenderer legBackRight;
	protected final ModelRenderer legFrontLeft;
	protected final ModelRenderer legFrontRight;
	protected final ModelRenderer tail;
	protected final ModelRenderer head;
	protected final ModelRenderer body;
	private final ModelRenderer nose; 
	private final ModelRenderer earRight;
	private final ModelRenderer earLeft;
	private final ModelRenderer mane;
	private final ModelRenderer mane2;
	private final ModelRenderer mane3;
	protected int state = 1;

	public LionModel() {
		super(true, 10.0F, 4.0F);
		this.textureWidth = 64;
		this.textureHeight = 64;
		
		this.head = new ModelRenderer(this, 0, 44);
		this.head.setRotationPoint(0.0F, 9.0F, -8.0F);
		this.head.addBox(-4.0F, -4.0F, -7.0F, 8.0F, 8.0F, 7.0F);
		
		this.nose = new ModelRenderer(this, 0, 0);
		this.nose.addBox(-2.0F, -1.0F, -9.0F, 4.0F, 5.0F, 2.0F);
		this.head.addChild(this.nose);
		
		this.earRight = new ModelRenderer(this, 0, 7);
		this.earRight.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 1.0F);
		this.earRight.setRotationPoint(-4.0F, -4.0F, -5.0F);
		this.head.addChild(this.earRight);

		this.earLeft = new ModelRenderer(this, 0, 7);
		this.earLeft.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 1.0F);
		this.earLeft.setRotationPoint(4.0F, -4.0F, -5.0F);
		this.head.addChild(this.earLeft);
		
		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-5.0F, -5.0F, -10.0F, 10.0F, 10.0F, 20.0F);
		this.body.setRotationPoint(0.0F, 11.0F, 0.0F);

		this.mane = new ModelRenderer(this, 0, 30);
		this.mane.addBox(-6.0F, -7.0F, -12.0F, 12.0F, 12.0F, 2.0F);
		this.body.addChild(this.mane);
		
		this.mane2 = new ModelRenderer(this, 28, 30);
		this.mane2.addBox(-6.5F, -8.0F, -11.0F, 13.0F, 14.0F, 4.0F);
		this.body.addChild(this.mane2);
		
		this.mane3 = new ModelRenderer(this, 0, 30);
		this.mane3.addBox(-6.0F, -6.0F, -7.0F, 12.0F, 12.0F, 2.0F);
		this.body.addChild(this.mane3);
		
		this.tail = new ModelRenderer(this, 12, 0);
		this.tail.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 8.0F, 2.0F);
		this.tail.setRotationPoint(0.0F, 8.0F, 10.0F);

		this.legBackLeft = new ModelRenderer(this, 40, 0);
		this.legBackLeft.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 8.0F, 4.0F);
		this.legBackLeft.setRotationPoint(3.0F, 16.0F, 10.0F);

		this.legBackRight = new ModelRenderer(this, 40, 0);
		this.legBackRight.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 8.0F, 4.0F);
		this.legBackRight.setRotationPoint(-3.0F, 16.0F, 10.0F);

		this.legFrontLeft = new ModelRenderer(this, 40, 0);
		this.legFrontLeft.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 4.0F);
		this.legFrontLeft.setRotationPoint(3.0F, 16.0F, -10.0F);

		this.legFrontRight = new ModelRenderer(this, 40, 0);
		this.legFrontRight.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 4.0F);
		this.legFrontRight.setRotationPoint(-3.0F, 16.0F, -10.0F);
	}

	protected Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of(this.head);
	}

	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.body, this.legBackLeft, this.legBackRight, this.legFrontLeft, this.legFrontRight, this.tail);
	}

	/**
	 * Sets this entity's model rotation angles
	 */
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		if (this.state != 3) {
			if (this.state == 2) {
				this.legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
				this.legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 0.3F) * limbSwingAmount;
				this.legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI + 0.3F) * limbSwingAmount;
				this.legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
			} else {
				this.legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
				this.legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
				this.legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
				this.legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
			}
		}
		
		this.earLeft.rotateAngleZ = -3 * (float) Math.PI / 4;
		this.earRight.rotateAngleZ = 3 * (float) Math.PI / 4;
	}

	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		this.tail.rotateAngleX = (float) Math.PI / 6;
		if (entityIn.isCrouching()) {
			++this.body.rotationPointY;
			this.head.rotationPointY += 2.0F;
			++this.tail.rotationPointY;
			this.tail.rotateAngleX = ((float) Math.PI / 2F);
			this.state = 0;
		} else if (entityIn.isSprinting()) {
			this.tail.rotateAngleX = ((float) Math.PI / 2F);
			this.state = 2;
		} else {
			this.state = 1;
		}
	}
}