package com.technologica.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.level.block.MonitorBlock;
import com.technologica.world.level.block.entity.MonitorBlockEntity;

import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;

public class MonitorRenderer implements BlockEntityRenderer<MonitorBlockEntity> {
	private final Font font;
	private static final ResourceLocation FULLSPACE_FONT = new TechnologicaLocation("full_space");
	private static final Style FULLSPACE_FONT_STYLE = Style.EMPTY.withFont(FULLSPACE_FONT);

	public MonitorRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
		this.font = rendererDispatcherIn.getFont();
	}

	@Override
	public void render(MonitorBlockEntity monitorBlockEntity, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
		BlockState blockState = monitorBlockEntity.getBlockState();
		float rotationDegrees = -blockState.getValue(MonitorBlock.FACING).toYRot();
		matrixStackIn.pushPose();
		matrixStackIn.translate(0.5D, 0.5D, 0.5D);
		matrixStackIn.mulPose(Axis.YP.rotationDegrees(rotationDegrees));
		matrixStackIn.translate(0.0D, 0.24D, 0.376D);
		matrixStackIn.scale(0.0013F, -0.0013F, 0.0013F);
		String[] text = monitorBlockEntity.getText();
		for (int row = 0; row < text.length; ++row) {
			Component line = Component.literal(text[row]).setStyle(FULLSPACE_FONT_STYLE);
			font.drawInBatch(line, -240, -60 + row * 12, 0x00FF00, false, matrixStackIn.last().pose(), bufferIn, Font.DisplayMode.POLYGON_OFFSET, 0, combinedLightIn);
		}
		matrixStackIn.popPose();
	}
}
