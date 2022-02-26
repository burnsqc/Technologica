package com.technologica.client.model;

import com.google.common.collect.ImmutableList;
import com.technologica.world.entity.animal.GiraffeEntity;

import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.util.Mth;

public class GiraffeModel<T extends AbstractHorse> extends AgeableListModel<T> {
	/*
	private final ModelPart body;
	private final ModelPart neck;
	private final ModelPart mane;
	private final ModelPart head;
	private final ModelPart nose;
	private final ModelPart earLeft;
	private final ModelPart earRight;
	private final ModelPart hornLeft;
	private final ModelPart hornRight;
	private final ModelPart legUpperBackLeft;
	private final ModelPart legUpperBackRight;
	private final ModelPart legUpperFrontLeft;
	private final ModelPart legUpperFrontRight;
	private final ModelPart legLowerBackLeft;
	private final ModelPart legLowerBackRight;
	private final ModelPart legLowerFrontLeft;
	private final ModelPart legLowerFrontRight;
	private final ModelPart tail;
	private final ModelPart saddle;
	private final ModelPart leftBit;
	private final ModelPart rightBit;
	private final ModelPart headBridle;
	private final ModelPart noseBridle;
	private final ModelPart leftReign;
	private final ModelPart rightReign;
	private final ModelPart[] saddles;
	private final ModelPart[] reigns;
	*/

