package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class SharkModel<T extends Entity> extends SegmentedModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer nose;
	private final ModelRenderer dorsalFin;
	private final ModelRenderer pectoralFinLeft;
	private final ModelRenderer pectoralFinRight;
	private final ModelRenderer tail;
	private final ModelRenderer tailFinTop;
	private final ModelRenderer tailFinBottom;

	public SharkModel() {
		this.texWidth = 64;
		this.texHeight = 64;

		this.body = new ModelRenderer(this, 22, 0);
		this.body.addBox(-4.0F, -7.0F, 0.0F, 8.0F, 7.0F, 13.0F);
		this.body.setPos(0.0F, 22.0F, -5.0F);

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-4.0F, -3.0F, -3.0F, 8.0F, 7.0F, 6.0F);
		this.head.setPos(0.0F, -4.0F, -3.0F);
		this.body.addChild(this.head);

		this.nose = new ModelRenderer(this, 0, 13);
		this.nose.addBox(-0.35F, -3.0F, -4.65F, 5.0F, 6.0F, 5.0F);
		this.nose.setPos(0.0F, 0.0F, 0.0F);
		this.nose.yRot = ((float) Math.PI / 4F);
		this.head.addChild(this.nose);

		this.dorsalFin = new ModelRenderer(this, 51, 0);
		this.dorsalFin.addBox(-0.5F, 0.0F, 8.0F, 1.0F, 4.0F, 5.0F);
		this.dorsalFin.xRot = ((float) Math.PI / 3F);
		this.body.addChild(this.dorsalFin);

		this.pectoralFinLeft = new ModelRenderer(this, 48, 20);
		this.pectoralFinLeft.mirror = true;
		this.pectoralFinLeft.addBox(-0.5F, -4.0F, 0.0F, 1.0F, 4.0F, 7.0F);
		this.pectoralFinLeft.setPos(2.0F, -2.0F, 4.0F);
		this.pectoralFinLeft.xRot = ((float) Math.PI / 3F);
		this.pectoralFinLeft.zRot = 2.0943952F;
		this.body.addChild(this.pectoralFinLeft);

		this.pectoralFinRight = new ModelRenderer(this, 48, 20);
		this.pectoralFinRight.addBox(-0.5F, -4.0F, 0.0F, 1.0F, 4.0F, 7.0F);
		this.pectoralFinRight.setPos(-2.0F, -2.0F, 4.0F);
		this.pectoralFinRight.xRot = ((float) Math.PI / 3F);
		this.pectoralFinRight.zRot = -2.0943952F;
		this.body.addChild(this.pectoralFinRight);

		this.tail = new ModelRenderer(this, 0, 35);
		this.tail.addBox(-2.0F, -3.5F, 0.0F, 4.0F, 5.0F, 11.0F);
		this.tail.setPos(0.0F, -2.5F, 11.0F);
		this.tail.yRot = -0.10471976F;
		this.body.addChild(this.tail);

		this.tailFinTop = new ModelRenderer(this, 30, 20);
		this.tailFinTop.addBox(-0.5F, -1.5F, 1.0F, 1.0F, 3.0F, 7.0F);
		this.tailFinTop.setPos(0.0F, 0.0F, 9.0F);
		this.tailFinTop.xRot = ((float) Math.PI / 3F);
		this.tailFinTop.yRot = 0.0F;
		this.tail.addChild(this.tailFinTop);

		this.tailFinBottom = new ModelRenderer(this, 13, 17);
		this.tailFinBottom.addBox(-0.5F, -3.0F, -2.0F, 1.0F, 3.0F, 7.0F);
		this.tailFinBottom.setPos(0.0F, 0.0F, 9.0F);
		this.tailFinBottom.xRot = -((float) Math.PI / 3F);
		this.tailFinBottom.yRot = 0.0F;
		this.tail.addChild(this.tailFinBottom);
	}

	public Iterable<ModelRenderer> parts() {
		return ImmutableList.of(this.body);
	}

	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.xRot = headPitch * ((float) Math.PI / 180F);
		this.body.yRot = netHeadYaw * ((float) Math.PI / 180F);
		if (Entity.getHorizontalDistanceSqr(entityIn.getDeltaMovement()) > 1.0E-7D) {
			this.body.xRot += -0.05F + -0.05F * MathHelper.cos(ageInTicks * 0.3F);
			this.tail.yRot = -0.1F * MathHelper.cos(ageInTicks * 0.3F);
			this.tailFinTop.yRot = -0.2F * MathHelper.cos(ageInTicks * 0.3F);
			this.tailFinBottom.yRot = -0.2F * MathHelper.cos(ageInTicks * 0.3F);
		}
	}
}
