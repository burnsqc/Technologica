package com.technologica.client.model;

import com.technologica.world.entity.animal.ElephantEntity;

import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class ElephantModel<T extends ElephantEntity> extends QuadrupedModel<T> {

	/*
	private final ModelPart nose;
	protected ModelPart earLeft;
	protected ModelPart earRight;
	protected ModelPart tuskLeft;
	protected ModelPart tuskRight;
	protected ModelPart trunk1;
	protected ModelPart trunk2;
	protected ModelPart trunk3;
	protected ModelPart tail;
	*/
	
	public ElephantModel(ModelPart modelPartIn) {
		super(modelPartIn, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		
		/*
		this.texWidth = 256;
		this.texHeight = 128;

		this.head = new ModelPart(this, 135, 0);
		this.head.addBox(-12.0F, -12.0F, -24.0F, 24.0F, 24.0F, 24.0F);
		this.head.setPos(0.0F, -28.0F, -32.0F);
		
		this.nose = new ModelPart(this, 0, 104);
		this.nose.addBox(-6.0F, -6.0F, -30.0F, 12.0F, 18.0F, 6.0F);
		this.head.addChild(this.nose);
		
		this.earLeft = new ModelPart(this, 0, 0);
		this.earLeft.addBox(-1.0F, -10.0F, 0.0F, 1.0F, 24.0F, 24.0F);
		this.earLeft.setPos(12.0F, -2.0F, -10.0F);
		this.head.addChild(this.earLeft);
		
		this.earRight = new ModelPart(this, 0, 0);
		this.earRight.addBox(0.0F, -10.0F, 0.0F, 1.0F, 24.0F, 24.0F);
		this.earRight.setPos(-12.0F, -2.0F, -10.0F);
		this.head.addChild(this.earRight);
		
		this.tuskLeft = new ModelPart(this, 0, 0);
		this.tuskLeft.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 16.0F, 4.0F);
		this.tuskLeft.setPos(9.0F, 12.0F, -19.0F);
		this.head.addChild(this.tuskLeft);
		
		this.tuskRight = new ModelPart(this, 0, 0);
		this.tuskRight.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 16.0F, 4.0F);
		this.tuskRight.setPos(-9.0F, 12.0F, -19.0F);
		this.head.addChild(this.tuskRight);
		
		this.trunk1 = new ModelPart(this, 200, 48);
		this.trunk1.addBox(-4.0F, -8.0F, 0.0F, 8.0F, 20.0F, 8.0F);
		this.trunk1.setPos(0.0F, 12.0F, -30.0F);
		this.head.addChild(this.trunk1);
		
		this.trunk2 = new ModelPart(this, 208, 0);
		this.trunk2.addBox(-3.5F, 0.0F, 0.0F, 7.0F, 12.0F, 7.0F);
		this.trunk2.setPos(0.0F, 12.0F, 0.0F);
		this.trunk1.addChild(this.trunk2);
		
		this.trunk3 = new ModelPart(this, 136, 0);
		this.trunk3.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 12.0F, 6.0F);
		this.trunk3.setPos(0.0F, 12.0F, 0.0F);
		this.trunk2.addChild(this.trunk3);
		
		this.body = new ModelPart(this, 0, 0);
		this.body.addBox(-18.0F, -20.0F, -32.0F, 36.0F, 40.0F, 64.0F);
		this.body.setPos(0.0F, -20.0F, 0.0F);
		
		this.tail = new ModelPart(this, 236, 0);
		this.tail.addBox(-1.5F, 0.0F, -3.0F, 3.0F, 32.0F, 3.0F);
		this.tail.setPos(0.0F, -8.0F, 32.0F);
		this.body.addChild(this.tail);

		this.leg0 = new ModelPart(this, 188, 92);
		this.leg0.addBox(-6.0F, 0.0F, -6.0F, 12.0F, 24.0F, 12.0F);
		this.leg0.setPos(-12.0F, 0.0F, 26.0F);

		this.leg1 = new ModelPart(this, 188, 92);
	    this.leg1.addBox(-6.0F, 0.0F, -6.0F, 12.0F, 24.0F, 12.0F);
	    this.leg1.setPos(12.0F, 0.0F, 26.0F);
	      
	    this.leg2 = new ModelPart(this, 188, 92);
	    this.leg2.addBox(-6.0F, 0.0F, -6.0F, 12.0F, 24.0F, 12.0F);
	    this.leg2.setPos(-12.0F, 0.0F, -26.0F);
		
	    this.leg3 = new ModelPart(this, 188, 92);
	    this.leg3.addBox(-6.0F, 0.0F, -6.0F, 12.0F, 24.0F, 12.0F);
	    this.leg3.setPos(12.0F, 0.0F, -26.0F);
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
		this.tuskLeft.xRot = -(float) Math.PI / 10.0F;
		this.tuskRight.xRot = -(float) Math.PI / 10.0F;
		this.tail.xRot = (float) Math.PI / 10.0F;
		this.trunk1.xRot = 0;
		this.trunk2.xRot = 0;
		this.trunk3.xRot = 0;
		this.earLeft.yRot = (float) Math.PI / 5.0F;
		this.earRight.yRot = -(float) Math.PI / 5.0F;
	}
	*/
}
