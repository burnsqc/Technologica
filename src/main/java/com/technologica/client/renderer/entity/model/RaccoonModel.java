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
		super(3, 0.0F, true, 20.0F, 0.5F, 2.7272F, 2.0F, 24);
		this.texWidth = 64;
		this.texHeight = 32;
		
		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-4.0F, -6.0F, -7.0F, 8.0F, 6.0F, 10.0F);
		this.body.setPos(0.0F, 21.0F, 2.0F);

		this.tail = new ModelRenderer(this, 2, 16);
		this.tail.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F);
		this.tail.setPos(0.0F, -3.0F, 3.0F);
		this.body.addChild(this.tail);

		this.leg0 = new ModelRenderer(this, 0, 0);
		this.leg0.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F);
		this.leg0.setPos(-2.0F, 21.0F, 3.0F);

		this.leg1 = new ModelRenderer(this, 0, 0);
		this.leg1.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F);
		this.leg1.setPos(2.0F, 21.0F, 3.0F);

		this.leg2 = new ModelRenderer(this, 0, 0);
		this.leg2.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F);
		this.leg2.setPos(-2.0F, 21.0F, -3.0F);

		this.leg3 = new ModelRenderer(this, 0, 0);
		this.leg3.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F);
		this.leg3.setPos(2.0F, 21.0F, -3.0F);

		this.head = new ModelRenderer(this, 14, 16);
		this.head.addBox(-2.5F, -5.0F, -3.0F, 5.0F, 4.0F, 3.0F);
		this.head.setPos(0.0F, 21.0F, -5.0F);
		
		this.earRight = new ModelRenderer(this, 0, 16);
		this.earRight.addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		this.earRight.setPos(2.0F, -5.0F, -2.0F);
		this.head.addChild(this.earRight);
		
		this.earLeft = new ModelRenderer(this, 0, 16);
		this.earLeft.addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		this.earLeft.setPos(-2.0F, -5.0F, -2.0F);
		this.head.addChild(this.earLeft);
		
		this.snout = new ModelRenderer(this, 0, 6);
		this.snout.addBox(-1.0F, -9.0F, -7.0F, 2.0F, 2.0F, 2.0F);
		this.snout.setPos(0.0F, 6.0F, 2.0F);
		this.head.addChild(this.snout);

	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.xRot = headPitch * ((float) Math.PI / 180F) * 0.5F;
		this.head.yRot = netHeadYaw * ((float) Math.PI / 180F) * 0.5F;
		this.earLeft.zRot = -(float) Math.PI / 4F;
		this.earRight.zRot = 3 * -(float) Math.PI / 4F;
	}
	
	@Override
	public void prepareMobModel(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		if (entityIn.isBegging()) {
			this.body.xRot = -(float) Math.PI / 3;
			this.head.setPos(0.0F, 15.0F, 1.0F);
			this.leg3.setPos(2.0F, 17.0F, 0.0F);
			this.leg2.setPos(-2.0F, 17.0F, 0.0F);
			this.leg3.xRot = MathHelper.sin(0.75F * ((float) entityIn.tickCount + partialTick)) - (float) Math.PI / 3;
			this.leg2.xRot = MathHelper.sin(0.75F * ((float) entityIn.tickCount + partialTick)) - (float) Math.PI / 3;
			this.leg3.zRot = -(float) Math.PI / 10;
			this.leg2.zRot = (float) Math.PI / 10;
			this.tail.xRot = (float) Math.PI / 3;
		} else {
			this.body.xRot = 0;
			this.head.setPos(0.0F, 21.0F, -5.0F);
			this.leg3.setPos(2.0F, 21.0F, -3.0F);
			this.leg2.setPos(-2.0F, 21.0F, -3.0F);
			this.leg2.xRot = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.leg3.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.leg3.zRot = 0;
			this.leg2.zRot = 0;
			this.tail.xRot = -((float) Math.PI / 10F);
		}
		
		this.leg0.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg1.xRot = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		
	}
	
}