package com.technologica.client.model;

import com.technologica.world.entity.animal.Buffalo;

import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class BuffaloModel<T extends Buffalo> extends QuadrupedModel<T> {
	protected ModelPart mane;
	
	public BuffaloModel(ModelPart modelPartIn) {
		super(modelPartIn, false, 10.0F, 4.0F, 2.0F, 2.0F, 24);
	}
	
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition root = meshdefinition.getRoot();
		root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(12, 0).addBox(-5.0F, -3.0F, -6.0F, 10.0F, 12.0F, 8.0F).texOffs(0, 0).addBox(-6.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(5.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F).texOffs(0, 2).addBox(-7.0F, -4.0F, -3.0F, 1.0F, 3.0F, 1.0F).texOffs(0, 2).addBox(6.0F, -4.0F, -3.0F, 1.0F, 3.0F, 1.0F), PartPose.offset(0.0F, 0.0F, -16.0F));
		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 20).addBox(-6.0F, -10.0F, -14.0F, 12.0F, 16.0F, 28.0F), PartPose.offset(0.0F, 6.0F, -0.0F));
		body.addOrReplaceChild("mane", CubeListBuilder.create().texOffs(52, 0).addBox(-7.0F, -12.0F, -12.0F, 14.0F, 20.0F, 12.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		root.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(-4.0F, 12.0F, 12.0F));
		root.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(4.0F, 12.0F, 12.0F));
		root.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(-4.0F, 12.0F, -8.0F));
		root.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(4.0F, 12.0F, -8.0F));
		return LayerDefinition.create(meshdefinition, 128, 64);
	}
	
	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
