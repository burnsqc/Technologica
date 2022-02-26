package com.technologica.client.model;

import com.google.common.collect.ImmutableList;
import com.technologica.world.entity.animal.CamelEntity;

import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;

public class CamelModel<T extends CamelEntity> extends AgeableListModel<T> {
	/*
	protected final ModelPart body;
	protected final ModelPart humpLower;
	protected final ModelPart humpUpper;
	protected final ModelPart tail;
	protected final ModelPart neckLower;
	protected final ModelPart neck;
	protected final ModelPart head;
	protected final ModelPart nose;
	protected final ModelPart earLeft;
	protected final ModelPart earRight;
	
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	
	private final ModelPart[] saddleParts;
	private final ModelPart[] ridingParts;
	 */
	
	public CamelModel(ModelPart modelPartIn) {
		super(true, 16.2F, 1.36F, 2.7272F, 2.0F, 20.0F);
		/*
		this.texWidth = 64;
		this.texHeight = 64;
		
		this.body = new ModelPart(this, 0, 0);
		this.body.addBox(-5.0F, -10.0F, -13.0F, 10.0F, 12.0F, 18.0F);
		this.body.setPos(0.0F, 11.0F, 5.0F);
		
		this.humpLower = new ModelPart(this, 0, 30);
		this.humpLower.addBox(-4.0F, -12.0F, -10.0F, 8.0F, 2.0F, 12.0F);
		this.body.addChild(this.humpLower);
		
		this.humpUpper = new ModelPart(this, 28, 30);
		this.humpUpper.addBox(-3.0F, -15.0F, -8.0F, 6.0F, 3.0F, 8.0F);
		this.body.addChild(this.humpUpper);
		
		this.tail = new ModelPart(this, 56, 0);
		this.tail.addBox(-1.0F, -2.0F, 0.0F, 2.0F, 12.0F, 2.0F);
		this.tail.setPos(0.0F, -5.0F, 2.0F);
		this.body.addChild(this.tail);
		
		this.neckLower = new ModelPart(this, 0, 44);
		this.neckLower.addBox(-2.0F, 5.0F, -6.0F, 4.0F, 5.0F, 10.0F);
		
		this.neck = new ModelPart(this, 38, 0);
		this.neck.addBox(-2.0F, -12.0F, 0.0F, 4.0F, 12.0F, 5.0F);
		this.neck.setPos(0.0F, 10.0F, -6.0F);
		this.neckLower.addChild(this.neck);
		
		this.head = new ModelPart(this, 21, 52);
		this.head.addBox(-3.0F, -17.0F, -2.0F, 6.0F, 5.0F, 7.0F);
		this.neck.addChild(head);
		
		this.nose = new ModelPart(this, 0, 0);
		this.nose.addBox(-2.0F, -16.0F, -7.0F, 4.0F, 4.0F, 5.0F);
		this.neck.addChild(nose);
		
		this.earLeft = new ModelPart(this, 0, 9);
		this.earLeft.addBox(2.0F, -17.0F, 3.0F, 2.0F, 2.0F, 1.0F);
		this.neck.addChild(earLeft);
		
		this.earRight = new ModelPart(this, 0, 9);
		this.earRight.addBox(-4.0F, -17.0F, 3.0F, 2.0F, 2.0F, 1.0F);
		this.neck.addChild(earRight);
		
		this.leg1 = new ModelPart(this, 40, 41);
		this.leg1.mirror = true;
		this.leg1.addBox(-3.0F, -1.0F, -1.5F, 3.0F, 11.0F, 3.0F);
		this.leg1.setPos(5.0F, 14.0F, 8.5F);
		
		this.leg2 = new ModelPart(this, 40, 41);
		this.leg2.addBox(-1.0F, -1.0F, -1.5F, 3.0F, 11.0F, 3.0F);
		this.leg2.setPos(-4.0F, 14.0F, 8.5F);
		
		this.leg3 = new ModelPart(this, 40, 41);
		this.leg3.mirror = true;
		this.leg3.addBox(-3.0F, -1.0F, -1.5F, 3.0F, 11.0F, 3.0F);
		this.leg3.setPos(5.0F, 14.0F, -6.5F);
		
		this.leg4 = new ModelPart(this, 40, 41);
		this.leg4.addBox(-1.0F, -1.0F, -1.5F, 3.0F, 11.0F, 3.0F);
		this.leg4.setPos(-4.0F, 14.0F, -6.5F);
		
		ModelPart modelrenderer3 = new ModelPart(this, 26, 0);
		modelrenderer3.addBox(-5.0F, -8.0F, -9.0F, 10.0F, 9.0F, 9.0F, 0.5F);
		this.body.addChild(modelrenderer3);
		ModelPart modelrenderer4 = new ModelPart(this, 29, 5);
		modelrenderer4.addBox(2.0F, -9.0F, -6.0F, 1.0F, 2.0F, 2.0F);
		this.neck.addChild(modelrenderer4);
		ModelPart modelrenderer5 = new ModelPart(this, 29, 5);
		modelrenderer5.addBox(-3.0F, -9.0F, -6.0F, 1.0F, 2.0F, 2.0F);
		this.neck.addChild(modelrenderer5);
		ModelPart modelrenderer6 = new ModelPart(this, 32, 2);
		modelrenderer6.addBox(3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F);
		modelrenderer6.xRot = (-(float) Math.PI / 6F);
		this.neck.addChild(modelrenderer6);
		ModelPart modelrenderer7 = new ModelPart(this, 32, 2);
		modelrenderer7.addBox(-3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F);
		modelrenderer7.xRot = (-(float) Math.PI / 6F);
		this.neck.addChild(modelrenderer7);
		ModelPart modelrenderer8 = new ModelPart(this, 1, 1);
		modelrenderer8.addBox(-3.0F, -11.0F, -1.9F, 6.0F, 5.0F, 6.0F, 0.2F);
		this.neck.addChild(modelrenderer8);
		ModelPart modelrenderer9 = new ModelPart(this, 19, 0);
		modelrenderer9.addBox(-2.0F, -11.0F, -4.0F, 4.0F, 5.0F, 2.0F, 0.2F);
		
		this.neck.addChild(modelrenderer9);
		
		this.saddleParts = new ModelPart[] { modelrenderer3, modelrenderer4, modelrenderer5, modelrenderer8, modelrenderer9 };
		this.ridingParts = new ModelPart[] { modelrenderer6, modelrenderer7 };
		*/
	}

	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		//this.tail.xRot = ((float) Math.PI / 6F);
		
