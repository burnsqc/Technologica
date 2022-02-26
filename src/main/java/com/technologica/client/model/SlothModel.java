package com.technologica.client.model;

import com.technologica.world.entity.animal.SlothEntity;

import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class SlothModel<T extends SlothEntity> extends QuadrupedModel<T> {
	/*
	private final ModelPart legBackRightLower;
	private final ModelPart legBackLeftLower;
	private final ModelPart legFrontRightLower;
	private final ModelPart legFrontLeftLower;
	private final ModelPart clawInnerBackRight;
	private final ModelPart clawInnerBackLeft;
	private final ModelPart clawInnerFrontRight;
	private final ModelPart clawInnerFrontLeft;
	private final ModelPart clawOuterBackRight;
	private final ModelPart clawOuterBackLeft;
	private final ModelPart clawOuterFrontRight;
	private final ModelPart clawOuterFrontLeft;
	*/
		
	public SlothModel(ModelPart modelPartIn) {
		super(modelPartIn, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		/*
		this.texWidth = 32;
		this.texHeight = 32;
		
		this.head = new ModelPart(this, 0, 16);
		this.head.addBox(-2.0F, -4.0F, -4.0F, 4.0F, 4.0F, 4.0F);
		this.head.setPos(0.0F, 18.0F, -5.0F);
		
		this.body = new ModelPart(this, 0, 0);
		this.body.addBox(-3.0F, -3.0F, -5.0F, 6.0F, 6.0F, 10.0F);
		this.body.setPos(0.0F, 17.0F, 0.0F);

		this.leg0 = new ModelPart(this, 0, 0);
		this.leg0.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F);
		this.leg0.setPos(-2.0F, 20.0F, 3.0F);

		this.leg1 = new ModelPart(this, 0, 0);
		this.leg1.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F);
		this.leg1.setPos(2.0F, 20.0F, 3.0F);

		this.leg2 = new ModelPart(this, 0, 0);
		this.leg2.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F);
		this.leg2.setPos(-2.0F, 20.0F, -3.0F);

		this.leg3 = new ModelPart(this, 0, 0);
		this.leg3.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F);
		this.leg3.setPos(2.0F, 20.0F, -3.0F);
		
		this.legBackRightLower = new ModelPart(this, 22, 0);
		this.legBackRightLower.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F);
		this.legBackRightLower.setPos(0.0F, 6.0F, 0.0F);
		this.leg0.addChild(this.legBackRightLower);

		this.legBackLeftLower = new ModelPart(this, 22, 0);
		this.legBackLeftLower.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F);
		this.legBackLeftLower.setPos(0.0F, 6.0F, 0.0F);
		this.leg1.addChild(this.legBackLeftLower);

		this.legFrontRightLower = new ModelPart(this, 22, 0);
		this.legFrontRightLower.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 4.0F, 2.0F);
		this.legFrontRightLower.setPos(0.0F, 6.0F, 0.0F);
		this.leg2.addChild(this.legFrontRightLower);

		this.legFrontLeftLower = new ModelPart(this, 22, 0);
		this.legFrontLeftLower.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 4.0F, 2.0F);
		this.legFrontLeftLower.setPos(0.0F, 6.0F, 0.0F);
		this.leg3.addChild(this.legFrontLeftLower);
		
		this.clawInnerBackRight = new ModelPart(this, 0, 16);
		this.clawInnerBackRight.addBox(0.0F, 4.0F, 0.0F, 1.0F, 3.0F, 1.0F);
		this.legBackRightLower.addChild(this.clawInnerBackRight);
		
		this.clawInnerBackLeft = new ModelPart(this, 0, 16);
		this.clawInnerBackLeft.addBox(-1.0F, 4.0F, 0.0F, 1.0F, 3.0F, 1.0F);
		this.legBackLeftLower.addChild(this.clawInnerBackLeft);
		
		this.clawInnerFrontRight = new ModelPart(this, 0, 16);
		this.clawInnerFrontRight.addBox(0.0F, 4.0F, -1.0F, 1.0F, 3.0F, 1.0F);
		this.legFrontRightLower.addChild(this.clawInnerFrontRight);
		
		this.clawInnerFrontLeft = new ModelPart(this, 0, 16);
		this.clawInnerFrontLeft.addBox(-1.0F, 4.0F, -1.0F, 1.0F, 3.0F, 1.0F);
		this.legFrontLeftLower.addChild(this.clawInnerFrontLeft);
		
		this.clawOuterBackRight = new ModelPart(this, 0, 16);
		this.clawOuterBackRight.addBox(-1.0F, 4.0F, 0.0F, 1.0F, 3.0F, 1.0F);
		this.legBackRightLower.addChild(this.clawOuterBackRight);
		
		this.clawOuterBackLeft = new ModelPart(this, 0, 16);
		this.clawOuterBackLeft.addBox(0.0F, 4.0F, 0.0F, 1.0F, 3.0F, 1.0F);
		this.legBackLeftLower.addChild(this.clawOuterBackLeft);
		
		this.clawOuterFrontRight = new ModelPart(this, 0, 16);
		this.clawOuterFrontRight.addBox(-1.0F, 4.0F, -1.0F, 1.0F, 3.0F, 1.0F);
		this.legFrontRightLower.addChild(this.clawOuterFrontRight);
		
		this.clawOuterFrontLeft = new ModelPart(this, 0, 16);
		this.clawOuterFrontLeft.addBox(0.0F, 4.0F, -1.0F, 1.0F, 3.0F, 1.0F);
		this.legFrontLeftLower.addChild(this.clawOuterFrontLeft);
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
	
	/*
	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.xRot = headPitch * ((float) Math.PI / 180F) * 0.5F;
		this.head.yRot = netHeadYaw * ((float) Math.PI / 180F) * 0.5F;

		this.leg0.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg1.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg2.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg3.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		
		this.leg0.xRot = (float) Math.PI/4;
		this.leg1.xRot = (float) Math.PI/4;
		this.leg2.xRot = -(float) Math.PI/4;
		this.leg3.xRot = -(float) Math.PI/4;
		
		this.legBackRightLower.xRot = (float) Math.PI/4;
		this.legBackLeftLower.xRot = (float) Math.PI/4;
		this.legFrontRightLower.xRot = -(float) Math.PI/4;
		this.legFrontLeftLower.xRot = -(float) Math.PI/4;
		
		this.clawInnerFrontLeft.xRot = 0;
	}
	*/
}