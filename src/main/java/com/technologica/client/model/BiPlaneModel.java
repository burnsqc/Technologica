package com.technologica.client.model;

import com.google.common.collect.ImmutableList;
import com.technologica.world.entity.vehicle.Aircraft;

import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class BiPlaneModel extends ListModel<Aircraft> {
	private final ImmutableList<ModelPart> parts;
	private final ModelPart propeller;

	public BiPlaneModel(ModelPart modelPart) {
		this.parts = new ImmutableList.Builder<ModelPart>().add(modelPart.getChild("bottom")).add(modelPart.getChild("wing_lower")).add(modelPart.getChild("wing_upper")).add(modelPart.getChild("brace_left_front")).add(modelPart.getChild("brace_right_rear")).add(modelPart.getChild("brace_right_front")).add(modelPart.getChild("brace_left_rear")).add(modelPart.getChild("windshield")).add(modelPart.getChild("nose")).add(modelPart.getChild("propeller")).build();
		this.propeller = modelPart.getChild("propeller");
	}

	public static LayerDefinition createBodyModel() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partDefinition = meshdefinition.getRoot();
		partDefinition.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(0, 0).addBox(-32.0F, -22.0F, -8.0F, 64.0F, 16.0F, 16.0F), PartPose.offset(0.0F, 12.0F, 0.0F));
		partDefinition.addOrReplaceChild("wing_lower", CubeListBuilder.create().texOffs(0, 0).addBox(4.0F, -8.0F, -48.0F, 16.0F, 2.0F, 96.0F), PartPose.offset(0.0F, 12.0F, 0.0F));
		partDefinition.addOrReplaceChild("wing_upper", CubeListBuilder.create().texOffs(0, 0).addBox(8.0F, -32.0F, -48.0F, 16.0F, 2.0F, 96.0F), PartPose.offset(0.0F, 12.0F, 0.0F));
		partDefinition.addOrReplaceChild("brace_left_front", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -14.0F, 0.0F, 1.0F, 25.0F, 1.0F), PartPose.offsetAndRotation(23.0F, -6.0F, -32.0F, 0.0F, 0.0F, 0.2F));
		partDefinition.addOrReplaceChild("brace_left_rear", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -14.0F, 0.0F, 1.0F, 25.0F, 1.0F), PartPose.offsetAndRotation(9.0F, -6.0F, -32.0F, 0.0F, 0.0F, 0.2F));
		partDefinition.addOrReplaceChild("brace_right_front", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -14.0F, 0.0F, 1.0F, 25.0F, 1.0F), PartPose.offsetAndRotation(23.0F, -6.0F, 33.0F, 0.0F, 0.0F, 0.2F));
		partDefinition.addOrReplaceChild("brace_right_rear", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -14.0F, 0.0F, 1.0F, 25.0F, 1.0F), PartPose.offsetAndRotation(9.0F, -6.0F, 33.0F, 0.0F, 0.0F, 0.2F));
		partDefinition.addOrReplaceChild("windshield", CubeListBuilder.create().texOffs(102, 110).addBox(8.0F, -28.0F, -6.0F, 1.0F, 6.0F, 12.0F), PartPose.offset(0.0F, 12.0F, 0.0F));
		partDefinition.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(0, 0).addBox(32.0F, -16.0F, -2.0F, 3.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 12.0F, 0.0F));
		partDefinition.addOrReplaceChild("propeller", CubeListBuilder.create().texOffs(0, 0).addBox(33.0F, -30.0F, -2.0F, 1.0F, 32.0F, 4.0F), PartPose.offset(0.0F, 12.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Aircraft biplane, float limbSwing, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		float wrapped = this.propeller.xRot = Mth.wrapDegrees(this.propeller.xRot);
		this.propeller.xRot = wrapped + (biplane.tickCount + partialTicks) / 10000F * biplane.throttleDelivered;
	}

	@Override
	public ImmutableList<ModelPart> parts() {
		return this.parts;
	}
}
