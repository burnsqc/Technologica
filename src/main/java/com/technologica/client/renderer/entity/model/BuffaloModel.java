package com.technologica.client.renderer.entity.model;

import com.technologica.entity.passive.BuffaloEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class BuffaloModel<T extends BuffaloEntity> extends QuadrupedModel<T> {

	protected ModelRenderer bodyMane;
	
	public BuffaloModel() {
		super(12, 0.0F, false, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		this.texWidth = 128;
		this.texHeight = 64;
		
		this.head = new ModelRenderer(this, 12, 0);
		this.head.addBox(-5.0F, -3.0F, -6.0F, 10.0F, 12.0F, 8.0F);
		this.head.setPos(0.0F, 0.0F, -16.0F);
		this.head.texOffs(0, 0).addBox(-6.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F);
		this.head.texOffs(0, 0).addBox(5.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F);
		this.head.texOffs(0, 2).addBox(-7.0F, -4.0F, -3.0F, 1.0F, 3.0F, 1.0F);
		this.head.texOffs(0, 2).addBox(6.0F, -4.0F, -3.0F, 1.0F, 3.0F, 1.0F);
		
		this.body = new ModelRenderer(this, 0, 20);
		this.body.addBox(-6.0F, -10.0F, -14.0F, 12.0F, 16.0F, 28.0F);
		this.body.setPos(0.0F, 6.0F, -0.0F);
		
		this.bodyMane = new ModelRenderer(this, 52, 0);
		this.bodyMane.addBox(-7.0F, -12.0F, -12.0F, 14.0F, 20.0F, 12.0F);
		this.body.addChild(this.bodyMane);
		
		this.leg0 = new ModelRenderer(this, 0, 16);
	      this.leg0.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F);
	      this.leg0.setPos(-3.0F, 12.0F, 7.0F);
	      this.leg1 = new ModelRenderer(this, 0, 16);
	      this.leg1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F);
	      this.leg1.setPos(3.0F, 12.0F, 7.0F);
	      this.leg2 = new ModelRenderer(this, 0, 16);
	      this.leg2.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F);
	      this.leg2.setPos(-3.0F, 12.0F, -5.0F);
	      this.leg3 = new ModelRenderer(this, 0, 16);
	      this.leg3.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F);
	      this.leg3.setPos(3.0F, 12.0F, -5.0F);
		
		--this.leg0.x;
		++this.leg1.x;
		this.leg0.z = 12.0F;
		this.leg1.z = 12.0F;
		--this.leg2.x;
		++this.leg3.x;
		this.leg2.z = -8.0F;
		this.leg3.z = -8.0F;
	}
	
	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
