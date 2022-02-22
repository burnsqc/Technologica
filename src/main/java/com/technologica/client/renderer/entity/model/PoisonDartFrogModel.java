package com.technologica.client.renderer.entity.model;

import com.technologica.entity.passive.PoisonDartFrogEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class PoisonDartFrogModel<T extends PoisonDartFrogEntity> extends QuadrupedModel<T> {
	private final ModelRenderer eyeLeft;
	private final ModelRenderer eyeRight;
	
	
	public PoisonDartFrogModel() {
		super(2, 0.0F, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		this.texWidth = 32;
		this.texHeight = 16;
		
		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-2.0F, -1.0F, -2.0F, 4.0F, 3.0F, 4.0F);
		this.body.setPos(0.0F, 21.0F, 0.0F);
		
		this.head = new ModelRenderer(this, 0, 7);
		this.head.addBox(-1.5F, -1.0F, -3.0F, 3.0F, 2.0F, 3.0F);
		this.head.setPos(0.0F, 20.0F, -1.0F);
		
		this.eyeLeft = new ModelRenderer(this, 0, 12);
		this.eyeLeft.addBox(-1.5F, -2.0F, -2.0F, 1.0F, 1.0F, 2.0F);
		this.head.addChild(this.eyeLeft);
		
		this.eyeRight = new ModelRenderer(this, 6, 12);
		this.eyeRight.addBox(0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 2.0F);
		this.head.addChild(this.eyeRight);
		
		this.leg1 = new ModelRenderer(this, 16, 0);
	    this.leg1.addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F);
	    this.leg1.setPos(1.0F, 21.0F, 0.0F);
		
		this.leg0 = new ModelRenderer(this, 16, 5);
	    this.leg0.addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F);
	    this.leg0.setPos(-3.0F, 21.0F, 0.0F);
	   
	    this.leg3 = new ModelRenderer(this, 16, 0);
	    this.leg3.addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F);
	    this.leg3.setPos(1.0F, 21.0F, -4.0F);
	    
	    this.leg2 = new ModelRenderer(this, 16, 5);
	    this.leg2.addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F);
	    this.leg2.setPos(-3.0F, 21.0F, -4.0F);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.xRot = -((float) Math.PI / 8F);
	}
}
