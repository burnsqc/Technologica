package com.technologica.client.model;

import com.google.common.collect.ImmutableList;
import com.technologica.world.entity.animal.Moose;

import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.horse.AbstractHorse;

public class MooseModel<T extends AbstractHorse> extends AgeableListModel<T> {
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
	private final ModelPart antlerLeft3a;
	private final ModelPart antlerRight3a;
	private final ModelPart antlerLeft4;
	private final ModelPart antlerRight4;
	private final ModelPart antlerLeft5;
	private final ModelPart antlerRight5;
	private final ModelPart antlerLeft6;
	private final ModelPart antlerRight6;
	private final ModelPart antlerLeft7;
	private final ModelPart antlerRight7;
	private final ModelPart antlerLeft8;
	private final ModelPart antlerRight8;
	private final ModelPart antlerLeft9;
	private final ModelPart antlerRight9;
	private final ModelPart antlerLeft10;
	private final ModelPart antlerRight10;
	private final ModelPart antlerLeft11;
	private final ModelPart antlerRight11;
	private final ModelPart antlerLeft12;
	private final ModelPart antlerRight12;
	private final ModelPart legUpperBackLeft;
	private final ModelPart legUpperBackRight;
	private final ModelPart legUpperFrontLeft;
	private final ModelPart legUpperFrontRight;
	private final ModelPart legLowerBackLeft;
	private final ModelPart legLowerBackRight;
	private final ModelPart legLowerFrontLeft;
	private final ModelPart legLowerFrontRight;
	protected final ModelPart tail;
	// private final ModelPart saddle;
	// private final ModelPart leftBit;
	// private final ModelPart rightBit;
	// private final ModelPart headBridle;
	// private final ModelPart noseBridle;
	// private final ModelPart leftReign;
	// private final ModelPart rightReign;
	// private final ModelPart[] saddles;
	// private final ModelPart[] reigns;

