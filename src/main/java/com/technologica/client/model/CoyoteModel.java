package com.technologica.client.model;

import com.google.common.collect.ImmutableList;
import com.technologica.world.entity.animal.Coyote;

import net.minecraft.client.model.ColorableAgeableListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class CoyoteModel<T extends Coyote> extends ColorableAgeableListModel<T> {
    private final ModelPart head;
    private final ModelPart realHead;
    private final ModelPart body;
    private final ModelPart rightHindLeg;
    private final ModelPart leftHindLeg;
    private final ModelPart rightFrontLeg;
    private final ModelPart leftFrontLeg;
    private final ModelPart tail;
    private final ModelPart realTail;

    public CoyoteModel(ModelPart modelPartIn) {
	this.head = modelPartIn.getChild("head");
	this.realHead = this.head.getChild("real_head");
	this.body = modelPartIn.getChild("body");
	this.rightHindLeg = modelPartIn.getChild("right_hind_leg");
	this.leftHindLeg = modelPartIn.getChild("left_hind_leg");
	this.rightFrontLeg = modelPartIn.getChild("right_front_leg");
	this.leftFrontLeg = modelPartIn.getChild("left_front_leg");
	this.tail = modelPartIn.getChild("tail");
	this.realTail = this.tail.getChild("real_tail");
    }

    public static LayerDefinition createBodyLayer() {
	MeshDefinition meshdefinition = new MeshDefinition();
	PartDefinition partdefinition = meshdefinition.getRoot();
	PartDefinition partdefinition1 = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 14.0F, -5.0F));
	partdefinition1.addOrReplaceChild("real_head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -4.0F, -5.0F, 5.0F, 5.0F, 5.0F).texOffs(16, 14).addBox(-3.5F, -5.0F, -2.0F, 2.0F, 2.0F, 1.0F).texOffs(16, 14).addBox(1.5F, -5.0F, -2.0F, 2.0F, 2.0F, 1.0F).texOffs(0, 10).addBox(-1.0F, -2.0F, -8.0F, 2.0F, 3.0F, 4.0F), PartPose.ZERO);
	partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(18, 11).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 15.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 14.0F, 2.0F, ((float) Math.PI / 2F), 0.0F, 0.0F));
	CubeListBuilder cubelistbuilder = CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F);
	partdefinition.addOrReplaceChild("right_hind_leg", cubelistbuilder, PartPose.offset(-2.5F, 16.0F, 7.0F));
	partdefinition.addOrReplaceChild("left_hind_leg", cubelistbuilder, PartPose.offset(0.5F, 16.0F, 7.0F));
	partdefinition.addOrReplaceChild("right_front_leg", cubelistbuilder, PartPose.offset(-2.5F, 16.0F, -4.0F));
	partdefinition.addOrReplaceChild("left_front_leg", cubelistbuilder, PartPose.offset(0.5F, 16.0F, -4.0F));
	PartDefinition partdefinition2 = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 12.0F, 8.0F, ((float) Math.PI / 5F), 0.0F, 0.0F));
	partdefinition2.addOrReplaceChild("real_tail", CubeListBuilder.create().texOffs(9, 18).addBox(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F), PartPose.ZERO);
	return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    protected Iterable<ModelPart> headParts() {
	return ImmutableList.of(this.head);
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
	return ImmutableList.of(this.body, this.rightHindLeg, this.leftHindLeg, this.rightFrontLeg, this.leftFrontLeg, this.tail);
    }

    @Override
    public void prepareMobModel(T entityIn, float limbSwing, float limbSwingAmount, float p_104135_) {
	if (entityIn.isAngry()) {
	    this.tail.yRot = 0.0F;
	} else {
	    this.tail.yRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}

	if (entityIn.isInSittingPose()) {
	    this.body.setPos(0.0F, 18.0F, 0.0F);
	    this.body.xRot = ((float) Math.PI / 4F);
	    this.tail.setPos(-1.0F, 21.0F, 6.0F);
	    this.rightHindLeg.setPos(-2.5F, 22.7F, 2.0F);
	    this.rightHindLeg.xRot = ((float) Math.PI * 1.5F);
	    this.leftHindLeg.setPos(0.5F, 22.7F, 2.0F);
	    this.leftHindLeg.xRot = ((float) Math.PI * 1.5F);
	    this.rightFrontLeg.xRot = 5.811947F;
	    this.rightFrontLeg.setPos(-2.49F, 17.0F, -4.0F);
	    this.leftFrontLeg.xRot = 5.811947F;
	    this.leftFrontLeg.setPos(0.51F, 17.0F, -4.0F);
	} else {
	    this.body.setPos(0.0F, 14.0F, 2.0F);
	    this.body.xRot = ((float) Math.PI / 2F);
	    this.tail.setPos(-1.0F, 12.0F, 8.0F);
	    this.rightHindLeg.setPos(-2.5F, 16.0F, 7.0F);
	    this.leftHindLeg.setPos(0.5F, 16.0F, 7.0F);
	    this.rightFrontLeg.setPos(-2.5F, 16.0F, -4.0F);
	    this.leftFrontLeg.setPos(0.5F, 16.0F, -4.0F);
	    this.rightHindLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	    this.leftHindLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
	    this.rightFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
	    this.leftFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}

	this.realHead.zRot = entityIn.getHeadRollAngle(p_104135_) + entityIn.getBodyRollAngle(p_104135_, 0.0F);
	this.body.zRot = entityIn.getBodyRollAngle(p_104135_, -0.16F);
	this.realTail.zRot = entityIn.getBodyRollAngle(p_104135_, -0.2F);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	this.head.xRot = headPitch * ((float) Math.PI / 180F);
	this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
	this.tail.xRot = ageInTicks;
    }
}