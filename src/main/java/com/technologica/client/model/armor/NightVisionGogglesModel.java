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

public class NightVisionGogglesModel<T extends LivingEntity> extends HumanoidModel<T> {
	public NightVisionGogglesModel(ModelPart modelPart) {
		super(modelPart, RenderType::entityCutoutNoCull);
	}

	public static MeshDefinition createMesh(CubeDeformation cubeDeformation, float offsetY) {
		MeshDefinition meshdefinition = HumanoidModel.createMesh(cubeDeformation, 0.0F);
		PartDefinition root = meshdefinition.getRoot();
		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubeDeformation), PartPose.offset(0.0F, 0.0F + offsetY, 0.0F));
		head.addOrReplaceChild("eye_right", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -5.0F, -7.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("eye_left", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, -5.0F, -7.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("lens_right", CubeListBuilder.create().texOffs(0, 4).addBox(-3.0F, -5.0F, -6.0F, 2.0F, 2.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("lens_left", CubeListBuilder.create().texOffs(0, 4).addBox(1.0F, -5.0F, -6.0F, 2.0F, 2.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		return meshdefinition;
	}
}
