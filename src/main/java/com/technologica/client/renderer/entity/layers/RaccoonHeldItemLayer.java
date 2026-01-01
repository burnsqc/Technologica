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

	public RaccoonHeldItemLayer(RenderLayerParent<Raccoon, RaccoonModel<Raccoon>> renderLayerParent) {
		super(renderLayerParent);
	}

	@Override
	public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, Raccoon raccoon, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		boolean isBaby = raccoon.isBaby();
		poseStack.pushPose();
		if (isBaby) {
			poseStack.scale(0.75F, 0.75F, 0.75F);
			poseStack.translate(0.0D, 1.5D, 0.209375F);
		}
		poseStack.translate(0D, 1.3125D, -0.3125D);
		poseStack.mulPose(Axis.YP.rotationDegrees(netHeadYaw / 2));
		poseStack.mulPose(Axis.XP.rotationDegrees(headPitch / 2));
		if (isBaby) {
			poseStack.translate(0.06F, 0.26F, -0.6D);
		} else {
			poseStack.translate(0.0D, -0.13D, -0.55D);
		}
		poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
		ItemStack itemstack = raccoon.getItemBySlot(EquipmentSlot.MAINHAND);
		Minecraft.getInstance().getEntityRenderDispatcher().getItemInHandRenderer().renderItem(raccoon, itemstack, ItemDisplayContext.GROUND, false, poseStack, multiBufferSource, packedLight);
		poseStack.popPose();
	}
}
