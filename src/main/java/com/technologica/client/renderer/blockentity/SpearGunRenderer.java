package com.technologica.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.technologica.client.model.SpearGunModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;

import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.ItemStack;

public class SpearGunRenderer extends BlockEntityWithoutLevelRenderer {
	private final SpearGunModel spearGun;

	public SpearGunRenderer(BlockEntityRenderDispatcher p_172550_, EntityModelSet p_172551_) {
		super(p_172550_, p_172551_);
		this.spearGun = new SpearGunModel(p_172551_.bakeLayer(TechnologicaModelLayers.SPEAR_GUN));
	}

	@Override
	public void renderByItem(ItemStack stack, ItemTransforms.TransformType p_239207_2_, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
		matrixStack.pushPose();
		VertexConsumer ivertexbuilder1 = ItemRenderer.getFoilBufferDirect(buffer, this.spearGun.renderType(SpearGunModel.TEXTURE_LOCATION), false, false);
		this.spearGun.renderToBuffer(matrixStack, ivertexbuilder1, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
		matrixStack.popPose();
	}
}
