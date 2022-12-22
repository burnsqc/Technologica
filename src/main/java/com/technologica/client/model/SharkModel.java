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

public class SharkModel<T extends Entity> extends ListModel<T> {
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart nose;
	private final ModelPart dorsalFin;
	private final ModelPart pectoralFinLeft;
	private final ModelPart pectoralFinRight;
	private final ModelPart tail;
	private final ModelPart tailFinTop;
	private final ModelPart tailFinBottom;

	public SharkModel(ModelPart modelPartIn) {
		this.body = modelPartIn.getChild("body");
		this.head = this.body.getChild("head");
		this.nose = this.head.getChild("nose");
		this.tail = body.getChild("tail");
		this.dorsalFin = body.getChild("dorsalFin");
		this.pectoralFinLeft = body.getChild("pectoralFinLeft");
		this.pectoralFinRight = body.getChild("pectoralFinRight");
		this.tailFinTop = tail.getChild("tailFinTop");
		this.tailFinBottom = tail.getChild("tailFinBottom");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition root = meshdefinition.getRoot();
		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(22, 0).addBox(-4.0F, -7.0F, 0.0F, 8.0F, 7.0F, 13.0F), PartPose.offset(0.0F, 22.0F, -5.0F));
		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 7.0F, 6.0F), PartPose.offset(0.0F, -4.0F, -3.0F));
		head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(0, 13).addBox(-0.35F, -3.0F, -4.65F, 5.0F, 6.0F, 5.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		body.addOrReplaceChild("dorsalFin", CubeListBuilder.create().texOffs(51, 0).addBox(-0.5F, 0.0F, 8.0F, 1.0F, 4.0F, 5.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		body.addOrReplaceChild("pectoralFinLeft", CubeListBuilder.create().texOffs(48, 20).mirror().addBox(-0.5F, -4.0F, 0.0F, 1.0F, 4.0F, 7.0F), PartPose.offset(2.0F, -2.0F, 4.0F));
		body.addOrReplaceChild("pectoralFinRight", CubeListBuilder.create().texOffs(48, 20).addBox(-0.5F, -4.0F, 0.0F, 1.0F, 4.0F, 7.0F), PartPose.offset(-2.0F, -2.0F, 4.0F));
		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 35).addBox(-2.0F, -3.5F, 0.0F, 4.0F, 5.0F, 11.0F), PartPose.offset(0.0F, -2.5F, 11.0F));
		tail.addOrReplaceChild("tailFinTop", CubeListBuilder.create().texOffs(30, 20).addBox(-0.5F, -1.5F, 1.0F, 1.0F, 3.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 9.0F));
		tail.addOrReplaceChild("tailFinBottom", CubeListBuilder.create().texOffs(13, 17).addBox(-0.5F, -3.0F, -2.0F, 1.0F, 3.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 9.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	
	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.body);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.nose.yRot = ((float) Math.PI / 4F);
		this.dorsalFin.xRot = ((float) Math.PI / 3F);
		this.pectoralFinLeft.xRot = ((float) Math.PI / 3F);
		this.pectoralFinLeft.zRot = 2.0943952F;
		this.pectoralFinRight.xRot = ((float) Math.PI / 3F);
		this.pectoralFinRight.zRot = -2.0943952F;
		this.body.xRot = headPitch * ((float) Math.PI / 180F);
		this.body.yRot = netHeadYaw * ((float) Math.PI / 180F);
		this.tail.yRot = -0.10471976F;
		this.tailFinTop.xRot = ((float) Math.PI / 3F);
		this.tailFinTop.yRot = 0.0F;
		this.tailFinBottom.xRot = -((float) Math.PI / 3F);
		this.tailFinBottom.yRot = 0.0F;
		if (entityIn.getDeltaMovement().horizontalDistanceSqr() > 1.0E-7D) {
			this.body.xRot += -0.05F + -0.05F * Mth.cos(ageInTicks * 0.3F);
			this.tail.yRot = -0.1F * Mth.cos(ageInTicks * 0.3F);
			this.tailFinTop.yRot = -0.2F * Mth.cos(ageInTicks * 0.3F);
			this.tailFinBottom.yRot = -0.2F * Mth.cos(ageInTicks * 0.3F);
		}
	}
}
