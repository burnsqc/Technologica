package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import com.technologica.entity.passive.JaguarEntity;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class JaguarModel<T extends JaguarEntity> extends AgeableModel<T> {
	protected final ModelRenderer legBackLeft;
	protected final ModelRenderer legBackRight;
	protected final ModelRenderer legFrontLeft;
	protected final ModelRenderer legFrontRight;
	protected final ModelRenderer tail;
	protected final ModelRenderer tail2;
	protected final ModelRenderer head;
	protected final ModelRenderer body;
	private final ModelRenderer nose; 
	private ModelRenderer earRight;
	private ModelRenderer earLeft;
	protected int state = 1;

	public JaguarModel() {
		super(true, 10.0F, 4.0F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 9.0F, -6.0F);
		this.head.addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 6.0F);
		
		this.nose = new ModelRenderer(this, 0, 0);
		this.nose.addBox(-2.0F, 0.0F, -8.0F, 4.0F, 3.0F, 2.0F);
		this.head.addChild(this.nose);
		
		this.earRight = new ModelRenderer(this, 0, 16);
		this.earRight.addBox(0.0F, -1.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		this.earRight.setRotationPoint(-3.0F, -3.0F, -3.0F);
		this.head.addChild(this.earRight);

		this.earLeft = new ModelRenderer(this, 0, 16);
		this.earLeft.addBox(-1.0F, -1.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		this.earLeft.setRotationPoint(3.0F, -3.0F, -3.0F);
		this.head.addChild(this.earLeft);
		
		this.body = new ModelRenderer(this, 20, 0);
		this.body.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 16.0F, 8.0F);
		this.body.setRotationPoint(0.0F, 12.0F, 0.0F);

		this.tail = new ModelRenderer(this, 0, 15);
		this.tail.addBox(-1.5F, 0.0F, -3.0F, 3.0F, 8.0F, 3.0F);
		this.tail.rotateAngleX = 0.9F;
		this.tail.setRotationPoint(0.0F, 8.0F, 8.0F);

		this.tail2 = new ModelRenderer(this, 4, 15);
		this.tail2.addBox(-1.5F, 0.0F, 0.0F, 3.0F, 8.0F, 3.0F);
		this.tail2.setRotationPoint(0.0F, 20.0F, 14.0F);

		this.legBackLeft = new ModelRenderer(this, 8, 13);
		this.legBackLeft.addBox(-1.0F, 0.0F, -3.0F, 3.0F, 8.0F, 3.0F);
		this.legBackLeft.setRotationPoint(2.0F, 16.0F, 8.0F);

		this.legBackRight = new ModelRenderer(this, 8, 13);
		this.legBackRight.addBox(-1.0F, 0.0F, -3.0F, 3.0F, 8.0F, 3.0F);
		this.legBackRight.setRotationPoint(-3.0F, 16.0F, 8.0F);

		this.legFrontLeft = new ModelRenderer(this, 40, 0);
		this.legFrontLeft.addBox(-1.0F, 0.0F, 0.0F, 3.0F, 8.0F, 3.0F);
		this.legFrontLeft.setRotationPoint(2.0F, 16.0F, -8.0F);

		this.legFrontRight = new ModelRenderer(this, 40, 0);
		this.legFrontRight.addBox(-1.0F, 0.0F, 0.0F, 3.0F, 8.0F, 3.0F);
		this.legFrontRight.setRotationPoint(-3.0F, 16.0F, -8.0F);
	}

	protected Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of(this.head);
	}

	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.body, this.legBackLeft, this.legBackRight, this.legFrontLeft, this.legFrontRight, this.tail, this.tail2);
	}

	/**
	 * Sets this entity's model rotation angles
	 */
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		if (this.state != 3) {
			this.body.rotateAngleX = ((float) Math.PI / 2F);
			if (this.state == 2) {
				this.legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
				this.legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 0.3F) * limbSwingAmount;
				this.legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI + 0.3F)
						* limbSwingAmount;
				this.legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI)
						* limbSwingAmount;
				this.tail2.rotateAngleX = 1.7278761F
						+ ((float) Math.PI / 10F) * MathHelper.cos(limbSwing) * limbSwingAmount;
			} else {
				this.legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
				this.legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI)
						* limbSwingAmount;
				this.legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI)
						* limbSwingAmount;
				this.legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
				if (this.state == 1) {
					this.tail2.rotateAngleX = 1.7278761F
							+ ((float) Math.PI / 4F) * MathHelper.cos(limbSwing) * limbSwingAmount;
				} else {
					this.tail2.rotateAngleX = 1.7278761F + 0.47123894F * MathHelper.cos(limbSwing) * limbSwingAmount;
				}
			}
		}
		
		this.earLeft.rotateAngleZ = -3 * (float) Math.PI / 4;
		this.earRight.rotateAngleZ = 3 * (float) Math.PI / 4;
	}

	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		
		
		this.tail.rotateAngleX = 0.9F;
		if (entityIn.isCrouching()) {
			++this.body.rotationPointY;
			this.head.rotationPointY += 2.0F;
			++this.tail.rotationPointY;
			
			this.tail.rotateAngleX = ((float) Math.PI / 2F);
			this.tail2.rotateAngleX = ((float) Math.PI / 2F);
			this.state = 0;
		} else if (entityIn.isSprinting()) {
			
			this.tail.rotateAngleX = ((float) Math.PI / 2F);
			this.tail2.rotateAngleX = ((float) Math.PI / 2F);
			this.state = 2;
		} else {
			this.state = 1;
		}

	}
}