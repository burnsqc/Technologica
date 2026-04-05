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
	public void render(AnnunciatorBlockEntity annunciatorBlockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int combinedLightIn, int combinedOverlayIn) {
		BlockState blockState = annunciatorBlockEntity.getBlockState();
		float f1 = -blockState.getValue(AnnunciatorBlock.FACING).toYRot();
		poseStack.pushPose();
		poseStack.translate(0.5D, 0.5D, 0.5D);
		poseStack.mulPose(Axis.YP.rotationDegrees(f1));
		poseStack.translate(0.0D, 0.18D, 0.51D);
		poseStack.scale(0.009F, -0.009F, 0.009F);
		for (int k1 = 0; k1 < 8; ++k1) {
			FormattedCharSequence ireorderingprocessor = annunciatorBlockEntity.reorderText(k1, (component) -> {
				List<FormattedCharSequence> list = font.split(component, 90);
				return list.isEmpty() ? FormattedCharSequence.EMPTY : list.get(0);
			});
			if (ireorderingprocessor != null) {
				float f3 = -font.width(ireorderingprocessor) / 2;
				font.drawInBatch(ireorderingprocessor, f3, k1 * 10 - 20, 0, false, poseStack.last().pose(), multiBufferSource, Font.DisplayMode.POLYGON_OFFSET, 0, combinedLightIn);
			}
		}
		poseStack.popPose();
	}
}