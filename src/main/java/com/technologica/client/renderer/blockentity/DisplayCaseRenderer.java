package com.technologica.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.technologica.world.level.block.entity.DisplayCaseBlockEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class DisplayCaseRenderer implements BlockEntityRenderer<DisplayCaseBlockEntity> {
	public DisplayCaseRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
	}

	@Override
	public void render(DisplayCaseBlockEntity tileEntity, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
		ItemStack stack = tileEntity.getDisplayStack();
		long time = System.currentTimeMillis();
		float angle = (time / 25) % 360;
		if (!stack.isEmpty()) {
			matrixStack.pushPose();
			matrixStack.translate(0.5, 0.3, 0.5);
			matrixStack.mulPose(Axis.YN.rotationDegrees(angle));
			ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
			BakedModel ibakedmodel = itemRenderer.getModel(stack, tileEntity.getLevel(), null, combinedOverlay);
			itemRenderer.render(stack, ItemDisplayContext.GROUND, true, matrixStack, buffer, combinedLight, combinedOverlay, ibakedmodel);
			matrixStack.popPose();
		}
	}
}