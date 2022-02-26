package com.technologica.client.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class VultureModel<T extends Entity> extends ListModel<T> {
	/*
	private final ModelPart body;
	private final ModelPart legLeft;
	private final ModelPart legRight;
	private final ModelPart neckLower;
	private final ModelPart neck;
	private final ModelPart head;
	private final ModelPart beak;
	private final ModelPart leftWingBody;
	private final ModelPart leftWing;
	private final ModelPart rightWingBody;
	private final ModelPart rightWing;
	private final ModelPart tail;
	*/

	public VultureModel() {
		/*
		this.texWidth = 64;
		this.texHeight = 64;

		this.body = new ModelPart(this, 0, 0);
		this.body.addBox(-2.5F, -2.0F, -8.0F, 5.0F, 3.0F, 9.0F);

		this.neckLower = new ModelPart(this, 19, 0);
		this.neckLower.addBox(-1.0F, 0.0F, -5.0F, 2.0F, 2.0F, 5.0F);
		this.neckLower.setPos(0.0F, -2.0F, -8.0F);
		this.body.addChild(this.neckLower);
		
		this.neck = new ModelPart(this, 33, 0);
		this.neck.addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 5.0F);
		this.neck.setPos(0.0F, 2.0F, -5.0F);
		this.neckLower.addChild(this.neck);
		
		this.head = new ModelPart(this, 47, 0);
		this.head.addBox(-1.5F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F);
		this.head.setPos(0.0F, -2.0F, -5.0F);
		this.neck.addChild(this.head);
		
		this.beak = new ModelPart(this, 0, 0);
		this.beak.addBox(-0.5F, 1.0F, -5.0F, 1.0F, 2.0F, 2.0F);
		this.head.addChild(this.beak);
		
		this.tail = new ModelPart(this, 0, 12);
		this.tail.addBox(-8.0F, -1.0F, -8.0F, 16.0F, 2.0F, 16.0F);
		this.tail.setPos(0.0F, -1.0F, 9.0F);
		this.body.addChild(this.tail);
		
		this.legLeft = new ModelPart(this, 0, 12);
		this.legLeft.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F);
		this.legLeft.setPos(-2.0F, 0.0F, -1.0F);
		this.body.addChild(this.legLeft);
		
		this.legRight = new ModelPart(this, 0, 12);
		this.legRight.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F);
		this.legRight.setPos(2.0F, 0.0F, -1.0F);
		this.body.addChild(this.legRight);

		this.leftWingBody = new ModelPart(this, 0, 30);
		this.leftWingBody.addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F);
		this.leftWingBody.setPos(2.5F, -2.0F, -8.0F);
		this.body.addChild(this.leftWingBody);

		this.leftWing = new ModelPart(this, 0, 41);
		this.leftWing.addBox(0.0F, 0.0F, 0.0F, 13.0F, 1.0F, 9.0F);
		this.leftWing.setPos(6.0F, 0.0F, 0.0F);
		this.leftWingBody.addChild(this.leftWing);

		this.rightWingBody = new ModelPart(this, 0, 30);
		this.rightWingBody.mirror = true;
		this.rightWingBody.addBox(-6.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F);
		this.rightWingBody.setPos(-2.5F, -2.0F, -8.0F);
		this.body.addChild(this.rightWingBody);

		this.rightWing = new ModelPart(this, 0, 41);
		this.rightWing.mirror = true;
		this.rightWing.addBox(-13.0F, 0.0F, 0.0F, 13.0F, 1.0F, 9.0F);
		this.rightWing.setPos(-6.0F, 0.0F, 0.0F);
		this.rightWingBody.addChild(this.rightWing);

		this.leftWingBody.zRot = 0.1F;
		this.leftWing.zRot = 0.1F;
		this.rightWingBody.zRot = -0.1F;
		this.rightWing.zRot = -0.1F;	
		*/
	}

	@Override
	public Iterable<ModelPart> parts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setupAnim(T p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_,
			float p_102623_) {
		// TODO Auto-generated method stub
		
	}

	/*
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.body);
	}

	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float ageTicker = ((float) (entityIn.getId() * 3) + ageInTicks) * 0.13F;
		this.body.xRot = -0.1F;
		this.leftWingBody.zRot = Mth.cos(ageTicker) * 16.0F * ((float) Math.PI / 180F);
		this.leftWing.zRot = Mth.cos(ageTicker) * 16.0F * ((float) Math.PI / 180F);
		this.rightWingBody.zRot = -this.leftWingBody.zRot;
		this.rightWing.zRot = -this.leftWing.zRot;
		this.tail.yRot = (float) Math.PI / 4;
		this.neckLower.xRot = (float) Math.PI / 4;
		this.neck.xRot = -(float) Math.PI / 3;
		this.head.xRot = (float) Math.PI / 4;
	}
	*/
}