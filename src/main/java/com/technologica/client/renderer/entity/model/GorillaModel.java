package com.technologica.client.renderer.entity.model;

import com.technologica.entity.passive.GorillaEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class GorillaModel<T extends GorillaEntity> extends QuadrupedModel<T> {
	private final ModelRenderer neck;
	private final ModelRenderer nose;
	
	public GorillaModel() {
		super(2, 0.0F, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		this.texWidth = 64;
		this.texHeight = 64;
		
		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-6.0F, -4.0F, -8.0F, 12.0F, 8.0F, 16.0F);
		this.body.setPos(0.0F, 12.0F, 0.0F);
		
		this.head = new ModelRenderer(this, 0, 24);
		this.head.addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F);
		this.head.setPos(0.0F, 6.0F, -6.0F);
		
		this.nose = new ModelRenderer(this, 22, 24);
		this.nose.addBox(-2.0F, -1.0F, -7.0F, 4.0F, 5.0F, 1.0F);
		this.head.addChild(this.nose);
		
		this.neck = new ModelRenderer(this, 40, 0);
		this.neck.addBox(-3.0F, -5.0F, -3.0F, 6.0F, 8.0F, 6.0F);
		this.head.addChild(this.neck);
		
		this.leg1 = new ModelRenderer(this, 0, 0);
	    this.leg1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F);
	    this.leg1.setPos(5.0F, 12.0F, 6.0F);
		
		this.leg0 = new ModelRenderer(this, 0, 0);
	    this.leg0.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F);
	    this.leg0.setPos(-5.0F, 12.0F, 6.0F);
	   
	    this.leg3 = new ModelRenderer(this, 0, 38);
	    this.leg3.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 16.0F, 4.0F);
	    this.leg3.setPos(5.0F, 8.0F, -5.0F);
	    
	    this.leg2 = new ModelRenderer(this, 0, 38);
	    this.leg2.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 16.0F, 4.0F);
	    this.leg2.setPos(-5.0F, 8.0F, -5.0F);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.xRot = -((float) Math.PI / 8F);
		this.head.xRot = 0;
		
	}
}
