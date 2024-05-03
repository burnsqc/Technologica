package com.technologica.mixin;

import org.spongepowered.asm.mixin.Mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.chunk.ChunkRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@Mixin(ChunkRenderDispatcher.class)
public abstract class MixinBlockOutline {

	// @Inject(method = "compile(FFFLnet/minecraft/client/renderer/ChunkBufferBuilderPack;)Lnet/minecraft/client/renderer/chunk/ChunkRenderDispatcher$RenderChunk$RebuildTask$CompileResults;", at = @At("RETURN"))
	// private void technologica_blockOutline(CallbackInfoReturnable<CompileResults> ci) {
	// Technologica.LOGGER.info("OUTLINE");
	// Minecraft mc = Minecraft.getInstance();
	// Vec3 vec3 = mc.gameRenderer.getMainCamera().getPosition();
	// double d0 = vec3.x();
	// double d1 = vec3.y();
	// double d2 = vec3.z();
	// MultiBufferSource.BufferSource multibuffersource$buffersource = mc.renderBuffers().bufferSource();
	// VertexConsumer vertexConsumer = multibuffersource$buffersource.getBuffer(RenderType.lines());

	// PoseStack poseStack = new PoseStack();
	// renderHitOutline(poseStack, vertexConsumer, mc.gameRenderer.getMainCamera().getEntity(), d0, d1, d2, blockPos, blockState);

	// }

	private void renderHitOutline(PoseStack poseStack, VertexConsumer vertexConsumer, Entity entity, double p_109641_, double p_109642_, double p_109643_, BlockPos blockPos, BlockState blockState) {
		Minecraft mc = Minecraft.getInstance();
		renderShape(poseStack, vertexConsumer, blockState.getShape(mc.level, blockPos, CollisionContext.of(entity)), blockPos.getX() - p_109641_, blockPos.getY() - p_109642_, blockPos.getZ() - p_109643_, 0.0F, 0.0F, 0.0F, 0.4F);
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
