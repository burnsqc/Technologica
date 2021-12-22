package com.technologica.client.renderer.entity.model;

import com.technologica.entity.passive.RaccoonEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class RaccoonModel<T extends RaccoonEntity> extends QuadrupedModel<T> {

	private ModelRenderer tail;
	private ModelRenderer earRight;
	private ModelRenderer earLeft;
	private ModelRenderer snout;

	public RaccoonModel() {
		super(2, 0.0F, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		this.textureWidth = 64;
		this.textureHeight = 32;
		
		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-4.0F, 9.0F, -6.0F, 8.0F, 6.0F, 10.0F);
		this.body.setRotationPoint(0.0F, 6.0F, 2.0F);

		this.tail = new ModelRenderer(this, 2, 16);
		this.tail.addBox(-1.0F, -4.0F, -2.0F, 2.0F, 2.0F, 8.0F);
		this.tail.setRotationPoint(0.0F, 14.0F, 2.0F);
		this.body.addChild(this.tail);

		this.legBackRight = new ModelRenderer(this, 0, 0);
		this.legBackRight.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 4.0F, 2.0F);
		this.legBackRight.setRotationPoint(-2.0F, 21.0F, 3.0F);

		this.legBackLeft = new ModelRenderer(this, 0, 0);
		this.legBackLeft.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 4.0F, 2.0F);
		this.legBackLeft.setRotationPoint(2.0F, 21.0F, 3.0F);

		this.legFrontRight = new ModelRenderer(this, 0, 0);
		this.legFrontRight.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 4.0F, 2.0F);
		this.legFrontRight.setRotationPoint(-2.0F, 21.0F, -3.0F);

		this.legFrontLeft = new ModelRenderer(this, 0, 0);
		this.legFrontLeft.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 4.0F, 2.0F);
		this.legFrontLeft.setRotationPoint(2.0F, 21.0F, -3.0F);

		this.headModel = new ModelRenderer(this, 14, 16);
		this.headModel.addBox(-2.5F, -5.0F, -3.0F, 5.0F, 4.0F, 3.0F);
		this.headModel.setRotationPoint(0.0F, 21.0F, -4.0F);
		
		this.earRight = new ModelRenderer(this, 0, 16);
		this.earRight.addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		this.earRight.setRotationPoint(2.0F, -5.0F, -2.0F);
		this.headModel.addChild(this.earRight);
		
		this.earLeft = new ModelRenderer(this, 0, 16);
		this.earLeft.addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		this.earLeft.setRotationPoint(-2.0F, -5.0F, -2.0F);
		this.headModel.addChild(this.earLeft);
		
		this.snout = new ModelRenderer(this, 0, 6);
		this.snout.addBox(-1.0F, -9.0F, -7.0F, 2.0F, 2.0F, 2.0F);
		this.snout.setRotationPoint(0.0F, 6.0F, 2.0F);
		this.headModel.addChild(this.snout);

	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.earRight.rotateAngleZ = 3 * -(float) Math.PI / 4F;
		this.earLeft.rotateAngleZ = -(float) Math.PI / 4F;
		this.headModel.rotateAngleX = headPitch * ((float) Math.PI / 180F) * 0.5F;
		this.headModel.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F) * 0.5F;

		this.legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.tail.rotateAngleX = -((float) Math.PI / 10F);
	}
}