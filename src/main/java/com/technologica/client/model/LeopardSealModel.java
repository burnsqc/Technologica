package com.technologica.client.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class LeopardSealModel<T extends Entity> extends ListModel<T> {
	/*
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart nose;
	private final ModelPart jaw;
	private final ModelPart flipperLeft;
	private final ModelPart flipperRight;
	private final ModelPart tail;
	private final ModelPart tailFlipperLeft;
	private final ModelPart tailFlipperRight;
	*/

	public LeopardSealModel() {
		/*
		this.texWidth = 64;
		this.texHeight = 64;

		this.body = new ModelPart(this, 20, 2);
		this.body.setPos(0.0F, 20.0F, 0.0F);
		this.body.addBox(-4.0F, -4.0F, -7.0F, 8.0F, 8.0F, 14.0F);
		
		this.head = new ModelPart(this, 0, 16);
		this.head.setPos(0.0F, 0.0F, -7.0F);
		this.head.addBox(-3.0F, -3.0F, -4.0F, 6.0F, 6.0F, 4.0F);
		this.body.addChild(this.head);

		this.nose = new ModelPart(this, 16, 24);
		this.nose.setPos(0.0F, -1.0F, -4.0F);
		this.nose.addBox(-2.0F, -1.0F, -4.0F, 4.0F, 3.0F, 4.0F);
		this.head.addChild(this.nose);
		
		this.jaw = new ModelPart(this, 0, 26);
		this.jaw.setPos(0.0F, 1.0F, -4.0F);
		this.jaw.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 1.0F, 4.0F);
		this.head.addChild(this.jaw);

		this.flipperLeft = new ModelPart(this, 32, 24);
		this.flipperLeft.setPos(4.0F, 1.0F, -4.0F);
		this.flipperLeft.addBox(0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 4.0F);
		this.flipperLeft.mirror = true;
		this.body.addChild(this.flipperLeft);

		this.flipperRight = new ModelPart(this, 32, 24);
		this.flipperRight.setPos(-4.0F, 1.0F, -4.0F);
		this.flipperRight.addBox(-8.0F, 0.0F, 0.0F, 8.0F, 1.0F, 4.0F);
		this.body.addChild(this.flipperRight);

		this.tail = new ModelPart(this, 0, 0);
		this.tail.setPos(0.0F, 0.0F, 7.0F);
		this.tail.addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 10.0F);
		this.body.addChild(this.tail);

		this.tailFlipperLeft = new ModelPart(this, 0, 31);
		this.tailFlipperLeft.setPos(2.0F, 0.0F, 10.0F);
		this.tailFlipperLeft.addBox(0.0F, -3.0F, 0.0F, 1.0F, 6.0F, 8.0F);
		this.flipperLeft.mirror = true;
		this.tail.addChild(this.tailFlipperLeft);

		this.tailFlipperRight = new ModelPart(this, 0, 31);
		this.tailFlipperRight.setPos(-2.0F, 0.0F, 10.0F);
		this.tailFlipperRight.addBox(-1.0F, -3.0F, 0.0F, 1.0F, 6.0F, 8.0F);
		this.tail.addChild(this.tailFlipperRight);
		*/
	}

	@Override
	public Iterable<ModelPart> parts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setupAnim(T p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_,
			float p_102623_) {
		// TODO Auto-generated method stub
		
	}

	/*
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.body);
	}

	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.jaw.xRot = (Mth.sin(ageInTicks / 10) * Mth.sin(ageInTicks / 10))/2;
		
		this.tailFlipperLeft.yRot = (float) Math.PI / 8;
		this.tailFlipperRight.yRot = -(float) Math.PI / 8;
		
		this.flipperLeft.yRot = -(float) Math.PI / 4;
		this.flipperLeft.zRot = (float) Math.PI / 8;
		
		this.flipperRight.yRot = (float) Math.PI / 4;
		this.flipperRight.zRot = -(float) Math.PI / 8;

		this.body.xRot = headPitch * ((float) Math.PI / 180F);
		this.body.yRot = netHeadYaw * ((float) Math.PI / 180F);
		if (Entity.getHorizontalDistanceSqr(entityIn.getDeltaMovement()) > 1.0E-7D) {
			this.body.xRot += -0.05F + -0.05F * Mth.cos(ageInTicks * 0.3F);
			this.tail.yRot = -0.1F * Mth.cos(ageInTicks * 0.3F);
			this.tailFlipperLeft.yRot = -0.2F * Mth.cos(ageInTicks * 0.3F);
			this.tailFlipperRight.yRot = -0.2F * Mth.cos(ageInTicks * 0.3F);
		}
	}
	*/
}
