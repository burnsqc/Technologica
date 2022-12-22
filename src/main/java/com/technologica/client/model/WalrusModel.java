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

public class WalrusModel<T extends Entity> extends ListModel<T> {
	private final ModelPart body;

	public WalrusModel(ModelPart modelPartIn) {
		this.body = modelPartIn.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition root = meshdefinition.getRoot();
		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, -10.0F, -8.0F, 20.0F, 20.0F, 16.0F), PartPose.offset(0.0F, 14.0F, -8.0F));
		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(88, 0).addBox(-5.0F, -3.0F, -3.0F, 10.0F, 10.0F, 10.0F), PartPose.offset(0.0F, -10.0F, -8.0F));
		head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(104, 20).addBox(-4.0F, 2.0F, -5.0F, 8.0F, 4.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("tusk_left", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 6.0F, -4.0F, 1.0F, 6.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("tusk_right", CubeListBuilder.create().texOffs(0, 0).addBox(2.0F, 6.0F, -4.0F, 1.0F, 6.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		body.addOrReplaceChild("flipper_front_left", CubeListBuilder.create().texOffs(104, 26).mirror().addBox(0.0F, -1.0F, -5.0F, 7.0F, 2.0F, 5.0F), PartPose.offset(10.0F, 9.0F, -2.0F));
		body.addOrReplaceChild("flipper_front_right", CubeListBuilder.create().texOffs(104, 26).addBox(-7.0F, -1.0F, -5.0F, 7.0F, 2.0F, 5.0F), PartPose.offset(-10.0F, 9.0F, -2.0F));
		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(56, 20).addBox(-8.0F, -8.0F, 0.0F, 16.0F, 16.0F, 16.0F), PartPose.offset(0.0F, 2.0F, 8.0F));
		PartDefinition tail2 = tail.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(56, 0).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 8.0F), PartPose.offset(0.0F, 4.0F, 16.0F));
		tail2.addOrReplaceChild("flipper_back_left", CubeListBuilder.create().texOffs(104, 26).mirror().addBox(0.0F, -1.0F, 0.0F, 7.0F, 2.0F, 5.0F), PartPose.offset(4.0F, 3.0F, 3.0F));
		tail2.addOrReplaceChild("flipper_back_right", CubeListBuilder.create().texOffs(104, 26).addBox(-7.0F, -1.0F, 0.0F, 7.0F, 2.0F, 5.0F), PartPose.offset(-4.0F, 3.0F, 3.0F));
		return LayerDefinition.create(meshdefinition, 128, 64);
	}
	
	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.body);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
