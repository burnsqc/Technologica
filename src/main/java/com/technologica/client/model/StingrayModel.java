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

public class StingrayModel<T extends Entity> extends ListModel<T> {
	/*
	private final ModelPart body;
	private final ModelPart bodyLeft1;
	private final ModelPart bodyLeft2;
	private final ModelPart bodyLeft3;
	private final ModelPart bodyLeft4;
	private final ModelPart bodyRight1;
	private final ModelPart bodyRight2;
	private final ModelPart bodyRight3;
	private final ModelPart bodyRight4;
	private final ModelPart head;
	private final ModelPart tail1;
	private final ModelPart tail2;
	private final ModelPart tail3;
	*/

	public StingrayModel() {
		/*
		this.texWidth = 64;
		this.texHeight = 32;

		this.body = new ModelPart(this, 0, 0);
		this.body.addBox(-3.0F, 0.0F, -8.0F, 6.0F, 1.0F, 16.0F);
		this.body.setPos(0.0F, 23.0F, 0.0F);
		
		this.bodyLeft1 = new ModelPart(this, 0, 17);
		this.bodyLeft1.addBox(0.0F, -1.0F, -7.0F, 2.0F, 1.0F, 14.0F, true);
		this.bodyLeft1.setPos(3.0F, 1.0F, 0.0F);
		this.body.addChild(this.bodyLeft1);
		
		this.bodyLeft2 = new ModelPart(this, 18, 17);
		this.bodyLeft2.addBox(0.0F, -1.0F, -6.0F, 1.0F, 1.0F, 12.0F);
		this.bodyLeft2.setPos(2.0F, 0.0F, 0.0F);
		this.bodyLeft1.addChild(this.bodyLeft2);
		
		this.bodyLeft3 = new ModelPart(this, 32, 17);
		this.bodyLeft3.addBox(0.0F, -1.0F, -5.0F, 1.0F, 1.0F, 10.0F);
		this.bodyLeft3.setPos(1.0F, 0.0F, 0.0F);
		this.bodyLeft2.addChild(this.bodyLeft3);
		
		this.bodyLeft4 = new ModelPart(this, 44, 17);
		this.bodyLeft4.addBox(0.0F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F);
		this.bodyLeft4.setPos(1.0F, 0.0F, 0.0F);
		this.bodyLeft3.addChild(this.bodyLeft4);
		
		this.bodyRight1 = new ModelPart(this, 0, 17);
		this.bodyRight1.addBox(-2.0F, -1.0F, -7.0F, 2.0F, 1.0F, 14.0F);
		this.bodyRight1.setPos(-3.0F, 1.0F, 0.0F);
		this.body.addChild(this.bodyRight1);
		
		this.bodyRight2 = new ModelPart(this, 18, 17);
		this.bodyRight2.addBox(-1.0F, -1.0F, -6.0F, 1.0F, 1.0F, 12.0F);
		this.bodyRight2.setPos(-2.0F, 0.0F, 0.0F);
		this.bodyRight1.addChild(this.bodyRight2);
		
		this.bodyRight3 = new ModelPart(this, 32, 17);
		this.bodyRight3.addBox(-1.0F, -1.0F, -5.0F, 1.0F, 1.0F, 10.0F);
		this.bodyRight3.setPos(-1.0F, 0.0F, 0.0F);
		this.bodyRight2.addChild(this.bodyRight3);
		
		this.bodyRight4 = new ModelPart(this, 44, 17);
		this.bodyRight4.addBox(-1.0F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F);
		this.bodyRight4.setPos(-1.0F, 0.0F, 0.0F);
		this.bodyRight3.addChild(this.bodyRight4);

		this.head = new ModelPart(this, 28, 0);
		this.head.addBox(-3.0F, -1.0F, -4.0F, 6.0F, 1.0F, 12.0F);
		this.body.addChild(this.head);

		this.tail1 = new ModelPart(this, 0, 0);
		this.tail1.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F);
		this.tail1.setPos(0.0F, 0.0F, 8.0F);
		this.body.addChild(this.tail1);
		
		this.tail2 = new ModelPart(this, 0, 8);
		this.tail2.addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 6.0F);
		this.tail2.setPos(0.0F, 0.5F, 6.0F);
		this.tail1.addChild(this.tail2);
		
		this.tail3 = new ModelPart(this, 0, 17);
		this.tail3.addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 6.0F);
		this.tail3.setPos(0.0F, 0.0F, 6.0F);
		this.tail2.addChild(this.tail3);
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
		return ImmutableList.of(this.body);
	}

	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.xRot = headPitch * ((float) Math.PI / 180F);
		this.body.yRot = netHeadYaw * ((float) Math.PI / 180F);
		if (Entity.getHorizontalDistanceSqr(entityIn.getDeltaMovement()) > 1.0E-7D) {
			
			this.tail1.yRot = 0.2F * Mth.cos(ageInTicks * 0.3F);
			this.tail2.yRot = 0.2F * Mth.cos(ageInTicks * 0.3F);
			this.tail3.yRot = 0.2F * Mth.cos(ageInTicks * 0.3F);
		}
	}
	*/
}
