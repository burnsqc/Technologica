package com.technologica.client.renderer;

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

import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.IForgeDimensionSpecialEffects;

public class MoonRenderer extends DimensionSpecialEffects implements IForgeDimensionSpecialEffects {

	@Nullable
	private VertexBuffer starBuffer;
	@Nullable
	private VertexBuffer skyBuffer;
	@Nullable
	private VertexBuffer sky2VBO;
	private final VertexFormat skyVertexFormat = DefaultVertexFormat.POSITION;
	private static final ResourceLocation SUN_TEXTURES = new ResourceLocation("textures/environment/sun.png");
	private static final ResourceLocation EARTH_TEXTURES = new ResourceLocation(Technologica.MODID, "textures/environment/earth.png");
	private final float[] sunriseCol = { 0.0F, 0.0F, 0.0F, 0.0F };

	public MoonRenderer() {
		super(Float.NaN, true, DimensionSpecialEffects.SkyType.NORMAL, false, false);
		this.createSky();
		this.createStars();
	}

	@Override
	public boolean renderSky(ClientLevel level, int ticks, float partialTicks, PoseStack matrixStackIn, Camera camera, Matrix4f projectionMatrix, boolean isFoggy, Runnable setupFog) {
		RenderSystem.disableTexture();
		Vec3 vector3d = level.getSkyColor(camera.getPosition(), partialTicks);
		float f = (float) vector3d.x;
		float f1 = (float) vector3d.y;
		float f2 = (float) vector3d.z;
		FogRenderer.levelFogColor();
		BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
		RenderSystem.depthMask(false);
		RenderSystem.setShaderColor(f, f1, f2, 1.0F);
		ShaderInstance shaderinstance = RenderSystem.getShader();
		this.skyBuffer.bind();
		this.skyBuffer.drawWithShader(matrixStackIn.last().pose(), projectionMatrix, shaderinstance);
		VertexBuffer.unbind();
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		float[] afloat = sunriseCol;
		if (afloat != null) {
			RenderSystem.disableTexture();
			RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
			matrixStackIn.pushPose();
			matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(90.0F));
			float f3 = Mth.sin(level.getSunAngle(partialTicks)) < 0.0F ? 180.0F : 0.0F;
			matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(f3));
			matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
			float f4 = afloat[0];
			float f5 = afloat[1];
			float f6 = afloat[2];
			Matrix4f matrix4f = matrixStackIn.last().pose();
			bufferbuilder.begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION_COLOR);
			bufferbuilder.vertex(matrix4f, 0.0F, 100.0F, 0.0F).color(f4, f5, f6, afloat[3]).endVertex();
			for (int j = 0; j <= 16; ++j) {
				float f7 = j * ((float) Math.PI * 2F) / 16.0F;
				float f8 = Mth.sin(f7);
				float f9 = Mth.cos(f7);
				bufferbuilder.vertex(matrix4f, f8 * 120.0F, f9 * 120.0F, -f9 * 40.0F * afloat[3]).color(afloat[0], afloat[1], afloat[2], 0.0F).endVertex();
			}

			BufferUploader.drawWithShader(bufferbuilder.end());
			matrixStackIn.popPose();
		}

		RenderSystem.enableTexture();
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		matrixStackIn.pushPose();
		float f11 = 1.0F - level.getRainLevel(partialTicks);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, f11);
		matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-90.0F));
		matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(45.0F));
		Matrix4f matrix4f1 = matrixStackIn.last().pose();
		float f12 = 30.0F;
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderTexture(0, EARTH_TEXTURES);
		bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
		bufferbuilder.vertex(matrix4f1, -f12, 70.0F, -f12).uv(0.0F, 0.0F).endVertex();
		bufferbuilder.vertex(matrix4f1, f12, 70.0F, -f12).uv(1.0F, 0.0F).endVertex();
		bufferbuilder.vertex(matrix4f1, f12, 70.0F, f12).uv(1.0F, 1.0F).endVertex();
		bufferbuilder.vertex(matrix4f1, -f12, 70.0F, f12).uv(0.0F, 1.0F).endVertex();
		BufferUploader.drawWithShader(bufferbuilder.end());

		matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(-45.0F));

		matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(level.getTimeOfDay(partialTicks) * 360.0F));
		matrix4f1 = matrixStackIn.last().pose();

		RenderSystem.setShaderTexture(0, SUN_TEXTURES);
		bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
		bufferbuilder.vertex(matrix4f1, -f12, 100.0F, -f12).uv(0.0F, 0.0F).endVertex();
		bufferbuilder.vertex(matrix4f1, f12, 100.0F, -f12).uv(1.0F, 0.0F).endVertex();
		bufferbuilder.vertex(matrix4f1, f12, 100.0F, f12).uv(1.0F, 1.0F).endVertex();
		bufferbuilder.vertex(matrix4f1, -f12, 100.0F, f12).uv(0.0F, 1.0F).endVertex();
		BufferUploader.drawWithShader(bufferbuilder.end());
		RenderSystem.disableTexture();

		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		FogRenderer.setupNoFog();
		this.starBuffer.bind();
		this.starBuffer.drawWithShader(matrixStackIn.last().pose(), projectionMatrix, GameRenderer.getPositionShader());
		VertexBuffer.unbind();

		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.disableBlend();
		matrixStackIn.popPose();
		RenderSystem.disableTexture();
		RenderSystem.setShaderColor(0.0F, 0.0F, 0.0F, 1.0F);

		if (level.effects().hasGround()) {
			RenderSystem.setShaderColor(f * 0.2F + 0.04F, f1 * 0.2F + 0.04F, f2 * 0.6F + 0.1F, 1.0F);
		} else {
			RenderSystem.setShaderColor(f, f1, f2, 1.0F);
		}

		RenderSystem.enableTexture();
		RenderSystem.depthMask(true);
		return true;
	}

	private void createSky() {
		Tesselator tesselator = Tesselator.getInstance();
		BufferBuilder bufferbuilder = tesselator.getBuilder();
		if (this.skyBuffer != null) {
			this.skyBuffer.close();
		}

		this.skyBuffer = new VertexBuffer();
		BufferBuilder.RenderedBuffer bufferbuilder$renderedbuffer = buildSkyDisc(bufferbuilder, 16.0F);
		this.skyBuffer.bind();
		this.skyBuffer.upload(bufferbuilder$renderedbuffer);
		VertexBuffer.unbind();
	}

	private static BufferBuilder.RenderedBuffer buildSkyDisc(BufferBuilder p_234268_, float p_234269_) {
		float f = Math.signum(p_234269_) * 512.0F;
		RenderSystem.setShader(GameRenderer::getPositionShader);
		p_234268_.begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION);
		p_234268_.vertex(0.0D, p_234269_, 0.0D).endVertex();

		for (int i = -180; i <= 180; i += 45) {
			p_234268_.vertex(f * Mth.cos(i * ((float) Math.PI / 180F)), p_234269_, 512.0F * Mth.sin(i * ((float) Math.PI / 180F))).endVertex();
		}

		return p_234268_.end();
	}

	private void createStars() {
		Tesselator tesselator = Tesselator.getInstance();
		BufferBuilder bufferbuilder = tesselator.getBuilder();
		RenderSystem.setShader(GameRenderer::getPositionShader);
		if (this.starBuffer != null) {
			this.starBuffer.close();
		}

		this.starBuffer = new VertexBuffer();
		BufferBuilder.RenderedBuffer bufferbuilder$renderedbuffer = this.drawStars(bufferbuilder);
		this.starBuffer.bind();
		this.starBuffer.upload(bufferbuilder$renderedbuffer);
		VertexBuffer.unbind();
	}

	private BufferBuilder.RenderedBuffer drawStars(BufferBuilder p_234260_) {
		RandomSource randomsource = RandomSource.create(10842L);
		p_234260_.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION);

		for (int i = 0; i < 1500; ++i) {
			double d0 = randomsource.nextFloat() * 2.0F - 1.0F;
			double d1 = randomsource.nextFloat() * 2.0F - 1.0F;
			double d2 = randomsource.nextFloat() * 2.0F - 1.0F;
			double d3 = 0.15F + randomsource.nextFloat() * 0.1F;
			double d4 = d0 * d0 + d1 * d1 + d2 * d2;
			if (d4 < 1.0D && d4 > 0.01D) {
				d4 = 1.0D / Math.sqrt(d4);
				d0 *= d4;
				d1 *= d4;
				d2 *= d4;
				double d5 = d0 * 100.0D;
				double d6 = d1 * 100.0D;
				double d7 = d2 * 100.0D;
				double d8 = Math.atan2(d0, d2);
				double d9 = Math.sin(d8);
				double d10 = Math.cos(d8);
				double d11 = Math.atan2(Math.sqrt(d0 * d0 + d2 * d2), d1);
				double d12 = Math.sin(d11);
				double d13 = Math.cos(d11);
				double d14 = randomsource.nextDouble() * Math.PI * 2.0D;
				double d15 = Math.sin(d14);
				double d16 = Math.cos(d14);

				for (int j = 0; j < 4; ++j) {
					double d18 = ((j & 2) - 1) * d3;
					double d19 = ((j + 1 & 2) - 1) * d3;
					double d21 = d18 * d16 - d19 * d15;
					double d22 = d19 * d16 + d18 * d15;
					double d23 = d21 * d12 + 0.0D * d13;
					double d24 = 0.0D * d12 - d21 * d13;
					double d25 = d24 * d9 - d22 * d10;
					double d26 = d22 * d9 + d24 * d10;
					p_234260_.vertex(d5 + d25, d6 + d23, d7 + d26).endVertex();
				}
			}
		}

		return p_234260_.end();
	}

	@Override
	public Vec3 getBrightnessDependentFogColor(Vec3 p_108878_, float p_108879_) {
		return p_108878_.scale(0.15F);
	}

	@Override
	public boolean isFoggyAt(int p_108874_, int p_108875_) {
		return false;
	}
}
