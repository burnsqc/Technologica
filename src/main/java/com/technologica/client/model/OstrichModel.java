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
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.util.Mth;

public class OstrichModel<T extends AbstractHorse> extends AgeableListModel<T> {
	/*
	protected final ModelPart body;
	private final ModelPart tail;
	protected final ModelPart wingLeft;
	protected final ModelPart wingRight;
	protected final ModelPart neckLower;
	protected final ModelPart neck;
	protected final ModelPart head;
	protected final ModelPart beak;
	private final ModelPart legUpperLeft;
	private final ModelPart legUpperRight;
	private final ModelPart legLowerLeft;
	private final ModelPart legLowerRight;
	private final ModelPart talonInnerLeft;
	private final ModelPart talonInnerRight;
	private final ModelPart talonOuterLeft;
	private final ModelPart talonOuterRight;
	private final ModelPart saddle;
	*/
	
	public OstrichModel() {
		super(true, 24.0F, 1.36F, 2.7272F, 2.0F, 24.0F);
		/*
		this.texWidth = 64;
		this.texHeight = 64;

		this.body = new ModelPart(this, 0, 0);
		this.body.addBox(-5.0F, -5.0F, -8.0F, 10.0F, 10.0F, 16.0F);
		this.body.setPos(0.0F, 3.0F, 0.0F);
		
		this.tail = new ModelPart(this, 36, 0);
		this.tail.addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 3.0F);
		this.tail.setPos(0.0F, -2.0F, 8.0F);
		this.body.addChild(this.tail);
		
		this.wingLeft = new ModelPart(this, 0, 26);
		this.wingLeft.mirror = true;
		this.wingLeft.addBox(0.0F, -5.0F, 0.0F, 1.0F, 10.0F, 12.0F);
		this.wingLeft.setPos(5.0F, 0F, -7.0F);
		this.body.addChild(this.wingLeft);
		
		this.wingRight = new ModelPart(this, 0, 26);
		this.wingRight.addBox(-1.0F, -5.0F, 0.0F, 1.0F, 10.0F, 12.0F);
		this.wingRight.setPos(-5.0F, 0F, -7.0F);
		this.body.addChild(this.wingRight);

		this.legUpperLeft = new ModelPart(this, 0, 26);
		this.legUpperLeft.mirror = true;
		this.legUpperLeft.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F);
		this.legUpperLeft.setPos(3.0F, 5.0F, 0.0F);
		this.body.addChild(this.legUpperLeft);
		
		this.legUpperRight = new ModelPart(this, 0, 26);
		this.legUpperRight.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F);
		this.legUpperRight.setPos(-3.0F, 5.0F, 0.0F);
		this.body.addChild(this.legUpperRight);
		
		this.legLowerLeft = new ModelPart(this, 18, 26);
		this.legLowerLeft.mirror = true;
		this.legLowerLeft.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 10.0F, 2.0F);
		this.legLowerLeft.setPos(0.0F, 6.0F, 2.0F);
		this.legUpperLeft.addChild(this.legLowerLeft);
		
		this.legLowerRight = new ModelPart(this, 18, 26);
		this.legLowerRight.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 10.0F, 2.0F);
		this.legLowerRight.setPos(0.0F, 6.0F, 2.0F);
		this.legUpperRight.addChild(this.legLowerRight);
		
		this.talonInnerLeft = new ModelPart(this, 0, 34);
		this.talonInnerLeft.mirror = true;
		this.talonInnerLeft.addBox(-1.0F, 9.0F, -5.0F, 1.0F, 1.0F, 3.0F);
		this.legLowerLeft.addChild(talonInnerLeft);
		
		this.talonInnerRight = new ModelPart(this, 0, 34);
		this.talonInnerRight.addBox(0.0F, 9.0F, -5.0F, 1.0F, 1.0F, 3.0F);
		this.legLowerRight.addChild(talonInnerRight);
		
		this.talonOuterLeft = new ModelPart(this, 6, 34);
		this.talonOuterLeft.mirror = true;
		this.talonOuterLeft.addBox(0.0F, 9.0F, -2.0F, 1.0F, 1.0F, 2.0F);
		this.talonOuterLeft.setPos(0.0F, 0.0F, -2.0F);
		this.legLowerLeft.addChild(talonOuterLeft);
		
		this.talonOuterRight = new ModelPart(this, 6, 34);
		this.talonOuterRight.addBox(-1.0F, 9.0F, -2.0F, 1.0F, 1.0F, 2.0F);
		this.talonOuterRight.setPos(0.0F, 0.0F, -2.0F);
		this.legLowerRight.addChild(talonOuterRight);
		
		this.neckLower = new ModelPart(this, 36, 7);
		this.neckLower.addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 5.0F);
		this.neckLower.setPos(0.0F, 2.0F, -8.0F);
		
		this.neck = new ModelPart(this, 50, 0);
		this.neck.addBox(-1.0F, -10.0F, 0.0F, 2.0F, 10.0F, 2.0F);
		this.neck.setPos(0.0F, 0.0F, -5.0F);
		this.neckLower.addChild(this.neck);
		
		this.head = new ModelPart(this, 0, 0);
		this.head.addBox(-2.0F, -13.0F, -2.0F, 4.0F, 3.0F, 4.0F);
		this.neck.addChild(this.head);
		
		this.beak = new ModelPart(this, 0, 7);
		this.beak.addBox(-1.0F, -11.0F, -4.0F, 2.0F, 1.0F, 2.0F);
		this.head.addChild(this.beak);
		
		this.saddle = new ModelPart(this, 26, 26);
		this.saddle.addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 9.0F, 0.5F);
		this.body.addChild(this.saddle);	
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
	public Iterable<ModelPart> headParts() {
		return ImmutableList.of(this.neckLower);
	}

	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(this.body);
	}

	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netneckYaw, float neckPitch) {
		this.talonOuterLeft.yRot = -((float) Math.PI / 6F);
		this.talonOuterRight.yRot = ((float) Math.PI / 6F);
		boolean flag = entityIn.isSaddled();
		saddle.visible = flag;
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
		boolean wingsFlapping = ((OstrichEntity) entityIn).wingCounter != 0;
		
		this.neckLower.y = 2.0F;
		this.neckLower.z = -8.0F;
		
		this.neckLower.y = f7 * this.neckLower.y - f6;
	    this.neckLower.z = f7 * this.neckLower.z - 3*f6;
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
			this.tail.yRot = Mth.cos(f9/2)/2;
		} else {
			this.tail.yRot = 0.0F;
		}
		
		if (wingsFlapping) {
			this.wingLeft.yRot = Mth.cos((float) entityIn.tickCount/2 + partialTick)*Mth.cos((float) entityIn.tickCount/2 + partialTick);
			this.wingRight.yRot = -(Mth.cos((float) entityIn.tickCount/2 + partialTick)*Mth.cos((float) entityIn.tickCount/2 + partialTick));
		} else {
			this.wingLeft.yRot = 0.0F;
			this.wingRight.yRot = 0.0F;
		}
	}
	*/
}
