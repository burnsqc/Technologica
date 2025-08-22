package com.technologica.client.model;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;

public class AxemanModel<T extends Mob> extends HumanoidModel<T> {
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart hat;
	private final ModelPart rightArm;
	private final ModelPart leftArm;
	private final ModelPart rightLeg;
	private final ModelPart leftLeg;

	public AxemanModel(ModelPart root) {
		super(root);
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.jaw = head.getChild("jaw");
		this.hat = root.getChild("hat");
		this.rightArm = root.getChild("right_arm");
		this.leftArm = root.getChild("left_arm");
		this.rightLeg = root.getChild("right_leg");
		this.leftLeg = root.getChild("left_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -12.0F, -3.0F, 12.0F, 18.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 24).addBox(-9.0F, -12.0F, 0.0F, 18.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(36, 0).addBox(-1.0F, -16.0F, 1.0F, 2.0F, 22.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 27).addBox(-5.0F, -24.0F, -6.0F, 10.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(0, 84).addBox(-4.0F, -23.0F, -5.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 43).addBox(-4.0F, -18.0F, -1.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(29, 54).addBox(-4.0F, -18.0F, -6.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 49).addBox(-4.0F, 0.0F, -5.0F, 8.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -18.0F, -1.0F));

		PartDefinition hat = partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(0, 58).addBox(-5.0F, -24.0F, -6.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.5F))
		.texOffs(0, 78).addBox(5.0F, -22.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.5F))
		.texOffs(0, 78).addBox(-7.0F, -22.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.5F))
		.texOffs(8, 78).addBox(-8.0F, -27.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.5F))
		.texOffs(8, 78).addBox(7.0F, -27.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightArm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(56, 0).addBox(-4.0F, -13.0F, 0.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(56, 12).addBox(-3.0F, -3.0F, 0.0F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(62, 12).addBox(-4.0F, -3.0F, 0.0F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(52, 22).addBox(-5.0F, 5.0F, 1.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(52, 27).addBox(-5.0F, 5.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition leftArm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(56, 0).mirror().addBox(2.0F, -13.0F, 0.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(56, 12).mirror().addBox(2.0F, -3.0F, 0.0F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(62, 12).mirror().addBox(3.0F, -3.0F, 0.0F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(52, 22).mirror().addBox(1.0F, 5.0F, 1.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(52, 27).mirror().addBox(1.0F, 5.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition rightLeg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(44, 0).addBox(-3.0F, -6.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(44, 11).addBox(-2.0F, 3.0F, -1.0F, 1.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(50, 11).addBox(-3.0F, 3.0F, -1.0F, 1.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 32).addBox(-3.0F, 11.0F, -5.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(40, 32).addBox(-2.0F, 11.0F, -5.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 12.0F, 0.0F));

		PartDefinition leftLeg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(44, 0).addBox(1.0F, -6.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(44, 11).mirror().addBox(1.0F, 3.0F, -1.0F, 1.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(50, 11).mirror().addBox(2.0F, 3.0F, -1.0F, 1.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(40, 32).addBox(1.0F, 11.0F, -5.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(40, 32).addBox(2.0F, 11.0F, -5.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		jaw.xRot = (1 + Mth.sin(ageInTicks / 6)) / 6;
	}
}
