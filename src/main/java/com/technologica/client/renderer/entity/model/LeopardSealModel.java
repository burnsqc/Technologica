package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class LeopardSealModel<T extends Entity> extends SegmentedModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer nose;
	private final ModelRenderer jaw;
	private final ModelRenderer flipperLeft;
	private final ModelRenderer flipperRight;
	private final ModelRenderer tail;
	private final ModelRenderer tailFlipperLeft;
	private final ModelRenderer tailFlipperRight;

	public LeopardSealModel() {
		this.textureWidth = 64;
		this.textureHeight = 64;

		this.body = new ModelRenderer(this, 22, 0);
		this.body.setRotationPoint(0.0F, 20.0F, 0.0F);
		this.body.addBox(-4.0F, -4.0F, -7.0F, 8.0F, 8.0F, 14.0F);
		
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, -7.0F);
		this.head.addBox(-3.0F, -3.0F, -4.0F, 6.0F, 6.0F, 4.0F);
		this.body.addChild(this.head);

		this.nose = new ModelRenderer(this, 0, 13);
		this.nose.setRotationPoint(0.0F, -1.0F, -4.0F);
		this.nose.addBox(-2.0F, -1.0F, -4.0F, 4.0F, 3.0F, 4.0F);
		this.head.addChild(this.nose);
		
		this.jaw = new ModelRenderer(this, 0, 13);
		this.jaw.setRotationPoint(0.0F, 1.0F, -4.0F);
		this.jaw.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 1.0F, 4.0F);
		this.head.addChild(this.jaw);

		this.flipperLeft = new ModelRenderer(this, 48, 20);
		this.flipperLeft.setRotationPoint(4.0F, 1.0F, -4.0F);
		this.flipperLeft.addBox(0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 4.0F);
		this.flipperLeft.mirror = true;
		this.body.addChild(this.flipperLeft);

		this.flipperRight = new ModelRenderer(this, 48, 20);
		this.flipperRight.setRotationPoint(-4.0F, 1.0F, -4.0F);
		this.flipperRight.addBox(-8.0F, 0.0F, 0.0F, 8.0F, 1.0F, 4.0F);
		this.body.addChild(this.flipperRight);

		this.tail = new ModelRenderer(this, 0, 35);
		this.tail.setRotationPoint(0.0F, 0.0F, 7.0F);
		this.tail.addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 10.0F);
		this.body.addChild(this.tail);

		this.tailFlipperLeft = new ModelRenderer(this, 30, 20);
		this.tailFlipperLeft.setRotationPoint(2.0F, 0.0F, 10.0F);
		this.tailFlipperLeft.addBox(0.0F, -3.0F, 0.0F, 1.0F, 6.0F, 8.0F);
		this.flipperLeft.mirror = true;
		this.tail.addChild(this.tailFlipperLeft);

		this.tailFlipperRight = new ModelRenderer(this, 13, 17);
		this.tailFlipperRight.setRotationPoint(-2.0F, 0.0F, 10.0F);
		this.tailFlipperRight.addBox(-1.0F, -3.0F, 0.0F, 1.0F, 6.0F, 8.0F);
		this.tail.addChild(this.tailFlipperRight);
	}

	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.body);
	}

	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.jaw.rotateAngleX = (MathHelper.sin(ageInTicks / 10) * MathHelper.sin(ageInTicks / 10))/2;
		
		this.tailFlipperLeft.rotateAngleY = (float) Math.PI / 8;
		this.tailFlipperRight.rotateAngleY = -(float) Math.PI / 8;
		
		this.flipperLeft.rotateAngleY = -(float) Math.PI / 4;
		this.flipperLeft.rotateAngleZ = (float) Math.PI / 8;
		
		this.flipperRight.rotateAngleY = (float) Math.PI / 4;
		this.flipperRight.rotateAngleZ = -(float) Math.PI / 8;

		this.body.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.body.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		if (Entity.horizontalMag(entityIn.getMotion()) > 1.0E-7D) {
			this.body.rotateAngleX += -0.05F + -0.05F * MathHelper.cos(ageInTicks * 0.3F);
			this.tail.rotateAngleY = -0.1F * MathHelper.cos(ageInTicks * 0.3F);
			this.tailFlipperLeft.rotateAngleY = -0.2F * MathHelper.cos(ageInTicks * 0.3F);
			this.tailFlipperRight.rotateAngleY = -0.2F * MathHelper.cos(ageInTicks * 0.3F);
		}
	}
}
