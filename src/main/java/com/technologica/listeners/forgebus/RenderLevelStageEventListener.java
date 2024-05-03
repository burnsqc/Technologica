package com.technologica.listeners.forgebus;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.technologica.registration.deferred.TechnologicaMobEffects;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent.Stage;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RenderLevelStageEventListener {
	@SubscribeEvent
	public void onRenderLevelStageEvent(final RenderLevelStageEvent event) {
		Minecraft minecraft = Minecraft.getInstance();
		LocalPlayer localPlayer = minecraft.player;

		if (localPlayer.hasEffect(TechnologicaMobEffects.HALLUCINIATION.get())) {
			if (minecraft.gameRenderer.currentEffect() == null) {
				minecraft.gameRenderer.loadEffect(new ResourceLocation("shaders/post/invert.json"));
			}
		} else {
			if (minecraft.gameRenderer.currentEffect() != null) {
				if (minecraft.gameRenderer.currentEffect().getName().equals(new ResourceLocation("shaders/post/invert.json").toString())) {
					minecraft.gameRenderer.shutdownEffect();
				}
			}
		}

		Vec3 vec3 = event.getCamera().getPosition();
		double d0 = vec3.x();
		double d1 = vec3.y();
		double d2 = vec3.z();

		if (event.getStage() == Stage.AFTER_SOLID_BLOCKS) {
			BlockPos pos = event.getCamera().getBlockPosition();

			for (int posX = pos.getX() - 10; posX < pos.getX() + 10; posX++) {
				for (int posY = pos.getY() - 10; posY < pos.getY() + 10; posY++) {
					for (int posZ = pos.getZ() - 10; posZ < pos.getZ() + 10; posZ++) {
						BlockPos blockPos = new BlockPos(posX, posY, posZ);
						BlockState blockState = minecraft.level.getBlockState(blockPos);

						MultiBufferSource.BufferSource multibuffersource$buffersource = minecraft.renderBuffers().bufferSource();
						VertexConsumer vertexConsumer = multibuffersource$buffersource.getBuffer(RenderType.lines());

						this.renderHitOutline(event.getPoseStack(), vertexConsumer, event.getCamera().getEntity(), d0, d1, d2, blockPos, blockState);
					}
				}
			}
		}

	}

	private void renderHitOutline(PoseStack poseStack, VertexConsumer vertexConsumer, Entity entity, double p_109641_, double p_109642_, double p_109643_, BlockPos blockPos, BlockState blockState) {
		Minecraft mc = Minecraft.getInstance();
		renderShape(poseStack, vertexConsumer, blockState.getShape(mc.level, blockPos, CollisionContext.of(entity)), blockPos.getX() - p_109641_, blockPos.getY() - p_109642_, blockPos.getZ() - p_109643_, 0.0F, 1.0F, 0.0F, 1.0F);
	}

	private static void renderShape(PoseStack poseStack, VertexConsumer vertexConsumer, VoxelShape voxelShape, double p_109786_, double p_109787_, double p_109788_, float p_109789_, float p_109790_, float p_109791_, float p_109792_) {
		PoseStack.Pose posestack$pose = poseStack.last();
		voxelShape.forAllEdges((p_234280_, p_234281_, p_234282_, p_234283_, p_234284_, p_234285_) -> {
			float f = (float) (p_234283_ - p_234280_);
			float f1 = (float) (p_234284_ - p_234281_);
			float f2 = (float) (p_234285_ - p_234282_);
			float f3 = Mth.sqrt(f * f + f1 * f1 + f2 * f2);
			f /= f3;
			f1 /= f3;
			f2 /= f3;
			vertexConsumer.vertex(posestack$pose.pose(), (float) (p_234280_ + p_109786_), (float) (p_234281_ + p_109787_), (float) (p_234282_ + p_109788_)).color(p_109789_, p_109790_, p_109791_, p_109792_).normal(posestack$pose.normal(), f, f1, f2).endVertex();
			vertexConsumer.vertex(posestack$pose.pose(), (float) (p_234283_ + p_109786_), (float) (p_234284_ + p_109787_), (float) (p_234285_ + p_109788_)).color(p_109789_, p_109790_, p_109791_, p_109792_).normal(posestack$pose.normal(), f, f1, f2).endVertex();
		});
	}

}
