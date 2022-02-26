package com.technologica.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.technologica.world.level.block.TechnologicaBlocks;
import com.technologica.world.level.block.TwelveDirectionBlock;
import com.technologica.world.level.block.entity.LineShaftHangerTileEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;

public class LineShaftHangerRenderer implements BlockEntityRenderer<LineShaftHangerTileEntity> {

	public LineShaftHangerRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {

	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(LineShaftHangerTileEntity tileEntity, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
		if (tileEntity.getShaft()) {
			long time = System.currentTimeMillis() * 6 * (int) tileEntity.getRPM() / 1000;
			float angle = time % 360;
			BlockRenderDispatcher blockrendererdispatcher = Minecraft.getInstance().getBlockRenderer();
			ModelBlockRenderer blockModelRenderer = blockrendererdispatcher.getModelRenderer();
			BlockState state;

			matrixStack.pushPose();

			if (tileEntity.getBlockState().getValue(TwelveDirectionBlock.AXIS) == Direction.Axis.X) {
				state = TechnologicaBlocks.LINE_SHAFT.get().defaultBlockState().setValue(TwelveDirectionBlock.AXIS, Direction.Axis.X);
				matrixStack.translate(0.0, 0.5, 0.5);
				matrixStack.mulPose(Vector3f.XP.rotationDegrees(angle));
				matrixStack.translate(0.0, -0.5, -0.5);
			} else if (tileEntity.getBlockState().getValue(TwelveDirectionBlock.AXIS) == Direction.Axis.Y) {
				state = TechnologicaBlocks.LINE_SHAFT.get().defaultBlockState().setValue(TwelveDirectionBlock.AXIS, Direction.Axis.Y);
				matrixStack.translate(0.5, 0.0, 0.5);
				matrixStack.mulPose(Vector3f.YP.rotationDegrees(angle));
				matrixStack.translate(-0.5, 0.0, -0.5);
			} else {
				state = TechnologicaBlocks.LINE_SHAFT.get().defaultBlockState().setValue(TwelveDirectionBlock.AXIS, Direction.Axis.Z);
				matrixStack.translate(0.5, 0.5, 0.0);
				matrixStack.mulPose(Vector3f.ZP.rotationDegrees(angle));
				matrixStack.translate(-0.5, -0.5, 0.0);
			}
			blockModelRenderer.renderModel(matrixStack.last(), buffer.getBuffer(RenderType.solid()), state, blockrendererdispatcher.getBlockModel(state), 0.0F, 0.0F, 0.0F, combinedOverlay, combinedOverlay);
			matrixStack.popPose();
		}
	}
}
