package com.technologica.client.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.util.Mth;

public class TurkeyModel<T extends Animal> extends AgeableListModel<T> {
	/*
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart rightLeg;
	private final ModelPart leftLeg;
	private final ModelPart rightWing;
	private final ModelPart leftWing;
	private final ModelPart bill;
	private final ModelPart chin;
	private final ModelPart tail;
	*/

	public TurkeyModel() {
		/*
		texWidth = 64;
		texHeight = 32;
		
		this.head = new ModelPart(this, 0, 16);
		this.head.addBox(-2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 4.0F);
		this.head.setPos(0.0F, 11.0F, -1.0F);
		
		this.bill = new ModelPart(this, 12, 16);
		this.bill.addBox(-2.0F, 0.0F, -6.0F, 4.0F, 2.0F, 2.0F);
		this.head.addChild(this.bill);
		
		this.chin = new ModelPart(this, 0, 0);
		this.chin.addBox(-1.0F, 2.0F, -4.0F, 2.0F, 3.0F, 1.0F);
		this.head.addChild(this.chin);
		
		this.body = new ModelPart(this, 0, 0);
		this.body.addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F);
		this.body.setPos(0.0F, 15.0F, 0.0F);
		
		this.rightLeg = new ModelPart(this, 34, 13);
		this.rightLeg.addBox(-1.0F, 0.0F, -3.0F, 3.0F, 5.0F, 3.0F);
		this.rightLeg.setPos(-2.0F, 19.0F, 1.0F);
		
		this.leftLeg = new ModelPart(this, 34, 13);
		this.leftLeg.addBox(-1.0F, 0.0F, -3.0F, 3.0F, 5.0F, 3.0F);
		this.leftLeg.setPos(1.0F, 19.0F, 1.0F);
		
		this.rightWing = new ModelPart(this, 24, 13);
		this.rightWing.addBox(-1.0F, -2.0F, 0.0F, 1.0F, 4.0F, 8.0F);
		this.rightWing.setPos(-4.0F, 13.0F, -2.0F);
		
		this.leftWing = new ModelPart(this, 24, 13);
		this.leftWing.addBox(0.0F, -2.0F, 0.0F, 1.0F, 4.0F, 8.0F);
		this.leftWing.setPos(4.0F, 13.0F, -2.0F);
		
		this.tail = new ModelPart(this, 32, 0);
		this.tail.addBox(0.0F, 0.0F, 0.0F, 12.0F, 12.0F, 1.0F);
		this.tail.setPos(0.0F, 4.0F, 4.0F);
		this.body.addChild(this.tail);
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

	@Override
	public void setupAnim(T p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_,
			float p_102623_) {
		// TODO Auto-generated method stub
		
	}

	/*
	@Override
	protected Iterable<ModelPart> headParts() {
		return ImmutableList.of(this.head);
	}

	@Override
	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(this.body, this.rightLeg, this.leftLeg, this.rightWing, this.leftWing);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		
		this.rightWing.xRot = -(float) Math.PI / 4;
		this.leftWing.xRot = -(float) Math.PI / 4;
		this.tail.zRot = -3 * (float) Math.PI / 4;
		this.head.xRot = headPitch * ((float)Math.PI / 180F);
	    this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
	    
	    this.rightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	    this.leftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
	    this.rightWing.zRot = ageInTicks;
	    this.leftWing.zRot = -ageInTicks;
	}
	*/
}
