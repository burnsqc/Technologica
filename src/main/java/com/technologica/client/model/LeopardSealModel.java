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
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class LeopardSealModel<T extends Entity> extends ListModel<T> {
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart flipperLeft;
	private final ModelPart flipperRight;
	private final ModelPart tail;
	private final ModelPart tailFlipperLeft;
	private final ModelPart tailFlipperRight;
	
	public LeopardSealModel(ModelPart modelPartIn) {
		this.body = modelPartIn.getChild("body");
		this.flipperLeft = body.getChild("flipper_left");
		this.flipperRight = body.getChild("flipper_right");
		this.head = body.getChild("head");
		this.jaw = head.getChild("jaw");
		this.tail = body.getChild("tail");
		this.tailFlipperLeft = tail.getChild("tail_flipper_left");
		this.tailFlipperRight = tail.getChild("tail_flipper_right");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition root = meshdefinition.getRoot();
		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(20, 2).addBox(-4.0F, -4.0F, -7.0F, 8.0F, 8.0F, 14.0F), PartPose.offset(0.0F, 20.0F, 0.0F));
		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 16).addBox(-3.0F, -3.0F, -4.0F, 6.0F, 6.0F, 4.0F), PartPose.offset(0.0F, 0.0F, -7.0F));
		head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(16, 24).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 3.0F, 4.0F), PartPose.offset(0.0F, -1.0F, -4.0F));
		head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 26).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 1.0F, 4.0F), PartPose.offset(0.0F, 1.0F, -4.0F));
		body.addOrReplaceChild("flipper_left", CubeListBuilder.create().texOffs(32, 24).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 4.0F), PartPose.offset(4.0F, 1.0F, -4.0F));
		body.addOrReplaceChild("flipper_right", CubeListBuilder.create().texOffs(32, 24).addBox(-8.0F, 0.0F, 0.0F, 8.0F, 1.0F, 4.0F), PartPose.offset(-4.0F, 1.0F, -4.0F));
		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 10.0F), PartPose.offset(0.0F, 0.0F, 7.0F));
		tail.addOrReplaceChild("tail_flipper_left", CubeListBuilder.create().texOffs(0, 31).mirror().addBox(0.0F, -3.0F, 0.0F, 1.0F, 6.0F, 8.0F), PartPose.offset(2.0F, 0.0F, 10.0F));
		tail.addOrReplaceChild("tail_flipper_right", CubeListBuilder.create().texOffs(0, 31).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 6.0F, 8.0F), PartPose.offset(-2.0F, 0.0F, 10.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	
	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.body);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.jaw.xRot = (Mth.sin(ageInTicks / 10) * Mth.sin(ageInTicks / 10))/2;
		
		this.tailFlipperLeft.yRot = (float) Math.PI / 8;
		this.tailFlipperRight.yRot = -(float) Math.PI / 8;
		
		this.flipperLeft.yRot = -(float) Math.PI / 4;
		this.flipperLeft.zRot = (float) Math.PI / 8;
		
		this.flipperRight.yRot = (float) Math.PI / 4;
		this.flipperRight.zRot = -(float) Math.PI / 8;

		this.body.xRot = headPitch * ((float) Math.PI / 180F);
		this.body.yRot = netHeadYaw * ((float) Math.PI / 180F);
		if (entityIn.getDeltaMovement().horizontalDistanceSqr() > 1.0E-7D) {
			this.body.xRot += -0.05F + -0.05F * Mth.cos(ageInTicks * 0.3F);
			this.tail.yRot = -0.1F * Mth.cos(ageInTicks * 0.3F);
			this.tailFlipperLeft.yRot = -0.2F * Mth.cos(ageInTicks * 0.3F);
			this.tailFlipperRight.yRot = -0.2F * Mth.cos(ageInTicks * 0.3F);
		}
	}
	
}