	public GiraffeModel() {
		super(true, 24.0F, 1.36F, 2.7272F, 2.0F, 24.0F);
		/*
		this.texWidth = 128;
		this.texHeight = 128;

		this.body = new ModelPart(this, 0, 0);
		this.body.addBox(-5.0F, -31.0F, -17.0F, 10.0F, 12.0F, 22.0F);
		this.body.setPos(0.0F, 28.0F, 3.0F);

		this.neck = new ModelPart(this, 0, 34);
		this.neck.addBox(-2.0F, -38.0F, -6.0F, 4.0F, 37.0F, 6.0F);

		this.mane = new ModelPart(this, 20, 34);
		this.mane.addBox(-1.0F, -40.0F, 0.0F, 2.0F, 37.0F, 2.0F);
		this.neck.addChild(mane);

		this.head = new ModelPart(this, 42, 0);
		this.head.addBox(-3.0F, -5.0F, -9.0F, 6.0F, 5.0F, 9.0F);
		this.head.setPos(0.0F, -35.0F, 0.0F);
		this.neck.addChild(head);

		this.nose = new ModelPart(this, 0, 0);
		this.nose.addBox(-1.5F, -4.0F, -15.0F, 3.0F, 4.0F, 6.0F);
		this.head.addChild(nose);

		this.earLeft = new ModelPart(this, 12, 10);
		this.earLeft.addBox(0F, -3.0F, -1.0F, 4.0F, 3.0F, 1.0F, 0.0F);
		this.earLeft.setPos(3.0F, -1.0F, -2.0F);
		this.head.addChild(earLeft);

		this.earRight = new ModelPart(this, 12, 0);
		this.earRight.addBox(-4.0F, -3.0F, -1.0F, 4.0F, 3.0F, 1.0F, 0.0F);
		this.earRight.setPos(-3.0F, -1.0F, -2.0F);
		this.head.addChild(earRight);

		this.hornLeft = new ModelPart(this, 0, 0);
		this.hornLeft.addBox(1.0F, -7.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F);
		this.head.addChild(hornLeft);

		this.hornRight = new ModelPart(this, 0, 0);
		this.hornRight.addBox(-2.0F, -7.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F);
		this.head.addChild(hornRight);

		this.legUpperBackLeft = new ModelPart(this, 28, 34);
		this.legUpperBackLeft.mirror = true;
		this.legUpperBackLeft.addBox(-1.99F, -4.0F, -3.99F, 3.98F, 12.0F, 3.98F, 0.0F);
		this.legUpperBackLeft.setPos(3.0F, -19.0F, 5.0F);
		this.body.addChild(this.legUpperBackLeft);

		this.legUpperBackRight = new ModelPart(this, 28, 34);
		this.legUpperBackRight.addBox(-1.99F, -4.0F, -3.99F, 3.98F, 12.0F, 3.98F, 0.0F);
		this.legUpperBackRight.setPos(-3.0F, -19.0F, 5.0F);
		this.body.addChild(this.legUpperBackRight);

		this.legUpperFrontLeft = new ModelPart(this, 44, 56);
		this.legUpperFrontLeft.mirror = true;
		this.legUpperFrontLeft.addBox(-1.99F, -4.0F, 0.01F, 3.98F, 18.0F, 3.98F, 0.0F);
		this.legUpperFrontLeft.setPos(3.0F, -19.0F, -17.0F);
		this.body.addChild(this.legUpperFrontLeft);

		this.legUpperFrontRight = new ModelPart(this, 44, 56);
		this.legUpperFrontRight.addBox(-1.99F, -4.0F, 0.01F, 3.98F, 18.0F, 3.98F, 0.0F);
		this.legUpperFrontRight.setPos(-3.0F, -19.0F, -17.0F);
		this.body.addChild(this.legUpperFrontRight);

		this.legLowerBackLeft = new ModelPart(this, 60, 34);
		this.legLowerBackLeft.mirror = true;
		this.legLowerBackLeft.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 24.0F, 4.0F, 0.0F);
		this.legLowerBackLeft.setPos(0.0F, 8.0F, 0.0F);
		this.legUpperBackLeft.addChild(this.legLowerBackLeft);

		this.legLowerBackRight = new ModelPart(this, 60, 34);
		this.legLowerBackRight.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 24.0F, 4.0F, 0.0F);
		this.legLowerBackRight.setPos(0.0F, 8.0F, 0.0F);
		this.legUpperBackRight.addChild(this.legLowerBackRight);

		this.legLowerFrontLeft = new ModelPart(this, 44, 34);
		this.legLowerFrontLeft.mirror = true;
		this.legLowerFrontLeft.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 18.0F, 4.0F, 0.0F);
		this.legLowerFrontLeft.setPos(0.0F, 14.0F, 0.0F);
		this.legUpperFrontLeft.addChild(this.legLowerFrontLeft);

		this.legLowerFrontRight = new ModelPart(this, 44, 34);
		this.legLowerFrontRight.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 18.0F, 4.0F, 0.0F);
		this.legLowerFrontRight.setPos(0.0F, 14.0F, 0.0F);
		this.legUpperFrontRight.addChild(this.legLowerFrontRight);

		this.tail = new ModelPart(this, 28, 50);
		this.tail.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 16.0F, 2.0F);
		this.tail.setPos(0.0F, -30.0F, 5.0F);
		this.body.addChild(this.tail);

		this.saddle = new ModelPart(this, 72, 0);
		this.saddle.addBox(-5.0F, -31.0F, -9.0F, 10.0F, 9.0F, 9.0F, 0.5F);
		this.body.addChild(saddle);
		
		this.headBridle = new ModelPart(this, 72, 18);
		this.headBridle.addBox(-3.0F, -5.0F, -8.9F, 6.0F, 5.0F, 8.0F, 0.2F);
		this.head.addChild(this.headBridle);
		
		this.noseBridle = new ModelPart(this, 69, 0);
		this.noseBridle.addBox(-1.5F, -4.0F, -11.0F, 3.0F, 4.0F, 2.0F, 0.2F);
		this.head.addChild(this.noseBridle);
		
		this.leftBit = new ModelPart(this, 101, 0);
		this.leftBit.addBox(1.5F, -3.0F, -13.0F, 1.0F, 2.0F, 2.0F);
		this.head.addChild(this.leftBit);
		
		this.rightBit = new ModelPart(this, 101, 0);
		this.rightBit.addBox(-2.5F, -3.0F, -13.0F, 1.0F, 2.0F, 2.0F);
		this.head.addChild(this.rightBit);
		
		this.leftReign = new ModelPart(this, 42, 19);
		this.leftReign.addBox(3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F);
		this.leftReign.xRot = (-(float) Math.PI / 6F);
		this.neck.addChild(this.leftReign);
		
		this.rightReign = new ModelPart(this, 42, 19);
		this.rightReign.addBox(-3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F);
		this.rightReign.xRot = (-(float) Math.PI / 6F);
		this.neck.addChild(this.rightReign);
		
		this.saddles = new ModelPart[] { this.saddle, this.headBridle, this.noseBridle, this.leftBit, this.rightBit };
		this.reigns = new ModelPart[] { leftReign, rightReign };
		*/
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition partdefinition = meshdefinition.getRoot();
		
		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 14).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 21.0F, -4.0F));
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 10.0F, -6.0F, 6.0F, 6.0F, 8.0F), PartPose.offset(0.0F, 6.0F, 2.0F));
		
		partdefinition.addOrReplaceChild("rightHindLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(-2.0F, 21.0F, 3.0F));
		partdefinition.addOrReplaceChild("leftHindLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(2.0F, 21.0F, 3.0F));
		partdefinition.addOrReplaceChild("rightFrontLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(-2.0F, 21.0F, -3.0F));
		partdefinition.addOrReplaceChild("leftFrontLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(2.0F, 21.0F, -3.0F));
		partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 6.0F), PartPose.offset(0.0F, 14.0F, 2.0F));
		
		return LayerDefinition.create(meshdefinition, 32, 32);
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
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		boolean flag = entityIn.isSaddled();
		boolean flag1 = entityIn.isVehicle();

		this.earLeft.zRot = -0.5F;
		this.earRight.zRot = 0.5F;
		this.tail.xRot = ((float) Math.PI / 8F);

		for (ModelPart modelrenderer : this.saddles) {
			modelrenderer.visible = flag;
		}

		for (ModelPart modelrenderer1 : this.reigns) {
			modelrenderer1.visible = flag1 && flag;
		}

		this.body.y = 11.0F;
	}

	public Iterable<ModelPart> headParts() {
		return ImmutableList.of(this.neck);
	}

	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(this.body);
	}

	public void prepareMobModel(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		float f = Mth.lerp(partialTick, entityIn.yBodyRotO, entityIn.yBodyRot);
		float f1 = Mth.lerp(partialTick, entityIn.yHeadRotO, entityIn.yHeadRot);
		
		float f3 = f1 - f;
		
		if (f3 > 20.0F) {
			f3 = 20.0F;
		}

		if (f3 < -20.0F) {
			f3 = -20.0F;
		}

	    float f6 = entityIn.getStandAnim(partialTick);
	    float f7 = 1.0F - f6;
	    float f9 = (float)entityIn.tickCount + partialTick;
		float f10 = entityIn.isInWater() ? 0.2F : 1.0F;
		
		boolean tailWagging = entityIn.tailCounter != 0;
		boolean earsFlapping = ((GiraffeEntity) entityIn).earCounter != 0;
		
		this.neck.y = -16.0F;
		this.neck.z = -8.0F;

		this.body.xRot = 0.0F;
		this.neck.xRot = ((float) Math.PI / 10F) + Mth.sin(f10 * limbSwing * 0.5F) / 10;
		this.head.xRot = -((float) Math.PI / 10F) + Mth.cos(f10 * limbSwing * 0.5F) / 10;
		this.neck.yRot = f3 * ((float) Math.PI / 180F);
		
		this.neck.y = f7 * this.neck.y - f6*15;
	    this.neck.z = f7 * this.neck.z + f6*15;
		
	    this.body.xRot = f6 * (-(float) Math.PI / 4F) + this.body.xRot;

		this.legUpperFrontRight.xRot = -((Mth.sin(f10 * limbSwing * 0.25F) * Mth.sin(f10 * limbSwing * 0.25F)) * limbSwingAmount * 1.5F) - f6 / 2 * Mth.sin(f9 * 0.25F) * f6 * Mth.sin(f9 * 0.25F);
		this.legLowerFrontRight.xRot = (Mth.cos(f10 * limbSwing * 0.25F + (float) Math.PI / 4F) * Mth.cos(f10 * limbSwing * 0.25F + (float) Math.PI / 4F)) * limbSwingAmount * 1.5F + f6 * Mth.cos(f9 * 0.25F - (float) Math.PI / 4) * f6 * Mth.cos(f9 * 0.25F - (float) Math.PI / 4);

		this.legUpperBackLeft.xRot = (Mth.cos(f10 * limbSwing * 0.25F + (float) Math.PI / 4F) * Mth.cos(f10 * limbSwing * 0.25F + (float) Math.PI / 4F)) * limbSwingAmount * 1.5F + f6 / 2;
		this.legLowerBackLeft.xRot = -((Mth.cos(f10 * limbSwing * 0.25F) * Mth.cos(f10 * limbSwing * 0.25F)) * limbSwingAmount * 1.5F) - f6 / 2;

		this.legUpperFrontLeft.xRot = -((Mth.cos(f10 * limbSwing * 0.25F) * Mth.cos(f10 * limbSwing * 0.25F)) * limbSwingAmount * 1.5F) - f6 / 2 * Mth.cos(f9 * 0.25F) * f6 * Mth.cos(f9 * 0.25F);
		this.legLowerFrontLeft.xRot = (Mth.sin(f10 * limbSwing * 0.25F + (float) Math.PI / 4F) * Mth.sin(f10 * limbSwing * 0.25F + (float) Math.PI / 4F)) * limbSwingAmount * 1.5F + f6 * Mth.sin(f9 * 0.25F - (float) Math.PI / 4) * f6 * Mth.sin(f9 * 0.25F - (float) Math.PI / 4);

		this.legUpperBackRight.xRot = (Mth.sin(f10 * limbSwing * 0.25F + (float) Math.PI / 4F) * Mth.sin(f10 * limbSwing * 0.25F + (float) Math.PI / 4F)) * limbSwingAmount * 1.5F + f6 / 2;
		this.legLowerBackRight.xRot = -((Mth.sin(f10 * limbSwing * 0.25F) * Mth.sin(f10 * limbSwing * 0.25F)) * limbSwingAmount * 1.5F) - f6 / 2;
		
		if (tailWagging) {
			this.tail.yRot = Mth.cos(f9);
		} else {
			this.tail.yRot = 0.0F;
		}
		
		if (earsFlapping) {
			this.earLeft.yRot = Mth.cos((float) entityIn.tickCount + partialTick);
			this.earRight.yRot = -Mth.cos((float) entityIn.tickCount + partialTick);
		} else {
			this.earLeft.yRot = 0.0F;
			this.earRight.yRot = 0.0F;
		}
	}
	*/
}