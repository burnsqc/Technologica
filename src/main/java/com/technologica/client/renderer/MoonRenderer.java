package com.technologica.client.renderer;

import java.util.Random;

import javax.annotation.Nullable;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import com.technologica.Technologica;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.ISkyRenderHandler;

public class MoonRenderer implements ISkyRenderHandler {

	@Nullable
	private VertexBuffer starVBO;
	@Nullable
	private VertexBuffer skyVBO;
	@Nullable
	private VertexBuffer sky2VBO;
	private final VertexFormat skyVertexFormat = DefaultVertexFormat.POSITION;
	private static final ResourceLocation SUN_TEXTURES = new ResourceLocation("textures/environment/sun.png");
	private static final ResourceLocation EARTH_TEXTURES = new ResourceLocation(Technologica.MODID, "textures/environment/earth.png");

	public MoonRenderer() {
		super();
	}

	@Override
	public void render(int ticks, float partialTicks, PoseStack matrixStackIn, ClientLevel world, Minecraft mc) {
		this.skyVBO = new VertexBuffer();
		generateStars();

		RenderSystem.disableTexture();
		Vec3 vector3d = world.getSkyColor(mc.gameRenderer.getMainCamera().getPosition(), partialTicks);
		float f = (float) vector3d.x;
		float f1 = (float) vector3d.y;
		float f2 = (float) vector3d.z;
		FogRenderer.levelFogColor();
		BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
		RenderSystem.depthMask(false);

		RenderSystem.setShaderColor(0.0f, 0.0F, 0.0F, 0.0F);
		this.skyVBO.bind();
		this.skyVertexFormat.setupBufferState();
		this.skyVBO.draw();
		VertexBuffer.unbind();
		this.skyVertexFormat.clearBufferState();
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		float[] afloat = world.effects().getSunriseColor(world.getTimeOfDay(partialTicks), partialTicks);
		if (afloat != null) {
			RenderSystem.disableTexture();
			RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
			matrixStackIn.pushPose();
			matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(90.0F));
			float f3 = Mth.sin(world.getSunAngle(partialTicks)) < 0.0F ? 180.0F : 0.0F;
			matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(f3));
			matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
			float f4 = afloat[0];
			float f5 = afloat[1];
			float f6 = afloat[2];
			Matrix4f matrix4f = matrixStackIn.last().pose();
			bufferbuilder.begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION_COLOR);
			bufferbuilder.vertex(matrix4f, 0.0F, 100.0F, 0.0F).color(f4, f5, f6, afloat[3]).endVertex();
			for (int j = 0; j <= 16; ++j) {
				float f7 = (float) j * ((float) Math.PI * 2F) / 16.0F;
				float f8 = Mth.sin(f7);
				float f9 = Mth.cos(f7);
				bufferbuilder.vertex(matrix4f, f8 * 120.0F, f9 * 120.0F, -f9 * 40.0F * afloat[3]).color(afloat[0], afloat[1], afloat[2], 0.0F).endVertex();
			}

			bufferbuilder.end();
			BufferUploader.end(bufferbuilder);
			matrixStackIn.popPose();
		}

		RenderSystem.enableTexture();
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		matrixStackIn.pushPose();
		float f11 = 1.0F - world.getRainLevel(partialTicks);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, f11);
		matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-90.0F));
		matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(45.0F));
		float f12 = 30.0F;
		Matrix4f matrix4f1 = matrixStackIn.last().pose();
		RenderSystem.setShaderTexture(0, EARTH_TEXTURES);
		bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
		bufferbuilder.vertex(matrix4f1, -f12, 70.0F, -f12).uv(0.0F, 0.0F).endVertex();
		bufferbuilder.vertex(matrix4f1, f12, 70.0F, -f12).uv(1.0F, 0.0F).endVertex();
		bufferbuilder.vertex(matrix4f1, f12, 70.0F, f12).uv(1.0F, 1.0F).endVertex();
		bufferbuilder.vertex(matrix4f1, -f12, 70.0F, f12).uv(0.0F, 1.0F).endVertex();
		bufferbuilder.end();
		BufferUploader.end(bufferbuilder);

		matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(-45.0F));
		
		matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(world.getTimeOfDay(partialTicks) * 360.0F));
		matrix4f1 = matrixStackIn.last().pose();

		RenderSystem.setShaderTexture(0, SUN_TEXTURES);
		bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
		bufferbuilder.vertex(matrix4f1, -f12, 100.0F, -f12).uv(0.0F, 0.0F).endVertex();
		bufferbuilder.vertex(matrix4f1, f12, 100.0F, -f12).uv(1.0F, 0.0F).endVertex();
		bufferbuilder.vertex(matrix4f1, f12, 100.0F, f12).uv(1.0F, 1.0F).endVertex();
		bufferbuilder.vertex(matrix4f1, -f12, 100.0F, f12).uv(0.0F, 1.0F).endVertex();
		bufferbuilder.end();
		BufferUploader.end(bufferbuilder);

		RenderSystem.disableTexture();

		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		this.starVBO.bind();
		this.skyVertexFormat.setupBufferState();
		this.starVBO.draw();
		VertexBuffer.unbind();
		this.skyVertexFormat.clearBufferState();

		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.disableBlend();
		

		matrixStackIn.popPose();

		RenderSystem.disableTexture();
		RenderSystem.setShaderColor(0.0F, 0.0F, 0.0F, 1.0F);

		if (world.effects().hasGround()) {
			RenderSystem.setShaderColor(f * 0.2F + 0.04F, f1 * 0.2F + 0.04F, f2 * 0.6F + 0.1F, 1.0F);
		} else {
			RenderSystem.setShaderColor(f, f1, f2, 1.0F);
		}

		RenderSystem.enableTexture();
		RenderSystem.depthMask(true);
	}

	private void generateStars() {
		Tesselator tessellator = Tesselator.getInstance();
		BufferBuilder bufferbuilder = tessellator.getBuilder();
		if (this.starVBO != null) {
			this.starVBO.close();
		}

		this.starVBO = new VertexBuffer();
		this.renderStars(bufferbuilder);
		bufferbuilder.end();
		this.starVBO.upload(bufferbuilder);
	}

	private void renderStars(BufferBuilder bufferBuilderIn) {
		Random random = new Random(10842L);
		bufferBuilderIn.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION);

		for (int i = 0; i < 1500; ++i) {
			double d0 = (double) (random.nextFloat() * 2.0F - 1.0F);
			double d1 = (double) (random.nextFloat() * 2.0F - 1.0F);
			double d2 = (double) (random.nextFloat() * 2.0F - 1.0F);
			double d3 = (double) (0.15F + random.nextFloat() * 0.1F);
			double d4 = d0 * d0 + d1 * d1 + d2 * d2;
			if (d4 < 1.0D && d4 > 0.01D) {
				d4 = 1.0D / Math.sqrt(d4);
				d0 = d0 * d4;
				d1 = d1 * d4;
				d2 = d2 * d4;
				double d5 = d0 * 100.0D;
				double d6 = d1 * 100.0D;
				double d7 = d2 * 100.0D;
				double d8 = Math.atan2(d0, d2);
				double d9 = Math.sin(d8);
				double d10 = Math.cos(d8);
				double d11 = Math.atan2(Math.sqrt(d0 * d0 + d2 * d2), d1);
				double d12 = Math.sin(d11);
				double d13 = Math.cos(d11);
				double d14 = random.nextDouble() * Math.PI * 2.0D;
				double d15 = Math.sin(d14);
				double d16 = Math.cos(d14);

				for (int j = 0; j < 4; ++j) {
					double d18 = (double) ((j & 2) - 1) * d3;
					double d19 = (double) ((j + 1 & 2) - 1) * d3;
					double d21 = d18 * d16 - d19 * d15;
					double d22 = d19 * d16 + d18 * d15;
					double d23 = d21 * d12 + 0.0D * d13;
					double d24 = 0.0D * d12 - d21 * d13;
					double d25 = d24 * d9 - d22 * d10;
					double d26 = d22 * d9 + d24 * d10;
					bufferBuilderIn.vertex(d5 + d25, d6 + d23, d7 + d26).endVertex();
				}
			}
		}
	}
}
