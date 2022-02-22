package com.technologica.client.renderer.entity.model;

import com.technologica.entity.passive.ElephantEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ElephantModel<T extends ElephantEntity> extends QuadrupedModel<T> {

	private final ModelRenderer nose;
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
		
		this.texWidth = 256;
		this.texHeight = 128;

		this.head = new ModelRenderer(this, 135, 0);
		this.head.addBox(-12.0F, -12.0F, -24.0F, 24.0F, 24.0F, 24.0F);
		this.head.setPos(0.0F, -28.0F, -32.0F);
		
		this.nose = new ModelRenderer(this, 0, 104);
		this.nose.addBox(-6.0F, -6.0F, -30.0F, 12.0F, 18.0F, 6.0F);
		this.head.addChild(this.nose);
		
		this.earLeft = new ModelRenderer(this, 0, 0);
		this.earLeft.addBox(-1.0F, -10.0F, 0.0F, 1.0F, 24.0F, 24.0F);
		this.earLeft.setPos(12.0F, -2.0F, -10.0F);
		this.head.addChild(this.earLeft);
		
		this.earRight = new ModelRenderer(this, 0, 0);
		this.earRight.addBox(0.0F, -10.0F, 0.0F, 1.0F, 24.0F, 24.0F);
		this.earRight.setPos(-12.0F, -2.0F, -10.0F);
		this.head.addChild(this.earRight);
		
		this.tuskLeft = new ModelRenderer(this, 0, 0);
		this.tuskLeft.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 16.0F, 4.0F);
		this.tuskLeft.setPos(9.0F, 12.0F, -19.0F);
		this.head.addChild(this.tuskLeft);
		
		this.tuskRight = new ModelRenderer(this, 0, 0);
		this.tuskRight.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 16.0F, 4.0F);
		this.tuskRight.setPos(-9.0F, 12.0F, -19.0F);
		this.head.addChild(this.tuskRight);
		
		this.trunk1 = new ModelRenderer(this, 200, 48);
		this.trunk1.addBox(-4.0F, -8.0F, 0.0F, 8.0F, 20.0F, 8.0F);
		this.trunk1.setPos(0.0F, 12.0F, -30.0F);
		this.head.addChild(this.trunk1);
		
		this.trunk2 = new ModelRenderer(this, 208, 0);
		this.trunk2.addBox(-3.5F, 0.0F, 0.0F, 7.0F, 12.0F, 7.0F);
		this.trunk2.setPos(0.0F, 12.0F, 0.0F);
		this.trunk1.addChild(this.trunk2);
		
		this.trunk3 = new ModelRenderer(this, 136, 0);
		this.trunk3.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 12.0F, 6.0F);
		this.trunk3.setPos(0.0F, 12.0F, 0.0F);
		this.trunk2.addChild(this.trunk3);
		
		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-18.0F, -20.0F, -32.0F, 36.0F, 40.0F, 64.0F);
		this.body.setPos(0.0F, -20.0F, 0.0F);
		
		this.tail = new ModelRenderer(this, 236, 0);
		this.tail.addBox(-1.5F, 0.0F, -3.0F, 3.0F, 32.0F, 3.0F);
		this.tail.setPos(0.0F, -8.0F, 32.0F);
		this.body.addChild(this.tail);

		this.leg0 = new ModelRenderer(this, 188, 92);
		this.leg0.addBox(-6.0F, 0.0F, -6.0F, 12.0F, 24.0F, 12.0F);
		this.leg0.setPos(-12.0F, 0.0F, 26.0F);

		this.leg1 = new ModelRenderer(this, 188, 92);
	    this.leg1.addBox(-6.0F, 0.0F, -6.0F, 12.0F, 24.0F, 12.0F);
	    this.leg1.setPos(12.0F, 0.0F, 26.0F);
	      
	    this.leg2 = new ModelRenderer(this, 188, 92);
	    this.leg2.addBox(-6.0F, 0.0F, -6.0F, 12.0F, 24.0F, 12.0F);
	    this.leg2.setPos(-12.0F, 0.0F, -26.0F);
		
	    this.leg3 = new ModelRenderer(this, 188, 92);
	    this.leg3.addBox(-6.0F, 0.0F, -6.0F, 12.0F, 24.0F, 12.0F);
	    this.leg3.setPos(12.0F, 0.0F, -26.0F);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.tuskLeft.xRot = -(float) Math.PI / 10.0F;
		this.tuskRight.xRot = -(float) Math.PI / 10.0F;
		this.tail.xRot = (float) Math.PI / 10.0F;
		this.trunk1.xRot = 0;
		this.trunk2.xRot = 0;
		this.trunk3.xRot = 0;
		this.earLeft.yRot = (float) Math.PI / 5.0F;
		this.earRight.yRot = -(float) Math.PI / 5.0F;
	}
}
