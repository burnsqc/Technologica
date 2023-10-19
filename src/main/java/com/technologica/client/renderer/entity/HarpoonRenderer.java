package com.technologica.client.renderer.entity;

import org.joml.Matrix3f;
import org.joml.Matrix4f;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.technologica.Technologica;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.projectile.AbstractArrow;

public class HarpoonRenderer<T extends AbstractArrow> extends EntityRenderer<T> {
	public static final ResourceLocation HARPOON = new ResourceLocation(Technologica.MODID, "textures/entity/projectiles/harpoon.png");

	public HarpoonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public void render(T entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
		matrixStackIn.pushPose();
		matrixStackIn.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90.0F));
		matrixStackIn.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		float shake = entityIn.shakeTime - partialTicks;
		if (shake > 0.0F) {
			float f10 = -Mth.sin(shake * 3.0F) * shake;
			matrixStackIn.mulPose(Axis.ZP.rotationDegrees(f10));
		}
		matrixStackIn.mulPose(Axis.XP.rotationDegrees(45.0F));
		matrixStackIn.scale(0.05625F, 0.05625F, 0.05625F);
		matrixStackIn.translate(-4.0D, 0.0D, 0.0D);
		VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		PoseStack.Pose matrixstack$entry = matrixStackIn.last();
		Matrix4f matrix4f = matrixstack$entry.pose();
		Matrix3f matrix3f = matrixstack$entry.normal();
		for (int j = 0; j < 4; ++j) {
			matrixStackIn.mulPose(Axis.XP.rotationDegrees(90.0F));
			this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -8, -2, 0, 0.0F, 0.0F, 0, 1, 0, packedLightIn);
			this.drawVertex(matrix4f, matrix3f, ivertexbuilder, 8, -2, 0, 0.75F, 0.0F, 0, 1, 0, packedLightIn);
			this.drawVertex(matrix4f, matrix3f, ivertexbuilder, 8, 2, 0, 0.75F, 0.15625F, 0, 1, 0, packedLightIn);
			this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -8, 2, 0, 0.0F, 0.15625F, 0, 1, 0, packedLightIn);
		}
		matrixStackIn.popPose();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	public void drawVertex(Matrix4f matrix, Matrix3f normals, VertexConsumer vertexBuilder, int offsetX, int offsetY, int offsetZ, float textureX, float textureY, int normalX, int p_229039_10_, int p_229039_11_, int packedLightIn) {
		vertexBuilder.vertex(matrix, offsetX, offsetY, offsetZ).color(255, 255, 255, 255).uv(textureX, textureY).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLightIn).normal(normals, normalX, p_229039_11_, p_229039_10_).endVertex();
	}

	@Override
	public ResourceLocation getTextureLocation(T entity) {
		return HARPOON;
	}
}