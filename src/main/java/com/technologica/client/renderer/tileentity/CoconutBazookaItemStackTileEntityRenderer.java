package com.technologica.client.renderer.tileentity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.technologica.client.renderer.entity.model.CoconutBazookaModel;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.ItemStack;

public class CoconutBazookaItemStackTileEntityRenderer extends ItemStackTileEntityRenderer {
	private final CoconutBazookaModel coconutBazooka = new CoconutBazookaModel();

	@Override
	public void renderByItem(ItemStack stack, TransformType p_239207_2_, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
		matrixStack.pushPose();
		IVertexBuilder ivertexbuilder1 = ItemRenderer.getFoilBufferDirect(buffer, this.coconutBazooka.renderType(CoconutBazookaModel.TEXTURE_LOCATION), false, false);
		this.coconutBazooka.renderToBuffer(matrixStack, ivertexbuilder1, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
		matrixStack.popPose();
	}
}
