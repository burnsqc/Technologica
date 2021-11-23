package com.technologica.client.renderer.entity.model;

import com.technologica.entity.passive.BeaverEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class BeaverModel<T extends BeaverEntity> extends QuadrupedModel<T> {

	
	private ModelRenderer tail;

	public BeaverModel() {
		super(2, 0.0F, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		this.textureWidth = 32;
		this.textureHeight = 32;
		
		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-3.0F, 10.0F, -6.0F, 6.0F, 6.0F, 8.0F);
		this.body.setRotationPoint(0.0F, 6.0F, 2.0F);

		this.tail = new ModelRenderer(this, 0, 22);
		this.tail.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 6.0F);
		this.tail.setRotationPoint(0.0F, 14.0F, 2.0F);
		this.body.addChild(this.tail);

		this.legBackRight = new ModelRenderer(this, 0, 0);
		this.legBackRight.addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F);
		this.legBackRight.addBox(-1.5F, 3.0F, -2.0F, 3.0F, 0.01F, 3.0F);
		this.legBackRight.setRotationPoint(-2.0F, 21.0F, 3.0F);

		this.legBackLeft = new ModelRenderer(this, 0, 0);
		this.legBackLeft.addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F);
		this.legBackLeft.addBox(-1.5F, 3.0F, -2.0F, 3.0F, 0.01F, 3.0F);
		this.legBackLeft.setRotationPoint(2.0F, 21.0F, 3.0F);

		this.legFrontRight = new ModelRenderer(this, 0, 0);
		this.legFrontRight.addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F);
		this.legFrontRight.setRotationPoint(-2.0F, 21.0F, -3.0F);

		this.legFrontLeft = new ModelRenderer(this, 0, 0);
		this.legFrontLeft.addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F);
		this.legFrontLeft.setRotationPoint(2.0F, 21.0F, -3.0F);

		this.headModel = new ModelRenderer(this, 0, 14);
		this.headModel.addBox(-2.0F, -4.0F, -4.0F, 4.0F, 4.0F, 4.0F);
		this.headModel.setRotationPoint(0.0F, 21.0F, -4.0F);

	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.headModel.rotateAngleX = headPitch * ((float) Math.PI / 180F) * 0.5F;
		this.headModel.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F) * 0.5F;

		this.legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.tail.rotateAngleX = -((float) Math.PI / 10F);
	}
}