package com.technologica.client.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.ColorableHierarchicalModel;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class PiranhaModel<T extends Entity> extends ColorableHierarchicalModel<T> {
	/*
	private final ModelPart body;
	private final ModelPart tail;
	private final ModelPart finLeft;
	private final ModelPart finRight;
	private final ModelPart finTop;
	private final ModelPart finBottom;
	*/

	public PiranhaModel() {
		/*
		this.texWidth = 16;
		this.texHeight = 16;
		
		this.body = new ModelPart(this, 0, 0);
		this.body.addBox(-1.0F, -3.0F, -3.0F, 2.0F, 6.0F, 6.0F);
		this.body.setPos(0.0F, 21.0F, 6.0F);
		
		this.tail = new ModelPart(this, 10, -2);
		this.tail.addBox(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 2.0F);
		this.tail.setPos(0.0F, 21.0F, 9.0F);
		
		this.finLeft = new ModelPart(this, 0, 0);
		this.finLeft.addBox(0.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F);
		this.finLeft.setPos(1.0F, 22.0F, 5.0F);
		
		this.finRight = new ModelPart(this, 0, 0);
		this.finRight.addBox(-2.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F);
		this.finRight.setPos(-1.0F, 22.0F, 5.0F);
		
		this.finTop = new ModelPart(this, 0, -1);
		this.finTop.addBox(0.0F, -4.0F, -2.0F, 0.0F, 1.0F, 2.0F);
		this.finTop.setPos(0.0F, 21.0F, 6.0F);
		
		this.finBottom = new ModelPart(this, 0, 0);
		this.finBottom.addBox(0.0F, 3.0F, -1.0F, 0.0F, 1.0F, 2.0F);
		this.finBottom.setPos(0.0F, 21.0F, 6.0F);
		*/
	}
	
	/*
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.body, this.tail, this.finRight, this.finLeft, this.finTop, this.finBottom);
	}

	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.xRot = (float) Math.PI / 4;
		this.finLeft.yRot = -(float) Math.PI / 4;
		this.finRight.yRot = (float) Math.PI / 4;
		this.finTop.xRot = -(float) Math.PI / 4;
		this.finBottom.xRot = (float) Math.PI / 4;
		this.tail.yRot = entityIn.isInWater()? 0.45F * Mth.sin(0.6F * ageInTicks) : 0.675F * Mth.sin(0.6F * ageInTicks);
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
	public ModelPart root() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setupAnim(T p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_,
			float p_102623_) {
		// TODO Auto-generated method stub
		
	}
}