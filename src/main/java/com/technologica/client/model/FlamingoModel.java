package com.technologica.client.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.animal.Animal;

public class FlamingoModel<T extends Animal> extends AgeableListModel<T> {
	private final ModelPart head;
	private final ModelPart neck1;
	private final ModelPart neck2;
	private final ModelPart neck3;
	private final ModelPart neck4;
	private final ModelPart neck5;
	private final ModelPart body;
	private final ModelPart legRight;
	private final ModelPart legLeft;
	private final ModelPart wingRight;
	private final ModelPart wingLeft;

	public FlamingoModel(ModelPart modelPartIn) {
		this.body = modelPartIn.getChild("body");
		this.neck1 = modelPartIn.getChild("neck1");
		this.neck2 = neck1.getChild("neck2");
		this.neck3 = neck2.getChild("neck3");
		this.neck4 = neck3.getChild("neck4");
		this.neck5 = neck4.getChild("neck5");
		this.head = neck5.getChild("head");
		this.legRight = modelPartIn.getChild("leg_right");
		this.legLeft = modelPartIn.getChild("leg_left");
		this.wingRight = modelPartIn.getChild("wing_right");
		this.wingLeft = modelPartIn.getChild("wing_left");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition root = meshdefinition.getRoot();
		root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, -4.0F, 6.0F, 6.0F, 8.0F), PartPose.offset(0.0F, 9.0F, 0.0F));
		root.addOrReplaceChild("wing_right", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(0.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F), PartPose.offset(-4.0F, 7.0F, 0.0F));
		root.addOrReplaceChild("wing_left", CubeListBuilder.create().texOffs(0, 19).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F), PartPose.offset(4.0F, 7.0F, 0.0F));
		PartDefinition rightLeg = root.addOrReplaceChild("leg_right", CubeListBuilder.create().texOffs(10, 14).addBox(-1.0F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F), PartPose.offset(-2.0F, 12.0F, 0.0F));
		PartDefinition leftLeg = root.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(10, 14).addBox(-1.0F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F), PartPose.offset(1.0F, 12.0F, 0.0F));
		rightLeg.addOrReplaceChild("right_leg_lower", CubeListBuilder.create().texOffs(22, 14).addBox(-1.0F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F), PartPose.offset(0.0F, 6.0F, 0.0F));
		leftLeg.addOrReplaceChild("left_leg_lower", CubeListBuilder.create().texOffs(22, 14).addBox(-1.0F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F), PartPose.offset(0.0F, 6.0F, 0.0F));
		PartDefinition neck1 = root.addOrReplaceChild("neck1", CubeListBuilder.create().texOffs(14, 23).addBox(-1.0F, -2.0F, -4.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(0.0F, 12.0F, -4.0F));
		PartDefinition neck2 = neck1.addOrReplaceChild("neck2", CubeListBuilder.create().texOffs(14, 23).addBox(-1.0F, -2.0F, -4.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(0.0F, 0.0F, -4.0F));
		PartDefinition neck3 = neck2.addOrReplaceChild("neck3", CubeListBuilder.create().texOffs(14, 23).addBox(-1.0F, -2.0F, -4.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(0.0F, 0.0F, -4.0F));
		PartDefinition neck4 = neck3.addOrReplaceChild("neck4", CubeListBuilder.create().texOffs(14, 23).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(0.0F, -2.0F, -4.0F));
		PartDefinition neck5 = neck4.addOrReplaceChild("neck5", CubeListBuilder.create().texOffs(14, 23).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(0.0F, 0.0F, -4.0F));
		PartDefinition head = neck5.addOrReplaceChild("head", CubeListBuilder.create().texOffs(20, 0).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F), PartPose.offset(0.0F, 0.0F, -4.0F));
		head.addOrReplaceChild("bill", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, 1.0F, -6.0F, 2.0F, 2.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 32);
	}
	
	@Override
	protected Iterable<ModelPart> headParts() {
		return ImmutableList.of(this.neck1);
	}

	@Override
	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(this.body, this.legRight, this.legLeft, this.wingRight, this.wingLeft);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.neck1.xRot = -(float)Math.PI/4;
		this.neck2.xRot = -(float)Math.PI/4;
		this.neck3.xRot = -(float)Math.PI/4;
		this.neck4.xRot = (float)Math.PI/4;
		this.neck5.xRot = (float)Math.PI/4;
		this.head.xRot = (float)Math.PI/4;
	}
}