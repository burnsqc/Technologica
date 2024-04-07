package com.technologica.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexMultiConsumer;
import com.technologica.client.renderer.TechnologicaRenderType;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.RenderTypeHelper;

public class IgnitionRenderer extends BlockEntityWithoutLevelRenderer {
	private ResourceLocation BASE_MODEL_LOCATION;
	private static ItemRenderer renderer = null;

	public IgnitionRenderer(BlockEntityRenderDispatcher dispatcher, EntityModelSet modelSet, ResourceLocation baseModelLocation) {
		super(dispatcher, modelSet);
		BASE_MODEL_LOCATION = baseModelLocation;
		if (renderer == null) {
			renderer = Minecraft.getInstance().getItemRenderer();
		}
	}

	@Override
	public void renderByItem(ItemStack stack, ItemDisplayContext transformType, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
		poseStack.popPose();
		poseStack.pushPose();
		BakedModel mainModel = Minecraft.getInstance().getModelManager().getModel(BASE_MODEL_LOCATION);
		mainModel = mainModel.applyTransform(transformType, poseStack, transformType == ItemDisplayContext.FIRST_PERSON_LEFT_HAND || transformType == ItemDisplayContext.THIRD_PERSON_LEFT_HAND);
		poseStack.translate(-.5, -.5, -.5);
		for (BakedModel model : mainModel.getRenderPasses(stack, true)) {
			for (RenderType type : model.getRenderTypes(stack, true)) {
				type = RenderTypeHelper.getEntityRenderType(type, true);
				VertexConsumer consumer = VertexMultiConsumer.create(buffer.getBuffer(TechnologicaRenderType.ignition()), buffer.getBuffer(type));
				renderer.renderModelLists(model, stack, packedLight, packedOverlay, poseStack, consumer);
			}
		}
	}
}
