package com.technologica.client.model;

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
	/*
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
	*/

	public CottonmouthModel() {
		/*
		texWidth = 16;
		texHeight = 16;

		this.headLower = new ModelPart(this, 0, 8);
		this.headLower.setPos(0.0F, 23.0F, 0.0F);
		this.headLower.addBox(-1.5F, 0.0F, -3.0F, 3.0F, 1.0F, 3.0F);
		
		this.headUpper = new ModelPart(this, 0, 4);
		this.headUpper.setPos(0.0F, 0.0F, 0.0F);
		this.headUpper.addBox(-1.5F, -1.0F, -3.0F, 3.0F, 1.0F, 3.0F);
		this.headLower.addChild(this.headUpper);
		
		this.fangs = new ModelPart(this, 0, 12);
		this.fangs.addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F);
		this.fangs.setPos(0.0F, 0.0F, -2.0F);
		this.headUpper.addChild(this.fangs);
		
		body1 = new ModelPart(this, 0, 0);
		body1.setPos(0.0F, 0.0F, 0.0F);
		body1.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);
		this.headLower.addChild(this.body1);
		
		body2 = new ModelPart(this, 0, 0);
		body2.setPos(0.0F, 0.0F, 2.0F);
		body2.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body1.addChild(this.body2);
		
		body3 = new ModelPart(this, 0, 0);
		body3.setPos(0.0F, 0.0F, 2.0F);
		body3.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body2.addChild(this.body3);
		
		body4 = new ModelPart(this, 0, 0);
		body4.setPos(0.0F, 0.0F, 2.0F);
		body4.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body3.addChild(this.body4);
		
		body5 = new ModelPart(this, 0, 0);
		body5.setPos(0.0F, 0.0F, 2.0F);
		body5.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body4.addChild(this.body5);
		
		body6 = new ModelPart(this, 0, 0);
		body6.setPos(0.0F, 0.0F, 2.0F);
		body6.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body5.addChild(this.body6);
		
		body7 = new ModelPart(this, 0, 0);
		body7.setPos(0.0F, 0.0F, 2.0F);
		body7.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body6.addChild(this.body7);
		
		body8 = new ModelPart(this, 0, 0);
		body8.setPos(0.0F, 0.0F, 2.0F);
		body8.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body7.addChild(this.body8);
		
		body9 = new ModelPart(this, 0, 0);
		body9.setPos(0.0F, 0.0F, 2.0F);
		body9.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body8.addChild(this.body9);
		
		body10 = new ModelPart(this, 0, 0);
		body10.setPos(0.0F, 0.0F, 2.0F);
		body10.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body9.addChild(this.body10);
		
		body11 = new ModelPart(this, 0, 0);
		body11.setPos(0.0F, 0.0F, 2.0F);
		body11.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body10.addChild(this.body11);
		
		body12 = new ModelPart(this, 0, 0);
		body12.setPos(0.0F, 0.0F, 2.0F);
		body12.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body11.addChild(this.body12);
		
		body13 = new ModelPart(this, 0, 0);
		body13.setPos(0.0F, 0.0F, 2.0F);
		body13.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body12.addChild(this.body13);
		
		body14 = new ModelPart(this, 0, 0);
		body14.setPos(0.0F, 0.0F, 2.0F);
		body14.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body13.addChild(this.body14);
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
	public Iterable<ModelPart> parts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setupAnim(T p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_,
			float p_102623_) {
		// TODO Auto-generated method stub
		
	}

	/*
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.headLower);
	}

	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.headUpper.xRot = -(Mth.sin(ageInTicks / 10) * Mth.sin(ageInTicks / 10))/2;
		this.body1.yRot = -Mth.sin(ageInTicks / 10)/3;
		this.body2.yRot = -Mth.sin(ageInTicks / 10)/3;
		this.body3.yRot = -Mth.sin(ageInTicks / 10)/3;
		this.body4.yRot = -Mth.sin(ageInTicks / 10)/3;
		this.body5.yRot = Mth.sin(ageInTicks / 10)/3;
		this.body6.yRot = Mth.sin(ageInTicks / 10)/3;
		this.body7.yRot = Mth.sin(ageInTicks / 10)/3;
		this.body8.yRot = Mth.sin(ageInTicks / 10)/3;
		this.body9.yRot = -Mth.sin(ageInTicks / 10)/3;
		this.body10.yRot = -Mth.sin(ageInTicks / 10)/3;
		this.body11.yRot = -Mth.sin(ageInTicks / 10)/3;
		this.body12.yRot = -Mth.sin(ageInTicks / 10)/3;
		this.body13.yRot = Mth.sin(ageInTicks / 10)/3;
		this.body14.yRot = Mth.sin(ageInTicks / 10)/3;
		this.fangs.xRot = (float) Math.PI/4;
	}

	public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
	*/
}