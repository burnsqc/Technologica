package com.technologica.client.renderer.entity.model;

import com.technologica.entity.passive.BeaverEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class BeaverModel<T extends BeaverEntity> extends QuadrupedModel<T> {

	private ModelRenderer tail;

	public BeaverModel() {
		super(2, 0.0F, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		this.texWidth = 32;
		this.texHeight = 32;
		
		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-3.0F, 10.0F, -6.0F, 6.0F, 6.0F, 8.0F);
		this.body.setPos(0.0F, 6.0F, 2.0F);

		this.tail = new ModelRenderer(this, 0, 22);
		this.tail.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 6.0F);
		this.tail.setPos(0.0F, 14.0F, 2.0F);
		this.body.addChild(this.tail);

		this.leg0 = new ModelRenderer(this, 0, 0);
		this.leg0.addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F);
		this.leg0.addBox(-1.5F, 3.0F, -2.0F, 3.0F, 0.01F, 3.0F);
		this.leg0.setPos(-2.0F, 21.0F, 3.0F);

		this.leg1 = new ModelRenderer(this, 0, 0);
		this.leg1.addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F);
		this.leg1.addBox(-1.5F, 3.0F, -2.0F, 3.0F, 0.01F, 3.0F);
		this.leg1.setPos(2.0F, 21.0F, 3.0F);

		this.leg2 = new ModelRenderer(this, 0, 0);
		this.leg2.addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F);
		this.leg2.setPos(-2.0F, 21.0F, -3.0F);

		this.leg3 = new ModelRenderer(this, 0, 0);
		this.leg3.addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F);
		this.leg3.setPos(2.0F, 21.0F, -3.0F);

		this.head = new ModelRenderer(this, 0, 14);
		this.head.addBox(-2.0F, -4.0F, -4.0F, 4.0F, 4.0F, 4.0F);
		this.head.setPos(0.0F, 21.0F, -4.0F);

	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.xRot = headPitch * ((float) Math.PI / 180F) * 0.5F;
		this.head.yRot = netHeadYaw * ((float) Math.PI / 180F) * 0.5F;

		this.leg0.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg1.xRot = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg2.xRot = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg3.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.tail.xRot = -((float) Math.PI / 10F);
	}
}