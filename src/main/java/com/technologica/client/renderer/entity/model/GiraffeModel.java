package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import com.technologica.entity.passive.GiraffeEntity;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.util.math.MathHelper;

public class GiraffeModel<T extends AbstractHorseEntity> extends AgeableModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer neck;
	private final ModelRenderer mane;
	private final ModelRenderer head;
	private final ModelRenderer nose;
	private final ModelRenderer earLeft;
	private final ModelRenderer earRight;
	private final ModelRenderer hornLeft;
	private final ModelRenderer hornRight;
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

	public GiraffeModel() {
		super(true, 24.0F, 1.36F, 2.7272F, 2.0F, 24.0F);
		this.textureWidth = 128;
		this.textureHeight = 128;

		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-5.0F, -31.0F, -17.0F, 10.0F, 12.0F, 22.0F);
		this.body.setRotationPoint(0.0F, 28.0F, 3.0F);

		this.neck = new ModelRenderer(this, 0, 35);
		this.neck.addBox(-2.0F, -38.0F, -6.0F, 4.0F, 37.0F, 6.0F);

		this.mane = new ModelRenderer(this, 20, 34);
		this.mane.addBox(-1.0F, -40.0F, 0.0F, 2.0F, 37.0F, 2.0F);
		this.neck.addChild(mane);

		this.head = new ModelRenderer(this, 42, 0);
		this.head.addBox(-3.0F, -5.0F, -9.0F, 6.0F, 5.0F, 9.0F);
		this.head.setRotationPoint(0.0F, -35.0F, 0.0F);
		this.neck.addChild(head);

		this.nose = new ModelRenderer(this, 0, 0);
		this.nose.addBox(-1.5F, -4.0F, -15.0F, 3.0F, 4.0F, 6.0F);
		this.head.addChild(nose);

		this.earLeft = new ModelRenderer(this, 12, 10);
		this.earLeft.addBox(0F, -3.0F, -1.0F, 4.0F, 3.0F, 1.0F, 0.0F);
		this.earLeft.setRotationPoint(3.0F, -1.0F, -2.0F);
		this.head.addChild(earLeft);

		this.earRight = new ModelRenderer(this, 12, 0);
		this.earRight.addBox(-4.0F, -3.0F, -1.0F, 4.0F, 3.0F, 1.0F, 0.0F);
		this.earRight.setRotationPoint(-3.0F, -1.0F, -2.0F);
		this.head.addChild(earRight);

		this.hornLeft = new ModelRenderer(this, 0, 0);
		this.hornLeft.addBox(1.0F, -7.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F);
		this.head.addChild(hornLeft);

		this.hornRight = new ModelRenderer(this, 0, 0);
		this.hornRight.addBox(-2.0F, -7.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F);
		this.head.addChild(hornRight);

		this.legUpperBackLeft = new ModelRenderer(this, 28, 34);
		this.legUpperBackLeft.mirror = true;
		this.legUpperBackLeft.addBox(-1.99F, -4.0F, -3.99F, 3.98F, 12.0F, 3.98F, 0.0F);
		this.legUpperBackLeft.setRotationPoint(3.0F, -19.0F, 5.0F);
		this.body.addChild(this.legUpperBackLeft);

		this.legUpperBackRight = new ModelRenderer(this, 28, 34);
		this.legUpperBackRight.addBox(-1.99F, -4.0F, -3.99F, 3.98F, 12.0F, 3.98F, 0.0F);
		this.legUpperBackRight.setRotationPoint(-3.0F, -19.0F, 5.0F);
		this.body.addChild(this.legUpperBackRight);

		this.legUpperFrontLeft = new ModelRenderer(this, 44, 56);
		this.legUpperFrontLeft.mirror = true;
		this.legUpperFrontLeft.addBox(-1.99F, -4.0F, 0.01F, 3.98F, 18.0F, 3.98F, 0.0F);
		this.legUpperFrontLeft.setRotationPoint(3.0F, -19.0F, -17.0F);
		this.body.addChild(this.legUpperFrontLeft);

		this.legUpperFrontRight = new ModelRenderer(this, 44, 56);
		this.legUpperFrontRight.addBox(-1.99F, -4.0F, 0.01F, 3.98F, 18.0F, 3.98F, 0.0F);
		this.legUpperFrontRight.setRotationPoint(-3.0F, -19.0F, -17.0F);
		this.body.addChild(this.legUpperFrontRight);

		this.legLowerBackLeft = new ModelRenderer(this, 60, 34);
		this.legLowerBackLeft.mirror = true;
		this.legLowerBackLeft.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 24.0F, 4.0F, 0.0F);
		this.legLowerBackLeft.setRotationPoint(0.0F, 8.0F, 0.0F);
		this.legUpperBackLeft.addChild(this.legLowerBackLeft);

		this.legLowerBackRight = new ModelRenderer(this, 60, 34);
		this.legLowerBackRight.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 24.0F, 4.0F, 0.0F);
		this.legLowerBackRight.setRotationPoint(0.0F, 8.0F, 0.0F);
		this.legUpperBackRight.addChild(this.legLowerBackRight);

		this.legLowerFrontLeft = new ModelRenderer(this, 44, 34);
		this.legLowerFrontLeft.mirror = true;
		this.legLowerFrontLeft.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 18.0F, 4.0F, 0.0F);
		this.legLowerFrontLeft.setRotationPoint(0.0F, 14.0F, 0.0F);
		this.legUpperFrontLeft.addChild(this.legLowerFrontLeft);

		this.legLowerFrontRight = new ModelRenderer(this, 44, 34);
		this.legLowerFrontRight.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 18.0F, 4.0F, 0.0F);
		this.legLowerFrontRight.setRotationPoint(0.0F, 14.0F, 0.0F);
		this.legUpperFrontRight.addChild(this.legLowerFrontRight);

		this.tail = new ModelRenderer(this, 28, 50);
		this.tail.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 16.0F, 2.0F);
		this.tail.setRotationPoint(0.0F, -30.0F, 5.0F);
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

		this.body.rotationPointY = 11.0F;
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
	    float f7 = 1.0F - f6;
	    float f9 = (float)entityIn.ticksExisted + partialTick;
		float f10 = entityIn.isInWater() ? 0.2F : 1.0F;
		
		boolean tailWagging = entityIn.tailCounter != 0;
		boolean earsFlapping = ((GiraffeEntity) entityIn).earCounter != 0;
		
		this.neck.rotationPointY = -16.0F;
		this.neck.rotationPointZ = -8.0F;

		this.body.rotateAngleX = 0.0F;
		this.neck.rotateAngleX = ((float) Math.PI / 10F) + MathHelper.sin(f10 * limbSwing * 0.5F) / 10;
		this.head.rotateAngleX = -((float) Math.PI / 10F) + MathHelper.cos(f10 * limbSwing * 0.5F) / 10;
		this.neck.rotateAngleY = f3 * ((float) Math.PI / 180F);
		
		this.neck.rotationPointY = f7 * this.neck.rotationPointY - f6*15;
	    this.neck.rotationPointZ = f7 * this.neck.rotationPointZ + f6*15;
		
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
		
		if (earsFlapping) {
			this.earLeft.rotateAngleY = MathHelper.cos((float) entityIn.ticksExisted + partialTick);
			this.earRight.rotateAngleY = -MathHelper.cos((float) entityIn.ticksExisted + partialTick);
		} else {
			this.earLeft.rotateAngleY = 0.0F;
			this.earRight.rotateAngleY = 0.0F;
		}
	}
}