		boolean flag = entityIn.isSaddled();
		boolean flag1 = entityIn.isVehicle();

		/*
		for (ModelPart modelrenderer : this.saddleParts) {
			modelrenderer.visible = flag;
		}
		

		for (ModelPart modelrenderer1 : this.ridingParts) {
			modelrenderer1.visible = flag1 && flag;
		}

		this.body.y = 11.0F;
		*/
	}

	/*
	public Iterable<ModelPart> headParts() {
		return ImmutableList.of(this.neckLower);
	}

	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(this.body, this.leg1, this.leg2, this.leg3, this.leg4);
	}

*/
	public void prepareMobModel(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		/*
		super.prepareMobModel(entityIn, limbSwing, limbSwingAmount, partialTick);
		float f = Mth.lerp(partialTick, entityIn.yBodyRotO, entityIn.yBodyRot);
		float f1 = Mth.lerp(partialTick, entityIn.yHeadRotO, entityIn.yHeadRot);
		float f2 = Mth.lerp(partialTick, entityIn.xRotO, entityIn.xRot);
		float f3 = f1 - f;
		float f4 = f2 * ((float) Math.PI / 180F);
		if (f3 > 20.0F) {
			f3 = 20.0F;
		}

		if (f3 < -20.0F) {
			f3 = -20.0F;
		}

		if (limbSwingAmount > 0.2F) {
			f4 += Mth.cos(limbSwing * 0.4F) * 0.15F * limbSwingAmount;
		}

		float f5 = entityIn.getEatAnim(partialTick);
		float f6 = entityIn.getStandAnim(partialTick);
		float f7 = 1.0F - f6;
		boolean flag = entityIn.tailCounter != 0;
		float f9 = (float) entityIn.tickCount + partialTick;
		this.neckLower.z = -12.0F;
		this.body.xRot = 0.0F;
		this.neckLower.yRot = f3 * ((float) Math.PI / 180F);
		float f10 = entityIn.isInWater() ? 0.2F : 1.0F;
		float f11 = Mth.cos(f10 * limbSwing * 0.6662F + (float) Math.PI);
		float f12 = f11 * 0.8F * limbSwingAmount;
		this.neck.xRot = f6 * (0.2617994F + f4) + f5 * (2.1816616F + Mth.sin(f9) * 0.05F);
		this.body.xRot = f6 * (-(float) Math.PI / 4F) + f7 * this.body.xRot;
		float f14 = 0.2617994F * f6;
		float f15 = Mth.cos(f9 * 0.6F + (float) Math.PI);
		float f16 = ((-(float) Math.PI / 3F) + f15) * f6 + f12 * f7;
		float f17 = ((-(float) Math.PI / 3F) - f15) * f6 - f12 * f7;
		this.leg1.xRot = f14 - f11 * 0.5F * limbSwingAmount * f7;
		this.leg2.xRot = f14 + f11 * 0.5F * limbSwingAmount * f7;
		this.leg3.xRot = f16;
		this.leg4.xRot = f17;
		this.tail.xRot = ((float) Math.PI / 6F) + limbSwingAmount * 0.75F;
		this.tail.y = -5.0F + limbSwingAmount;
		this.tail.z = 2.0F + limbSwingAmount * 2.0F;
		if (flag) {
			this.tail.yRot = Mth.cos(f9 * 0.7F);
		} else {
			this.tail.yRot = 0.0F;
		}

		
		boolean flag1 = entityIn.isBaby();
		this.leg1.visible = !flag1;
		this.leg2.visible = !flag1;
		this.leg3.visible = !flag1;
		this.leg4.visible = !flag1;
		
		this.body.y = flag1 ? 10.8F : 0.0F;
		*/
	}

	@Override
	protected Iterable<ModelPart> headParts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Iterable<ModelPart> bodyParts() {
		// TODO Auto-generated method stub
		return null;
	}
}