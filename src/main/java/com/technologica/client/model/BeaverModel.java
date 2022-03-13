package com.technologica.client.model;

import com.technologica.world.entity.animal.Beaver;

import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class BeaverModel<T extends Beaver> extends QuadrupedModel<T> {
	public BeaverModel(ModelPart modelPartIn) {
		super(modelPartIn, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
	}
	
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 14).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 4.0F, 4.0F).texOffs(20, 4).addBox("left_tooth", 0.0F, -1.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F, 0.0F, -0.4F)).texOffs(20, 4).addBox("right_tooth", -1.0F, -1.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F, 0.0F, -0.4F)), PartPose.offset(0.0F, 21.0F, -4.0F));
		PartDefinition partdefinition1 = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 10.0F, -6.0F, 6.0F, 6.0F, 8.0F), PartPose.offset(0.0F, 6.0F, 2.0F));
		partdefinition1.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 14.0F, 2.0F, -0.3F, 0.0F, 0.0F));
		partdefinition.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(20, 0).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F, 0.0F, -0.1F)).texOffs(12, 14).addBox("left_hind_foot", -1.5F, 1.0F, -3.0F, 3.0F, 1.0F, 3.0F), PartPose.offset(2.0F, 22.0F, 4.0F));
		partdefinition.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(20, 0).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F, 0.0F, -0.1F)).texOffs(12, 14).addBox("right_hind_foot", -1.5F, 1.0F, -3.0F, 3.0F, 1.0F, 3.0F), PartPose.offset(-2.0F, 22.0F, 4.0F));
		partdefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.1F, 0.0F, -0.1F)), PartPose.offset(2.0F, 22.0F, -4.0F));
		partdefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.1F, 0.0F, -0.1F)), PartPose.offset(-2.0F, 22.0F, -4.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.xRot = headPitch * ((float) Math.PI / 180F) * 0.5F;
		this.head.yRot = netHeadYaw * ((float) Math.PI / 180F) * 0.5F;
		this.rightHindLeg.xRot = Mth.square(Mth.cos(limbSwing) * 2.0F * limbSwingAmount);
		this.leftHindLeg.xRot = Mth.square(Mth.cos(limbSwing + (float) Math.PI/2) * 2.0F * limbSwingAmount);
		this.rightFrontLeg.xRot = -Mth.square(Mth.cos(limbSwing + (float) Math.PI/2) * 2.0F * limbSwingAmount);
		this.leftFrontLeg.xRot =  -Mth.square(Mth.cos(limbSwing) * 2.0F * limbSwingAmount);
	}
}