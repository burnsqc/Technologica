package com.technologica.client.model;

import com.google.common.collect.ImmutableList;
import com.technologica.world.entity.animal.ScorpionEntity;

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
import net.minecraft.util.Mth;

public class ScorpionModel<T extends Entity> extends ListModel<T> {
	/*
	private final ModelPart body;
	private final ModelPart tail1;
	private final ModelPart tail2;
	private final ModelPart tail3;
	private final ModelPart tail4;
	private final ModelPart tail5;
	private final ModelPart tail6;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	private final ModelPart leg5;
	private final ModelPart leg6;
	private final ModelPart leg7;
	private final ModelPart leg8;
	private final ModelPart armRight;
	private final ModelPart armLeft;
	private final ModelPart clawRight;
	private final ModelPart clawLeft;
	private final ModelPart pincherRightInner;
	private final ModelPart pincherRightOuter;
	private final ModelPart pincherLeftInner;
	private final ModelPart pincherLeftOuter;
	*/

	public ScorpionModel() {
		/*
		this.texWidth = 64;
		this.texHeight = 64;

		this.body = new ModelPart(this, 0, 0);
		this.body.setPos(0.0F, 15.0F, -3.0F);
		this.body.addBox(-4.0F, -2.0F, -2.0F, 8.0F, 4.0F, 16.0F);

		this.tail1 = new ModelPart(this);
		this.tail1.setPos(0.0F, 0.0F, 12.0F);
		this.tail1.texOffs(0, 20).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 8.0F, 0.0F);
		this.body.addChild(this.tail1);

		tail2 = new ModelPart(this);
		tail2.setPos(0.0F, 2.0F, 8.0F);
		tail2.texOffs(24, 20).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 3.0F, 8.0F);
		this.tail1.addChild(tail2);

		tail3 = new ModelPart(this);
		tail3.setPos(0.0F, 0.0F, 8.0F);
		tail3.texOffs(24, 20).addBox(-1.49F, -3.0F, 0.0F, 2.98F, 2.98F, 8.0F);
		tail2.addChild(tail3);

		tail4 = new ModelPart(this);
		tail4.setPos(0.0F, 0.0F, 8.0F);
		tail4.texOffs(32, 0).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 8.0F);
		tail3.addChild(tail4);
		
		tail5 = new ModelPart(this);
		tail5.setPos(0.0F, 0.0F, 8.0F);
		tail5.texOffs(0, 0).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 3.0F, 3.0F);
		tail4.addChild(tail5);
		
		tail6 = new ModelPart(this);
		tail6.texOffs(9, 0).addBox(-0.5F, -3.0F, 3.0F, 1.0F, 1.0F, 2.0F);
		tail5.addChild(tail6);

		leg1 = new ModelPart(this);
		leg1.setPos(-4.0F, 15.0F, 2.0F);
		leg1.texOffs(0, 32).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

		leg2 = new ModelPart(this);
		leg2.setPos(4.0F, 15.0F, 2.0F);
		leg2.texOffs(0, 32).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

		leg3 = new ModelPart(this);
		leg3.setPos(-4.0F, 15.0F, 1.0F);
		leg3.texOffs(0, 32).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

		leg4 = new ModelPart(this);
		leg4.setPos(4.0F, 15.0F, 1.0F);
		leg4.texOffs(0, 32).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

		leg5 = new ModelPart(this);
		leg5.setPos(-4.0F, 15.0F, 0.0F);
		leg5.texOffs(0, 32).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

		leg6 = new ModelPart(this);
		leg6.setPos(4.0F, 15.0F, 0.0F);
		leg6.texOffs(0, 32).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

		leg7 = new ModelPart(this);
		leg7.setPos(-4.0F, 15.0F, -1.0F);
		leg7.texOffs(0, 32).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

		leg8 = new ModelPart(this);
		leg8.setPos(4.0F, 15.0F, -1.0F);
		leg8.texOffs(0, 32).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

		this.armLeft = new ModelPart(this, 32, 10);
		this.armLeft.setPos(2.0F, 0.0F, 0.0F);
		this.armLeft.addBox(0.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F);
		this.body.addChild(this.armLeft);
		
		this.armRight = new ModelPart(this, 32, 10);
		this.armRight.setPos(-2.0F, 0.0F, 0.0F);
		this.armRight.addBox(-8.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F);
		this.body.addChild(this.armRight);
		
		this.clawLeft = new ModelPart(this, 0, 6);
		this.clawLeft.setPos(7.0F, 0.0F, 0.0F);
		this.clawLeft.addBox(-1.0F, -1.5F, -2.0F, 4.0F, 3.0F, 4.0F);
		this.armLeft.addChild(this.clawLeft);
		
		this.clawRight = new ModelPart(this, 0 ,6);
		this.clawRight.setPos(-7.0F, 0.0F, 0.0F);
		this.clawRight.addBox(-3.0F, -1.5F, -2.0F, 4.0F, 3.0F, 4.0F);
		this.armRight.addChild(this.clawRight);
		
		this.pincherLeftInner = new ModelPart(this, 0, 13);
		this.pincherLeftInner.addBox(3.0F, -0.5F, -2.0F, 4.0F, 1.0F, 2.0F);
		this.clawLeft.addChild(this.pincherLeftInner);
		
		this.pincherLeftOuter = new ModelPart(this, 19, 20);
		this.pincherLeftOuter.setPos(3.0F, 0.0F, 2.0F);
		this.pincherLeftOuter.addBox(0.0F, -0.5F, -1.0F, 4.0F, 1.0F, 1.0F);
		this.clawLeft.addChild(this.pincherLeftOuter);
		
		this.pincherRightInner = new ModelPart(this, 0, 13);
		this.pincherRightInner.addBox(-7.0F, -0.5F, -2.0F, 4.0F, 1.0F, 2.0F);
		this.clawRight.addChild(this.pincherRightInner);
		
		this.pincherRightOuter = new ModelPart(this, 19, 20);
		this.pincherRightOuter.addBox(-4.0F, -0.5F, -1.0F, 4.0F, 1.0F, 1.0F);
		this.pincherRightOuter.setPos(-3.0F, 0.0F, 2.0F);
		this.clawRight.addChild(this.pincherRightOuter);
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
		return ImmutableList.of(this.body, this.leg1, this.leg2, this.leg3, this.leg4, this.leg5, this.leg6, this.leg7, this.leg8);
	}

	public void setupAnim(T entityIn, float limbSwingIn, float limbSwingAmountIn, float ageInTicksIn, float netHeadYawIn, float headPitchIn) {
		this.leg1.yRot = ((float) Math.PI / 4F);
		this.leg2.yRot = (-(float) Math.PI / 4F);
		this.leg3.yRot = ((float) Math.PI / 8F);
		this.leg4.yRot = (-(float) Math.PI / 8F);
		this.leg5.yRot = (-(float) Math.PI / 8F);
		this.leg6.yRot = ((float) Math.PI / 8F);
		this.leg7.yRot = (-(float) Math.PI / 4F);
		this.leg8.yRot = ((float) Math.PI / 4F);
		
		this.leg1.zRot = -(float) Math.PI / 4;
		this.leg2.zRot = (float) Math.PI / 4;
		this.leg3.zRot = -0.58119464F;
		this.leg4.zRot = 0.58119464F;
		this.leg5.zRot = -0.58119464F;
		this.leg6.zRot = 0.58119464F;
		this.leg7.zRot = -(float) Math.PI / 4;
		this.leg8.zRot = (float) Math.PI / 4;
		
		float f1 = -limbSwingAmountIn * 0.4F * Mth.cos(limbSwingIn * 1.3324F);
		float f2 = -limbSwingAmountIn * 0.4F * Mth.cos(limbSwingIn * 1.3324F + (float) Math.PI);
		float f3 = -limbSwingAmountIn * 0.4F * Mth.cos(limbSwingIn * 1.3324F + ((float) Math.PI * 0.5F));
		float f4 = -limbSwingAmountIn * 0.4F * Mth.cos(limbSwingIn * 1.3324F + ((float) Math.PI * 1.5F));
		
		this.leg1.yRot += f1;
		this.leg2.yRot += -f1;
		this.leg3.yRot += f2;
		this.leg4.yRot += -f2;
		this.leg5.yRot += f3;
		this.leg6.yRot += -f3;
		this.leg7.yRot += f4;
		this.leg8.yRot += -f4;
		
		float f5 = limbSwingAmountIn * 0.4F * Math.abs(Mth.sin(limbSwingIn * 0.6662F));
		float f6 = limbSwingAmountIn * 0.4F * Math.abs(Mth.sin(limbSwingIn * 0.6662F + (float) Math.PI));
		float f7 = limbSwingAmountIn * 0.4F * Math.abs(Mth.sin(limbSwingIn * 0.6662F + ((float) Math.PI * 0.5F)));
		float f8 = limbSwingAmountIn * 0.4F * Math.abs(Mth.sin(limbSwingIn * 0.6662F + ((float) Math.PI * 1.5F)));
		
		this.leg1.zRot += f5;
		this.leg2.zRot += -f5;
		this.leg3.zRot += f6;
		this.leg4.zRot += -f6;
		this.leg5.zRot += f7;
		this.leg6.zRot += -f7;
		this.leg7.zRot += f8;
		this.leg8.zRot += -f8;
	}

	@Override
	public void prepareMobModel(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		boolean clawsClicking = ((ScorpionEntity) entityIn).clawCounter != 0;
		
		this.clawLeft.xRot = -(float) Math.PI/2;
		
		this.armLeft.yRot = (float) Math.PI / 4F;
		this.armRight.yRot = -(float) Math.PI / 4F;
		this.clawLeft.yRot = (float) Math.PI / 4F;
		this.clawRight.yRot = -(float) Math.PI / 4F;
		
		this.tail1.xRot = (float) Math.PI / 4;
		this.tail2.xRot = (float) Math.PI / 4;
		this.tail3.xRot = (float) Math.PI / 4;
		this.tail4.xRot = (float) Math.PI / 4;
		this.tail5.xRot = (float) Math.PI / 4;
		
		float f9 = limbSwingAmount * 0.03F * Mth.cos(limbSwing);
		float f10 = ((ScorpionEntity) entityIn).oAttackAnim;
		float f11 = ((ScorpionEntity) entityIn).attackAnim;
		float f12 = f10 + (f11-f10) * partialTick;
		if (f10 > 0) {
			this.tail1.xRot += f12;
			this.tail2.xRot += f12;
			this.tail3.xRot -= f12;
			this.tail4.xRot -= f12;
			this.tail5.xRot -= f12;
		} else {
			this.tail1.xRot += f9;
			this.tail2.xRot += f9;
			this.tail3.xRot += f9;
			this.tail4.xRot += f9;
			this.tail5.xRot += f9;
		}	
		
		if (clawsClicking || ((ScorpionEntity) entityIn).isAggressive()) {
			this.pincherLeftOuter.yRot = 0.25F * Mth.cos((float) (entityIn.tickCount + partialTick) / 2) * Mth.cos((float) (entityIn.tickCount + partialTick) / 2);
			this.pincherRightOuter.yRot = -0.25F * Mth.cos((float) (entityIn.tickCount + partialTick) / 2) * Mth.cos((float) (entityIn.tickCount + partialTick) / 2);
		} else {
			this.pincherLeftOuter.yRot = 0.0F;
			this.pincherRightOuter.yRot = 0.0F;
		}
		
		if (((ScorpionEntity) entityIn).isAggressive()) {
			this.armLeft.yRot += 0.25F * Mth.cos((float) (entityIn.tickCount + partialTick) / 2);
			this.clawLeft.yRot += 0.25F * Mth.cos((float) (entityIn.tickCount + partialTick - Math.PI) / 2);
			this.armRight.yRot -= 0.25F * Mth.cos((float) (entityIn.tickCount + partialTick + Math.PI) / 2);
			this.clawRight.yRot -= 0.25F * Mth.cos((float) (entityIn.tickCount + partialTick) / 2);
		}
	}
	*/
}