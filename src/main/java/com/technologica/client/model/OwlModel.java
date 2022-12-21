package com.technologica.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.technologica.world.entity.animal.Owl;

import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class OwlModel<T extends Owl> extends ListModel<T> {
	private final ModelPart body;
	private final ModelPart tail;
	private final ModelPart wing_left;
	private final ModelPart wing_right;
	private final ModelPart head;
	private final ModelPart beak;
	private final ModelPart leg_left;
	private final ModelPart leg_right;

	public OwlModel(ModelPart modelPartIn) {
		this.body = modelPartIn.getChild("body");
		this.wing_left = modelPartIn.getChild("wing_left");
		this.wing_right = modelPartIn.getChild("wing_right");
		this.tail = modelPartIn.getChild("tail");
		this.leg_left = modelPartIn.getChild("leg_left");
		this.leg_right = modelPartIn.getChild("leg_right");
		this.head = modelPartIn.getChild("head");
		this.beak = head.getChild("beak");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition root = meshdefinition.getRoot();
		root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -1.5F, 4.0F, 6.0F, 4.0F), PartPose.offset(0.0F, 16.5F, -3.0F));
		root.addOrReplaceChild("wing_left", CubeListBuilder.create().texOffs(12, 6).addBox(-0.5F, 0.0F, -1.5F, 1.0F, 6.0F, 4.0F), PartPose.offset(2.0F, 16.94F, -1.76F));
		root.addOrReplaceChild("wing_right", CubeListBuilder.create().texOffs(12, 6).addBox(-0.5F, 0.0F, -1.5F, 1.0F, 6.0F, 4.0F), PartPose.offset(-2.0F, 16.94F, -1.76F));
		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(18, 0).addBox(-1.5F, -2.0F, -1.5F, 3.0F, 4.0F, 3.0F), PartPose.offset(0.0F, 15.69F, -2.26F));
		head.addOrReplaceChild("beak", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F), PartPose.offset(0.0F, 0.0F, -1.5F));
		root.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(12, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F), PartPose.offset(1.0F, 22.0F, -1.05F));
		root.addOrReplaceChild("leg_right", CubeListBuilder.create().texOffs(12, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F), PartPose.offset(-1.0F, 22.0F, -1.05F));
		root.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 10).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 4.0F, 1.0F), PartPose.offset(0.0F, 21.07F, 1.16F));
		return LayerDefinition.create(meshdefinition, 32, 16);
	}
	
	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.body, this.wing_left, this.wing_right, this.tail, this.head, this.leg_left, this.leg_right);
	}

	@Override
	public void setupAnim(Owl entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.setRotationAngles(getParrotState(entityIn), entityIn.tickCount, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
	}

	@Override
	public void prepareMobModel(Owl entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		this.setLivingAnimations(getParrotState(entityIn));
	}

	public void renderOnShoulder(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float p_228284_5_, float p_228284_6_, float p_228284_7_, float p_228284_8_, int p_228284_9_) {
		this.setLivingAnimations(OwlModel.State.ON_SHOULDER);
		this.setRotationAngles(OwlModel.State.ON_SHOULDER, p_228284_9_, p_228284_5_, p_228284_6_, 0.0F, p_228284_7_, p_228284_8_);
		this.parts().forEach((p_228285_4_) -> {p_228285_4_.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);});
	}

	private void setRotationAngles(OwlModel.State stateIn, int ticksExistedIn, float limbSwingIn, float limbSwingAmountIn, float ageInTicksIn, float netHeadYawIn, float headPitchIn) {
		this.beak.yRot = (float) Math.PI/4;
		this.head.xRot = headPitchIn * ((float) Math.PI / 180F);
		this.head.yRot = netHeadYawIn * ((float) Math.PI / 180F);
		this.head.zRot = 0.0F;
		
		this.head.x = 0.0F;
		this.body.x = 0.0F;
		this.tail.x = 0.0F;
		
		this.wing_right.x = -2.0F;
		this.wing_left.x = 2.0F;
		
		switch (stateIn) {
		case SITTING:
			break;
		case PARTY:
			float f = Mth.cos(ticksExistedIn);
			float f1 = Mth.sin(ticksExistedIn);
			this.head.x = f;
			this.head.y = 15.69F + f1;
			
			this.head.xRot = 0.0F;
			this.head.yRot = 0.0F;
			this.head.zRot = Mth.sin(ticksExistedIn) * 0.4F;
			
			this.body.x = f;
			this.body.y = 16.5F + f1;
			
			this.wing_left.zRot = -0.0873F - ageInTicksIn;
			this.wing_left.x = 2.0F + f;
			this.wing_left.y = 16.94F + f1;
			
			this.wing_right.zRot = 0.0873F + ageInTicksIn;
			this.wing_right.x = -2.0F + f;
			this.wing_right.y = 16.94F + f1;
			
			this.tail.x = f;
			this.tail.y = 21.07F + f1;
			break;
		case STANDING:
			this.leg_left.xRot += Mth.cos(limbSwingIn * 0.6662F) * 1.4F * limbSwingAmountIn;
			this.leg_right.xRot += Mth.cos(limbSwingIn * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmountIn;
		case FLYING:
		case ON_SHOULDER:
		default:
			float f2 = ageInTicksIn * 0.3F;
			this.head.y = 15.69F + f2;
			
			this.tail.xRot = 1.015F + Mth.cos(limbSwingIn * 0.6662F) * 0.3F * limbSwingAmountIn;
			this.tail.y = 21.07F + f2;
			
			this.body.y = 16.5F + f2;
			
			this.wing_left.zRot = -0.0873F - ageInTicksIn;
			this.wing_left.y = 16.94F + f2;
			
			this.wing_right.zRot = 0.0873F + ageInTicksIn;
			this.wing_right.y = 16.94F + f2;
			
			this.leg_left.y = 22.0F + f2;
			this.leg_right.y = 22.0F + f2;
		}
	}

	private void setLivingAnimations(OwlModel.State p_217160_1_) {
		this.body.xRot = 0.25F;
		
		this.wing_left.xRot = -0.5F;
		this.wing_left.yRot = -(float) Math.PI;
		
		this.wing_right.xRot = -0.5F;
		this.wing_right.yRot = -(float) Math.PI;
		
		this.leg_left.xRot = -0.0299F;
		this.leg_right.xRot = -0.0299F;
		
		this.leg_left.y = 22.0F;
		this.leg_right.y = 22.0F;
		
		this.leg_left.zRot = 0.0F;
		this.leg_right.zRot = 0.0F;
		
		switch (p_217160_1_) {
		case SITTING:
			this.head.y = 17.59F;
			this.tail.xRot = 1.5388988F;
			this.tail.y = 22.97F;
			this.body.y = 18.4F;
			
			this.wing_left.zRot = -0.0873F;
			this.wing_left.y = 18.84F;
			
			this.wing_right.zRot = 0.0873F;
			this.wing_right.y = 18.84F;
			
			++this.leg_left.y;
			++this.leg_right.y;
			++this.leg_left.xRot;
			++this.leg_right.xRot;
			break;
		case PARTY:
			this.leg_left.zRot = -0.34906584F;
			this.leg_right.zRot = 0.34906584F;
		case STANDING:
		case ON_SHOULDER:
		default:
			break;
		case FLYING:
			this.leg_left.xRot += 0.6981317F;
			this.leg_right.xRot += 0.6981317F;
		}
		this.beak.visible = true;
	}

	private static OwlModel.State getParrotState(Owl entityIn) {
		if (entityIn.isPartying()) {
			return OwlModel.State.PARTY;
		} else if (entityIn.isInSittingPose()) {
			return OwlModel.State.SITTING;
		} else {
			return entityIn.isFlying() ? OwlModel.State.FLYING : OwlModel.State.STANDING;
		}
	}

	public static enum State {
		FLYING, STANDING, SITTING, PARTY, ON_SHOULDER;
	}
}