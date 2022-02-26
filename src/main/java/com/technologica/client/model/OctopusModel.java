package com.technologica.client.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.Entity;

public class OctopusModel<T extends Entity> extends ListModel<T> {
	/*
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart eyeLeft;
	private final ModelPart eyeRight;
	private final ModelPart legBackBackLeftUpper;
	private final ModelPart legBackBackLeftLower;
	private final ModelPart legBackBackRightUpper;
	private final ModelPart legBackBackRightLower;
	private final ModelPart legBackRightUpper;
	private final ModelPart legBackRightLower;
	private final ModelPart legBackLeftUpper;
	private final ModelPart legBackLeftLower;
	private final ModelPart legFrontRightUpper;
	private final ModelPart legFrontRightLower;
	private final ModelPart legFrontLeftUpper;
	private final ModelPart legFrontLeftLower;
	private final ModelPart legFrontFrontRightUpper;
	private final ModelPart legFrontFrontRightLower;
	private final ModelPart legFrontFrontLeftUpper;
	private final ModelPart legFrontFrontLeftLower;
	*/
	public OctopusModel() {
		/*
		this.texWidth = 64;
		this.texHeight = 32;

		this.body = new ModelPart(this, 0, 0);
		this.body.setPos(0.0F, 17.0F, 1.0F);
		this.body.addBox(-3.0F, -6.0F, -3.0F, 6.0F, 8.0F, 6.0F);
		
		this.head = new ModelPart(this, 24, 0);
		this.head.setPos(0.0F, -6.0F, -3.0F);
		this.head.addBox(-4.0F, -8.0F, 0.0F, 8.0F, 8.0F, 8.0F);
		this.body.addChild(this.head);
		
		this.eyeLeft = new ModelPart(this, 0, 0);
		this.eyeLeft.addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 1.0F, true);
		this.body.addChild(this.eyeLeft);
		
		this.eyeRight = new ModelPart(this, 0, 0);
		this.eyeRight.addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 1.0F);
		this.body.addChild(this.eyeRight);
		
		this.legBackBackLeftUpper = new ModelPart(this, 0, 14);
		this.legBackBackLeftUpper.setPos(0.0F, 19.0F, 0.0F);
		this.legBackBackLeftUpper.addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F);
		
		this.legBackBackLeftLower = new ModelPart(this, 12, 14);
		this.legBackBackLeftLower.setPos(0.0F, 8.0F, 2.5F);
		this.legBackBackLeftLower.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F);
		this.legBackBackLeftUpper.addChild(this.legBackBackLeftLower);
		
		this.legBackBackRightUpper = new ModelPart(this, 0, 14);
		this.legBackBackRightUpper.setPos(0.0F, 19.0F, 0.0F);
		this.legBackBackRightUpper.addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F);
		
		this.legBackBackRightLower = new ModelPart(this, 12, 14);
		this.legBackBackRightLower.setPos(0.0F, 8.0F, 2.5F);
		this.legBackBackRightLower.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F);
		this.legBackBackRightUpper.addChild(this.legBackBackRightLower);

		this.legBackLeftUpper = new ModelPart(this, 0, 14);
		this.legBackLeftUpper.setPos(0.0F, 19.0F, 0.0F);
		this.legBackLeftUpper.addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F);
		
		this.legBackLeftLower = new ModelPart(this, 12, 14);
		this.legBackLeftLower.setPos(0.0F, 8.0F, 2.5F);
		this.legBackLeftLower.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F);
		this.legBackLeftUpper.addChild(this.legBackLeftLower);

		this.legBackRightUpper = new ModelPart(this, 0, 14);
		this.legBackRightUpper.setPos(0.0F, 19.0F, 0.0F);
		this.legBackRightUpper.addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F);
		
		this.legBackRightLower = new ModelPart(this, 12, 14);
		this.legBackRightLower.setPos(0.0F, 8.0F, 2.5F);
		this.legBackRightLower.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F);
		this.legBackRightUpper.addChild(this.legBackRightLower);

		this.legFrontLeftUpper = new ModelPart(this, 0, 14);
		this.legFrontLeftUpper.setPos(0.0F, 19.0F, 0.0F);
		this.legFrontLeftUpper.addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F);
		
		this.legFrontLeftLower = new ModelPart(this, 12, 14);
		this.legFrontLeftLower.setPos(0.0F, 8.0F, 2.5F);
		this.legFrontLeftLower.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F);
		this.legFrontLeftUpper.addChild(this.legFrontLeftLower);

		this.legFrontRightUpper = new ModelPart(this, 0, 14);
		this.legFrontRightUpper.setPos(0.0F, 19.0F, 0.0F);
		this.legFrontRightUpper.addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F);
		
		this.legFrontRightLower = new ModelPart(this, 12, 14);
		this.legFrontRightLower.setPos(0.0F, 8.0F, 2.5F);
		this.legFrontRightLower.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F);
		this.legFrontRightUpper.addChild(this.legFrontRightLower);

		this.legFrontFrontLeftUpper = new ModelPart(this, 0, 14);
		this.legFrontFrontLeftUpper.setPos(0.0F, 19.0F, 0.0F);
		this.legFrontFrontLeftUpper.addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F);
		
		this.legFrontFrontLeftLower = new ModelPart(this, 12, 14);
		this.legFrontFrontLeftLower.setPos(0.0F, 8.0F, 2.5F);
		this.legFrontFrontLeftLower.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F);
		this.legFrontFrontLeftUpper.addChild(this.legFrontFrontLeftLower);

		this.legFrontFrontRightUpper = new ModelPart(this, 0, 14);
		this.legFrontFrontRightUpper.setPos(0.0F, 19.0F, 0.0F);
		this.legFrontFrontRightUpper.addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F);
		
		this.legFrontFrontRightLower = new ModelPart(this, 12, 14);
		this.legFrontFrontRightLower.setPos(0.0F, 8.0F, 2.5F);
		this.legFrontFrontRightLower.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F);
		this.legFrontFrontRightUpper.addChild(this.legFrontFrontRightLower);
		*/
	}
	/*
	public Iterable<ModelPart> parts() {
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

	public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
	*/

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition partdefinition = meshdefinition.getRoot();
		
		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 14).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 21.0F, -4.0F));
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 10.0F, -6.0F, 6.0F, 6.0F, 8.0F), PartPose.offset(0.0F, 6.0F, 2.0F));
		
		partdefinition.addOrReplaceChild("rightHindLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(-2.0F, 21.0F, 3.0F));
		partdefinition.addOrReplaceChild("leftHindLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(2.0F, 21.0F, 3.0F));
		partdefinition.addOrReplaceChild("rightFrontLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(-2.0F, 21.0F, -3.0F));
		partdefinition.addOrReplaceChild("leftFrontLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(2.0F, 21.0F, -3.0F));
		partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 6.0F), PartPose.offset(0.0F, 14.0F, 2.0F));
		
		return LayerDefinition.create(meshdefinition, 32, 32);
	}
	
	@Override
	public Iterable<ModelPart> parts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setupAnim(T p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_,
			float p_102623_) {
		// TODO Auto-generated method stub
		
	}
}