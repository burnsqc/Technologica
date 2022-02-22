package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.technologica.entity.passive.OwlEntity;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class OwlModel<T extends OwlEntity> extends SegmentedModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer tail;
	private final ModelRenderer wingLeft;
	private final ModelRenderer wingRight;
	private final ModelRenderer head;
	private final ModelRenderer beak;
	private final ModelRenderer legLeft;
	private final ModelRenderer legRight;

	public OwlModel() {
		this.texWidth = 32;
		this.texHeight = 16;
		
		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-2.0F, 0.0F, -1.5F, 4.0F, 6.0F, 4.0F);
		this.body.setPos(0.0F, 16.5F, -3.0F);
		
		this.tail = new ModelRenderer(this, 0, 10);
		this.tail.addBox(-1.5F, -1.0F, -1.0F, 3.0F, 4.0F, 1.0F);
		this.tail.setPos(0.0F, 21.07F, 1.16F);
		
		this.wingLeft = new ModelRenderer(this, 12, 7);
		this.wingLeft.addBox(-0.5F, 0.0F, -1.5F, 1.0F, 5.0F, 4.0F);
		this.wingLeft.setPos(2.0F, 16.94F, -1.76F);
		
		this.wingRight = new ModelRenderer(this, 12, 7);
		this.wingRight.addBox(-0.5F, 0.0F, -1.5F, 1.0F, 5.0F, 4.0F);
		this.wingRight.setPos(-2.0F, 16.94F, -1.76F);
		
		this.head = new ModelRenderer(this, 16, 0);
		this.head.addBox(-1.5F, -2.0F, -1.5F, 3.0F, 4.0F, 3.0F);
		this.head.setPos(0.0F, 15.69F, -2.26F);
		
		this.beak = new ModelRenderer(this, 0, 0);
		this.beak.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F);
		this.beak.setPos(0.0F, 0.0F, -1.5F);
		this.head.addChild(this.beak);
		
		this.legLeft = new ModelRenderer(this, 12, 0);
		this.legLeft.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F);
		this.legLeft.setPos(1.0F, 22.0F, -1.05F);
		
		this.legRight = new ModelRenderer(this, 12, 0);
		this.legRight.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F);
		this.legRight.setPos(-1.0F, 22.0F, -1.05F);
	}

	public Iterable<ModelRenderer> parts() {
		return ImmutableList.of(this.body, this.wingLeft, this.wingRight, this.tail, this.head, this.legLeft, this.legRight);
	}

	public void setupAnim(OwlEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.setRotationAngles(getParrotState(entityIn), entityIn.tickCount, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
	}

	public void prepareMobModel(OwlEntity entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		this.setLivingAnimations(getParrotState(entityIn));
	}

	public void renderOnShoulder(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float p_228284_5_, float p_228284_6_, float p_228284_7_, float p_228284_8_, int p_228284_9_) {
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
		
		this.wingRight.x = -2.0F;
		this.wingLeft.x = 2.0F;
		
		switch (stateIn) {
		case SITTING:
			break;
		case PARTY:
			float f = MathHelper.cos((float) ticksExistedIn);
			float f1 = MathHelper.sin((float) ticksExistedIn);
			this.head.x = f;
			this.head.y = 15.69F + f1;
			
			this.head.xRot = 0.0F;
			this.head.yRot = 0.0F;
			this.head.zRot = MathHelper.sin((float) ticksExistedIn) * 0.4F;
			
			this.body.x = f;
			this.body.y = 16.5F + f1;
			
			this.wingLeft.zRot = -0.0873F - ageInTicksIn;
			this.wingLeft.x = 2.0F + f;
			this.wingLeft.y = 16.94F + f1;
			
			this.wingRight.zRot = 0.0873F + ageInTicksIn;
			this.wingRight.x = -2.0F + f;
			this.wingRight.y = 16.94F + f1;
			
			this.tail.x = f;
			this.tail.y = 21.07F + f1;
			break;
		case STANDING:
			this.legLeft.xRot += MathHelper.cos(limbSwingIn * 0.6662F) * 1.4F * limbSwingAmountIn;
			this.legRight.xRot += MathHelper.cos(limbSwingIn * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmountIn;
		case FLYING:
		case ON_SHOULDER:
		default:
			float f2 = ageInTicksIn * 0.3F;
			this.head.y = 15.69F + f2;
			
			this.tail.xRot = 1.015F + MathHelper.cos(limbSwingIn * 0.6662F) * 0.3F * limbSwingAmountIn;
			this.tail.y = 21.07F + f2;
			
			this.body.y = 16.5F + f2;
			
			this.wingLeft.zRot = -0.0873F - ageInTicksIn;
			this.wingLeft.y = 16.94F + f2;
			
			this.wingRight.zRot = 0.0873F + ageInTicksIn;
			this.wingRight.y = 16.94F + f2;
			
			this.legLeft.y = 22.0F + f2;
			this.legRight.y = 22.0F + f2;
		}
	}

	private void setLivingAnimations(OwlModel.State p_217160_1_) {
		this.body.xRot = 0.25F;
		
		this.wingLeft.xRot = -0.5F;
		this.wingLeft.yRot = -(float) Math.PI;
		
		this.wingRight.xRot = -0.5F;
		this.wingRight.yRot = -(float) Math.PI;
		
		this.legLeft.xRot = -0.0299F;
		this.legRight.xRot = -0.0299F;
		
		this.legLeft.y = 22.0F;
		this.legRight.y = 22.0F;
		
		this.legLeft.zRot = 0.0F;
		this.legRight.zRot = 0.0F;
		
		switch (p_217160_1_) {
		case SITTING:
			this.head.y = 17.59F;
			this.tail.xRot = 1.5388988F;
			this.tail.y = 22.97F;
			this.body.y = 18.4F;
			
			this.wingLeft.zRot = -0.0873F;
			this.wingLeft.y = 18.84F;
			
			this.wingRight.zRot = 0.0873F;
			this.wingRight.y = 18.84F;
			
			++this.legLeft.y;
			++this.legRight.y;
			++this.legLeft.xRot;
			++this.legRight.xRot;
			break;
		case PARTY:
			this.legLeft.zRot = -0.34906584F;
			this.legRight.zRot = 0.34906584F;
		case STANDING:
		case ON_SHOULDER:
		default:
			break;
		case FLYING:
			this.legLeft.xRot += 0.6981317F;
			this.legRight.xRot += 0.6981317F;
		}
		this.beak.visible = true;
	}

	private static OwlModel.State getParrotState(OwlEntity entityIn) {
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