package com.technologica.client.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.Animal;

public class TurkeyModel<T extends Animal> extends AgeableListModel<T> {
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;
    private final ModelPart rightWing;
    private final ModelPart leftWing;
    private final ModelPart tail;

    public TurkeyModel(ModelPart modelPartIn) {
	this.head = modelPartIn.getChild("head");
	this.body = modelPartIn.getChild("body");
	this.rightLeg = modelPartIn.getChild("rightLeg");
	this.leftLeg = modelPartIn.getChild("leftLeg");
	this.rightWing = modelPartIn.getChild("rightWing");
	this.leftWing = modelPartIn.getChild("leftWing");
	this.tail = modelPartIn.getChild("tail");
    }

    public static LayerDefinition createBodyLayer() {
	MeshDefinition meshdefinition = new MeshDefinition();
	PartDefinition partdefinition = meshdefinition.getRoot();
	PartDefinition partdefinition1 = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 11.0F, -1.0F));
	partdefinition1.addOrReplaceChild("real_head", CubeListBuilder.create().texOffs(12, 16).addBox(-2.0F, 0.0F, -6.0F, 4.0F, 2.0F, 2.0F).texOffs(0, 0).addBox(-1.0F, 2.0F, -4.0F, 2.0F, 3.0F, 1.0F), PartPose.ZERO);
	partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.offset(0.0F, 15.0F, 0.0F));
	partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(34, 13).addBox(-1.0F, 0.0F, -3.0F, 3.0F, 5.0F, 3.0F), PartPose.offset(-2.0F, 19.0F, 1.0F));
	partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(34, 13).addBox(-1.0F, 0.0F, -3.0F, 3.0F, 5.0F, 3.0F), PartPose.offset(1.0F, 19.0F, 1.0F));
	partdefinition.addOrReplaceChild("rightWing", CubeListBuilder.create().texOffs(24, 13).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 4.0F, 8.0F), PartPose.offset(-4.0F, 13.0F, -2.0F));
	partdefinition.addOrReplaceChild("leftWing", CubeListBuilder.create().texOffs(24, 13).addBox(0.0F, -2.0F, 0.0F, 1.0F, 4.0F, 8.0F), PartPose.offset(4.0F, 13.0F, -2.0F));
	partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(32, 0).addBox(0.0F, 0.0F, 0.0F, 12.0F, 12.0F, 1.0F), PartPose.offset(0.0F, 19.0F, 4.0F));
	return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    protected Iterable<ModelPart> headParts() {
	return ImmutableList.of(this.head);
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
	return ImmutableList.of(this.body, this.rightLeg, this.leftLeg, this.rightWing, this.leftWing, this.tail);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	this.rightWing.xRot = -(float) Math.PI / 4;
	this.leftWing.xRot = -(float) Math.PI / 4;
	this.tail.zRot = -3 * (float) Math.PI / 4;
	this.head.xRot = headPitch * ((float) Math.PI / 180F);
	this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
	this.rightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	this.leftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
	this.rightWing.zRot = ageInTicks;
	this.leftWing.zRot = -ageInTicks;
    }
}