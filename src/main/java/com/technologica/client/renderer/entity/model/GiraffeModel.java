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
		this.texWidth = 128;
		this.texHeight = 128;

		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-5.0F, -31.0F, -17.0F, 10.0F, 12.0F, 22.0F);
		this.body.setPos(0.0F, 28.0F, 3.0F);

		this.neck = new ModelRenderer(this, 0, 34);
		this.neck.addBox(-2.0F, -38.0F, -6.0F, 4.0F, 37.0F, 6.0F);

		this.mane = new ModelRenderer(this, 20, 34);
		this.mane.addBox(-1.0F, -40.0F, 0.0F, 2.0F, 37.0F, 2.0F);
		this.neck.addChild(mane);

		this.head = new ModelRenderer(this, 42, 0);
		this.head.addBox(-3.0F, -5.0F, -9.0F, 6.0F, 5.0F, 9.0F);
		this.head.setPos(0.0F, -35.0F, 0.0F);
		this.neck.addChild(head);

		this.nose = new ModelRenderer(this, 0, 0);
		this.nose.addBox(-1.5F, -4.0F, -15.0F, 3.0F, 4.0F, 6.0F);
		this.head.addChild(nose);

		this.earLeft = new ModelRenderer(this, 12, 10);
		this.earLeft.addBox(0F, -3.0F, -1.0F, 4.0F, 3.0F, 1.0F, 0.0F);
		this.earLeft.setPos(3.0F, -1.0F, -2.0F);
		this.head.addChild(earLeft);

		this.earRight = new ModelRenderer(this, 12, 0);
		this.earRight.addBox(-4.0F, -3.0F, -1.0F, 4.0F, 3.0F, 1.0F, 0.0F);
		this.earRight.setPos(-3.0F, -1.0F, -2.0F);
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
		this.legUpperBackLeft.setPos(3.0F, -19.0F, 5.0F);
		this.body.addChild(this.legUpperBackLeft);

		this.legUpperBackRight = new ModelRenderer(this, 28, 34);
		this.legUpperBackRight.addBox(-1.99F, -4.0F, -3.99F, 3.98F, 12.0F, 3.98F, 0.0F);
		this.legUpperBackRight.setPos(-3.0F, -19.0F, 5.0F);
		this.body.addChild(this.legUpperBackRight);

		this.legUpperFrontLeft = new ModelRenderer(this, 44, 56);
		this.legUpperFrontLeft.mirror = true;
		this.legUpperFrontLeft.addBox(-1.99F, -4.0F, 0.01F, 3.98F, 18.0F, 3.98F, 0.0F);
		this.legUpperFrontLeft.setPos(3.0F, -19.0F, -17.0F);
		this.body.addChild(this.legUpperFrontLeft);

		this.legUpperFrontRight = new ModelRenderer(this, 44, 56);
		this.legUpperFrontRight.addBox(-1.99F, -4.0F, 0.01F, 3.98F, 18.0F, 3.98F, 0.0F);
		this.legUpperFrontRight.setPos(-3.0F, -19.0F, -17.0F);
		this.body.addChild(this.legUpperFrontRight);

		this.legLowerBackLeft = new ModelRenderer(this, 60, 34);
		this.legLowerBackLeft.mirror = true;
		this.legLowerBackLeft.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 24.0F, 4.0F, 0.0F);
		this.legLowerBackLeft.setPos(0.0F, 8.0F, 0.0F);
		this.legUpperBackLeft.addChild(this.legLowerBackLeft);

		this.legLowerBackRight = new ModelRenderer(this, 60, 34);
		this.legLowerBackRight.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 24.0F, 4.0F, 0.0F);
		this.legLowerBackRight.setPos(0.0F, 8.0F, 0.0F);
		this.legUpperBackRight.addChild(this.legLowerBackRight);

		this.legLowerFrontLeft = new ModelRenderer(this, 44, 34);
		this.legLowerFrontLeft.mirror = true;
		this.legLowerFrontLeft.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 18.0F, 4.0F, 0.0F);
		this.legLowerFrontLeft.setPos(0.0F, 14.0F, 0.0F);
		this.legUpperFrontLeft.addChild(this.legLowerFrontLeft);

		this.legLowerFrontRight = new ModelRenderer(this, 44, 34);
		this.legLowerFrontRight.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 18.0F, 4.0F, 0.0F);
		this.legLowerFrontRight.setPos(0.0F, 14.0F, 0.0F);
		this.legUpperFrontRight.addChild(this.legLowerFrontRight);

		this.tail = new ModelRenderer(this, 28, 50);
		this.tail.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 16.0F, 2.0F);
		this.tail.setPos(0.0F, -30.0F, 5.0F);
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
		this.leftReign.xRot = (-(float) Math.PI / 6F);
		this.neck.addChild(this.leftReign);
		
		this.rightReign = new ModelRenderer(this, 42, 19);
		this.rightReign.addBox(-3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F);
		this.rightReign.xRot = (-(float) Math.PI / 6F);
		this.neck.addChild(this.rightReign);
		
		this.saddles = new ModelRenderer[] { this.saddle, this.headBridle, this.noseBridle, this.leftBit, this.rightBit };
		this.reigns = new ModelRenderer[] { leftReign, rightReign };
	}

	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		boolean flag = entityIn.isSaddled();
		boolean flag1 = entityIn.isVehicle();

		this.earLeft.zRot = -0.5F;
		this.earRight.zRot = 0.5F;
		this.tail.xRot = ((float) Math.PI / 8F);

		for (ModelRenderer modelrenderer : this.saddles) {
			modelrenderer.visible = flag;
		}

		for (ModelRenderer modelrenderer1 : this.reigns) {
			modelrenderer1.visible = flag1 && flag;
		}

		this.body.y = 11.0F;
	}

	public Iterable<ModelRenderer> headParts() {
		return ImmutableList.of(this.neck);
	}

	protected Iterable<ModelRenderer> bodyParts() {
		return ImmutableList.of(this.body);
	}

	public void prepareMobModel(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		float f = MathHelper.lerp(partialTick, entityIn.yBodyRotO, entityIn.yBodyRot);
		float f1 = MathHelper.lerp(partialTick, entityIn.yHeadRotO, entityIn.yHeadRot);
		
		float f3 = f1 - f;
		
		if (f3 > 20.0F) {
			f3 = 20.0F;
		}

		if (f3 < -20.0F) {
			f3 = -20.0F;
		}

	    float f6 = entityIn.getStandAnim(partialTick);
	    float f7 = 1.0F - f6;
	    float f9 = (float)entityIn.tickCount + partialTick;
		float f10 = entityIn.isInWater() ? 0.2F : 1.0F;
		
		boolean tailWagging = entityIn.tailCounter != 0;
		boolean earsFlapping = ((GiraffeEntity) entityIn).earCounter != 0;
		
		this.neck.y = -16.0F;
		this.neck.z = -8.0F;

		this.body.xRot = 0.0F;
		this.neck.xRot = ((float) Math.PI / 10F) + MathHelper.sin(f10 * limbSwing * 0.5F) / 10;
		this.head.xRot = -((float) Math.PI / 10F) + MathHelper.cos(f10 * limbSwing * 0.5F) / 10;
		this.neck.yRot = f3 * ((float) Math.PI / 180F);
		
		this.neck.y = f7 * this.neck.y - f6*15;
	    this.neck.z = f7 * this.neck.z + f6*15;
		
	    this.body.xRot = f6 * (-(float) Math.PI / 4F) + this.body.xRot;

		this.legUpperFrontRight.xRot = -((MathHelper.sin(f10 * limbSwing * 0.25F) * MathHelper.sin(f10 * limbSwing * 0.25F)) * limbSwingAmount * 1.5F) - f6 / 2 * MathHelper.sin(f9 * 0.25F) * f6 * MathHelper.sin(f9 * 0.25F);
		this.legLowerFrontRight.xRot = (MathHelper.cos(f10 * limbSwing * 0.25F + (float) Math.PI / 4F) * MathHelper.cos(f10 * limbSwing * 0.25F + (float) Math.PI / 4F)) * limbSwingAmount * 1.5F + f6 * MathHelper.cos(f9 * 0.25F - (float) Math.PI / 4) * f6 * MathHelper.cos(f9 * 0.25F - (float) Math.PI / 4);

		this.legUpperBackLeft.xRot = (MathHelper.cos(f10 * limbSwing * 0.25F + (float) Math.PI / 4F) * MathHelper.cos(f10 * limbSwing * 0.25F + (float) Math.PI / 4F)) * limbSwingAmount * 1.5F + f6 / 2;
		this.legLowerBackLeft.xRot = -((MathHelper.cos(f10 * limbSwing * 0.25F) * MathHelper.cos(f10 * limbSwing * 0.25F)) * limbSwingAmount * 1.5F) - f6 / 2;

		this.legUpperFrontLeft.xRot = -((MathHelper.cos(f10 * limbSwing * 0.25F) * MathHelper.cos(f10 * limbSwing * 0.25F)) * limbSwingAmount * 1.5F) - f6 / 2 * MathHelper.cos(f9 * 0.25F) * f6 * MathHelper.cos(f9 * 0.25F);
		this.legLowerFrontLeft.xRot = (MathHelper.sin(f10 * limbSwing * 0.25F + (float) Math.PI / 4F) * MathHelper.sin(f10 * limbSwing * 0.25F + (float) Math.PI / 4F)) * limbSwingAmount * 1.5F + f6 * MathHelper.sin(f9 * 0.25F - (float) Math.PI / 4) * f6 * MathHelper.sin(f9 * 0.25F - (float) Math.PI / 4);

		this.legUpperBackRight.xRot = (MathHelper.sin(f10 * limbSwing * 0.25F + (float) Math.PI / 4F) * MathHelper.sin(f10 * limbSwing * 0.25F + (float) Math.PI / 4F)) * limbSwingAmount * 1.5F + f6 / 2;
		this.legLowerBackRight.xRot = -((MathHelper.sin(f10 * limbSwing * 0.25F) * MathHelper.sin(f10 * limbSwing * 0.25F)) * limbSwingAmount * 1.5F) - f6 / 2;
		
		if (tailWagging) {
			this.tail.yRot = MathHelper.cos(f9);
		} else {
			this.tail.yRot = 0.0F;
		}
		
		if (earsFlapping) {
			this.earLeft.yRot = MathHelper.cos((float) entityIn.tickCount + partialTick);
			this.earRight.yRot = -MathHelper.cos((float) entityIn.tickCount + partialTick);
		} else {
			this.earLeft.yRot = 0.0F;
			this.earRight.yRot = 0.0F;
		}
	}
}