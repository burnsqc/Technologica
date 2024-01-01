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

public class StingrayModel<T extends Entity> extends ListModel<T> {
	private final ModelPart body;
	private final ModelPart tail1;
	private final ModelPart tail2;
	private final ModelPart tail3;

	public StingrayModel(ModelPart modelPartIn) {
		this.body = modelPartIn.getChild("body");
		this.tail1 = body.getChild("tail1");
		this.tail2 = tail1.getChild("tail2");
		this.tail3 = tail2.getChild("tail3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 0.0F, -8.0F, 6.0F, 1.0F, 16.0F), PartPose.offset(0.0F, 23.0F, 0.0F));
		body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(28, 0).addBox(-3.0F, -1.0F, -4.0F, 6.0F, 1.0F, 12.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition bodyLeft1 = body.addOrReplaceChild("bodyLeft1", CubeListBuilder.create().texOffs(0, 17).mirror(true).addBox(0.0F, -1.0F, -7.0F, 2.0F, 1.0F, 14.0F), PartPose.offset(3.0F, 1.0F, 0.0F));
		PartDefinition bodyLeft2 = bodyLeft1.addOrReplaceChild("bodyLeft2", CubeListBuilder.create().texOffs(18, 17).mirror(true).addBox(0.0F, -1.0F, -6.0F, 1.0F, 1.0F, 12.0F), PartPose.offset(2.0F, 0.0F, 0.0F));
		PartDefinition bodyLeft3 = bodyLeft2.addOrReplaceChild("bodyLeft3", CubeListBuilder.create().texOffs(32, 17).mirror(true).addBox(0.0F, -1.0F, -5.0F, 1.0F, 1.0F, 10.0F), PartPose.offset(1.0F, 0.0F, 0.0F));
		bodyLeft3.addOrReplaceChild("bodyLeft4", CubeListBuilder.create().texOffs(44, 17).mirror(true).addBox(0.0F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F), PartPose.offset(1.0F, 0.0F, 0.0F));
		PartDefinition bodyRight1 = body.addOrReplaceChild("bodyRight1", CubeListBuilder.create().texOffs(0, 17).addBox(-2.0F, -1.0F, -7.0F, 2.0F, 1.0F, 14.0F), PartPose.offset(-3.0F, 1.0F, 0.0F));
		PartDefinition bodyRight2 = bodyRight1.addOrReplaceChild("bodyRight2", CubeListBuilder.create().texOffs(18, 17).addBox(-1.0F, -1.0F, -6.0F, 1.0F, 1.0F, 12.0F), PartPose.offset(-2.0F, 0.0F, 0.0F));
		PartDefinition bodyRight3 = bodyRight2.addOrReplaceChild("bodyRight3", CubeListBuilder.create().texOffs(32, 17).addBox(-1.0F, -1.0F, -5.0F, 1.0F, 1.0F, 10.0F), PartPose.offset(-1.0F, 0.0F, 0.0F));
		bodyRight3.addOrReplaceChild("bodyRight4", CubeListBuilder.create().texOffs(44, 17).addBox(-1.0F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F), PartPose.offset(-1.0F, 0.0F, 0.0F));
		PartDefinition tail1 = body.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F), PartPose.offset(0.0F, 0.0F, 8.0F));
		PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(0, 8).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 6.0F), PartPose.offset(0.0F, 0.5F, 6.0F));
		tail2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(0, 17).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 6.0F), PartPose.offset(0.0F, 0.0F, 6.0F));
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.body);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.xRot = headPitch * ((float) Math.PI / 180F);
		this.body.yRot = netHeadYaw * ((float) Math.PI / 180F);
		if (entityIn.getDeltaMovement().horizontalDistanceSqr() > 1.0E-7D) {
			this.tail1.yRot = 0.2F * Mth.cos(ageInTicks * 0.3F);
			this.tail2.yRot = 0.2F * Mth.cos(ageInTicks * 0.3F);
			this.tail3.yRot = 0.2F * Mth.cos(ageInTicks * 0.3F);
		}
	}
}