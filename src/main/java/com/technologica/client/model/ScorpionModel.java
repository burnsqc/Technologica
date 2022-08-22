package com.technologica.client.model;

import com.google.common.collect.ImmutableList;
import com.technologica.world.entity.animal.Scorpion;

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

public class ScorpionModel<T extends Entity> extends ListModel<T> {
	
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
	

	public ScorpionModel(ModelPart modelPartIn) {

		this.body = modelPartIn.getChild("body");
		this.tail1 = body.getChild("tail1");
		this.tail2 = tail1.getChild("tail2");
		this.tail3 = tail2.getChild("tail3");
		this.tail4 = tail3.getChild("tail4");
		this.tail5 = tail4.getChild("tail5");
		this.tail6 = tail5.getChild("tail6");
		this.leg1 = body.getChild("leg1");
		this.leg2 = body.getChild("leg2");
		this.leg3 = body.getChild("leg3");
		this.leg4 = body.getChild("leg4");
		this.leg5 = body.getChild("leg5");
		this.leg6 = body.getChild("leg6");
		this.leg7 = body.getChild("leg7");
		this.leg8 = body.getChild("leg8");
		this.armLeft = body.getChild("armLeft");
		this.clawLeft = armLeft.getChild("clawLeft");
		this.pincherLeftInner = clawLeft.getChild("pincherLeftInner");
		this.pincherLeftOuter = clawLeft.getChild("pincherLeftOuter");
		this.armRight = body.getChild("armRight");
		this.clawRight = armRight.getChild("clawRight");
		this.pincherRightInner = clawRight.getChild("pincherRightInner");
		this.pincherRightOuter = clawRight.getChild("pincherRightOuter");
		
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition partdefinition = meshdefinition.getRoot();
		
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -2.0F, -2.0F, 8.0F, 4.0F, 16.0F), PartPose.offset(0.0F, 15.0F, -3.0F));
			
		PartDefinition tail1 = body.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(0, 20).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 8.0F), PartPose.offset(0.0F, 0.0F, 12.0F));
		PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(24, 20).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 3.0F, 8.0F), PartPose.offset(0.0F, 2.0F, 8.0F));
		PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(24, 20).addBox(-1.49F, -3.0F, 0.0F, 2.98F, 2.98F, 8.0F), PartPose.offset(0.0F, 0.0F, 8.0F));
		PartDefinition tail4 = tail3.addOrReplaceChild("tail4", CubeListBuilder.create().texOffs(32, 0).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 8.0F), PartPose.offset(0.0F, 0.0F, 8.0F));
		PartDefinition tail5 = tail4.addOrReplaceChild("tail5", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 3.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 8.0F));
		tail5.addOrReplaceChild("tail6", CubeListBuilder.create().texOffs(9, 0).addBox(-0.5F, -3.0F, 3.0F, 1.0F, 1.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		
		body.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 32).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F), PartPose.offset(-4.0F, 15.0F, 2.0F));
		body.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F), PartPose.offset(4.0F, 15.0F, 2.0F));
		body.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 32).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F), PartPose.offset(-4.0F, 15.0F, 1.0F));
		body.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F), PartPose.offset(4.0F, 15.0F, 1.0F));
		body.addOrReplaceChild("leg5", CubeListBuilder.create().texOffs(0, 32).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F), PartPose.offset(-4.0F, 15.0F, 0.0F));
		body.addOrReplaceChild("leg6", CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F), PartPose.offset(4.0F, 15.0F, 0.0F));
		body.addOrReplaceChild("leg7", CubeListBuilder.create().texOffs(0, 32).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F), PartPose.offset(-4.0F, 15.0F, -1.0F));
		body.addOrReplaceChild("leg8", CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F), PartPose.offset(4.0F, 15.0F, -1.0F));
		
		PartDefinition armLeft = body.addOrReplaceChild("armLeft", CubeListBuilder.create().texOffs(32, 10).addBox(0.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F), PartPose.offset(2.0F, 0.0F, 0.0F));
		PartDefinition clawLeft = armLeft.addOrReplaceChild("clawLeft", CubeListBuilder.create().texOffs(0, 6).addBox(-1.0F, -1.5F, -2.0F, 4.0F, 3.0F, 4.0F), PartPose.offset(7.0F, 0.0F, 0.0F));
		clawLeft.addOrReplaceChild("pincherLeftInner", CubeListBuilder.create().texOffs(0, 13).addBox(3.0F, -0.5F, -2.0F, 4.0F, 1.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		clawLeft.addOrReplaceChild("pincherLeftOuter", CubeListBuilder.create().texOffs(19, 20).addBox(0.0F, -0.5F, -1.0F, 4.0F, 1.0F, 1.0F), PartPose.offset(3.0F, 0.0F, 2.0F));
		
		PartDefinition armRight = body.addOrReplaceChild("armRight", CubeListBuilder.create().texOffs(32, 10).addBox(-8.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F), PartPose.offset(-2.0F, 0.0F, 0.0F));
		PartDefinition clawRight = armRight.addOrReplaceChild("clawRight", CubeListBuilder.create().texOffs(0, 6).addBox(-3.0F, -1.5F, -2.0F, 4.0F, 3.0F, 4.0F), PartPose.offset(-7.0F, 0.0F, 0.0F));
		clawRight.addOrReplaceChild("pincherRightInner", CubeListBuilder.create().texOffs(0, 13).addBox(-7.0F, -0.5F, -2.0F, 4.0F, 1.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		clawRight.addOrReplaceChild("pincherRightOuter", CubeListBuilder.create().texOffs(19, 20).addBox(-4.0F, -0.5F, -1.0F, 4.0F, 1.0F, 1.0F), PartPose.offset(-3.0F, 0.0F, 2.0F));
							
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	
	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.body, this.leg1, this.leg2, this.leg3, this.leg4, this.leg5, this.leg6, this.leg7, this.leg8);
	}

	@Override
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
		
		float f1 = (float) (-limbSwingAmountIn * 0.4F * Math.cos(limbSwingIn * 1.3324F));
		float f2 = (float) (-limbSwingAmountIn * 0.4F * Math.cos(limbSwingIn * 1.3324F + (float) Math.PI));
		float f3 = (float) (-limbSwingAmountIn * 0.4F * Math.cos(limbSwingIn * 1.3324F + ((float) Math.PI * 0.5F)));
		float f4 = (float) (-limbSwingAmountIn * 0.4F * Math.cos(limbSwingIn * 1.3324F + ((float) Math.PI * 1.5F)));
		
		this.leg1.yRot += f1;
		this.leg2.yRot += -f1;
		this.leg3.yRot += f2;
		this.leg4.yRot += -f2;
		this.leg5.yRot += f3;
		this.leg6.yRot += -f3;
		this.leg7.yRot += f4;
		this.leg8.yRot += -f4;
		
		float f5 = (float) (limbSwingAmountIn * 0.4F * Math.abs(Math.sin(limbSwingIn * 0.6662F)));
		float f6 = (float) (limbSwingAmountIn * 0.4F * Math.abs(Math.sin(limbSwingIn * 0.6662F + (float) Math.PI)));
		float f7 = (float) (limbSwingAmountIn * 0.4F * Math.abs(Math.sin(limbSwingIn * 0.6662F + ((float) Math.PI * 0.5F))));
		float f8 = (float) (limbSwingAmountIn * 0.4F * Math.abs(Math.sin(limbSwingIn * 0.6662F + ((float) Math.PI * 1.5F))));
		
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
		boolean clawsClicking = ((Scorpion) entityIn).clawCounter != 0;
		
		this.clawLeft.xRot = -(float) Math.PI/2;
		this.clawRight.xRot = -(float) Math.PI/2;
		
		this.armLeft.yRot = (float) Math.PI / 4F;
		this.armRight.yRot = -(float) Math.PI / 4F;
		this.clawLeft.yRot = (float) Math.PI / 4F;
		this.clawRight.yRot = -(float) Math.PI / 4F;
		
		this.tail1.xRot = (float) Math.PI / 4;
		this.tail2.xRot = (float) Math.PI / 4;
		this.tail3.xRot = (float) Math.PI / 4;
		this.tail4.xRot = (float) Math.PI / 4;
		this.tail5.xRot = (float) Math.PI / 4;
		
		float f9 = (float) (limbSwingAmount * 0.03F * Math.cos(limbSwing));
		float f10 = ((Scorpion) entityIn).oAttackAnim;
		float f11 = ((Scorpion) entityIn).attackAnim;
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
		
		if (clawsClicking || ((Scorpion) entityIn).isAggressive()) {
			this.pincherLeftOuter.yRot = (float) (0.25F * Math.cos((float) (entityIn.tickCount + partialTick) / 2) * Math.cos((float) (entityIn.tickCount + partialTick) / 2));
			this.pincherRightOuter.yRot = (float) (-0.25F * Math.cos((float) (entityIn.tickCount + partialTick) / 2) * Math.cos((float) (entityIn.tickCount + partialTick) / 2));
		} else {
			this.pincherLeftOuter.yRot = 0.0F;
			this.pincherRightOuter.yRot = 0.0F;
		}
		
		if (((Scorpion) entityIn).isAggressive()) {
			this.armLeft.yRot += 0.25F * Math.cos((float) (entityIn.tickCount + partialTick) / 2);
			this.clawLeft.yRot += 0.25F * Math.cos((float) (entityIn.tickCount + partialTick - Math.PI) / 2);
			this.armRight.yRot -= 0.25F * Math.cos((float) (entityIn.tickCount + partialTick + Math.PI) / 2);
			this.clawRight.yRot -= 0.25F * Math.cos((float) (entityIn.tickCount + partialTick) / 2);
		}
	}
}