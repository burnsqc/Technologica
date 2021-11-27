package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.util.math.MathHelper;

public class OstrichModel<T extends AbstractHorseEntity> extends AgeableModel<T> {
	protected final ModelRenderer body;
	protected final ModelRenderer leftWing;
	protected final ModelRenderer rightWing;
	protected final ModelRenderer neck;
	protected final ModelRenderer head;
	protected final ModelRenderer beak;

	private final ModelRenderer frontLeftLeg;
	private final ModelRenderer frontRightLeg;

	private final ModelRenderer topLeftLeg;
	private final ModelRenderer topRightLeg;
	private final ModelRenderer bottomLeftLeg;
	private final ModelRenderer bottomRightLeg;
	private final ModelRenderer LeftFoot;
	private final ModelRenderer RightFoot;
	private final ModelRenderer LeftToe;
	private final ModelRenderer RightToe;

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

	public OstrichModel() {
		super(true, 16.2F, 1.36F, 2.7272F, 2.0F, 20.0F);
		
		this.textureWidth = 64;
		this.textureHeight = 64;

		this.body = new ModelRenderer(this, 0, 50);
		this.body.addBox(-5.0F, -8.0F, -19.0F, 10.0F, 11.0F, 16.0F);
		this.body.setRotationPoint(0.0F, 11.0F, 5.0F);
		
		this.leftWing = new ModelRenderer(this, 0, 50);
		this.leftWing.mirror = true;
		this.leftWing.addBox(-6.0F, 3.0F, -14.0F, 1.0F, 6.0F, 14.0F);
		this.leftWing.setRotationPoint(0F, 0F, 0F);
		
		this.rightWing = new ModelRenderer(this, 0, 50);
		this.rightWing.addBox(5.0F, 3.0F, -14.0F, 1.0F, 6.0F, 14.0F);
		this.rightWing.setRotationPoint(0F, 0F, 0F);

		this.neck = new ModelRenderer(this, 52, 0);
		this.neck.addBox(-1.05F, -15.0F, -2.0F, 2.0F, 14.0F, 3.0F);

		this.head = new ModelRenderer(this, 0, 13);
		this.head.addBox(-2.0F, -17.0F, -4.0F, 4.0F, 3.0F, 5.0F);
		this.neck.addChild(this.head);
		
		this.beak = new ModelRenderer(this, 0, 25);
		this.beak.addBox(-1.0F, -15.0F, -6.0F, 2.0F, 1.0F, 5.0F);
		this.head.addChild(this.beak);
		
		this.frontLeftLeg = new ModelRenderer(this, 48, 27);
		this.frontLeftLeg.mirror = true;
		this.frontLeftLeg.addBox(-3.0F, -7.01F, 1.9F, 2.0F, 17.0F, 2.0F);
		this.frontLeftLeg.setRotationPoint(4.0F, 6.0F, -12.0F);
		
		this.frontRightLeg = new ModelRenderer(this, 48, 27);
		this.frontRightLeg.addBox(1.0F, -7.01F, 1.9F, 2.0F, 17.0F, 2.0F);
		this.frontRightLeg.setRotationPoint(-4.0F, 6.0F, -12.0F);

		this.topLeftLeg = new ModelRenderer(this, 0, 40);
		this.topLeftLeg.mirror = true;
		this.topLeftLeg.addBox(-2.0F, -7.01F, 1.9F, 2.0F, 8.0F, 2.0F);
		this.topLeftLeg.setRotationPoint(4.0F, 6.0F, -12.0F);
		
		this.topRightLeg = new ModelRenderer(this, 0, 40);
		this.topRightLeg.addBox(0.0F, -7.01F, 1.9F, 2.0F, 8.0F, 2.0F);
		this.topRightLeg.setRotationPoint(-4.0F, 6.0F, -12.0F);
		
		this.bottomLeftLeg = new ModelRenderer(this, 0, 40);
		this.bottomLeftLeg.mirror = true;
		this.bottomLeftLeg.addBox(-2.0F, 9.0F, 3.9F, 2.0F, 9.0F, 2.0F);
		this.bottomLeftLeg.setRotationPoint(4.0F, 6.0F, -12.0F);
		
		this.bottomRightLeg = new ModelRenderer(this, 0, 40);
		this.bottomRightLeg.addBox(0.0F, 9.0F, 3.9F, 2.0F, 9.0F, 2.0F);
		this.bottomRightLeg.setRotationPoint(-4.0F, 6.0F, -12.0F);
		
		this.LeftFoot = new ModelRenderer(this, 47, 26);
		this.LeftFoot.mirror = true;
		this.LeftFoot.addBox(-2F, 17.0F, 0.9F, 2.0F, 1.0F, 5.0F);
		this.LeftFoot.setRotationPoint(4.0F, 6.0F, -12.0F);
		
		this.RightFoot = new ModelRenderer(this, 47, 26);
		this.RightFoot.addBox(0F, 17.0F, 0.9F, 2.0F, 1.0F, 5.0F);
		this.RightFoot.setRotationPoint(-4.0F, 6.0F, -12.0F);
		
		this.LeftToe = new ModelRenderer(this, 47, 26);
		this.LeftToe.mirror = true;
		this.LeftToe.addBox(-4.0F, 23.0F, -11.0F, 1.0F, 1.0F, 4.0F);
		this.LeftToe.setRotationPoint(0F, 0F, 0F);
		this.LeftToe.rotateAngleY = ((float) Math.PI / -4F);
		
		this.RightToe = new ModelRenderer(this, 47, 26);
		this.RightToe.addBox(3.0F, 23.0F, -11.0F, 1.0F, 1.0F, 4.0F);
		this.RightToe.setRotationPoint(0F, 0F, 0F);
		this.RightToe.rotateAngleY = ((float) Math.PI / 4F);
		
		this.tail = new ModelRenderer(this, 0, 15);
		this.tail.addBox(-1.5F, -7F, -8.0F, 3.0F, 2.0F, 5.0F);
		this.body.addChild(this.tail);
		
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
		this.leftBit.addBox(2.0F, -9.0F, -6.0F, 1.0F, 2.0F, 2.0F);
		this.neck.addChild(this.leftBit);
		
		this.rightBit = new ModelRenderer(this, 29, 5);
		this.rightBit.addBox(-3.0F, -9.0F, -6.0F, 1.0F, 2.0F, 2.0F);
		this.neck.addChild(this.rightBit);
		
		this.leftReign = new ModelRenderer(this, 32, 2);
		this.leftReign.addBox(3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F);
		this.leftReign.rotateAngleX = (-(float) Math.PI / 6F);
		this.neck.addChild(this.leftReign);
		
		this.rightReign = new ModelRenderer(this, 32, 2);
		this.rightReign.addBox(-3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F);
		this.rightReign.rotateAngleX = (-(float) Math.PI / 6F);
		this.neck.addChild(this.rightReign);
		
		this.saddles = new ModelRenderer[] { this.saddle, this.headBridle, this.noseBridle, this.leftBit, this.rightBit };
		this.reigns = new ModelRenderer[] { this.leftReign, this.rightReign };
	}

