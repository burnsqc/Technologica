package com.technologica.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.Entity;

public class WindmillModel<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new TechnologicaLocation("windmill"), "main");
	private final ModelPart main;

	public WindmillModel(ModelPart root) {
		this.main = root.getChild("windmill");
	}

	public static LayerDefinition createBodyModel() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("windmill", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 18).addBox(-8.0F, -10.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 18).addBox(-24.0F, -10.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 18).addBox(-40.0F, -10.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 18).addBox(-56.0F, -10.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 18).addBox(-72.0F, -10.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(0.0F, 0.0F, -24.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(0.0F, 0.0F, -40.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(0.0F, 0.0F, -56.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -9.0F, -16.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(8.0F, 0.0F, 0.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(24.0F, 0.0F, 0.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(40.0F, 0.0F, 0.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, -9.0F, 2.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r3 = bb_main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 18).addBox(-24.0F, -10.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 18).addBox(-40.0F, -10.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 18).addBox(-56.0F, -10.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 18).addBox(-72.0F, -10.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r4 = bb_main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 18).addBox(-24.0F, -10.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 18).addBox(-40.0F, -10.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 18).addBox(-56.0F, -10.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 18).addBox(-72.0F, -10.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r5 = bb_main.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 18).addBox(-8.0F, -10.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 18).addBox(-40.0F, -10.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 18).addBox(-56.0F, -10.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 18).addBox(-72.0F, -10.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 18).addBox(-24.0F, -10.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r6 = bb_main.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-16.0F, 0.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-16.0F, 0.0F, 8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-16.0F, 0.0F, 24.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-16.0F, 0.0F, 40.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -9.0F, 16.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r7 = bb_main.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-56.0F, 0.0F, -16.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-40.0F, 0.0F, -16.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-24.0F, 0.0F, -16.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-8.0F, 0.0F, -16.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, -9.0F, -2.0F, 0.3927F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		main.yRot = ageInTicks / 20;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
