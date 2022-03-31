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

public class WalrusModel<T extends Entity> extends ListModel<T> {
	/*
	private final ModelPart body;
	private final ModelPart tail;
	private final ModelPart tail2;
	
	private final ModelPart head;
	private final ModelPart nose;
	private final ModelPart tuskLeft;
	private final ModelPart tuskRight;
	
	private final ModelPart flipperFrontLeft;
	private final ModelPart flipperFrontRight;
	
	private final ModelPart flipperBackLeft;
	private final ModelPart flipperBackRight;
	*/

	public WalrusModel() {
		/*
		this.texWidth = 128;
		this.texHeight = 64;

		this.body = new ModelPart(this, 0, 0);
		this.body.addBox(-10.0F, -10.0F, -8.0F, 20.0F, 20.0F, 16.0F);
		this.body.setPos(0.0F, 14.0F, -8.0F);

		this.tail = new ModelPart(this, 56, 20);
		this.tail.addBox(-8.0F, -8.0F, 0.0F, 16.0F, 16.0F, 16.0F);
		this.tail.setPos(0.0F, 2.0F, 8.0F);
		this.body.addChild(this.tail);
		
		this.tail2 = new ModelPart(this, 56, 0);
		this.tail2.addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 8.0F);
		this.tail2.setPos(0.0F, 4.0F, 16.0F);
		this.tail.addChild(this.tail2);
		
		this.head = new ModelPart(this, 88, 0);
		this.head.addBox(-5.0F, -3.0F, -3.0F, 10.0F, 10.0F, 10.0F);
		this.head.setPos(0.0F, -10.0F, -8.0F);
		this.body.addChild(this.head);
		
		this.nose = new ModelPart(this, 104, 20);
		this.nose.addBox(-4.0F, 2.0F, -5.0F, 8.0F, 4.0F, 2.0F);
		this.head.addChild(this.nose);
		
		this.tuskLeft = new ModelPart(this, 0, 0);
		this.tuskLeft.addBox(-3.0F, 6.0F, -4.0F, 1.0F, 6.0F, 1.0F);
		this.head.addChild(this.tuskLeft);
		
		this.tuskRight = new ModelPart(this, 0, 0);
		this.tuskRight.addBox(2.0F, 6.0F, -4.0F, 1.0F, 6.0F, 1.0F);
		this.head.addChild(this.tuskRight);

		this.flipperFrontLeft = new ModelPart(this, 104, 26);
		this.flipperFrontLeft.mirror = true;
		this.flipperFrontLeft.addBox(0.0F, -1.0F, -5.0F, 7.0F, 2.0F, 5.0F);
		this.flipperFrontLeft.setPos(10.0F, 9.0F, -2.0F);
		this.body.addChild(this.flipperFrontLeft);

		this.flipperFrontRight = new ModelPart(this, 104, 26);
		this.flipperFrontRight.addBox(-7.0F, -1.0F, -5.0F, 7.0F, 2.0F, 5.0F);
		this.flipperFrontRight.setPos(-10.0F, 9.0F, -2.0F);
		this.body.addChild(this.flipperFrontRight);

		this.flipperBackLeft = new ModelPart(this, 104, 26);
		this.flipperBackLeft.addBox(0.0F, -1.0F, 0.0F, 7.0F, 2.0F, 5.0F);
		this.flipperBackLeft.setPos(4.0F, 3.0F, 3.0F);
		this.tail2.addChild(this.flipperBackLeft);

		this.flipperBackRight = new ModelPart(this, 104, 26);
		this.flipperBackRight.addBox(-7.0F, -1.0F, 0.0F, 7.0F, 2.0F, 5.0F);
		this.flipperBackRight.setPos(-4.0F, 3.0F, 3.0F);
		this.tail2.addChild(this.flipperBackRight);
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
	}
	*/
}
