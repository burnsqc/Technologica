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
	private final ModelPart body;
	private final ModelPart head;
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

	public OctopusModel(ModelPart modelPartIn) {
		this.body = modelPartIn.getChild("body");
		this.head = this.body.getChild("head");
		this.legBackBackLeftUpper = modelPartIn.getChild("legBackBackLeftUpper");
		this.legBackBackRightUpper = modelPartIn.getChild("legBackBackRightUpper");
		this.legBackLeftUpper = modelPartIn.getChild("legBackLeftUpper");
		this.legBackRightUpper = modelPartIn.getChild("legBackRightUpper");
		this.legFrontLeftUpper = modelPartIn.getChild("legFrontLeftUpper");
		this.legFrontRightUpper = modelPartIn.getChild("legFrontRightUpper");
		this.legFrontFrontLeftUpper = modelPartIn.getChild("legFrontFrontLeftUpper");
		this.legFrontFrontRightUpper = modelPartIn.getChild("legFrontFrontRightUpper");
		this.legBackBackLeftLower = legBackBackLeftUpper.getChild("legBackBackLeftLower");
		this.legBackBackRightLower = legBackBackRightUpper.getChild("legBackBackRightLower");
		this.legBackLeftLower = legBackLeftUpper.getChild("legBackLeftLower");
		this.legBackRightLower = legBackRightUpper.getChild("legBackRightLower");
		this.legFrontLeftLower = legFrontLeftUpper.getChild("legFrontLeftLower");
		this.legFrontRightLower = legFrontRightUpper.getChild("legFrontRightLower");
		this.legFrontFrontLeftLower = legFrontFrontLeftUpper.getChild("legFrontFrontLeftLower");
		this.legFrontFrontRightLower = legFrontFrontRightUpper.getChild("legFrontFrontRightLower");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition root = meshdefinition.getRoot();
		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 8.0F, 6.0F), PartPose.offset(0.0F, 17.0F, 1.0F));
		body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 0).addBox(-4.0F, -8.0F, 0.0F, 8.0F, 8.0F, 8.0F), PartPose.offset(0.0F, -6.0F, -3.0F));
		body.addOrReplaceChild("eye_left", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		body.addOrReplaceChild("eye_right", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition legBackBackLeftUpper = root.addOrReplaceChild("legBackBackLeftUpper", CubeListBuilder.create().texOffs(0, 14).addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F), PartPose.offset(0.0F, 19.0F, 0.0F));
		PartDefinition legBackBackRightUpper = root.addOrReplaceChild("legBackBackRightUpper", CubeListBuilder.create().texOffs(0, 14).addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F), PartPose.offset(0.0F, 19.0F, 0.0F));
		PartDefinition legBackLeftUpper = root.addOrReplaceChild("legBackLeftUpper", CubeListBuilder.create().texOffs(0, 14).addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F), PartPose.offset(0.0F, 19.0F, 0.0F));
		PartDefinition legBackRightUpper = root.addOrReplaceChild("legBackRightUpper", CubeListBuilder.create().texOffs(0, 14).addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F), PartPose.offset(0.0F, 19.0F, 0.0F));
		PartDefinition legFrontLeftUpper = root.addOrReplaceChild("legFrontLeftUpper", CubeListBuilder.create().texOffs(0, 14).addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F), PartPose.offset(0.0F, 19.0F, 0.0F));
		PartDefinition legFrontRightUpper = root.addOrReplaceChild("legFrontRightUpper", CubeListBuilder.create().texOffs(0, 14).addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F), PartPose.offset(0.0F, 19.0F, 0.0F));
		PartDefinition legFrontFrontLeftUpper = root.addOrReplaceChild("legFrontFrontLeftUpper", CubeListBuilder.create().texOffs(0, 14).addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F), PartPose.offset(0.0F, 19.0F, 0.0F));
		PartDefinition legFrontFrontRightUpper = root.addOrReplaceChild("legFrontFrontRightUpper", CubeListBuilder.create().texOffs(0, 14).addBox(-1.5F, 0.0F, 1.0F, 3.0F, 8.0F, 3.0F), PartPose.offset(0.0F, 19.0F, 0.0F));
		legBackBackLeftUpper.addOrReplaceChild("legBackBackLeftLower", CubeListBuilder.create().texOffs(12, 14).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F), PartPose.offset(0.0F, 8.0F, 2.5F));
		legBackBackRightUpper.addOrReplaceChild("legBackBackRightLower", CubeListBuilder.create().texOffs(12, 14).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F), PartPose.offset(0.0F, 8.0F, 2.5F));
		legBackLeftUpper.addOrReplaceChild("legBackLeftLower", CubeListBuilder.create().texOffs(12, 14).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F), PartPose.offset(0.0F, 8.0F, 2.5F));
		legBackRightUpper.addOrReplaceChild("legBackRightLower", CubeListBuilder.create().texOffs(12, 14).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F), PartPose.offset(0.0F, 8.0F, 2.5F));
		legFrontLeftUpper.addOrReplaceChild("legFrontLeftLower", CubeListBuilder.create().texOffs(12, 14).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F), PartPose.offset(0.0F, 8.0F, 2.5F));
		legFrontRightUpper.addOrReplaceChild("legFrontRightLower", CubeListBuilder.create().texOffs(12, 14).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F), PartPose.offset(0.0F, 8.0F, 2.5F));
		legFrontFrontLeftUpper.addOrReplaceChild("legFrontFrontLeftLower", CubeListBuilder.create().texOffs(12, 14).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F), PartPose.offset(0.0F, 8.0F, 2.5F));
		legFrontFrontRightUpper.addOrReplaceChild("legFrontFrontRightLower", CubeListBuilder.create().texOffs(12, 14).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F), PartPose.offset(0.0F, 8.0F, 2.5F));
		return LayerDefinition.create(meshdefinition, 64, 32);
	}
	
	@Override
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
}