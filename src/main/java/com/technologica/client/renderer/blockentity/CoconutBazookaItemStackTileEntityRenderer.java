package com.technologica.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.technologica.client.model.CoconutBazookaModel;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.ItemStack;

public class CoconutBazookaItemStackTileEntityRenderer extends BlockEntityWithoutLevelRenderer {
	public CoconutBazookaItemStackTileEntityRenderer(BlockEntityRenderDispatcher p_172550_, EntityModelSet p_172551_) {
		super(p_172550_, p_172551_);
		// TODO Auto-generated constructor stub
	}

	private final CoconutBazookaModel coconutBazooka = new CoconutBazookaModel();

	@Override
	public void renderByItem(ItemStack stack, TransformType p_239207_2_, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
		matrixStack.pushPose();
		VertexConsumer ivertexbuilder1 = ItemRenderer.getFoilBufferDirect(buffer, this.coconutBazooka.renderType(CoconutBazookaModel.TEXTURE_LOCATION), false, false);
		this.coconutBazooka.renderToBuffer(matrixStack, ivertexbuilder1, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
		matrixStack.popPose();
	}
}
