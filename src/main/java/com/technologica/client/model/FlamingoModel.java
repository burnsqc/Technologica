package com.technologica.client.model;

import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.animal.Animal;

public class FlamingoModel<T extends Animal> extends AgeableListModel<T> {
	/*
	private final ModelPart head;
	private final ModelPart neck1;
	private final ModelPart neck2;
	private final ModelPart neck3;
	private final ModelPart neck4;
	private final ModelPart neck5;
	private final ModelPart body;
	private final ModelPart rightLeg;
	private final ModelPart leftLeg;
	private final ModelPart rightLegLower;
	private final ModelPart leftLegLower;
	private final ModelPart rightWing;
	private final ModelPart leftWing;
	private final ModelPart bill;
	*/

	public FlamingoModel() {
		/*
		texWidth = 64;
		texHeight = 32;
		
		this.neck1 = new ModelPart(this, 14, 23);
		this.neck1.addBox(-1.0F, -2.0F, -4.0F, 2.0F, 2.0F, 4.0F);
		this.neck1.setPos(0.0F, 12.0F, -4.0F);
		
		this.neck2 = new ModelPart(this, 14, 23);
		this.neck2.addBox(-1.0F, -2.0F, -4.0F, 2.0F, 2.0F, 4.0F);
		this.neck2.setPos(0.0F, 0.0F, -4.0F);
		this.neck1.addChild(this.neck2);
		
		this.neck3 = new ModelPart(this, 14, 23);
		this.neck3.addBox(-1.0F, -2.0F, -4.0F, 2.0F, 2.0F, 4.0F);
		this.neck3.setPos(0.0F, 0.0F, -4.0F);
		this.neck2.addChild(this.neck3);
		
		this.neck4 = new ModelPart(this, 14, 23);
		this.neck4.addBox(-1.0F, 0.0F, -4.0F, 2.0F, 2.0F, 4.0F);
		this.neck4.setPos(0.0F, -2.0F, -4.0F);
		this.neck3.addChild(this.neck4);
		
		this.neck5 = new ModelPart(this, 14, 23);
		this.neck5.addBox(-1.0F, 0.0F, -4.0F, 2.0F, 2.0F, 4.0F);
		this.neck5.setPos(0.0F, 0.0F, -4.0F);
		this.neck4.addChild(this.neck5);
		
		this.head = new ModelPart(this, 20, 0);
		this.head.addBox(-1.5F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F);
		this.head.setPos(0.0F, 0.0F, -4.0F);
		this.neck5.addChild(this.head);
		
		this.bill = new ModelPart(this, 0, 14);
		this.bill.addBox(-1.0F, 1.0F, -6.0F, 2.0F, 2.0F, 3.0F);
		this.head.addChild(this.bill);
		
		this.body = new ModelPart(this, 0, 0);
		this.body.addBox(-3.0F, -3.0F, -4.0F, 6.0F, 6.0F, 8.0F);
		this.body.setPos(0.0F, 9.0F, 0.0F);
		
		this.rightLeg = new ModelPart(this, 10, 14);
		this.rightLeg.addBox(-1.0F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F);
		this.rightLeg.setPos(-2.0F, 12.0F, 0.0F);
		
		this.leftLeg = new ModelPart(this, 10, 14);
		this.leftLeg.addBox(-1.0F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F);
		this.leftLeg.setPos(1.0F, 12.0F, 0.0F);
		
		this.rightLegLower = new ModelPart(this, 22, 14);
		this.rightLegLower.addBox(-1.0F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F);
		this.rightLegLower.setPos(0.0F, 6.0F, 0.0F);
		this.rightLeg.addChild(this.rightLegLower);
		
		this.leftLegLower = new ModelPart(this, 22, 14);
		this.leftLegLower.addBox(-1.0F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F);
		this.leftLegLower.setPos(0.0F, 6.0F, 0.0F);
		this.leftLeg.addChild(this.leftLegLower);
		
		this.rightWing = new ModelPart(this, 0, 19);
		this.rightWing.addBox(0.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F);
		this.rightWing.setPos(-4.0F, 7.0F, 0.0F);
		this.rightWing.mirror = true;
		
		this.leftWing = new ModelPart(this, 0, 19);
		this.leftWing.addBox(-1.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F);
		this.leftWing.setPos(4.0F, 7.0F, 0.0F);
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
	protected Iterable<ModelPart> headParts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Iterable<ModelPart> bodyParts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setupAnim(T p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_,
			float p_102623_) {
		// TODO Auto-generated method stub
		
	}

	/*
	@Override
	protected Iterable<ModelPart> headParts() {
		return ImmutableList.of(this.neck1);
	}

	@Override
	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(this.body, this.rightLeg, this.leftLeg, this.rightWing, this.leftWing);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.neck1.xRot = -(float)Math.PI/4;
		this.neck2.xRot = -(float)Math.PI/4;
		this.neck3.xRot = -(float)Math.PI/4;
		this.neck4.xRot = (float)Math.PI/4;
		this.neck5.xRot = (float)Math.PI/4;
		this.head.xRot = (float)Math.PI/4;
	}
	*/

}
