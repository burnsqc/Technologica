package com.technologica.client.model;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.Entity;

public class DustDevilModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart body2;
	private final ModelPart body3;
	private final ModelPart body4;
	private final ModelPart body5;
	private final ModelPart body6;
	private final ModelPart body7;
	private final ModelPart body8;
	private final ModelPart ring1;
	private final ModelPart ring2;
	private final ModelPart ring3;
	private final ModelPart ring4;
	private final ModelPart ring5;
	private final ModelPart ring6;

	public DustDevilModel(ModelPart modlePart) {
		this.root = modlePart;
		this.body = modlePart.getChild("body");
		this.body2 = modlePart.getChild("body2");
		this.body3 = modlePart.getChild("body3");
		this.body4 = modlePart.getChild("body4");
		this.body5 = modlePart.getChild("body5");
		this.body6 = modlePart.getChild("body6");
		this.body7 = modlePart.getChild("body7");
		this.body8 = modlePart.getChild("body8");
		this.ring1 = modlePart.getChild("ring1");
		this.ring2 = modlePart.getChild("ring2");
		this.ring3 = modlePart.getChild("ring3");
		this.ring4 = modlePart.getChild("ring4");
		this.ring5 = modlePart.getChild("ring5");
		this.ring6 = modlePart.getChild("ring6");
	}

	public static LayerDefinition createBodyLayer(CubeDeformation cubeDeformation) {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(14, 14).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, cubeDeformation), PartPose.offset(0.0F, 16.0F, 0.0F));
		partdefinition.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(12, 12).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, cubeDeformation), PartPose.offset(0.0F, 8.0F, 0.0F));
		partdefinition.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(10, 10).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 8.0F, 6.0F, cubeDeformation), PartPose.offset(0.0F, 0.0F, 0.0F));
		partdefinition.addOrReplaceChild("body4", CubeListBuilder.create().texOffs(8, 8).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubeDeformation), PartPose.offset(0.0F, -8.0F, 0.0F));
		partdefinition.addOrReplaceChild("body5", CubeListBuilder.create().texOffs(0, 48).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 4.0F, 10.0F, cubeDeformation), PartPose.offset(0.0F, -12.0F, 0.0F));
		partdefinition.addOrReplaceChild("body6", CubeListBuilder.create().texOffs(0, 32).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 4.0F, 12.0F, cubeDeformation), PartPose.offset(0.0F, -16.0F, 0.0F));
		partdefinition.addOrReplaceChild("body7", CubeListBuilder.create().texOffs(2, 2).addBox(-7.0F, 0.0F, -7.0F, 14.0F, 4.0F, 14.0F, cubeDeformation), PartPose.offset(0.0F, -20.0F, 0.0F));
		partdefinition.addOrReplaceChild("body8", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, 0.0F, -8.0F, 16.0F, 4.0F, 16.0F, cubeDeformation), PartPose.offset(0.0F, -24.0F, 0.0F));

		partdefinition.addOrReplaceChild("ring1", CubeListBuilder.create().texOffs(60, 58).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 2.0F, 4.0F, cubeDeformation), PartPose.offset(0.0F, 19.0F, 0.0F));
		partdefinition.addOrReplaceChild("ring2", CubeListBuilder.create().texOffs(56, 54).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.0F, 8.0F, cubeDeformation), PartPose.offset(0.0F, 11.0F, 0.0F));
		partdefinition.addOrReplaceChild("ring3", CubeListBuilder.create().texOffs(52, 50).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 2.0F, 12.0F, cubeDeformation), PartPose.offset(0.0F, 3.0F, 0.0F));
		partdefinition.addOrReplaceChild("ring4", CubeListBuilder.create().texOffs(48, 46).addBox(-8.0F, 0.0F, -8.0F, 16.0F, 2.0F, 16.0F, cubeDeformation), PartPose.offset(0.0F, -5.0F, 0.0F));
		partdefinition.addOrReplaceChild("ring5", CubeListBuilder.create().texOffs(44, 42).addBox(-10.0F, 0.0F, -10.0F, 20.0F, 2.0F, 20.0F, cubeDeformation), PartPose.offset(0.0F, -13.0F, 0.0F));
		partdefinition.addOrReplaceChild("ring6", CubeListBuilder.create().texOffs(40, 38).addBox(-12.0F, 0.0F, -12.0F, 24.0F, 2.0F, 24.0F, cubeDeformation), PartPose.offset(0.0F, -21.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.xRot = (float) (0.1F * Math.sin(ageInTicks / 2));
		this.body.zRot = (float) (0.1F * Math.cos(ageInTicks / 2));
		this.body2.xRot = (float) (0.1F * Math.cos(ageInTicks / 2));
		this.body2.zRot = (float) (0.1F * -Math.sin(ageInTicks / 2));
		this.body3.xRot = (float) (0.1F * -Math.sin(ageInTicks / 2));
		this.body3.zRot = (float) (0.1F * -Math.cos(ageInTicks / 2));
		this.body4.xRot = (float) (0.1F * -Math.cos(ageInTicks / 2));
		this.body4.zRot = (float) (0.1F * Math.sin(ageInTicks / 2));
		this.body5.xRot = (float) (0.1F * Math.sin(ageInTicks / 2));
		this.body5.zRot = (float) (0.1F * Math.cos(ageInTicks / 2));
		this.body6.xRot = (float) (0.1F * Math.cos(ageInTicks / 2));
		this.body6.zRot = (float) (0.1F * -Math.sin(ageInTicks / 2));
		this.body7.xRot = (float) (0.1F * -Math.sin(ageInTicks / 2));
		this.body7.zRot = (float) (0.1F * -Math.cos(ageInTicks / 2));
		this.body8.xRot = (float) (0.1F * -Math.cos(ageInTicks / 2));
		this.body8.zRot = (float) (0.1F * Math.sin(ageInTicks / 2));

		this.ring1.yRot = ageInTicks;
		this.ring1.xRot = (float) (0.1F * Math.sin(ageInTicks / 2));
		this.ring1.zRot = (float) (0.1F * Math.cos(ageInTicks / 2));

		this.ring2.yRot = ageInTicks / 1.5F;
		this.ring2.xRot = (float) (0.1F * Math.cos(ageInTicks / 2));
		this.ring2.zRot = (float) (0.1F * -Math.sin(ageInTicks / 2));

		this.ring3.yRot = ageInTicks / 2;
		this.ring3.xRot = (float) (0.1F * -Math.sin(ageInTicks / 2));
		this.ring3.zRot = (float) (0.1F * -Math.cos(ageInTicks / 2));

		this.ring4.yRot = ageInTicks / 2.5F;
		this.ring4.xRot = (float) (0.1F * -Math.cos(ageInTicks / 2));
		this.ring4.zRot = (float) (0.1F * Math.sin(ageInTicks / 2));

		this.ring5.yRot = ageInTicks / 3;
		this.ring5.xRot = (float) (0.1F * Math.sin(ageInTicks / 2));
		this.ring5.zRot = (float) (0.1F * Math.cos(ageInTicks / 2));

		this.ring6.yRot = ageInTicks / 3.5F;
		this.ring6.xRot = (float) (0.1F * Math.cos(ageInTicks / 2));
		this.ring6.zRot = (float) (0.1F * -Math.sin(ageInTicks / 2));
	}
}