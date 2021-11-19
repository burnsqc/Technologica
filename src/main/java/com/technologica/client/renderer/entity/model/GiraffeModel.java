package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.util.math.MathHelper;

public class GiraffeModel<T extends AbstractHorseEntity> extends AgeableModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer neck;
	private final ModelRenderer mane;
	private final ModelRenderer head;
	private final ModelRenderer nose;
	private final ModelRenderer earLeft;
	private final ModelRenderer earRight;
	private final ModelRenderer hornLeft;
	private final ModelRenderer hornRight;
	private final ModelRenderer legUpperBackLeft;
	private final ModelRenderer legUpperBackRight;
	private final ModelRenderer legUpperFrontLeft;
	private final ModelRenderer legUpperFrontRight;
	private final ModelRenderer legLowerBackLeft;
	private final ModelRenderer legLowerBackRight;
	private final ModelRenderer legLowerFrontLeft;
	private final ModelRenderer legLowerFrontRight;
	private final ModelRenderer tail;
	private final ModelRenderer[] field_217134_k;
	private final ModelRenderer[] field_217135_l;

	public GiraffeModel(float p_i51065_1_) {
		this.textureWidth = 64;
		this.textureHeight = 64;
		
		this.body = new ModelRenderer(this, 0, 32);
		this.body.addBox(-5.0F, -31.0F, -17.0F, 10.0F, 12.0F, 22.0F);
		this.body.setRotationPoint(0.0F, 28.0F, 3.0F);
		
		this.neck = new ModelRenderer(this, 0, 35);
		this.neck.addBox(-2.0F, -38.0F, -6.0F, 4.0F, 37.0F, 6.0F);
		this.neck.setRotationPoint(0.0F, -16.0F, -8.0F);
		
		this.mane = new ModelRenderer(this, 56, 36);
		this.mane.addBox(-1.0F, -40.0F, 0.0F, 2.0F, 37.0F, 2.0F);
		this.neck.addChild(mane);
		
		this.head = new ModelRenderer(this, 0, 13);
		this.head.addBox(-3.0F, -5.0F, -9.0F, 6.0F, 5.0F, 9.0F);
		this.head.setRotationPoint(0.0F, -35.0F, 0.0F);
		this.neck.addChild(head);

		this.nose = new ModelRenderer(this, 0, 25);
		this.nose.addBox(-1.5F, -4.0F, -15.0F, 3.0F, 4.0F, 6.0F);
		this.head.addChild(nose);
		
		this.earLeft = new ModelRenderer(this, 19, 16);
		this.earLeft.addBox(0F, -3.0F, -1.0F, 4.0F, 3.0F, 1.0F, 0.0F);
		this.earLeft.setRotationPoint(3.0F, -1.0F, -2.0F);
		this.head.addChild(earLeft);
		
		this.earRight = new ModelRenderer(this, 19, 16);
		this.earRight.addBox(-4.0F, -3.0F, -1.0F, 4.0F, 3.0F, 1.0F, 0.0F);
		this.earRight.setRotationPoint(-3.0F, -1.0F, -2.0F);
		this.head.addChild(earRight);
		
		this.hornLeft = new ModelRenderer(this, 19, 16);
		this.hornLeft.addBox(1.0F, -7.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F);
		this.head.addChild(hornLeft);
		
		this.hornRight = new ModelRenderer(this, 19, 16);
		this.hornRight.addBox(-2.0F, -7.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F);
		this.head.addChild(hornRight);
		
		this.legUpperBackLeft = new ModelRenderer(this, 48, 21);
		this.legUpperBackLeft.mirror = true;
		this.legUpperBackLeft.addBox(-1.99F, -4.0F, -3.99F, 3.98F, 12.0F, 3.98F, 0.0F);
		this.legUpperBackLeft.setRotationPoint(3.0F, -19.0F, 5.0F);
		this.body.addChild(this.legUpperBackLeft);
		
		this.legUpperBackRight = new ModelRenderer(this, 48, 21);
		this.legUpperBackRight.addBox(-1.99F, -4.0F, -3.99F, 3.98F, 12.0F, 3.98F, 0.0F);
		this.legUpperBackRight.setRotationPoint(-3.0F, -19.0F, 5.0F);
		this.body.addChild(this.legUpperBackRight);
		
		this.legUpperFrontLeft = new ModelRenderer(this, 48, 21);
		this.legUpperFrontLeft.mirror = true;
		this.legUpperFrontLeft.addBox(-1.99F, -4.0F, 0.01F, 3.98F, 18.0F, 3.98F, 0.0F);
		this.legUpperFrontLeft.setRotationPoint(3.0F, -19.0F, -17.0F);
		this.body.addChild(this.legUpperFrontLeft);
		
		this.legUpperFrontRight = new ModelRenderer(this, 48, 21);
		this.legUpperFrontRight.addBox(-1.99F, -4.0F, 0.01F, 3.98F, 18.0F, 3.98F, 0.0F);
		this.legUpperFrontRight.setRotationPoint(-3.0F, -19.0F, -17.0F);
		this.body.addChild(this.legUpperFrontRight);
		
		this.legLowerBackLeft = new ModelRenderer(this, 48, 21);
		this.legLowerBackLeft.mirror = true;
		this.legLowerBackLeft.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 24.0F, 4.0F, 0.0F);
		this.legLowerBackLeft.setRotationPoint(0.0F, 8.0F, 0.0F);
		this.legUpperBackLeft.addChild(this.legLowerBackLeft);
		
		this.legLowerBackRight = new ModelRenderer(this, 48, 21);
		this.legLowerBackRight.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 24.0F, 4.0F, 0.0F);
		this.legLowerBackRight.setRotationPoint(0.0F, 8.0F, 0.0F);
		this.legUpperBackRight.addChild(this.legLowerBackRight);
		
		this.legLowerFrontLeft = new ModelRenderer(this, 48, 21);
		this.legLowerFrontLeft.mirror = true;
		this.legLowerFrontLeft.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 18.0F, 4.0F, 0.0F);
		this.legLowerFrontLeft.setRotationPoint(0.0F, 14.0F, 0.0F);
		this.legUpperFrontLeft.addChild(this.legLowerFrontLeft);
		
		this.legLowerFrontRight = new ModelRenderer(this, 48, 21);
		this.legLowerFrontRight.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 18.0F, 4.0F, 0.0F);
		this.legLowerFrontRight.setRotationPoint(0.0F, 14.0F, 0.0F);
		this.legUpperFrontRight.addChild(this.legLowerFrontRight);
		
		this.tail = new ModelRenderer(this, 42, 36);
		this.tail.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 16.0F, 2.0F);
		this.tail.setRotationPoint(0.0F, -30.0F, 5.0F);
		this.body.addChild(this.tail);
		
		ModelRenderer modelrenderer3 = new ModelRenderer(this, 26, 0);
		modelrenderer3.addBox(-5.0F, -8.0F, -9.0F, 10.0F, 9.0F, 9.0F, 0.5F);
		this.body.addChild(modelrenderer3);
		ModelRenderer modelrenderer4 = new ModelRenderer(this, 29, 5);
		modelrenderer4.addBox(2.0F, -9.0F, -6.0F, 1.0F, 2.0F, 2.0F, p_i51065_1_);
		this.neck.addChild(modelrenderer4);
		ModelRenderer modelrenderer5 = new ModelRenderer(this, 29, 5);
		modelrenderer5.addBox(-3.0F, -9.0F, -6.0F, 1.0F, 2.0F, 2.0F, p_i51065_1_);
		this.neck.addChild(modelrenderer5);
		ModelRenderer modelrenderer6 = new ModelRenderer(this, 32, 2);
		modelrenderer6.addBox(3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F, p_i51065_1_);
		modelrenderer6.rotateAngleX = (-(float) Math.PI / 6F);
		this.neck.addChild(modelrenderer6);
		ModelRenderer modelrenderer7 = new ModelRenderer(this, 32, 2);
		modelrenderer7.addBox(-3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F, p_i51065_1_);
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
		boolean flag = entityIn.isHorseSaddled();
		boolean flag1 = entityIn.isBeingRidden();

		this.neck.rotateAngleX = ((float) Math.PI / 10F);
		this.head.rotateAngleX = -((float) Math.PI / 10F);
		this.earLeft.rotateAngleZ = -0.5F;
		this.earRight.rotateAngleZ = 0.5F;
		this.tail.rotateAngleX = ((float) Math.PI / 8F);
		this.tail.rotateAngleY = 0;
		this.legLowerBackLeft.rotateAngleY = 0;
		
		for (ModelRenderer modelrenderer : this.field_217134_k) {
			modelrenderer.showModel = flag;
		}

		for (ModelRenderer modelrenderer1 : this.field_217135_l) {
			modelrenderer1.showModel = flag1 && flag;
		}

		this.body.rotationPointY = 11.0F;
	}

	public Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of(this.neck);
	}

	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.body);
	}
	
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
	      super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	      float f = MathHelper.rotLerp(entityIn.prevRenderYawOffset, entityIn.renderYawOffset, partialTick);
	      float f1 = MathHelper.rotLerp(entityIn.prevRotationYawHead, entityIn.rotationYawHead, partialTick);
	      float f2 = MathHelper.lerp(partialTick, entityIn.prevRotationPitch, entityIn.rotationPitch);
	      float f3 = f1 - f;
	      float f4 = f2 * ((float)Math.PI / 180F);
	      if (f3 > 20.0F) {
	         f3 = 20.0F;
	      }

	      if (f3 < -20.0F) {
	         f3 = -20.0F;
	      }

	      if (limbSwingAmount > 0.2F) {
	         f4 += MathHelper.cos(limbSwing * 0.4F) * 0.15F * limbSwingAmount;
	      }

	      boolean flag = entityIn.tailCounter != 0;
	      float f9 = (float)entityIn.ticksExisted + partialTick;
	      
	      this.body.rotateAngleX = 0.0F;
	      this.neck.rotateAngleX = ((float)Math.PI / 6F) + f4;
	      this.neck.rotateAngleY = f3 * ((float)Math.PI / 180F);
	      
	      float f10 = entityIn.isInWater() ? 0.2F : 1.0F;
	      float f13 = (1.0F - Math.max(entityIn.getRearingAmount(partialTick), entityIn.getGrassEatingAmount(partialTick))) * (((float)Math.PI / 6F) + f4 + entityIn.getMouthOpennessAngle(partialTick) * MathHelper.sin(f9) * 0.05F);
	      
	      this.neck.rotateAngleX = entityIn.getRearingAmount(partialTick) * (0.2617994F + f4) + entityIn.getGrassEatingAmount(partialTick) * (2.1816616F + MathHelper.sin(f9) * 0.05F) + f13;
	      this.neck.rotateAngleY = entityIn.getRearingAmount(partialTick) * f3 * ((float)Math.PI / 180F) + (1.0F - Math.max(entityIn.getRearingAmount(partialTick), entityIn.getGrassEatingAmount(partialTick))) * this.neck.rotateAngleY;
	      
	      this.body.rotateAngleX = entityIn.getRearingAmount(partialTick) * (-(float)Math.PI / 4F) + (1.0F - entityIn.getRearingAmount(partialTick)) * this.body.rotateAngleX;
	      
	      this.legUpperFrontRight.rotateAngleX = -((MathHelper.sin(f10 * limbSwing * 0.25F) * MathHelper.sin(f10 * limbSwing * 0.25F)) * limbSwingAmount * 1.5F);
	      this.legLowerFrontRight.rotateAngleX = 2.0F * ((MathHelper.sin(f10 * limbSwing * 0.25F) * MathHelper.sin(f10 * limbSwing * 0.25F)) * limbSwingAmount * 1.5F);
	      
	      this.legUpperBackLeft.rotateAngleX = (MathHelper.cos(f10 * limbSwing * 0.25F + (float) Math.PI/4F) * MathHelper.cos(f10 * limbSwing * 0.25F + (float) Math.PI/4F)) * limbSwingAmount * 1.5F;
	      this.legLowerBackLeft.rotateAngleX = -2.0F * (MathHelper.cos(f10 * limbSwing * 0.25F + (float) Math.PI/4F) * MathHelper.cos(f10 * limbSwing * 0.25F + (float) Math.PI/4F)) * limbSwingAmount * 1.5F;
	      
	      this.legUpperFrontLeft.rotateAngleX = -((MathHelper.cos(f10 * limbSwing * 0.25F) * MathHelper.cos(f10 * limbSwing * 0.25F)) * limbSwingAmount * 1.5F);
	      this.legLowerFrontLeft.rotateAngleX = 2.0F * ((MathHelper.cos(f10 * limbSwing * 0.25F) * MathHelper.cos(f10 * limbSwing * 0.25F)) * limbSwingAmount * 1.5F);
	      
	      this.legUpperBackRight.rotateAngleX = (MathHelper.sin(f10 * limbSwing * 0.25F + (float) Math.PI/4F) * MathHelper.sin(f10 * limbSwing * 0.25F + (float) Math.PI/4F)) * limbSwingAmount * 1.5F;
	      this.legLowerBackRight.rotateAngleX = -2.0F * (MathHelper.sin(f10 * limbSwing * 0.25F + (float) Math.PI/4F) * MathHelper.sin(f10 * limbSwing * 0.25F + (float) Math.PI/4F)) * limbSwingAmount * 1.5F;

	      this.tail.rotateAngleX = ((float)Math.PI / 6F) + limbSwingAmount * 0.75F;
	     
	      if (flag) {
	         this.tail.rotateAngleY = MathHelper.cos(f9 * 0.7F);
	      } else {
	         this.tail.rotateAngleY = 0.0F;
	      }
/*
	      this.field_228266_j_.rotateAngleX = this.field_228262_f_.rotateAngleX;
	      this.field_228267_k_.rotateAngleX = this.field_228263_g_.rotateAngleX;
	      this.field_228268_l_.rotateAngleX = this.field_228264_h_.rotateAngleX;
	      this.field_228269_m_.rotateAngleX = this.field_228265_i_.rotateAngleX; 
	      */
	   }
}