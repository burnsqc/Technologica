package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import com.technologica.entity.passive.OstrichEntity;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.util.math.MathHelper;

public class OstrichModel<T extends AbstractHorseEntity> extends AgeableModel<T> {
	protected final ModelRenderer body;
	private final ModelRenderer tail;
	protected final ModelRenderer wingLeft;
	protected final ModelRenderer wingRight;
	protected final ModelRenderer neckLower;
	protected final ModelRenderer neck;
	protected final ModelRenderer head;
	protected final ModelRenderer beak;
	private final ModelRenderer legUpperLeft;
	private final ModelRenderer legUpperRight;
	private final ModelRenderer legLowerLeft;
	private final ModelRenderer legLowerRight;
	private final ModelRenderer talonInnerLeft;
	private final ModelRenderer talonInnerRight;
	private final ModelRenderer talonOuterLeft;
	private final ModelRenderer talonOuterRight;
	private final ModelRenderer saddle;
	
	public OstrichModel() {
		super(true, 24.0F, 1.36F, 2.7272F, 2.0F, 24.0F);
		this.textureWidth = 64;
		this.textureHeight = 64;

		this.body = new ModelRenderer(this, 0, 50);
		this.body.addBox(-5.0F, -5.0F, -8.0F, 10.0F, 10.0F, 16.0F);
		this.body.setRotationPoint(0.0F, 3.0F, 0.0F);
		
		this.tail = new ModelRenderer(this, 0, 15);
		this.tail.addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 3.0F);
		this.tail.setRotationPoint(0.0F, -2.0F, 8.0F);
		this.body.addChild(this.tail);
		
		this.wingLeft = new ModelRenderer(this, 0, 50);
		this.wingLeft.mirror = true;
		this.wingLeft.addBox(0.0F, -5.0F, 0.0F, 1.0F, 10.0F, 12.0F);
		this.wingLeft.setRotationPoint(5.0F, 0F, -7.0F);
		this.body.addChild(this.wingLeft);
		
		this.wingRight = new ModelRenderer(this, 0, 50);
		this.wingRight.addBox(-1.0F, -5.0F, 0.0F, 1.0F, 10.0F, 12.0F);
		this.wingRight.setRotationPoint(-5.0F, 0F, -7.0F);
		this.body.addChild(this.wingRight);

