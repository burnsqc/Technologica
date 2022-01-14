package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class WalrusModel<T extends Entity> extends SegmentedModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer tail;
	private final ModelRenderer tail2;
	
	private final ModelRenderer head;
	private final ModelRenderer nose;
	private final ModelRenderer tuskLeft;
	private final ModelRenderer tuskRight;
	
	private final ModelRenderer flipperFrontLeft;
	private final ModelRenderer flipperFrontRight;
	
	private final ModelRenderer flipperBackLeft;
	private final ModelRenderer flipperBackRight;

	public WalrusModel() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-10.0F, -10.0F, -8.0F, 20.0F, 20.0F, 16.0F);
		this.body.setRotationPoint(0.0F, 14.0F, -8.0F);

		this.tail = new ModelRenderer(this, 56, 20);
		this.tail.addBox(-8.0F, -8.0F, 0.0F, 16.0F, 16.0F, 16.0F);
		this.tail.setRotationPoint(0.0F, 2.0F, 8.0F);
		this.body.addChild(this.tail);
		
		this.tail2 = new ModelRenderer(this, 56, 0);
		this.tail2.addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 8.0F);
		this.tail2.setRotationPoint(0.0F, 4.0F, 16.0F);
		this.tail.addChild(this.tail2);
		
		this.head = new ModelRenderer(this, 88, 0);
		this.head.addBox(-5.0F, -3.0F, -3.0F, 10.0F, 10.0F, 10.0F);
		this.head.setRotationPoint(0.0F, -10.0F, -8.0F);
		this.body.addChild(this.head);
		
		this.nose = new ModelRenderer(this, 104, 20);
		this.nose.addBox(-4.0F, 2.0F, -5.0F, 8.0F, 4.0F, 2.0F);
		this.head.addChild(this.nose);
		
		this.tuskLeft = new ModelRenderer(this, 0, 0);
		this.tuskLeft.addBox(-3.0F, 6.0F, -4.0F, 1.0F, 6.0F, 1.0F);
		this.head.addChild(this.tuskLeft);
		
		this.tuskRight = new ModelRenderer(this, 0, 0);
		this.tuskRight.addBox(2.0F, 6.0F, -4.0F, 1.0F, 6.0F, 1.0F);
		this.head.addChild(this.tuskRight);

		this.flipperFrontLeft = new ModelRenderer(this, 104, 26);
		this.flipperFrontLeft.mirror = true;
		this.flipperFrontLeft.addBox(0.0F, -1.0F, -5.0F, 7.0F, 2.0F, 5.0F);
		this.flipperFrontLeft.setRotationPoint(10.0F, 9.0F, -2.0F);
		this.body.addChild(this.flipperFrontLeft);

		this.flipperFrontRight = new ModelRenderer(this, 104, 26);
		this.flipperFrontRight.addBox(-7.0F, -1.0F, -5.0F, 7.0F, 2.0F, 5.0F);
		this.flipperFrontRight.setRotationPoint(-10.0F, 9.0F, -2.0F);
		this.body.addChild(this.flipperFrontRight);

		this.flipperBackLeft = new ModelRenderer(this, 104, 26);
		this.flipperBackLeft.addBox(0.0F, -1.0F, 0.0F, 7.0F, 2.0F, 5.0F);
		this.flipperBackLeft.setRotationPoint(4.0F, 3.0F, 3.0F);
		this.tail2.addChild(this.flipperBackLeft);

		this.flipperBackRight = new ModelRenderer(this, 104, 26);
		this.flipperBackRight.addBox(-7.0F, -1.0F, 0.0F, 7.0F, 2.0F, 5.0F);
		this.flipperBackRight.setRotationPoint(-4.0F, 3.0F, 3.0F);
		this.tail2.addChild(this.flipperBackRight);
	}

	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.body);
	}

	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
