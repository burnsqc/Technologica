package com.technologica.client.model;

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

public class CrabModel<T extends Entity> extends ListModel<T> {
	/*
	private final ModelPart scorpionBody;
	private final ModelPart eyeRight;
	private final ModelPart eyeLeft;
	private final ModelPart scorpionLeg1;
	private final ModelPart scorpionLeg2;
	private final ModelPart scorpionLeg3;
	private final ModelPart scorpionLeg4;
	private final ModelPart scorpionLeg5;
	private final ModelPart scorpionLeg6;
	private final ModelPart scorpionLeg7;
	private final ModelPart scorpionLeg8;
	private final ModelPart scorpionArmRight;
	private final ModelPart scorpionClawRight;
	private final ModelPart scorpionPincherRightInner;
	private final ModelPart scorpionArmLeft;
	private final ModelPart scorpionClawLeft;
	private final ModelPart scorpionPincherLeftInner;
	*/

	public CrabModel() {
		/*
		texWidth = 32;
		texHeight = 16;

		scorpionBody = new ModelPart(this);
		scorpionBody.setPos(0.0F, 4.0F, -3.0F);
		scorpionBody.texOffs(0, 0).addBox(-3.0F, 16.0F, 0.0F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		
		eyeRight = new ModelPart(this);
		eyeRight.texOffs(0, 0).addBox(-2.0F, 15.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		scorpionBody.addChild(eyeRight);
		
		eyeLeft = new ModelPart(this);
		eyeLeft.texOffs(0, 0).addBox(1.0F, 15.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		scorpionBody.addChild(eyeLeft);
		
		scorpionLeg1 = new ModelPart(this);
		scorpionLeg1.setPos(-3.0F, 22.0F, 1.0F);
		scorpionLeg1.texOffs(0, 7).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		
		scorpionLeg2 = new ModelPart(this);
		scorpionLeg2.setPos(3.0F, 22.0F, 1.0F);
		scorpionLeg2.texOffs(0, 7).addBox(-1.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		scorpionLeg3 = new ModelPart(this);
		scorpionLeg3.setPos(-3.0F, 22.0F, 0.0F);
		scorpionLeg3.texOffs(0, 7).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		scorpionLeg4 = new ModelPart(this);
		scorpionLeg4.setPos(3.0F, 22.0F, 0.0F);
		scorpionLeg4.texOffs(0, 7).addBox(-1.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		scorpionLeg5 = new ModelPart(this);
		scorpionLeg5.setPos(-3.0F, 22.0F, -1.0F);
		scorpionLeg5.texOffs(0, 7).addBox(-3.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		scorpionLeg6 = new ModelPart(this);
		scorpionLeg6.setPos(3.0F, 22.0F, -1.0F);
		scorpionLeg6.texOffs(0, 7).addBox(-1.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		scorpionLeg7 = new ModelPart(this);
		scorpionLeg7.setPos(-3.0F, 22.0F, -2.0F);
		scorpionLeg7.texOffs(0, 7).addBox(-3.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		scorpionLeg8 = new ModelPart(this, 0, 7);
		scorpionLeg8.setPos(3.0F, 22.0F, -2.0F);
		scorpionLeg8.texOffs(0, 7).addBox(-1.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		scorpionArmRight = new ModelPart(this);
		scorpionArmRight.setPos(-2.0F, 1.0F, 0.0F);
		scorpionArmRight.texOffs(0, 9).addBox(-3.0F, 16.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		scorpionBody.addChild(scorpionArmRight);

		scorpionClawRight = new ModelPart(this);
		scorpionClawRight.setPos(-3.0F, 0.0F, 1.0F);
		scorpionClawRight.texOffs(0, 11).addBox(-2.0F, 16.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		scorpionArmRight.addChild(scorpionClawRight);
		
		scorpionPincherRightInner = new ModelPart(this);
		scorpionPincherRightInner.setPos(-3.0F, 0.0F, 1.0F);
		scorpionPincherRightInner.texOffs(0, 11).addBox(-2.0F, 16.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		scorpionArmRight.addChild(scorpionPincherRightInner);

		scorpionArmLeft = new ModelPart(this);
		scorpionArmLeft.setPos(2.0F, 1.0F, 0.0F);
		scorpionArmLeft.texOffs(0, 9).addBox(0.0F, 16.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		scorpionBody.addChild(scorpionArmLeft);

		scorpionClawLeft = new ModelPart(this);
		scorpionClawLeft.setPos(3.0F, 0.0F, 1.0F);
		scorpionClawLeft.texOffs(0, 11).addBox(-2.0F, 16.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		scorpionArmLeft.addChild(scorpionClawLeft);
		
		scorpionPincherLeftInner = new ModelPart(this);
		scorpionPincherLeftInner.setPos(3.0F, 0.0F, 1.0F);
		scorpionPincherLeftInner.texOffs(0, 11).addBox(-2.0F, 16.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		scorpionArmLeft.addChild(scorpionPincherLeftInner);
		*/
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition partdefinition = meshdefinition.getRoot();
		
		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 14).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 21.0F, -4.0F));
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 10.0F, -6.0F, 6.0F, 6.0F, 8.0F), PartPose.offset(0.0F, 6.0F, 2.0F));
		
		partdefinition.addOrReplaceChild("rightHindLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(-2.0F, 21.0F, 3.0F));
		partdefinition.addOrReplaceChild("leftHindLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(2.0F, 21.0F, 3.0F));
		partdefinition.addOrReplaceChild("rightFrontLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(-2.0F, 21.0F, -3.0F));
		partdefinition.addOrReplaceChild("leftFrontLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(2.0F, 21.0F, -3.0F));
		partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 6.0F), PartPose.offset(0.0F, 14.0F, 2.0F));
		
		return LayerDefinition.create(meshdefinition, 32, 32);
	}
	
	@Override
	public Iterable<ModelPart> parts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setupAnim(T p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_,
			float p_102623_) {
		// TODO Auto-generated method stub
		
	}

	/*
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.scorpionBody, this.scorpionLeg1, this.scorpionLeg2, this.scorpionLeg3, this.scorpionLeg4, this.scorpionLeg5, this.scorpionLeg6, this.scorpionLeg7, this.scorpionLeg8);
	}

	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		scorpionArmRight.yRot = -(float) Math.PI / 4F;
		scorpionClawRight.yRot = -(float) Math.PI / 4F;
		scorpionPincherRightInner.yRot = 2 * -(float) Math.PI / 4F;
		scorpionArmLeft.yRot = (float) Math.PI / 4F;
		scorpionClawLeft.yRot = 3 * -(float) Math.PI / 4F;
		scorpionPincherLeftInner.yRot = 2 * -(float) Math.PI / 4F;
		this.scorpionLeg1.zRot = (-(float) Math.PI / 4F);
		this.scorpionLeg2.zRot = ((float) Math.PI / 4F);
		this.scorpionLeg3.zRot = -0.58119464F;
		this.scorpionLeg4.zRot = 0.58119464F;
		this.scorpionLeg5.zRot = -0.58119464F;
		this.scorpionLeg6.zRot = 0.58119464F;
		this.scorpionLeg7.zRot = (-(float) Math.PI / 4F);
		this.scorpionLeg8.zRot = ((float) Math.PI / 4F);
		this.scorpionLeg1.yRot = ((float) Math.PI / 4F);
		this.scorpionLeg2.yRot = (-(float) Math.PI / 4F);
		this.scorpionLeg3.yRot = ((float) Math.PI / 8F);
		this.scorpionLeg4.yRot = (-(float) Math.PI / 8F);
		this.scorpionLeg5.yRot = (-(float) Math.PI / 8F);
		this.scorpionLeg6.yRot = ((float) Math.PI / 8F);
		this.scorpionLeg7.yRot = (-(float) Math.PI / 4F);
		this.scorpionLeg8.yRot = ((float) Math.PI / 4F);
		float f3 = -(Mth.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
		float f4 = -(Mth.cos(limbSwing * 0.6662F * 2.0F + (float) Math.PI) * 0.4F) * limbSwingAmount;
		float f5 = -(Mth.cos(limbSwing * 0.6662F * 2.0F + ((float) Math.PI / 2F)) * 0.4F) * limbSwingAmount;
		float f6 = -(Mth.cos(limbSwing * 0.6662F * 2.0F + ((float) Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
		float f7 = Math.abs(Mth.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
		float f8 = Math.abs(Mth.sin(limbSwing * 0.6662F + (float) Math.PI) * 0.4F) * limbSwingAmount;
		float f9 = Math.abs(Mth.sin(limbSwing * 0.6662F + ((float) Math.PI / 2F)) * 0.4F) * limbSwingAmount;
		float f10 = Math.abs(Mth.sin(limbSwing * 0.6662F + ((float) Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
		this.scorpionLeg1.yRot += f3;
		this.scorpionLeg2.yRot += -f3;
		this.scorpionLeg3.yRot += f4;
		this.scorpionLeg4.yRot += -f4;
		this.scorpionLeg5.yRot += f5;
		this.scorpionLeg6.yRot += -f5;
		this.scorpionLeg7.yRot += f6;
		this.scorpionLeg8.yRot += -f6;
		this.scorpionLeg1.zRot += f7;
		this.scorpionLeg2.zRot += -f7;
		this.scorpionLeg3.zRot += f8;
		this.scorpionLeg4.zRot += -f8;
		this.scorpionLeg5.zRot += f9;
		this.scorpionLeg6.zRot += -f9;
		this.scorpionLeg7.zRot += f10;
		this.scorpionLeg8.zRot += -f10;
	}

	public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
	*/
}