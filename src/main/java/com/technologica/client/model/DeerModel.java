package com.technologica.client.model;

import com.google.common.collect.ImmutableList;
import com.technologica.world.entity.animal.Deer;

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

public class DeerModel<T extends AbstractHorse> extends AgeableListModel<T> {
	private final ModelPart head;
	private final ModelPart earLeft;
	private final ModelPart earRight;
	private final ModelPart antlerLeft1;
	private final ModelPart antlerLeft2;
	private final ModelPart antlerLeft3;
	private final ModelPart antlerLeft4;
	private final ModelPart antlerLeft5;
	private final ModelPart antlerLeft6;
	private final ModelPart antlerRight1;
	private final ModelPart antlerRight2;
	private final ModelPart antlerRight3;
	private final ModelPart antlerRight4;
	private final ModelPart antlerRight5;
	private final ModelPart antlerRight6;
	private final ModelPart body;
	private final ModelPart legUpperBackLeft;
	private final ModelPart legUpperBackRight;
	private final ModelPart legUpperFrontLeft;
	private final ModelPart legUpperFrontRight;
	private final ModelPart legLowerBackLeft;
	private final ModelPart legLowerBackRight;
	private final ModelPart legLowerFrontLeft;
	private final ModelPart legLowerFrontRight;
	private final ModelPart neck;
	protected final ModelPart tail;

