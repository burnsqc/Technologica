package com.technologica.client.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.Entity;

public class CottonmouthModel<T extends Entity> extends ListModel<T> {
	
	private final ModelPart headUpper;
	private final ModelPart headLower;
	private final ModelPart fangs;
	private final ModelPart body1;
	private final ModelPart body2;
	private final ModelPart body3;
	private final ModelPart body4;
	private final ModelPart body5;
	private final ModelPart body6;
	private final ModelPart body7;
	private final ModelPart body8;
	private final ModelPart body9;
	private final ModelPart body10;
	private final ModelPart body11;
	private final ModelPart body12;
	private final ModelPart body13;
	private final ModelPart body14;
	

	public CottonmouthModel(ModelPart modelPartIn) {
		
		//texWidth = 16;
		//texHeight = 16;
		
		this.headLower = modelPartIn.getChild("headLower");
		this.headUpper = headLower.getChild("headUpper");
		this.fangs = headUpper.getChild("fangs");
		this.body1 = headLower.getChild("body1");
		this.body2 = body1.getChild("body2");
		this.body3 = body2.getChild("body3");
		this.body4 = body3.getChild("body4");
		this.body5 = body4.getChild("body5");
		this.body6 = body5.getChild("body6");
		this.body7 = body6.getChild("body7");
		this.body8 = body7.getChild("body8");
		this.body9 = body8.getChild("body9");
		this.body10 = body9.getChild("body10");
		this.body11 = body10.getChild("body11");
		this.body12 = body11.getChild("body12");
		this.body13 = body12.getChild("body13");
		this.body14 = body13.getChild("body14");
		
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
		PartDefinition partdefinition = meshdefinition.getRoot();
		
		PartDefinition headLower = partdefinition.addOrReplaceChild("headLower", CubeListBuilder.create().texOffs(0, 8).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 1.0F, 3.0F), PartPose.offset(0.0F, 23.0F, 0.0F));
		
		PartDefinition headUpper = headLower.addOrReplaceChild("headUpper", CubeListBuilder.create().texOffs(0, 4).addBox(-1.5F, -1.0F, -3.0F, 3.0F, 1.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		headUpper.addOrReplaceChild("fangs", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F), PartPose.offset(0.0F, 0.0F, -2.0F));
		
		PartDefinition body1 = headLower.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition body2 = body1.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 2.0F));
		PartDefinition body3 = body2.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 2.0F));
		PartDefinition body4 = body3.addOrReplaceChild("body4", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 2.0F));
		PartDefinition body5 = body4.addOrReplaceChild("body5", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 2.0F));
		PartDefinition body6 = body5.addOrReplaceChild("body6", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 2.0F));
		PartDefinition body7 = body6.addOrReplaceChild("body7", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 2.0F));
		PartDefinition body8 = body7.addOrReplaceChild("body8", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 2.0F));
		PartDefinition body9 = body8.addOrReplaceChild("body9", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 2.0F));
		PartDefinition body10 = body9.addOrReplaceChild("body10", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 2.0F));
		PartDefinition body11 = body10.addOrReplaceChild("body11", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 2.0F));
		PartDefinition body12 = body11.addOrReplaceChild("body12", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 2.0F));
		PartDefinition body13 = body12.addOrReplaceChild("body13", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 2.0F));
		body13.addOrReplaceChild("body14", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 2.0F));
		
		return LayerDefinition.create(meshdefinition, 16, 16);
	}
	
	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.headLower);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.headUpper.xRot = (float) (-(Math.sin(ageInTicks / 10) * Math.sin(ageInTicks / 10))/2);
		this.body1.yRot = (float) (-Math.sin(ageInTicks / 10)/3);
		this.body2.yRot = (float) (-Math.sin(ageInTicks / 10)/3);
		this.body3.yRot = (float) (-Math.sin(ageInTicks / 10)/3);
		this.body4.yRot = (float) (-Math.sin(ageInTicks / 10)/3);
		this.body5.yRot = (float) (Math.sin(ageInTicks / 10)/3);
		this.body6.yRot = (float) (Math.sin(ageInTicks / 10)/3);
		this.body7.yRot = (float) (Math.sin(ageInTicks / 10)/3);
		this.body8.yRot = (float) (Math.sin(ageInTicks / 10)/3);
		this.body9.yRot = (float) (-Math.sin(ageInTicks / 10)/3);
		this.body10.yRot = (float) (-Math.sin(ageInTicks / 10)/3);
		this.body11.yRot = (float) (-Math.sin(ageInTicks / 10)/3);
		this.body12.yRot = (float) (-Math.sin(ageInTicks / 10)/3);
		this.body13.yRot = (float) (Math.sin(ageInTicks / 10)/3);
		this.body14.yRot = (float) (Math.sin(ageInTicks / 10)/3);
		this.fangs.xRot = (float) Math.PI/4;
	}

	public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}