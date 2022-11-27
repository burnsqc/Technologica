package com.technologica.client.model;

import com.google.common.collect.ImmutableList;
import com.technologica.world.entity.animal.Lion;

import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class LionModel<T extends Lion> extends QuadrupedModel<T> {
	protected final ModelPart tail;
	protected final ModelPart head;
	protected final ModelPart body;
	private final ModelPart earRight;
	private final ModelPart earLeft;
	protected int state = 1;

	public LionModel(ModelPart modelPartIn) {
		super(modelPartIn, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		this.head = modelPartIn.getChild("head");
		this.tail = modelPartIn.getChild("tail");
		this.body = modelPartIn.getChild("body");
		this.earRight = this.head.getChild("earRight");
		this.earLeft = this.head.getChild("earLeft");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition partdefinition1 = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 45).addBox(-4.0F, -4.0F, -7.0F, 8.0F, 8.0F, 7.0F), PartPose.offset(0.0F, 9.0F, -8.0F));
		partdefinition1.addOrReplaceChild("real_head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.0F, -9.0F, 4.0F, 5.0F, 2.0F), PartPose.ZERO);
		partdefinition1.addOrReplaceChild("earRight", CubeListBuilder.create().texOffs(0, 7).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 1.0F), PartPose.offset(-4.0F, -4.0F, -5.0F));
		partdefinition1.addOrReplaceChild("earLeft", CubeListBuilder.create().texOffs(0, 7).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 1.0F), PartPose.offset(4.0F, -4.0F, -5.0F));
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -5.0F, -10.0F, 10.0F, 10.0F, 20.0F).texOffs(0, 30).addBox(-6.0F, -7.0F, -12.0F, 12.0F, 12.0F, 3.0F).texOffs(30, 30).addBox(-6.5F, -8.0F, -11.0F, 13.0F, 14.0F, 4.0F).texOffs(30, 48).addBox(-6.0F, -6.0F, -9.0F, 12.0F, 12.0F, 4.0F), PartPose.offset(0.0F, 11.0F, 0.0F));
		partdefinition.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(40, 0).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 8.0F, 4.0F), PartPose.offset(-3.0F, 16.0F, 10.0F));
		partdefinition.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(40, 0).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 8.0F, 4.0F), PartPose.offset(3.0F, 16.0F, 10.0F));
		partdefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(40, 0).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 4.0F), PartPose.offset(-3.0F, 16.0F, -10.0F));
		partdefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(40, 0).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 4.0F), PartPose.offset(3.0F, 16.0F, -10.0F));
		partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(12, 0).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 8.0F, 2.0F), PartPose.offset(0.0F, 8.0F, 10.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	protected Iterable<ModelPart> headParts() {
		return ImmutableList.of(this.head);
	}

	@Override
	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(this.body, this.leftHindLeg, this.rightHindLeg, this.leftFrontLeg, this.rightFrontLeg, this.tail);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.xRot = headPitch * ((float) Math.PI / 180F);
		this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
		if (this.state != 3) {
			if (this.state == 2) {
				this.leftHindLeg.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
				this.rightHindLeg.xRot = Mth.cos(limbSwing * 0.6662F + 0.3F) * limbSwingAmount;
				this.leftFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI + 0.3F) * limbSwingAmount;
				this.rightFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
			} else {
				this.leftHindLeg.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
				this.rightHindLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
				this.leftFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
				this.rightFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
			}
		}

		this.earLeft.zRot = -3 * (float) Math.PI / 4;
		this.earRight.zRot = 3 * (float) Math.PI / 4;
	}

	@Override
	public void prepareMobModel(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		this.tail.xRot = (float) Math.PI / 6;
		if (entityIn.isCrouching()) {
			++this.body.y;
			this.head.y += 2.0F;
			++this.tail.y;
			this.tail.xRot = ((float) Math.PI / 2F);
			this.state = 0;
		} else if (entityIn.isSprinting()) {
			this.tail.xRot = ((float) Math.PI / 2F);
			this.state = 2;
		} else {
			this.state = 1;
		}
	}

}