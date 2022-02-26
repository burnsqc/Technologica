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
import net.minecraft.util.Mth;

public class NarwhalModel<T extends Entity> extends ListModel<T> {
	/*
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart spear;
	private final ModelPart flipperLeft;
	private final ModelPart flipperRight;
	private final ModelPart tail;
	private final ModelPart tailFin;
	*/

	public NarwhalModel() {
		/*
		this.texWidth = 64;
		this.texHeight = 64;

		this.body = new ModelPart(this, 0, 0);
		this.body.setPos(0.0F, 20.0F, 0.0F);
		this.body.addBox(-4.0F, -4.0F, -7.0F, 8.0F, 8.0F, 14.0F);
		
		this.head = new ModelPart(this, 30, 0);
		this.head.setPos(0.0F, 0.0F, -7.0F);
		this.head.addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 6.0F);
		this.body.addChild(this.head);
		
		this.spear = new ModelPart(this, 28, 12);
		this.spear.setPos(0.0F, -1.0F, -6.0F);
		this.spear.addBox(-0.5F, 0.0F, -16.0F, 1.0F, 1.0F, 16.0F);
		this.head.addChild(this.spear);

		this.flipperLeft = new ModelPart(this, 0, 22);
		this.flipperLeft.setPos(4.0F, 2.0F, -4.0F);
		this.flipperLeft.addBox(0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 4.0F);
		this.flipperLeft.mirror = true;
		this.body.addChild(this.flipperLeft);

		this.flipperRight = new ModelPart(this, 0, 22);
		this.flipperRight.setPos(-4.0F, 2.0F, -4.0F);
		this.flipperRight.addBox(-8.0F, 0.0F, 0.0F, 8.0F, 1.0F, 4.0F);
		this.body.addChild(this.flipperRight);

		this.tail = new ModelPart(this, 0, 27);
		this.tail.setPos(0.0F, 0.0F, 7.0F);
		this.tail.addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 10.0F);
		this.body.addChild(this.tail);

		this.tailFin = new ModelPart(this, 0, 43);
		this.tailFin.setPos(0.0F, 0.0F, 8.0F);
		this.tailFin.addBox(-8.0F, 0.0F, 0.0F, 	16.0F, 1.0F, 6.0F);
		this.flipperLeft.mirror = true;
		this.tail.addChild(this.tailFin);
		*/
	}
	/*
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.body);
	}

	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {	
		this.flipperLeft.yRot = -(float) Math.PI / 4;
		this.flipperLeft.zRot = (float) Math.PI / 8;
		
		this.flipperRight.yRot = (float) Math.PI / 4;
		this.flipperRight.zRot = -(float) Math.PI / 8;

		this.body.xRot = headPitch * ((float) Math.PI / 180F);
		this.body.yRot = netHeadYaw * ((float) Math.PI / 180F);
		if (Entity.getHorizontalDistanceSqr(entityIn.getDeltaMovement()) > 1.0E-7D) {
			this.body.xRot += -0.05F + -0.05F * Mth.cos(ageInTicks * 0.3F);
			this.tail.yRot = -0.1F * Mth.cos(ageInTicks * 0.3F);
			this.tailFin.yRot = -0.2F * Mth.cos(ageInTicks * 0.3F);
		}
	}
	*/

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
}
