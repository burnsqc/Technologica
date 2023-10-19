package com.technologica.client.model;

import com.google.common.collect.ImmutableList;
import com.technologica.world.entity.animal.Raccoon;

import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class RaccoonModel<T extends Raccoon> extends QuadrupedModel<T> {
	private final ModelPart earRight;
	private final ModelPart earLeft;
	private final ModelPart tail;

	public RaccoonModel(ModelPart modelPartIn) {
		super(modelPartIn, true, 20.0F, 0.5F, 2.7272F, 2.0F, 24);
		this.earLeft = this.head.getChild("earLeft");
		this.earRight = this.head.getChild("earRight");
		this.tail = this.body.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition partdefinition1 = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(14, 16).addBox(-2.5F, -5.0F, -3.0F, 5.0F, 4.0F, 3.0F), PartPose.offset(0.0F, 21.0F, -5.0F));
		partdefinition1.addOrReplaceChild("earLeft", CubeListBuilder.create().texOffs(0, 16).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 1.0F), PartPose.offset(-2.0F, -5.0F, -2.0F));
		partdefinition1.addOrReplaceChild("earRight", CubeListBuilder.create().texOffs(0, 16).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 1.0F), PartPose.offset(2.0F, -5.0F, -2.0F));
		partdefinition1.addOrReplaceChild("real_head", CubeListBuilder.create().texOffs(0, 6).addBox(-1.0F, -3.0F, -5.0F, 2.0F, 2.0F, 2.0F), PartPose.ZERO);
		PartDefinition partdefinition2 = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -6.0F, -7.0F, 8.0F, 6.0F, 10.0F), PartPose.offset(0.0F, 21.0F, 2.0F));
		partdefinition.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offset(-2.0F, 21.0F, 3.0F));
		partdefinition.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offset(2.0F, 21.0F, 3.0F));
		partdefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offset(-2.0F, 21.0F, -3.0F));
		partdefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offset(2.0F, 21.0F, -3.0F));
		partdefinition2.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(2, 16).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F), PartPose.offset(0.0F, -4.0F, 2.0F));
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(this.body, this.rightHindLeg, this.leftHindLeg, this.rightFrontLeg, this.leftFrontLeg);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.xRot = headPitch * ((float) Math.PI / 180F) * 0.5F;
		this.head.yRot = netHeadYaw * ((float) Math.PI / 180F) * 0.5F;
		this.earLeft.zRot = -(float) Math.PI / 4F;
		this.earRight.zRot = 3 * -(float) Math.PI / 4F;
	}

	@Override
	public void prepareMobModel(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		if (entityIn.isBegging()) {
			this.body.xRot = -(float) Math.PI / 3;
			this.head.setPos(0.0F, 15.0F, 1.0F);
			this.leftFrontLeg.setPos(2.0F, 17.0F, 0.0F);
			this.rightFrontLeg.setPos(-2.0F, 17.0F, 0.0F);
			this.leftFrontLeg.xRot = Mth.sin(0.75F * (entityIn.tickCount + partialTick)) - (float) Math.PI / 3;
			this.rightFrontLeg.xRot = Mth.sin(0.75F * (entityIn.tickCount + partialTick)) - (float) Math.PI / 3;
			this.leftFrontLeg.zRot = -(float) Math.PI / 10;
			this.rightFrontLeg.zRot = (float) Math.PI / 10;
			this.tail.xRot = (float) Math.PI / 3;
		} else {
			this.body.xRot = 0;
			this.head.setPos(0.0F, 21.0F, -5.0F);
			this.leftFrontLeg.setPos(2.0F, 21.0F, -3.0F);
			this.rightFrontLeg.setPos(-2.0F, 21.0F, -3.0F);
			this.rightFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.leftFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.leftFrontLeg.zRot = 0;
			this.rightFrontLeg.zRot = 0;
			this.tail.xRot = -((float) Math.PI / 10F);
		}
		this.rightHindLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftHindLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
	}
}