package com.technologica.client.model;

import com.google.common.collect.ImmutableList;

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

public class PenguinModel<T extends Animal> extends AgeableListModel<T> {
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;
    private final ModelPart rightWing;
    private final ModelPart leftWing;
    

    public PenguinModel(ModelPart modelPartIn) {
	this.head = modelPartIn.getChild("head");
	this.body = modelPartIn.getChild("body");
	this.rightLeg = modelPartIn.getChild("rightLeg");
	this.leftLeg = modelPartIn.getChild("leftLeg");
	this.rightWing = modelPartIn.getChild("rightWing");
	this.leftWing = modelPartIn.getChild("leftWing");
    }

    public static LayerDefinition createBodyLayer() {
	MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
	PartDefinition partdefinition = meshdefinition.getRoot();
	PartDefinition partdefinition1 = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -12.0F, 2.0F, 4.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 15.0F, -4.0F));
	partdefinition1.addOrReplaceChild("real_head", CubeListBuilder.create().texOffs(0, 8).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 1.0F, 2.0F), PartPose.ZERO);
	partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(8, 9).addBox(-3.0F, -9.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
	partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, 2.0F, -3.0F, 3.0F, 3.0F, 3.0F), PartPose.offset(-2.0F, 19.0F, 1.0F));
	partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, 2.0F, -3.0F, 3.0F, 3.0F, 3.0F), PartPose.offset(1.0F, 19.0F, 1.0F));
	partdefinition.addOrReplaceChild("rightWing", CubeListBuilder.create().texOffs(0, 12).addBox(0.0F, -4.0F, -1.0F, 1.0F, 8.0F, 3.0F), PartPose.offset(-4.0F, 13.0F, 0.0F));
	partdefinition.addOrReplaceChild("leftWing", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 8.0F, 3.0F), PartPose.offset(4.0F, 13.0F, 0.0F));
	return LayerDefinition.create(meshdefinition, 32, 32);
    }
    
    @Override
    protected Iterable<ModelPart> headParts() {
	return ImmutableList.of(this.head);
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
	return ImmutableList.of(this.body, this.rightLeg, this.leftLeg, this.rightWing, this.leftWing);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
}