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
		this.texWidth = 32;
		this.texHeight = 32;
		
		this.head = new ModelRenderer(this, 0, 16);
		this.head.addBox(-2.0F, -4.0F, -4.0F, 4.0F, 4.0F, 4.0F);
		this.head.setPos(0.0F, 18.0F, -5.0F);
		
		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-3.0F, -3.0F, -5.0F, 6.0F, 6.0F, 10.0F);
		this.body.setPos(0.0F, 17.0F, 0.0F);

		this.leg0 = new ModelRenderer(this, 0, 0);
		this.leg0.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F);
		this.leg0.setPos(-2.0F, 20.0F, 3.0F);

		this.leg1 = new ModelRenderer(this, 0, 0);
		this.leg1.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F);
		this.leg1.setPos(2.0F, 20.0F, 3.0F);

		this.leg2 = new ModelRenderer(this, 0, 0);
		this.leg2.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F);
		this.leg2.setPos(-2.0F, 20.0F, -3.0F);

		this.leg3 = new ModelRenderer(this, 0, 0);
		this.leg3.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F);
		this.leg3.setPos(2.0F, 20.0F, -3.0F);
		
		this.legBackRightLower = new ModelRenderer(this, 22, 0);
		this.legBackRightLower.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F);
		this.legBackRightLower.setPos(0.0F, 6.0F, 0.0F);
		this.leg0.addChild(this.legBackRightLower);

		this.legBackLeftLower = new ModelRenderer(this, 22, 0);
		this.legBackLeftLower.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F);
		this.legBackLeftLower.setPos(0.0F, 6.0F, 0.0F);
		this.leg1.addChild(this.legBackLeftLower);

		this.legFrontRightLower = new ModelRenderer(this, 22, 0);
		this.legFrontRightLower.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 4.0F, 2.0F);
		this.legFrontRightLower.setPos(0.0F, 6.0F, 0.0F);
		this.leg2.addChild(this.legFrontRightLower);

		this.legFrontLeftLower = new ModelRenderer(this, 22, 0);
		this.legFrontLeftLower.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 4.0F, 2.0F);
		this.legFrontLeftLower.setPos(0.0F, 6.0F, 0.0F);
		this.leg3.addChild(this.legFrontLeftLower);
		
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
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.xRot = headPitch * ((float) Math.PI / 180F) * 0.5F;
		this.head.yRot = netHeadYaw * ((float) Math.PI / 180F) * 0.5F;

		this.leg0.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg1.xRot = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg2.xRot = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg3.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		
		this.leg0.xRot = (float) Math.PI/4;
		this.leg1.xRot = (float) Math.PI/4;
		this.leg2.xRot = -(float) Math.PI/4;
		this.leg3.xRot = -(float) Math.PI/4;
		
		this.legBackRightLower.xRot = (float) Math.PI/4;
		this.legBackLeftLower.xRot = (float) Math.PI/4;
		this.legFrontRightLower.xRot = -(float) Math.PI/4;
		this.legFrontLeftLower.xRot = -(float) Math.PI/4;
		
		this.clawInnerFrontLeft.xRot = 0;
	}
}