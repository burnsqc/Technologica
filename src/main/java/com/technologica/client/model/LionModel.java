package com.technologica.client.model;

import com.google.common.collect.ImmutableList;
import com.technologica.world.entity.animal.Lion;

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

public class LionModel<T extends Lion> extends AgeableListModel<T> {
	/*
	protected final ModelPart legBackLeft;
	protected final ModelPart legBackRight;
	protected final ModelPart legFrontLeft;
	protected final ModelPart legFrontRight;
	protected final ModelPart tail;
	protected final ModelPart head;
	protected final ModelPart body;
	private final ModelPart nose; 
	private final ModelPart earRight;
	private final ModelPart earLeft;
	private final ModelPart mane;
	private final ModelPart mane2;
	private final ModelPart mane3;
	protected int state = 1;
	*/

	public LionModel() {
		super(true, 10.0F, 4.0F);
		/*
		this.texWidth = 64;
		this.texHeight = 64;
		
		this.head = new ModelPart(this, 0, 44);
		this.head.setPos(0.0F, 9.0F, -8.0F);
		this.head.addBox(-4.0F, -4.0F, -7.0F, 8.0F, 8.0F, 7.0F);
		
		this.nose = new ModelPart(this, 0, 0);
		this.nose.addBox(-2.0F, -1.0F, -9.0F, 4.0F, 5.0F, 2.0F);
		this.head.addChild(this.nose);
		
		this.earRight = new ModelPart(this, 0, 7);
		this.earRight.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 1.0F);
		this.earRight.setPos(-4.0F, -4.0F, -5.0F);
		this.head.addChild(this.earRight);

		this.earLeft = new ModelPart(this, 0, 7);
		this.earLeft.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 1.0F);
		this.earLeft.setPos(4.0F, -4.0F, -5.0F);
		this.head.addChild(this.earLeft);
		
		this.body = new ModelPart(this, 0, 0);
		this.body.addBox(-5.0F, -5.0F, -10.0F, 10.0F, 10.0F, 20.0F);
		this.body.setPos(0.0F, 11.0F, 0.0F);

		this.mane = new ModelPart(this, 0, 30);
		this.mane.addBox(-6.0F, -7.0F, -12.0F, 12.0F, 12.0F, 2.0F);
		this.body.addChild(this.mane);
		
		this.mane2 = new ModelPart(this, 28, 30);
		this.mane2.addBox(-6.5F, -8.0F, -11.0F, 13.0F, 14.0F, 4.0F);
		this.body.addChild(this.mane2);
		
		this.mane3 = new ModelPart(this, 0, 30);
		this.mane3.addBox(-6.0F, -6.0F, -7.0F, 12.0F, 12.0F, 2.0F);
		this.body.addChild(this.mane3);
		
		this.tail = new ModelPart(this, 12, 0);
		this.tail.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 8.0F, 2.0F);
		this.tail.setPos(0.0F, 8.0F, 10.0F);

		this.legBackLeft = new ModelPart(this, 40, 0);
		this.legBackLeft.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 8.0F, 4.0F);
		this.legBackLeft.setPos(3.0F, 16.0F, 10.0F);

		this.legBackRight = new ModelPart(this, 40, 0);
		this.legBackRight.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 8.0F, 4.0F);
		this.legBackRight.setPos(-3.0F, 16.0F, 10.0F);

		this.legFrontLeft = new ModelPart(this, 40, 0);
		this.legFrontLeft.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 4.0F);
		this.legFrontLeft.setPos(3.0F, 16.0F, -10.0F);

		this.legFrontRight = new ModelPart(this, 40, 0);
		this.legFrontRight.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 4.0F);
		this.legFrontRight.setPos(-3.0F, 16.0F, -10.0F);
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
	protected Iterable<ModelPart> headParts() {
		return ImmutableList.of(this.head);
	}

	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(this.body, this.legBackLeft, this.legBackRight, this.legFrontLeft, this.legFrontRight, this.tail);
	}

	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.xRot = headPitch * ((float) Math.PI / 180F);
		this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
		if (this.state != 3) {
			if (this.state == 2) {
				this.legBackLeft.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
				this.legBackRight.xRot = Mth.cos(limbSwing * 0.6662F + 0.3F) * limbSwingAmount;
				this.legFrontLeft.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI + 0.3F) * limbSwingAmount;
				this.legFrontRight.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
			} else {
				this.legBackLeft.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
				this.legBackRight.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
				this.legFrontLeft.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
				this.legFrontRight.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
			}
		}
		
		this.earLeft.zRot = -3 * (float) Math.PI / 4;
		this.earRight.zRot = 3 * (float) Math.PI / 4;
	}

	public void prepareMobModel(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		this.tail.xRot = (float) Math.PI / 6;
		if (entityIn.isCrouching()) {
			++this.body.y;
			this.head.y += 2.0F;
			++this.tail.y;
			this.tail.xRot = ((float) Math.PI / 2F);
			this.state = 0;
		} else if (entityIn.isSprinting()) {
			this.tail.xRot = ((float) Math.PI / 2F);
			this.state = 2;
		} else {
			this.state = 1;
		}
	}
	*/
}