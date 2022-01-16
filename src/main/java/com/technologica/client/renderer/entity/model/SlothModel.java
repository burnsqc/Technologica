package com.technologica.client.renderer.entity.model;

import com.technologica.entity.passive.SlothEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class SlothModel<T extends SlothEntity> extends QuadrupedModel<T> {
	private final ModelRenderer legBackRightLower;
	private final ModelRenderer legBackLeftLower;
	private final ModelRenderer legFrontRightLower;
	private final ModelRenderer legFrontLeftLower;
	private final ModelRenderer clawInnerBackRight;
	private final ModelRenderer clawInnerBackLeft;
	private final ModelRenderer clawInnerFrontRight;
	private final ModelRenderer clawInnerFrontLeft;
	private final ModelRenderer clawOuterBackRight;
	private final ModelRenderer clawOuterBackLeft;
	private final ModelRenderer clawOuterFrontRight;
	private final ModelRenderer clawOuterFrontLeft;
		
	public SlothModel() {
		super(2, 0.0F, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		this.textureWidth = 32;
		this.textureHeight = 32;
		
		this.headModel = new ModelRenderer(this, 0, 16);
		this.headModel.addBox(-2.0F, -4.0F, -4.0F, 4.0F, 4.0F, 4.0F);
		this.headModel.setRotationPoint(0.0F, 18.0F, -5.0F);
		
		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-3.0F, -3.0F, -5.0F, 6.0F, 6.0F, 10.0F);
		this.body.setRotationPoint(0.0F, 17.0F, 0.0F);

		this.legBackRight = new ModelRenderer(this, 0, 0);
		this.legBackRight.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F);
		this.legBackRight.setRotationPoint(-2.0F, 20.0F, 3.0F);

		this.legBackLeft = new ModelRenderer(this, 0, 0);
		this.legBackLeft.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F);
		this.legBackLeft.setRotationPoint(2.0F, 20.0F, 3.0F);

		this.legFrontRight = new ModelRenderer(this, 0, 0);
		this.legFrontRight.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F);
		this.legFrontRight.setRotationPoint(-2.0F, 20.0F, -3.0F);

		this.legFrontLeft = new ModelRenderer(this, 0, 0);
		this.legFrontLeft.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F);
		this.legFrontLeft.setRotationPoint(2.0F, 20.0F, -3.0F);
		
		this.legBackRightLower = new ModelRenderer(this, 22, 0);
		this.legBackRightLower.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F);
		this.legBackRightLower.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.legBackRight.addChild(this.legBackRightLower);

		this.legBackLeftLower = new ModelRenderer(this, 22, 0);
		this.legBackLeftLower.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F);
		this.legBackLeftLower.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.legBackLeft.addChild(this.legBackLeftLower);

		this.legFrontRightLower = new ModelRenderer(this, 22, 0);
		this.legFrontRightLower.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 4.0F, 2.0F);
		this.legFrontRightLower.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.legFrontRight.addChild(this.legFrontRightLower);

		this.legFrontLeftLower = new ModelRenderer(this, 22, 0);
		this.legFrontLeftLower.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 4.0F, 2.0F);
		this.legFrontLeftLower.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.legFrontLeft.addChild(this.legFrontLeftLower);
		
		this.clawInnerBackRight = new ModelRenderer(this, 0, 16);
		this.clawInnerBackRight.addBox(0.0F, 4.0F, 0.0F, 1.0F, 3.0F, 1.0F);
		this.legBackRightLower.addChild(this.clawInnerBackRight);
		
		this.clawInnerBackLeft = new ModelRenderer(this, 0, 16);
		this.clawInnerBackLeft.addBox(-1.0F, 4.0F, 0.0F, 1.0F, 3.0F, 1.0F);
		this.legBackLeftLower.addChild(this.clawInnerBackLeft);
		
		this.clawInnerFrontRight = new ModelRenderer(this, 0, 16);
		this.clawInnerFrontRight.addBox(0.0F, 4.0F, -1.0F, 1.0F, 3.0F, 1.0F);
		this.legFrontRightLower.addChild(this.clawInnerFrontRight);
		
		this.clawInnerFrontLeft = new ModelRenderer(this, 0, 16);
		this.clawInnerFrontLeft.addBox(-1.0F, 4.0F, -1.0F, 1.0F, 3.0F, 1.0F);
		this.legFrontLeftLower.addChild(this.clawInnerFrontLeft);
		
		this.clawOuterBackRight = new ModelRenderer(this, 0, 16);
		this.clawOuterBackRight.addBox(-1.0F, 4.0F, 0.0F, 1.0F, 3.0F, 1.0F);
		this.legBackRightLower.addChild(this.clawOuterBackRight);
		
		this.clawOuterBackLeft = new ModelRenderer(this, 0, 16);
		this.clawOuterBackLeft.addBox(0.0F, 4.0F, 0.0F, 1.0F, 3.0F, 1.0F);
		this.legBackLeftLower.addChild(this.clawOuterBackLeft);
		
		this.clawOuterFrontRight = new ModelRenderer(this, 0, 16);
		this.clawOuterFrontRight.addBox(-1.0F, 4.0F, -1.0F, 1.0F, 3.0F, 1.0F);
		this.legFrontRightLower.addChild(this.clawOuterFrontRight);
		
		this.clawOuterFrontLeft = new ModelRenderer(this, 0, 16);
		this.clawOuterFrontLeft.addBox(0.0F, 4.0F, -1.0F, 1.0F, 3.0F, 1.0F);
		this.legFrontLeftLower.addChild(this.clawOuterFrontLeft);

	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.headModel.rotateAngleX = headPitch * ((float) Math.PI / 180F) * 0.5F;
		this.headModel.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F) * 0.5F;

		this.legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		
		this.legBackRight.rotateAngleX = (float) Math.PI/4;
		this.legBackLeft.rotateAngleX = (float) Math.PI/4;
		this.legFrontRight.rotateAngleX = -(float) Math.PI/4;
		this.legFrontLeft.rotateAngleX = -(float) Math.PI/4;
		
		this.legBackRightLower.rotateAngleX = (float) Math.PI/4;
		this.legBackLeftLower.rotateAngleX = (float) Math.PI/4;
		this.legFrontRightLower.rotateAngleX = -(float) Math.PI/4;
		this.legFrontLeftLower.rotateAngleX = -(float) Math.PI/4;
		
		this.clawInnerFrontLeft.rotateAngleX = 0;
	}
}