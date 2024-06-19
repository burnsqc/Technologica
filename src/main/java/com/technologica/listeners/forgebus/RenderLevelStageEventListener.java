package com.technologica.listeners.forgebus;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferBuilder.RenderedBuffer;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.technologica.Technologica;
import com.technologica.registration.deferred.TechnologicaMobEffects;
import com.technologica.util.math.MathHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent.Stage;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class RenderLevelStageEventListener {
	private static VertexBuffer sonarBuffer;
	private static int timer;

	@SubscribeEvent
	public static void onRenderLevelStageEvent(final RenderLevelStageEvent event) {
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

		if (event.getStage() == Stage.AFTER_SOLID_BLOCKS && timer > 0) {
			MultiBufferSource.BufferSource multibuffersource$buffersource = minecraft.renderBuffers().bufferSource();
			VertexConsumer vertexConsumer = multibuffersource$buffersource.getBuffer(RenderType.lines());
			BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
			if (sonarBuffer != null) {
				sonarBuffer.close();
			}
			sonarBuffer = new VertexBuffer(VertexBuffer.Usage.STATIC);
			BufferBuilder.RenderedBuffer bufferbuilder$renderedbuffer = buildSonar(bufferbuilder, vertexConsumer, event.getPoseStack(), event.getCamera().getEntity(), event);
			sonarBuffer.bind();
			sonarBuffer.upload(bufferbuilder$renderedbuffer);
			VertexBuffer.unbind();

			if (sonarBuffer != null) {
				sonarBuffer.bind();
				ShaderInstance shaderinstance = RenderSystem.getShader();
				sonarBuffer.drawWithShader(event.getPoseStack().last().pose(), event.getProjectionMatrix(), shaderinstance);
			}
		}
		timer--;
	}

	private static RenderedBuffer buildSonar(BufferBuilder bufferBuilder, VertexConsumer vertexConsumer, PoseStack poseStack, Entity entity, final RenderLevelStageEvent event) {
		int maxDistance = 32;
		Minecraft minecraft = Minecraft.getInstance();
		BlockPos playerPos = entity.blockPosition();
		Vec3 vec3 = event.getCamera().getPosition();
		double d0 = vec3.x();
		double d1 = vec3.y();
		double d2 = vec3.z();
		bufferBuilder.begin(VertexFormat.Mode.LINES, DefaultVertexFormat.POSITION_COLOR_NORMAL);

		int totalpos = 0;
		int visible = 0;
		int inFrustum = 0;
		int inRange = 0;
		int outline = 0;

		for (int posX = playerPos.getX() - maxDistance; posX < playerPos.getX() + maxDistance; posX++) {
			for (int posY = playerPos.getY() - maxDistance; posY < playerPos.getY() + maxDistance; posY++) {
				for (int posZ = playerPos.getZ() - maxDistance; posZ < playerPos.getZ() + maxDistance; posZ++) {
					BlockPos blockPos = new BlockPos(posX, posY, posZ);
					BlockState blockState = minecraft.level.getBlockState(blockPos);

					if (blockState.getRenderShape() != RenderShape.INVISIBLE) {
						VoxelShape voxelShape = blockState.getShape(minecraft.level, blockPos, CollisionContext.of(entity));
						if (event.getFrustum().isVisible(voxelShape.bounds().move(blockPos))) {
							float distance = MathHelper.trueBlockPosDistance(blockPos.getX(), blockPos.getY(), blockPos.getZ(), playerPos.getX(), playerPos.getY(), playerPos.getZ());

							if (distance < maxDistance) {
								float alpha = Mth.clamp(distance + (timer - minecraft.getPartialTick() - 2800) / 50 < 1 ? distance + (timer - minecraft.getPartialTick() - 2800) / 50 : -distance + (-timer - minecraft.getPartialTick() + 3001) / 50, 0.0F, 1.0F) * (1 - distance / maxDistance);
								if (alpha > 0) {
									PoseStack.Pose posestack$pose = poseStack.last();
									double posX2 = blockPos.getX() - d0;
									double posY2 = blockPos.getY() - d1;
									double posZ2 = blockPos.getZ() - d2;

									voxelShape.forAllEdges((voxelX1, voxelY1, voxelZ1, voxelX2, voxelY2, voxelZ2) -> {
										float lengthX = (float) (voxelX2 - voxelX1);
										float lengthY = (float) (voxelY2 - voxelY1);
										float lengthZ = (float) (voxelZ2 - voxelZ1);
										float length = Mth.sqrt(lengthX * lengthX + lengthY * lengthY + lengthZ * lengthZ);

										lengthX /= length;
										lengthY /= length;
										lengthZ /= length;

										vertexConsumer.vertex(posestack$pose.pose(), (float) (voxelX1 + posX2), (float) (voxelY1 + posY2), (float) (voxelZ1 + posZ2)).color(0, 1, 0, alpha).normal(posestack$pose.normal(), lengthX, lengthY, lengthZ).endVertex();
										vertexConsumer.vertex(posestack$pose.pose(), (float) (voxelX2 + posX2), (float) (voxelY2 + posY2), (float) (voxelZ2 + posZ2)).color(0, 1, 0, alpha).normal(posestack$pose.normal(), lengthX, lengthY, lengthZ).endVertex();
									});
									outline++;
								}
								inRange++;
							}
							inFrustum++;
						}
						visible++;
					}
					totalpos++;
				}
			}
		}

		Technologica.LOGGER.info("{} positions   {} visible   {} in frustum   {} in range   {} to outline", totalpos, visible, inFrustum, inRange, outline);
		return bufferBuilder.end();
	}

	public static void setTime() {
		timer = 3000;
	}
}
