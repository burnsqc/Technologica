package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class VultureModel<T extends Entity> extends SegmentedModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer legLeft;
	private final ModelRenderer legRight;
	private final ModelRenderer neckLower;
	private final ModelRenderer neck;
	private final ModelRenderer head;
	private final ModelRenderer beak;
	private final ModelRenderer leftWingBody;
	private final ModelRenderer leftWing;
	private final ModelRenderer rightWingBody;
	private final ModelRenderer rightWing;
	private final ModelRenderer tail;

	public VultureModel() {
		this.textureWidth = 64;
		this.textureHeight = 64;

		this.body = new ModelRenderer(this, 0, 8);
		this.body.addBox(-2.5F, -2.0F, -8.0F, 5.0F, 3.0F, 9.0F);

		this.tail = new ModelRenderer(this, 3, 20);
		this.tail.addBox(-8.0F, -1.0F, -8.0F, 16.0F, 2.0F, 16.0F);
		this.tail.setRotationPoint(0.0F, -1.0F, 9.0F);
		this.body.addChild(this.tail);
		
		this.legLeft = new ModelRenderer(this, 3, 20);
		this.legLeft.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F);
		this.legLeft.setRotationPoint(-2.0F, 0.0F, -1.0F);
		this.body.addChild(this.legLeft);
		
		this.legRight = new ModelRenderer(this, 3, 20);
		this.legRight.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F);
		this.legRight.setRotationPoint(2.0F, 0.0F, -1.0F);
		this.body.addChild(this.legRight);

		this.leftWingBody = new ModelRenderer(this, 23, 12);
		this.leftWingBody.addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F);
		this.leftWingBody.setRotationPoint(2.5F, -2.0F, -8.0F);
		this.body.addChild(this.leftWingBody);

		this.leftWing = new ModelRenderer(this, 16, 24);
		this.leftWing.addBox(0.0F, 0.0F, 0.0F, 13.0F, 1.0F, 9.0F);
		this.leftWing.setRotationPoint(6.0F, 0.0F, 0.0F);
		this.leftWingBody.addChild(this.leftWing);

		this.rightWingBody = new ModelRenderer(this, 23, 12);
		this.rightWingBody.mirror = true;
		this.rightWingBody.addBox(-6.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F);
		this.rightWingBody.setRotationPoint(-2.5F, -2.0F, -8.0F);
		this.body.addChild(this.rightWingBody);

		this.rightWing = new ModelRenderer(this, 16, 24);
		this.rightWing.mirror = true;
		this.rightWing.addBox(-13.0F, 0.0F, 0.0F, 13.0F, 1.0F, 9.0F);
		this.rightWing.setRotationPoint(-6.0F, 0.0F, 0.0F);
		this.rightWingBody.addChild(this.rightWing);

		this.leftWingBody.rotateAngleZ = 0.1F;
		this.leftWing.rotateAngleZ = 0.1F;
		this.rightWingBody.rotateAngleZ = -0.1F;
		this.rightWing.rotateAngleZ = -0.1F;

		this.neckLower = new ModelRenderer(this, 0, 35);
		this.neckLower.addBox(-1.0F, 0.0F, -5.0F, 2.0F, 2.0F, 5.0F);
		this.neckLower.setRotationPoint(0.0F, -2.0F, -8.0F);
		this.body.addChild(this.neckLower);
		
		this.neck = new ModelRenderer(this, 0, 35);
		this.neck.addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 5.0F);
		this.neck.setRotationPoint(0.0F, 2.0F, -5.0F);
		this.neckLower.addChild(this.neck);
		
		this.head = new ModelRenderer(this, 0, 13);
		this.head.addBox(-1.5F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F);
		this.head.setRotationPoint(0.0F, -2.0F, -5.0F);
		this.neck.addChild(this.head);
		
		this.beak = new ModelRenderer(this, 0, 25);
		this.beak.addBox(-0.5F, 1.0F, -5.0F, 1.0F, 2.0F, 2.0F);
		this.head.addChild(this.beak);
	}

	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.body);
	}

	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float ageTicker = ((float) (entityIn.getEntityId() * 3) + ageInTicks) * 0.13F;
		this.body.rotateAngleX = -0.1F;
		this.leftWingBody.rotateAngleZ = MathHelper.cos(ageTicker) * 16.0F * ((float) Math.PI / 180F);
		this.leftWing.rotateAngleZ = MathHelper.cos(ageTicker) * 16.0F * ((float) Math.PI / 180F);
		this.rightWingBody.rotateAngleZ = -this.leftWingBody.rotateAngleZ;
		this.rightWing.rotateAngleZ = -this.leftWing.rotateAngleZ;
		this.tail.rotateAngleY = (float) Math.PI / 4;
		this.neckLower.rotateAngleX = (float) Math.PI / 4;
		this.neck.rotateAngleX = -(float) Math.PI / 3;
		this.head.rotateAngleX = (float) Math.PI / 4;
	}
}