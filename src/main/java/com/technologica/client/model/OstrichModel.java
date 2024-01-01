package com.technologica.client.model;

import com.google.common.collect.ImmutableList;
import com.technologica.world.entity.animal.Ostrich;

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

public class OstrichModel<T extends AbstractHorse> extends AgeableListModel<T> {
	protected final ModelPart body;
	private final ModelPart tail;
	protected final ModelPart wingLeft;
	protected final ModelPart wingRight;
	protected final ModelPart neckLower;
	protected final ModelPart neck;
	protected final ModelPart head;
	private final ModelPart legUpperLeft;
	private final ModelPart legUpperRight;
	private final ModelPart legLowerLeft;
	private final ModelPart legLowerRight;
	private final ModelPart talonOuterLeft;
	private final ModelPart talonOuterRight;
	private final ModelPart saddle;

	public OstrichModel(ModelPart modelPartIn) {
		super(true, 24.0F, 1.36F, 2.7272F, 2.0F, 24.0F);
		this.body = modelPartIn.getChild("body");
		this.neckLower = modelPartIn.getChild("neckLower");
		this.neck = neckLower.getChild("neck");
		this.head = neck.getChild("head");
		this.legUpperLeft = body.getChild("legUpperLeft");
		this.legUpperRight = body.getChild("legUpperRight");
		this.legLowerLeft = legUpperLeft.getChild("legLowerLeft");
		this.legLowerRight = legUpperRight.getChild("legLowerRight");
		this.talonOuterLeft = legLowerLeft.getChild("talonOuterLeft");
		this.talonOuterRight = legLowerRight.getChild("talonOuterRight");
		this.wingLeft = body.getChild("wingLeft");
		this.wingRight = body.getChild("wingRight");
		this.tail = body.getChild("tail");
		this.saddle = body.getChild("saddle");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition root = meshdefinition.getRoot();
		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -5.0F, -8.0F, 10.0F, 10.0F, 16.0F), PartPose.offset(0.0F, 3.0F, 0.0F));
		body.addOrReplaceChild("wingLeft", CubeListBuilder.create().texOffs(0, 26).mirror().addBox(0.0F, -5.0F, 0.0F, 1.0F, 10.0F, 12.0F), PartPose.offset(5.01F, 0.0F, -7.0F));
		body.addOrReplaceChild("wingRight", CubeListBuilder.create().texOffs(0, 26).addBox(-1.0F, -5.0F, 0.0F, 1.0F, 10.0F, 12.0F), PartPose.offset(-5.01F, 0.0F, -7.0F));
		PartDefinition legUpperLeft = body.addOrReplaceChild("legUpperLeft", CubeListBuilder.create().mirror().texOffs(0, 26).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F), PartPose.offset(3.0F, 5.0F, 0.0F));
		PartDefinition legUpperRight = body.addOrReplaceChild("legUpperRight", CubeListBuilder.create().texOffs(0, 26).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F), PartPose.offset(-3.0F, 5.0F, 0.0F));
		PartDefinition legLowerLeft = legUpperLeft.addOrReplaceChild("legLowerLeft", CubeListBuilder.create().texOffs(18, 26).mirror().addBox(-1.0F, 0.0F, -2.0F, 2.0F, 10.0F, 2.0F), PartPose.offset(0.0F, 6.0F, 2.0F));
		PartDefinition legLowerRight = legUpperRight.addOrReplaceChild("legLowerRight", CubeListBuilder.create().texOffs(18, 26).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 10.0F, 2.0F), PartPose.offset(0.0F, 6.0F, 2.0F));
		legLowerLeft.addOrReplaceChild("talonInnerLeft", CubeListBuilder.create().texOffs(0, 34).mirror().addBox(-1.0F, 9.0F, -5.0F, 1.0F, 1.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		legLowerRight.addOrReplaceChild("talonInnerRight", CubeListBuilder.create().texOffs(0, 34).addBox(0.0F, 9.0F, -5.0F, 1.0F, 1.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		legLowerLeft.addOrReplaceChild("talonOuterLeft", CubeListBuilder.create().texOffs(6, 34).mirror().addBox(0.0F, 9.0F, -2.0F, 1.0F, 1.0F, 2.0F), PartPose.offset(0.0F, 0.0F, -2.0F));
		legLowerRight.addOrReplaceChild("talonOuterRight", CubeListBuilder.create().texOffs(6, 34).addBox(-1.0F, 9.0F, -2.0F, 1.0F, 1.0F, 2.0F), PartPose.offset(0.0F, 0.0F, -2.0F));
		PartDefinition neckLower = root.addOrReplaceChild("neckLower", CubeListBuilder.create().texOffs(36, 7).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 5.0F), PartPose.offset(0.0F, 2.0F, -8.0F));
		PartDefinition neck = neckLower.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(50, 0).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 10.0F, 2.0F), PartPose.offset(0.0F, 0.0F, -5.0F));
		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -13.0F, -2.0F, 4.0F, 3.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("beak", CubeListBuilder.create().texOffs(0, 7).addBox(-1.0F, -11.0F, -4.0F, 2.0F, 1.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(36, 0).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 3.0F), PartPose.offset(0.0F, -2.0F, 8.01F));
		body.addOrReplaceChild("saddle", CubeListBuilder.create().texOffs(26, 26).mirror().addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 9.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	protected Iterable<ModelPart> headParts() {
		return ImmutableList.of(this.neckLower);
	}

	@Override
	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(this.body);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netneckYaw, float neckPitch) {
		this.talonOuterLeft.yRot = -((float) Math.PI / 6F);
		this.talonOuterRight.yRot = ((float) Math.PI / 6F);
		boolean flag = entityIn.isSaddled();
		saddle.visible = flag;
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
		boolean wingsFlapping = ((Ostrich) entityIn).wingCounter != 0;
		this.neckLower.y = 2.0F;
		this.neckLower.z = -8.0F;
		this.neckLower.y = f7 * this.neckLower.y - f6;
		this.neckLower.z = f7 * this.neckLower.z - 3 * f6;
		this.neckLower.xRot = -((float) Math.PI / 4F) + Mth.sin(f10 * limbSwing) / 5;
		this.neck.xRot = ((float) Math.PI / 4F) - Mth.sin(f10 * limbSwing) / 10;
		this.body.xRot = 0.0F;
		this.neckLower.yRot = f3 * ((float) Math.PI / 180F);
		this.body.xRot = f6 * (-(float) Math.PI / 4F) + this.body.xRot;
		this.legUpperRight.xRot = ((Mth.sin(f10 * limbSwing * 0.25F) * Mth.sin(f10 * limbSwing * 0.25F)) * limbSwingAmount * 1.5F) + f6 / 2 * Mth.sin(f9 * 0.25F) * f6 * Mth.sin(f9 * 0.25F);
		this.legLowerRight.xRot = -(Mth.cos(f10 * limbSwing * 0.25F + (float) Math.PI / 4F) * Mth.cos(f10 * limbSwing * 0.25F + (float) Math.PI / 4F)) * limbSwingAmount * 1.5F - f6 * Mth.cos(f9 * 0.5F - (float) Math.PI / 4) * f6 * Mth.cos(f9 * 0.5F - (float) Math.PI / 4);
		this.legUpperLeft.xRot = ((Mth.cos(f10 * limbSwing * 0.25F) * Mth.cos(f10 * limbSwing * 0.25F)) * limbSwingAmount * 1.5F) + f6 / 2 * Mth.cos(f9 * 0.25F) * f6 * Mth.cos(f9 * 0.25F);
		this.legLowerLeft.xRot = -(Mth.sin(f10 * limbSwing * 0.25F + (float) Math.PI / 4F) * Mth.sin(f10 * limbSwing * 0.25F + (float) Math.PI / 4F)) * limbSwingAmount * 1.5F - f6 * Mth.sin(f9 * 0.5F - (float) Math.PI / 4) * f6 * Mth.sin(f9 * 0.5F - (float) Math.PI / 4);

		if (tailWagging) {
			this.tail.yRot = Mth.cos(f9 / 2) / 2;
		} else {
			this.tail.yRot = 0.0F;
		}

		if (wingsFlapping) {
			this.wingLeft.yRot = Mth.cos((float) entityIn.tickCount / 2 + partialTick) * Mth.cos((float) entityIn.tickCount / 2 + partialTick);
			this.wingRight.yRot = -(Mth.cos((float) entityIn.tickCount / 2 + partialTick) * Mth.cos((float) entityIn.tickCount / 2 + partialTick));
		} else {
			this.wingLeft.yRot = 0.0F;
			this.wingRight.yRot = 0.0F;
		}
	}
}