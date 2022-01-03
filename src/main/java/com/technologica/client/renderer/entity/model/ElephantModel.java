package com.technologica.client.renderer.entity.model;

import com.technologica.entity.passive.ElephantEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ElephantModel<T extends ElephantEntity> extends QuadrupedModel<T> {

	protected ModelRenderer earLeft;
	protected ModelRenderer earRight;
	protected ModelRenderer tuskLeft;
	protected ModelRenderer tuskRight;
	protected ModelRenderer trunk1;
	protected ModelRenderer trunk2;
	protected ModelRenderer trunk3;
	protected ModelRenderer tail;
	
	public ElephantModel() {
		super(24, 0.0F, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);

		this.headModel = new ModelRenderer(this, 0, 0);
		this.headModel.addBox(-12.0F, -12.0F, -24.0F, 24.0F, 24.0F, 24.0F);
		this.headModel.setRotationPoint(0.0F, -28.0F, -32.0F);
		
		this.headModel.setTextureOffset(22, 0).addBox(-6.0F, -6.0F, -30.0F, 12.0F, 18.0F, 6.0F);
		
		this.earLeft = new ModelRenderer(this, 0, 0);
		this.earLeft.addBox(-1.0F, -10.0F, 0.0F, 1.0F, 24.0F, 24.0F);
		this.earLeft.setRotationPoint(12.0F, -2.0F, -10.0F);
		this.headModel.addChild(this.earLeft);
		
		this.earRight = new ModelRenderer(this, 0, 0);
		this.earRight.addBox(0.0F, -10.0F, 0.0F, 1.0F, 24.0F, 24.0F);
		this.earRight.setRotationPoint(-12.0F, -2.0F, -10.0F);
		this.headModel.addChild(this.earRight);
		
		this.tuskLeft = new ModelRenderer(this, 0, 0);
		this.tuskLeft.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 16.0F, 4.0F);
		this.tuskLeft.setRotationPoint(9.0F, 12.0F, -19.0F);
		this.headModel.addChild(this.tuskLeft);
		
		this.tuskRight = new ModelRenderer(this, 0, 0);
		this.tuskRight.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 16.0F, 4.0F);
		this.tuskRight.setRotationPoint(-9.0F, 12.0F, -19.0F);
		this.headModel.addChild(this.tuskRight);
		
		this.trunk1 = new ModelRenderer(this, 0, 0);
		this.trunk1.addBox(-4.0F, -8.0F, 0.0F, 8.0F, 20.0F, 8.0F);
		this.trunk1.setRotationPoint(0.0F, 12.0F, -30.0F);
		this.headModel.addChild(this.trunk1);
		
		this.trunk2 = new ModelRenderer(this, 0, 0);
		this.trunk2.addBox(-3.5F, 0.0F, 0.0F, 7.0F, 12.0F, 7.0F);
		this.trunk2.setRotationPoint(0.0F, 12.0F, 0.0F);
		this.trunk1.addChild(this.trunk2);
		
		this.trunk3 = new ModelRenderer(this, 0, 0);
		this.trunk3.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 12.0F, 6.0F);
		this.trunk3.setRotationPoint(0.0F, 12.0F, 0.0F);
		this.trunk2.addChild(this.trunk3);
		
		this.body = new ModelRenderer(this, 18, 4);
		this.body.addBox(-18.0F, -20.0F, -32.0F, 36.0F, 40.0F, 64.0F);
		this.body.setRotationPoint(0.0F, -20.0F, 0.0F);
		
		this.tail = new ModelRenderer(this, 18, 4);
		this.tail.addBox(-1.5F, 0.0F, -2.0F, 3.0F, 32.0F, 3.0F);
		this.tail.setRotationPoint(0.0F, -8.0F, 32.0F);
		this.body.addChild(this.tail);

		this.legBackRight = new ModelRenderer(this, 0, 16);
		this.legBackRight.addBox(-6.0F, 0.0F, -6.0F, 12.0F, 24.0F, 12.0F);
		this.legBackRight.setRotationPoint(-12.0F, 0.0F, 26.0F);

		this.legBackLeft = new ModelRenderer(this, 0, 16);
	    this.legBackLeft.addBox(-6.0F, 0.0F, -6.0F, 12.0F, 24.0F, 12.0F);
	    this.legBackLeft.setRotationPoint(12.0F, 0.0F, 26.0F);
	      
	    this.legFrontRight = new ModelRenderer(this, 0, 16);
	    this.legFrontRight.addBox(-6.0F, 0.0F, -6.0F, 12.0F, 24.0F, 12.0F);
	    this.legFrontRight.setRotationPoint(-12.0F, 0.0F, -26.0F);
		
	    this.legFrontLeft = new ModelRenderer(this, 0, 16);
	    this.legFrontLeft.addBox(-6.0F, 0.0F, -6.0F, 12.0F, 24.0F, 12.0F);
	    this.legFrontLeft.setRotationPoint(12.0F, 0.0F, -26.0F);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.tuskLeft.rotateAngleX = -(float) Math.PI / 10.0F;
		this.tuskRight.rotateAngleX = -(float) Math.PI / 10.0F;
		this.tail.rotateAngleX = (float) Math.PI / 10.0F;
		this.trunk1.rotateAngleX = 0;
		this.trunk2.rotateAngleX = 0;
		this.trunk3.rotateAngleX = 0;
		this.earLeft.rotateAngleY = (float) Math.PI / 5.0F;
		this.earRight.rotateAngleY = -(float) Math.PI / 5.0F;
	}

}
