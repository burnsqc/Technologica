package com.technologica.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.technologica.world.level.block.entity.FruitBlockEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class FruitRenderer implements BlockEntityRenderer<FruitBlockEntity> {
	public FruitRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
	}

	@Override
	public void render(FruitBlockEntity tileEntity, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
		ItemStack stack = tileEntity.getFruitStack();
		Minecraft minecraft = Minecraft.getInstance();
		LocalPlayer clientplayerentity = minecraft.player;
		if (!stack.isEmpty()) {
			matrixStack.pushPose();
			matrixStack.translate(0.5, -0.3, 0.5);
			matrixStack.mulPose(Axis.YN.rotationDegrees(clientplayerentity.getYRot()));
			ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
			BakedModel ibakedmodel = itemRenderer.getModel(stack, tileEntity.getLevel(), null, combinedOverlay);
			itemRenderer.render(stack, ItemDisplayContext.GROUND, true, matrixStack, buffer, combinedLight, combinedOverlay, ibakedmodel);
			matrixStack.popPose();
		}
	}
}