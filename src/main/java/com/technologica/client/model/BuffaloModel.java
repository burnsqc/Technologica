package com.technologica.client.model;

import com.technologica.world.entity.animal.Buffalo;

import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class BuffaloModel<T extends Buffalo> extends QuadrupedModel<T> {

	protected ModelPart bodyMane;
	
	public BuffaloModel(ModelPart modelPartIn) {
		super(modelPartIn, false, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		/*
		this.texWidth = 128;
		this.texHeight = 64;
		
		this.head = new ModelPart(this, 12, 0);
		this.head.addBox(-5.0F, -3.0F, -6.0F, 10.0F, 12.0F, 8.0F);
		this.head.setPos(0.0F, 0.0F, -16.0F);
		this.head.texOffs(0, 0).addBox(-6.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F);
		this.head.texOffs(0, 0).addBox(5.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F);
		this.head.texOffs(0, 2).addBox(-7.0F, -4.0F, -3.0F, 1.0F, 3.0F, 1.0F);
		this.head.texOffs(0, 2).addBox(6.0F, -4.0F, -3.0F, 1.0F, 3.0F, 1.0F);
		
		this.body = new ModelPart(this, 0, 20);
		this.body.addBox(-6.0F, -10.0F, -14.0F, 12.0F, 16.0F, 28.0F);
		this.body.setPos(0.0F, 6.0F, -0.0F);
		
		this.bodyMane = new ModelPart(this, 52, 0);
		this.bodyMane.addBox(-7.0F, -12.0F, -12.0F, 14.0F, 20.0F, 12.0F);
		this.body.addChild(this.bodyMane);
		
		this.leg0 = new ModelPart(this, 0, 16);
	      this.leg0.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F);
	      this.leg0.setPos(-3.0F, 12.0F, 7.0F);
	      this.leg1 = new ModelPart(this, 0, 16);
	      this.leg1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F);
	      this.leg1.setPos(3.0F, 12.0F, 7.0F);
	      this.leg2 = new ModelPart(this, 0, 16);
	      this.leg2.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F);
	      this.leg2.setPos(-3.0F, 12.0F, -5.0F);
	      this.leg3 = new ModelPart(this, 0, 16);
	      this.leg3.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F);
	      this.leg3.setPos(3.0F, 12.0F, -5.0F);
		
		--this.leg0.x;
		++this.leg1.x;
		this.leg0.z = 12.0F;
		this.leg1.z = 12.0F;
		--this.leg2.x;
		++this.leg3.x;
		this.leg2.z = -8.0F;
		this.leg3.z = -8.0F;
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
	}
}
