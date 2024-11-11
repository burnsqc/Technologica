package com.technologica.client.model;

import com.google.common.collect.ImmutableList;
import com.technologica.world.entity.item.NavalMine;

import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class NavalMineModel extends ListModel<NavalMine> {
	private final ModelPart bb_main;
	private final ModelPart cube_r1;
	private final ModelPart cube_r2;
	private final ModelPart cube_r3;
	private final ModelPart cube_r4;
	private final ModelPart cube_r5;
	private final ModelPart cube_r6;
	private final ModelPart cube_r7;
	private final ModelPart cube_r8;
	private final ModelPart cube_r9;
	private final ModelPart cube_r10;
	private final ModelPart cube_r11;
	private final ModelPart cube_r12;

	public NavalMineModel(ModelPart modelPartIn) {
		this.bb_main = modelPartIn.getChild("bb_main");
		this.cube_r1 = bb_main.getChild("cube_r1");
		this.cube_r2 = bb_main.getChild("cube_r2");
		this.cube_r3 = bb_main.getChild("cube_r3");
		this.cube_r4 = bb_main.getChild("cube_r4");
		this.cube_r5 = bb_main.getChild("cube_r5");
		this.cube_r6 = bb_main.getChild("cube_r6");
		this.cube_r7 = bb_main.getChild("cube_r7");
		this.cube_r8 = bb_main.getChild("cube_r8");
		this.cube_r9 = bb_main.getChild("cube_r9");
		this.cube_r10 = bb_main.getChild("cube_r10");
		this.cube_r11 = bb_main.getChild("cube_r11");
		this.cube_r12 = bb_main.getChild("cube_r12");
	}

	public static LayerDefinition createBodyModel() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(112, 0).addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-6.0F, -16.0F, -6.0F, 12.0F, 32.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));
		PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-6.0F, -16.0F, -6.0F, 12.0F, 32.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(112, 0).addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
		PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -16.0F, -6.0F, 12.0F, 32.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition cube_r3 = bb_main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(112, 0).addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
		PartDefinition cube_r4 = bb_main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(112, 0).addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(48, 0).addBox(-6.0F, -16.0F, -7.0F, 12.0F, 32.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition cube_r5 = bb_main.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(112, 0).addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 1.5708F));
		PartDefinition cube_r6 = bb_main.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(112, 0).addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 1.5708F));
		PartDefinition cube_r7 = bb_main.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(112, 0).addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 1.5708F));
		PartDefinition cube_r8 = bb_main.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(112, 0).addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 44).mirror().addBox(-7.0F, -16.0F, -6.0F, 14.0F, 32.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition cube_r9 = bb_main.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(112, 0).addBox(-2.0F, -24.0F, -2.0F, 4.0F, 48.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 44).mirror().addBox(-7.0F, -16.0F, -6.0F, 14.0F, 32.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition cube_r10 = bb_main.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 102).mirror().addBox(-16.0F, -6.0F, -7.0F, 32.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition cube_r11 = bb_main.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 102).mirror().addBox(-16.0F, -6.0F, -7.0F, 32.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition cube_r12 = bb_main.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(48, 0).addBox(-6.0F, -16.0F, -7.0F, 12.0F, 32.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 3.927F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.bb_main);
	}

	@Override
	public void setupAnim(NavalMine p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {
	}
}