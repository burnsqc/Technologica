package com.technologica.client.model;

import net.minecraft.client.model.ColorableHierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.Entity;

public class PiranhaModel<T extends Entity> extends ColorableHierarchicalModel<T> {

	private final ModelPart body;
	private final ModelPart tail;

	public PiranhaModel(ModelPart modelPartIn) {
		this.body = modelPartIn;
		this.tail = modelPartIn.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 6.0F, 6.0F), PartPose.offset(0.0F, 21.0F, 6.0F));
		partdefinition.addOrReplaceChild("right_fin", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-1.0F, 22.5F, 5.0F, 0.0F, ((float) Math.PI / 4F), 0.0F));
		partdefinition.addOrReplaceChild("left_fin", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(1.0F, 22.5F, 5.0F, 0.0F, (-(float) Math.PI / 4F), 0.0F));
		partdefinition.addOrReplaceChild("top_fin", CubeListBuilder.create().texOffs(0, -1).addBox(0.0F, -4.0F, -2.0F, 0.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 21.0F, 6.0F, -(float) Math.PI / 4, 0.0F, 0.0F));
		partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(10, -2).addBox(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 2.0F), PartPose.offset(0.0F, 21.0F, 9.0F));
		partdefinition.addOrReplaceChild("bottom_fin", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 3.0F, -1.0F, 0.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 21.0F, 6.0F, (float) Math.PI / 4, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public ModelPart root() {
		return this.body;
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.xRot = (float) Math.PI / 4;
		this.tail.yRot = (float) (entityIn.isInWater() ? 0.45F * Math.sin(0.6F * ageInTicks) : 0.675F * Math.sin(0.6F * ageInTicks));
	}
}