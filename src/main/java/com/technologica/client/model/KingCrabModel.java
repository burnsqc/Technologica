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

public class KingCrabModel<T extends Entity> extends ListModel<T> {
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart legBackBackLeftUpper;
	private final ModelPart legBackBackLeftLower;
	private final ModelPart legBackBackRightUpper;
	private final ModelPart legBackBackRightLower;
	private final ModelPart legBackRightUpper;
	private final ModelPart legBackRightLower;
	private final ModelPart legBackLeftUpper;
	private final ModelPart legBackLeftLower;
	private final ModelPart legFrontRightUpper;
	private final ModelPart legFrontRightLower;
	private final ModelPart legFrontLeftUpper;
	private final ModelPart legFrontLeftLower;
	private final ModelPart legFrontFrontRightUpper;
	private final ModelPart legFrontFrontRightLower;
	private final ModelPart legFrontFrontLeftUpper;
	private final ModelPart legFrontFrontLeftLower;
	private final ModelPart armLeft;
	private final ModelPart armRight;
	private final ModelPart clawLeft;
	private final ModelPart clawRight;
	private final ModelPart pincherLeft;
	private final ModelPart pincherRight;

	public KingCrabModel(ModelPart modelPartIn) {
		this.body = modelPartIn.getChild("body");
		this.head = body.getChild("head");
		this.legBackBackLeftUpper = modelPartIn.getChild("legBackBackLeftUpper");
		this.legBackBackLeftLower = legBackBackLeftUpper.getChild("legBackBackLeftLower");
		this.legBackBackRightUpper = modelPartIn.getChild("legBackBackRightUpper");
		this.legBackBackRightLower = legBackBackRightUpper.getChild("legBackBackRightLower");
		this.legBackLeftUpper = modelPartIn.getChild("legBackLeftUpper");
		this.legBackLeftLower = legBackLeftUpper.getChild("legBackLeftLower");
		this.legBackRightUpper = modelPartIn.getChild("legBackRightUpper");
		this.legBackRightLower = legBackRightUpper.getChild("legBackRightLower");
		this.legFrontLeftUpper = modelPartIn.getChild("legFrontLeftUpper");
		this.legFrontLeftLower = legFrontLeftUpper.getChild("legFrontLeftLower");
		this.legFrontRightUpper = modelPartIn.getChild("legFrontRightUpper");
		this.legFrontRightLower = legFrontRightUpper.getChild("legFrontRightLower");
		this.legFrontFrontLeftUpper = modelPartIn.getChild("legFrontFrontLeftUpper");
		this.legFrontFrontLeftLower = legFrontFrontLeftUpper.getChild("legFrontFrontLeftLower");
		this.legFrontFrontRightUpper = modelPartIn.getChild("legFrontFrontRightUpper");
		this.legFrontFrontRightLower = legFrontFrontRightUpper.getChild("legFrontFrontRightLower");
		this.armLeft = body.getChild("armLeft");
		this.clawLeft = armLeft.getChild("clawLeft");
		this.pincherLeft = clawLeft.getChild("pincherLeft");
		this.armRight = body.getChild("armRight");
		this.clawRight = armRight.getChild("clawRight");
		this.pincherRight = clawRight.getChild("pincherRight");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 7.0F), PartPose.offset(0.0F, 6.0F, 0.0F));
		body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 11).addBox(-2.0F, -0.99F, -2.0F, 4.0F, 1.98F, 4.0F), PartPose.offset(0.0F, -1.0F, -3.0F));
		PartDefinition legBackBackLeftUpper = partdefinition.addOrReplaceChild("legBackBackLeftUpper", CubeListBuilder.create().texOffs(16, 13).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F), PartPose.offset(4.0F, 7.0F, 2.0F));
		legBackBackLeftUpper.addOrReplaceChild("legBackBackLeftLower", CubeListBuilder.create().texOffs(0, 17).addBox(0.0F, 0.01F, -0.99F, 16.0F, 1.98F, 1.98F), PartPose.offset(15.0F, 1.0F, 0.0F));
		PartDefinition legBackBackRightUpper = partdefinition.addOrReplaceChild("legBackBackRightUpper", CubeListBuilder.create().texOffs(16, 13).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F), PartPose.offset(-4.0F, 7.0F, 2.0F));
		legBackBackRightUpper.addOrReplaceChild("legBackBackRightLower", CubeListBuilder.create().texOffs(0, 17).addBox(-16.0F, 0.01F, -0.99F, 16.0F, 1.98F, 1.98F), PartPose.offset(-15.0F, 1.0F, 0.0F));
		PartDefinition legBackLeftUpper = partdefinition.addOrReplaceChild("legBackLeftUpper", CubeListBuilder.create().texOffs(16, 13).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F), PartPose.offset(4.0F, 7.0F, 1.0F));
		legBackLeftUpper.addOrReplaceChild("legBackLeftLower", CubeListBuilder.create().texOffs(0, 17).addBox(0.0F, 0.01F, -0.99F, 16.0F, 1.98F, 1.98F), PartPose.offset(15.0F, 1.0F, 0.0F));
		PartDefinition legBackRightUpper = partdefinition.addOrReplaceChild("legBackRightUpper", CubeListBuilder.create().texOffs(16, 13).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F), PartPose.offset(-4.0F, 7.0F, 1.0F));
		legBackRightUpper.addOrReplaceChild("legBackRightLower", CubeListBuilder.create().texOffs(0, 17).addBox(-16.0F, 0.01F, -0.99F, 16.0F, 1.98F, 1.98F), PartPose.offset(-15.0F, 1.0F, 0.0F));
		PartDefinition legFrontLeftUpper = partdefinition.addOrReplaceChild("legFrontLeftUpper", CubeListBuilder.create().texOffs(16, 13).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F), PartPose.offset(4.0F, 7.0F, 0.0F));
		legFrontLeftUpper.addOrReplaceChild("legFrontLeftLower", CubeListBuilder.create().texOffs(0, 17).addBox(0.0F, 0.01F, -0.99F, 16.0F, 1.98F, 1.98F), PartPose.offset(15.0F, 1.0F, 0.0F));
		PartDefinition legFrontRightUpper = partdefinition.addOrReplaceChild("legFrontRightUpper", CubeListBuilder.create().texOffs(16, 13).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F), PartPose.offset(-4.0F, 7.0F, 0.0F));
		legFrontRightUpper.addOrReplaceChild("legFrontRightLower", CubeListBuilder.create().texOffs(0, 17).addBox(-16.0F, 0.01F, -0.99F, 16.0F, 1.98F, 1.98F), PartPose.offset(-15.0F, 1.0F, 0.0F));
		PartDefinition legFrontFrontLeftUpper = partdefinition.addOrReplaceChild("legFrontFrontLeftUpper", CubeListBuilder.create().texOffs(16, 13).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F), PartPose.offset(4.0F, 7.0F, -1.0F));
		legFrontFrontLeftUpper.addOrReplaceChild("legFrontFrontLeftLower", CubeListBuilder.create().texOffs(0, 17).addBox(0.0F, 0.01F, -0.99F, 16.0F, 1.98F, 1.98F), PartPose.offset(15.0F, 1.0F, 0.0F));
		PartDefinition legFrontFrontRightUpper = partdefinition.addOrReplaceChild("legFrontFrontRightUpper", CubeListBuilder.create().texOffs(16, 13).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F), PartPose.offset(-4.0F, 7.0F, -1.0F));
		legFrontFrontRightUpper.addOrReplaceChild("legFrontFrontRightLower", CubeListBuilder.create().texOffs(0, 17).addBox(-16.0F, 0.01F, -0.99F, 16.0F, 1.98F, 1.98F), PartPose.offset(-15.0F, 1.0F, 0.0F));
		PartDefinition armLeft = body.addOrReplaceChild("armLeft", CubeListBuilder.create().texOffs(0, 21).addBox(-2.0F, -0.99F, -1.0F, 10.0F, 1.98F, 2.0F), PartPose.offset(4.0F, 1.0F, -3.0F));
		PartDefinition clawLeft = armLeft.addOrReplaceChild("clawLeft", CubeListBuilder.create().texOffs(14, 25).addBox(0.0F, -1.0F, -2.0F, 10.0F, 2.0F, 2.0F), PartPose.offset(8.0F, 0.0F, 1.0F));
		clawLeft.addOrReplaceChild("pincherLeft", CubeListBuilder.create().texOffs(0, 25).addBox(0.0F, -0.99F, -2.0F, 5.0F, 1.98F, 2.0F), PartPose.offset(5.0F, 0.0F, 0.0F));
		PartDefinition armRight = body.addOrReplaceChild("armRight", CubeListBuilder.create().texOffs(0, 21).addBox(-8.0F, -0.99F, -1.0F, 10.0F, 1.98F, 2.0F), PartPose.offset(-4.0F, 1.0F, -3.0F));
		PartDefinition clawRight = armRight.addOrReplaceChild("clawRight", CubeListBuilder.create().texOffs(14, 25).addBox(0.0F, -1.0F, 0.0F, 10.0F, 2.0F, 2.0F), PartPose.offset(-8.0F, 0.0F, 1.0F));
		clawRight.addOrReplaceChild("pincherRight", CubeListBuilder.create().texOffs(0, 25).addBox(0.0F, -0.99F, 0.0F, 5.0F, 1.98F, 2.0F), PartPose.offset(5.0F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.body, this.legBackBackRightUpper, this.legBackBackLeftUpper, this.legBackRightUpper, this.legBackLeftUpper, this.legFrontRightUpper, this.legFrontLeftUpper, this.legFrontFrontRightUpper, this.legFrontFrontLeftUpper);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = ((float) Math.PI / 4F);
		this.legBackBackRightUpper.zRot = 0;
		this.legBackBackLeftUpper.zRot = 0;
		this.legBackRightUpper.zRot = 0;
		this.legBackLeftUpper.zRot = 0;
		this.legFrontRightUpper.zRot = 0;
		this.legFrontLeftUpper.zRot = 0;
		this.legFrontFrontRightUpper.zRot = 0;
		this.legFrontFrontLeftUpper.zRot = 0;
		this.legBackBackRightUpper.yRot = ((float) Math.PI / 4F);
		this.legBackBackLeftUpper.yRot = -((float) Math.PI / 4F);
		this.legBackRightUpper.yRot = ((float) Math.PI / 8F);
		this.legBackLeftUpper.yRot = -((float) Math.PI / 8F);
		this.legFrontRightUpper.yRot = 0;
		this.legFrontLeftUpper.yRot = 0;
		this.legFrontFrontRightUpper.yRot = -((float) Math.PI / 8F);
		this.legFrontFrontLeftUpper.yRot = ((float) Math.PI / 8F);
		this.legBackBackLeftLower.zRot = (float) Math.PI / 2;
		this.legBackBackRightLower.zRot = -(float) Math.PI / 2;
		this.legBackLeftLower.zRot = (float) Math.PI / 2;
		this.legBackRightLower.zRot = -(float) Math.PI / 2;
		this.legFrontLeftLower.zRot = (float) Math.PI / 2;
		this.legFrontRightLower.zRot = -(float) Math.PI / 2;
		this.legFrontFrontLeftLower.zRot = (float) Math.PI / 2;
		this.legFrontFrontRightLower.zRot = -(float) Math.PI / 2;
		float f3 = (float) (-(Math.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount);
		float f4 = (float) (-(Math.cos(limbSwing * 0.6662F * 2.0F + (float) Math.PI) * 0.4F) * limbSwingAmount);
		float f5 = (float) (-(Math.cos(limbSwing * 0.6662F * 2.0F + ((float) Math.PI / 2F)) * 0.4F) * limbSwingAmount);
		float f6 = (float) (-(Math.cos(limbSwing * 0.6662F * 2.0F + ((float) Math.PI * 1.5F)) * 0.4F) * limbSwingAmount);
		float f7 = (float) (Math.abs(Math.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount);
		float f8 = (float) (Math.abs(Math.sin(limbSwing * 0.6662F + (float) Math.PI) * 0.4F) * limbSwingAmount);
		float f9 = (float) (Math.abs(Math.sin(limbSwing * 0.6662F + ((float) Math.PI / 2F)) * 0.4F) * limbSwingAmount);
		float f10 = (float) (Math.abs(Math.sin(limbSwing * 0.6662F + ((float) Math.PI * 1.5F)) * 0.4F) * limbSwingAmount);
		this.legBackBackRightUpper.yRot += f3;
		this.legBackBackLeftUpper.yRot += -f3;
		this.legBackRightUpper.yRot += f4;
		this.legBackLeftUpper.yRot += -f4;
		this.legFrontRightUpper.yRot += f5;
		this.legFrontLeftUpper.yRot += -f5;
		this.legFrontFrontRightUpper.yRot += f6;
		this.legFrontFrontLeftUpper.yRot += -f6;
		this.legBackBackRightUpper.zRot += f7;
		this.legBackBackLeftUpper.zRot += -f7;
		this.legBackRightUpper.zRot += f8;
		this.legBackLeftUpper.zRot += -f8;
		this.legFrontRightUpper.zRot += f9;
		this.legFrontLeftUpper.zRot += -f9;
		this.legFrontFrontRightUpper.zRot += f10;
		this.legFrontFrontLeftUpper.zRot += -f10;
		this.armLeft.yRot = (float) Math.PI / 4F;
		this.armRight.yRot = -(float) Math.PI / 4F;
		this.clawLeft.yRot = (float) Math.PI / 4F;
		this.clawRight.yRot = 3 * (float) Math.PI / 4F;
		this.pincherLeft.yRot = (float) Math.PI / 4F;
		this.pincherRight.yRot = -(float) Math.PI / 4F;
	}

	public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}