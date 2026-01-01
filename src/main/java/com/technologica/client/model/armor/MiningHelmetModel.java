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
	public MiningHelmetModel(ModelPart modelPart) {
		super(modelPart, RenderType::entityCutoutNoCull);
	}

	public static MeshDefinition createMesh(CubeDeformation cubeDeformation, float offsetY) {
		MeshDefinition meshdefinition = HumanoidModel.createMesh(cubeDeformation, 0.0F);
		PartDefinition root = meshdefinition.getRoot();
		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubeDeformation), PartPose.offset(0.0F, 0.0F + offsetY, 0.0F));
		root.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubeDeformation.extend(0.5F)), PartPose.offset(0.0F, 0.0F + offsetY, 0.0F));
		head.addOrReplaceChild("brim", CubeListBuilder.create().texOffs(0, 20).addBox(-6.0F, -5.25F, -6.0F, 12.0F, 0.0F, 12.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("light", CubeListBuilder.create().texOffs(0, 20).addBox(-2.0F, -10.0F, -6.0F, 4.0F, 4.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("battery", CubeListBuilder.create().texOffs(0, 25).addBox(5.0F, -8.5F, -1.0F, 1.0F, 3.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		return meshdefinition;
	}
}
