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
import com.technologica.registration.deferred.TechnologicaMobEffects;

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
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent.Stage;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RenderLevelStageEventListener {
	private VertexBuffer sonarBuffer;
	private static int timer;

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

		if (event.getStage() == Stage.AFTER_SOLID_BLOCKS && timer > 0) {
			MultiBufferSource.BufferSource multibuffersource$buffersource = minecraft.renderBuffers().bufferSource();
			VertexConsumer vertexConsumer = multibuffersource$buffersource.getBuffer(RenderType.lines());
			BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
			if (this.sonarBuffer != null) {
				this.sonarBuffer.close();
			}
			this.sonarBuffer = new VertexBuffer(VertexBuffer.Usage.STATIC);
			BufferBuilder.RenderedBuffer bufferbuilder$renderedbuffer = this.buildSonar(bufferbuilder, vertexConsumer, event.getPoseStack(), event.getCamera().getEntity(), event);
			this.sonarBuffer.bind();
			this.sonarBuffer.upload(bufferbuilder$renderedbuffer);
			VertexBuffer.unbind();

			if (this.sonarBuffer != null) {
				this.sonarBuffer.bind();
				ShaderInstance shaderinstance = RenderSystem.getShader();
				this.sonarBuffer.drawWithShader(event.getPoseStack().last().pose(), event.getProjectionMatrix(), shaderinstance);
			}
		}
		timer--;
	}

	private RenderedBuffer buildSonar(BufferBuilder bufferBuilder, VertexConsumer vertexConsumer, PoseStack poseStack, Entity entity, final RenderLevelStageEvent event) {
		int radius = 16;
		Minecraft mc = Minecraft.getInstance();
		BlockPos pos = entity.blockPosition();
		Vec3 vec3 = event.getCamera().getPosition();
		double d0 = vec3.x();
		double d1 = vec3.y();
		double d2 = vec3.z();
		bufferBuilder.begin(VertexFormat.Mode.LINES, DefaultVertexFormat.POSITION_COLOR_NORMAL);

		for (int posX = pos.getX() - radius; posX < pos.getX() + radius; posX++) {
			for (int posY = pos.getY() - radius; posY < pos.getY() + radius; posY++) {
				for (int posZ = pos.getZ() - radius; posZ < pos.getZ() + radius; posZ++) {

					BlockPos blockPos = new BlockPos(posX, posY, posZ);
					BlockState blockState = mc.level.getBlockState(blockPos);
					if (blockState.getRenderShape() != RenderShape.INVISIBLE) {
						PoseStack.Pose posestack$pose = poseStack.last();
						VoxelShape voxelShape = blockState.getShape(mc.level, blockPos, CollisionContext.of(entity));

						double posX2 = blockPos.getX() - d0;
						double posY2 = blockPos.getY() - d1;
						double posZ2 = blockPos.getZ() - d2;

						float distance = (float) Math.sqrt((posX - pos.getX()) * (posX - pos.getX()) + (posY - pos.getY()) * (posY - pos.getY()) + (posZ - pos.getZ()) * (posZ - pos.getZ()));
						if (distance < radius) {
							float alpha = Mth.clamp(distance + (timer - mc.getPartialTick() - 4800) / 50 < 1 ? distance + (timer - mc.getPartialTick() - 4800) / 50 : -distance + (-timer - mc.getPartialTick() + 5001) / 50, 0.0F, 1.0F) * (1 - distance / radius);

							voxelShape.forAllEdges((p_234280_, p_234281_, p_234282_, p_234283_, p_234284_, p_234285_) -> {
								float f = (float) (p_234283_ - p_234280_);
								float f1 = (float) (p_234284_ - p_234281_);
								float f2 = (float) (p_234285_ - p_234282_);
								float f3 = Mth.sqrt(f * f + f1 * f1 + f2 * f2);
								f /= f3;
								f1 /= f3;
								f2 /= f3;
								vertexConsumer.vertex(posestack$pose.pose(), (float) (p_234280_ + posX2), (float) (p_234281_ + posY2), (float) (p_234282_ + posZ2)).color(0, 1, 0, alpha).normal(posestack$pose.normal(), f, f1, f2).endVertex();
								vertexConsumer.vertex(posestack$pose.pose(), (float) (p_234283_ + posX2), (float) (p_234284_ + posY2), (float) (p_234285_ + posZ2)).color(0, 1, 0, alpha).normal(posestack$pose.normal(), f, f1, f2).endVertex();
							});
						}
					}
				}
			}
		}
		return bufferBuilder.end();
	}

	public static void setTime() {
		timer = 5000;
	}
}
