package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.AnimalEntity;

public class FlamingoModel<T extends AnimalEntity> extends AgeableModel<T> {
	private final ModelRenderer head;
	private final ModelRenderer neck1;
	private final ModelRenderer neck2;
	private final ModelRenderer neck3;
	private final ModelRenderer neck4;
	private final ModelRenderer neck5;
	private final ModelRenderer body;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftLeg;
	private final ModelRenderer rightLegLower;
	private final ModelRenderer leftLegLower;
	private final ModelRenderer rightWing;
	private final ModelRenderer leftWing;
	private final ModelRenderer bill;

	public FlamingoModel() {
		texWidth = 64;
		texHeight = 32;
		
		this.neck1 = new ModelRenderer(this, 14, 23);
		this.neck1.addBox(-1.0F, -2.0F, -4.0F, 2.0F, 2.0F, 4.0F);
		this.neck1.setPos(0.0F, 12.0F, -4.0F);
		
		this.neck2 = new ModelRenderer(this, 14, 23);
		this.neck2.addBox(-1.0F, -2.0F, -4.0F, 2.0F, 2.0F, 4.0F);
		this.neck2.setPos(0.0F, 0.0F, -4.0F);
		this.neck1.addChild(this.neck2);
		
		this.neck3 = new ModelRenderer(this, 14, 23);
		this.neck3.addBox(-1.0F, -2.0F, -4.0F, 2.0F, 2.0F, 4.0F);
		this.neck3.setPos(0.0F, 0.0F, -4.0F);
		this.neck2.addChild(this.neck3);
		
		this.neck4 = new ModelRenderer(this, 14, 23);
		this.neck4.addBox(-1.0F, 0.0F, -4.0F, 2.0F, 2.0F, 4.0F);
		this.neck4.setPos(0.0F, -2.0F, -4.0F);
		this.neck3.addChild(this.neck4);
		
		this.neck5 = new ModelRenderer(this, 14, 23);
		this.neck5.addBox(-1.0F, 0.0F, -4.0F, 2.0F, 2.0F, 4.0F);
		this.neck5.setPos(0.0F, 0.0F, -4.0F);
		this.neck4.addChild(this.neck5);
		
		this.head = new ModelRenderer(this, 20, 0);
		this.head.addBox(-1.5F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F);
		this.head.setPos(0.0F, 0.0F, -4.0F);
		this.neck5.addChild(this.head);
		
		this.bill = new ModelRenderer(this, 0, 14);
		this.bill.addBox(-1.0F, 1.0F, -6.0F, 2.0F, 2.0F, 3.0F);
		this.head.addChild(this.bill);
		
		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-3.0F, -3.0F, -4.0F, 6.0F, 6.0F, 8.0F);
		this.body.setPos(0.0F, 9.0F, 0.0F);
		
		this.rightLeg = new ModelRenderer(this, 10, 14);
		this.rightLeg.addBox(-1.0F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F);
		this.rightLeg.setPos(-2.0F, 12.0F, 0.0F);
		
		this.leftLeg = new ModelRenderer(this, 10, 14);
		this.leftLeg.addBox(-1.0F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F);
		this.leftLeg.setPos(1.0F, 12.0F, 0.0F);
		
		this.rightLegLower = new ModelRenderer(this, 22, 14);
		this.rightLegLower.addBox(-1.0F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F);
		this.rightLegLower.setPos(0.0F, 6.0F, 0.0F);
		this.rightLeg.addChild(this.rightLegLower);
		
		this.leftLegLower = new ModelRenderer(this, 22, 14);
		this.leftLegLower.addBox(-1.0F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F);
		this.leftLegLower.setPos(0.0F, 6.0F, 0.0F);
		this.leftLeg.addChild(this.leftLegLower);
		
		this.rightWing = new ModelRenderer(this, 0, 19);
		this.rightWing.addBox(0.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F);
		this.rightWing.setPos(-4.0F, 7.0F, 0.0F);
		this.rightWing.mirror = true;
		
		this.leftWing = new ModelRenderer(this, 0, 19);
		this.leftWing.addBox(-1.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F);
		this.leftWing.setPos(4.0F, 7.0F, 0.0F);
	}

	@Override
	protected Iterable<ModelRenderer> headParts() {
		return ImmutableList.of(this.neck1);
	}

	@Override
	protected Iterable<ModelRenderer> bodyParts() {
		return ImmutableList.of(this.body, this.rightLeg, this.leftLeg, this.rightWing, this.leftWing);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.neck1.xRot = -(float)Math.PI/4;
		this.neck2.xRot = -(float)Math.PI/4;
		this.neck3.xRot = -(float)Math.PI/4;
		this.neck4.xRot = (float)Math.PI/4;
		this.neck5.xRot = (float)Math.PI/4;
		this.head.xRot = (float)Math.PI/4;
	}

}
