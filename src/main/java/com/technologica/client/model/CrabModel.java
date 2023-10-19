package com.technologica.client.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.Entity;

public class CrabModel<T extends Entity> extends ListModel<T> {
	private final ModelPart body;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	private final ModelPart leg5;
	private final ModelPart leg6;
	private final ModelPart leg7;
	private final ModelPart leg8;
	private final ModelPart armRight;
	private final ModelPart clawRight;
	private final ModelPart pincherRightInner;
	private final ModelPart armLeft;
	private final ModelPart clawLeft;
	private final ModelPart pincherLeftInner;

	public CrabModel(ModelPart modelPartIn) {
		this.body = modelPartIn.getChild("body");
		this.leg1 = modelPartIn.getChild("leg1");
		this.leg2 = modelPartIn.getChild("leg2");
		this.leg3 = modelPartIn.getChild("leg3");
		this.leg4 = modelPartIn.getChild("leg4");
		this.leg5 = modelPartIn.getChild("leg5");
		this.leg6 = modelPartIn.getChild("leg6");
		this.leg7 = modelPartIn.getChild("leg7");
		this.leg8 = modelPartIn.getChild("leg8");
		this.armLeft = body.getChild("armLeft");
		this.clawLeft = armLeft.getChild("clawLeft");
		this.pincherLeftInner = armLeft.getChild("pincherLeftInner");
		this.armRight = body.getChild("armRight");
		this.clawRight = armRight.getChild("clawRight");
		this.pincherRightInner = armRight.getChild("pincherRightInner");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 16.0F, 0.0F, 6.0F, 2.0F, 5.0F), PartPose.offset(0.0F, 4.0F, -3.0F));
		body.addOrReplaceChild("eyeLeft", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, 15.0F, 0.0F, 1.0F, 1.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		body.addOrReplaceChild("eyeRight", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 15.0F, 0.0F, 1.0F, 1.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 7).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F), PartPose.offset(-3.0F, 22.0F, 1.0F));
		partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 7).addBox(-1.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F), PartPose.offset(3.0F, 22.0F, 1.0F));
		partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 7).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F), PartPose.offset(-3.0F, 22.0F, 0.0F));
		partdefinition.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(0, 7).addBox(-1.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F), PartPose.offset(3.0F, 22.0F, 0.0F));
		partdefinition.addOrReplaceChild("leg5", CubeListBuilder.create().texOffs(0, 7).addBox(-3.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F), PartPose.offset(-3.0F, 22.0F, -1.0F));
		partdefinition.addOrReplaceChild("leg6", CubeListBuilder.create().texOffs(0, 7).addBox(-1.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F), PartPose.offset(3.0F, 22.0F, -1.0F));
		partdefinition.addOrReplaceChild("leg7", CubeListBuilder.create().texOffs(0, 7).addBox(-3.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F), PartPose.offset(-3.0F, 22.0F, -2.0F));
		partdefinition.addOrReplaceChild("leg8", CubeListBuilder.create().texOffs(0, 7).addBox(-1.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F), PartPose.offset(3.0F, 22.0F, -2.0F));
		PartDefinition armLeft = body.addOrReplaceChild("armLeft", CubeListBuilder.create().texOffs(0, 9).addBox(0.0F, 16.0F, 0.0F, 3.0F, 1.0F, 1.0F), PartPose.offset(2.0F, 1.0F, 0.0F));
		armLeft.addOrReplaceChild("clawLeft", CubeListBuilder.create().texOffs(0, 11).addBox(-2.0F, 16.0F, 0.0F, 2.0F, 1.0F, 1.0F), PartPose.offset(3.0F, 0.0F, 1.0F));
		armLeft.addOrReplaceChild("pincherLeftInner", CubeListBuilder.create().texOffs(0, 11).addBox(-2.0F, 16.0F, 0.0F, 2.0F, 1.0F, 1.0F), PartPose.offset(3.0F, 0.0F, 1.0F));
		PartDefinition armRight = body.addOrReplaceChild("armRight", CubeListBuilder.create().texOffs(0, 9).addBox(-3.0F, 16.0F, 0.0F, 3.0F, 1.0F, 1.0F), PartPose.offset(-2.0F, 1.0F, 0.0F));
		armRight.addOrReplaceChild("clawRight", CubeListBuilder.create().texOffs(0, 11).addBox(-2.0F, 16.0F, -1.0F, 2.0F, 1.0F, 1.0F), PartPose.offset(-3.0F, 0.0F, 1.0F));
		armRight.addOrReplaceChild("pincherRightInner", CubeListBuilder.create().texOffs(0, 11).addBox(-2.0F, 16.0F, -1.0F, 2.0F, 1.0F, 1.0F), PartPose.offset(-3.0F, 0.0F, 1.0F));
		return LayerDefinition.create(meshdefinition, 32, 16);
	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.body, this.leg1, this.leg2, this.leg3, this.leg4, this.leg5, this.leg6, this.leg7, this.leg8);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		armRight.yRot = -(float) Math.PI / 4F;
		clawRight.yRot = -(float) Math.PI / 4F;
		pincherRightInner.yRot = 2 * -(float) Math.PI / 4F;
		armLeft.yRot = (float) Math.PI / 4F;
		clawLeft.yRot = 3 * -(float) Math.PI / 4F;
		pincherLeftInner.yRot = 2 * -(float) Math.PI / 4F;
		this.leg1.zRot = (-(float) Math.PI / 4F);
		this.leg2.zRot = ((float) Math.PI / 4F);
		this.leg3.zRot = -0.58119464F;
		this.leg4.zRot = 0.58119464F;
		this.leg5.zRot = -0.58119464F;
		this.leg6.zRot = 0.58119464F;
		this.leg7.zRot = (-(float) Math.PI / 4F);
		this.leg8.zRot = ((float) Math.PI / 4F);
		this.leg1.yRot = ((float) Math.PI / 4F);
		this.leg2.yRot = (-(float) Math.PI / 4F);
		this.leg3.yRot = ((float) Math.PI / 8F);
		this.leg4.yRot = (-(float) Math.PI / 8F);
		this.leg5.yRot = (-(float) Math.PI / 8F);
		this.leg6.yRot = ((float) Math.PI / 8F);
		this.leg7.yRot = (-(float) Math.PI / 4F);
		this.leg8.yRot = ((float) Math.PI / 4F);
		float f3 = (float) (-(Math.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount);
		float f4 = (float) (-(Math.cos(limbSwing * 0.6662F * 2.0F + (float) Math.PI) * 0.4F) * limbSwingAmount);
		float f5 = (float) (-(Math.cos(limbSwing * 0.6662F * 2.0F + ((float) Math.PI / 2F)) * 0.4F) * limbSwingAmount);
		float f6 = (float) (-(Math.cos(limbSwing * 0.6662F * 2.0F + ((float) Math.PI * 1.5F)) * 0.4F) * limbSwingAmount);
		float f7 = (float) (Math.abs(Math.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount);
		float f8 = (float) (Math.abs(Math.sin(limbSwing * 0.6662F + (float) Math.PI) * 0.4F) * limbSwingAmount);
		float f9 = (float) (Math.abs(Math.sin(limbSwing * 0.6662F + ((float) Math.PI / 2F)) * 0.4F) * limbSwingAmount);
		float f10 = (float) (Math.abs(Math.sin(limbSwing * 0.6662F + ((float) Math.PI * 1.5F)) * 0.4F) * limbSwingAmount);
		this.leg1.yRot += f3;
		this.leg2.yRot += -f3;
		this.leg3.yRot += f4;
		this.leg4.yRot += -f4;
		this.leg5.yRot += f5;
		this.leg6.yRot += -f5;
		this.leg7.yRot += f6;
		this.leg8.yRot += -f6;
		this.leg1.zRot += f7;
		this.leg2.zRot += -f7;
		this.leg3.zRot += f8;
		this.leg4.zRot += -f8;
		this.leg5.zRot += f9;
		this.leg6.zRot += -f9;
		this.leg7.zRot += f10;
		this.leg8.zRot += -f10;
	}

	public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}