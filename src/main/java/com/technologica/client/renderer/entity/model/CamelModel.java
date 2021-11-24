package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import com.technologica.entity.passive.CamelEntity;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class CamelModel<T extends CamelEntity> extends AgeableModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer neck;
	private final ModelRenderer mane;
	private final ModelRenderer head;
	private final ModelRenderer nose;
	private final ModelRenderer earLeft;
	private final ModelRenderer earRight;
	private final ModelRenderer hornLeft;
	private final ModelRenderer hornRight;
	private final ModelRenderer legUpperBackLeft;
	private final ModelRenderer legUpperBackRight;
	private final ModelRenderer legUpperFrontLeft;
	private final ModelRenderer legUpperFrontRight;
	private final ModelRenderer legLowerBackLeft;
	private final ModelRenderer legLowerBackRight;
	private final ModelRenderer legLowerFrontLeft;
	private final ModelRenderer legLowerFrontRight;
	private final ModelRenderer tail;



	public CamelModel() {
		this.textureWidth = 64;
		this.textureHeight = 64;

		this.body = new ModelRenderer(this, 0, 32);
		this.body.addBox(-5.0F, -31.0F, -17.0F, 10.0F, 12.0F, 22.0F);
		this.body.setRotationPoint(0.0F, 28.0F, 3.0F);

		this.neck = new ModelRenderer(this, 0, 35);
		this.neck.addBox(-2.0F, -38.0F, -6.0F, 4.0F, 37.0F, 6.0F);
		this.neck.setRotationPoint(0.0F, -16.0F, -8.0F);

		this.mane = new ModelRenderer(this, 56, 36);
		this.mane.addBox(-1.0F, -40.0F, 0.0F, 2.0F, 37.0F, 2.0F);
		this.neck.addChild(mane);

		this.head = new ModelRenderer(this, 0, 13);
		this.head.addBox(-3.0F, -5.0F, -9.0F, 6.0F, 5.0F, 9.0F);
		this.head.setRotationPoint(0.0F, -35.0F, 0.0F);
		this.neck.addChild(head);

		this.nose = new ModelRenderer(this, 0, 25);
		this.nose.addBox(-1.5F, -4.0F, -15.0F, 3.0F, 4.0F, 6.0F);
		this.head.addChild(nose);

		this.earLeft = new ModelRenderer(this, 19, 16);
		this.earLeft.addBox(0F, -3.0F, -1.0F, 4.0F, 3.0F, 1.0F, 0.0F);
		this.earLeft.setRotationPoint(3.0F, -1.0F, -2.0F);
		this.head.addChild(earLeft);

		this.earRight = new ModelRenderer(this, 19, 16);
		this.earRight.addBox(-4.0F, -3.0F, -1.0F, 4.0F, 3.0F, 1.0F, 0.0F);
		this.earRight.setRotationPoint(-3.0F, -1.0F, -2.0F);
		this.head.addChild(earRight);

		this.hornLeft = new ModelRenderer(this, 19, 16);
		this.hornLeft.addBox(1.0F, -7.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F);
		this.head.addChild(hornLeft);

		this.hornRight = new ModelRenderer(this, 19, 16);
		this.hornRight.addBox(-2.0F, -7.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F);
		this.head.addChild(hornRight);

		this.legUpperBackLeft = new ModelRenderer(this, 48, 21);
		this.legUpperBackLeft.mirror = true;
		this.legUpperBackLeft.addBox(-1.99F, -4.0F, -3.99F, 3.98F, 12.0F, 3.98F, 0.0F);
		this.legUpperBackLeft.setRotationPoint(3.0F, -19.0F, 5.0F);
		this.body.addChild(this.legUpperBackLeft);

		this.legUpperBackRight = new ModelRenderer(this, 48, 21);
		this.legUpperBackRight.addBox(-1.99F, -4.0F, -3.99F, 3.98F, 12.0F, 3.98F, 0.0F);
		this.legUpperBackRight.setRotationPoint(-3.0F, -19.0F, 5.0F);
		this.body.addChild(this.legUpperBackRight);

		this.legUpperFrontLeft = new ModelRenderer(this, 48, 21);
		this.legUpperFrontLeft.mirror = true;
		this.legUpperFrontLeft.addBox(-1.99F, -4.0F, 0.01F, 3.98F, 18.0F, 3.98F, 0.0F);
		this.legUpperFrontLeft.setRotationPoint(3.0F, -19.0F, -17.0F);
		this.body.addChild(this.legUpperFrontLeft);

		this.legUpperFrontRight = new ModelRenderer(this, 48, 21);
		this.legUpperFrontRight.addBox(-1.99F, -4.0F, 0.01F, 3.98F, 18.0F, 3.98F, 0.0F);
		this.legUpperFrontRight.setRotationPoint(-3.0F, -19.0F, -17.0F);
		this.body.addChild(this.legUpperFrontRight);

		this.legLowerBackLeft = new ModelRenderer(this, 48, 21);
		this.legLowerBackLeft.mirror = true;
		this.legLowerBackLeft.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 24.0F, 4.0F, 0.0F);
		this.legLowerBackLeft.setRotationPoint(0.0F, 8.0F, 0.0F);
		this.legUpperBackLeft.addChild(this.legLowerBackLeft);

		this.legLowerBackRight = new ModelRenderer(this, 48, 21);
		this.legLowerBackRight.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 24.0F, 4.0F, 0.0F);
		this.legLowerBackRight.setRotationPoint(0.0F, 8.0F, 0.0F);
		this.legUpperBackRight.addChild(this.legLowerBackRight);

		this.legLowerFrontLeft = new ModelRenderer(this, 48, 21);
		this.legLowerFrontLeft.mirror = true;
		this.legLowerFrontLeft.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 18.0F, 4.0F, 0.0F);
		this.legLowerFrontLeft.setRotationPoint(0.0F, 14.0F, 0.0F);
		this.legUpperFrontLeft.addChild(this.legLowerFrontLeft);

		this.legLowerFrontRight = new ModelRenderer(this, 48, 21);
		this.legLowerFrontRight.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 18.0F, 4.0F, 0.0F);
		this.legLowerFrontRight.setRotationPoint(0.0F, 14.0F, 0.0F);
		this.legUpperFrontRight.addChild(this.legLowerFrontRight);

		this.tail = new ModelRenderer(this, 42, 36);
		this.tail.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 16.0F, 2.0F);
		this.tail.setRotationPoint(0.0F, -30.0F, 5.0F);
		this.body.addChild(this.tail);

		
		
		
	}

	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.neck.rotateAngleX = ((float) Math.PI / 10F);
		this.head.rotateAngleX = -((float) Math.PI / 10F);
		this.earLeft.rotateAngleZ = -0.5F;
		this.earRight.rotateAngleZ = 0.5F;
		this.tail.rotateAngleX = ((float) Math.PI / 8F);

		this.body.rotationPointY = 11.0F;
	}

	public Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of(this.neck);
	}

	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.body);
	}

	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
	}
}