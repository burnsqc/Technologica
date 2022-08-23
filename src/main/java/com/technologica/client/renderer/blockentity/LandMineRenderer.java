package com.technologica.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.technologica.world.level.block.entity.LandMineBlockEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.ModelData;

public class LandMineRenderer implements BlockEntityRenderer<LandMineBlockEntity> {
	public LandMineRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
	}

	@Override
	public void render(LandMineBlockEntity tileEntity, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
		BlockState state = tileEntity.getPreviousBlockState();
		BlockRenderDispatcher blockrendererdispatcher = Minecraft.getInstance().getBlockRenderer();

		matrixStack.pushPose();
		blockrendererdispatcher.renderSingleBlock(state, matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, RenderType.cutoutMipped());
		matrixStack.popPose();
	}
}