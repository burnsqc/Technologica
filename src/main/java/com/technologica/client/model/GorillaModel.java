package com.technologica.client.model;

import com.technologica.world.entity.animal.Gorilla;

import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class GorillaModel<T extends Gorilla> extends QuadrupedModel<T> {
	private final ModelPart leftFrontLeg;
	private final ModelPart rightFrontLeg;
	private final ModelPart leftFrontLegLower;
	private final ModelPart rightFrontLegLower;
	
	public GorillaModel(ModelPart modelPartIn) {
		super(modelPartIn, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		this.leftFrontLeg = modelPartIn.getChild("left_front_leg");
		this.rightFrontLeg = modelPartIn.getChild("right_front_leg");
		this.leftFrontLegLower = leftFrontLeg.getChild("left_front_leg_lower");
		this.rightFrontLegLower = rightFrontLeg.getChild("right_front_leg_lower");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition root = meshdefinition.getRoot();
		root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -4.0F, -8.0F, 12.0F, 8.0F, 16.0F), PartPose.offset(0.0F, 12.0F, 0.0F));
		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 24).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F), PartPose.offset(0.0F, 6.0F, -6.0F));
		head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(22, 24).addBox(-2.0F, -1.0F, -7.0F, 4.0F, 5.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(40, 0).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 8.0F, 6.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		root.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(-5.0F, 12.0F, 6.0F));
		root.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(5.0F, 12.0F, 6.0F));
		PartDefinition rightFrontLeg = root.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(0, 38).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F), PartPose.offset(-5.0F, 8.0F, -5.0F));
		PartDefinition leftFrontLeg = root.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(0, 38).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F), PartPose.offset(5.0F, 8.0F, -5.0F));
		rightFrontLeg.addOrReplaceChild("right_front_leg_lower", CubeListBuilder.create().texOffs(16, 38).addBox(0.0F, 0.0F, 0.0F, 4.0F, 8.0F, 4.0F), PartPose.offset(-2.0F, 10.0F, -2.0F));
		leftFrontLeg.addOrReplaceChild("left_front_leg_lower", CubeListBuilder.create().texOffs(16, 38).addBox(-4.0F, 0.0F, 0.0F, 4.0F, 8.0F, 4.0F), PartPose.offset(2.0F, 10.0F, -2.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	
	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.xRot = -((float) Math.PI / 8F);
		this.head.xRot = 0;
		leftFrontLeg.xRot = -(float) (Math.PI/8);
		rightFrontLeg.xRot = -(float) (Math.PI/8);
		leftFrontLegLower.xRot = (float) (Math.PI/8);
		rightFrontLegLower.xRot = (float) (Math.PI/8);
	}
}
