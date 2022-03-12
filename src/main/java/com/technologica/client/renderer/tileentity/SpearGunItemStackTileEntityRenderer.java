package com.technologica.client.renderer.tileentity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.technologica.client.renderer.entity.model.SpearGunModel;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.ItemStack;

public class SpearGunItemStackTileEntityRenderer extends ItemStackTileEntityRenderer {
	private final SpearGunModel spearGun = new SpearGunModel();

	@Override
	public void func_239207_a_(ItemStack stack, ItemCameraTransforms.TransformType p_239207_2_, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
		matrixStack.push();
		IVertexBuilder ivertexbuilder1 = ItemRenderer.getEntityGlintVertexBuilder(buffer, this.spearGun.getRenderType(SpearGunModel.TEXTURE_LOCATION), false, false);
		this.spearGun.render(matrixStack, ivertexbuilder1, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
		matrixStack.pop();
	}
}