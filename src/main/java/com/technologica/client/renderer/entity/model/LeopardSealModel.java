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
		this.texWidth = 64;
		this.texHeight = 64;

		this.body = new ModelRenderer(this, 20, 2);
		this.body.setPos(0.0F, 20.0F, 0.0F);
		this.body.addBox(-4.0F, -4.0F, -7.0F, 8.0F, 8.0F, 14.0F);
		
		this.head = new ModelRenderer(this, 0, 16);
		this.head.setPos(0.0F, 0.0F, -7.0F);
		this.head.addBox(-3.0F, -3.0F, -4.0F, 6.0F, 6.0F, 4.0F);
		this.body.addChild(this.head);

		this.nose = new ModelRenderer(this, 16, 24);
		this.nose.setPos(0.0F, -1.0F, -4.0F);
		this.nose.addBox(-2.0F, -1.0F, -4.0F, 4.0F, 3.0F, 4.0F);
		this.head.addChild(this.nose);
		
		this.jaw = new ModelRenderer(this, 0, 26);
		this.jaw.setPos(0.0F, 1.0F, -4.0F);
		this.jaw.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 1.0F, 4.0F);
		this.head.addChild(this.jaw);

		this.flipperLeft = new ModelRenderer(this, 32, 24);
		this.flipperLeft.setPos(4.0F, 1.0F, -4.0F);
		this.flipperLeft.addBox(0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 4.0F);
		this.flipperLeft.mirror = true;
		this.body.addChild(this.flipperLeft);

		this.flipperRight = new ModelRenderer(this, 32, 24);
		this.flipperRight.setPos(-4.0F, 1.0F, -4.0F);
		this.flipperRight.addBox(-8.0F, 0.0F, 0.0F, 8.0F, 1.0F, 4.0F);
		this.body.addChild(this.flipperRight);

		this.tail = new ModelRenderer(this, 0, 0);
		this.tail.setPos(0.0F, 0.0F, 7.0F);
		this.tail.addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 10.0F);
		this.body.addChild(this.tail);

		this.tailFlipperLeft = new ModelRenderer(this, 0, 31);
		this.tailFlipperLeft.setPos(2.0F, 0.0F, 10.0F);
		this.tailFlipperLeft.addBox(0.0F, -3.0F, 0.0F, 1.0F, 6.0F, 8.0F);
		this.flipperLeft.mirror = true;
		this.tail.addChild(this.tailFlipperLeft);

		this.tailFlipperRight = new ModelRenderer(this, 0, 31);
		this.tailFlipperRight.setPos(-2.0F, 0.0F, 10.0F);
		this.tailFlipperRight.addBox(-1.0F, -3.0F, 0.0F, 1.0F, 6.0F, 8.0F);
		this.tail.addChild(this.tailFlipperRight);
	}

	public Iterable<ModelRenderer> parts() {
		return ImmutableList.of(this.body);
	}

	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.jaw.xRot = (MathHelper.sin(ageInTicks / 10) * MathHelper.sin(ageInTicks / 10))/2;
		
		this.tailFlipperLeft.yRot = (float) Math.PI / 8;
		this.tailFlipperRight.yRot = -(float) Math.PI / 8;
		
		this.flipperLeft.yRot = -(float) Math.PI / 4;
		this.flipperLeft.zRot = (float) Math.PI / 8;
		
		this.flipperRight.yRot = (float) Math.PI / 4;
		this.flipperRight.zRot = -(float) Math.PI / 8;

		this.body.xRot = headPitch * ((float) Math.PI / 180F);
		this.body.yRot = netHeadYaw * ((float) Math.PI / 180F);
		if (Entity.getHorizontalDistanceSqr(entityIn.getDeltaMovement()) > 1.0E-7D) {
			this.body.xRot += -0.05F + -0.05F * MathHelper.cos(ageInTicks * 0.3F);
			this.tail.yRot = -0.1F * MathHelper.cos(ageInTicks * 0.3F);
			this.tailFlipperLeft.yRot = -0.2F * MathHelper.cos(ageInTicks * 0.3F);
			this.tailFlipperRight.yRot = -0.2F * MathHelper.cos(ageInTicks * 0.3F);
		}
	}
}
