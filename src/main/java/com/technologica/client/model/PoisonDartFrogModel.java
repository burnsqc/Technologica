package com.technologica.client.model;

import com.technologica.world.entity.animal.PoisonDartFrog;

import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class PoisonDartFrogModel<T extends PoisonDartFrog> extends QuadrupedModel<T> {
	//private final ModelPart eyeLeft;
	//private final ModelPart eyeRight;
	
	
	public PoisonDartFrogModel(ModelPart modelPartIn) {
		super(modelPartIn, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		/*
		this.texWidth = 32;
		this.texHeight = 16;
		
		this.body = new ModelPart(this, 0, 0);
		this.body.addBox(-2.0F, -1.0F, -2.0F, 4.0F, 3.0F, 4.0F);
		this.body.setPos(0.0F, 21.0F, 0.0F);
		
		this.head = new ModelPart(this, 0, 7);
		this.head.addBox(-1.5F, -1.0F, -3.0F, 3.0F, 2.0F, 3.0F);
		this.head.setPos(0.0F, 20.0F, -1.0F);
		
		this.eyeLeft = new ModelPart(this, 0, 12);
		this.eyeLeft.addBox(-1.5F, -2.0F, -2.0F, 1.0F, 1.0F, 2.0F);
		this.head.addChild(this.eyeLeft);
		
		this.eyeRight = new ModelPart(this, 6, 12);
		this.eyeRight.addBox(0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 2.0F);
		this.head.addChild(this.eyeRight);
		
		this.leg1 = new ModelPart(this, 16, 0);
	    this.leg1.addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F);
	    this.leg1.setPos(1.0F, 21.0F, 0.0F);
		
		this.leg0 = new ModelPart(this, 16, 5);
	    this.leg0.addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F);
	    this.leg0.setPos(-3.0F, 21.0F, 0.0F);
	   
	    this.leg3 = new ModelPart(this, 16, 0);
	    this.leg3.addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F);
	    this.leg3.setPos(1.0F, 21.0F, -4.0F);
	    
	    this.leg2 = new ModelPart(this, 16, 5);
	    this.leg2.addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F);
	    this.leg2.setPos(-3.0F, 21.0F, -4.0F);
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
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.xRot = -((float) Math.PI / 8F);
	}
}
