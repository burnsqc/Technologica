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
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class VultureModel<T extends Entity> extends ListModel<T> {
	private final ModelPart body;
	private final ModelPart neck_lower;
	private final ModelPart neck;
	private final ModelPart head;
	private final ModelPart wing_inner_left;
	private final ModelPart wing_outer_left;
	private final ModelPart wing_inner_right;
	private final ModelPart wing_outer_right;
	private final ModelPart tail;

	public VultureModel(ModelPart modelPartIn) {
		this.body = modelPartIn.getChild("body");
		this.neck_lower = body.getChild("neck_lower");
		this.neck = neck_lower.getChild("neck");
		this.head = neck.getChild("head");
		this.wing_inner_left = body.getChild("wing_inner_left");
		this.wing_outer_left = wing_inner_left.getChild("wing_outer_left");
		this.wing_inner_right = body.getChild("wing_inner_right");
		this.wing_outer_right = wing_inner_right.getChild("wing_outer_right");
		this.tail = body.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition root = meshdefinition.getRoot();
		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.0F, -8.0F, 5.0F, 3.0F, 9.0F), PartPose.offset(0.0F, 20.0F, 0.0F));
		PartDefinition neck_lower = body.addOrReplaceChild("neck_lower", CubeListBuilder.create().texOffs(19, 0).addBox(-1.0F, 0.0F, -5.0F, 2.0F, 2.0F, 5.0F), PartPose.offset(0.0F, -2.0F, -8.0F));
		PartDefinition neck = neck_lower.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(33, 0).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 5.0F), PartPose.offset(0.0F, 2.0F, -5.0F));
		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(47, 0).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F), PartPose.offset(0.0F, -2.0F, -5.0F));
		head.addOrReplaceChild("beak", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 1.0F, -5.0F, 1.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 12).addBox(-8.0F, -0.99F, -8.0F, 16.0F, 1.98F, 16.0F), PartPose.offset(0.0F, -1.0F, 9.0F));
		body.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(0, 12).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F), PartPose.offset(-2.0F, 0.0F, -1.0F));
		body.addOrReplaceChild("leg_right", CubeListBuilder.create().texOffs(0, 12).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F), PartPose.offset(2.0F, 0.0F, -1.0F));
		PartDefinition wing_inner_left = body.addOrReplaceChild("wing_inner_left", CubeListBuilder.create().texOffs(0, 30).addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F), PartPose.offset(2.5F, -2.0F, -8.0F));
		PartDefinition wing_inner_right = body.addOrReplaceChild("wing_inner_right", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-6.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F), PartPose.offset(-2.5F, -2.0F, -8.0F));
		wing_inner_left.addOrReplaceChild("wing_outer_left", CubeListBuilder.create().texOffs(0, 41).addBox(0.0F, 0.0F, 0.0F, 13.0F, 1.0F, 9.0F), PartPose.offset(6.0F, 0.0F, 0.0F));
		wing_inner_right.addOrReplaceChild("wing_outer_right", CubeListBuilder.create().texOffs(0, 41).mirror().addBox(-13.0F, 0.0F, 0.0F, 13.0F, 1.0F, 9.0F), PartPose.offset(-6.0F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.body);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float ageTicker = (entityIn.getId() * 3 + ageInTicks) * 0.13F;
		this.wing_inner_left.zRot = 0.1F;
		this.wing_outer_left.zRot = 0.1F;
		this.wing_inner_right.zRot = -0.1F;
		this.wing_outer_right.zRot = -0.1F;
		this.body.xRot = -0.1F;
		this.wing_inner_left.zRot = Mth.cos(ageTicker) * 16.0F * ((float) Math.PI / 180F);
		this.wing_outer_left.zRot = Mth.cos(ageTicker) * 16.0F * ((float) Math.PI / 180F);
		this.wing_inner_right.zRot = -this.wing_inner_left.zRot;
		this.wing_outer_right.zRot = -this.wing_outer_left.zRot;
		this.tail.yRot = (float) Math.PI / 4;
		this.neck_lower.xRot = (float) Math.PI / 4;
		this.neck.xRot = -(float) Math.PI / 3;
		this.head.xRot = (float) Math.PI / 4;
	}
}