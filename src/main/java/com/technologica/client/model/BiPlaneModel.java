package com.technologica.client.model;

import com.google.common.collect.ImmutableList;
import com.technologica.world.entity.vehicle.Submersible;

import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class BiPlaneModel extends ListModel<Submersible> {
	private final ImmutableList<ModelPart> parts;
	private final ModelPart propeller;

	public BiPlaneModel(ModelPart p_250599_) {
		this.parts = this.createPartsBuilder(p_250599_).build();
		this.propeller = p_250599_.getChild("propeller");
	}

	protected ImmutableList.Builder<ModelPart> createPartsBuilder(ModelPart modelPart) {
		ImmutableList.Builder<ModelPart> builder = new ImmutableList.Builder<>();
		builder.add(modelPart.getChild("bottom")).add(modelPart.getChild("wing_lower")).add(modelPart.getChild("wing_upper")).add(modelPart.getChild("brace_left_front")).add(modelPart.getChild("brace_right_rear")).add(modelPart.getChild("brace_right_front")).add(modelPart.getChild("brace_left_rear")).add(modelPart.getChild("windshield")).add(modelPart.getChild("nose")).add(modelPart.getChild("propeller"));
		return builder;
	}

	public static void createChildren(PartDefinition partDefinition) {
		partDefinition.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(0, 0).addBox(-32.0F, -8.0F, -8.0F, 64.0F, 16.0F, 16.0F), PartPose.offset(0.0F, 12.0F, 0.0F));
		partDefinition.addOrReplaceChild("wing_lower", CubeListBuilder.create().texOffs(0, 0).addBox(4.0F, 6.0F, -48.0F, 16.0F, 2.0F, 96.0F), PartPose.offset(0.0F, 12.0F, 0.0F));
		partDefinition.addOrReplaceChild("wing_upper", CubeListBuilder.create().texOffs(0, 0).addBox(8.0F, -18.0F, -48.0F, 16.0F, 2.0F, 96.0F), PartPose.offset(0.0F, 12.0F, 0.0F));
		partDefinition.addOrReplaceChild("brace_left_front", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 25.0F, 1.0F), PartPose.offsetAndRotation(23.0F, -6.0F, -32.0F, 0.0F, 0.0F, 0.2F));
		partDefinition.addOrReplaceChild("brace_left_rear", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 25.0F, 1.0F), PartPose.offsetAndRotation(9.0F, -6.0F, -32.0F, 0.0F, 0.0F, 0.2F));
		partDefinition.addOrReplaceChild("brace_right_front", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 25.0F, 1.0F), PartPose.offsetAndRotation(23.0F, -6.0F, 33.0F, 0.0F, 0.0F, 0.2F));
		partDefinition.addOrReplaceChild("brace_right_rear", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 25.0F, 1.0F), PartPose.offsetAndRotation(9.0F, -6.0F, 33.0F, 0.0F, 0.0F, 0.2F));
		partDefinition.addOrReplaceChild("windshield", CubeListBuilder.create().texOffs(102, 110).addBox(8.0F, -14.0F, -6.0F, 1.0F, 6.0F, 12.0F), PartPose.offset(0.0F, 12.0F, 0.0F));
		partDefinition.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(0, 0).addBox(32.0F, -2.0F, -2.0F, 3.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 12.0F, 0.0F));
		partDefinition.addOrReplaceChild("propeller", CubeListBuilder.create().texOffs(0, 0).addBox(33.0F, -16.0F, -2.0F, 1.0F, 32.0F, 4.0F), PartPose.offset(0.0F, 12.0F, 0.0F));
	}

	public static LayerDefinition createBodyModel() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		createChildren(partdefinition);
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Submersible biplane, float p_102270_, float p_102271_, float p_102272_, float p_102273_, float p_102274_) {
		this.propeller.xRot = 2 * biplane.throttle * (biplane.tickCount + p_102271_);
	}

	@Override
	public ImmutableList<ModelPart> parts() {
		return this.parts;
	}
}