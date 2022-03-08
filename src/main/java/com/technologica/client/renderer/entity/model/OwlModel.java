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
		this.textureWidth = 32;
		this.textureHeight = 16;
		
		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-2.0F, 0.0F, -1.5F, 4.0F, 6.0F, 4.0F);
		this.body.setRotationPoint(0.0F, 16.5F, -3.0F);
		
		this.tail = new ModelRenderer(this, 0, 10);
		this.tail.addBox(-1.5F, -1.0F, -1.0F, 3.0F, 4.0F, 1.0F);
		this.tail.setRotationPoint(0.0F, 21.07F, 1.16F);
		
		this.wingLeft = new ModelRenderer(this, 12, 7);
		this.wingLeft.addBox(-0.5F, 0.0F, -1.5F, 1.0F, 5.0F, 4.0F);
		this.wingLeft.setRotationPoint(2.0F, 16.94F, -1.76F);
		
		this.wingRight = new ModelRenderer(this, 12, 7);
		this.wingRight.addBox(-0.5F, 0.0F, -1.5F, 1.0F, 5.0F, 4.0F);
		this.wingRight.setRotationPoint(-2.0F, 16.94F, -1.76F);
		
		this.head = new ModelRenderer(this, 16, 0);
		this.head.addBox(-1.5F, -2.0F, -1.5F, 3.0F, 4.0F, 3.0F);
		this.head.setRotationPoint(0.0F, 15.69F, -2.26F);
		
		this.beak = new ModelRenderer(this, 0, 0);
		this.beak.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F);
		this.beak.setRotationPoint(0.0F, 0.0F, -1.5F);
		this.head.addChild(this.beak);
		
		this.legLeft = new ModelRenderer(this, 12, 0);
		this.legLeft.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F);
		this.legLeft.setRotationPoint(1.0F, 22.0F, -1.05F);
		
		this.legRight = new ModelRenderer(this, 12, 0);
		this.legRight.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F);
		this.legRight.setRotationPoint(-1.0F, 22.0F, -1.05F);
	}

	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.body, this.wingLeft, this.wingRight, this.tail, this.head, this.legLeft, this.legRight);
	}

	public void setRotationAngles(OwlEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.setRotationAngles(getParrotState(entityIn), entityIn.ticksExisted, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
	}

	public void setLivingAnimations(OwlEntity entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		this.setLivingAnimations(getParrotState(entityIn));
	}

	public void renderOnShoulder(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float p_228284_5_, float p_228284_6_, float p_228284_7_, float p_228284_8_, int p_228284_9_) {
		this.setLivingAnimations(OwlModel.State.ON_SHOULDER);
		this.setRotationAngles(OwlModel.State.ON_SHOULDER, p_228284_9_, p_228284_5_, p_228284_6_, 0.0F, p_228284_7_, p_228284_8_);
		this.getParts().forEach((p_228285_4_) -> {p_228285_4_.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);});
	}

	private void setRotationAngles(OwlModel.State stateIn, int ticksExistedIn, float limbSwingIn, float limbSwingAmountIn, float ageInTicksIn, float netHeadYawIn, float headPitchIn) {
		this.beak.rotateAngleY = (float) Math.PI/4;
		this.head.rotateAngleX = headPitchIn * ((float) Math.PI / 180F);
		this.head.rotateAngleY = netHeadYawIn * ((float) Math.PI / 180F);
		this.head.rotateAngleZ = 0.0F;
		
		this.head.rotationPointX = 0.0F;
		this.body.rotationPointX = 0.0F;
		this.tail.rotationPointX = 0.0F;
		
		this.wingRight.rotationPointX = -2.0F;
		this.wingLeft.rotationPointX = 2.0F;
		
		switch (stateIn) {
		case SITTING:
			break;
		case PARTY:
			float f = MathHelper.cos((float) ticksExistedIn);
			float f1 = MathHelper.sin((float) ticksExistedIn);
			this.head.rotationPointX = f;
			this.head.rotationPointY = 15.69F + f1;
			
			this.head.rotateAngleX = 0.0F;
			this.head.rotateAngleY = 0.0F;
			this.head.rotateAngleZ = MathHelper.sin((float) ticksExistedIn) * 0.4F;
			
			this.body.rotationPointX = f;
			this.body.rotationPointY = 16.5F + f1;
			
			this.wingLeft.rotateAngleZ = -0.0873F - ageInTicksIn;
			this.wingLeft.rotationPointX = 2.0F + f;
			this.wingLeft.rotationPointY = 16.94F + f1;
			
			this.wingRight.rotateAngleZ = 0.0873F + ageInTicksIn;
			this.wingRight.rotationPointX = -2.0F + f;
			this.wingRight.rotationPointY = 16.94F + f1;
			
			this.tail.rotationPointX = f;
			this.tail.rotationPointY = 21.07F + f1;
			break;
		case STANDING:
			this.legLeft.rotateAngleX += MathHelper.cos(limbSwingIn * 0.6662F) * 1.4F * limbSwingAmountIn;
			this.legRight.rotateAngleX += MathHelper.cos(limbSwingIn * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmountIn;
		case FLYING:
		case ON_SHOULDER:
		default:
			float f2 = ageInTicksIn * 0.3F;
			this.head.rotationPointY = 15.69F + f2;
			
			this.tail.rotateAngleX = 1.015F + MathHelper.cos(limbSwingIn * 0.6662F) * 0.3F * limbSwingAmountIn;
			this.tail.rotationPointY = 21.07F + f2;
			
			this.body.rotationPointY = 16.5F + f2;
			
			this.wingLeft.rotateAngleZ = -0.0873F - ageInTicksIn;
			this.wingLeft.rotationPointY = 16.94F + f2;
			
			this.wingRight.rotateAngleZ = 0.0873F + ageInTicksIn;
			this.wingRight.rotationPointY = 16.94F + f2;
			
			this.legLeft.rotationPointY = 22.0F + f2;
			this.legRight.rotationPointY = 22.0F + f2;
		}
	}

	private void setLivingAnimations(OwlModel.State p_217160_1_) {
		this.body.rotateAngleX = 0.25F;
		
		this.wingLeft.rotateAngleX = -0.5F;
		this.wingLeft.rotateAngleY = -(float) Math.PI;
		
		this.wingRight.rotateAngleX = -0.5F;
		this.wingRight.rotateAngleY = -(float) Math.PI;
		
		this.legLeft.rotateAngleX = -0.0299F;
		this.legRight.rotateAngleX = -0.0299F;
		
		this.legLeft.rotationPointY = 22.0F;
		this.legRight.rotationPointY = 22.0F;
		
		this.legLeft.rotateAngleZ = 0.0F;
		this.legRight.rotateAngleZ = 0.0F;
		
		switch (p_217160_1_) {
		case SITTING:
			this.head.rotationPointY = 17.59F;
			this.tail.rotateAngleX = 1.5388988F;
			this.tail.rotationPointY = 22.97F;
			this.body.rotationPointY = 18.4F;
			
			this.wingLeft.rotateAngleZ = -0.0873F;
			this.wingLeft.rotationPointY = 18.84F;
			
			this.wingRight.rotateAngleZ = 0.0873F;
			this.wingRight.rotationPointY = 18.84F;
			
			++this.legLeft.rotationPointY;
			++this.legRight.rotationPointY;
			++this.legLeft.rotateAngleX;
			++this.legRight.rotateAngleX;
			break;
		case PARTY:
			this.legLeft.rotateAngleZ = -0.34906584F;
			this.legRight.rotateAngleZ = 0.34906584F;
		case STANDING:
		case ON_SHOULDER:
		default:
			break;
		case FLYING:
			this.legLeft.rotateAngleX += 0.6981317F;
			this.legRight.rotateAngleX += 0.6981317F;
		}
		this.beak.showModel = true;
	}

	private static OwlModel.State getParrotState(OwlEntity entityIn) {
		if (entityIn.isPartying()) {
			return OwlModel.State.PARTY;
		} else if (entityIn.isEntitySleeping()) {
			return OwlModel.State.SITTING;
		} else {
			return entityIn.isFlying() ? OwlModel.State.FLYING : OwlModel.State.STANDING;
		}
	}

	public static enum State {
		FLYING, STANDING, SITTING, PARTY, ON_SHOULDER;
	}
}