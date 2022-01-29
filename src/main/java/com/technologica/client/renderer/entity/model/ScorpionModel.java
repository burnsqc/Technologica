package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import com.technologica.entity.passive.ScorpionEntity;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ScorpionModel<T extends Entity> extends SegmentedModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer tail1;
	private final ModelRenderer tail2;
	private final ModelRenderer tail3;
	private final ModelRenderer tail4;
	private final ModelRenderer tail5;
	private final ModelRenderer tail6;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;
	private final ModelRenderer leg4;
	private final ModelRenderer leg5;
	private final ModelRenderer leg6;
	private final ModelRenderer leg7;
	private final ModelRenderer leg8;
	private final ModelRenderer armRight;
	private final ModelRenderer armLeft;
	private final ModelRenderer clawRight;
	private final ModelRenderer clawLeft;
	private final ModelRenderer pincherRightInner;
	private final ModelRenderer pincherRightOuter;
	private final ModelRenderer pincherLeftInner;
	private final ModelRenderer pincherLeftOuter;

	public ScorpionModel() {
		this.textureWidth = 64;
		this.textureHeight = 64;

		this.body = new ModelRenderer(this, 0, 0);
		this.body.setRotationPoint(0.0F, 15.0F, -3.0F);
		this.body.addBox(-4.0F, -2.0F, -2.0F, 8.0F, 4.0F, 16.0F);

		this.tail1 = new ModelRenderer(this);
		this.tail1.setRotationPoint(0.0F, 0.0F, 12.0F);
		this.tail1.setTextureOffset(0, 20).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 8.0F, 0.0F);
		this.body.addChild(this.tail1);

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.0F, 2.0F, 8.0F);
		tail2.setTextureOffset(24, 20).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 3.0F, 8.0F);
		this.tail1.addChild(tail2);

		tail3 = new ModelRenderer(this);
		tail3.setRotationPoint(0.0F, 0.0F, 8.0F);
		tail3.setTextureOffset(24, 20).addBox(-1.49F, -3.0F, 0.0F, 2.98F, 2.98F, 8.0F);
		tail2.addChild(tail3);

		tail4 = new ModelRenderer(this);
		tail4.setRotationPoint(0.0F, 0.0F, 8.0F);
		tail4.setTextureOffset(32, 0).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 8.0F);
		tail3.addChild(tail4);
		
		tail5 = new ModelRenderer(this);
		tail5.setRotationPoint(0.0F, 0.0F, 8.0F);
		tail5.setTextureOffset(0, 0).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 3.0F, 3.0F);
		tail4.addChild(tail5);
		
		tail6 = new ModelRenderer(this);
		tail6.setTextureOffset(9, 0).addBox(-0.5F, -3.0F, 3.0F, 1.0F, 1.0F, 2.0F);
		tail5.addChild(tail6);

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(-4.0F, 15.0F, 2.0F);
		leg1.setTextureOffset(0, 32).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(4.0F, 15.0F, 2.0F);
		leg2.setTextureOffset(0, 32).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(-4.0F, 15.0F, 1.0F);
		leg3.setTextureOffset(0, 32).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(4.0F, 15.0F, 1.0F);
		leg4.setTextureOffset(0, 32).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

		leg5 = new ModelRenderer(this);
		leg5.setRotationPoint(-4.0F, 15.0F, 0.0F);
		leg5.setTextureOffset(0, 32).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

		leg6 = new ModelRenderer(this);
		leg6.setRotationPoint(4.0F, 15.0F, 0.0F);
		leg6.setTextureOffset(0, 32).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

		leg7 = new ModelRenderer(this);
		leg7.setRotationPoint(-4.0F, 15.0F, -1.0F);
		leg7.setTextureOffset(0, 32).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

		leg8 = new ModelRenderer(this);
		leg8.setRotationPoint(4.0F, 15.0F, -1.0F);
		leg8.setTextureOffset(0, 32).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

		this.armLeft = new ModelRenderer(this, 32, 10);
		this.armLeft.setRotationPoint(2.0F, 0.0F, 0.0F);
		this.armLeft.addBox(0.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F);
		this.body.addChild(this.armLeft);
		
		this.armRight = new ModelRenderer(this, 32, 10);
		this.armRight.setRotationPoint(-2.0F, 0.0F, 0.0F);
		this.armRight.addBox(-8.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F);
		this.body.addChild(this.armRight);
		
		this.clawLeft = new ModelRenderer(this, 0, 6);
		this.clawLeft.setRotationPoint(7.0F, 0.0F, 0.0F);
		this.clawLeft.addBox(-1.0F, -1.5F, -2.0F, 4.0F, 3.0F, 4.0F);
		this.armLeft.addChild(this.clawLeft);
		
		this.clawRight = new ModelRenderer(this, 0 ,6);
		this.clawRight.setRotationPoint(-7.0F, 0.0F, 0.0F);
		this.clawRight.addBox(-3.0F, -1.5F, -2.0F, 4.0F, 3.0F, 4.0F);
		this.armRight.addChild(this.clawRight);
		
		this.pincherLeftInner = new ModelRenderer(this, 0, 13);
		this.pincherLeftInner.addBox(3.0F, -0.5F, -2.0F, 4.0F, 1.0F, 2.0F);
		this.clawLeft.addChild(this.pincherLeftInner);
		
		this.pincherLeftOuter = new ModelRenderer(this, 19, 20);
		this.pincherLeftOuter.setRotationPoint(3.0F, 0.0F, 2.0F);
		this.pincherLeftOuter.addBox(0.0F, -0.5F, -1.0F, 4.0F, 1.0F, 1.0F);
		this.clawLeft.addChild(this.pincherLeftOuter);
		
		this.pincherRightInner = new ModelRenderer(this, 0, 13);
		this.pincherRightInner.addBox(-7.0F, -0.5F, -2.0F, 4.0F, 1.0F, 2.0F);
		this.clawRight.addChild(this.pincherRightInner);
		
		this.pincherRightOuter = new ModelRenderer(this, 19, 20);
		this.pincherRightOuter.addBox(-4.0F, -0.5F, -1.0F, 4.0F, 1.0F, 1.0F);
		this.pincherRightOuter.setRotationPoint(-3.0F, 0.0F, 2.0F);
		this.clawRight.addChild(this.pincherRightOuter);
	}

	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.body, this.leg1, this.leg2, this.leg3, this.leg4, this.leg5, this.leg6, this.leg7, this.leg8);
	}

	public void setRotationAngles(T entityIn, float limbSwingIn, float limbSwingAmountIn, float ageInTicksIn, float netHeadYawIn, float headPitchIn) {
		
		
		this.leg1.rotateAngleY = ((float) Math.PI / 4F);
		this.leg2.rotateAngleY = (-(float) Math.PI / 4F);
		this.leg3.rotateAngleY = ((float) Math.PI / 8F);
		this.leg4.rotateAngleY = (-(float) Math.PI / 8F);
		this.leg5.rotateAngleY = (-(float) Math.PI / 8F);
		this.leg6.rotateAngleY = ((float) Math.PI / 8F);
		this.leg7.rotateAngleY = (-(float) Math.PI / 4F);
		this.leg8.rotateAngleY = ((float) Math.PI / 4F);
		
		this.leg1.rotateAngleZ = -(float) Math.PI / 4;
		this.leg2.rotateAngleZ = (float) Math.PI / 4;
		this.leg3.rotateAngleZ = -0.58119464F;
		this.leg4.rotateAngleZ = 0.58119464F;
		this.leg5.rotateAngleZ = -0.58119464F;
		this.leg6.rotateAngleZ = 0.58119464F;
		this.leg7.rotateAngleZ = -(float) Math.PI / 4;
		this.leg8.rotateAngleZ = (float) Math.PI / 4;
		
		float f1 = -limbSwingAmountIn * 0.4F * MathHelper.cos(limbSwingIn * 1.3324F);
		float f2 = -limbSwingAmountIn * 0.4F * MathHelper.cos(limbSwingIn * 1.3324F + (float) Math.PI);
		float f3 = -limbSwingAmountIn * 0.4F * MathHelper.cos(limbSwingIn * 1.3324F + ((float) Math.PI * 0.5F));
		float f4 = -limbSwingAmountIn * 0.4F * MathHelper.cos(limbSwingIn * 1.3324F + ((float) Math.PI * 1.5F));
		
		this.leg1.rotateAngleY += f1;
		this.leg2.rotateAngleY += -f1;
		this.leg3.rotateAngleY += f2;
		this.leg4.rotateAngleY += -f2;
		this.leg5.rotateAngleY += f3;
		this.leg6.rotateAngleY += -f3;
		this.leg7.rotateAngleY += f4;
		this.leg8.rotateAngleY += -f4;
		
		float f5 = limbSwingAmountIn * 0.4F * Math.abs(MathHelper.sin(limbSwingIn * 0.6662F));
		float f6 = limbSwingAmountIn * 0.4F * Math.abs(MathHelper.sin(limbSwingIn * 0.6662F + (float) Math.PI));
		float f7 = limbSwingAmountIn * 0.4F * Math.abs(MathHelper.sin(limbSwingIn * 0.6662F + ((float) Math.PI * 0.5F)));
		float f8 = limbSwingAmountIn * 0.4F * Math.abs(MathHelper.sin(limbSwingIn * 0.6662F + ((float) Math.PI * 1.5F)));
		
		this.leg1.rotateAngleZ += f5;
		this.leg2.rotateAngleZ += -f5;
		this.leg3.rotateAngleZ += f6;
		this.leg4.rotateAngleZ += -f6;
		this.leg5.rotateAngleZ += f7;
		this.leg6.rotateAngleZ += -f7;
		this.leg7.rotateAngleZ += f8;
		this.leg8.rotateAngleZ += -f8;
	}

	@Override
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		boolean clawsClicking = ((ScorpionEntity) entityIn).clawCounter != 0;
		
		this.armLeft.rotateAngleY = (float) Math.PI / 4F;
		this.armRight.rotateAngleY = -(float) Math.PI / 4F;
		this.clawLeft.rotateAngleY = (float) Math.PI / 4F;
		this.clawRight.rotateAngleY = -(float) Math.PI / 4F;
		
		this.tail1.rotateAngleX = (float) Math.PI / 4;
		this.tail2.rotateAngleX = (float) Math.PI / 4;
		this.tail3.rotateAngleX = (float) Math.PI / 4;
		this.tail4.rotateAngleX = (float) Math.PI / 4;
		this.tail5.rotateAngleX = (float) Math.PI / 4;
		
		float f9 = limbSwingAmount * 0.03F * MathHelper.cos(limbSwing);
		float f10 = ((ScorpionEntity) entityIn).prevSwingProgress;
		float f11 = ((ScorpionEntity) entityIn).swingProgress;
		float f12 = f10 + (f11-f10) * partialTick;
		if (f10 > 0) {
			this.tail1.rotateAngleX += f12;
			this.tail2.rotateAngleX += f12;
			this.tail3.rotateAngleX -= f12;
			this.tail4.rotateAngleX -= f12;
			this.tail5.rotateAngleX -= f12;
		} else {
			this.tail1.rotateAngleX += f9;
			this.tail2.rotateAngleX += f9;
			this.tail3.rotateAngleX += f9;
			this.tail4.rotateAngleX += f9;
			this.tail5.rotateAngleX += f9;
		}	
		
		if (clawsClicking || ((ScorpionEntity) entityIn).isAggressive()) {
			this.pincherLeftOuter.rotateAngleY = 0.25F * MathHelper.cos((float) (entityIn.ticksExisted + partialTick) / 2) * MathHelper.cos((float) (entityIn.ticksExisted + partialTick) / 2);
			this.pincherRightOuter.rotateAngleY = -0.25F * MathHelper.cos((float) (entityIn.ticksExisted + partialTick) / 2) * MathHelper.cos((float) (entityIn.ticksExisted + partialTick) / 2);
		} else {
			this.pincherLeftOuter.rotateAngleY = 0.0F;
			this.pincherRightOuter.rotateAngleY = 0.0F;
		}
		
		if (((ScorpionEntity) entityIn).isAggressive()) {
			this.armLeft.rotateAngleY += 0.25F * MathHelper.cos((float) (entityIn.ticksExisted + partialTick) / 2);
			this.clawLeft.rotateAngleY += 0.25F * MathHelper.cos((float) (entityIn.ticksExisted + partialTick - Math.PI) / 2);
			this.armRight.rotateAngleY -= 0.25F * MathHelper.cos((float) (entityIn.ticksExisted + partialTick + Math.PI) / 2);
			this.clawRight.rotateAngleY -= 0.25F * MathHelper.cos((float) (entityIn.ticksExisted + partialTick) / 2);
		}
	}
}