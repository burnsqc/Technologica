package com.technologica.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.technologica.world.level.block.entity.LandMineBlockEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.ModelData;

public class LandMineRenderer implements BlockEntityRenderer<LandMineBlockEntity> {
	public LandMineRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
	}

	@Override
	public void render(LandMineBlockEntity landMineBlockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource multiSourceBuffer, int combinedLight, int combinedOverlay) {
		BlockState blockState = landMineBlockEntity.getPreviousBlockState();
		poseStack.pushPose();
		BakedModel bakedmodel = Minecraft.getInstance().getBlockRenderer().getBlockModel(blockState);
		for (RenderType renderType : bakedmodel.getRenderTypes(blockState, RandomSource.create(blockState.getSeed(landMineBlockEntity.getBlockPos())), ModelData.EMPTY)) {
			VertexConsumer vertexConsumer = multiSourceBuffer.getBuffer(renderType);
			Minecraft.getInstance().getBlockRenderer().getModelRenderer().tesselateBlock(landMineBlockEntity.getLevel(), bakedmodel, blockState, landMineBlockEntity.getBlockPos(), poseStack, vertexConsumer, true, RandomSource.create(), blockState.getSeed(landMineBlockEntity.getBlockPos()), combinedOverlay, ModelData.EMPTY, renderType);
		}
		poseStack.popPose();
	}
}
