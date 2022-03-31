package com.technologica.client.model;

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

public class DeerModel<T extends AbstractHorse> extends AgeableListModel<T> {
	/*
	private final ModelPart body;
	private final ModelPart neck;
	private final ModelPart head;
	private final ModelPart nose;
	private final ModelPart earLeft;
	private final ModelPart earRight;
	private final ModelPart antlerLeft1;
	private final ModelPart antlerRight1;
	private final ModelPart antlerLeft2;
	private final ModelPart antlerRight2;
	private final ModelPart antlerLeft3;
	private final ModelPart antlerRight3;
	private final ModelPart antlerLeft4;
	private final ModelPart antlerRight4;
	private final ModelPart antlerLeft5;
	private final ModelPart antlerRight5;
	private final ModelPart antlerLeft6;
	private final ModelPart antlerRight6;
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

	public DeerModel() {
		super(true, 24.0F, 1.36F, 2.7272F, 2.0F, 24.0F);
		/*
		this.texWidth = 64;
		this.texHeight = 64;

		this.body = new ModelPart(this, 0, 0);
		this.body.addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 16.0F);
		this.body.setPos(0.0F, 8.0F, 0.0F);

		this.neck = new ModelPart(this, 32, 0);
		this.neck.setPos(0.0F, 4.0F, -8.0F);
		this.neck.addBox(-2.0F, -4.0F, -3.0F, 4.0F, 8.0F, 6.0F);

		this.head = new ModelPart(this, 0, 24);
		this.head.addBox(-2.5F, 0.0F, -5.0F, 5.0F, 5.0F, 5.0F);
		this.head.setPos(0.0F, -4.0F, 3.0F);
		this.neck.addChild(head);

		this.nose = new ModelPart(this, 0, 0);
		this.nose.addBox(-1.5F, 2.0F, -9.0F, 3.0F, 3.0F, 4.0F);
		this.head.addChild(nose);

		this.earLeft = new ModelPart(this, 0, 7);
		this.earLeft.addBox(0.0F, -2.0F, -1.0F, 3.0F, 2.0F, 1.0F);
		this.earLeft.setPos(2.5F, 2.0F, 0.0F);
		this.head.addChild(earLeft);

		this.earRight = new ModelPart(this, 0, 7);
		this.earRight.addBox(-3.0F, -2.0F, -1.0F, 3.0F, 2.0F, 1.0F);
		this.earRight.setPos(-2.5F, 2.0F, 0.0F);
		this.head.addChild(earRight);

		this.antlerLeft1 = new ModelPart(this, 0, 10);
		this.antlerLeft1.setPos(0.5F, 0.0F, -2.0F);
		this.antlerLeft1.addBox(0.0F, -5.0F, -1.0F, 1.0F, 5.0F, 1.0F);
		this.head.addChild(antlerLeft1);

		this.antlerRight1 = new ModelPart(this, 0, 10);
		this.antlerRight1.setPos(-0.5F, 0.0F, -2.0F);
		this.antlerRight1.addBox(-1.0F, -5.0F, -1.0F, 1.0F, 5.0F, 1.0F);
		this.head.addChild(antlerRight1);
		
		this.antlerLeft2 = new ModelPart(this, 0, 10);
		this.antlerLeft2.setPos(0.0F, -5.0F, 0.0F);
		this.antlerLeft2.addBox(0.0F, -5.0F, -1.0F, 1.0F, 5.0F, 1.0F);
		this.antlerLeft1.addChild(antlerLeft2);

		this.antlerRight2 = new ModelPart(this, 0, 10);
		this.antlerRight2.setPos(0.0F, -5.0F, 0.0F);
		this.antlerRight2.addBox(-1.0F, -5.0F, -1.0F, 1.0F, 5.0F, 1.0F);
		this.antlerRight1.addChild(antlerRight2);
		
		this.antlerLeft3 = new ModelPart(this, 0, 10);
		this.antlerLeft3.setPos(1.0F, -5.0F, -1.0F);
		this.antlerLeft3.addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F);
		this.antlerLeft2.addChild(antlerLeft3);

		this.antlerRight3 = new ModelPart(this, 0, 10);
		this.antlerRight3.setPos(-1.0F, -5.0F, -1.0F);
		this.antlerRight3.addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F);
		this.antlerRight2.addChild(antlerRight3);
		
		this.antlerLeft4 = new ModelPart(this, 0, 10);
		this.antlerLeft4.setPos(1.0F, -2.0F, -1.0F);
		this.antlerLeft4.addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		this.antlerLeft1.addChild(antlerLeft4);

		this.antlerRight4 = new ModelPart(this, 0, 10);
		this.antlerRight4.setPos(-1.0F, -2.0F, -1.0F);
		this.antlerRight4.addBox(0.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		this.antlerRight1.addChild(antlerRight4);
		
		this.antlerLeft5 = new ModelPart(this, 0, 10);
		this.antlerLeft5.setPos(0.0F, -1.0F, -1.0F);
		this.antlerLeft5.addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F);
		this.antlerLeft2.addChild(antlerLeft5);

		this.antlerRight5 = new ModelPart(this, 0, 10);
		this.antlerRight5.setPos(0.0F, -1.0F, -1.0F);
		this.antlerRight5.addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F);
		this.antlerRight2.addChild(antlerRight5);
		
		this.antlerLeft6 = new ModelPart(this, 0, 10);
		this.antlerLeft6.setPos(0.0F, -3.0F, -1.0F);
		this.antlerLeft6.addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F);
		this.antlerLeft2.addChild(antlerLeft6);

		this.antlerRight6 = new ModelPart(this, 0, 10);
		this.antlerRight6.setPos(0.0F, -3.0F, -1.0F);
		this.antlerRight6.addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F);
		this.antlerRight2.addChild(antlerRight6);

		this.legUpperBackLeft = new ModelPart(this, 52, 0);
		this.legUpperBackLeft.mirror = true;
		this.legUpperBackLeft.addBox(-2.0F, -3.0F, -3.0F, 3.0F, 7.0F, 3.0F);
		this.legUpperBackLeft.setPos(3.0F, 4.0F, 8.0F);
		this.body.addChild(this.legUpperBackLeft);

		this.legUpperBackRight = new ModelPart(this, 52, 0);
		this.legUpperBackRight.addBox(-2.0F, -3.0F, -3.0F, 3.0F, 7.0F, 3.0F);
		this.legUpperBackRight.setPos(-2.0F, 4.0F, 8.0F);
		this.body.addChild(this.legUpperBackRight);

		this.legUpperFrontLeft = new ModelPart(this, 52, 10);
		this.legUpperFrontLeft.mirror = true;
		this.legUpperFrontLeft.addBox(-2.0F, -3.0F, 0.0F, 3.0F, 9.0F, 3.0F);
		this.legUpperFrontLeft.setPos(3.0F, 4.0F, -8.0F);
		this.body.addChild(this.legUpperFrontLeft);

		this.legUpperFrontRight = new ModelPart(this, 52, 10);
		this.legUpperFrontRight.addBox(-2.0F, -3.0F, 0.0F, 3.0F, 9.0F, 3.0F);
		this.legUpperFrontRight.setPos(-2.0F, 4.0F, -8.0F);
		this.body.addChild(this.legUpperFrontRight);

		this.legLowerBackLeft = new ModelPart(this, 52, 22);
		this.legLowerBackLeft.mirror = true;
		this.legLowerBackLeft.addBox(-2.0F, 0.0F, -3.0F, 3.0F, 8.0F, 3.0F);
		this.legLowerBackLeft.setPos(0.0F, 4.0F, 0.0F);
		this.legUpperBackLeft.addChild(this.legLowerBackLeft);

		this.legLowerBackRight = new ModelPart(this, 52, 22);
		this.legLowerBackRight.addBox(-2.0F, 0.0F, -3.0F, 3.0F, 8.0F, 3.0F);
		this.legLowerBackRight.setPos(0.0F, 4.0F, 0.0F);
		this.legUpperBackRight.addChild(this.legLowerBackRight);

		this.legLowerFrontLeft = new ModelPart(this, 52, 33);
		this.legLowerFrontLeft.mirror = true;
		this.legLowerFrontLeft.addBox(-2.0F, 0.0F, 0.0F, 3.0F, 6.0F, 3.0F);
		this.legLowerFrontLeft.setPos(0.0F, 6.0F, 0.0F);
		this.legUpperFrontLeft.addChild(this.legLowerFrontLeft);

		this.legLowerFrontRight = new ModelPart(this, 52, 33);
		this.legLowerFrontRight.addBox(-2.0F, 0.0F, 0.0F, 3.0F, 6.0F, 3.0F);
		this.legLowerFrontRight.setPos(0.0F, 6.0F, 0.0F);
		this.legUpperFrontRight.addChild(this.legLowerFrontRight);

		this.tail = new ModelPart(this, 8, 7);
		this.tail.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 4.0F, 2.0F);
		this.tail.setPos(0.0F, -3.0F, 8.0F);
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
		
		this.antlerLeft1.zRot = (float) Math.PI/3;
		this.antlerRight1.zRot = -(float) Math.PI/3;
		this.antlerLeft2.xRot = (float) Math.PI/3;
		this.antlerRight2.xRot = (float) Math.PI/3;
		this.antlerLeft3.zRot = -(float) Math.PI/3;
		this.antlerRight3.zRot = (float) Math.PI/3;
		this.antlerLeft4.zRot = -(float) Math.PI/3;
		this.antlerRight4.zRot = (float) Math.PI/3;
		this.antlerLeft5.zRot = -(float) Math.PI/2;
		this.antlerRight5.zRot = (float) Math.PI/2;
		this.antlerLeft6.zRot = -(float) Math.PI/2;
		this.antlerRight6.zRot = (float) Math.PI/2;
		this.antlerLeft6.xRot = -(float) Math.PI/6;
		this.antlerRight6.xRot = -(float) Math.PI/6;
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
	    //float f7 = 1.0F - f6;
	    float f9 = (float)entityIn.tickCount + partialTick;
		float f10 = entityIn.isInWater() ? 0.2F : 1.0F;
		
		boolean tailWagging = entityIn.tailCounter != 0;
		//boolean earsFlapping = ((GiraffeEntity) entityIn).earCounter != 0;

		this.body.xRot = 0.0F;
		this.neck.xRot = (float) Math.PI / 4 + Mth.sin(f10 * limbSwing * 0.5F) / 10;
		this.head.xRot = -(float) Math.PI / 4 + Mth.cos(f10 * limbSwing * 0.5F) / 10;
		this.neck.yRot = f3 * (float) Math.PI / 180;
		
		
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
			this.earLeft.rotateAngleY = MathHelper.cos((float) entityIn.ticksExisted + partialTick);
			this.earRight.rotateAngleY = -MathHelper.cos((float) entityIn.ticksExisted + partialTick);
		} else {
			this.earLeft.rotateAngleY = 0.0F;
			this.earRight.rotateAngleY = 0.0F;
		}
		
	}
*/
}