package com.technologica.client.renderer.tileentity;

import java.util.List;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.technologica.block.AnnunciatorBlock;
import com.technologica.tileentity.AnnunciatorTileEntity;

import net.minecraft.block.BlockState;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.texture.NativeImage;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.math.vector.Vector3f;

public class AnnunciatorTileEntityRenderer extends TileEntityRenderer<AnnunciatorTileEntity> {

	public AnnunciatorTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	public void render(AnnunciatorTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		BlockState blockstate = tileEntityIn.getBlockState();
		float f1 = -blockstate.getValue(AnnunciatorBlock.FACING).toYRot();
		FontRenderer fontrenderer = this.renderer.getFont();
		
		matrixStackIn.pushPose();
		matrixStackIn.translate(0.5D, 0.5D, 0.5D);
		matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(f1));
		matrixStackIn.translate(0.0D, 0.18D, 0.51D);
		matrixStackIn.scale(0.009F, -0.009F, 0.009F);
		
		int i = 0;
		int alpha = blockstate.getValue(AnnunciatorBlock.LIT) ? 0 : 50;

		int j = (int) ((double) NativeImage.getR(i) * 0.4D);
		int k = (int) ((double) NativeImage.getG(i) * 0.4D);
		int l = (int) ((double) NativeImage.getB(i) * 0.4D);
		int i1 = NativeImage.combine(alpha, l, k, j);

		for (int k1 = 0; k1 < 8; ++k1) {
			IReorderingProcessor ireorderingprocessor = tileEntityIn.reorderText(k1, (p_243502_1_) -> {
				List<IReorderingProcessor> list = fontrenderer.split(p_243502_1_, 90);
				return list.isEmpty() ? IReorderingProcessor.EMPTY : list.get(0);
			});
			if (ireorderingprocessor != null) {
				float f3 = (float) (-fontrenderer.width(ireorderingprocessor) / 2);
				fontrenderer.drawInBatch(ireorderingprocessor, f3, (float) (k1 * 10 - 20), i1, false, matrixStackIn.last().pose(), bufferIn, false, 0, combinedLightIn);
			}
		}

		matrixStackIn.popPose();
	}
}
