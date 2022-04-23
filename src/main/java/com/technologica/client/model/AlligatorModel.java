package com.technologica.client.model;

import com.technologica.world.entity.animal.Alligator;

import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class AlligatorModel<T extends Alligator> extends QuadrupedModel<T> {

    protected final ModelPart tail;
    protected final ModelPart tail2;
    protected final ModelPart tail3;
    protected final ModelPart nose;

    public AlligatorModel(ModelPart modelPartIn) {
	super(modelPartIn, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
	this.nose = modelPartIn.getChild("head").getChild("nose");
	this.tail = modelPartIn.getChild("body").getChild("tail");
	this.tail2 = modelPartIn.getChild("body").getChild("tail").getChild("tail2");
	this.tail3 = modelPartIn.getChild("body").getChild("tail").getChild("tail2").getChild("tail3");
    }

    public static LayerDefinition createBodyLayer() {
	MeshDefinition meshdefinition = new MeshDefinition();
	PartDefinition partdefinition = meshdefinition.getRoot();
	PartDefinition headDefinition = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 22).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 6.0F, 4.0F).texOffs(20, 32).addBox("jaw", -3.0F, 0.0F, -12.0F, 6.0F, 2.0F, 8.0F).texOffs(26, 45).addBox("lower_teeth", -2.5F, -1.0F, -11.5F, 5.0F, 1.0F, 8.0F), PartPose.offset(0.0F, 19.0F, -8.0F));
	headDefinition.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(0, 35).addBox(-3.0F, -2.0F, -8.0F, 6.0F, 2.0F, 8.0F).texOffs(0, 10).addBox("left_eye", 1.0F, -3.0F, -3.0F, 1.0F, 1.0F, 2.0F).texOffs(6, 10).addBox("right_eye", -2.0F, -3.0F, -3.0F, 1.0F, 1.0F, 2.0F).texOffs(0, 45).addBox("upper_teeth", -2.5F, 0.0F, -7.5F, 5.0F, 1.0F, 8.0F), PartPose.offset(0.0F, -1.0F, -4.0F));
	PartDefinition bodyDefinition = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -3.0F, -8.0F, 10.0F, 6.0F, 16.0F), PartPose.offset(0.0F, 19.0F, 0.0F));
	PartDefinition tailDefinition = bodyDefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(36, 0).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 8.0F), PartPose.offset(0.0F, 0.0F, 8.0F));
	PartDefinition tailDefinition2 = tailDefinition.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 5.0F, 8.0F), PartPose.offset(0.0F, 0.0F, 8.0F));
	tailDefinition2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(44, 14).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 4.0F, 8.0F), PartPose.offset(0.0F, 0.0F, 8.0F));
	partdefinition.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F), PartPose.offset(5.0F, 18.0F, 7.0F));
	partdefinition.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F), PartPose.offset(-5.0F, 18.0F, 7.0F));
	partdefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F), PartPose.offset(5.0F, 18.0F, -5.0F));
	partdefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F), PartPose.offset(-5.0F, 18.0F, -5.0F));
	return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	this.body.xRot = 0;
	this.nose.xRot = -(Mth.sin(ageInTicks / 10) * Mth.sin(ageInTicks / 10)) / 2;
    }
}
