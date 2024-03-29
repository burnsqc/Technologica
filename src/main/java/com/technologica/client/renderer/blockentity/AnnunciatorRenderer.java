package com.technologica.client.renderer.blockentity;

import java.util.List;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.technologica.world.level.block.AnnunciatorBlock;
import com.technologica.world.level.block.entity.AnnunciatorBlockEntity;

import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.level.block.state.BlockState;

public class AnnunciatorRenderer implements BlockEntityRenderer<AnnunciatorBlockEntity> {
	private final Font font;

	public AnnunciatorRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
		this.font = rendererDispatcherIn.getFont();
	}

	@Override
	public void render(AnnunciatorBlockEntity tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
		BlockState blockstate = tileEntityIn.getBlockState();
		float f1 = -blockstate.getValue(AnnunciatorBlock.FACING).toYRot();
		matrixStackIn.pushPose();
		matrixStackIn.translate(0.5D, 0.5D, 0.5D);
		matrixStackIn.mulPose(Axis.YP.rotationDegrees(f1));
		matrixStackIn.translate(0.0D, 0.18D, 0.51D);
		matrixStackIn.scale(0.009F, -0.009F, 0.009F);
		for (int k1 = 0; k1 < 8; ++k1) {
			FormattedCharSequence ireorderingprocessor = tileEntityIn.reorderText(k1, (p_243502_1_) -> {
				List<FormattedCharSequence> list = font.split(p_243502_1_, 90);
				return list.isEmpty() ? FormattedCharSequence.EMPTY : list.get(0);
			});
			if (ireorderingprocessor != null) {
				float f3 = -font.width(ireorderingprocessor) / 2;
				font.drawInBatch(ireorderingprocessor, f3, k1 * 10 - 20, 0, false, matrixStackIn.last().pose(), bufferIn, Font.DisplayMode.POLYGON_OFFSET, 0, combinedLightIn);
			}
		}
		matrixStackIn.popPose();
	}
}