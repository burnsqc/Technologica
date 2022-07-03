package com.technologica.client.model;

import com.google.common.collect.ImmutableList;
import com.technologica.world.entity.item.NavalMine;

import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class NavalMineModel extends ListModel<NavalMine> {
	private final ModelPart body1;
	private final ModelPart body2;
	private final ModelPart body3;
	private final ModelPart faceUD1;
	private final ModelPart faceUD2;
	private final ModelPart faceNS1;
	private final ModelPart faceNS2;
	private final ModelPart faceEW1;
	private final ModelPart faceEW2;
	private final ModelPart spike1;
	private final ModelPart spike2;
	private final ModelPart spike3;
	private final ModelPart spike4;
	private final ModelPart spike5;
	private final ModelPart spike6;
	private final ModelPart spike7;
	private final ModelPart spike8;
	private final ModelPart spike9;

	public NavalMineModel(ModelPart modelPartIn) {
		this.body1 = modelPartIn.getChild("body1");
		this.body2 = modelPartIn.getChild("body2");
		this.body3 = modelPartIn.getChild("body3");
		this.faceUD1 = modelPartIn.getChild("faceUD1");
		this.faceUD2 = modelPartIn.getChild("faceUD2");
		this.faceNS1 = modelPartIn.getChild("faceNS1");
		this.faceNS2 = modelPartIn.getChild("faceNS2");
		this.faceEW1 = modelPartIn.getChild("faceEW1");
		this.faceEW2 = modelPartIn.getChild("faceEW2");
		this.spike1 = modelPartIn.getChild("spike1");
		this.spike2 = modelPartIn.getChild("spike2");
		this.spike3 = modelPartIn.getChild("spike3");
		this.spike4 = modelPartIn.getChild("spike4");
		this.spike5 = modelPartIn.getChild("spike5");
		this.spike6 = modelPartIn.getChild("spike6");
		this.spike7 = modelPartIn.getChild("spike7");
		this.spike8 = modelPartIn.getChild("spike8");
		this.spike9 = modelPartIn.getChild("spike9");
	}

	public static LayerDefinition createBodyModel() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -8.0F, -12.0F, 24.0F, 16.0F, 24.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		partdefinition.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -12.0F, -12.0F, 16.0F, 24.0F, 24.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		partdefinition.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -12.0F, -8.0F, 24.0F, 24.0F, 16.0F), PartPose.offset(0.0F, 16.0F, 0.0F));

		partdefinition.addOrReplaceChild("faceUD1", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -16.0F, -4.0F, 16.0F, 32.0F, 8.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		partdefinition.addOrReplaceChild("faceUD2", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -16.0F, -8.0F, 8.0F, 32.0F, 16.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		partdefinition.addOrReplaceChild("faceNS1", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -4.0F, -16.0F, 16.0F, 8.0F, 32.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		partdefinition.addOrReplaceChild("faceNS2", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -16.0F, 8.0F, 16.0F, 32.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		partdefinition.addOrReplaceChild("faceEW1", CubeListBuilder.create().texOffs(0, 0).addBox(-16.0F, -4.0F, -8.0F, 32.0F, 8.0F, 16.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		partdefinition.addOrReplaceChild("faceEW2", CubeListBuilder.create().texOffs(0, 0).addBox(-16.0F, -8.0F, -4.0F, 32.0F, 16.0F, 8.0F), PartPose.offset(0.0F, 16.0F, 0.0F));

		partdefinition.addOrReplaceChild("spike1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		partdefinition.addOrReplaceChild("spike2", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		partdefinition.addOrReplaceChild("spike3", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		partdefinition.addOrReplaceChild("spike4", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		partdefinition.addOrReplaceChild("spike5", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		partdefinition.addOrReplaceChild("spike6", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		partdefinition.addOrReplaceChild("spike7", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		partdefinition.addOrReplaceChild("spike8", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		partdefinition.addOrReplaceChild("spike9", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F), PartPose.offset(0.0F, 16.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.body1, this.body2, this.body3, this.faceUD1, this.faceUD2, this.faceNS1, this.faceNS2, this.faceEW1, this.faceEW2, this.spike1, this.spike2, this.spike3, this.spike4, this.spike5, this.spike6, this.spike7, this.spike8, this.spike9);
	}

	@Override
	public void setupAnim(NavalMine p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {
		this.spike2.xRot = (float) Math.PI / 4;
		this.spike3.xRot = (float) Math.PI / 2;
		this.spike4.xRot = -(float) Math.PI / 4;

		this.spike5.yRot = (float) Math.PI / 2;
		this.spike6.yRot = (float) Math.PI / 2;
		this.spike7.yRot = (float) Math.PI / 2;
		this.spike5.xRot = (float) Math.PI / 4;
		this.spike6.xRot = (float) Math.PI / 2;
		this.spike7.xRot = -(float) Math.PI / 4;

		this.spike8.yRot = (float) Math.PI / 4;
		this.spike9.yRot = -(float) Math.PI / 4;
		this.spike8.xRot = (float) Math.PI / 2;
		this.spike9.xRot = (float) Math.PI / 2;

	}
}