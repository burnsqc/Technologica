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
	private final ModelPart neck;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart tail;
	private final ModelPart tailFlipperLeft;
	private final ModelPart tailFlipperRight;

	public LeopardSealModel(ModelPart modelPartIn) {
		this.body = modelPartIn.getChild("body");
		this.neck = body.getChild("neck");
		this.head = neck.getChild("head");
		this.jaw = head.getChild("jaw");
		this.tail = body.getChild("tail");
		this.tailFlipperLeft = tail.getChild("tail_flipper_left");
		this.tailFlipperRight = tail.getChild("tail_flipper_right");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition root = meshdefinition.getRoot();
		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -7.0F, 8.0F, 8.0F, 14.0F), PartPose.offset(0.0F, 20.0F, 0.0F));
		PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 22).addBox(-2.99F, -6.0F, -8.0F, 5.98F, 6.0F, 8.0F), PartPose.offset(0.0F, 3.0F, -7.0F));
		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(30, 0).addBox(-3.0F, 0.0F, -6.0F, 6.0F, 6.0F, 6.0F), PartPose.offset(0.0F, -6.0F, -8.0F));
		head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(48, 12).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 3.0F, 4.0F).texOffs(0, 0).addBox(-1.5F, 2.0F, -3.0F, 3.0F, 1.0F, 3.0F), PartPose.offset(0.0F, 2.0F, -6.0F));
		head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(48, 0).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 1.0F, 4.0F), PartPose.offset(0.0F, 4.0F, -6.0F));
		body.addOrReplaceChild("flipper_left", CubeListBuilder.create().texOffs(0, 36).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 7.0F), PartPose.offset(4.0F, 1.0F, -6.0F));
		body.addOrReplaceChild("flipper_right", CubeListBuilder.create().texOffs(0, 36).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 3.0F, 7.0F), PartPose.offset(-4.0F, 1.0F, -6.0F));
		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(28, 22).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 10.0F), PartPose.offset(0.0F, 1.0F, 7.0F));
		tail.addOrReplaceChild("tail_flipper_left", CubeListBuilder.create().texOffs(0, 46).mirror().addBox(0.0F, -3.0F, 0.0F, 1.0F, 6.0F, 8.0F), PartPose.offset(2.0F, 0.0F, 10.0F));
		tail.addOrReplaceChild("tail_flipper_right", CubeListBuilder.create().texOffs(0, 46).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 6.0F, 8.0F), PartPose.offset(-2.0F, 0.0F, 10.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.body);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.jaw.xRot = (Mth.sin(ageInTicks / 10) * Mth.sin(ageInTicks / 10)) / 2;
		this.neck.xRot = -(float) (Math.PI / 4);
		this.head.xRot = (float) (Math.PI / 4);
		this.tailFlipperLeft.yRot = (float) Math.PI / 8;
		this.tailFlipperRight.yRot = -(float) Math.PI / 8;
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