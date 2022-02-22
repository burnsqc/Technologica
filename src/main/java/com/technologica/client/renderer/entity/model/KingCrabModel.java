package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class KingCrabModel<T extends Entity> extends SegmentedModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer head;
	
	private final ModelRenderer legBackBackLeftUpper;
	private final ModelRenderer legBackBackLeftLower;
	private final ModelRenderer legBackBackRightUpper;
	private final ModelRenderer legBackBackRightLower;
	private final ModelRenderer legBackRightUpper;
	private final ModelRenderer legBackRightLower;
	private final ModelRenderer legBackLeftUpper;
	private final ModelRenderer legBackLeftLower;
	private final ModelRenderer legFrontRightUpper;
	private final ModelRenderer legFrontRightLower;
	private final ModelRenderer legFrontLeftUpper;
	private final ModelRenderer legFrontLeftLower;
	private final ModelRenderer legFrontFrontRightUpper;
	private final ModelRenderer legFrontFrontRightLower;
	private final ModelRenderer legFrontFrontLeftUpper;
	private final ModelRenderer legFrontFrontLeftLower;
	
	private final ModelRenderer armLeft;
	private final ModelRenderer armRight;
	private final ModelRenderer clawLeft;
	private final ModelRenderer clawRight;
	private final ModelRenderer pincherLeft;
	private final ModelRenderer pincherRight;
	
	public KingCrabModel() {
		this.texWidth = 64;
		this.texHeight = 32;

		this.body = new ModelRenderer(this, 0, 0);
		this.body.setPos(0.0F, 6.0F, 0.0F);
		this.body.addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 7.0F);
		
		this.head = new ModelRenderer(this, 0, 11);
		this.head.setPos(0.0F, -1.0F, -3.0F);
		this.head.addBox(-2.0F, -1.0F, -2.0F, 4.0F, 2.0F, 4.0F);
		this.body.addChild(this.head);
		
		this.legBackBackLeftUpper = new ModelRenderer(this, 0, 17);
		this.legBackBackLeftUpper.setPos(4.0F, 7.0F, 2.0F);
		this.legBackBackLeftUpper.addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F);
		
		this.legBackBackLeftLower = new ModelRenderer(this, 0, 17);
		this.legBackBackLeftLower.setPos(15.0F, 1.0F, 0.0F);
		this.legBackBackLeftLower.addBox(0.0F, 0.0F, -1.0F, 16.0F, 2.0F, 2.0F);
		this.legBackBackLeftUpper.addChild(this.legBackBackLeftLower);
		
		this.legBackBackRightUpper = new ModelRenderer(this, 0, 17);
		this.legBackBackRightUpper.setPos(-4.0F, 7.0F, 2.0F);
		this.legBackBackRightUpper.addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F);
		
		this.legBackBackRightLower = new ModelRenderer(this, 0, 17);
		this.legBackBackRightLower.setPos(-15.0F, 1.0F, 0.0F);
		this.legBackBackRightLower.addBox(-16.0F, 0.0F, -1.0F, 16.0F, 2.0F, 2.0F);
		this.legBackBackRightUpper.addChild(this.legBackBackRightLower);
		
		this.legBackLeftUpper = new ModelRenderer(this, 0, 17);
		this.legBackLeftUpper.setPos(4.0F, 7.0F, 1.0F);
		this.legBackLeftUpper.addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F);
		
		this.legBackLeftLower = new ModelRenderer(this, 0, 17);
		this.legBackLeftLower.setPos(15.0F, 1.0F, 0.0F);
		this.legBackLeftLower.addBox(0.0F, 0.0F, -1.0F, 16.0F, 2.0F, 2.0F);
		this.legBackLeftUpper.addChild(this.legBackLeftLower);
		
		this.legBackRightUpper = new ModelRenderer(this, 0, 17);
		this.legBackRightUpper.setPos(-4.0F, 7.0F, 1.0F);
		this.legBackRightUpper.addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F);

		this.legBackRightLower = new ModelRenderer(this, 0, 17);
		this.legBackRightLower.setPos(-15.0F, 1.0F, 0.0F);
		this.legBackRightLower.addBox(-16.0F, 0.0F, -1.0F, 16.0F, 2.0F, 2.0F);
		this.legBackRightUpper.addChild(this.legBackRightLower);

		this.legFrontLeftUpper = new ModelRenderer(this, 0, 17);
		this.legFrontLeftUpper.setPos(4.0F, 7.0F, 0.0F);
		this.legFrontLeftUpper.addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F);
		
		this.legFrontLeftLower = new ModelRenderer(this, 0, 17);
		this.legFrontLeftLower.setPos(15.0F, 1.0F, 0.0F);
		this.legFrontLeftLower.addBox(0.0F, 0.0F, -1.0F, 16.0F, 2.0F, 2.0F);
		this.legFrontLeftUpper.addChild(this.legFrontLeftLower);
		
		this.legFrontRightUpper = new ModelRenderer(this, 0, 17);
		this.legFrontRightUpper.setPos(-4.0F, 7.0F, 0.0F);
		this.legFrontRightUpper.addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F);

		this.legFrontRightLower = new ModelRenderer(this, 0, 17);
		this.legFrontRightLower.setPos(-15.0F, 1.0F, 0.0F);
		this.legFrontRightLower.addBox(-16.0F, 0.0F, -1.0F, 16.0F, 2.0F, 2.0F);
		this.legFrontRightUpper.addChild(this.legFrontRightLower);

		this.legFrontFrontLeftUpper = new ModelRenderer(this, 0, 17);
		this.legFrontFrontLeftUpper.setPos(4.0F, 7.0F, -1.0F);
		this.legFrontFrontLeftUpper.addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F);
		
		this.legFrontFrontLeftLower = new ModelRenderer(this, 0, 17);
		this.legFrontFrontLeftLower.setPos(15.0F, 1.0F, 0.0F);
		this.legFrontFrontLeftLower.addBox(0.0F, 0.0F, -1.0F, 16.0F, 2.0F, 2.0F);
		this.legFrontFrontLeftUpper.addChild(this.legFrontFrontLeftLower);
		
		this.legFrontFrontRightUpper = new ModelRenderer(this, 0, 17);
		this.legFrontFrontRightUpper.setPos(-4.0F, 7.0F, -1.0F);
		this.legFrontFrontRightUpper.addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F);

		this.legFrontFrontRightLower = new ModelRenderer(this, 0, 17);
		this.legFrontFrontRightLower.setPos(-15.0F, 1.0F, 0.0F);
		this.legFrontFrontRightLower.addBox(-16.0F, 0.0F, -1.0F, 16.0F, 2.0F, 2.0F);
		this.legFrontFrontRightUpper.addChild(this.legFrontFrontRightLower);
		
		this.armLeft = new ModelRenderer(this, 0, 21);
		this.armLeft.setPos(4.0F, 1.0F, -3.0F);
		this.armLeft.addBox(-2.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F);
		this.body.addChild(this.armLeft);
		
		this.armRight = new ModelRenderer(this, 0, 21);
		this.armRight.setPos(-4.0F, 1.0F, -3.0F);
		this.armRight.addBox(-8.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F);
		this.body.addChild(this.armRight);

		this.clawLeft = new ModelRenderer(this, 0, 21);
		this.clawLeft.setPos(8.0F, 0.0F, 1.0F);
		this.clawLeft.addBox(0.0F, -1.0F, -2.0F, 10.0F, 2.0F, 2.0F);
		this.armLeft.addChild(this.clawLeft);
		
		this.clawRight = new ModelRenderer(this, 0, 21);
		this.clawRight.setPos(-8.0F, 0.0F, 1.0F);
		this.clawRight.addBox(0.0F, -1.0F, 0.0F, 10.0F, 2.0F, 2.0F);
		this.armRight.addChild(this.clawRight);
		
		this.pincherLeft = new ModelRenderer(this, 0, 25);
		this.pincherLeft.setPos(5.0F, 0.0F, 0.0F);
		this.pincherLeft.addBox(0.0F, -1.0F, -2.0F, 5.0F, 2.0F, 2.0F);
		this.clawLeft.addChild(this.pincherLeft);

		this.pincherRight = new ModelRenderer(this, 0, 25);
		this.pincherRight.setPos(5.0F, 0.0F, 0.0F);
		this.pincherRight.addBox(0.0F, -1.0F, 0.0F, 5.0F, 2.0F, 2.0F);
		this.pincherRight.mirror = true;
		this.clawRight.addChild(this.pincherRight);
	}

	public Iterable<ModelRenderer> parts() {
		return ImmutableList.of(this.body, this.legBackBackRightUpper, this.legBackBackLeftUpper, this.legBackRightUpper, this.legBackLeftUpper, this.legFrontRightUpper, this.legFrontLeftUpper, this.legFrontFrontRightUpper, this.legFrontFrontLeftUpper);
	}

	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = ((float) Math.PI / 4F);
		
		this.legBackBackRightUpper.zRot = 0;
		this.legBackBackLeftUpper.zRot = 0;
		this.legBackRightUpper.zRot = 0;
		this.legBackLeftUpper.zRot = 0;
		this.legFrontRightUpper.zRot = 0;
		this.legFrontLeftUpper.zRot = 0;
		this.legFrontFrontRightUpper.zRot = 0;
		this.legFrontFrontLeftUpper.zRot = 0;
		
		this.legBackBackRightUpper.yRot = ((float) Math.PI / 4F);
		this.legBackBackLeftUpper.yRot = -((float) Math.PI / 4F);
		this.legBackRightUpper.yRot = ((float) Math.PI / 8F);
		this.legBackLeftUpper.yRot = -((float) Math.PI / 8F);
		this.legFrontRightUpper.yRot = 0;
		this.legFrontLeftUpper.yRot = 0;
		this.legFrontFrontRightUpper.yRot = -((float) Math.PI / 8F);
		this.legFrontFrontLeftUpper.yRot = ((float) Math.PI / 8F);
		
		this.legBackBackLeftLower.zRot = (float) Math.PI / 2;
		this.legBackBackRightLower.zRot = -(float) Math.PI / 2;
		this.legBackLeftLower.zRot = (float) Math.PI / 2;
		this.legBackRightLower.zRot = -(float) Math.PI / 2;
		this.legFrontLeftLower.zRot = (float) Math.PI / 2;
		this.legFrontRightLower.zRot = -(float) Math.PI / 2;
		this.legFrontFrontLeftLower.zRot = (float) Math.PI / 2;
		this.legFrontFrontRightLower.zRot = -(float) Math.PI / 2;

		float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
		float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float) Math.PI) * 0.4F) * limbSwingAmount;
		float f5 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float) Math.PI / 2F)) * 0.4F) * limbSwingAmount;
		float f6 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float) Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
		float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
		float f8 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float) Math.PI) * 0.4F) * limbSwingAmount;
		float f9 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float) Math.PI / 2F)) * 0.4F) * limbSwingAmount;
		float f10 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float) Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
		
		this.legBackBackRightUpper.yRot += f3;
		this.legBackBackLeftUpper.yRot += -f3;
		this.legBackRightUpper.yRot += f4;
		this.legBackLeftUpper.yRot += -f4;
		this.legFrontRightUpper.yRot += f5;
		this.legFrontLeftUpper.yRot += -f5;
		this.legFrontFrontRightUpper.yRot += f6;
		this.legFrontFrontLeftUpper.yRot += -f6;
		this.legBackBackRightUpper.zRot += f7;
		this.legBackBackLeftUpper.zRot += -f7;
		this.legBackRightUpper.zRot += f8;
		this.legBackLeftUpper.zRot += -f8;
		this.legFrontRightUpper.zRot += f9;
		this.legFrontLeftUpper.zRot += -f9;
		this.legFrontFrontRightUpper.zRot += f10;
		this.legFrontFrontLeftUpper.zRot += -f10;
		
		this.armLeft.yRot = (float) Math.PI / 4F;
		this.armRight.yRot = - (float) Math.PI / 4F;
		this.clawLeft.yRot = (float) Math.PI / 4F;
		this.clawRight.yRot = 3 *(float) Math.PI / 4F;
		this.pincherLeft.yRot = (float) Math.PI / 4F;
		this.pincherRight.yRot = -(float) Math.PI / 4F;
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}