package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import com.technologica.entity.passive.JaguarEntity;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

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
		this.texWidth = 64;
		this.texHeight = 32;
		
		this.head = new ModelRenderer(this, 32, 0);
		this.head.setPos(0.0F, 9.0F, -6.0F);
		this.head.addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 6.0F);
		
		this.nose = new ModelRenderer(this, 24, 0);
		this.nose.addBox(-1.5F, 0.0F, -8.0F, 3.0F, 3.0F, 2.0F);
		this.head.addChild(this.nose);
		
		this.earRight = new ModelRenderer(this, 50, 0);
		this.earRight.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 1.0F);
		this.earRight.setPos(-3.0F, -3.0F, -3.0F);
		this.head.addChild(this.earRight);

		this.earLeft = new ModelRenderer(this, 50, 0);
		this.earLeft.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 1.0F);
		this.earLeft.setPos(3.0F, -3.0F, -3.0F);
		this.head.addChild(this.earLeft);
		
		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 16.0F, 8.0F);
		this.body.setPos(0.0F, 12.0F, 0.0F);

		this.tail = new ModelRenderer(this, 56, 0);
		this.tail.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 8.0F, 2.0F);
		this.tail.xRot = 0.9F;
		this.tail.setPos(0.0F, 8.0F, 8.0F);

		this.tail2 = new ModelRenderer(this, 56, 10);
		this.tail2.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F);
		this.tail2.setPos(0.0F, 8.0F, -2.0F);
		this.tail.addChild(this.tail2);

		this.legBackLeft = new ModelRenderer(this, 32, 12);
		this.legBackLeft.addBox(-1.0F, 0.0F, -3.0F, 3.0F, 8.0F, 3.0F);
		this.legBackLeft.setPos(2.0F, 16.0F, 8.0F);

		this.legBackRight = new ModelRenderer(this, 32, 12);
		this.legBackRight.addBox(-1.0F, 0.0F, -3.0F, 3.0F, 8.0F, 3.0F);
		this.legBackRight.setPos(-3.0F, 16.0F, 8.0F);

		this.legFrontLeft = new ModelRenderer(this, 32, 12);
		this.legFrontLeft.addBox(-1.0F, 0.0F, 0.0F, 3.0F, 8.0F, 3.0F);
		this.legFrontLeft.setPos(2.0F, 16.0F, -8.0F);

		this.legFrontRight = new ModelRenderer(this, 32, 12);
		this.legFrontRight.addBox(-1.0F, 0.0F, 0.0F, 3.0F, 8.0F, 3.0F);
		this.legFrontRight.setPos(-3.0F, 16.0F, -8.0F);
	}

	protected Iterable<ModelRenderer> headParts() {
		return ImmutableList.of(this.head);
	}

	protected Iterable<ModelRenderer> bodyParts() {
		return ImmutableList.of(this.body, this.legBackLeft, this.legBackRight, this.legFrontLeft, this.legFrontRight, this.tail);
	}

	/**
	 * Sets this entity's model rotation angles
	 */
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.xRot = headPitch * ((float) Math.PI / 180F);
		this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
		if (this.state != 3) {
			this.body.xRot = ((float) Math.PI / 2F);
			if (this.state == 2) {
				this.legBackLeft.xRot = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
				this.legBackRight.xRot = MathHelper.cos(limbSwing * 0.6662F + 0.3F) * limbSwingAmount;
				this.legFrontLeft.xRot = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI + 0.3F) * limbSwingAmount;
				this.legFrontRight.xRot = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
				this.tail2.xRot = 0.7278761F + ((float) Math.PI / 10F) * MathHelper.cos(limbSwing) * limbSwingAmount;
			} else {
				this.legBackLeft.xRot = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
				this.legBackRight.xRot = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
				this.legFrontLeft.xRot = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
				this.legFrontRight.xRot = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
				if (this.state == 1) {
					this.tail2.xRot = 0.7278761F + ((float) Math.PI / 4F) * MathHelper.cos(limbSwing) * limbSwingAmount;
				} else {
					this.tail2.xRot = 0.7278761F + 0.47123894F * MathHelper.cos(limbSwing) * limbSwingAmount;
				}
			}
		}
		
		this.earLeft.zRot = -3 * (float) Math.PI / 4;
		this.earRight.zRot = 3 * (float) Math.PI / 4;
	}

	public void prepareMobModel(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		this.tail.xRot = 0.9F;
		if (entityIn.isCrouching()) {
			++this.body.y;
			this.head.y += 2.0F;
			++this.tail.y;
			this.tail.xRot = ((float) Math.PI / 2F);
			this.tail2.xRot = ((float) Math.PI / 2F);
			this.state = 0;
		} else if (entityIn.isSprinting()) {
			
			this.tail.xRot = ((float) Math.PI / 2F);
			this.tail2.xRot = ((float) Math.PI / 2F);
			this.state = 2;
		} else {
			this.state = 1;
		}
	}
}