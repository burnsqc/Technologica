package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.util.math.MathHelper;

public class MooseModel<T extends AbstractHorseEntity> extends AgeableModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer neck;
	private final ModelRenderer head;
	private final ModelRenderer beard;
	private final ModelRenderer nose;
	private final ModelRenderer earLeft;
	private final ModelRenderer earRight;
	private final ModelRenderer antlerLeft1;
	private final ModelRenderer antlerRight1;
	private final ModelRenderer antlerLeft2;
	private final ModelRenderer antlerRight2;
	private final ModelRenderer antlerLeft3;
	private final ModelRenderer antlerRight3;
	private final ModelRenderer antlerLeft4;
	private final ModelRenderer antlerRight4;
	private final ModelRenderer antlerLeft5;
	private final ModelRenderer antlerRight5;
	private final ModelRenderer antlerLeft6;
	private final ModelRenderer antlerRight6;
	private final ModelRenderer antlerLeft7;
	private final ModelRenderer antlerRight7;
	private final ModelRenderer antlerLeft8;
	private final ModelRenderer antlerRight8;
	private final ModelRenderer antlerLeft9;
	private final ModelRenderer antlerRight9;
	private final ModelRenderer legUpperBackLeft;
	private final ModelRenderer legUpperBackRight;
	private final ModelRenderer legUpperFrontLeft;
	private final ModelRenderer legUpperFrontRight;
	private final ModelRenderer legLowerBackLeft;
	private final ModelRenderer legLowerBackRight;
	private final ModelRenderer legLowerFrontLeft;
	private final ModelRenderer legLowerFrontRight;
	private final ModelRenderer saddle;
	private final ModelRenderer leftBit;
	private final ModelRenderer rightBit;
	private final ModelRenderer headBridle;
	private final ModelRenderer noseBridle;
	private final ModelRenderer leftReign;
	private final ModelRenderer rightReign;
	private final ModelRenderer[] saddles;
	private final ModelRenderer[] reigns;

	public MooseModel() {
		super(true, 24.0F, 1.36F, 2.7272F, 2.0F, 24.0F);
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-6.0F, -8.0F, -16.0F, 12.0F, 16.0F, 32.0F);
		this.body.setRotationPoint(0.0F, 0.0F, 0.0F);

		this.neck = new ModelRenderer(this, 56, 0);
		this.neck.setRotationPoint(0.0F, -7.0F, -16.0F);
		this.neck.addBox(-3.0F, -6.0F, -4.0F, 6.0F, 14.0F, 8.0F);

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-4.0F, 0.0F, -8.0F, 8.0F, 8.0F, 8.0F);
		this.head.setRotationPoint(0.0F, -6.0F, 4.0F);
		this.neck.addChild(head);
		
		this.beard = new ModelRenderer(this, 56, 22);
		this.beard.addBox(-2.0F, 8.0F, -6.0F, 4.0F, 4.0F, 4.0F);
		this.head.addChild(beard);

		this.nose = new ModelRenderer(this, 0, 16);
		this.nose.setRotationPoint(0.0F, 2.0F, -8.0F);
		this.nose.addBox(-3.0F, 0.0F, -8.0F, 6.0F, 6.0F, 10.0F);
		this.head.addChild(nose);

		this.earLeft = new ModelRenderer(this, 0, 16);
		this.earLeft.addBox(0.0F, -3.0F, -1.0F, 4.0F, 3.0F, 1.0F);
		this.earLeft.setRotationPoint(4.0F, 3.0F, -1.0F);
		this.head.addChild(earLeft);

		this.earRight = new ModelRenderer(this, 0, 16);
		this.earRight.addBox(-4.0F, -3.0F, -1.0F, 4.0F, 3.0F, 1.0F);
		this.earRight.setRotationPoint(-4.0F, 3.0F, -1.0F);
		this.head.addChild(earRight);

		this.antlerLeft1 = new ModelRenderer(this, 0, 0);
		this.antlerLeft1.setRotationPoint(3.0F, 0.0F, -4.0F);
		this.antlerLeft1.addBox(0.0F, -5.0F, -1.0F, 1.0F, 5.0F, 1.0F);
		this.head.addChild(antlerLeft1);

		this.antlerRight1 = new ModelRenderer(this, 0, 0);
		this.antlerRight1.setRotationPoint(-3.0F, 0.0F, -4.0F);
		this.antlerRight1.addBox(-1.0F, -5.0F, -1.0F, 1.0F, 5.0F, 1.0F);
		this.head.addChild(antlerRight1);
		
		this.antlerLeft2 = new ModelRenderer(this, 84, 0);
		this.antlerLeft2.setRotationPoint(0.0F, -5.0F, -1.0F);
		this.antlerLeft2.addBox(0.0F, -8.0F, 0.0F, 1.0F, 8.0F, 4.0F);
		this.antlerLeft1.addChild(antlerLeft2);

		this.antlerRight2 = new ModelRenderer(this, 84, 0);
		this.antlerRight2.setRotationPoint(0.0F, -5.0F, -1.0F);
		this.antlerRight2.addBox(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 4.0F);
		this.antlerRight1.addChild(antlerRight2);
		
		this.antlerLeft3 = new ModelRenderer(this, 2, 4);
		this.antlerLeft3.setRotationPoint(1.0F, -3.0F, -1.0F);
		this.antlerLeft3.addBox(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F);
		this.antlerLeft1.addChild(antlerLeft3);

		this.antlerRight3 = new ModelRenderer(this, 2, 4);
		this.antlerRight3.setRotationPoint(-1.0F, -3.0F, -1.0F);
		this.antlerRight3.addBox(0.0F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F);
		this.antlerRight1.addChild(antlerRight3);
		
		this.antlerLeft4 = new ModelRenderer(this, 2, 4);
		this.antlerLeft4.setRotationPoint(1.0F, 0.0F, 0.0F);
		this.antlerLeft4.addBox(-1.0F, -2.0F, -2.0F, 1.0F, 1.0F, 2.0F);
		this.antlerLeft2.addChild(antlerLeft4);

		this.antlerRight4 = new ModelRenderer(this, 2, 4);
		this.antlerRight4.setRotationPoint(-1.0F, 0.0F, 0.0F);
		this.antlerRight4.addBox(0.0F, -2.0F, -2.0F, 1.0F, 1.0F, 2.0F);
		this.antlerRight2.addChild(antlerRight4);
		
		this.antlerLeft5 = new ModelRenderer(this, 2, 4);
		this.antlerLeft5.setRotationPoint(1.0F, -2.0F, 0.0F);
		this.antlerLeft5.addBox(-1.0F, -2.0F, -2.0F, 1.0F, 1.0F, 2.0F);
		this.antlerLeft2.addChild(antlerLeft5);

		this.antlerRight5 = new ModelRenderer(this, 2, 4);
		this.antlerRight5.setRotationPoint(-1.0F, -2.0F, 0.0F);
		this.antlerRight5.addBox(0.0F, -2.0F, -2.0F, 1.0F, 1.0F, 2.0F);
		this.antlerRight2.addChild(antlerRight5);
		
		this.antlerLeft6 = new ModelRenderer(this, 2, 4);
		this.antlerLeft6.setRotationPoint(1.0F, -4.0F, 0.0F);
		this.antlerLeft6.addBox(-1.0F, -2.0F, -2.0F, 1.0F, 1.0F, 2.0F);
		this.antlerLeft2.addChild(antlerLeft6);

		this.antlerRight6 = new ModelRenderer(this, 2, 4);
		this.antlerRight6.setRotationPoint(-1.0F, -4.0F, 0.0F);
		this.antlerRight6.addBox(0.0F, -2.0F, -2.0F, 1.0F, 1.0F, 2.0F);
		this.antlerRight2.addChild(antlerRight6);
		
		this.antlerLeft7 = new ModelRenderer(this, 2, 4);
		this.antlerLeft7.setRotationPoint(1.0F, -6.0F, 0.0F);
		this.antlerLeft7.addBox(-1.0F, -2.0F, -2.0F, 1.0F, 1.0F, 2.0F);
		this.antlerLeft2.addChild(antlerLeft7);

		this.antlerRight7 = new ModelRenderer(this, 2, 4);
		this.antlerRight7.setRotationPoint(-1.0F, -6.0F, 0.0F);
		this.antlerRight7.addBox(0.0F, -2.0F, -2.0F, 1.0F, 1.0F, 2.0F);
		this.antlerRight2.addChild(antlerRight7);
		
		this.antlerLeft8 = new ModelRenderer(this, 4, 0);
		this.antlerLeft8.setRotationPoint(1.0F, -8.0F, 3.0F);
		this.antlerLeft8.addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 1.0F);
		this.antlerLeft2.addChild(antlerLeft8);

		this.antlerRight8 = new ModelRenderer(this, 4, 0);
		this.antlerRight8.setRotationPoint(-1.0F, -8.0F, 3.0F);
		this.antlerRight8.addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 1.0F);
		this.antlerRight2.addChild(antlerRight8);
		
		this.antlerLeft9 = new ModelRenderer(this, 4, 0);
		this.antlerLeft9.setRotationPoint(1.0F, -8.0F, 5.0F);
		this.antlerLeft9.addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 1.0F);
		this.antlerLeft2.addChild(antlerLeft9);

		this.antlerRight9 = new ModelRenderer(this, 4, 0);
		this.antlerRight9.setRotationPoint(-1.0F, -8.0F, 5.0F);
		this.antlerRight9.addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 1.0F);
		this.antlerRight2.addChild(antlerRight9);

		this.legUpperBackLeft = new ModelRenderer(this, 0, 48);
		this.legUpperBackLeft.mirror = true;
		this.legUpperBackLeft.addBox(-2.0F, -4.0F, -4.0F, 4.0F, 8.0F, 4.0F);
		this.legUpperBackLeft.setRotationPoint(4.0F, 8.0F, 16.0F);
		this.body.addChild(this.legUpperBackLeft);

		this.legUpperBackRight = new ModelRenderer(this, 0, 48);
		this.legUpperBackRight.addBox(-2.0F, -4.0F, -4.0F, 4.0F, 8.0F, 4.0F);
		this.legUpperBackRight.setRotationPoint(-4.0F, 8.0F, 16.0F);
		this.body.addChild(this.legUpperBackRight);

		this.legUpperFrontLeft = new ModelRenderer(this, 16, 48);
		this.legUpperFrontLeft.mirror = true;
		this.legUpperFrontLeft.addBox(-2.0F, -4.0F, 0.0F, 4.0F, 12.0F, 4.0F);
		this.legUpperFrontLeft.setRotationPoint(4.0F, 8.0F, -16.0F);
		this.body.addChild(this.legUpperFrontLeft);

		this.legUpperFrontRight = new ModelRenderer(this, 16, 48);
		this.legUpperFrontRight.addBox(-2.0F, -4.0F, 0.0F, 4.0F, 12.0F, 4.0F);
		this.legUpperFrontRight.setRotationPoint(-4.0F, 8.0F, -16.0F);
		this.body.addChild(this.legUpperFrontRight);

		this.legLowerBackLeft = new ModelRenderer(this, 32, 48);
		this.legLowerBackLeft.mirror = true;
		this.legLowerBackLeft.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 12.0F, 4.0F);
		this.legLowerBackLeft.setRotationPoint(0.0F, 4.0F, 0.0F);
		this.legUpperBackLeft.addChild(this.legLowerBackLeft);

		this.legLowerBackRight = new ModelRenderer(this, 32, 48);
		this.legLowerBackRight.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 12.0F, 4.0F);
		this.legLowerBackRight.setRotationPoint(0.0F, 4.0F, 0.0F);
		this.legUpperBackRight.addChild(this.legLowerBackRight);

		this.legLowerFrontLeft = new ModelRenderer(this, 48, 48);
		this.legLowerFrontLeft.mirror = true;
		this.legLowerFrontLeft.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 4.0F);
		this.legLowerFrontLeft.setRotationPoint(0.0F, 8.0F, 0.0F);
		this.legUpperFrontLeft.addChild(this.legLowerFrontLeft);

		this.legLowerFrontRight = new ModelRenderer(this, 48, 48);
		this.legLowerFrontRight.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 4.0F);
		this.legLowerFrontRight.setRotationPoint(0.0F, 8.0F, 0.0F);
		this.legUpperFrontRight.addChild(this.legLowerFrontRight);

		this.saddle = new ModelRenderer(this, 72, 0);
		this.saddle.addBox(-5.0F, -31.0F, -9.0F, 10.0F, 9.0F, 9.0F, 0.5F);
		this.body.addChild(saddle);
		
		this.headBridle = new ModelRenderer(this, 72, 18);
		this.headBridle.addBox(-3.0F, -5.0F, -8.9F, 6.0F, 5.0F, 8.0F, 0.2F);
		this.head.addChild(this.headBridle);
		
		this.noseBridle = new ModelRenderer(this, 69, 0);
		this.noseBridle.addBox(-1.5F, -4.0F, -11.0F, 3.0F, 4.0F, 2.0F, 0.2F);
		this.head.addChild(this.noseBridle);
		
		this.leftBit = new ModelRenderer(this, 101, 0);
		this.leftBit.addBox(1.5F, -3.0F, -13.0F, 1.0F, 2.0F, 2.0F);
		this.head.addChild(this.leftBit);
		
		this.rightBit = new ModelRenderer(this, 101, 0);
		this.rightBit.addBox(-2.5F, -3.0F, -13.0F, 1.0F, 2.0F, 2.0F);
		this.head.addChild(this.rightBit);
		
		this.leftReign = new ModelRenderer(this, 42, 19);
		this.leftReign.addBox(3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F);
		this.leftReign.rotateAngleX = (-(float) Math.PI / 6F);
		this.neck.addChild(this.leftReign);
		
		this.rightReign = new ModelRenderer(this, 42, 19);
		this.rightReign.addBox(-3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F);
		this.rightReign.rotateAngleX = (-(float) Math.PI / 6F);
		this.neck.addChild(this.rightReign);
		
		this.saddles = new ModelRenderer[] { this.saddle, this.headBridle, this.noseBridle, this.leftBit, this.rightBit };
		this.reigns = new ModelRenderer[] { leftReign, rightReign };
	}

	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		boolean flag = entityIn.isHorseSaddled();
		boolean flag1 = entityIn.isBeingRidden();

		this.nose.rotateAngleX = (float) Math.PI / 10;
		this.earLeft.rotateAngleZ = 0F;
		this.earRight.rotateAngleZ = 0F;

		for (ModelRenderer modelrenderer : this.saddles) {
			modelrenderer.showModel = flag;
		}

		for (ModelRenderer modelrenderer1 : this.reigns) {
			modelrenderer1.showModel = flag1 && flag;
		}
		
		this.antlerLeft1.rotateAngleZ = (float) Math.PI/3;
		this.antlerRight1.rotateAngleZ = -(float) Math.PI/3;
		this.antlerLeft2.rotateAngleX = -1.35F;
		this.antlerRight2.rotateAngleX = -1.35F;
		this.antlerLeft3.rotateAngleX = -(float) Math.PI/6;
		this.antlerRight3.rotateAngleX = -(float) Math.PI/6;
		this.antlerLeft4.rotateAngleY = (float) (Math.PI/6);
		this.antlerRight4.rotateAngleY= -(float) (Math.PI/6);
		this.antlerLeft5.rotateAngleY = (float) (Math.PI/6);
		this.antlerRight5.rotateAngleY = -(float) (Math.PI/6);
		this.antlerLeft6.rotateAngleY = (float) (Math.PI/6);
		this.antlerRight6.rotateAngleY = -(float) (Math.PI/6);
		this.antlerLeft7.rotateAngleY = (float) (Math.PI/6);
		this.antlerRight7.rotateAngleY = -(float) (Math.PI/6);
		this.antlerLeft8.rotateAngleZ = -(float) (Math.PI/6);
		this.antlerRight8.rotateAngleZ = (float) (Math.PI/6);
		this.antlerLeft9.rotateAngleZ = -(float) (Math.PI/6);
		this.antlerRight9.rotateAngleZ = (float) (Math.PI/6);
	}

	public Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of(this.neck);
	}

	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.body);
	}

	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		float f = MathHelper.lerp(partialTick, entityIn.prevRenderYawOffset, entityIn.renderYawOffset);
		float f1 = MathHelper.lerp(partialTick, entityIn.prevRotationYawHead, entityIn.rotationYawHead);
		
		float f3 = f1 - f;
		
		if (f3 > 20.0F) {
			f3 = 20.0F;
		}

		if (f3 < -20.0F) {
			f3 = -20.0F;
		}

	    float f6 = entityIn.getRearingAmount(partialTick);
	    //float f7 = 1.0F - f6;
	    float f9 = (float)entityIn.ticksExisted + partialTick;
		float f10 = entityIn.isInWater() ? 0.2F : 1.0F;
		
		//boolean earsFlapping = ((GiraffeEntity) entityIn).earCounter != 0;

		this.body.rotateAngleX = 0.0F;
		this.neck.rotateAngleX = (float) Math.PI / 3 + MathHelper.sin(f10 * limbSwing * 0.5F) / 10;
		this.head.rotateAngleX = -(float) Math.PI / 3 + MathHelper.cos(f10 * limbSwing * 0.5F) / 10;
		this.neck.rotateAngleY = f3 * (float) Math.PI / 180;
		
		
	    this.body.rotateAngleX = f6 * (-(float) Math.PI / 4F) + this.body.rotateAngleX;

		this.legUpperFrontRight.rotateAngleX = -((MathHelper.sin(f10 * limbSwing * 0.25F) * MathHelper.sin(f10 * limbSwing * 0.25F)) * limbSwingAmount * 1.5F) - f6 / 2 * MathHelper.sin(f9 * 0.25F) * f6 * MathHelper.sin(f9 * 0.25F);
		this.legLowerFrontRight.rotateAngleX = (MathHelper.cos(f10 * limbSwing * 0.25F + (float) Math.PI / 4F) * MathHelper.cos(f10 * limbSwing * 0.25F + (float) Math.PI / 4F)) * limbSwingAmount * 1.5F + f6 * MathHelper.cos(f9 * 0.25F - (float) Math.PI / 4) * f6 * MathHelper.cos(f9 * 0.25F - (float) Math.PI / 4);

		this.legUpperBackLeft.rotateAngleX = (MathHelper.cos(f10 * limbSwing * 0.25F + (float) Math.PI / 4F) * MathHelper.cos(f10 * limbSwing * 0.25F + (float) Math.PI / 4F)) * limbSwingAmount * 1.5F + f6 / 2;
		this.legLowerBackLeft.rotateAngleX = -((MathHelper.cos(f10 * limbSwing * 0.25F) * MathHelper.cos(f10 * limbSwing * 0.25F)) * limbSwingAmount * 1.5F) - f6 / 2;

		this.legUpperFrontLeft.rotateAngleX = -((MathHelper.cos(f10 * limbSwing * 0.25F) * MathHelper.cos(f10 * limbSwing * 0.25F)) * limbSwingAmount * 1.5F) - f6 / 2 * MathHelper.cos(f9 * 0.25F) * f6 * MathHelper.cos(f9 * 0.25F);
		this.legLowerFrontLeft.rotateAngleX = (MathHelper.sin(f10 * limbSwing * 0.25F + (float) Math.PI / 4F) * MathHelper.sin(f10 * limbSwing * 0.25F + (float) Math.PI / 4F)) * limbSwingAmount * 1.5F + f6 * MathHelper.sin(f9 * 0.25F - (float) Math.PI / 4) * f6 * MathHelper.sin(f9 * 0.25F - (float) Math.PI / 4);

		this.legUpperBackRight.rotateAngleX = (MathHelper.sin(f10 * limbSwing * 0.25F + (float) Math.PI / 4F) * MathHelper.sin(f10 * limbSwing * 0.25F + (float) Math.PI / 4F)) * limbSwingAmount * 1.5F + f6 / 2;
		this.legLowerBackRight.rotateAngleX = -((MathHelper.sin(f10 * limbSwing * 0.25F) * MathHelper.sin(f10 * limbSwing * 0.25F)) * limbSwingAmount * 1.5F) - f6 / 2;
		
		/*
		if (earsFlapping) {
			this.earLeft.rotateAngleY = MathHelper.cos((float) entityIn.ticksExisted + partialTick);
			this.earRight.rotateAngleY = -MathHelper.cos((float) entityIn.ticksExisted + partialTick);
		} else {
			this.earLeft.rotateAngleY = 0.0F;
			this.earRight.rotateAngleY = 0.0F;
		}
		*/
	}
}