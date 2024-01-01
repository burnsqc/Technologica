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

public class MiningHelmetModel<T extends LivingEntity> extends HumanoidModel<T> {

	public MiningHelmetModel(ModelPart p_170679_) {
		super(p_170679_, RenderType::entityCutoutNoCull);
	}

	public static MeshDefinition createMesh(CubeDeformation p_170682_, float p_170683_) {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, p_170682_), PartPose.offset(0.0F, 0.0F + p_170683_, 0.0F));
		head.addOrReplaceChild("brim", CubeListBuilder.create().texOffs(0, 20).addBox(-6.0F, -5.25F, -6.0F, 12.0F, 0.0F, 12.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("light", CubeListBuilder.create().texOffs(0, 20).addBox(-2.0F, -10.0F, -6.0F, 4.0F, 4.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("battery", CubeListBuilder.create().texOffs(0, 25).addBox(5.0F, -8.5F, -1.0F, 1.0F, 3.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, p_170682_.extend(0.5F)), PartPose.offset(0.0F, 0.0F + p_170683_, 0.0F));
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, p_170682_), PartPose.offset(0.0F, 0.0F + p_170683_, 0.0F));
		partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, p_170682_), PartPose.offset(-5.0F, 2.0F + p_170683_, 0.0F));
		partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, p_170682_), PartPose.offset(5.0F, 2.0F + p_170683_, 0.0F));
		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, p_170682_), PartPose.offset(-1.9F, 12.0F + p_170683_, 0.0F));
		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, p_170682_), PartPose.offset(1.9F, 12.0F + p_170683_, 0.0F));
		return meshdefinition;
	}
}