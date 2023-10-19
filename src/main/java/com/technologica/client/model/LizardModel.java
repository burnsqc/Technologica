package com.technologica.client.model;

import com.technologica.world.entity.animal.Lizard;

import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class LizardModel<T extends Lizard> extends QuadrupedModel<T> {
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart tongue;
	private final ModelPart frillLeft;
	private final ModelPart frillRight;

	public LizardModel(ModelPart modelPartIn) {
		super(modelPartIn, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		this.body = modelPartIn.getChild("body");
		this.head = modelPartIn.getChild("head");
		this.tongue = head.getChild("tongue");
		this.frillLeft = body.getChild("frill_left");
		this.frillRight = body.getChild("frill_right");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition root = meshdefinition.getRoot();
		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 3.0F, 6.0F), PartPose.offset(0.0F, 21.0F, 0.0F));
		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(14, 0).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 2.0F, 3.0F), PartPose.offset(0.0F, 20.0F, -3.0F));
		head.addOrReplaceChild("tongue", CubeListBuilder.create().texOffs(23, 0).mirror().addBox(-1.5F, 0.0F, -0.5F, 3.0F, 0.0F, 3.0F), PartPose.offset(1.5F, 0.5F, -1.5F));
		body.addOrReplaceChild("frill_left", CubeListBuilder.create().texOffs(0, 9).mirror().addBox(-1.0F, -4.0F, 0.0F, 5.0F, 5.0F, 0.0F), PartPose.offset(0.0F, -1.0F, -3.5F));
		body.addOrReplaceChild("frill_right", CubeListBuilder.create().texOffs(0, 9).addBox(-4.0F, -4.0F, 0.0F, 5.0F, 5.0F, 0.0F), PartPose.offset(0.0F, -1.0F, -3.5F));
		root.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(20, 5).addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F), PartPose.offset(0.0F, 21.0F, 0.0F));
		root.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(20, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F), PartPose.offset(-3.0F, 21.0F, 0.0F));
		root.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(20, 5).addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F), PartPose.offset(1.0F, 21.0F, -4.0F));
		root.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(20, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F), PartPose.offset(-3.0F, 21.0F, -4.0F));
		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(10, 10).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(0.0F, 1.0F, 3.0F));
		tail.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(22, 10).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 4.0F));
		return LayerDefinition.create(meshdefinition, 32, 16);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = (float) Math.PI / 4;
		this.tongue.yRot = 3 * (float) Math.PI / 4;
		this.frillLeft.zRot = (float) Math.PI / 4;
		this.frillRight.zRot = -(float) Math.PI / 4;
	}
}