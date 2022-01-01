package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import com.technologica.entity.passive.CamelEntity;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class CamelModel<T extends CamelEntity> extends AgeableModel<T> {
	protected final ModelRenderer body;
	protected final ModelRenderer humpLower;
	protected final ModelRenderer humpUpper;
	protected final ModelRenderer tail;
	protected final ModelRenderer neckLower;
	protected final ModelRenderer neck;
	protected final ModelRenderer head;
	protected final ModelRenderer nose;
	protected final ModelRenderer earLeft;
	protected final ModelRenderer earRight;
	
	private final ModelRenderer field_228262_f_;
	private final ModelRenderer field_228263_g_;
	private final ModelRenderer field_228264_h_;
	private final ModelRenderer field_228265_i_;
	private final ModelRenderer field_228266_j_;
	private final ModelRenderer field_228267_k_;
	private final ModelRenderer field_228268_l_;
	private final ModelRenderer field_228269_m_;
	
	private final ModelRenderer[] field_217134_k;
	private final ModelRenderer[] field_217135_l;

	public CamelModel() {
		super(true, 16.2F, 1.36F, 2.7272F, 2.0F, 20.0F);
		this.textureWidth = 64;
		this.textureHeight = 64;
		
		this.body = new ModelRenderer(this, 0, 32);
		this.body.addBox(-5.0F, -10.0F, -13.0F, 10.0F, 12.0F, 18.0F);
		this.body.setRotationPoint(0.0F, 11.0F, 5.0F);
		
		this.humpLower = new ModelRenderer(this, 0, 32);
		this.humpLower.addBox(-4.0F, -12.0F, -10.0F, 8.0F, 2.0F, 12.0F);
		this.body.addChild(this.humpLower);
		
		this.humpUpper = new ModelRenderer(this, 0, 32);
		this.humpUpper.addBox(-3.0F, -15.0F, -8.0F, 6.0F, 3.0F, 8.0F);
		this.body.addChild(this.humpUpper);
		
		this.tail = new ModelRenderer(this, 42, 36);
		this.tail.addBox(-1.0F, -2.0F, 0.0F, 2.0F, 12.0F, 2.0F);
		this.tail.setRotationPoint(0.0F, -5.0F, 2.0F);
		this.body.addChild(this.tail);
		
		this.neckLower = new ModelRenderer(this, 0, 35);
		this.neckLower.addBox(-2.0F, 5.0F, -6.0F, 4.0F, 5.0F, 10.0F);
		
		this.neck = new ModelRenderer(this, 0, 35);
		this.neck.addBox(-2.0F, -12.0F, 0.0F, 4.0F, 12.0F, 5.0F);
		this.neck.setRotationPoint(0.0F, 10.0F, -6.0F);
		this.neckLower.addChild(this.neck);
		
		this.head = new ModelRenderer(this, 0, 13);
		this.head.addBox(-3.0F, -17.0F, -2.0F, 6.0F, 5.0F, 7.0F);
		this.neck.addChild(head);
		
		this.nose = new ModelRenderer(this, 0, 25);
		this.nose.addBox(-2.0F, -16.0F, -7.0F, 4.0F, 4.0F, 5.0F);
		this.neck.addChild(nose);
		
		this.earLeft = new ModelRenderer(this, 19, 16);
		this.earLeft.addBox(2.0F, -17.0F, 3.0F, 2.0F, 2.0F, 1.0F);
		this.neck.addChild(earLeft);
		
		this.earRight = new ModelRenderer(this, 19, 16);
		this.earRight.addBox(-4.0F, -17.0F, 3.0F, 2.0F, 2.0F, 1.0F);
		this.neck.addChild(earRight);
		
		this.field_228262_f_ = new ModelRenderer(this, 48, 21);
		this.field_228262_f_.mirror = true;
		this.field_228262_f_.addBox(-3.0F, -1.0F, -1.5F, 3.0F, 11.0F, 3.0F);
		this.field_228262_f_.setRotationPoint(5.0F, 14.0F, 8.5F);
		
		this.field_228263_g_ = new ModelRenderer(this, 48, 21);
		this.field_228263_g_.addBox(-1.0F, -1.0F, -1.5F, 3.0F, 11.0F, 3.0F);
		this.field_228263_g_.setRotationPoint(-4.0F, 14.0F, 8.5F);
		
		this.field_228264_h_ = new ModelRenderer(this, 48, 21);
		this.field_228264_h_.mirror = true;
		this.field_228264_h_.addBox(-3.0F, -1.0F, -1.5F, 3.0F, 11.0F, 3.0F);
		this.field_228264_h_.setRotationPoint(5.0F, 14.0F, -6.5F);
		
		this.field_228265_i_ = new ModelRenderer(this, 48, 21);
		this.field_228265_i_.addBox(-1.0F, -1.0F, -1.5F, 3.0F, 11.0F, 3.0F);
		this.field_228265_i_.setRotationPoint(-4.0F, 14.0F, -6.5F);
		
		this.field_228266_j_ = new ModelRenderer(this, 48, 21);
		this.field_228266_j_.mirror = true;
		this.field_228266_j_.addBox(-3.0F, -1.0F, -1.5F, 3.0F, 11.0F, 3.0F + 5.5F);
		this.field_228266_j_.setRotationPoint(4.0F, 14.0F, 8.5F);
		this.field_228267_k_ = new ModelRenderer(this, 48, 21);
		this.field_228267_k_.addBox(-1.0F, -1.0F, -1.5F, 3.0F, 11.0F, 3.0F + 5.5F);
		this.field_228267_k_.setRotationPoint(-4.0F, 14.0F, 8.5F);
		this.field_228268_l_ = new ModelRenderer(this, 48, 21);
		this.field_228268_l_.mirror = true;
		this.field_228268_l_.addBox(-3.0F, -1.0F, -1.5F, 3.0F, 11.0F, 3.0F + 5.5F);
		this.field_228268_l_.setRotationPoint(4.0F, 6.0F, -11.5F);
		this.field_228269_m_ = new ModelRenderer(this, 48, 21);
		this.field_228269_m_.addBox(-1.0F, -1.0F, -1.5F, 3.0F, 11.0F, 3.0F + 5.5F);
		this.field_228269_m_.setRotationPoint(-4.0F, 6.0F, -11.5F);
		
		ModelRenderer modelrenderer3 = new ModelRenderer(this, 26, 0);
		modelrenderer3.addBox(-5.0F, -8.0F, -9.0F, 10.0F, 9.0F, 9.0F, 0.5F);
		this.body.addChild(modelrenderer3);
		ModelRenderer modelrenderer4 = new ModelRenderer(this, 29, 5);
		modelrenderer4.addBox(2.0F, -9.0F, -6.0F, 1.0F, 2.0F, 2.0F);
		this.neck.addChild(modelrenderer4);
		ModelRenderer modelrenderer5 = new ModelRenderer(this, 29, 5);
		modelrenderer5.addBox(-3.0F, -9.0F, -6.0F, 1.0F, 2.0F, 2.0F);
		this.neck.addChild(modelrenderer5);
		ModelRenderer modelrenderer6 = new ModelRenderer(this, 32, 2);
		modelrenderer6.addBox(3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F);
		modelrenderer6.rotateAngleX = (-(float) Math.PI / 6F);
		this.neck.addChild(modelrenderer6);
		ModelRenderer modelrenderer7 = new ModelRenderer(this, 32, 2);
		modelrenderer7.addBox(-3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F);
		modelrenderer7.rotateAngleX = (-(float) Math.PI / 6F);
		this.neck.addChild(modelrenderer7);
		ModelRenderer modelrenderer8 = new ModelRenderer(this, 1, 1);
		modelrenderer8.addBox(-3.0F, -11.0F, -1.9F, 6.0F, 5.0F, 6.0F, 0.2F);
		this.neck.addChild(modelrenderer8);
		ModelRenderer modelrenderer9 = new ModelRenderer(this, 19, 0);
		modelrenderer9.addBox(-2.0F, -11.0F, -4.0F, 4.0F, 5.0F, 2.0F, 0.2F);
		
		this.neck.addChild(modelrenderer9);
		
		this.field_217134_k = new ModelRenderer[] { modelrenderer3, modelrenderer4, modelrenderer5, modelrenderer8, modelrenderer9 };
		this.field_217135_l = new ModelRenderer[] { modelrenderer6, modelrenderer7 };
	}

	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.tail.rotateAngleX = ((float) Math.PI / 6F);
		
		boolean flag = entityIn.isHorseSaddled();
		boolean flag1 = entityIn.isBeingRidden();

		for (ModelRenderer modelrenderer : this.field_217134_k) {
			modelrenderer.showModel = flag;
		}

		for (ModelRenderer modelrenderer1 : this.field_217135_l) {
			modelrenderer1.showModel = flag1 && flag;
		}

		this.body.rotationPointY = 11.0F;
	}

	public Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of(this.neckLower);
	}

	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.body, this.field_228262_f_, this.field_228263_g_, this.field_228264_h_, this.field_228265_i_, this.field_228266_j_, this.field_228267_k_, this.field_228268_l_, this.field_228269_m_);
	}

	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
		float f = MathHelper.lerp(partialTick, entityIn.prevRenderYawOffset, entityIn.renderYawOffset);
		float f1 = MathHelper.lerp(partialTick, entityIn.prevRotationYawHead, entityIn.rotationYawHead);
		float f2 = MathHelper.lerp(partialTick, entityIn.prevRotationPitch, entityIn.rotationPitch);
		float f3 = f1 - f;
		float f4 = f2 * ((float) Math.PI / 180F);
		if (f3 > 20.0F) {
			f3 = 20.0F;
		}

		if (f3 < -20.0F) {
			f3 = -20.0F;
		}

		if (limbSwingAmount > 0.2F) {
			f4 += MathHelper.cos(limbSwing * 0.4F) * 0.15F * limbSwingAmount;
		}

		float f5 = entityIn.getGrassEatingAmount(partialTick);
		float f6 = entityIn.getRearingAmount(partialTick);
		float f7 = 1.0F - f6;
		boolean flag = entityIn.tailCounter != 0;
		float f9 = (float) entityIn.ticksExisted + partialTick;
		this.neckLower.rotationPointZ = -12.0F;
		this.body.rotateAngleX = 0.0F;
		this.neckLower.rotateAngleY = f3 * ((float) Math.PI / 180F);
		float f10 = entityIn.isInWater() ? 0.2F : 1.0F;
		float f11 = MathHelper.cos(f10 * limbSwing * 0.6662F + (float) Math.PI);
		float f12 = f11 * 0.8F * limbSwingAmount;
		this.neck.rotateAngleX = f6 * (0.2617994F + f4) + f5 * (2.1816616F + MathHelper.sin(f9) * 0.05F);
		this.body.rotateAngleX = f6 * (-(float) Math.PI / 4F) + f7 * this.body.rotateAngleX;
		float f14 = 0.2617994F * f6;
		float f15 = MathHelper.cos(f9 * 0.6F + (float) Math.PI);
		float f16 = ((-(float) Math.PI / 3F) + f15) * f6 + f12 * f7;
		float f17 = ((-(float) Math.PI / 3F) - f15) * f6 - f12 * f7;
		this.field_228262_f_.rotateAngleX = f14 - f11 * 0.5F * limbSwingAmount * f7;
		this.field_228263_g_.rotateAngleX = f14 + f11 * 0.5F * limbSwingAmount * f7;
		this.field_228264_h_.rotateAngleX = f16;
		this.field_228265_i_.rotateAngleX = f17;
		this.tail.rotateAngleX = ((float) Math.PI / 6F) + limbSwingAmount * 0.75F;
		this.tail.rotationPointY = -5.0F + limbSwingAmount;
		this.tail.rotationPointZ = 2.0F + limbSwingAmount * 2.0F;
		if (flag) {
			this.tail.rotateAngleY = MathHelper.cos(f9 * 0.7F);
		} else {
			this.tail.rotateAngleY = 0.0F;
		}

		this.field_228266_j_.rotationPointY = this.field_228262_f_.rotationPointY;
		this.field_228266_j_.rotationPointZ = this.field_228262_f_.rotationPointZ;
		this.field_228266_j_.rotateAngleX = this.field_228262_f_.rotateAngleX;
		this.field_228267_k_.rotationPointY = this.field_228263_g_.rotationPointY;
		this.field_228267_k_.rotationPointZ = this.field_228263_g_.rotationPointZ;
		this.field_228267_k_.rotateAngleX = this.field_228263_g_.rotateAngleX;
		this.field_228268_l_.rotationPointY = this.field_228264_h_.rotationPointY;
		this.field_228268_l_.rotationPointZ = this.field_228264_h_.rotationPointZ;
		this.field_228268_l_.rotateAngleX = this.field_228264_h_.rotateAngleX;
		this.field_228269_m_.rotationPointY = this.field_228265_i_.rotationPointY;
		this.field_228269_m_.rotationPointZ = this.field_228265_i_.rotationPointZ;
		this.field_228269_m_.rotateAngleX = this.field_228265_i_.rotateAngleX;
		boolean flag1 = entityIn.isChild();
		this.field_228262_f_.showModel = !flag1;
		this.field_228263_g_.showModel = !flag1;
		this.field_228264_h_.showModel = !flag1;
		this.field_228265_i_.showModel = !flag1;
		this.field_228266_j_.showModel = flag1;
		this.field_228267_k_.showModel = flag1;
		this.field_228268_l_.showModel = flag1;
		this.field_228269_m_.showModel = flag1;
		this.body.rotationPointY = flag1 ? 10.8F : 0.0F;
	}
}