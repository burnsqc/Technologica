package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class NarwhalModel<T extends Entity> extends SegmentedModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer spear;
	private final ModelRenderer flipperLeft;
	private final ModelRenderer flipperRight;
	private final ModelRenderer tail;
	private final ModelRenderer tailFin;

	public NarwhalModel() {
		this.texWidth = 64;
		this.texHeight = 64;

		this.body = new ModelRenderer(this, 0, 0);
		this.body.setPos(0.0F, 20.0F, 0.0F);
		this.body.addBox(-4.0F, -4.0F, -7.0F, 8.0F, 8.0F, 14.0F);
		
		this.head = new ModelRenderer(this, 30, 0);
		this.head.setPos(0.0F, 0.0F, -7.0F);
		this.head.addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 6.0F);
		this.body.addChild(this.head);
		
		this.spear = new ModelRenderer(this, 28, 12);
		this.spear.setPos(0.0F, -1.0F, -6.0F);
		this.spear.addBox(-0.5F, 0.0F, -16.0F, 1.0F, 1.0F, 16.0F);
		this.head.addChild(this.spear);

		this.flipperLeft = new ModelRenderer(this, 0, 22);
		this.flipperLeft.setPos(4.0F, 2.0F, -4.0F);
		this.flipperLeft.addBox(0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 4.0F);
		this.flipperLeft.mirror = true;
		this.body.addChild(this.flipperLeft);

		this.flipperRight = new ModelRenderer(this, 0, 22);
		this.flipperRight.setPos(-4.0F, 2.0F, -4.0F);
		this.flipperRight.addBox(-8.0F, 0.0F, 0.0F, 8.0F, 1.0F, 4.0F);
		this.body.addChild(this.flipperRight);

		this.tail = new ModelRenderer(this, 0, 27);
		this.tail.setPos(0.0F, 0.0F, 7.0F);
		this.tail.addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 10.0F);
		this.body.addChild(this.tail);

		this.tailFin = new ModelRenderer(this, 0, 43);
		this.tailFin.setPos(0.0F, 0.0F, 8.0F);
		this.tailFin.addBox(-8.0F, 0.0F, 0.0F, 	16.0F, 1.0F, 6.0F);
		this.flipperLeft.mirror = true;
		this.tail.addChild(this.tailFin);
	}
	
	public Iterable<ModelRenderer> parts() {
		return ImmutableList.of(this.body);
	}

	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {	
		this.flipperLeft.yRot = -(float) Math.PI / 4;
		this.flipperLeft.zRot = (float) Math.PI / 8;
		
		this.flipperRight.yRot = (float) Math.PI / 4;
		this.flipperRight.zRot = -(float) Math.PI / 8;

		this.body.xRot = headPitch * ((float) Math.PI / 180F);
		this.body.yRot = netHeadYaw * ((float) Math.PI / 180F);
		if (Entity.getHorizontalDistanceSqr(entityIn.getDeltaMovement()) > 1.0E-7D) {
			this.body.xRot += -0.05F + -0.05F * MathHelper.cos(ageInTicks * 0.3F);
			this.tail.yRot = -0.1F * MathHelper.cos(ageInTicks * 0.3F);
			this.tailFin.yRot = -0.2F * MathHelper.cos(ageInTicks * 0.3F);
		}
	}
}
