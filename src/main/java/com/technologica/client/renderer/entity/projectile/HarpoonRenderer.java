package com.technologica.client.renderer.entity.projectile;

import org.joml.Matrix3f;
import org.joml.Matrix4f;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.projectile.AbstractArrow;

public final class HarpoonRenderer<T extends AbstractArrow> extends EntityRenderer<T> {
	public static final ResourceLocation TEXTURE = new TechnologicaLocation("textures/entity/projectiles/harpoon.png");

	public HarpoonRenderer(Context context) {
		super(context);
	}

	@Override
	public ResourceLocation getTextureLocation(T harpoon) {
		return TEXTURE;
	}

	@Override
	public void render(T harpoon, float yaw, float partialTicks, PoseStack postStack, MultiBufferSource multiBufferSource, int packedLight) {
		postStack.pushPose();
		postStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, harpoon.yRotO, harpoon.getYRot()) - 90.0F));
		postStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, harpoon.xRotO, harpoon.getXRot())));
		float shake = harpoon.shakeTime - partialTicks;
		if (shake > 0.0F) {
			float f10 = -Mth.sin(shake * 3.0F) * shake;
			postStack.mulPose(Axis.ZP.rotationDegrees(f10));
		}
		postStack.mulPose(Axis.XP.rotationDegrees(45.0F));
		postStack.scale(0.05625F, 0.05625F, 0.05625F);
		postStack.translate(-4.0D, 0.0D, 0.0D);
		VertexConsumer ivertexbuilder = multiBufferSource.getBuffer(RenderType.entityCutout(this.getTextureLocation(harpoon)));
		PoseStack.Pose pose = postStack.last();
		Matrix4f matrix4f = pose.pose();
		Matrix3f matrix3f = pose.normal();
		for (int j = 0; j < 4; ++j) {
			postStack.mulPose(Axis.XP.rotationDegrees(90.0F));
			this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -8, -2, 0, 0.0F, 0.0F, 0, 1, 0, packedLight);
			this.drawVertex(matrix4f, matrix3f, ivertexbuilder, 8, -2, 0, 0.75F, 0.0F, 0, 1, 0, packedLight);
			this.drawVertex(matrix4f, matrix3f, ivertexbuilder, 8, 2, 0, 0.75F, 0.15625F, 0, 1, 0, packedLight);
			this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -8, 2, 0, 0.0F, 0.15625F, 0, 1, 0, packedLight);
		}
		postStack.popPose();
		super.render(harpoon, yaw, partialTicks, postStack, multiBufferSource, packedLight);
	}

	private void drawVertex(Matrix4f matrix, Matrix3f normals, VertexConsumer vertexBuilder, int offsetX, int offsetY, int offsetZ, float textureX, float textureY, int normalX, int p_229039_10_, int p_229039_11_, int packedLightIn) {
		vertexBuilder.vertex(matrix, offsetX, offsetY, offsetZ).color(255, 255, 255, 255).uv(textureX, textureY).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLightIn).normal(normals, normalX, p_229039_11_, p_229039_10_).endVertex();
	}
}
