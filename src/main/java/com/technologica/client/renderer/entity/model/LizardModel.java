package com.technologica.client.renderer.entity.model;

import com.technologica.entity.passive.LizardEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class LizardModel<T extends LizardEntity> extends QuadrupedModel<T> {
	private final ModelRenderer frillLeft;
	private final ModelRenderer frillRight;
	private final ModelRenderer tail1;
	private final ModelRenderer tail2;
	
	public LizardModel() {
		super(2, 0.0F, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		this.texWidth = 32;
		this.texHeight = 16;
		
		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-2.0F, -1.0F, -3.0F, 4.0F, 3.0F, 6.0F);
		this.body.setPos(0.0F, 21.0F, 0.0F);
		
		this.head = new ModelRenderer(this, 14, 0);
		this.head.addBox(-1.5F, -1.0F, -1.5F, 3.0F, 2.0F, 3.0F);
		this.head.setPos(0.0F, 20.0F, -3.0F);
		
		this.frillLeft = new ModelRenderer(this, 0, 9);
		this.frillLeft.setPos(0.0F, -1.0F, -3.5F);
		this.frillLeft.addBox(0.0F, -4.0F, 0.0F, 4.0F, 4.0F, 1.0F,true);
		this.body.addChild(this.frillLeft);
		
		this.frillRight = new ModelRenderer(this, 0, 9);
		this.frillRight.setPos(0.0F, -1.0F, -3.5F);
		this.frillRight.addBox(-4.0F, -4.0F, 0.0F, 4.0F, 4.0F, 1.0F);
		this.body.addChild(this.frillRight);
		
		this.leg1 = new ModelRenderer(this, 20, 5);
	    this.leg1.addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F);
	    this.leg1.setPos(1.0F, 21.0F, 0.0F);
		
		this.leg0 = new ModelRenderer(this, 20, 5);
	    this.leg0.addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F, true);
	    this.leg0.setPos(-3.0F, 21.0F, 0.0F);
	   
	    this.leg3 = new ModelRenderer(this, 20, 5);
	    this.leg3.addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F);
	    this.leg3.setPos(1.0F, 21.0F, -4.0F);
	    
	    this.leg2 = new ModelRenderer(this, 20, 5);
	    this.leg2.addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F, true);
	    this.leg2.setPos(-3.0F, 21.0F, -4.0F);
	    
	    this.tail1 = new ModelRenderer(this, 10, 10);
		this.tail1.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F);
		this.tail1.setPos(0.0F, 1.0F, 3.0F);
		this.body.addChild(this.tail1);
		
		this.tail2 = new ModelRenderer(this, 22, 10);
		this.tail2.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 4.0F);
		this.tail2.setPos(0.0F, 0.0F, 4.0F);
		this.tail1.addChild(this.tail2);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = (float) Math.PI / 4;
		
		this.frillLeft.zRot = (float) Math.PI / 4;
		this.frillRight.zRot = -(float) Math.PI / 4;
	}
}
