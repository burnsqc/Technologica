package com.technologica.client.model;

import com.technologica.world.entity.animal.PoisonDartFrog;

import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class PoisonDartFrogModel<T extends PoisonDartFrog> extends QuadrupedModel<T> {
	
	private final ModelPart body;
	private final ModelPart eyeLeft;
	private final ModelPart eyeRight;
	private final ModelPart head;
	private final ModelPart leg0;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	
	public PoisonDartFrogModel(ModelPart modelPartIn) {
		super(modelPartIn, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		
		this.body = modelPartIn.getChild("body");
		this.head = modelPartIn.getChild("head");
		this.eyeRight = head.getChild("eyeRight");
		this.eyeLeft = head.getChild("eyeLeft");
		this.leg0 = modelPartIn.getChild("right_hind_leg");
		this.leg1 = modelPartIn.getChild("left_hind_leg");
		this.leg2 = modelPartIn.getChild("right_front_leg");
		this.leg3 = modelPartIn.getChild("left_front_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition partdefinition = meshdefinition.getRoot();
		
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 3.0F, 4.0F), PartPose.offset(0.0F, 21.0F, 0.0F));
		
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 7).addBox(-1.5F, -1.0F, -3.0F, 3.0F, 2.0F, 3.0F), PartPose.offset(0.0F, 20.0F, -1.0F));
		PartDefinition eyeLeft = head.addOrReplaceChild("eyeLeft", CubeListBuilder.create().texOffs(0, 12).addBox(-1.5F, -2.0F, -2.0F, 1.0F, 1.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition eyeRight = head.addOrReplaceChild("eyeRight", CubeListBuilder.create().texOffs( 6, 12).addBox(0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		
		partdefinition.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(16, 5).addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F), PartPose.offset(-3.0F, 21.0F, 0.0F));
		partdefinition.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(16, 0).addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F), PartPose.offset(1.0F, 21.0F, 0.0F));
		partdefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(16, 5).addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F), PartPose.offset(-3.0F, 21.0F, -4.0F));
		partdefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(16, 0).addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F), PartPose.offset(1.0F, 21.0F, -4.0F));
		
		return LayerDefinition.create(meshdefinition, 32, 16);
	}
	
	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.xRot = -((float) Math.PI / 8F);
	}
}
