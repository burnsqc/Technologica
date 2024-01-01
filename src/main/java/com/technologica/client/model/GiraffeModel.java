package com.technologica.client.model;

import com.google.common.collect.ImmutableList;
import com.technologica.world.entity.animal.Giraffe;

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

public class GiraffeModel<T extends AbstractHorse> extends AgeableListModel<T> {
	private final ModelPart body;
	private final ModelPart neck;
	private final ModelPart head;
	private final ModelPart earLeft;
	private final ModelPart earRight;
	private final ModelPart legUpperBackLeft;
	private final ModelPart legUpperBackRight;
	private final ModelPart legUpperFrontLeft;
	private final ModelPart legUpperFrontRight;
	private final ModelPart legLowerBackLeft;
	private final ModelPart legLowerBackRight;
	private final ModelPart legLowerFrontLeft;
	private final ModelPart legLowerFrontRight;
	private final ModelPart tail;
	// private final ModelPart saddle;
	// private final ModelPart leftBit;
	// private final ModelPart rightBit;
	// private final ModelPart headBridle;
	// private final ModelPart noseBridle;
	// private final ModelPart leftReign;
	// private final ModelPart rightReign;
	// private final ModelPart[] saddles;
	// private final ModelPart[] reigns;

	public GiraffeModel(ModelPart modelPartIn) {
		super(true, 24.0F, 1.36F, 2.7272F, 2.0F, 24.0F);
		this.body = modelPartIn.getChild("body");
		this.neck = modelPartIn.getChild("neck");
		this.head = this.neck.getChild("head");
		this.earLeft = this.head.getChild("ear_left");
		this.earRight = this.head.getChild("ear_right");
		this.legUpperBackLeft = body.getChild("legUpperBackLeft");
		this.legUpperBackRight = body.getChild("legUpperBackRight");
		this.legUpperFrontLeft = body.getChild("legUpperFrontLeft");
		this.legUpperFrontRight = body.getChild("legUpperFrontRight");
		this.legLowerBackLeft = legUpperBackLeft.getChild("legLowerBackLeft");
		this.legLowerBackRight = legUpperBackRight.getChild("legLowerBackRight");
		this.legLowerFrontLeft = legUpperFrontLeft.getChild("legLowerFrontLeft");
		this.legLowerFrontRight = legUpperFrontRight.getChild("legLowerFrontRight");
		this.tail = body.getChild("tail");
		/*
		 * 
		 * 
		 * 
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
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition root = meshdefinition.getRoot();
		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -31.0F, -17.0F, 10.0F, 12.0F, 22.0F), PartPose.offset(0.0F, 28.0F, 3.0F));
		PartDefinition neck = root.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 34).addBox(-2.0F, -38.0F, -6.0F, 4.0F, 37.0F, 6.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		neck.addOrReplaceChild("mane", CubeListBuilder.create().texOffs(20, 34).addBox(-1.0F, -40.0F, 0.0F, 2.0F, 37.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(42, 0).addBox(-3.0F, -5.0F, -9.0F, 6.0F, 5.0F, 9.0F), PartPose.offset(0.0F, -35.0F, 0.0F));
		head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -4.0F, -15.0F, 3.0F, 4.0F, 6.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("ear_left", CubeListBuilder.create().texOffs(12, 10).addBox(0.0F, -3.0F, -1.0F, 4.0F, 3.0F, 1.0F), PartPose.offset(3.0F, -1.0F, -2.0F));
		head.addOrReplaceChild("ear_right", CubeListBuilder.create().texOffs(12, 0).addBox(-4.0F, -3.0F, -1.0F, 4.0F, 3.0F, 1.0F), PartPose.offset(-3.0F, -1.0F, -2.0F));
		head.addOrReplaceChild("horn_left", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, -7.0F, -3.0F, 1.0F, 2.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("horn_right", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -7.0F, -3.0F, 1.0F, 2.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition legUpperBackRight = body.addOrReplaceChild("legUpperBackRight", CubeListBuilder.create().texOffs(28, 34).mirror().addBox(-1.99F, -4.0F, -3.99F, 3.98F, 12.0F, 3.98F), PartPose.offset(-3.0F, -19.0F, 5.0F));
		PartDefinition legUpperBackLeft = body.addOrReplaceChild("legUpperBackLeft", CubeListBuilder.create().texOffs(28, 34).addBox(-1.99F, -4.0F, -3.99F, 3.98F, 12.0F, 3.98F), PartPose.offset(3.0F, -19.0F, 5.0F));
		PartDefinition legUpperFrontRight = body.addOrReplaceChild("legUpperFrontRight", CubeListBuilder.create().texOffs(44, 56).mirror().addBox(-1.99F, -4.0F, 0.01F, 3.98F, 18.0F, 3.98F), PartPose.offset(-3.0F, -19.0F, -17.0F));
		PartDefinition legUpperFrontLeft = body.addOrReplaceChild("legUpperFrontLeft", CubeListBuilder.create().texOffs(44, 56).addBox(-1.99F, -4.0F, 0.01F, 3.98F, 18.0F, 3.98F), PartPose.offset(3.0F, -19.0F, -17.0F));
		legUpperBackRight.addOrReplaceChild("legLowerBackRight", CubeListBuilder.create().texOffs(60, 34).mirror().addBox(-2.0F, 0.0F, -4.0F, 4.0F, 24.0F, 4.0F), PartPose.offset(0.0F, 8.0F, 0.0F));
		legUpperBackLeft.addOrReplaceChild("legLowerBackLeft", CubeListBuilder.create().texOffs(60, 34).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 24.0F, 4.0F), PartPose.offset(0.0F, 8.0F, 0.0F));
		legUpperFrontRight.addOrReplaceChild("legLowerFrontRight", CubeListBuilder.create().texOffs(44, 34).mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 18.0F, 4.0F), PartPose.offset(0.0F, 14.0F, 0.0F));
		legUpperFrontLeft.addOrReplaceChild("legLowerFrontLeft", CubeListBuilder.create().texOffs(44, 34).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 18.0F, 4.0F), PartPose.offset(0.0F, 14.0F, 0.0F));
		body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(28, 50).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 16.0F, 2.0F), PartPose.offset(0.0F, -30.0F, 5.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	protected Iterable<ModelPart> headParts() {
		return ImmutableList.of(this.neck);
	}

	@Override
	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(this.body);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.earLeft.zRot = -0.5F;
		this.earRight.zRot = 0.5F;
		this.tail.xRot = ((float) Math.PI / 8F);

		// for (ModelPart modelrenderer : this.saddles) {
		// modelrenderer.visible = flag;
		// }

		// for (ModelPart modelrenderer1 : this.reigns) {
		// modelrenderer1.visible = flag1 && flag;
		// }

		this.body.y = 11.0F;
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
		float f7 = 1.0F - f6;
		float f9 = entityIn.tickCount + partialTick;
		float f10 = entityIn.isInWater() ? 0.2F : 1.0F;

		boolean tailWagging = entityIn.tailCounter != 0;
		boolean earsFlapping = ((Giraffe) entityIn).earCounter != 0;

		this.neck.y = -16.0F;
		this.neck.z = -8.0F;

		this.body.xRot = 0.0F;
		this.neck.xRot = ((float) Math.PI / 10F) + Mth.sin(f10 * limbSwing * 0.5F) / 10;
		this.head.xRot = -((float) Math.PI / 10F) + Mth.cos(f10 * limbSwing * 0.5F) / 10;
		this.neck.yRot = f3 * ((float) Math.PI / 180F);

		this.neck.y = f7 * this.neck.y - f6 * 15;
		this.neck.z = f7 * this.neck.z + f6 * 15;

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
			this.earLeft.yRot = Mth.cos(entityIn.tickCount + partialTick);
			this.earRight.yRot = -Mth.cos(entityIn.tickCount + partialTick);
		} else {
			this.earLeft.yRot = 0.0F;
			this.earRight.yRot = 0.0F;
		}
	}
}