		this.legUpperLeft = new ModelRenderer(this, 0, 40);
		this.legUpperLeft.mirror = true;
		this.legUpperLeft.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F);
		this.legUpperLeft.setRotationPoint(3.0F, 5.0F, 0.0F);
		this.body.addChild(this.legUpperLeft);
		
		this.legUpperRight = new ModelRenderer(this, 0, 40);
		this.legUpperRight.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F);
		this.legUpperRight.setRotationPoint(-3.0F, 5.0F, 0.0F);
		this.body.addChild(this.legUpperRight);
		
		this.legLowerLeft = new ModelRenderer(this, 0, 40);
		this.legLowerLeft.mirror = true;
		this.legLowerLeft.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 10.0F, 2.0F);
		this.legLowerLeft.setRotationPoint(0.0F, 6.0F, 2.0F);
		this.legUpperLeft.addChild(this.legLowerLeft);
		
		this.legLowerRight = new ModelRenderer(this, 0, 40);
		this.legLowerRight.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 10.0F, 2.0F);
		this.legLowerRight.setRotationPoint(0.0F, 6.0F, 2.0F);
		this.legUpperRight.addChild(this.legLowerRight);
		
		this.talonInnerLeft = new ModelRenderer(this, 47, 26);
		this.talonInnerLeft.mirror = true;
		this.talonInnerLeft.addBox(-1.0F, 9.0F, -5.0F, 1.0F, 1.0F, 3.0F);
		this.legLowerLeft.addChild(talonInnerLeft);
		
		this.talonInnerRight = new ModelRenderer(this, 47, 26);
		this.talonInnerRight.addBox(0.0F, 9.0F, -5.0F, 1.0F, 1.0F, 3.0F);
		this.legLowerRight.addChild(talonInnerRight);
		
		this.talonOuterLeft = new ModelRenderer(this, 47, 26);
		this.talonOuterLeft.mirror = true;
		this.talonOuterLeft.addBox(0.0F, 9.0F, -2.0F, 1.0F, 1.0F, 2.0F);
		this.talonOuterLeft.setRotationPoint(0.0F, 0.0F, -2.0F);
		this.legLowerLeft.addChild(talonOuterLeft);
		
		this.talonOuterRight = new ModelRenderer(this, 47, 26);
		this.talonOuterRight.addBox(-1.0F, 9.0F, -2.0F, 1.0F, 1.0F, 2.0F);
		this.talonOuterRight.setRotationPoint(0.0F, 0.0F, -2.0F);
		this.legLowerRight.addChild(talonOuterRight);
		
		this.neckLower = new ModelRenderer(this, 0, 35);
		this.neckLower.addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 5.0F);
		this.neckLower.setRotationPoint(0.0F, 2.0F, -8.0F);
		
		this.neck = new ModelRenderer(this, 0, 35);
		this.neck.addBox(-1.0F, -10.0F, 0.0F, 2.0F, 10.0F, 2.0F);
		this.neck.setRotationPoint(0.0F, 0.0F, -5.0F);
		this.neckLower.addChild(this.neck);
		
		this.head = new ModelRenderer(this, 0, 13);
		this.head.addBox(-2.0F, -13.0F, -2.0F, 4.0F, 3.0F, 4.0F);
		this.neck.addChild(this.head);
		
		this.beak = new ModelRenderer(this, 0, 25);
		this.beak.addBox(-1.0F, -11.0F, -4.0F, 2.0F, 1.0F, 2.0F);
		this.head.addChild(this.beak);
		
		this.saddle = new ModelRenderer(this, 26, 0);
		this.saddle.addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 9.0F, 0.5F);
		this.body.addChild(this.saddle);	
	}

	public Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of(this.neckLower);
	}

	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.body);
	}

	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netneckYaw, float neckPitch) {
		this.talonOuterLeft.rotateAngleY = -((float) Math.PI / 6F);
		this.talonOuterRight.rotateAngleY = ((float) Math.PI / 6F);
		boolean flag = entityIn.isHorseSaddled();
		saddle.showModel = flag;
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
		boolean wingsFlapping = ((OstrichEntity) entityIn).wingCounter != 0;
		
		this.neckLower.rotationPointY = 2.0F;
		this.neckLower.rotationPointZ = -8.0F;
		
		this.neckLower.rotationPointY = f7 * this.neckLower.rotationPointY - f6;
	    this.neckLower.rotationPointZ = f7 * this.neckLower.rotationPointZ - 3*f6;
		this.neckLower.rotateAngleX = -((float) Math.PI / 4F) + MathHelper.sin(f10 * limbSwing) / 5;
		this.neck.rotateAngleX = ((float) Math.PI / 4F) - MathHelper.sin(f10 * limbSwing) / 10;

		this.body.rotateAngleX = 0.0F;
		
		this.neckLower.rotateAngleY = f3 * ((float) Math.PI / 180F);
		
	    this.body.rotateAngleX = f6 * (-(float) Math.PI / 4F) + this.body.rotateAngleX;

		this.legUpperRight.rotateAngleX = ((MathHelper.sin(f10 * limbSwing * 0.25F) * MathHelper.sin(f10 * limbSwing * 0.25F)) * limbSwingAmount * 1.5F) + f6 / 2 * MathHelper.sin(f9 * 0.25F) * f6 * MathHelper.sin(f9 * 0.25F);
		this.legLowerRight.rotateAngleX = -(MathHelper.cos(f10 * limbSwing * 0.25F + (float) Math.PI / 4F) * MathHelper.cos(f10 * limbSwing * 0.25F + (float) Math.PI / 4F)) * limbSwingAmount * 1.5F - f6 * MathHelper.cos(f9 * 0.5F - (float) Math.PI / 4) * f6 * MathHelper.cos(f9 * 0.5F - (float) Math.PI / 4);

		this.legUpperLeft.rotateAngleX = ((MathHelper.cos(f10 * limbSwing * 0.25F) * MathHelper.cos(f10 * limbSwing * 0.25F)) * limbSwingAmount * 1.5F) + f6 / 2 * MathHelper.cos(f9 * 0.25F) * f6 * MathHelper.cos(f9 * 0.25F);
		this.legLowerLeft.rotateAngleX = -(MathHelper.sin(f10 * limbSwing * 0.25F + (float) Math.PI / 4F) * MathHelper.sin(f10 * limbSwing * 0.25F + (float) Math.PI / 4F)) * limbSwingAmount * 1.5F - f6 * MathHelper.sin(f9 * 0.5F - (float) Math.PI / 4) * f6 * MathHelper.sin(f9 * 0.5F - (float) Math.PI / 4);

		if (tailWagging) {
			this.tail.rotateAngleY = MathHelper.cos(f9/2)/2;
		} else {
			this.tail.rotateAngleY = 0.0F;
		}
		
		if (wingsFlapping) {
			this.wingLeft.rotateAngleY = MathHelper.cos((float) entityIn.ticksExisted/2 + partialTick)*MathHelper.cos((float) entityIn.ticksExisted/2 + partialTick);
			this.wingRight.rotateAngleY = -(MathHelper.cos((float) entityIn.ticksExisted/2 + partialTick)*MathHelper.cos((float) entityIn.ticksExisted/2 + partialTick));
		} else {
			this.wingLeft.rotateAngleY = 0.0F;
			this.wingRight.rotateAngleY = 0.0F;
		}
	}
}
