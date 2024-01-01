package com.technologica.client.model.armor;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.LivingEntity;

public class DivingHelmetModel<T extends LivingEntity> extends HumanoidModel<T> {

	public DivingHelmetModel(ModelPart p_170679_) {
		super(p_170679_, RenderType::entityCutoutNoCull);
	}

	public static MeshDefinition createMesh(CubeDeformation p_170682_, float p_170683_) {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, p_170682_), PartPose.offset(0.0F, 0.0F + p_170683_, 0.0F));

		head.addOrReplaceChild("window_front", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -7.0F, -6.1667F, 6.0F, 6.0F, 1.0F, p_170682_.extend(-0.25F, -0.25F, -0.83333F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("window_left", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -7.0F, -6.1667F, 6.0F, 6.0F, 1.0F, p_170682_.extend(-0.25F, -0.25F, -0.83333F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, (float) -(Math.PI / 2), 0.0F));
		head.addOrReplaceChild("window_right", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -7.0F, -6.1667F, 6.0F, 6.0F, 1.0F, p_170682_.extend(-0.25F, -0.25F, -0.83333F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, (float) (Math.PI / 2), 0.0F));
		head.addOrReplaceChild("window_top", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -12.0F, -6.1667F, 6.0F, 6.0F, 1.0F, p_170682_.extend(-0.25F, -0.25F, -0.83333F)), PartPose.offsetAndRotation(0.0F, -4.0F, -9.0F, (float) -(Math.PI / 2), 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -7.83333F, 8.0F, 8.0F, 8.0F, p_170682_.extend(-2.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("cage_left", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -7.83333F, 8.0F, 8.0F, 8.0F, p_170682_.extend(-2.5F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, (float) -(Math.PI / 2), 0.0F));
		head.addOrReplaceChild("cage_right", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -7.83333F, 8.0F, 8.0F, 8.0F, p_170682_.extend(-2.5F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, (float) (Math.PI / 2), 0.0F));
		head.addOrReplaceChild("cage_top", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -13.0F, -7.83333F, 8.0F, 8.0F, 8.0F, p_170682_.extend(-2.5F)), PartPose.offsetAndRotation(0.0F, -4.0F, -9.0F, (float) -(Math.PI / 2), 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, p_170682_), PartPose.offset(0.0F, 0.0F + p_170683_, 0.0F));
		partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, p_170682_), PartPose.offset(-5.0F, 2.0F + p_170683_, 0.0F));
		partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, p_170682_), PartPose.offset(5.0F, 2.0F + p_170683_, 0.0F));
		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, p_170682_), PartPose.offset(-1.9F, 12.0F + p_170683_, 0.0F));
		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, p_170682_), PartPose.offset(1.9F, 12.0F + p_170683_, 0.0F));
		return meshdefinition;
	}
}