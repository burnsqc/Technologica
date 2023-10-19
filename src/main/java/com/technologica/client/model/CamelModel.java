package com.technologica.client.model;

import com.google.common.collect.ImmutableList;
import com.technologica.world.entity.animal.Camel;

import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class CamelModel<T extends Camel> extends AgeableListModel<T> {
	protected final ModelPart body;
	protected final ModelPart humpFront;
	protected final ModelPart humpRear;
	protected final ModelPart rightHindLeg;
	protected final ModelPart leftHindLeg;
	protected final ModelPart rightFrontLeg;
	protected final ModelPart leftFrontLeg;
	protected final ModelPart tail;
	protected final ModelPart neckLower;
	protected final ModelPart neck;
	protected final ModelPart head;
	protected final ModelPart earLeft;
	protected final ModelPart earRight;

	public CamelModel(ModelPart modelPartIn) {
		super(true, 21.0F, 1.36F, 2.7272F, 2.0F, 24.0F);
		this.body = modelPartIn.getChild("body");
		this.humpFront = body.getChild("hump_front");
		this.humpRear = body.getChild("hump_rear");
		this.rightHindLeg = modelPartIn.getChild("right_hind_leg");
		this.leftHindLeg = modelPartIn.getChild("left_hind_leg");
		this.rightFrontLeg = modelPartIn.getChild("right_front_leg");
		this.leftFrontLeg = modelPartIn.getChild("left_front_leg");
		this.tail = body.getChild("tail");
		this.neckLower = modelPartIn.getChild("neck_lower");
		this.neck = neckLower.getChild("neck");
		this.head = neck.getChild("head");
		this.earLeft = head.getChild("ear_left");
		this.earRight = head.getChild("ear_right");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition root = meshdefinition.getRoot();
		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -10.0F, -13.0F, 10.0F, 10.0F, 18.0F, new CubeDeformation(0.5F)).texOffs(18, 44).addBox(-3.0F, -14.0F, -6.0F, 6.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 11.0F, 5.0F));
		body.addOrReplaceChild("hump_front", CubeListBuilder.create().texOffs(0, 28).addBox(-3.0F, 0.0F, -6.0F, 6.0F, 4.0F, 6.0F), PartPose.offset(0.0F, -14.0F, -6.0F));
		body.addOrReplaceChild("hump_rear", CubeListBuilder.create().texOffs(24, 28).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 4.0F, 6.0F), PartPose.offset(0.0F, -14.0F, -2.0F));
		PartDefinition neckLower = root.addOrReplaceChild("neck_lower", CubeListBuilder.create().texOffs(0, 44).addBox(-2.0F, 5.0F, -6.0F, 4.0F, 5.0F, 10.0F), PartPose.offset(0.0F, 0.0F, -9.0F));
		PartDefinition neck = neckLower.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(38, 0).addBox(-2.0F, -12.0F, 0.0F, 4.0F, 12.0F, 5.0F), PartPose.offset(0.0F, 10.0F, -6.0F));
		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(21, 52).addBox(-3.0F, -5.0F, -2.0F, 6.0F, 5.0F, 7.0F), PartPose.offset(0.0F, -12.0F, 0.0F));
		head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -4.0F, -7.0F, 4.0F, 4.0F, 5.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("ear_left", CubeListBuilder.create().texOffs(0, 9).addBox(2.0F, -5.0F, 3.0F, 2.0F, 2.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("ear_right", CubeListBuilder.create().texOffs(0, 9).addBox(-4.0F, -5.0F, 3.0F, 2.0F, 2.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		root.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(40, 41).mirror().addBox(-3.0F, -1.0F, -1.5F, 3.0F, 13.0F, 3.0F), PartPose.offset(5.0F, 12.0F, 8.5F));
		root.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(40, 41).addBox(-1.0F, -1.0F, -1.5F, 3.0F, 13.0F, 3.0F), PartPose.offset(-4.0F, 12.0F, 8.5F));
		root.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(40, 41).mirror().addBox(-3.0F, -1.0F, -1.5F, 3.0F, 13.0F, 3.0F), PartPose.offset(5.0F, 12.0F, -6.5F));
		root.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(40, 41).addBox(-1.0F, -1.0F, -1.5F, 3.0F, 13.0F, 3.0F), PartPose.offset(-4.0F, 12.0F, -6.5F));
		body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(56, 0).addBox(-1.0F, -1.0F, 1.0F, 2.0F, 12.0F, 2.0F), PartPose.offset(0.0F, -7.0F, 2.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.humpFront.xRot = ((float) Math.PI / 4F);
		this.humpRear.xRot = -((float) Math.PI / 4F);
		this.tail.xRot = ((float) Math.PI / 6F);
		this.body.y = 11.0F;
	}

	@Override
	public Iterable<ModelPart> headParts() {
		return ImmutableList.of(this.neckLower);
	}

	@Override
	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(this.body, this.rightHindLeg, this.leftHindLeg, this.rightFrontLeg, this.leftFrontLeg);
	}

	@Override
	public void prepareMobModel(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		float f = Mth.lerp(partialTick, entityIn.yBodyRotO, entityIn.yBodyRot);
		float f1 = Mth.lerp(partialTick, entityIn.yHeadRotO, entityIn.yHeadRot);

		float f3 = f1 - f;

		if (f3 > 20.0F) {
			f3 = 20.0F;
		}

		if (f3 < -20.0F) {
			f3 = -20.0F;
		}

		float f9 = entityIn.tickCount + partialTick;
		this.body.xRot = 0.0F;
		this.neckLower.yRot = f3 * ((float) Math.PI / 180F);
		float f10 = entityIn.isInWater() ? 0.2F : 1.0F;
		float f11 = Mth.cos(f10 * limbSwing * 0.6662F + (float) Math.PI);
		float f12 = f11 * 0.8F * limbSwingAmount;
		this.rightHindLeg.xRot = -f11 * 0.5F * limbSwingAmount;
		this.leftHindLeg.xRot = f11 * 0.5F * limbSwingAmount;
		this.rightFrontLeg.xRot = f12;
		this.leftFrontLeg.xRot = -f12;

		this.neck.xRot = 0.25F + Mth.sin(f10 * limbSwing * 0.5F) / 4;
		this.head.xRot = -0.25F - Mth.sin(f10 * limbSwing * 0.5F) / 4;

		boolean flag = entityIn.tailCounter != 0;
		if (flag) {
			this.tail.yRot = Mth.cos(f9 * 0.7F);
		} else {
			this.tail.yRot = 0.0F;
		}
	}
}