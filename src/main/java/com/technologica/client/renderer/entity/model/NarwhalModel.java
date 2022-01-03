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
		this.textureWidth = 64;
		this.textureHeight = 64;

		this.body = new ModelRenderer(this, 22, 0);
		this.body.setRotationPoint(0.0F, 20.0F, 0.0F);
		this.body.addBox(-4.0F, -4.0F, -7.0F, 8.0F, 8.0F, 14.0F);
		
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, -7.0F);
		this.head.addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 6.0F);
		this.body.addChild(this.head);
		
		this.spear = new ModelRenderer(this, 0, 0);
		this.spear.setRotationPoint(0.0F, -1.0F, -6.0F);
		this.spear.addBox(-0.5F, 0.0F, -16.0F, 1.0F, 1.0F, 16.0F);
		this.head.addChild(this.spear);

		this.flipperLeft = new ModelRenderer(this, 48, 20);
		this.flipperLeft.setRotationPoint(4.0F, 2.0F, -4.0F);
		this.flipperLeft.addBox(0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 4.0F);
		this.flipperLeft.mirror = true;
		this.body.addChild(this.flipperLeft);

		this.flipperRight = new ModelRenderer(this, 48, 20);
		this.flipperRight.setRotationPoint(-4.0F, 2.0F, -4.0F);
		this.flipperRight.addBox(-8.0F, 0.0F, 0.0F, 8.0F, 1.0F, 4.0F);
		this.body.addChild(this.flipperRight);

		this.tail = new ModelRenderer(this, 0, 35);
		this.tail.setRotationPoint(0.0F, 0.0F, 7.0F);
		this.tail.addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 10.0F);
		this.body.addChild(this.tail);

		this.tailFin = new ModelRenderer(this, 30, 20);
		this.tailFin.setRotationPoint(0.0F, 0.0F, 8.0F);
		this.tailFin.addBox(-8.0F, 0.0F, 0.0F, 	16.0F, 1.0F, 6.0F);
		this.flipperLeft.mirror = true;
		this.tail.addChild(this.tailFin);
	}
	
	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.body);
	}

	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {	
		this.flipperLeft.rotateAngleY = -(float) Math.PI / 4;
		this.flipperLeft.rotateAngleZ = (float) Math.PI / 8;
		
		this.flipperRight.rotateAngleY = (float) Math.PI / 4;
		this.flipperRight.rotateAngleZ = -(float) Math.PI / 8;

		this.body.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.body.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		if (Entity.horizontalMag(entityIn.getMotion()) > 1.0E-7D) {
			this.body.rotateAngleX += -0.05F + -0.05F * MathHelper.cos(ageInTicks * 0.3F);
			this.tail.rotateAngleY = -0.1F * MathHelper.cos(ageInTicks * 0.3F);
			this.tailFin.rotateAngleY = -0.2F * MathHelper.cos(ageInTicks * 0.3F);
		}
	}
}
