package com.technologica.client.model;

import com.google.common.collect.ImmutableList;
import com.technologica.world.entity.animal.Jaguar;

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

public class JaguarModel<T extends Jaguar> extends AgeableListModel<T> {
	protected final ModelPart legBackLeft;
	protected final ModelPart legBackRight;
	protected final ModelPart legFrontLeft;
	protected final ModelPart legFrontRight;
	protected final ModelPart tail;
	protected final ModelPart tail2;
	protected final ModelPart head;
	protected final ModelPart body;
	private ModelPart earRight;
	private ModelPart earLeft;
	protected int state = 1;
	
	public JaguarModel(ModelPart modelPartIn) {
		super(true, 10.0F, 4.0F);
		this.body = modelPartIn.getChild("body");
		this.head = modelPartIn.getChild("head");
		this.earLeft = head.getChild("earLeft");
		this.earRight = head.getChild("earRight");
		this.legBackLeft = modelPartIn.getChild("legBackLeft");
		this.legBackRight = modelPartIn.getChild("legBackRight");
		this.legFrontLeft = modelPartIn.getChild("legFrontLeft");
		this.legFrontRight = modelPartIn.getChild("legFrontRight");
		this.tail = modelPartIn.getChild("tail");
		this.tail2 = tail.getChild("tail2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition root = meshdefinition.getRoot();
		root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 16.0F, 8.0F), PartPose.offset(0.0F, 12.0F, 0.0F));
		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 0).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 6.0F), PartPose.offset(0.0F, 9.0F, -6.0F));
		head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(24, 0).addBox(-1.5F, 0.0F, -8.0F, 3.0F, 3.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("earLeft", CubeListBuilder.create().texOffs(50, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 1.0F), PartPose.offset(3.0F, -3.0F, -3.0F));
		head.addOrReplaceChild("earRight", CubeListBuilder.create().texOffs(50, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 1.0F), PartPose.offset(-3.0F, -3.0F, -3.0F));
		root.addOrReplaceChild("legBackLeft", CubeListBuilder.create().texOffs(32, 12).addBox(-1.0F, 0.0F, -3.0F, 3.0F, 8.0F, 3.0F), PartPose.offset(2.0F, 16.0F, 8.0F));
		root.addOrReplaceChild("legBackRight", CubeListBuilder.create().texOffs(32, 12).addBox(-1.0F, 0.0F, -3.0F, 3.0F, 8.0F, 3.0F), PartPose.offset(-3.0F, 16.0F, 8.0F));
		root.addOrReplaceChild("legFrontLeft", CubeListBuilder.create().texOffs(32, 12).addBox(-1.0F, 0.0F, 0.0F, 3.0F, 8.0F, 3.0F), PartPose.offset(2.0F, 16.0F, -8.0F));
		root.addOrReplaceChild("legFrontRight", CubeListBuilder.create().texOffs(32, 12).addBox(-1.0F, 0.0F, 0.0F, 3.0F, 8.0F, 3.0F), PartPose.offset(-3.0F, 16.0F, -8.0F));
		PartDefinition tail = root.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(56, 0).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 8.0F, 2.0F), PartPose.offset(0.0F, 8.0F, 8.0F));
		tail.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(56, 10).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F), PartPose.offset(0.0F, 8.0F, -2.0F));
		return LayerDefinition.create(meshdefinition, 64, 32);
	}
	
	@Override
	protected Iterable<ModelPart> headParts() {
		return ImmutableList.of(this.head);
	}

	@Override
	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(this.body, this.legBackLeft, this.legBackRight, this.legFrontLeft, this.legFrontRight, this.tail);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.xRot = headPitch * ((float) Math.PI / 180F);
		this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
		if (this.state != 3) {
			this.body.xRot = ((float) Math.PI / 2F);
			if (this.state == 2) {
				this.legBackLeft.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
				this.legBackRight.xRot = Mth.cos(limbSwing * 0.6662F + 0.3F) * limbSwingAmount;
				this.legFrontLeft.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI + 0.3F) * limbSwingAmount;
				this.legFrontRight.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
				this.tail2.xRot = 0.7278761F + ((float) Math.PI / 10F) * Mth.cos(limbSwing) * limbSwingAmount;
			} else {
				this.legBackLeft.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
				this.legBackRight.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
				this.legFrontLeft.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
				this.legFrontRight.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
				if (this.state == 1) {
					this.tail2.xRot = 0.7278761F + ((float) Math.PI / 4F) * Mth.cos(limbSwing) * limbSwingAmount;
				} else {
					this.tail2.xRot = 0.7278761F + 0.47123894F * Mth.cos(limbSwing) * limbSwingAmount;
				}
			}
		}
		
		this.earLeft.zRot = -3 * (float) Math.PI / 4;
		this.earRight.zRot = 3 * (float) Math.PI / 4;
	}
	
	@Override
	public void prepareMobModel(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		this.tail.xRot = 0.9F;
		if (entityIn.isCrouching()) {
			++this.body.y;
			this.head.y += 2.0F;
			++this.tail.y;
			this.tail.xRot = ((float) Math.PI / 2F);
			this.tail2.xRot = ((float) Math.PI / 2F);
			this.state = 0;
		} else if (entityIn.isSprinting()) {
			
			this.tail.xRot = ((float) Math.PI / 2F);
			this.tail2.xRot = ((float) Math.PI / 2F);
			this.state = 2;
		} else {
			this.state = 1;
		}
	}
}