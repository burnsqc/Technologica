package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import com.technologica.entity.item.NavalMineEntity;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class NavalMineModel extends SegmentedModel<NavalMineEntity> {
	private final ModelRenderer body1;
	private final ModelRenderer body2;
	private final ModelRenderer body3;
	private final ModelRenderer faceUD1;
	private final ModelRenderer faceUD2;
	private final ModelRenderer faceNS1;
	private final ModelRenderer faceNS2;
	private final ModelRenderer faceEW1;
	private final ModelRenderer faceEW2;
	
	private final ModelRenderer spike1;
	private final ModelRenderer spike2;
	private final ModelRenderer spike3;
	private final ModelRenderer spike4;
	private final ModelRenderer spike5;
	private final ModelRenderer spike6;
	private final ModelRenderer spike7;
	private final ModelRenderer spike8;
	private final ModelRenderer spike9;

	public NavalMineModel() {
		this.body1 = new ModelRenderer(this, 0, 0); 
		this.body1.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.body1.addBox(-12.0F, -8.0F, -12.0F, 24.0F, 16.0F, 24.0F);
		
		this.body2 = new ModelRenderer(this, 0, 0); 
		this.body2.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.body2.addBox(-8.0F, -12.0F, -12.0F, 16.0F, 24.0F, 24.0F);
		
		this.body3 = new ModelRenderer(this, 0, 0); 
		this.body3.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.body3.addBox(-12.0F, -12.0F, -8.0F, 24.0F, 24.0F, 16.0F);
		
		this.faceUD1 = new ModelRenderer(this, 0, 0); 
		this.faceUD1.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.faceUD1.addBox(-8.0F, -16.0F, -4.0F, 16.0F, 32.0F, 8.0F);
		
		this.faceUD2 = new ModelRenderer(this, 0, 0); 
		this.faceUD2.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.faceUD2.addBox(-4.0F, -16.0F, -8.0F, 8.0F, 32.0F, 16.0F);
		
		this.faceNS1 = new ModelRenderer(this, 0, 0); 
		this.faceNS1.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.faceNS1.addBox(-8.0F, -4.0F, -16.0F, 16.0F, 8.0F, 32.0F);
		
		this.faceNS2 = new ModelRenderer(this, 0, 0); 
		this.faceNS2.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.faceNS2.addBox(-4.0F, -8.0F, -16.0F, 8.0F, 16.0F, 32.0F);
		
		this.faceEW1 = new ModelRenderer(this, 0, 0); 
		this.faceEW1.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.faceEW1.addBox(-16.0F, -4.0F, -8.0F, 32.0F, 8.0F, 16.0F);
		
		this.faceEW2 = new ModelRenderer(this, 0, 0); 
		this.faceEW2.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.faceEW2.addBox(-16.0F, -8.0F, -4.0F, 32.0F, 16.0F, 8.0F);
		
		this.spike1 = new ModelRenderer(this, 0, 0); 
		this.spike1.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.spike1.addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F);
		
		this.spike2 = new ModelRenderer(this, 0, 0); 
		this.spike2.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.spike2.addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F);
		
		this.spike3 = new ModelRenderer(this, 0, 0); 
		this.spike3.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.spike3.addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F);
		
		this.spike4 = new ModelRenderer(this, 0, 0); 
		this.spike4.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.spike4.addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F);
		
		this.spike5 = new ModelRenderer(this, 0, 0); 
		this.spike5.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.spike5.addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F);
		
		this.spike6 = new ModelRenderer(this, 0, 0); 
		this.spike6.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.spike6.addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F);
		
		this.spike7 = new ModelRenderer(this, 0, 0); 
		this.spike7.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.spike7.addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F);
		
		this.spike8 = new ModelRenderer(this, 0, 0); 
		this.spike8.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.spike8.addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F);
		
		this.spike9 = new ModelRenderer(this, 0, 0); 
		this.spike9.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.spike9.addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F);
	}

	@Override
	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.body1, this.body2, this.body3, this.faceUD1, this.faceUD2, this.faceNS1, this.faceNS2, this.faceEW1, this.faceEW2, this.spike1, this.spike2, this.spike3, this.spike4, this.spike5, this.spike6, this.spike7, this.spike8, this.spike9);
	}

	@Override
	public void setRotationAngles(NavalMineEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.spike2.rotateAngleX = (float) Math.PI/4;
		this.spike3.rotateAngleX = (float) Math.PI/2;
		this.spike4.rotateAngleX = -(float) Math.PI/4;
		
		this.spike5.rotateAngleY = (float) Math.PI/2;
		this.spike6.rotateAngleY = (float) Math.PI/2;
		this.spike7.rotateAngleY = (float) Math.PI/2;
		this.spike5.rotateAngleX = (float) Math.PI/4;
		this.spike6.rotateAngleX = (float) Math.PI/2;
		this.spike7.rotateAngleX = -(float) Math.PI/4;
		
		this.spike8.rotateAngleY = (float) Math.PI/4;
		this.spike9.rotateAngleY = -(float) Math.PI/4;
		this.spike8.rotateAngleX = (float) Math.PI/2;
		this.spike9.rotateAngleX = (float) Math.PI/2;
		
	}
}