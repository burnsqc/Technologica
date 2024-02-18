package com.technologica.client.model;

import com.technologica.world.entity.animal.PoisonDartFrog;

import net.minecraft.client.animation.definitions.FrogAnimation;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class PoisonDartFrogModel<T extends PoisonDartFrog> extends HierarchicalModel<T> {
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart croakingBody;
	private final ModelPart tongue;

	public PoisonDartFrogModel(ModelPart modelPartIn) {
		this.root = modelPartIn.getChild("root");
		this.body = root.getChild("body");
		this.croakingBody = this.body.getChild("croaking_body");
		this.tongue = this.body.getChild("tongue");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition root = meshdefinition.getRoot();
		PartDefinition root1 = root.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition body = root1.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 3.0F, 4.0F), PartPose.offset(0.0F, 21.0F, 0.0F));
		PartDefinition head = root1.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 7).addBox(-1.5F, -1.0F, -3.0F, 3.0F, 1.0F, 3.0F), PartPose.offset(0.0F, 20.0F, -1.0F));
		root1.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 11).addBox(-1.5F, -1.0F, -3.0F, 3.0F, 1.0F, 3.0F), PartPose.offset(0.0F, 21.0F, -1.0F));
		body.addOrReplaceChild("croaking_body", CubeListBuilder.create().texOffs(12, 12).addBox(-1.0F, -0.1F, -2.9F, 2.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, 1.0F, 1.0F));
		body.addOrReplaceChild("tongue", CubeListBuilder.create().texOffs(24, 0).addBox(-0.5F, 0.0F, -6.9F, 1.0F, 0.0F, 6.0F), PartPose.offset(0.0F, -1.01F, 0.0F));
		head.addOrReplaceChild("eyeLeft", CubeListBuilder.create().texOffs(20, 12).addBox(-1.5F, -2.0F, -2.0F, 1.0F, 1.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("eyeRight", CubeListBuilder.create().texOffs(26, 12).addBox(0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		root1.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(16, 5).addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F), PartPose.offset(-3.0F, 21.0F, 0.0F));
		root1.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(16, 0).addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F), PartPose.offset(1.0F, 21.0F, 0.0F));
		root1.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(16, 5).addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F), PartPose.offset(-3.0F, 21.0F, -4.0F));
		root1.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(16, 0).addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F), PartPose.offset(1.0F, 21.0F, -4.0F));
		return LayerDefinition.create(meshdefinition, 32, 16);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.body.xRot = -((float) Math.PI / 8F);
		this.tongue.xRot = ((float) Math.PI / 8F);
		this.animate(entityIn.jumpAnimationState, FrogAnimation.FROG_JUMP, ageInTicks);
		this.animate(entityIn.croakAnimationState, FrogAnimation.FROG_CROAK, ageInTicks);
		this.animate(entityIn.tongueAnimationState, FrogAnimation.FROG_TONGUE, ageInTicks);
		if (entityIn.isInWaterOrBubble()) {
			this.animateWalk(FrogAnimation.FROG_SWIM, limbSwing, limbSwingAmount, 2.0F, 0.2F);
		} else {
			this.animateWalk(FrogAnimation.FROG_WALK, limbSwing, limbSwingAmount, 5.0F, 0.2F);
		}
		this.animate(entityIn.swimIdleAnimationState, FrogAnimation.FROG_IDLE_WATER, ageInTicks);
		this.croakingBody.visible = entityIn.croakAnimationState.isStarted();
		this.tongue.visible = entityIn.tongueAnimationState.isStarted();
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}