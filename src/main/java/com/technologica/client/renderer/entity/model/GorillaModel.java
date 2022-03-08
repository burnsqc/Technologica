package com.technologica.client.renderer.entity.model;

import com.technologica.entity.passive.GorillaEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class GorillaModel<T extends GorillaEntity> extends QuadrupedModel<T> {
	private final ModelRenderer neck;
	private final ModelRenderer nose;
	
	public GorillaModel() {
		super(2, 0.0F, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		this.textureWidth = 64;
		this.textureHeight = 64;
		
		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-6.0F, -4.0F, -8.0F, 12.0F, 8.0F, 16.0F);
		this.body.setRotationPoint(0.0F, 12.0F, 0.0F);
		
		this.headModel = new ModelRenderer(this, 0, 24);
		this.headModel.addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F);
		this.headModel.setRotationPoint(0.0F, 6.0F, -6.0F);
		
		this.nose = new ModelRenderer(this, 22, 24);
		this.nose.addBox(-2.0F, -1.0F, -7.0F, 4.0F, 5.0F, 1.0F);
		this.headModel.addChild(this.nose);
		
		this.neck = new ModelRenderer(this, 40, 0);
		this.neck.addBox(-3.0F, -5.0F, -3.0F, 6.0F, 8.0F, 6.0F);
		this.headModel.addChild(this.neck);
		
		this.legBackLeft = new ModelRenderer(this, 0, 0);
	    this.legBackLeft.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F);
	    this.legBackLeft.setRotationPoint(5.0F, 12.0F, 6.0F);
		
		this.legBackRight = new ModelRenderer(this, 0, 0);
	    this.legBackRight.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F);
	    this.legBackRight.setRotationPoint(-5.0F, 12.0F, 6.0F);
	   
	    this.legFrontLeft = new ModelRenderer(this, 0, 38);
	    this.legFrontLeft.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 16.0F, 4.0F);
	    this.legFrontLeft.setRotationPoint(5.0F, 8.0F, -5.0F);
	    
	    this.legFrontRight = new ModelRenderer(this, 0, 38);
	    this.legFrontRight.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 16.0F, 4.0F);
	    this.legFrontRight.setRotationPoint(-5.0F, 8.0F, -5.0F);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.rotateAngleX = -((float) Math.PI / 8F);
		this.headModel.rotateAngleX = 0;
		
	}
}