	public DeerModel(ModelPart modelPartIn) {
		super(true, 24.0F, 1.36F, 2.7272F, 2.0F, 24.0F);
		this.neck = modelPartIn.getChild("neck");
		this.head = this.neck.getChild("head");
		this.body = modelPartIn.getChild("body");
		this.legUpperBackLeft = modelPartIn.getChild("legUpperBackLeft");
		this.legUpperBackRight = modelPartIn.getChild("legUpperBackRight");
		this.legUpperFrontLeft = modelPartIn.getChild("legUpperFrontLeft");
		this.legUpperFrontRight = modelPartIn.getChild("legUpperFrontRight");
		this.legLowerBackLeft = legUpperBackLeft.getChild("legLowerBackLeft");
		this.legLowerBackRight = legUpperBackRight.getChild("legLowerBackRight");
		this.legLowerFrontLeft = legUpperFrontLeft.getChild("legLowerFrontLeft");
		this.legLowerFrontRight = legUpperFrontRight.getChild("legLowerFrontRight");
		this.earRight = this.head.getChild("ear_right");
		this.earLeft = this.head.getChild("ear_left");
		this.antlerLeft1 = this.head.getChild("antlerLeft1");
		this.antlerRight1 = this.head.getChild("antlerRight1");
		this.antlerLeft2 = this.antlerLeft1.getChild("antlerLeft2");
		this.antlerRight2 = this.antlerRight1.getChild("antlerRight2");
		this.antlerLeft3 = this.antlerLeft2.getChild("antlerLeft3");
		this.antlerRight3 = this.antlerRight2.getChild("antlerRight3");
		this.antlerLeft4 = this.antlerLeft1.getChild("antlerLeft4");
		this.antlerRight4 = this.antlerRight1.getChild("antlerRight4");
		this.antlerLeft5 = this.antlerLeft2.getChild("antlerLeft5");
		this.antlerRight5 = this.antlerRight2.getChild("antlerRight5");
		this.antlerLeft6 = this.antlerLeft2.getChild("antlerLeft6");
		this.antlerRight6 = this.antlerRight2.getChild("antlerRight6");
		this.tail = modelPartIn.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition body = meshdefinition.getRoot();
		PartDefinition partdefinition1 = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(32, 0).addBox(-2.0F, -4.0F, -3.0F, 4.0F, 8.0F, 6.0F), PartPose.offset(0.0F, 4.0F, -8.0F));
		PartDefinition head = partdefinition1.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 24).addBox(-2.5F, 0.0F, -5.0F, 5.0F, 5.0F, 5.0F), PartPose.offset(0.0F, -4.0F, 3.0F));
		head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 2.0F, -9.0F, 3.0F, 3.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("ear_right", CubeListBuilder.create().texOffs(0, 7).addBox(-3.0F, -2.0F, -1.0F, 3.0F, 2.0F, 1.0F), PartPose.offset(-2.5F, 2.0F, 0.0F));
		head.addOrReplaceChild("ear_left", CubeListBuilder.create().texOffs(0, 7).addBox(0.0F, -2.0F, -1.0F, 3.0F, 2.0F, 1.0F), PartPose.offset(2.5F, 2.0F, 0.0F));
		PartDefinition antlerLeft1 = head.addOrReplaceChild("antlerLeft1", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, -5.0F, -1.0F, 1.0F, 5.0F, 1.0F), PartPose.offset(0.5F, 0.0F, -2.0F));
		PartDefinition antlerRight1 = head.addOrReplaceChild("antlerRight1", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, -5.0F, -1.0F, 1.0F, 5.0F, 1.0F), PartPose.offset(-0.5F, 0.0F, -2.0F));
		PartDefinition antlerLeft2 = antlerLeft1.addOrReplaceChild("antlerLeft2", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, -5.0F, -1.0F, 1.0F, 5.0F, 1.0F), PartPose.offset(0.0F, -5.0F, 0.0F));
		PartDefinition antlerRight2 = antlerRight1.addOrReplaceChild("antlerRight2", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, -5.0F, -1.0F, 1.0F, 5.0F, 1.0F), PartPose.offset(0.0F, -5.0F, 0.0F));
		antlerLeft2.addOrReplaceChild("antlerLeft3", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F), PartPose.offset(1.0F, -5.0F, -1.0F));
		antlerRight2.addOrReplaceChild("antlerRight3", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F), PartPose.offset(-1.0F, -5.0F, -1.0F));
		antlerLeft1.addOrReplaceChild("antlerLeft4", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F), PartPose.offset(1.0F, -2.0F, -1.0F));
		antlerRight1.addOrReplaceChild("antlerRight4", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F), PartPose.offset(-1.0F, -2.0F, -1.0F));
		antlerLeft2.addOrReplaceChild("antlerLeft5", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -1.0F, -1.0F));
		antlerRight2.addOrReplaceChild("antlerRight5", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -1.0F, -1.0F));
		antlerLeft2.addOrReplaceChild("antlerLeft6", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -3.0F, -1.0F));
		antlerRight2.addOrReplaceChild("antlerRight6", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -3.0F, -1.0F));
		body.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 16.0F), PartPose.offset(0.0F, 8.0F, 0.0F));
		PartDefinition legUpperBackRight = body.addOrReplaceChild("legUpperBackRight", CubeListBuilder.create().texOffs(52, 0).mirror().addBox(-2.0F, -3.0F, -3.0F, 3.0F, 7.0F, 3.0F), PartPose.offset(-2.0F, 12.0F, 8.0F));
		PartDefinition legUpperBackLeft = body.addOrReplaceChild("legUpperBackLeft", CubeListBuilder.create().texOffs(52, 0).addBox(-2.0F, -3.0F, -3.0F, 3.0F, 7.0F, 3.0F), PartPose.offset(3.0F, 12.0F, 8.0F));
		PartDefinition legUpperFrontRight = body.addOrReplaceChild("legUpperFrontRight", CubeListBuilder.create().texOffs(52, 10).mirror().addBox(-2.0F, -3.0F, 0.0F, 3.0F, 9.0F, 3.0F), PartPose.offset(-2.0F, 12.0F, -8.0F));
		PartDefinition legUpperFrontLeft = body.addOrReplaceChild("legUpperFrontLeft", CubeListBuilder.create().texOffs(52, 10).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 9.0F, 3.0F), PartPose.offset(3.0F, 12.0F, -8.0F));
		legUpperBackRight.addOrReplaceChild("legLowerBackRight", CubeListBuilder.create().texOffs(52, 22).mirror().addBox(-2.0F, 0.0F, -3.0F, 3.0F, 8.0F, 3.0F), PartPose.offset(0.0F, 4.0F, 0.0F));
		legUpperBackLeft.addOrReplaceChild("legLowerBackLeft", CubeListBuilder.create().texOffs(52, 22).addBox(-2.0F, 0.0F, -3.0F, 3.0F, 8.0F, 3.0F), PartPose.offset(0.0F, 4.0F, 0.0F));
		legUpperFrontRight.addOrReplaceChild("legLowerFrontRight", CubeListBuilder.create().texOffs(52, 33).mirror().addBox(-2.0F, 0.0F, 0.0F, 3.0F, 6.0F, 3.0F), PartPose.offset(0.0F, 6.0F, 0.0F));
		legUpperFrontLeft.addOrReplaceChild("legLowerFrontLeft", CubeListBuilder.create().texOffs(52, 33).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 6.0F, 3.0F), PartPose.offset(0.0F, 6.0F, 0.0F));
		body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(8, 7).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 4.0F, 2.0F), PartPose.offset(0.0F, 5.0F, 8.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.earLeft.zRot = -0.5F;
		this.earRight.zRot = 0.5F; //
		this.tail.xRot = ((float) Math.PI / 8F);
		this.antlerLeft1.zRot = (float) Math.PI / 3;
		this.antlerRight1.zRot = -(float) Math.PI / 3;
		this.antlerLeft2.xRot = (float) Math.PI / 3;
		this.antlerRight2.xRot = (float) Math.PI / 3;
		this.antlerLeft3.zRot = -(float) Math.PI / 3;
		this.antlerRight3.zRot = (float) Math.PI / 3;
		this.antlerLeft4.zRot = -(float) Math.PI / 3;
		this.antlerRight4.zRot = (float) Math.PI / 3;
		this.antlerLeft5.zRot = -(float) Math.PI / 2;
		this.antlerRight5.zRot = (float) Math.PI / 2;
		this.antlerLeft6.zRot = -(float) Math.PI / 2;
		this.antlerRight6.zRot = (float) Math.PI / 2;
		this.antlerLeft6.xRot = -(float) Math.PI / 6;
		this.antlerRight6.xRot = -(float) Math.PI / 6;
	}

	@Override
	public Iterable<ModelPart> headParts() {
		return ImmutableList.of(this.neck);
	}

	@Override
	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(this.body, this.legUpperBackLeft, this.legUpperBackRight, this.legUpperFrontLeft, this.legUpperFrontRight, this.tail);
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
		float f9 = entityIn.tickCount + partialTick;
		float f10 = entityIn.isInWater() ? 0.2F : 1.0F;

		boolean tailWagging = entityIn.tailCounter != 0;
		boolean earsFlapping = ((Deer) entityIn).earCounter != 0;
		this.neck.xRot = (float) Math.PI / 4 + Mth.sin(f10 * limbSwing * 0.5F) / 10;
		this.neck.yRot = f3 * (float) Math.PI / 180;
		this.head.xRot = -(float) Math.PI / 4 + Mth.cos(f10 * limbSwing * 0.5F) / 10;

		this.body.xRot = 0.0F;
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