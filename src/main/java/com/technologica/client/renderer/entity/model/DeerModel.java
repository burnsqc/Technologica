package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.util.math.MathHelper;

public class DeerModel<T extends AbstractHorseEntity> extends AgeableModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer neck;
	private final ModelRenderer head;
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
	private final ModelRenderer legUpperBackLeft;
	private final ModelRenderer legUpperBackRight;
	private final ModelRenderer legUpperFrontLeft;
	private final ModelRenderer legUpperFrontRight;
	private final ModelRenderer legLowerBackLeft;
	private final ModelRenderer legLowerBackRight;
	private final ModelRenderer legLowerFrontLeft;
	private final ModelRenderer legLowerFrontRight;
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

	public DeerModel() {
		super(true, 24.0F, 1.36F, 2.7272F, 2.0F, 24.0F);
		this.textureWidth = 64;
		this.textureHeight = 64;

		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 16.0F);
		this.body.setRotationPoint(0.0F, 8.0F, 0.0F);

		this.neck = new ModelRenderer(this, 32, 0);
		this.neck.setRotationPoint(0.0F, 4.0F, -8.0F);
		this.neck.addBox(-2.0F, -4.0F, -3.0F, 4.0F, 8.0F, 6.0F);

		this.head = new ModelRenderer(this, 0, 24);
		this.head.addBox(-2.5F, 0.0F, -5.0F, 5.0F, 5.0F, 5.0F);
		this.head.setRotationPoint(0.0F, -4.0F, 3.0F);
		this.neck.addChild(head);

		this.nose = new ModelRenderer(this, 0, 0);
		this.nose.addBox(-1.5F, 2.0F, -9.0F, 3.0F, 3.0F, 4.0F);
		this.head.addChild(nose);

		this.earLeft = new ModelRenderer(this, 0, 7);
		this.earLeft.addBox(0.0F, -2.0F, -1.0F, 3.0F, 2.0F, 1.0F);
		this.earLeft.setRotationPoint(2.5F, 2.0F, 0.0F);
		this.head.addChild(earLeft);

		this.earRight = new ModelRenderer(this, 0, 7);
		this.earRight.addBox(-3.0F, -2.0F, -1.0F, 3.0F, 2.0F, 1.0F);
		this.earRight.setRotationPoint(-2.5F, 2.0F, 0.0F);
		this.head.addChild(earRight);

		this.antlerLeft1 = new ModelRenderer(this, 0, 10);
		this.antlerLeft1.setRotationPoint(0.5F, 0.0F, -2.0F);
		this.antlerLeft1.addBox(0.0F, -5.0F, -1.0F, 1.0F, 5.0F, 1.0F);
		this.head.addChild(antlerLeft1);

		this.antlerRight1 = new ModelRenderer(this, 0, 10);
		this.antlerRight1.setRotationPoint(-0.5F, 0.0F, -2.0F);
		this.antlerRight1.addBox(-1.0F, -5.0F, -1.0F, 1.0F, 5.0F, 1.0F);
		this.head.addChild(antlerRight1);
		
		this.antlerLeft2 = new ModelRenderer(this, 0, 10);
		this.antlerLeft2.setRotationPoint(0.0F, -5.0F, 0.0F);
		this.antlerLeft2.addBox(0.0F, -5.0F, -1.0F, 1.0F, 5.0F, 1.0F);
		this.antlerLeft1.addChild(antlerLeft2);

		this.antlerRight2 = new ModelRenderer(this, 0, 10);
		this.antlerRight2.setRotationPoint(0.0F, -5.0F, 0.0F);
		this.antlerRight2.addBox(-1.0F, -5.0F, -1.0F, 1.0F, 5.0F, 1.0F);
		this.antlerRight1.addChild(antlerRight2);
		
		this.antlerLeft3 = new ModelRenderer(this, 0, 10);
		this.antlerLeft3.setRotationPoint(1.0F, -5.0F, -1.0F);
		this.antlerLeft3.addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F);
		this.antlerLeft2.addChild(antlerLeft3);

		this.antlerRight3 = new ModelRenderer(this, 0, 10);
		this.antlerRight3.setRotationPoint(-1.0F, -5.0F, -1.0F);
		this.antlerRight3.addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F);
		this.antlerRight2.addChild(antlerRight3);
		
		this.antlerLeft4 = new ModelRenderer(this, 0, 10);
		this.antlerLeft4.setRotationPoint(1.0F, -2.0F, -1.0F);
		this.antlerLeft4.addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		this.antlerLeft1.addChild(antlerLeft4);

		this.antlerRight4 = new ModelRenderer(this, 0, 10);
		this.antlerRight4.setRotationPoint(-1.0F, -2.0F, -1.0F);
		this.antlerRight4.addBox(0.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		this.antlerRight1.addChild(antlerRight4);
		
		this.antlerLeft5 = new ModelRenderer(this, 0, 10);
		this.antlerLeft5.setRotationPoint(0.0F, -1.0F, -1.0F);
		this.antlerLeft5.addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F);
		this.antlerLeft2.addChild(antlerLeft5);

		this.antlerRight5 = new ModelRenderer(this, 0, 10);
		this.antlerRight5.setRotationPoint(0.0F, -1.0F, -1.0F);
		this.antlerRight5.addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F);
		this.antlerRight2.addChild(antlerRight5);
		
		this.antlerLeft6 = new ModelRenderer(this, 0, 10);
		this.antlerLeft6.setRotationPoint(0.0F, -3.0F, -1.0F);
		this.antlerLeft6.addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F);
		this.antlerLeft2.addChild(antlerLeft6);

		this.antlerRight6 = new ModelRenderer(this, 0, 10);
		this.antlerRight6.setRotationPoint(0.0F, -3.0F, -1.0F);
		this.antlerRight6.addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F);
		this.antlerRight2.addChild(antlerRight6);

		this.legUpperBackLeft = new ModelRenderer(this, 52, 0);
		this.legUpperBackLeft.mirror = true;
		this.legUpperBackLeft.addBox(-2.0F, -3.0F, -3.0F, 3.0F, 7.0F, 3.0F);
		this.legUpperBackLeft.setRotationPoint(3.0F, 4.0F, 8.0F);
		this.body.addChild(this.legUpperBackLeft);

		this.legUpperBackRight = new ModelRenderer(this, 52, 0);
		this.legUpperBackRight.addBox(-2.0F, -3.0F, -3.0F, 3.0F, 7.0F, 3.0F);
		this.legUpperBackRight.setRotationPoint(-2.0F, 4.0F, 8.0F);
		this.body.addChild(this.legUpperBackRight);

		this.legUpperFrontLeft = new ModelRenderer(this, 52, 10);
		this.legUpperFrontLeft.mirror = true;
		this.legUpperFrontLeft.addBox(-2.0F, -3.0F, 0.0F, 3.0F, 9.0F, 3.0F);
		this.legUpperFrontLeft.setRotationPoint(3.0F, 4.0F, -8.0F);
		this.body.addChild(this.legUpperFrontLeft);

		this.legUpperFrontRight = new ModelRenderer(this, 52, 10);
		this.legUpperFrontRight.addBox(-2.0F, -3.0F, 0.0F, 3.0F, 9.0F, 3.0F);
		this.legUpperFrontRight.setRotationPoint(-2.0F, 4.0F, -8.0F);
		this.body.addChild(this.legUpperFrontRight);

		this.legLowerBackLeft = new ModelRenderer(this, 52, 22);
		this.legLowerBackLeft.mirror = true;
		this.legLowerBackLeft.addBox(-2.0F, 0.0F, -3.0F, 3.0F, 8.0F, 3.0F);
		this.legLowerBackLeft.setRotationPoint(0.0F, 4.0F, 0.0F);
		this.legUpperBackLeft.addChild(this.legLowerBackLeft);

		this.legLowerBackRight = new ModelRenderer(this, 52, 22);
		this.legLowerBackRight.addBox(-2.0F, 0.0F, -3.0F, 3.0F, 8.0F, 3.0F);
		this.legLowerBackRight.setRotationPoint(0.0F, 4.0F, 0.0F);
		this.legUpperBackRight.addChild(this.legLowerBackRight);

		this.legLowerFrontLeft = new ModelRenderer(this, 52, 33);
		this.legLowerFrontLeft.mirror = true;
		this.legLowerFrontLeft.addBox(-2.0F, 0.0F, 0.0F, 3.0F, 6.0F, 3.0F);
		this.legLowerFrontLeft.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.legUpperFrontLeft.addChild(this.legLowerFrontLeft);

		this.legLowerFrontRight = new ModelRenderer(this, 52, 33);
		this.legLowerFrontRight.addBox(-2.0F, 0.0F, 0.0F, 3.0F, 6.0F, 3.0F);
		this.legLowerFrontRight.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.legUpperFrontRight.addChild(this.legLowerFrontRight);

		this.tail = new ModelRenderer(this, 8, 7);
		this.tail.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 4.0F, 2.0F);
		this.tail.setRotationPoint(0.0F, -3.0F, 8.0F);
		this.body.addChild(this.tail);

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

		this.earLeft.rotateAngleZ = -0.5F;
		this.earRight.rotateAngleZ = 0.5F;
		this.tail.rotateAngleX = ((float) Math.PI / 8F);

		for (ModelRenderer modelrenderer : this.saddles) {
			modelrenderer.showModel = flag;
		}

		for (ModelRenderer modelrenderer1 : this.reigns) {
			modelrenderer1.showModel = flag1 && flag;
		}
		
		this.antlerLeft1.rotateAngleZ = (float) Math.PI/3;
		this.antlerRight1.rotateAngleZ = -(float) Math.PI/3;
		this.antlerLeft2.rotateAngleX = (float) Math.PI/3;
		this.antlerRight2.rotateAngleX = (float) Math.PI/3;
		this.antlerLeft3.rotateAngleZ = -(float) Math.PI/3;
		this.antlerRight3.rotateAngleZ = (float) Math.PI/3;
		this.antlerLeft4.rotateAngleZ = -(float) Math.PI/3;
		this.antlerRight4.rotateAngleZ = (float) Math.PI/3;
		this.antlerLeft5.rotateAngleZ = -(float) Math.PI/2;
		this.antlerRight5.rotateAngleZ = (float) Math.PI/2;
		this.antlerLeft6.rotateAngleZ = -(float) Math.PI/2;
		this.antlerRight6.rotateAngleZ = (float) Math.PI/2;
		this.antlerLeft6.rotateAngleX = -(float) Math.PI/6;
		this.antlerRight6.rotateAngleX = -(float) Math.PI/6;
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
		
		boolean tailWagging = entityIn.tailCounter != 0;
		//boolean earsFlapping = ((GiraffeEntity) entityIn).earCounter != 0;

		this.body.rotateAngleX = 0.0F;
		this.neck.rotateAngleX = (float) Math.PI / 4 + MathHelper.sin(f10 * limbSwing * 0.5F) / 10;
		this.head.rotateAngleX = -(float) Math.PI / 4 + MathHelper.cos(f10 * limbSwing * 0.5F) / 10;
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
		
		if (tailWagging) {
			this.tail.rotateAngleY = MathHelper.cos(f9);
		} else {
			this.tail.rotateAngleY = 0.0F;
		}
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