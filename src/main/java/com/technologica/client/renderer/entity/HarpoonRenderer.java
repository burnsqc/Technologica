package com.technologica.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.technologica.Technologica;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;

public class HarpoonRenderer<T extends AbstractArrowEntity> extends EntityRenderer<T> {
	public static final ResourceLocation HARPOON = new ResourceLocation(Technologica.MODID, "textures/entity/projectiles/harpoon.png");

	public HarpoonRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public void render(T entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		matrixStackIn.pushPose();
		matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.yRotO, entityIn.yRot) - 90.0F));
		matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.xRotO, entityIn.xRot)));
		
		float shake = (float) entityIn.shakeTime - partialTicks;
		if (shake > 0.0F) {
			float f10 = -MathHelper.sin(shake * 3.0F) * shake;
			matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(f10));
		}

		matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(45.0F));
		matrixStackIn.scale(0.05625F, 0.05625F, 0.05625F);
		matrixStackIn.translate(-4.0D, 0.0D, 0.0D);
		IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		MatrixStack.Entry matrixstack$entry = matrixStackIn.last();
		Matrix4f matrix4f = matrixstack$entry.pose();
		Matrix3f matrix3f = matrixstack$entry.normal();
		
		for (int j = 0; j < 4; ++j) {
			matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(90.0F));
			this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -8, -2, 0, 0.0F, 0.0F, 0, 1, 0, packedLightIn);
			this.drawVertex(matrix4f, matrix3f, ivertexbuilder, 8, -2, 0, 0.75F, 0.0F, 0, 1, 0, packedLightIn);
			this.drawVertex(matrix4f, matrix3f, ivertexbuilder, 8, 2, 0, 0.75F, 0.15625F, 0, 1, 0, packedLightIn);
			this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -8, 2, 0, 0.0F, 0.15625F, 0, 1, 0, packedLightIn);
		}
		
		matrixStackIn.popPose();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	public void drawVertex(Matrix4f matrix, Matrix3f normals, IVertexBuilder vertexBuilder, int offsetX, int offsetY, int offsetZ, float textureX, float textureY, int normalX, int p_229039_10_, int p_229039_11_, int packedLightIn) {
		vertexBuilder.vertex(matrix, (float) offsetX, (float) offsetY, (float) offsetZ).color(255, 255, 255, 255).uv(textureX, textureY).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLightIn).normal(normals, (float) normalX, (float) p_229039_11_, (float) p_229039_10_).endVertex();
	}

	@Override
	public ResourceLocation getTextureLocation(T entity) {
		return HARPOON;
	}
}