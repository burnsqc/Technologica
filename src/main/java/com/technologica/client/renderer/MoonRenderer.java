package com.technologica.client.renderer;

import javax.annotation.Nullable;

import org.joml.Matrix4f;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.math.Axis;
import com.technologica.Technologica;

import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.IForgeDimensionSpecialEffects;

public class MoonRenderer extends DimensionSpecialEffects implements IForgeDimensionSpecialEffects {

	@Nullable
	private VertexBuffer starBuffer;
	@Nullable
	private VertexBuffer skyBuffer;
	private static final ResourceLocation SUN_TEXTURES = new ResourceLocation(Technologica.MODID, "textures/environment/sun.png");
	private static final ResourceLocation EARTH_TEXTURES = new ResourceLocation(Technologica.MODID, "textures/environment/earth.png");

	public MoonRenderer() {
		super(Float.NaN, true, DimensionSpecialEffects.SkyType.NORMAL, false, false);
		this.createStars();
	}

	@Override
	public boolean renderSky(ClientLevel level, int ticks, float partialTicks, PoseStack matrixStackIn, Camera camera, Matrix4f projectionMatrix, boolean isFoggy, Runnable setupFog) {
		FogRenderer.setupNoFog();
		RenderSystem.disableTexture();
		BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableTexture();
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

		matrixStackIn.pushPose();
		matrixStackIn.mulPose(Axis.YP.rotationDegrees(-90.0F));
		matrixStackIn.mulPose(Axis.XP.rotationDegrees(45.0F));
		Matrix4f matrix4f1 = matrixStackIn.last().pose();
		matrixStackIn.mulPose(Axis.XP.rotationDegrees(-45.0F));
		matrixStackIn.mulPose(Axis.XP.rotationDegrees(level.getTimeOfDay(partialTicks) * 360.0F));
		Matrix4f matrix4f2 = matrixStackIn.last().pose();

		this.starBuffer.bind();
		this.starBuffer.drawWithShader(matrix4f2, projectionMatrix, GameRenderer.getPositionShader());
		VertexBuffer.unbind();

		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderTexture(0, SUN_TEXTURES);
		bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
		bufferbuilder.vertex(matrix4f2, -30.0F, 100.0F, -30.0F).uv(0.0F, 0.0F).endVertex();
		bufferbuilder.vertex(matrix4f2, 30.0F, 100.0F, -30.0F).uv(1.0F, 0.0F).endVertex();
		bufferbuilder.vertex(matrix4f2, 30.0F, 100.0F, 30.0F).uv(1.0F, 1.0F).endVertex();
		bufferbuilder.vertex(matrix4f2, -30.0F, 100.0F, 30.0F).uv(0.0F, 1.0F).endVertex();
		BufferUploader.drawWithShader(bufferbuilder.end());

		RenderSystem.setShaderTexture(0, EARTH_TEXTURES);
		bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
		bufferbuilder.vertex(matrix4f1, -30.0F, 70.0F, -30.0F).uv(0.0F, 0.0F).endVertex();
		bufferbuilder.vertex(matrix4f1, 30.0F, 70.0F, -30.0F).uv(1.0F, 0.0F).endVertex();
		bufferbuilder.vertex(matrix4f1, 30.0F, 70.0F, 30.0F).uv(1.0F, 1.0F).endVertex();
		bufferbuilder.vertex(matrix4f1, -30.0F, 70.0F, 30.0F).uv(0.0F, 1.0F).endVertex();
		BufferUploader.drawWithShader(bufferbuilder.end());

		matrixStackIn.popPose();

		RenderSystem.disableBlend();
		RenderSystem.disableTexture();
		RenderSystem.setShaderColor(0.0F, 0.0F, 0.0F, 1.0F);
		RenderSystem.enableTexture();
		RenderSystem.depthMask(true);
		return true;
	}

	@Override
	public float[] getSunriseColor(float p_108872_, float p_108873_) {
		return null;
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
		return p_108878_.scale(0.0F);
	}

	@Override
	public boolean isFoggyAt(int p_108874_, int p_108875_) {
		return false;
	}
}
