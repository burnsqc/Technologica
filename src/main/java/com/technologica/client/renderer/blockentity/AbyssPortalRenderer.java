package com.technologica.client.renderer.blockentity;

import org.joml.Matrix4f;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.technologica.world.level.block.entity.AbyssPortalBlockEntity;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;

public class AbyssPortalRenderer<T extends AbyssPortalBlockEntity> implements BlockEntityRenderer<T> {
	public static final ResourceLocation END_SKY_LOCATION = new ResourceLocation("textures/environment/end_sky.png");
	public static final ResourceLocation END_PORTAL_LOCATION = new ResourceLocation("textures/entity/end_portal.png");

	public AbyssPortalRenderer(BlockEntityRendererProvider.Context context) {
	}

	@Override
	public void render(T abyssPortalBlockEntity, float p_112651_, PoseStack poseStack, MultiBufferSource multiBufferSource, int p_112654_, int p_112655_) {
		Matrix4f matrix4f = poseStack.last().pose();
		this.renderCube(abyssPortalBlockEntity, matrix4f, multiBufferSource.getBuffer(RenderType.endPortal()));
	}

	private void renderCube(T abyssPortalBlockEntity, Matrix4f matrix4f, VertexConsumer vertexConsumer) {
		this.renderFace(abyssPortalBlockEntity, matrix4f, vertexConsumer, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, Direction.SOUTH);
		this.renderFace(abyssPortalBlockEntity, matrix4f, vertexConsumer, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, Direction.NORTH);
		this.renderFace(abyssPortalBlockEntity, matrix4f, vertexConsumer, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, Direction.EAST);
		this.renderFace(abyssPortalBlockEntity, matrix4f, vertexConsumer, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, Direction.WEST);
		this.renderFace(abyssPortalBlockEntity, matrix4f, vertexConsumer, 0.0F, 1.0F, 0.375F, 0.375F, 0.0F, 0.0F, 1.0F, 1.0F, Direction.DOWN);
		this.renderFace(abyssPortalBlockEntity, matrix4f, vertexConsumer, 0.0F, 1.0F, 0.75F, 0.75F, 1.0F, 1.0F, 0.0F, 0.0F, Direction.UP);
	}

	private void renderFace(T abyssPortalBlockEntity, Matrix4f matrix4f, VertexConsumer p_254390_, float p_254147_, float p_253639_, float p_254107_, float p_254109_, float p_254021_, float p_254458_, float p_254086_, float p_254310_, Direction direction) {
		if (abyssPortalBlockEntity.shouldRenderFace(direction)) {
			p_254390_.vertex(matrix4f, p_254147_, p_254107_, p_254021_).endVertex();
			p_254390_.vertex(matrix4f, p_253639_, p_254107_, p_254458_).endVertex();
			p_254390_.vertex(matrix4f, p_253639_, p_254109_, p_254086_).endVertex();
			p_254390_.vertex(matrix4f, p_254147_, p_254109_, p_254310_).endVertex();
		}
	}
}
