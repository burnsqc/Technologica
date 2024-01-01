package com.technologica.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.technologica.client.model.CoconutBazookaModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;

import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class CoconutBazookaRenderer extends BlockEntityWithoutLevelRenderer {
	private final CoconutBazookaModel coconutBazooka;

	public CoconutBazookaRenderer(BlockEntityRenderDispatcher p_172550_, EntityModelSet p_172551_) {
		super(p_172550_, p_172551_);
		this.coconutBazooka = new CoconutBazookaModel(p_172551_.bakeLayer(TechnologicaModelLayers.COCONUT_BAZOOKA));
	}

	@Override
	public void renderByItem(ItemStack stack, ItemDisplayContext p_239207_2_, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
		matrixStack.pushPose();
		VertexConsumer ivertexbuilder1 = ItemRenderer.getFoilBufferDirect(buffer, this.coconutBazooka.renderType(CoconutBazookaModel.TEXTURE_LOCATION), false, false);
		this.coconutBazooka.renderToBuffer(matrixStack, ivertexbuilder1, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
		matrixStack.popPose();
	}
}