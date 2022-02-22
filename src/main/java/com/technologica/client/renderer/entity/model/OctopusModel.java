package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class OctopusModel<T extends Entity> extends SegmentedModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer eyeLeft;
	private final ModelRenderer eyeRight;
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
	
	public OctopusModel() {
		this.texWidth = 64;
		this.texHeight = 32;

		this.body = new ModelRenderer(this, 0, 0);
		this.body.setPos(0.0F, 17.0F, 1.0F);
		this.body.addBox(-3.0F, -6.0F, -3.0F, 6.0F, 8.0F, 6.0F);
		
		this.head = new ModelRenderer(this, 24, 0);
		this.head.setPos(0.0F, -6.0F, -3.0F);
		this.head.addBox(-4.0F, -8.0F, 0.0F, 8.0F, 8.0F, 8.0F);
		this.body.addChild(this.head);
		
		this.eyeLeft = new ModelRenderer(this, 0, 0);
		this.eyeLeft.addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 1.0F, true);
		this.body.addChild(this.eyeLeft);
		
		this.eyeRight = new ModelRenderer(this, 0, 0);
		this.eyeRight.addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 1.0F);
		this.body.addChild(this.eyeRight);
		
		this.legBackBackLeftUpper = new ModelRenderer(this, 0, 14);
		this.legBackBackLeftUpper.setPos(0.0F, 19.0F, 0.0F);
		this.legBackBackLeftUpper.addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F);
		
		this.legBackBackLeftLower = new ModelRenderer(this, 12, 14);
		this.legBackBackLeftLower.setPos(0.0F, 8.0F, 2.5F);
		this.legBackBackLeftLower.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F);
		this.legBackBackLeftUpper.addChild(this.legBackBackLeftLower);
		
		this.legBackBackRightUpper = new ModelRenderer(this, 0, 14);
		this.legBackBackRightUpper.setPos(0.0F, 19.0F, 0.0F);
		this.legBackBackRightUpper.addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F);
		
		this.legBackBackRightLower = new ModelRenderer(this, 12, 14);
		this.legBackBackRightLower.setPos(0.0F, 8.0F, 2.5F);
		this.legBackBackRightLower.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F);
		this.legBackBackRightUpper.addChild(this.legBackBackRightLower);

		this.legBackLeftUpper = new ModelRenderer(this, 0, 14);
		this.legBackLeftUpper.setPos(0.0F, 19.0F, 0.0F);
		this.legBackLeftUpper.addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F);
		
		this.legBackLeftLower = new ModelRenderer(this, 12, 14);
		this.legBackLeftLower.setPos(0.0F, 8.0F, 2.5F);
		this.legBackLeftLower.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F);
		this.legBackLeftUpper.addChild(this.legBackLeftLower);

		this.legBackRightUpper = new ModelRenderer(this, 0, 14);
		this.legBackRightUpper.setPos(0.0F, 19.0F, 0.0F);
		this.legBackRightUpper.addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F);
		
		this.legBackRightLower = new ModelRenderer(this, 12, 14);
		this.legBackRightLower.setPos(0.0F, 8.0F, 2.5F);
		this.legBackRightLower.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F);
		this.legBackRightUpper.addChild(this.legBackRightLower);

		this.legFrontLeftUpper = new ModelRenderer(this, 0, 14);
		this.legFrontLeftUpper.setPos(0.0F, 19.0F, 0.0F);
		this.legFrontLeftUpper.addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F);
		
		this.legFrontLeftLower = new ModelRenderer(this, 12, 14);
		this.legFrontLeftLower.setPos(0.0F, 8.0F, 2.5F);
		this.legFrontLeftLower.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F);
		this.legFrontLeftUpper.addChild(this.legFrontLeftLower);

		this.legFrontRightUpper = new ModelRenderer(this, 0, 14);
		this.legFrontRightUpper.setPos(0.0F, 19.0F, 0.0F);
		this.legFrontRightUpper.addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F);
		
		this.legFrontRightLower = new ModelRenderer(this, 12, 14);
		this.legFrontRightLower.setPos(0.0F, 8.0F, 2.5F);
		this.legFrontRightLower.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F);
		this.legFrontRightUpper.addChild(this.legFrontRightLower);

		this.legFrontFrontLeftUpper = new ModelRenderer(this, 0, 14);
		this.legFrontFrontLeftUpper.setPos(0.0F, 19.0F, 0.0F);
		this.legFrontFrontLeftUpper.addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F);
		
		this.legFrontFrontLeftLower = new ModelRenderer(this, 12, 14);
		this.legFrontFrontLeftLower.setPos(0.0F, 8.0F, 2.5F);
		this.legFrontFrontLeftLower.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F);
		this.legFrontFrontLeftUpper.addChild(this.legFrontFrontLeftLower);

		this.legFrontFrontRightUpper = new ModelRenderer(this, 0, 14);
		this.legFrontFrontRightUpper.setPos(0.0F, 19.0F, 0.0F);
		this.legFrontFrontRightUpper.addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F);
		
		this.legFrontFrontRightLower = new ModelRenderer(this, 12, 14);
		this.legFrontFrontRightLower.setPos(0.0F, 8.0F, 2.5F);
		this.legFrontFrontRightLower.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F);
		this.legFrontFrontRightUpper.addChild(this.legFrontFrontRightLower);
	}

	public Iterable<ModelRenderer> parts() {
		return ImmutableList.of(this.body, this.legBackBackRightUpper, this.legBackBackLeftUpper, this.legBackRightUpper, this.legBackLeftUpper, this.legFrontRightUpper, this.legFrontLeftUpper, this.legFrontFrontRightUpper, this.legFrontFrontLeftUpper);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.xRot = -(float) Math.PI / 4;
		this.head.xRot = -(float) Math.PI / 4;
		
		this.legBackBackLeftUpper.yRot = -(float) Math.PI / 8;
		this.legBackBackRightUpper.yRot = (float) Math.PI / 8;
		this.legBackLeftUpper.yRot = -3 * (float) Math.PI / 8;
		this.legBackRightUpper.yRot = 3 * (float) Math.PI / 8;
		this.legFrontLeftUpper.yRot = -5 * (float) Math.PI / 8;
		this.legFrontRightUpper.yRot = 5 * (float) Math.PI / 8;
		this.legFrontFrontLeftUpper.yRot = -7 * (float) Math.PI / 8;
		this.legFrontFrontRightUpper.yRot = 7 * (float) Math.PI / 8;
		
		this.legBackBackLeftUpper.xRot = (float) Math.PI / 4;
		this.legBackBackRightUpper.xRot = (float) Math.PI / 4;
		this.legBackLeftUpper.xRot = (float) Math.PI / 4;
		this.legBackRightUpper.xRot = (float) Math.PI / 4;
		this.legFrontLeftUpper.xRot = (float) Math.PI / 4;
		this.legFrontRightUpper.xRot = (float) Math.PI / 4;
		this.legFrontFrontLeftUpper.xRot = (float) Math.PI / 4;
		this.legFrontFrontRightUpper.xRot = (float) Math.PI / 4;
		
		this.legBackBackLeftLower.xRot = (float) Math.PI / 4;
		this.legBackBackRightLower.xRot = (float) Math.PI / 4;
		this.legBackLeftLower.xRot = (float) Math.PI / 4;
		this.legBackRightLower.xRot = (float) Math.PI / 4;
		this.legFrontLeftLower.xRot = (float) Math.PI / 4;
		this.legFrontRightLower.xRot = (float) Math.PI / 4;
		this.legFrontFrontLeftLower.xRot = (float) Math.PI / 4;
		this.legFrontFrontRightLower.xRot = (float) Math.PI / 4;
		
		this.legBackBackLeftLower.zRot = 0;//-(float) Math.PI / 4;
		this.legBackBackRightLower.zRot = 0;//-(float) Math.PI / 4;
		this.legBackLeftLower.zRot = 0;//-(float) Math.PI / 4;
		this.legBackRightLower.zRot = 0;//-(float) Math.PI / 4;
		this.legFrontLeftLower.zRot = 0;//-(float) Math.PI / 4;
		this.legFrontRightLower.zRot = 0;//-(float) Math.PI / 4;
		this.legFrontFrontLeftLower.zRot = 0;//-(float) Math.PI / 4;
		this.legFrontFrontRightLower.zRot = 0;//-(float) Math.PI / 4;
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}