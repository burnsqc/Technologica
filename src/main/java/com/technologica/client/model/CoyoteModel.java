package com.technologica.client.model;

import com.technologica.world.entity.animal.Coyote;

import net.minecraft.client.model.ColorableAgeableListModel;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class CoyoteModel<T extends Coyote> extends ColorableAgeableListModel<T> {
  /*
	private final ModelPart head;
   private final ModelPart headChild;
   private final ModelPart body;
   private final ModelPart legBackRight;
   private final ModelPart legBackLeft;
   private final ModelPart legFrontRight;
   private final ModelPart legFrontLeft;
   private final ModelPart tail;
   private final ModelPart tailChild;
   */

   public CoyoteModel() {
	   /*
      this.head = new ModelPart(this, 0, 0);
      this.head.setPos(0.0F, 14.0F, -5.0F);
      this.headChild = new ModelPart(this, 0, 0);
      this.headChild.addBox(-2.5F, -4.0F, -5.0F, 5.0F, 5.0F, 5.0F, 0.0F);
      this.head.addChild(this.headChild);
      this.body = new ModelPart(this, 18, 11);
      this.body.addBox(-3.0F, -8.0F, -3.0F, 6.0F, 15.0F, 6.0F, 0.0F);
      this.body.setPos(0.0F, 14.0F, 2.0F);
      this.legBackRight = new ModelPart(this, 0, 18);
      this.legBackRight.addBox(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F);
      this.legBackRight.setPos(-2.5F, 16.0F, 7.0F);
      this.legBackLeft = new ModelPart(this, 0, 18);
      this.legBackLeft.addBox(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F);
      this.legBackLeft.setPos(0.5F, 16.0F, 7.0F);
      this.legFrontRight = new ModelPart(this, 0, 18);
      this.legFrontRight.addBox(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F);
      this.legFrontRight.setPos(-2.5F, 16.0F, -4.0F);
      this.legFrontLeft = new ModelPart(this, 0, 18);
      this.legFrontLeft.addBox(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F);
      this.legFrontLeft.setPos(0.5F, 16.0F, -4.0F);
      this.tail = new ModelPart(this, 9, 18);
      this.tail.setPos(-1.0F, 12.0F, 8.0F);
      this.tailChild = new ModelPart(this, 9, 18);
      this.tailChild.addBox(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F);
      this.tail.addChild(this.tailChild);
      this.headChild.texOffs(16, 14).addBox(-3.5F, -5.0F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F);
      this.headChild.texOffs(16, 14).addBox(1.5F, -5.0F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F);
      this.headChild.texOffs(0, 10).addBox(-1.0F, -2.0F, -8.0F, 2.0F, 3.0F, 4.0F, 0.0F);
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
      return ImmutableList.of(this.body, this.legBackRight, this.legBackLeft, this.legFrontRight, this.legFrontLeft, this.tail);
   }

   public void prepareMobModel(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
      if (entityIn.isAngry()) {
         this.tail.yRot = 0.0F;
      } else {
         this.tail.yRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
      }

      if (entityIn.isInSittingPose()) {
         this.body.setPos(0.0F, 18.0F, 0.0F);
         this.body.xRot = ((float)Math.PI / 4F);
         this.tail.setPos(-1.0F, 21.0F, 6.0F);
         this.legBackRight.setPos(-2.5F, 22.7F, 2.0F);
         this.legBackRight.xRot = ((float)Math.PI * 1.5F);
         this.legBackLeft.setPos(0.5F, 22.7F, 2.0F);
         this.legBackLeft.xRot = ((float)Math.PI * 1.5F);
         this.legFrontRight.xRot = 5.811947F;
         this.legFrontRight.setPos(-2.49F, 17.0F, -4.0F);
         this.legFrontLeft.xRot = 5.811947F;
         this.legFrontLeft.setPos(0.51F, 17.0F, -4.0F);
      } else {
         this.body.setPos(0.0F, 14.0F, 2.0F);
         this.body.xRot = ((float)Math.PI / 2F);
         this.tail.setPos(-1.0F, 12.0F, 8.0F);
         this.legBackRight.setPos(-2.5F, 16.0F, 7.0F);
         this.legBackLeft.setPos(0.5F, 16.0F, 7.0F);
         this.legFrontRight.setPos(-2.5F, 16.0F, -4.0F);
         this.legFrontLeft.setPos(0.5F, 16.0F, -4.0F);
         this.legBackRight.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
         this.legBackLeft.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
         this.legFrontRight.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
         this.legFrontLeft.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
      }

      this.headChild.zRot = entityIn.getInterestedAngle(partialTick) + entityIn.getShakeAngle(partialTick, 0.0F);
      this.body.zRot = entityIn.getShakeAngle(partialTick, -0.16F);
      this.tailChild.zRot = entityIn.getShakeAngle(partialTick, -0.2F);
   }

   
   public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.xRot = headPitch * ((float)Math.PI / 180F);
      this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
      this.tail.xRot = ageInTicks;
   }
   */
}