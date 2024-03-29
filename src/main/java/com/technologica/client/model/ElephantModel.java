package com.technologica.client.model;

import com.technologica.world.entity.animal.Elephant;

import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class ElephantModel<T extends Elephant> extends QuadrupedModel<T> {
	protected ModelPart forehead;
	protected ModelPart earLeft;
	protected ModelPart earRight;
	protected ModelPart tuskLeft;
	protected ModelPart tuskRight;
	protected ModelPart trunk1;
	protected ModelPart trunk2;
	protected ModelPart trunk3;
	protected ModelPart tail;

	public ElephantModel(ModelPart modelPartIn) {
		super(modelPartIn, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		this.forehead = this.head.getChild("forehead");
		this.tuskLeft = this.head.getChild("tusk_left");
		this.tuskRight = this.head.getChild("tusk_right");
		this.earLeft = this.head.getChild("ear_left");
		this.earRight = this.head.getChild("ear_right");
		this.trunk1 = this.head.getChild("trunk1");
		this.trunk2 = this.trunk1.getChild("trunk2");
		this.trunk3 = this.trunk2.getChild("trunk3");
		this.tail = this.body.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition root = meshdefinition.getRoot();
		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-14.0F, -15.0F, -24.0F, 28.0F, 30.0F, 48.0F), PartPose.offset(0.0F, -11.0F, 0.0F));
		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(104, 0).addBox(-9.0F, -9.0F, -18.0F, 18.0F, 18.0F, 18.0F), PartPose.offset(0.0F, -17.0F, -24.0F));
		head.addOrReplaceChild("forehead", CubeListBuilder.create().texOffs(104, 36).addBox(-3.0F, -6.0F, 0.0F, 6.0F, 6.0F, 4.0F), PartPose.offset(0.0F, -3.0F, -22.0F));
		head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(158, 0).addBox(-4.0F, -3.0F, -22.0F, 8.0F, 12.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("ear_left", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -10.0F, 0.0F, 1.0F, 18.0F, 18.0F), PartPose.offset(10.0F, 1.0F, -10.0F));
		head.addOrReplaceChild("ear_right", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -10.0F, 0.0F, 1.0F, 18.0F, 18.0F), PartPose.offset(-10.0F, 1.0F, -10.0F));
		head.addOrReplaceChild("tusk_left", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -4.0F, 3.0F, 12.0F, 3.0F), PartPose.offset(7.0F, 9.0F, -13.0F));
		head.addOrReplaceChild("tusk_right", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -4.0F, 3.0F, 12.0F, 3.0F), PartPose.offset(-7.0F, 9.0F, -13.0F));
		PartDefinition trunk1 = head.addOrReplaceChild("trunk1", CubeListBuilder.create().texOffs(152, 36).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 12.0F, 6.0F), PartPose.offset(0.0F, 8.0F, -22.0F));
		PartDefinition trunk2 = trunk1.addOrReplaceChild("trunk2", CubeListBuilder.create().texOffs(152, 54).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(0.0F, 10.0F, 0.0F));
		trunk2.addOrReplaceChild("trunk3", CubeListBuilder.create().texOffs(152, 71).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 10.0F, 4.0F), PartPose.offset(0.0F, 12.0F, 0.0F));
		root.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(0, 78).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 20.0F, 10.0F), PartPose.offset(-9.0F, 4.0F, 19.0F));
		root.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(0, 78).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 20.0F, 10.0F), PartPose.offset(9.0F, 4.0F, 19.0F));
		root.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(0, 78).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 20.0F, 10.0F), PartPose.offset(-9.0F, 4.0F, -19.0F));
		root.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(0, 78).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 20.0F, 10.0F), PartPose.offset(9.0F, 4.0F, -19.0F));
		body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(40, 78).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 24.0F, 3.0F), PartPose.offset(0.0F, -8.0F, 24.0F));
		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.tuskLeft.xRot = -(float) Math.PI / 10.0F;
		this.tuskRight.xRot = -(float) Math.PI / 10.0F;
		this.tail.xRot = (float) Math.PI / 10.0F;
		this.trunk1.xRot = 0;
		this.trunk2.xRot = 0;
		this.trunk3.xRot = 0;
		this.earLeft.yRot = (float) Math.PI / 5.0F;
		this.earRight.yRot = -(float) Math.PI / 5.0F;
		this.forehead.xRot = -(float) (Math.PI / 4.0F);
	}
}