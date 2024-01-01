package com.technologica.client.model;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class FigureEightPufferfishMidModel<T extends Entity> extends HierarchicalModel<T> {
   private final ModelPart root;
   private final ModelPart leftBlueFin;
   private final ModelPart rightBlueFin;

   public FigureEightPufferfishMidModel(ModelPart p_170842_) {
      this.root = p_170842_;
      this.leftBlueFin = p_170842_.getChild("left_blue_fin");
      this.rightBlueFin = p_170842_.getChild("right_blue_fin");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(12, 22).addBox(-2.5F, -5.0F, -2.5F, 5.0F, 5.0F, 5.0F), PartPose.offset(0.0F, 22.0F, 0.0F));
      partdefinition.addOrReplaceChild("back_fin", CubeListBuilder.create().texOffs(-3, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 3.0F), PartPose.offset(0.0F, 19.0F, 2.5F));
      partdefinition.addOrReplaceChild("right_blue_fin", CubeListBuilder.create().texOffs(24, 0).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F), PartPose.offset(-2.5F, 20.0F, -1.5F));
      partdefinition.addOrReplaceChild("left_blue_fin", CubeListBuilder.create().texOffs(24, 3).addBox(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F), PartPose.offset(2.5F, 20.0F, -1.5F));
      return LayerDefinition.create(meshdefinition, 32, 32);
   }

   @Override
   public ModelPart root() {
      return this.root;
   }

   @Override
   public void setupAnim(T p_103471_, float p_103472_, float p_103473_, float p_103474_, float p_103475_, float p_103476_) {
      this.rightBlueFin.zRot = -0.2F + 0.4F * Mth.sin(p_103474_ * 0.2F);
      this.leftBlueFin.zRot = 0.2F - 0.4F * Mth.sin(p_103474_ * 0.2F);
   }
}