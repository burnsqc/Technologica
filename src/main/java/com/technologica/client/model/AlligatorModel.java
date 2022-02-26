package com.technologica.client.model;

import com.technologica.world.entity.animal.AlligatorEntity;

import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;

public class AlligatorModel<T extends AlligatorEntity> extends QuadrupedModel<T> {

	//private final ModelPart tail;
	//private final ModelPart tail2;
	//private final ModelPart tail3;
	//private final ModelPart nose;
	//private final ModelPart jaw;
	//private final ModelPart teethUpper;
	//private final ModelPart teethLower;
	//private final ModelPart eyeLeft;
	//private final ModelPart eyeRight;
	
	public AlligatorModel(ModelPart modelPartIn) {
		super(modelPartIn, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		/*
		this.texWidth = 64;
		this.texHeight = 64;

		this.body = new ModelPart(this, 0, 0);
		this.body.addBox(-5.0F, -3.0F, -8.0F, 10.0F, 6.0F, 16.0F);
		this.body.setPos(0.0F, 19.0F, 0.0F);

		this.tail = new ModelPart(this, 36, 0);
		this.tail.addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 8.0F);
		this.tail.setPos(0.0F, 0.0F, 8.0F);
		this.body.addChild(this.tail);
		
		this.tail2 = new ModelPart(this, 0, 22);
		this.tail2.addBox(-2.0F, -2.0F, 0.0F, 4.0F, 5.0F, 8.0F);
		this.tail2.setPos(0.0F, 0.0F, 8.0F);
		this.tail.addChild(this.tail2);
		
		this.tail3 = new ModelPart(this, 44, 14);
		this.tail3.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 4.0F, 8.0F);
		this.tail3.setPos(0.0F, 0.0F, 8.0F);
		this.tail2.addChild(this.tail3);
		
		this.head = new ModelPart(this, 24, 22);
		this.head.addBox(-4.0F, -3.0F, -4.0F, 8.0F, 6.0F, 4.0F);
		this.head.setPos(0.0F, 19.0F, -8.0F);
		
		this.nose = new ModelPart(this, 0, 35);
		this.nose.setPos(0.0F, -1.0F, -4.0F);
		this.nose.addBox(-3.0F, -2.0F, -8.0F, 6.0F, 2.0F, 8.0F);
		this.head.addChild(this.nose);
		
		this.jaw = new ModelPart(this, 20, 32);
		this.jaw.setPos(0.0F, -1.0F, -4.0F);
		this.jaw.addBox(-3.0F, 0.0F, -8.0F, 6.0F, 2.0F, 8.0F);
		this.head.addChild(this.jaw);
		
		this.teethUpper = new ModelPart(this, 0, 45);
		this.teethUpper.addBox(-2.5F, 0.0F, -7.5F, 5.0F, 1.0F, 8.0F);
		this.nose.addChild(this.teethUpper);
		
		this.teethLower = new ModelPart(this, 26, 45);
		this.teethLower.addBox(-2.5F, -1.0F, -7.5F, 5.0F, 1.0F, 8.0F);
		this.jaw.addChild(this.teethLower);
		
		this.eyeLeft = new ModelPart(this, 0, 10);
		this.eyeLeft.addBox(1.0F, -3.0F, -3.0F, 1.0F, 1.0F, 2.0F);
		this.nose.addChild(this.eyeLeft);
		
		this.eyeRight = new ModelPart(this, 6, 10);
		this.eyeRight.addBox(-2.0F, -3.0F, -3.0F, 1.0F, 1.0F, 2.0F);
		this.nose.addChild(this.eyeRight);
		
		this.leg0 = new ModelPart(this, 0, 0);
		this.leg0.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F);
		this.leg0.setPos(-5.0F, 18.0F, 7.0F);
		
		this.leg1 = new ModelPart(this, 0, 0);
		this.leg1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F);
		this.leg1.setPos(5.0F, 18.0F, 7.0F);
		
		this.leg2 = new ModelPart(this, 0, 0);
		this.leg2.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F);
		this.leg2.setPos(-5.0F, 18.0F, -5.0F);
		
		this.leg3 = new ModelPart(this, 0, 0);
		this.leg3.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F);
		this.leg3.setPos(5.0F, 18.0F, -5.0F);
		*/
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.xRot = 0;
		//this.nose.xRot = -(Mth.sin(ageInTicks / 10) * Mth.sin(ageInTicks / 10))/2;
		//this.leg1.xRot = 0;
	}
}
