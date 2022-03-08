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
		this.textureWidth = 64;
		this.textureHeight = 32;

		this.body = new ModelRenderer(this, 0, 0);
		this.body.setRotationPoint(0.0F, 17.0F, 1.0F);
		this.body.addBox(-3.0F, -6.0F, -3.0F, 6.0F, 8.0F, 6.0F);
		
		this.head = new ModelRenderer(this, 24, 0);
		this.head.setRotationPoint(0.0F, -6.0F, -3.0F);
		this.head.addBox(-4.0F, -8.0F, 0.0F, 8.0F, 8.0F, 8.0F);
		this.body.addChild(this.head);
		
		this.eyeLeft = new ModelRenderer(this, 0, 0);
		this.eyeLeft.addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 1.0F, true);
		this.body.addChild(this.eyeLeft);
		
		this.eyeRight = new ModelRenderer(this, 0, 0);
		this.eyeRight.addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 1.0F);
		this.body.addChild(this.eyeRight);
		
		this.legBackBackLeftUpper = new ModelRenderer(this, 0, 14);
		this.legBackBackLeftUpper.setRotationPoint(0.0F, 19.0F, 0.0F);
		this.legBackBackLeftUpper.addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F);
		
		this.legBackBackLeftLower = new ModelRenderer(this, 12, 14);
		this.legBackBackLeftLower.setRotationPoint(0.0F, 8.0F, 2.5F);
		this.legBackBackLeftLower.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F);
		this.legBackBackLeftUpper.addChild(this.legBackBackLeftLower);
		
		this.legBackBackRightUpper = new ModelRenderer(this, 0, 14);
		this.legBackBackRightUpper.setRotationPoint(0.0F, 19.0F, 0.0F);
		this.legBackBackRightUpper.addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F);
		
		this.legBackBackRightLower = new ModelRenderer(this, 12, 14);
		this.legBackBackRightLower.setRotationPoint(0.0F, 8.0F, 2.5F);
		this.legBackBackRightLower.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F);
		this.legBackBackRightUpper.addChild(this.legBackBackRightLower);

		this.legBackLeftUpper = new ModelRenderer(this, 0, 14);
		this.legBackLeftUpper.setRotationPoint(0.0F, 19.0F, 0.0F);
		this.legBackLeftUpper.addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F);
		
		this.legBackLeftLower = new ModelRenderer(this, 12, 14);
		this.legBackLeftLower.setRotationPoint(0.0F, 8.0F, 2.5F);
		this.legBackLeftLower.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F);
		this.legBackLeftUpper.addChild(this.legBackLeftLower);

		this.legBackRightUpper = new ModelRenderer(this, 0, 14);
		this.legBackRightUpper.setRotationPoint(0.0F, 19.0F, 0.0F);
		this.legBackRightUpper.addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F);
		
		this.legBackRightLower = new ModelRenderer(this, 12, 14);
		this.legBackRightLower.setRotationPoint(0.0F, 8.0F, 2.5F);
		this.legBackRightLower.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F);
		this.legBackRightUpper.addChild(this.legBackRightLower);

		this.legFrontLeftUpper = new ModelRenderer(this, 0, 14);
		this.legFrontLeftUpper.setRotationPoint(0.0F, 19.0F, 0.0F);
		this.legFrontLeftUpper.addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F);
		
		this.legFrontLeftLower = new ModelRenderer(this, 12, 14);
		this.legFrontLeftLower.setRotationPoint(0.0F, 8.0F, 2.5F);
		this.legFrontLeftLower.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F);
		this.legFrontLeftUpper.addChild(this.legFrontLeftLower);

		this.legFrontRightUpper = new ModelRenderer(this, 0, 14);
		this.legFrontRightUpper.setRotationPoint(0.0F, 19.0F, 0.0F);
		this.legFrontRightUpper.addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F);
		
		this.legFrontRightLower = new ModelRenderer(this, 12, 14);
		this.legFrontRightLower.setRotationPoint(0.0F, 8.0F, 2.5F);
		this.legFrontRightLower.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F);
		this.legFrontRightUpper.addChild(this.legFrontRightLower);

		this.legFrontFrontLeftUpper = new ModelRenderer(this, 0, 14);
		this.legFrontFrontLeftUpper.setRotationPoint(0.0F, 19.0F, 0.0F);
		this.legFrontFrontLeftUpper.addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F);
		
		this.legFrontFrontLeftLower = new ModelRenderer(this, 12, 14);
		this.legFrontFrontLeftLower.setRotationPoint(0.0F, 8.0F, 2.5F);
		this.legFrontFrontLeftLower.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F);
		this.legFrontFrontLeftUpper.addChild(this.legFrontFrontLeftLower);

		this.legFrontFrontRightUpper = new ModelRenderer(this, 0, 14);
		this.legFrontFrontRightUpper.setRotationPoint(0.0F, 19.0F, 0.0F);
		this.legFrontFrontRightUpper.addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F);
		
		this.legFrontFrontRightLower = new ModelRenderer(this, 12, 14);
		this.legFrontFrontRightLower.setRotationPoint(0.0F, 8.0F, 2.5F);
		this.legFrontFrontRightLower.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F);
		this.legFrontFrontRightUpper.addChild(this.legFrontFrontRightLower);
	}

	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.body, this.legBackBackRightUpper, this.legBackBackLeftUpper, this.legBackRightUpper, this.legBackLeftUpper, this.legFrontRightUpper, this.legFrontLeftUpper, this.legFrontFrontRightUpper, this.legFrontFrontLeftUpper);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.rotateAngleX = -(float) Math.PI / 4;
		this.head.rotateAngleX = -(float) Math.PI / 4;
		
		this.legBackBackLeftUpper.rotateAngleY = -(float) Math.PI / 8;
		this.legBackBackRightUpper.rotateAngleY = (float) Math.PI / 8;
		this.legBackLeftUpper.rotateAngleY = -3 * (float) Math.PI / 8;
		this.legBackRightUpper.rotateAngleY = 3 * (float) Math.PI / 8;
		this.legFrontLeftUpper.rotateAngleY = -5 * (float) Math.PI / 8;
		this.legFrontRightUpper.rotateAngleY = 5 * (float) Math.PI / 8;
		this.legFrontFrontLeftUpper.rotateAngleY = -7 * (float) Math.PI / 8;
		this.legFrontFrontRightUpper.rotateAngleY = 7 * (float) Math.PI / 8;
		
		this.legBackBackLeftUpper.rotateAngleX = (float) Math.PI / 4;
		this.legBackBackRightUpper.rotateAngleX = (float) Math.PI / 4;
		this.legBackLeftUpper.rotateAngleX = (float) Math.PI / 4;
		this.legBackRightUpper.rotateAngleX = (float) Math.PI / 4;
		this.legFrontLeftUpper.rotateAngleX = (float) Math.PI / 4;
		this.legFrontRightUpper.rotateAngleX = (float) Math.PI / 4;
		this.legFrontFrontLeftUpper.rotateAngleX = (float) Math.PI / 4;
		this.legFrontFrontRightUpper.rotateAngleX = (float) Math.PI / 4;
		
		this.legBackBackLeftLower.rotateAngleX = (float) Math.PI / 4;
		this.legBackBackRightLower.rotateAngleX = (float) Math.PI / 4;
		this.legBackLeftLower.rotateAngleX = (float) Math.PI / 4;
		this.legBackRightLower.rotateAngleX = (float) Math.PI / 4;
		this.legFrontLeftLower.rotateAngleX = (float) Math.PI / 4;
		this.legFrontRightLower.rotateAngleX = (float) Math.PI / 4;
		this.legFrontFrontLeftLower.rotateAngleX = (float) Math.PI / 4;
		this.legFrontFrontRightLower.rotateAngleX = (float) Math.PI / 4;
		
		this.legBackBackLeftLower.rotateAngleZ = 0;//-(float) Math.PI / 4;
		this.legBackBackRightLower.rotateAngleZ = 0;//-(float) Math.PI / 4;
		this.legBackLeftLower.rotateAngleZ = 0;//-(float) Math.PI / 4;
		this.legBackRightLower.rotateAngleZ = 0;//-(float) Math.PI / 4;
		this.legFrontLeftLower.rotateAngleZ = 0;//-(float) Math.PI / 4;
		this.legFrontRightLower.rotateAngleZ = 0;//-(float) Math.PI / 4;
		this.legFrontFrontLeftLower.rotateAngleZ = 0;//-(float) Math.PI / 4;
		this.legFrontFrontRightLower.rotateAngleZ = 0;//-(float) Math.PI / 4;
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}