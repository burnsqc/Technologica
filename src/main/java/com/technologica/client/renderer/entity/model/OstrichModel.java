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
		this.texWidth = 64;
		this.texHeight = 64;

		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-5.0F, -5.0F, -8.0F, 10.0F, 10.0F, 16.0F);
		this.body.setPos(0.0F, 3.0F, 0.0F);
		
		this.tail = new ModelRenderer(this, 36, 0);
		this.tail.addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 3.0F);
		this.tail.setPos(0.0F, -2.0F, 8.0F);
		this.body.addChild(this.tail);
		
		this.wingLeft = new ModelRenderer(this, 0, 26);
		this.wingLeft.mirror = true;
		this.wingLeft.addBox(0.0F, -5.0F, 0.0F, 1.0F, 10.0F, 12.0F);
		this.wingLeft.setPos(5.0F, 0F, -7.0F);
		this.body.addChild(this.wingLeft);
		
		this.wingRight = new ModelRenderer(this, 0, 26);
		this.wingRight.addBox(-1.0F, -5.0F, 0.0F, 1.0F, 10.0F, 12.0F);
		this.wingRight.setPos(-5.0F, 0F, -7.0F);
		this.body.addChild(this.wingRight);

		this.legUpperLeft = new ModelRenderer(this, 0, 26);
		this.legUpperLeft.mirror = true;
		this.legUpperLeft.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F);
		this.legUpperLeft.setPos(3.0F, 5.0F, 0.0F);
		this.body.addChild(this.legUpperLeft);
		
		this.legUpperRight = new ModelRenderer(this, 0, 26);
		this.legUpperRight.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F);
		this.legUpperRight.setPos(-3.0F, 5.0F, 0.0F);
		this.body.addChild(this.legUpperRight);
		
		this.legLowerLeft = new ModelRenderer(this, 18, 26);
		this.legLowerLeft.mirror = true;
		this.legLowerLeft.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 10.0F, 2.0F);
		this.legLowerLeft.setPos(0.0F, 6.0F, 2.0F);
		this.legUpperLeft.addChild(this.legLowerLeft);
		
		this.legLowerRight = new ModelRenderer(this, 18, 26);
		this.legLowerRight.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 10.0F, 2.0F);
		this.legLowerRight.setPos(0.0F, 6.0F, 2.0F);
		this.legUpperRight.addChild(this.legLowerRight);
		
		this.talonInnerLeft = new ModelRenderer(this, 0, 34);
		this.talonInnerLeft.mirror = true;
		this.talonInnerLeft.addBox(-1.0F, 9.0F, -5.0F, 1.0F, 1.0F, 3.0F);
		this.legLowerLeft.addChild(talonInnerLeft);
		
		this.talonInnerRight = new ModelRenderer(this, 0, 34);
		this.talonInnerRight.addBox(0.0F, 9.0F, -5.0F, 1.0F, 1.0F, 3.0F);
		this.legLowerRight.addChild(talonInnerRight);
		
		this.talonOuterLeft = new ModelRenderer(this, 6, 34);
		this.talonOuterLeft.mirror = true;
		this.talonOuterLeft.addBox(0.0F, 9.0F, -2.0F, 1.0F, 1.0F, 2.0F);
		this.talonOuterLeft.setPos(0.0F, 0.0F, -2.0F);
		this.legLowerLeft.addChild(talonOuterLeft);
		
		this.talonOuterRight = new ModelRenderer(this, 6, 34);
		this.talonOuterRight.addBox(-1.0F, 9.0F, -2.0F, 1.0F, 1.0F, 2.0F);
		this.talonOuterRight.setPos(0.0F, 0.0F, -2.0F);
		this.legLowerRight.addChild(talonOuterRight);
		
		this.neckLower = new ModelRenderer(this, 36, 7);
		this.neckLower.addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 5.0F);
		this.neckLower.setPos(0.0F, 2.0F, -8.0F);
		
		this.neck = new ModelRenderer(this, 50, 0);
		this.neck.addBox(-1.0F, -10.0F, 0.0F, 2.0F, 10.0F, 2.0F);
		this.neck.setPos(0.0F, 0.0F, -5.0F);
		this.neckLower.addChild(this.neck);
		
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-2.0F, -13.0F, -2.0F, 4.0F, 3.0F, 4.0F);
		this.neck.addChild(this.head);
		
		this.beak = new ModelRenderer(this, 0, 7);
		this.beak.addBox(-1.0F, -11.0F, -4.0F, 2.0F, 1.0F, 2.0F);
		this.head.addChild(this.beak);
		
		this.saddle = new ModelRenderer(this, 26, 26);
		this.saddle.addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 9.0F, 0.5F);
		this.body.addChild(this.saddle);	
	}

	public Iterable<ModelRenderer> headParts() {
		return ImmutableList.of(this.neckLower);
	}

	protected Iterable<ModelRenderer> bodyParts() {
		return ImmutableList.of(this.body);
	}

	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netneckYaw, float neckPitch) {
		this.talonOuterLeft.yRot = -((float) Math.PI / 6F);
		this.talonOuterRight.yRot = ((float) Math.PI / 6F);
		boolean flag = entityIn.isSaddled();
		saddle.visible = flag;
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
		boolean wingsFlapping = ((OstrichEntity) entityIn).wingCounter != 0;
		
		this.neckLower.y = 2.0F;
		this.neckLower.z = -8.0F;
		
		this.neckLower.y = f7 * this.neckLower.y - f6;
	    this.neckLower.z = f7 * this.neckLower.z - 3*f6;
		this.neckLower.xRot = -((float) Math.PI / 4F) + MathHelper.sin(f10 * limbSwing) / 5;
		this.neck.xRot = ((float) Math.PI / 4F) - MathHelper.sin(f10 * limbSwing) / 10;

		this.body.xRot = 0.0F;
		
		this.neckLower.yRot = f3 * ((float) Math.PI / 180F);
		
	    this.body.xRot = f6 * (-(float) Math.PI / 4F) + this.body.xRot;

		this.legUpperRight.xRot = ((MathHelper.sin(f10 * limbSwing * 0.25F) * MathHelper.sin(f10 * limbSwing * 0.25F)) * limbSwingAmount * 1.5F) + f6 / 2 * MathHelper.sin(f9 * 0.25F) * f6 * MathHelper.sin(f9 * 0.25F);
		this.legLowerRight.xRot = -(MathHelper.cos(f10 * limbSwing * 0.25F + (float) Math.PI / 4F) * MathHelper.cos(f10 * limbSwing * 0.25F + (float) Math.PI / 4F)) * limbSwingAmount * 1.5F - f6 * MathHelper.cos(f9 * 0.5F - (float) Math.PI / 4) * f6 * MathHelper.cos(f9 * 0.5F - (float) Math.PI / 4);

		this.legUpperLeft.xRot = ((MathHelper.cos(f10 * limbSwing * 0.25F) * MathHelper.cos(f10 * limbSwing * 0.25F)) * limbSwingAmount * 1.5F) + f6 / 2 * MathHelper.cos(f9 * 0.25F) * f6 * MathHelper.cos(f9 * 0.25F);
		this.legLowerLeft.xRot = -(MathHelper.sin(f10 * limbSwing * 0.25F + (float) Math.PI / 4F) * MathHelper.sin(f10 * limbSwing * 0.25F + (float) Math.PI / 4F)) * limbSwingAmount * 1.5F - f6 * MathHelper.sin(f9 * 0.5F - (float) Math.PI / 4) * f6 * MathHelper.sin(f9 * 0.5F - (float) Math.PI / 4);

		if (tailWagging) {
			this.tail.yRot = MathHelper.cos(f9/2)/2;
		} else {
			this.tail.yRot = 0.0F;
		}
		
		if (wingsFlapping) {
			this.wingLeft.yRot = MathHelper.cos((float) entityIn.tickCount/2 + partialTick)*MathHelper.cos((float) entityIn.tickCount/2 + partialTick);
			this.wingRight.yRot = -(MathHelper.cos((float) entityIn.tickCount/2 + partialTick)*MathHelper.cos((float) entityIn.tickCount/2 + partialTick));
		} else {
			this.wingLeft.yRot = 0.0F;
			this.wingRight.yRot = 0.0F;
		}
	}
}
