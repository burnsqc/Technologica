package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;

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
	private final ModelRenderer leftBit;
	private final ModelRenderer rightBit;
	private final ModelRenderer headBridle;
	private final ModelRenderer noseBridle;
	private final ModelRenderer leftReign;
	private final ModelRenderer rightReign;
	private final ModelRenderer[] saddles;
	private final ModelRenderer[] reigns;

	public OstrichModel() {
		super(false, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		
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
		return ImmutableList.of(this.neckLower);
	}

	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.body);
	}

	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netneckYaw, float neckPitch) {
		
		this.neckLower.rotateAngleX = -((float) Math.PI / 4F);
		this.neck.rotateAngleX = ((float) Math.PI / 4F);
		
		boolean flag = entityIn.isHorseSaddled();
		boolean flag1 = entityIn.isBeingRidden();
		
		for (ModelRenderer modelrenderer : this.saddles) {
			modelrenderer.showModel = flag;
		}
		for (ModelRenderer modelrenderer1 : this.reigns) {
			modelrenderer1.showModel = flag1 && flag;
		}

		//this.neck.rotateAngleX = ((float) Math.PI / 6F);
		
		this.talonOuterLeft.rotateAngleY = -((float) Math.PI / 6F);
		this.talonOuterRight.rotateAngleY = ((float) Math.PI / 6F);
	}

	
}
