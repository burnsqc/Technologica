package com.technologica.client.model;

import com.technologica.world.entity.animal.Sloth;

import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class SlothModel<T extends Sloth> extends QuadrupedModel<T> {
	private final ModelPart legBackRightLower;
	private final ModelPart legBackLeftLower;
	private final ModelPart legFrontRightLower;
	private final ModelPart legFrontLeftLower;

	public SlothModel(ModelPart modelPartIn) {
		super(modelPartIn, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		this.legBackRightLower = this.rightHindLeg.getChild("legBackRightLower");
		this.legBackLeftLower = this.leftHindLeg.getChild("legBackLeftLower");
		this.legFrontRightLower = this.rightFrontLeg.getChild("legFrontRightLower");
		this.legFrontLeftLower = this.leftFrontLeg.getChild("legFrontLeftLower");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 18.0F, -5.0F));
		head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(12, 16).addBox(-1.0F, -2.0F, -4.5F, 2.0F, 1.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, -5.0F, 6.0F, 6.0F, 10.0F), PartPose.offset(0.0F, 17.0F, 0.0F));
		PartDefinition righthindlegdefinition = partdefinition.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-0.99F, 0.0F, 0.0F, 1.98F, 6.0F, 2.0F), PartPose.offset(-2.0F, 20.0F, 3.0F));
		PartDefinition lefthindlegdefinition = partdefinition.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-0.99F, 0.0F, 0.0F, 1.98F, 6.0F, 2.0F), PartPose.offset(2.0F, 20.0F, 3.0F));
		PartDefinition rightfrontlegdefinition = partdefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-0.99F, 0.0F, -2.0F, 1.98F, 6.0F, 2.0F), PartPose.offset(-2.0F, 20.0F, -3.0F));
		PartDefinition leftfrontlegdefinition = partdefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-0.99F, 0.0F, -2.0F, 1.98F, 6.0F, 2.0F), PartPose.offset(2.0F, 20.0F, -3.0F));
		righthindlegdefinition.addOrReplaceChild("legBackRightLower", CubeListBuilder.create().texOffs(22, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F).texOffs(0, 16).addBox(0.0F, 4.0F, 0.0F, 1.0F, 3.0F, 1.0F).texOffs(0, 16).addBox(-1.0F, 4.0F, 0.0F, 1.0F, 3.0F, 1.0F), PartPose.offset(0.0F, 6.0F, 0.0F));
		lefthindlegdefinition.addOrReplaceChild("legBackLeftLower", CubeListBuilder.create().texOffs(22, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F).texOffs(0, 16).addBox(-1.0F, 4.0F, 0.0F, 1.0F, 3.0F, 1.0F).texOffs(0, 16).addBox(0.0F, 4.0F, 0.0F, 1.0F, 3.0F, 1.0F), PartPose.offset(0.0F, 6.0F, 0.0F));
		rightfrontlegdefinition.addOrReplaceChild("legFrontRightLower", CubeListBuilder.create().texOffs(22, 0).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 4.0F, 2.0F).texOffs(0, 16).addBox(0.0F, 4.0F, -1.0F, 1.0F, 3.0F, 1.0F).texOffs(0, 16).addBox(-1.0F, 4.0F, -1.0F, 1.0F, 3.0F, 1.0F), PartPose.offset(0.0F, 6.0F, 0.0F));
		leftfrontlegdefinition.addOrReplaceChild("legFrontLeftLower", CubeListBuilder.create().texOffs(22, 0).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 4.0F, 2.0F).texOffs(0, 16).addBox(-1.0F, 4.0F, -1.0F, 1.0F, 3.0F, 1.0F).texOffs(0, 16).addBox(0.0F, 4.0F, -1.0F, 1.0F, 3.0F, 1.0F), PartPose.offset(0.0F, 6.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.xRot = headPitch * ((float) Math.PI / 180F) * 0.5F;
		this.head.yRot = netHeadYaw * ((float) Math.PI / 180F) * 0.5F;
		this.rightHindLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftHindLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.rightFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leftFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.rightHindLeg.xRot = (float) Math.PI / 4;
		this.leftHindLeg.xRot = (float) Math.PI / 4;
		this.rightFrontLeg.xRot = -(float) Math.PI / 4;
		this.leftFrontLeg.xRot = -(float) Math.PI / 4;
		this.legBackRightLower.xRot = (float) Math.PI / 4;
		this.legBackLeftLower.xRot = (float) Math.PI / 4;
		this.legFrontRightLower.xRot = -(float) Math.PI / 4;
		this.legFrontLeftLower.xRot = -(float) Math.PI / 4;
	}
}