	public Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of(this.neck);
	}

	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.body, this.topLeftLeg, this.topRightLeg, this.bottomRightLeg, this.bottomLeftLeg, this.leftWing, this.rightWing, this.LeftFoot, this.RightFoot, this.LeftToe, this.RightToe);
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
		this.neck.rotateAngleX = ((float) Math.PI / 6F);
	}

	@Override
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
		float f15 = MathHelper.cos(f9 * 0.6F + (float) Math.PI);
		this.topLeftLeg.rotationPointY = 2.0F * f6 + 14.0F * f7;
		this.topLeftLeg.rotationPointZ = -6.0F * f6 - 10.0F * f7;
		this.topRightLeg.rotationPointY = this.topLeftLeg.rotationPointY;
		this.topRightLeg.rotationPointZ = this.topLeftLeg.rotationPointZ;
		float f16 = ((-(float) Math.PI / 3F) + f15) * f6 + f12 * f7;
		float f17 = ((-(float) Math.PI / 3F) - f15) * f6 - f12 * f7;

		this.frontLeftLeg.rotateAngleX = f16;
		this.frontRightLeg.rotateAngleX = f17;
		
		boolean flag1 = entityIn.isChild();
		this.frontLeftLeg.showModel = !flag1;
		this.frontRightLeg.showModel = !flag1;
		

		this.topLeftLeg.rotateAngleX = f16;
		this.topRightLeg.rotateAngleX = f17;
		this.LeftFoot.rotateAngleX = f16;
		this.RightFoot.rotateAngleX = f17;


		this.topLeftLeg.showModel = !flag1;
		this.topRightLeg.showModel = !flag1;
		this.body.rotationPointY = flag1 ? 10.8F : 0.0F;
	}
}
