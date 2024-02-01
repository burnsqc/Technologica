package com.technologica.client.renderer.blockentity;

import org.joml.Quaternionf;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.technologica.client.model.WindmillModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.level.block.FourDirectionBlock;
import com.technologica.world.level.block.entity.WindmillBlockEntity;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class WindmillRenderer implements BlockEntityRenderer<WindmillBlockEntity> {
	protected final WindmillModel<Entity> windmillModel;
	private static final ResourceLocation WINDMILL_TEXTURE = new TechnologicaLocation("textures/entity/windmill.png");

	public WindmillRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
		this.windmillModel = new WindmillModel<>(rendererDispatcherIn.bakeLayer(TechnologicaModelLayers.WINDMILL));
	}

	@Override
	public void render(WindmillBlockEntity windmillBlockEntity, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
		matrixStack.pushPose();
		VertexConsumer vertexconsumer = buffer.getBuffer(this.windmillModel.renderType(WINDMILL_TEXTURE));
		long i = windmillBlockEntity.getLevel().getGameTime();

		if (windmillBlockEntity.getBlockState().getValue(FourDirectionBlock.NESW_FACING) == Direction.NORTH) {
			matrixStack.translate(0.5, 0.5, 0.0);
			matrixStack.mulPose(Axis.XP.rotationDegrees(90));
			matrixStack.mulPose(this.angle(i, partialTicks));
			matrixStack.translate(0.0, -0.5, 0.0);
		} else if (windmillBlockEntity.getBlockState().getValue(FourDirectionBlock.NESW_FACING) == Direction.EAST) {
			matrixStack.translate(1.0, 0.5, 0.5);
			matrixStack.mulPose(Axis.YP.rotationDegrees(270));
			matrixStack.mulPose(Axis.XP.rotationDegrees(90));
			matrixStack.mulPose(this.angle(i, partialTicks));
			matrixStack.translate(0.0, -0.5, 0.0);
		} else if (windmillBlockEntity.getBlockState().getValue(FourDirectionBlock.NESW_FACING) == Direction.SOUTH) {
			matrixStack.translate(0.5, 0.5, 1.0);
			matrixStack.mulPose(Axis.XP.rotationDegrees(270));
			matrixStack.mulPose(this.angle(i, partialTicks));
			matrixStack.translate(0.0, -0.5, 0.0);
		} else {
			matrixStack.translate(0.0, 0.5, 0.5);
			matrixStack.mulPose(Axis.YP.rotationDegrees(90));
			matrixStack.mulPose(Axis.XP.rotationDegrees(90));
			matrixStack.mulPose(this.angle(i, partialTicks));
			matrixStack.translate(0.0, -0.5, -0.0);
		}

		this.windmillModel.renderToBuffer(matrixStack, vertexconsumer, combinedLight, combinedOverlay, 1, 1, 1, 1);
		matrixStack.popPose();
	}

	private Quaternionf angle(long time, float partialTicks) {
		float time2 = (time + partialTicks);
		return Axis.YP.rotationDegrees(time2);
	}
}