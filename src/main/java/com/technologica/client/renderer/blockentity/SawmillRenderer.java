package com.technologica.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import com.technologica.world.item.TechnologicaItems;
import com.technologica.world.level.block.SawmillBlock;
import com.technologica.world.level.block.entity.SawmillBlockEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

public class SawmillRenderer implements BlockEntityRenderer<SawmillBlockEntity> {
	public SawmillRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(SawmillBlockEntity tileEntity, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
		ItemStack stack = tileEntity.getLog();

		Block log = Block.byItem(stack.getItem());
		BlockRenderDispatcher blockrendererdispatcher = Minecraft.getInstance().getBlockRenderer();
		ModelBlockRenderer blockModelRenderer = blockrendererdispatcher.getModelRenderer();

		ItemStack blade = new ItemStack(TechnologicaItems.SAWBLADE.get().asItem(), 1);
		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
		BakedModel ibakedmodel = itemRenderer.getModel(blade, tileEntity.getLevel(), null, combinedOverlay);

		if (tileEntity.getBlade()) {

			matrixStack.pushPose();
			matrixStack.translate(0.5, 0.9, 0.5);
			switch (tileEntity.getBlockState().getValue(SawmillBlock.NESW_FACING)) {
			case NORTH:
				matrixStack.mulPose(Vector3f.YP.rotationDegrees(90));
				break;
			case EAST:
				break;
			case SOUTH:
				matrixStack.mulPose(Vector3f.YP.rotationDegrees(270));
				break;
			case WEST:
				matrixStack.mulPose(Vector3f.YP.rotationDegrees(180));
				break;
			default:
				break;
			}

			matrixStack.mulPose(angle());
			matrixStack.scale(2.25F, 2.25F, 1.0F);
			itemRenderer.render(blade, ItemTransforms.TransformType.NONE, true, matrixStack, buffer, combinedLight, combinedOverlay, ibakedmodel);
			matrixStack.popPose();
		}

		if (!stack.isEmpty()) {
			matrixStack.pushPose();
			BlockState state = log.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X);

			switch (tileEntity.getBlockState().getValue(SawmillBlock.NESW_FACING)) {
			case NORTH:
				matrixStack.mulPose(Vector3f.YP.rotationDegrees(90));
				matrixStack.translate(tileEntity.getLogPos() - 1, 1.0, 0.0);
				break;
			case EAST:
				matrixStack.translate(tileEntity.getLogPos(), 1.0, 0.0);
				break;
			case SOUTH:
				matrixStack.mulPose(Vector3f.YP.rotationDegrees(270));
				matrixStack.translate(tileEntity.getLogPos(), 1.0, -1.0);
				break;
			case WEST:
				matrixStack.mulPose(Vector3f.YP.rotationDegrees(180));
				matrixStack.translate(tileEntity.getLogPos() - 1, 1.0, -1.0);
				break;
			default:
				break;
			}

			blockModelRenderer.renderModel(matrixStack.last(), buffer.getBuffer(RenderType.solid()), state, blockrendererdispatcher.getBlockModel(state), 0.0F, 0.0F, 0.0F, combinedLight, combinedOverlay);
			matrixStack.popPose();
		}
	}

	private Quaternion angle() {
		long time = System.currentTimeMillis();
		float angle = time % 360 / 2;
		Vector3f vector = Vector3f.ZP;

		return vector.rotationDegrees(angle);
	}
}