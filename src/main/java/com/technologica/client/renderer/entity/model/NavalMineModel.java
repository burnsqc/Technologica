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
		this.body1.setPos(0.0F, 16.0F, 0.0F);
		this.body1.addBox(-12.0F, -8.0F, -12.0F, 24.0F, 16.0F, 24.0F);
		
		this.body2 = new ModelRenderer(this, 0, 0); 
		this.body2.setPos(0.0F, 16.0F, 0.0F);
		this.body2.addBox(-8.0F, -12.0F, -12.0F, 16.0F, 24.0F, 24.0F);
		
		this.body3 = new ModelRenderer(this, 0, 0); 
		this.body3.setPos(0.0F, 16.0F, 0.0F);
		this.body3.addBox(-12.0F, -12.0F, -8.0F, 24.0F, 24.0F, 16.0F);
		
		this.faceUD1 = new ModelRenderer(this, 0, 0); 
		this.faceUD1.setPos(0.0F, 16.0F, 0.0F);
		this.faceUD1.addBox(-8.0F, -16.0F, -4.0F, 16.0F, 32.0F, 8.0F);
		
		this.faceUD2 = new ModelRenderer(this, 0, 0); 
		this.faceUD2.setPos(0.0F, 16.0F, 0.0F);
		this.faceUD2.addBox(-4.0F, -16.0F, -8.0F, 8.0F, 32.0F, 16.0F);
		
		this.faceNS1 = new ModelRenderer(this, 0, 0); 
		this.faceNS1.setPos(0.0F, 16.0F, 0.0F);
		this.faceNS1.addBox(-8.0F, -4.0F, -16.0F, 16.0F, 8.0F, 32.0F);
		
		this.faceNS2 = new ModelRenderer(this, 0, 0); 
		this.faceNS2.setPos(0.0F, 16.0F, 0.0F);
		this.faceNS2.addBox(-4.0F, -8.0F, -16.0F, 8.0F, 16.0F, 32.0F);
		
		this.faceEW1 = new ModelRenderer(this, 0, 0); 
		this.faceEW1.setPos(0.0F, 16.0F, 0.0F);
		this.faceEW1.addBox(-16.0F, -4.0F, -8.0F, 32.0F, 8.0F, 16.0F);
		
		this.faceEW2 = new ModelRenderer(this, 0, 0); 
		this.faceEW2.setPos(0.0F, 16.0F, 0.0F);
		this.faceEW2.addBox(-16.0F, -8.0F, -4.0F, 32.0F, 16.0F, 8.0F);
		
		this.spike1 = new ModelRenderer(this, 0, 0); 
		this.spike1.setPos(0.0F, 16.0F, 0.0F);
		this.spike1.addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F);
		
		this.spike2 = new ModelRenderer(this, 0, 0); 
		this.spike2.setPos(0.0F, 16.0F, 0.0F);
		this.spike2.addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F);
		
		this.spike3 = new ModelRenderer(this, 0, 0); 
		this.spike3.setPos(0.0F, 16.0F, 0.0F);
		this.spike3.addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F);
		
		this.spike4 = new ModelRenderer(this, 0, 0); 
		this.spike4.setPos(0.0F, 16.0F, 0.0F);
		this.spike4.addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F);
		
		this.spike5 = new ModelRenderer(this, 0, 0); 
		this.spike5.setPos(0.0F, 16.0F, 0.0F);
		this.spike5.addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F);
		
		this.spike6 = new ModelRenderer(this, 0, 0); 
		this.spike6.setPos(0.0F, 16.0F, 0.0F);
		this.spike6.addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F);
		
		this.spike7 = new ModelRenderer(this, 0, 0); 
		this.spike7.setPos(0.0F, 16.0F, 0.0F);
		this.spike7.addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F);
		
		this.spike8 = new ModelRenderer(this, 0, 0); 
		this.spike8.setPos(0.0F, 16.0F, 0.0F);
		this.spike8.addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F);
		
		this.spike9 = new ModelRenderer(this, 0, 0); 
		this.spike9.setPos(0.0F, 16.0F, 0.0F);
		this.spike9.addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F);
	}

	@Override
	public Iterable<ModelRenderer> parts() {
		return ImmutableList.of(this.body1, this.body2, this.body3, this.faceUD1, this.faceUD2, this.faceNS1, this.faceNS2, this.faceEW1, this.faceEW2, this.spike1, this.spike2, this.spike3, this.spike4, this.spike5, this.spike6, this.spike7, this.spike8, this.spike9);
	}

	@Override
	public void setupAnim(NavalMineEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.spike2.xRot = (float) Math.PI/4;
		this.spike3.xRot = (float) Math.PI/2;
		this.spike4.xRot = -(float) Math.PI/4;
		
		this.spike5.yRot = (float) Math.PI/2;
		this.spike6.yRot = (float) Math.PI/2;
		this.spike7.yRot = (float) Math.PI/2;
		this.spike5.xRot = (float) Math.PI/4;
		this.spike6.xRot = (float) Math.PI/2;
		this.spike7.xRot = -(float) Math.PI/4;
		
		this.spike8.yRot = (float) Math.PI/4;
		this.spike9.yRot = -(float) Math.PI/4;
		this.spike8.xRot = (float) Math.PI/2;
		this.spike9.xRot = (float) Math.PI/2;
		
	}
}