package com.technologica.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.technologica.client.model.RaccoonModel;
import com.technologica.world.entity.animal.Raccoon;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class RaccoonHeldItemLayer extends RenderLayer<Raccoon, RaccoonModel<Raccoon>> {

	public RaccoonHeldItemLayer(RenderLayerParent<Raccoon, RaccoonModel<Raccoon>> p_i50938_1_) {
		super(p_i50938_1_);
	}

	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Raccoon entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		boolean flag1 = entitylivingbaseIn.isBaby();
		matrixStackIn.pushPose();
		if (flag1) {
			matrixStackIn.scale(0.75F, 0.75F, 0.75F);
			matrixStackIn.translate(0.0D, 1.5D, 0.209375F);
		}
		matrixStackIn.translate(0D, 1.3125D, -0.3125D);
		matrixStackIn.mulPose(Axis.YP.rotationDegrees(netHeadYaw / 2));
		matrixStackIn.mulPose(Axis.XP.rotationDegrees(headPitch / 2));
		if (entitylivingbaseIn.isBaby()) {
			matrixStackIn.translate(0.06F, 0.26F, -0.6D);
		} else {
			matrixStackIn.translate(0.0D, -0.13D, -0.55D);
		}
		matrixStackIn.mulPose(Axis.XP.rotationDegrees(90.0F));
		ItemStack itemstack = entitylivingbaseIn.getItemBySlot(EquipmentSlot.MAINHAND);
		Minecraft.getInstance().getEntityRenderDispatcher().getItemInHandRenderer().renderItem(entitylivingbaseIn, itemstack, ItemDisplayContext.GROUND, false, matrixStackIn, bufferIn, packedLightIn);
		matrixStackIn.popPose();
	}
}