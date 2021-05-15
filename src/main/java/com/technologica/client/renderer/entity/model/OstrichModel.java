package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class OstrichModel<T extends AbstractHorseEntity> extends AgeableModel<T> {
	protected final ModelRenderer body;
	protected final ModelRenderer neck;
	protected final ModelRenderer head;
	protected final ModelRenderer mane;
	protected final ModelRenderer nose;
	private final ModelRenderer leftEar;
	private final ModelRenderer rightEar;
	private final ModelRenderer backLeftLeg;
	private final ModelRenderer backRightLeg;
	private final ModelRenderer frontLeftLeg;
	private final ModelRenderer frontRightLeg;
	private final ModelRenderer babyBackLeftLeg;
	private final ModelRenderer babyBackRightLeg;
	private final ModelRenderer babyFrontLeftLeg;
	private final ModelRenderer babyFrontRightLeg;
	private final ModelRenderer tail;
	private final ModelRenderer saddle;
	private final ModelRenderer leftBit;
	private final ModelRenderer rightBit;
	private final ModelRenderer headBridle;
	private final ModelRenderer noseBridle;
	private final ModelRenderer leftReign;
	private final ModelRenderer rightReign;
	private final ModelRenderer[] saddles;
	private final ModelRenderer[] reigns;

	public OstrichModel(float p_i51065_1_) {
		super(true, 16.2F, 1.36F, 2.7272F, 2.0F, 20.0F);
		
		this.textureWidth = 64;
		this.textureHeight = 64;

		this.body = new ModelRenderer(this, 0, 32);
		this.body.addBox(-5.0F, -8.0F, -17.0F, 10.0F, 10.0F, 22.0F, 0.05F);
		this.body.setRotationPoint(0.0F, 11.0F, 5.0F);
		
		this.neck = new ModelRenderer(this, 0, 35);
		this.neck.addBox(-2.05F, -6.0F, -2.0F, 4.0F, 12.0F, 7.0F);
		this.neck.rotateAngleX = ((float) Math.PI / 6F);
		
		this.mane = new ModelRenderer(this, 56, 36);
		this.mane.addBox(-1.0F, -11.0F, 5.01F, 2.0F, 16.0F, 2.0F, p_i51065_1_);
		this.neck.addChild(this.mane);
		
		this.head = new ModelRenderer(this, 0, 13);
		this.head.addBox(-3.0F, -11.0F, -2.0F, 6.0F, 5.0F, 7.0F, p_i51065_1_);
		this.neck.addChild(this.head);
		
		this.nose = new ModelRenderer(this, 0, 25);
		this.nose.addBox(-2.0F, -11.0F, -7.0F, 4.0F, 5.0F, 5.0F, p_i51065_1_);
		this.neck.addChild(this.nose);
		
		this.leftEar = new ModelRenderer(this, 19, 16);
		this.leftEar.addBox(0.55F, -13.0F, 4.0F, 2.0F, 3.0F, 1.0F, -0.001F);
		this.neck.addChild(this.leftEar);
		
		this.rightEar = new ModelRenderer(this, 19, 16);
		this.rightEar.addBox(-2.55F, -13.0F, 4.0F, 2.0F, 3.0F, 1.0F, -0.001F);
		this.neck.addChild(this.rightEar);
		
		this.backLeftLeg = new ModelRenderer(this, 48, 21);
		this.backLeftLeg.mirror = true;
		this.backLeftLeg.addBox(-3.0F, -1.01F, -1.0F, 4.0F, 11.0F, 4.0F, p_i51065_1_);
		this.backLeftLeg.setRotationPoint(4.0F, 14.0F, 7.0F);
		
		this.backRightLeg = new ModelRenderer(this, 48, 21);
		this.backRightLeg.addBox(-1.0F, -1.01F, -1.0F, 4.0F, 11.0F, 4.0F, p_i51065_1_);
		this.backRightLeg.setRotationPoint(-4.0F, 14.0F, 7.0F);
		
		this.frontLeftLeg = new ModelRenderer(this, 48, 21);
		this.frontLeftLeg.mirror = true;
		this.frontLeftLeg.addBox(-3.0F, -1.01F, -1.9F, 4.0F, 11.0F, 4.0F, p_i51065_1_);
		this.frontLeftLeg.setRotationPoint(4.0F, 6.0F, -12.0F);
		
		this.frontRightLeg = new ModelRenderer(this, 48, 21);
		this.frontRightLeg.addBox(-1.0F, -1.01F, -1.9F, 4.0F, 11.0F, 4.0F, p_i51065_1_);
		this.frontRightLeg.setRotationPoint(-4.0F, 6.0F, -12.0F);
		
		this.tail = new ModelRenderer(this, 42, 36);
		this.tail.addBox(-1.5F, 0.0F, 0.0F, 3.0F, 14.0F, 4.0F, p_i51065_1_);
		this.tail.setRotationPoint(0.0F, -5.0F, 2.0F);
		this.tail.rotateAngleX = ((float) Math.PI / 6F);
		this.body.addChild(this.tail);
		
		this.babyBackLeftLeg = new ModelRenderer(this, 48, 21);
		this.babyBackLeftLeg.mirror = true;
		this.babyBackLeftLeg.addBox(-3.0F, -1.01F, -1.0F, 4.0F, 11.0F, 4.0F, p_i51065_1_, p_i51065_1_ + 5.5F, p_i51065_1_);
		this.babyBackLeftLeg.setRotationPoint(4.0F, 14.0F, 7.0F);
		
		this.babyBackRightLeg = new ModelRenderer(this, 48, 21);
		this.babyBackRightLeg.addBox(-1.0F, -1.01F, -1.0F, 4.0F, 11.0F, 4.0F, p_i51065_1_, p_i51065_1_ + 5.5F, p_i51065_1_);
		this.babyBackRightLeg.setRotationPoint(-4.0F, 14.0F, 7.0F);
		
		this.babyFrontLeftLeg = new ModelRenderer(this, 48, 21);
		this.babyFrontLeftLeg.mirror = true;
		this.babyFrontLeftLeg.addBox(-3.0F, -1.01F, -1.9F, 4.0F, 11.0F, 4.0F, p_i51065_1_, p_i51065_1_ + 5.5F, p_i51065_1_);
		this.babyFrontLeftLeg.setRotationPoint(4.0F, 6.0F, -12.0F);
		
		this.babyFrontRightLeg = new ModelRenderer(this, 48, 21);
		this.babyFrontRightLeg.addBox(-1.0F, -1.01F, -1.9F, 4.0F, 11.0F, 4.0F, p_i51065_1_, p_i51065_1_ + 5.5F, p_i51065_1_);
		this.babyFrontRightLeg.setRotationPoint(-4.0F, 6.0F, -12.0F);
		
		this.saddle = new ModelRenderer(this, 26, 0);
		this.saddle.addBox(-5.0F, -8.0F, -9.0F, 10.0F, 9.0F, 9.0F, 0.5F);
		this.body.addChild(this.saddle);
		
		this.headBridle = new ModelRenderer(this, 1, 1);
		this.headBridle.addBox(-3.0F, -11.0F, -1.9F, 6.0F, 5.0F, 6.0F, 0.2F);
		this.neck.addChild(this.headBridle);
		
		this.noseBridle = new ModelRenderer(this, 19, 0);
		this.noseBridle.addBox(-2.0F, -11.0F, -4.0F, 4.0F, 5.0F, 2.0F, 0.2F);
		this.neck.addChild(this.noseBridle);
		
		this.leftBit = new ModelRenderer(this, 29, 5);
		this.leftBit.addBox(2.0F, -9.0F, -6.0F, 1.0F, 2.0F, 2.0F, p_i51065_1_);
		this.neck.addChild(this.leftBit);
		
		this.rightBit = new ModelRenderer(this, 29, 5);
		this.rightBit.addBox(-3.0F, -9.0F, -6.0F, 1.0F, 2.0F, 2.0F, p_i51065_1_);
		this.neck.addChild(this.rightBit);
		
		this.leftReign = new ModelRenderer(this, 32, 2);
		this.leftReign.addBox(3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F, p_i51065_1_);
		this.leftReign.rotateAngleX = (-(float) Math.PI / 6F);
		this.neck.addChild(this.leftReign);
		
		this.rightReign = new ModelRenderer(this, 32, 2);
		this.rightReign.addBox(-3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F, p_i51065_1_);
		this.rightReign.rotateAngleX = (-(float) Math.PI / 6F);
		this.neck.addChild(this.rightReign);
		
		this.saddles = new ModelRenderer[] { this.saddle, this.headBridle, this.noseBridle, this.leftBit, this.rightBit };
		this.reigns = new ModelRenderer[] { this.leftReign, this.rightReign };
	}

	public Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of(this.neck);
	}

	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.body, this.backLeftLeg, this.backRightLeg, this.frontLeftLeg, this.frontRightLeg, this.babyBackLeftLeg, this.babyBackRightLeg, this.babyFrontLeftLeg, this.babyFrontRightLeg);
	}

	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netneckYaw, float neckPitch) {
		boolean flag = entityIn.isHorseSaddled();
		boolean flag1 = entityIn.isBeingRidden();
		for (ModelRenderer modelrenderer : this.saddles) {
			modelrenderer.showModel = flag;
		}
		for (ModelRenderer modelrenderer1 : this.reigns) {
			modelrenderer1.showModel = flag1 && flag;
		}
		this.body.rotationPointY = 11.0F;
	}

	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
		float f = MathHelper.interpolateAngle(entityIn.prevRenderYawOffset, entityIn.renderYawOffset, partialTick);
		float f1 = MathHelper.interpolateAngle(entityIn.prevRotationYawHead, entityIn.rotationYawHead, partialTick);
		float f2 = MathHelper.lerp(partialTick, entityIn.prevRotationPitch, entityIn.rotationPitch);
		float f3 = f1 - f;
		float f4 = f2 * ((float) Math.PI / 180F);
		if (f3 > 20.0F) {
			f3 = 20.0F;
		}
		if (f3 < -20.0F) {
			f3 = -20.0F;
		}
		if (limbSwingAmount > 0.2F) {
			f4 += MathHelper.cos(limbSwing * 0.4F) * 0.15F * limbSwingAmount;
		}
		float f5 = entityIn.getGrassEatingAmount(partialTick);
		float f6 = entityIn.getRearingAmount(partialTick);
		float f7 = 1.0F - f6;
		float f8 = entityIn.getMouthOpennessAngle(partialTick);
		boolean flag = entityIn.tailCounter != 0;
		float f9 = (float) entityIn.ticksExisted + partialTick;
		this.neck.rotationPointY = 4.0F;
		this.neck.rotationPointZ = -12.0F;
		this.body.rotateAngleX = 0.0F;
		this.neck.rotateAngleX = ((float) Math.PI / 6F) + f4;
		this.neck.rotateAngleY = f3 * ((float) Math.PI / 180F);
		float f10 = entityIn.isInWater() ? 0.2F : 1.0F;
		float f11 = MathHelper.cos(f10 * limbSwing * 0.6662F + (float) Math.PI);
		float f12 = f11 * 0.8F * limbSwingAmount;
		float f13 = (1.0F - Math.max(f6, f5)) * (((float) Math.PI / 6F) + f4 + f8 * MathHelper.sin(f9) * 0.05F);
		this.neck.rotateAngleX = f6 * (0.2617994F + f4) + f5 * (2.1816616F + MathHelper.sin(f9) * 0.05F) + f13;
		this.neck.rotateAngleY = f6 * f3 * ((float) Math.PI / 180F) + (1.0F - Math.max(f6, f5)) * this.neck.rotateAngleY;
		this.neck.rotationPointY = f6 * -4.0F + f5 * 11.0F + (1.0F - Math.max(f6, f5)) * this.neck.rotationPointY;
		this.neck.rotationPointZ = f6 * -4.0F + f5 * -12.0F + (1.0F - Math.max(f6, f5)) * this.neck.rotationPointZ;
		this.body.rotateAngleX = f6 * (-(float) Math.PI / 4F) + f7 * this.body.rotateAngleX;
		float f14 = 0.2617994F * f6;
		float f15 = MathHelper.cos(f9 * 0.6F + (float) Math.PI);
		this.frontLeftLeg.rotationPointY = 2.0F * f6 + 14.0F * f7;
		this.frontLeftLeg.rotationPointZ = -6.0F * f6 - 10.0F * f7;
		this.frontRightLeg.rotationPointY = this.frontLeftLeg.rotationPointY;
		this.frontRightLeg.rotationPointZ = this.frontLeftLeg.rotationPointZ;
		float f16 = ((-(float) Math.PI / 3F) + f15) * f6 + f12 * f7;
		float f17 = ((-(float) Math.PI / 3F) - f15) * f6 - f12 * f7;
		this.backLeftLeg.rotateAngleX = f14 - f11 * 0.5F * limbSwingAmount * f7;
		this.backRightLeg.rotateAngleX = f14 + f11 * 0.5F * limbSwingAmount * f7;
		this.frontLeftLeg.rotateAngleX = f16;
		this.frontRightLeg.rotateAngleX = f17;
		this.tail.rotateAngleX = ((float) Math.PI / 6F) + limbSwingAmount * 0.75F;
		this.tail.rotationPointY = -5.0F + limbSwingAmount;
		this.tail.rotationPointZ = 2.0F + limbSwingAmount * 2.0F;
		if (flag) {
			this.tail.rotateAngleY = MathHelper.cos(f9 * 0.7F);
		} else {
			this.tail.rotateAngleY = 0.0F;
		}
		this.babyBackLeftLeg.rotationPointY = this.backLeftLeg.rotationPointY;
		this.babyBackLeftLeg.rotationPointZ = this.backLeftLeg.rotationPointZ;
		this.babyBackLeftLeg.rotateAngleX = this.backLeftLeg.rotateAngleX;
		this.babyBackRightLeg.rotationPointY = this.backRightLeg.rotationPointY;
		this.babyBackRightLeg.rotationPointZ = this.backRightLeg.rotationPointZ;
		this.babyBackRightLeg.rotateAngleX = this.backRightLeg.rotateAngleX;
		this.babyFrontLeftLeg.rotationPointY = this.frontLeftLeg.rotationPointY;
		this.babyFrontLeftLeg.rotationPointZ = this.frontLeftLeg.rotationPointZ;
		this.babyFrontLeftLeg.rotateAngleX = this.frontLeftLeg.rotateAngleX;
		this.babyFrontRightLeg.rotationPointY = this.frontRightLeg.rotationPointY;
		this.babyFrontRightLeg.rotationPointZ = this.frontRightLeg.rotationPointZ;
		this.babyFrontRightLeg.rotateAngleX = this.frontRightLeg.rotateAngleX;
		boolean flag1 = entityIn.isChild();
		this.backLeftLeg.showModel = !flag1;
		this.backRightLeg.showModel = !flag1;
		this.frontLeftLeg.showModel = !flag1;
		this.frontRightLeg.showModel = !flag1;
		this.babyBackLeftLeg.showModel = flag1;
		this.babyBackRightLeg.showModel = flag1;
		this.babyFrontLeftLeg.showModel = flag1;
		this.babyFrontRightLeg.showModel = flag1;
		this.body.rotationPointY = flag1 ? 10.8F : 0.0F;
	}
}
