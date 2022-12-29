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

public class WalrusModel<T extends Entity> extends ListModel<T> {
	private final ModelPart body;
	private final ModelPart neck;
	private final ModelPart head;
	private final ModelPart tail;
	private final ModelPart tail2;
	private final ModelPart tail3;
	private final ModelPart legLeft;
	private final ModelPart legRight;
	private final ModelPart flipperFrontLeft;
	private final ModelPart flipperFrontRight;
	private final ModelPart flipperBackLeft;
	private final ModelPart flipperBackRight;

	public WalrusModel(ModelPart modelPartIn) {
		this.body = modelPartIn.getChild("body");
		this.neck = body.getChild("neck");
		this.head = neck.getChild("head");
		this.tail = body.getChild("tail");
		this.tail2 = tail.getChild("tail2");
		this.tail3 = tail2.getChild("tail3");
		this.legLeft = body.getChild("leg_left");
		this.legRight = body.getChild("leg_right");
		this.flipperFrontLeft = legLeft.getChild("flipper_front_left");
		this.flipperFrontRight = legRight.getChild("flipper_front_right");
		this.flipperBackLeft = tail3.getChild("flipper_back_left");
		this.flipperBackRight = tail3.getChild("flipper_back_right");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition root = meshdefinition.getRoot();
		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -9.0F, -6.0F, 18.0F, 18.0F, 12.0F), PartPose.offset(0.0F, 15.0F, -8.0F));
		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 30).addBox(-8.0F, -8.0F, 0.0F, 16.0F, 16.0F, 12.0F), PartPose.offset(0.0F, 1.0F, 6.0F));
		PartDefinition tail2 = tail.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(60, 0).addBox(-6.0F, -6.0F, 0.0F, 12.0F, 12.0F, 12.0F), PartPose.offset(0.0F, 2.0F, 12.0F));
		PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(48, 0).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 6.0F), PartPose.offset(0.0F, 3.0F, 12.0F));
		PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(56, 24).addBox(-5.0F, -10.0F, -15.0F, 10.0F, 10.0F, 15.0F), PartPose.offset(0.0F, 5.0F, -6.0F));
		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(46, 49).addBox(-5.0F, 0.0F, -10.0F, 10.0F, 10.0F, 10.0F), PartPose.offset(0.0F, -10.0F, -15.0F));
		head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(0, 58).addBox(-4.0F, 5.0F, -12.0F, 8.0F, 4.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("tusk_left", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 9.0F, -11.0F, 1.0F, 6.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("tusk_right", CubeListBuilder.create().texOffs(0, 0).addBox(2.0F, 9.0F, -11.0F, 1.0F, 6.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition legLeft = body.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(20, 58).mirror().addBox(-3.0F, 0.0F, 0.0F, 5.0F, 6.0F, 5.0F), PartPose.offset(9.0F, 3.0F, -4.0F));
		PartDefinition legRight = body.addOrReplaceChild("leg_right", CubeListBuilder.create().texOffs(20, 58).mirror().addBox(-2.0F, 0.0F, 0.0F, 5.0F, 6.0F, 5.0F), PartPose.offset(-9.0F, 3.0F, -4.0F));
		legLeft.addOrReplaceChild("flipper_front_left", CubeListBuilder.create().texOffs(0, 69).mirror().addBox(0.0F, -2.0F, 0.0F, 8.0F, 2.0F, 5.0F), PartPose.offset(2.0F, 6.0F, 0.0F));
		legRight.addOrReplaceChild("flipper_front_right", CubeListBuilder.create().texOffs(0, 69).addBox(-8.0F, -2.0F, 0.0F, 8.0F, 2.0F, 5.0F), PartPose.offset(-2.0F, 6.0F, 0.0F));
		tail3.addOrReplaceChild("flipper_back_left", CubeListBuilder.create().texOffs(0, 76).mirror().addBox(-5.0F, -1.0F, -5.0F, 15.0F, 2.0F, 5.0F), PartPose.offset(0.0F, 2.0F, 6.0F));
		tail3.addOrReplaceChild("flipper_back_right", CubeListBuilder.create().texOffs(0, 76).addBox(-10.0F, -1.0F, -5.0F, 15.0F, 2.0F, 5.0F), PartPose.offset(0.0F, 2.0F, 6.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	
	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.body);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.neck.xRot = -(float) (Math.PI/3.0F);
		this.head.xRot = (float) (Math.PI/3.0F);
		this.flipperBackLeft.yRot = -(float) (Math.PI/4.0F);
		this.flipperBackRight.yRot = (float) (Math.PI/4.0F);
		this.flipperFrontLeft.yRot = -(float) (Math.PI/4.0F);
		this.flipperFrontRight.yRot = (float) (Math.PI/4.0F);
	}
}
