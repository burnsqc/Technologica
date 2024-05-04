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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent.Stage;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RenderLevelStageEventListener {
	private VertexBuffer sonarBuffer;

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

		if (event.getStage() == Stage.AFTER_SOLID_BLOCKS) {
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
	}

	private RenderedBuffer buildSonar(BufferBuilder bufferBuilder, VertexConsumer vertexConsumer, PoseStack poseStack, Entity entity, final RenderLevelStageEvent event) {
		Minecraft mc = Minecraft.getInstance();
		BlockPos pos = event.getCamera().getBlockPosition();
		Vec3 vec3 = event.getCamera().getPosition();
		double d0 = vec3.x();
		double d1 = vec3.y();
		double d2 = vec3.z();
		bufferBuilder.begin(VertexFormat.Mode.LINES, DefaultVertexFormat.POSITION_COLOR_NORMAL);

		for (int posX = pos.getX() - 10; posX < pos.getX() + 10; posX++) {
			for (int posY = pos.getY() - 10; posY < pos.getY() + 10; posY++) {
				for (int posZ = pos.getZ() - 10; posZ < pos.getZ() + 10; posZ++) {

					BlockPos blockPos = new BlockPos(posX, posY, posZ);
					BlockState blockState = mc.level.getBlockState(blockPos);

					PoseStack.Pose posestack$pose = poseStack.last();
					VoxelShape voxelShape = blockState.getShape(mc.level, blockPos, CollisionContext.of(entity));

					double posX2 = blockPos.getX() - d0;
					double posY2 = blockPos.getY() - d1;
					double posZ2 = blockPos.getZ() - d2;

					float red = 0.0F;
					float green = 1.0F;
					float blue = 0.0F;
					float alpha = 1.0F;

					voxelShape.forAllEdges((p_234280_, p_234281_, p_234282_, p_234283_, p_234284_, p_234285_) -> {
						float f = (float) (p_234283_ - p_234280_);
						float f1 = (float) (p_234284_ - p_234281_);
						float f2 = (float) (p_234285_ - p_234282_);
						float f3 = Mth.sqrt(f * f + f1 * f1 + f2 * f2);
						f /= f3;
						f1 /= f3;
						f2 /= f3;
						bufferBuilder.vertex(posestack$pose.pose(), (float) (p_234280_ + posX2), (float) (p_234281_ + posY2), (float) (p_234282_ + posZ2)).color(1, 0, 0, alpha).normal(posestack$pose.normal(), f, f1, f2).endVertex();
						vertexConsumer.vertex(posestack$pose.pose(), (float) (p_234283_ + posX2), (float) (p_234284_ + posY2), (float) (p_234285_ + posZ2)).color(red, green, blue, alpha).normal(posestack$pose.normal(), f, f1, f2).endVertex();
					});

				}
			}
		}
		return bufferBuilder.end();
	}
}
