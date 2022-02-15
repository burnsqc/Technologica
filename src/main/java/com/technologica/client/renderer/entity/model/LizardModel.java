package com.technologica.client.renderer.entity.model;

import com.technologica.entity.passive.LizardEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class LizardModel<T extends LizardEntity> extends QuadrupedModel<T> {
	private final ModelRenderer frill;
	private final ModelRenderer tail1;
	private final ModelRenderer tail2;
	
	public LizardModel() {
		super(2, 0.0F, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		this.textureWidth = 32;
		this.textureHeight = 16;
		
		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-2.0F, -1.0F, -3.0F, 4.0F, 3.0F, 6.0F);
		this.body.setRotationPoint(0.0F, 21.0F, 0.0F);
		
		this.headModel = new ModelRenderer(this, 14, 0);
		this.headModel.addBox(-1.5F, -1.0F, -1.5F, 3.0F, 2.0F, 3.0F);
		this.headModel.setRotationPoint(0.0F, 20.0F, -3.0F);
		
		this.frill = new ModelRenderer(this, 0, 9);
		this.frill.addBox(-3.0F, -4.0F, -3.0F, 6.0F, 4.0F, 1.0F);
		this.body.addChild(this.frill);
		
		this.legBackLeft = new ModelRenderer(this, 20, 5);
	    this.legBackLeft.addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F);
	    this.legBackLeft.setRotationPoint(1.0F, 21.0F, 0.0F);
		
		this.legBackRight = new ModelRenderer(this, 20, 5);
	    this.legBackRight.addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F, true);
	    this.legBackRight.setRotationPoint(-3.0F, 21.0F, 0.0F);
	   
	    this.legFrontLeft = new ModelRenderer(this, 20, 5);
	    this.legFrontLeft.addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F);
	    this.legFrontLeft.setRotationPoint(1.0F, 21.0F, -4.0F);
	    
	    this.legFrontRight = new ModelRenderer(this, 20, 5);
	    this.legFrontRight.addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F, true);
	    this.legFrontRight.setRotationPoint(-3.0F, 21.0F, -4.0F);
	    
	    this.tail1 = new ModelRenderer(this, 10, 10);
		this.tail1.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F);
		this.tail1.setRotationPoint(0.0F, 1.0F, 3.0F);
		this.body.addChild(this.tail1);
		
		this.tail2 = new ModelRenderer(this, 22, 10);
		this.tail2.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 4.0F);
		this.tail2.setRotationPoint(0.0F, 0.0F, 4.0F);
		this.tail1.addChild(this.tail2);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.headModel.rotateAngleY = (float) (Math.PI / 4);
		this.frill.showModel = false;
	}
}
