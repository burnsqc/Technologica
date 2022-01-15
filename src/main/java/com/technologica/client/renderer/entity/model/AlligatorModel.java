package com.technologica.client.renderer.entity.model;

import com.technologica.entity.passive.AlligatorEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class AlligatorModel<T extends AlligatorEntity> extends QuadrupedModel<T> {

	private final ModelRenderer tail;
	private final ModelRenderer tail2;
	private final ModelRenderer tail3;
	private final ModelRenderer nose;
	private final ModelRenderer jaw;
	private final ModelRenderer teethUpper;
	private final ModelRenderer teethLower;
	private final ModelRenderer eyeLeft;
	private final ModelRenderer eyeRight;
	
	public AlligatorModel() {
		super(6, 0.0F, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		this.textureWidth = 64;
		this.textureHeight = 64;

		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-5.0F, -3.0F, -8.0F, 10.0F, 6.0F, 16.0F);
		this.body.setRotationPoint(0.0F, 19.0F, 0.0F);

		this.tail = new ModelRenderer(this, 36, 0);
		this.tail.addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 8.0F);
		this.tail.setRotationPoint(0.0F, 0.0F, 8.0F);
		this.body.addChild(this.tail);
		
		this.tail2 = new ModelRenderer(this, 0, 22);
		this.tail2.addBox(-2.0F, -2.0F, 0.0F, 4.0F, 5.0F, 8.0F);
		this.tail2.setRotationPoint(0.0F, 0.0F, 8.0F);
		this.tail.addChild(this.tail2);
		
		this.tail3 = new ModelRenderer(this, 44, 14);
		this.tail3.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 4.0F, 8.0F);
		this.tail3.setRotationPoint(0.0F, 0.0F, 8.0F);
		this.tail2.addChild(this.tail3);
		
		this.headModel = new ModelRenderer(this, 24, 22);
		this.headModel.addBox(-4.0F, -3.0F, -4.0F, 8.0F, 6.0F, 4.0F);
		this.headModel.setRotationPoint(0.0F, 19.0F, -8.0F);
		
		this.nose = new ModelRenderer(this, 0, 35);
		this.nose.setRotationPoint(0.0F, -1.0F, -4.0F);
		this.nose.addBox(-3.0F, -2.0F, -8.0F, 6.0F, 2.0F, 8.0F);
		this.headModel.addChild(this.nose);
		
		this.jaw = new ModelRenderer(this, 20, 32);
		this.jaw.setRotationPoint(0.0F, -1.0F, -4.0F);
		this.jaw.addBox(-3.0F, 0.0F, -8.0F, 6.0F, 2.0F, 8.0F);
		this.headModel.addChild(this.jaw);
		
		this.teethUpper = new ModelRenderer(this, 0, 45);
		this.teethUpper.addBox(-2.5F, 0.0F, -7.5F, 5.0F, 1.0F, 8.0F);
		this.nose.addChild(this.teethUpper);
		
		this.teethLower = new ModelRenderer(this, 26, 45);
		this.teethLower.addBox(-2.5F, -1.0F, -7.5F, 5.0F, 1.0F, 8.0F);
		this.jaw.addChild(this.teethLower);
		
		this.eyeLeft = new ModelRenderer(this, 0, 10);
		this.eyeLeft.addBox(1.0F, -3.0F, -3.0F, 1.0F, 1.0F, 2.0F);
		this.nose.addChild(this.eyeLeft);
		
		this.eyeRight = new ModelRenderer(this, 6, 10);
		this.eyeRight.addBox(-2.0F, -3.0F, -3.0F, 1.0F, 1.0F, 2.0F);
		this.nose.addChild(this.eyeRight);
		
		this.legBackRight = new ModelRenderer(this, 0, 0);
		this.legBackRight.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F);
		this.legBackRight.setRotationPoint(-5.0F, 18.0F, 7.0F);
		
		this.legBackLeft = new ModelRenderer(this, 0, 0);
		this.legBackLeft.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F);
		this.legBackLeft.setRotationPoint(5.0F, 18.0F, 7.0F);
		
		this.legFrontRight = new ModelRenderer(this, 0, 0);
		this.legFrontRight.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F);
		this.legFrontRight.setRotationPoint(-5.0F, 18.0F, -5.0F);
		
		this.legFrontLeft = new ModelRenderer(this, 0, 0);
		this.legFrontLeft.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F);
		this.legFrontLeft.setRotationPoint(5.0F, 18.0F, -5.0F);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.rotateAngleX = 0;
		this.nose.rotateAngleX = -(MathHelper.sin(ageInTicks / 10) * MathHelper.sin(ageInTicks / 10))/2;
		this.legBackLeft.rotateAngleX = 0;
	}
}