	public MooseModel(ModelPart modelPartIn) {
		super(true, 24.0F, 1.36F, 2.7272F, 2.0F, 24.0F);
		this.body = modelPartIn.getChild("body");
		this.neck = modelPartIn.getChild("neck");
		this.head = this.neck.getChild("head");
		this.nose = head.getChild("nose");
		this.earLeft = this.head.getChild("ear_left");
		this.earRight = this.head.getChild("ear_right");
		this.antlerLeft1 = head.getChild("antler_left_1");
		this.antlerRight1 = head.getChild("antler_right_1");
		this.antlerLeft2 = antlerLeft1.getChild("antler_left_2");
		this.antlerRight2 = antlerRight1.getChild("antler_right_2");
		this.antlerLeft3 = antlerLeft2.getChild("antler_left_3");
		this.antlerRight3 = antlerRight2.getChild("antler_right_3");
		this.antlerLeft3a = antlerLeft2.getChild("antler_left_3a");
		this.antlerRight3a = antlerRight2.getChild("antler_right_3a");
		this.antlerLeft4 = antlerLeft2.getChild("antler_left_4");
		this.antlerRight4 = antlerRight2.getChild("antler_right_4");
		this.antlerLeft5 = antlerLeft2.getChild("antler_left_5");
		this.antlerRight5 = antlerRight2.getChild("antler_right_5");
		this.antlerLeft6 = antlerLeft2.getChild("antler_left_6");
		this.antlerRight6 = antlerRight2.getChild("antler_right_6");
		this.antlerLeft7 = antlerLeft2.getChild("antler_left_7");
		this.antlerRight7 = antlerRight2.getChild("antler_right_7");
		this.antlerLeft8 = antlerLeft2.getChild("antler_left_8");
		this.antlerRight8 = antlerRight2.getChild("antler_right_8");
		this.antlerLeft9 = antlerLeft2.getChild("antler_left_9");
		this.antlerRight9 = antlerRight2.getChild("antler_right_9");
		this.antlerLeft10 = antlerLeft2.getChild("antler_left_10");
		this.antlerRight10 = antlerRight2.getChild("antler_right_10");
		this.antlerLeft11 = antlerLeft2.getChild("antler_left_11");
		this.antlerRight11 = antlerRight2.getChild("antler_right_11");
		this.antlerLeft12 = antlerLeft2.getChild("antler_left_12");
		this.antlerRight12 = antlerRight2.getChild("antler_right_12");
		this.legUpperBackLeft = body.getChild("legUpperBackLeft");
		this.legUpperBackRight = body.getChild("legUpperBackRight");
		this.legUpperFrontLeft = body.getChild("legUpperFrontLeft");
		this.legUpperFrontRight = body.getChild("legUpperFrontRight");
		this.legLowerBackLeft = legUpperBackLeft.getChild("legLowerBackLeft");
		this.legLowerBackRight = legUpperBackRight.getChild("legLowerBackRight");
		this.legLowerFrontLeft = legUpperFrontLeft.getChild("legLowerFrontLeft");
		this.legLowerFrontRight = legUpperFrontRight.getChild("legLowerFrontRight");
		this.tail = body.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition root = meshdefinition.getRoot();
		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -8.0F, -16.0F, 12.0F, 16.0F, 32.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition neck = root.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(56, 0).addBox(-3.0F, -6.0F, -4.0F, 6.0F, 14.0F, 8.0F), PartPose.offset(0.0F, -7.0F, -16.0F));
		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -8.0F, 8.0F, 8.0F, 8.0F), PartPose.offset(0.0F, -6.0F, 4.0F));
		head.addOrReplaceChild("beard", CubeListBuilder.create().texOffs(56, 22).addBox(-2.0F, 8.0F, -6.0F, 4.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(0, 16).addBox(-3.0F, 0.0F, -8.0F, 6.0F, 6.0F, 10.0F), PartPose.offset(0.0F, 2.0F, -8.0F));
		head.addOrReplaceChild("ear_left", CubeListBuilder.create().texOffs(0, 16).addBox(0.0F, -3.0F, -1.0F, 4.0F, 3.0F, 1.0F), PartPose.offset(4.0F, 3.0F, -1.0F));
		head.addOrReplaceChild("ear_right", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -3.0F, -1.0F, 4.0F, 3.0F, 1.0F), PartPose.offset(-4.0F, 3.0F, -1.0F));
		PartDefinition antlerLeft1 = head.addOrReplaceChild("antler_left_1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -3.0F, -1.0F, 1.0F, 2.0F, 1.0F), PartPose.offset(3.0F, 0.0F, -4.0F));
		PartDefinition antlerRight1 = head.addOrReplaceChild("antler_right_1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 2.0F, 1.0F), PartPose.offset(-3.0F, 0.0F, -4.0F));
		PartDefinition antlerLeft2 = antlerLeft1.addOrReplaceChild("antler_left_2", CubeListBuilder.create().texOffs(84, 0).addBox(-1.0F, -12.0F, -6.0F, 1.0F, 12.0F, 6.0F), PartPose.offset(1.0F, -3.0F, -1.0F));
		PartDefinition antlerRight2 = antlerRight1.addOrReplaceChild("antler_right_2", CubeListBuilder.create().texOffs(84, 0).addBox(0.0F, -12.0F, -6.0F, 1.0F, 12.0F, 6.0F), PartPose.offset(-1.0F, -3.0F, -1.0F));
		antlerLeft2.addOrReplaceChild("antler_left_3", CubeListBuilder.create().texOffs(2, 4).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F), PartPose.offset(0.0F, 0.0F, -1.0F));
		antlerRight2.addOrReplaceChild("antler_right_3", CubeListBuilder.create().texOffs(2, 4).addBox(0.0F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F), PartPose.offset(0.0F, 0.0F, -1.0F));
		antlerLeft2.addOrReplaceChild("antler_left_3a", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F), PartPose.offset(0.0F, 0.0F, -4.0F));
		antlerRight2.addOrReplaceChild("antler_right_3a", CubeListBuilder.create().texOffs(24, 0).addBox(0.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F), PartPose.offset(0.0F, 0.0F, -4.0F));
		antlerLeft2.addOrReplaceChild("antler_left_4", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 1.0F, 3.0F), PartPose.offset(0.0F, 0.0F, -6.0F));
		antlerRight2.addOrReplaceChild("antler_right_4", CubeListBuilder.create().texOffs(24, 0).addBox(0.0F, -2.0F, -3.0F, 1.0F, 1.0F, 3.0F), PartPose.offset(0.0F, 0.0F, -6.0F));
		antlerLeft2.addOrReplaceChild("antler_left_5", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 1.0F, 3.0F), PartPose.offset(0.0F, -2.0F, -6.0F));
		antlerRight2.addOrReplaceChild("antler_right_5", CubeListBuilder.create().texOffs(24, 0).addBox(0.0F, -2.0F, -3.0F, 1.0F, 1.0F, 3.0F), PartPose.offset(0.0F, -2.0F, -6.0F));
		antlerLeft2.addOrReplaceChild("antler_left_6", CubeListBuilder.create().texOffs(2, 4).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 1.0F, 2.0F), PartPose.offset(0.0F, -4.0F, -6.0F));
		antlerRight2.addOrReplaceChild("antler_right_6", CubeListBuilder.create().texOffs(2, 4).addBox(0.0F, -2.0F, -2.0F, 1.0F, 1.0F, 2.0F), PartPose.offset(0.0F, -4.0F, -6.0F));
		antlerLeft2.addOrReplaceChild("antler_left_7", CubeListBuilder.create().texOffs(2, 4).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 1.0F, 2.0F), PartPose.offset(0.0F, -6.0F, -6.0F));
		antlerRight2.addOrReplaceChild("antler_right_7", CubeListBuilder.create().texOffs(2, 4).addBox(0.0F, -2.0F, -2.0F, 1.0F, 1.0F, 2.0F), PartPose.offset(0.0F, -6.0F, -6.0F));
		antlerLeft2.addOrReplaceChild("antler_left_8", CubeListBuilder.create().texOffs(2, 4).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 1.0F, 2.0F), PartPose.offset(0.0F, -8.0F, -6.0F));
		antlerRight2.addOrReplaceChild("antler_right_8", CubeListBuilder.create().texOffs(2, 4).addBox(0.0F, -2.0F, -2.0F, 1.0F, 1.0F, 2.0F), PartPose.offset(0.0F, -8.0F, -6.0F));
		antlerLeft2.addOrReplaceChild("antler_left_9", CubeListBuilder.create().texOffs(4, 0).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F), PartPose.offset(0.0F, -10.0F, -6.0F));
		antlerRight2.addOrReplaceChild("antler_right_9", CubeListBuilder.create().texOffs(4, 0).addBox(0.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F), PartPose.offset(0.0F, -10.0F, -6.0F));
		antlerLeft2.addOrReplaceChild("antler_left_10", CubeListBuilder.create().texOffs(4, 0).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 1.0F), PartPose.offset(0.0F, -12.0F, -3.0F));
		antlerRight2.addOrReplaceChild("antler_right_10", CubeListBuilder.create().texOffs(4, 0).addBox(0.0F, -1.0F, -2.0F, 1.0F, 1.0F, 1.0F), PartPose.offset(0.0F, -12.0F, -3.0F));
		antlerLeft2.addOrReplaceChild("antler_left_11", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 1.0F), PartPose.offset(0.0F, -12.0F, -1.0F));
		antlerRight2.addOrReplaceChild("antler_right_11", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 1.0F), PartPose.offset(0.0F, -12.0F, -1.0F));
		antlerLeft2.addOrReplaceChild("antler_left_12", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 1.0F), PartPose.offset(0.0F, -12.0F, 1.0F));
		antlerRight2.addOrReplaceChild("antler_right_12", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 1.0F), PartPose.offset(0.0F, -12.0F, 1.0F));
		PartDefinition legUpperBackRight = body.addOrReplaceChild("legUpperBackRight", CubeListBuilder.create().texOffs(0, 48).addBox(-1.99F, -4.0F, -3.99F, 3.98F, 8.0F, 3.98F), PartPose.offset(4.0F, 8.0F, 16.0F));
		PartDefinition legUpperBackLeft = body.addOrReplaceChild("legUpperBackLeft", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(-1.99F, -4.0F, -3.99F, 3.98F, 8.0F, 3.98F), PartPose.offset(-4.0F, 8.0F, 16.0F));
		PartDefinition legUpperFrontRight = body.addOrReplaceChild("legUpperFrontRight", CubeListBuilder.create().texOffs(16, 48).addBox(-1.99F, -4.0F, 0.01F, 3.98F, 12.0F, 3.98F), PartPose.offset(4.0F, 8.0F, -16.0F));
		PartDefinition legUpperFrontLeft = body.addOrReplaceChild("legUpperFrontLeft", CubeListBuilder.create().texOffs(16, 48).mirror().addBox(-1.99F, -4.0F, 0.01F, 3.98F, 12.0F, 3.98F), PartPose.offset(-4.0F, 8.0F, -16.0F));
		legUpperBackRight.addOrReplaceChild("legLowerBackRight", CubeListBuilder.create().texOffs(32, 48).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(0.0F, 4.0F, 0.0F));
		legUpperBackLeft.addOrReplaceChild("legLowerBackLeft", CubeListBuilder.create().texOffs(32, 48).mirror().addBox(-2.0F, 0.0F, -4.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(0.0F, 4.0F, 0.0F));
		legUpperFrontRight.addOrReplaceChild("legLowerFrontRight", CubeListBuilder.create().texOffs(48, 48).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 4.0F), PartPose.offset(0.0F, 8.0F, 0.0F));
		legUpperFrontLeft.addOrReplaceChild("legLowerFrontLeft", CubeListBuilder.create().texOffs(48, 48).mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 4.0F), PartPose.offset(0.0F, 8.0F, 0.0F));
		body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(22, 16).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 4.0F, 2.0F), PartPose.offset(0.0F, -5.0F, 16.0F));
		/*
		 * this.saddle = new ModelPart(this, 72, 0); this.saddle.addBox(-5.0F, -31.0F, -9.0F, 10.0F, 9.0F, 9.0F, 0.5F); this.body.addChild(saddle);
		 * 
		 * this.headBridle = new ModelPart(this, 72, 18); this.headBridle.addBox(-3.0F, -5.0F, -8.9F, 6.0F, 5.0F, 8.0F, 0.2F); this.head.addChild(this.headBridle);
		 * 
		 * this.noseBridle = new ModelPart(this, 69, 0); this.noseBridle.addBox(-1.5F, -4.0F, -11.0F, 3.0F, 4.0F, 2.0F, 0.2F); this.head.addChild(this.noseBridle);
		 * 
		 * this.leftBit = new ModelPart(this, 101, 0); this.leftBit.addBox(1.5F, -3.0F, -13.0F, 1.0F, 2.0F, 2.0F); this.head.addChild(this.leftBit);
		 * 
		 * this.rightBit = new ModelPart(this, 101, 0); this.rightBit.addBox(-2.5F, -3.0F, -13.0F, 1.0F, 2.0F, 2.0F); this.head.addChild(this.rightBit);
		 * 
		 * this.leftReign = new ModelPart(this, 42, 19); this.leftReign.addBox(3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F); this.leftReign.xRot = (-(float) Math.PI / 6F); this.neck.addChild(this.leftReign);
		 * 
		 * this.rightReign = new ModelPart(this, 42, 19); this.rightReign.addBox(-3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F); this.rightReign.xRot = (-(float) Math.PI / 6F); this.neck.addChild(this.rightReign);
		 * 
		 * this.saddles = new ModelPart[] { this.saddle, this.headBridle, this.noseBridle, this.leftBit, this.rightBit }; this.reigns = new ModelPart[] { leftReign, rightReign };
		 */
		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.nose.xRot = (float) Math.PI / 10;
		this.earLeft.zRot = 0F;
		this.earRight.zRot = 0F;
		// for (ModelPart modelrenderer : this.saddles) {
		// modelrenderer.visible = flag;
		// }
		// for (ModelPart modelrenderer1 : this.reigns) {
		// modelrenderer1.visible = flag1 && flag;
		// }
		this.antlerLeft1.zRot = (float) Math.PI / 2;
		this.antlerRight1.zRot = -(float) Math.PI / 2;
		this.antlerLeft1.yRot = -(float) Math.PI / 8;
		this.antlerRight1.yRot = (float) Math.PI / 8;
		this.antlerLeft2.xRot = -1.25F;
		this.antlerRight2.xRot = -1.25F;
		this.antlerLeft2.zRot = -0.5F;
		this.antlerRight2.zRot = 0.5F;
		this.antlerLeft3.xRot = 1.0F;
		this.antlerRight3.xRot = 1.0F;
		this.antlerLeft3a.xRot = 1.0F;
		this.antlerRight3a.xRot = 1.0F;
		this.antlerLeft4.yRot = (float) (Math.PI / 6);
		this.antlerRight4.yRot = -(float) (Math.PI / 6);
		this.antlerLeft5.yRot = (float) (Math.PI / 6);
		this.antlerRight5.yRot = -(float) (Math.PI / 6);
		this.antlerLeft6.yRot = (float) (Math.PI / 6);
		this.antlerRight6.yRot = -(float) (Math.PI / 6);
		this.antlerLeft7.yRot = (float) (Math.PI / 6);
		this.antlerRight7.yRot = -(float) (Math.PI / 6);
		this.antlerLeft8.yRot = (float) (Math.PI / 6);
		this.antlerRight8.yRot = -(float) (Math.PI / 6);
		this.antlerLeft9.yRot = (float) (Math.PI / 6);
		this.antlerRight9.yRot = -(float) (Math.PI / 6);
		this.antlerLeft10.zRot = -(float) (Math.PI / 6);
		this.antlerRight10.zRot = (float) (Math.PI / 6);
		this.antlerLeft11.zRot = -(float) (Math.PI / 6);
		this.antlerRight11.zRot = (float) (Math.PI / 6);
		this.antlerLeft12.zRot = -(float) (Math.PI / 6);
		this.antlerRight12.zRot = (float) (Math.PI / 6);
		this.tail.xRot = ((float) Math.PI / 8F);
	}

	@Override
	public Iterable<ModelPart> headParts() {
		return ImmutableList.of(this.neck);
	}

	@Override
	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(this.body);
	}

	@Override
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
		// float f7 = 1.0F - f6;
		float f9 = entityIn.tickCount + partialTick;
		float f10 = entityIn.isInWater() ? 0.2F : 1.0F;

		boolean earsFlapping = ((Moose) entityIn).earCounter != 0;

		this.body.xRot = 0.0F;
		this.neck.xRot = (float) Math.PI / 3 + Mth.sin(f10 * limbSwing * 0.5F) / 10;
		this.head.xRot = -(float) Math.PI / 3 + Mth.cos(f10 * limbSwing * 0.5F) / 10;
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
		if (earsFlapping) {
			this.earLeft.yRot = Mth.cos(entityIn.tickCount + partialTick);
			this.earRight.yRot = -Mth.cos(entityIn.tickCount + partialTick);
		} else {
			this.earLeft.yRot = 0.0F;
			this.earRight.yRot = 0.0F;
		}
	}
}