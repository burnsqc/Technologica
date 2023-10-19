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
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.IForgeDimensionSpecialEffects;

public class MoonRenderer extends DimensionSpecialEffects implements IForgeDimensionSpecialEffects {
	@Nullable
	private VertexBuffer starBuffer;
	@Nullable
	private VertexBuffer skyBuffer;
	private static final ResourceLocation SUN_TEXTURES = new ResourceLocation(Technologica.MODID, "textures/environment/sun.png");
	private static final ResourceLocation EARTH_TEXTURES = new ResourceLocation(Technologica.MODID, "textures/environment/earth.png");
	private final float[] rainSizeX = new float[1024];
	private final float[] rainSizeZ = new float[1024];
	private static final ResourceLocation RAIN_LOCATION = new ResourceLocation(Technologica.MODID, "textures/environment/meteor_shower.png");

	public MoonRenderer() {
		super(Float.NaN, true, DimensionSpecialEffects.SkyType.NORMAL, false, false);
		this.createStars();
		for (int i = 0; i < 32; ++i) {
			for (int j = 0; j < 32; ++j) {
				float f = j - 16;
				float f1 = i - 16;
				float f2 = Mth.sqrt(f * f + f1 * f1);
				this.rainSizeX[i << 5 | j] = -f1 / f2;
				this.rainSizeZ[i << 5 | j] = f / f2;
			}
		}
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
		matrixStackIn.mulPose(Axis.XP.rotationDegrees(-90.0F));
		matrixStackIn.mulPose(Axis.XP.rotationDegrees(45.0F));
		Matrix4f matrix4f1 = matrixStackIn.last().pose();
		matrixStackIn.popPose();

		matrixStackIn.pushPose();
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

	@Override
	public boolean renderSnowAndRain(ClientLevel level, int ticks, float partialTick, LightTexture lightTexture, double camX, double camY, double camZ) {
		float f = 0.5F; // level.getRainLevel(partialTick);
		if (!(f <= 0.0F)) {
			lightTexture.turnOnLightLayer();
			int i = Mth.floor(camX);
			int j = Mth.floor(camY);
			int k = Mth.floor(camZ);
			Tesselator tesselator = Tesselator.getInstance();
			BufferBuilder bufferbuilder = tesselator.getBuilder();
			RenderSystem.disableCull();
			RenderSystem.enableBlend();
			RenderSystem.defaultBlendFunc();
			RenderSystem.enableDepthTest();
			int l = 5;
			if (Minecraft.useFancyGraphics()) {
				l = 10;
			}

			RenderSystem.depthMask(Minecraft.useShaderTransparency());
			int i1 = -1;
			RenderSystem.setShader(GameRenderer::getParticleShader);
			RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
			BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

			for (int j1 = k - l; j1 <= k + l; ++j1) {
				for (int k1 = i - l; k1 <= i + l; ++k1) {
					int l1 = (j1 - k + 16) * 32 + k1 - i + 16;
					double d0 = this.rainSizeX[l1] * 0.2D;
					double d1 = this.rainSizeZ[l1] * 0.2D;
					blockpos$mutableblockpos.set(k1, camY, j1);
					Biome biome = level.getBiome(blockpos$mutableblockpos).value();
					if (biome.getPrecipitation() != Biome.Precipitation.NONE) {
						int i2 = level.getHeight(Heightmap.Types.MOTION_BLOCKING, k1, j1);
						int j2 = j - l;
						int k2 = j + l;
						if (j2 < i2) {
							j2 = i2;
						}

						if (k2 < i2) {
							k2 = i2;
						}

						int l2 = i2;
						if (i2 < j) {
							l2 = j;
						}

						if (j2 != k2) {
							RandomSource randomsource = RandomSource.create(k1 * k1 * 3121 + k1 * 45238971 ^ j1 * j1 * 418711 + j1 * 13761);
							blockpos$mutableblockpos.set(k1, j2, j1);
							if (biome.warmEnoughToRain(blockpos$mutableblockpos)) {
								if (i1 != 0) {
									if (i1 >= 0) {
										tesselator.end();
									}

									i1 = 0;
									RenderSystem.setShaderTexture(0, RAIN_LOCATION);
									bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.PARTICLE);
								}

								int i3 = ticks + k1 * k1 * 3121 + k1 * 45238971 + j1 * j1 * 418711 + j1 * 13761 & 31;
								float f2 = -(i3 + partialTick) / 32.0F * (2.0F + randomsource.nextFloat());
								double d2 = k1 + 0.5D - camX;
								double d4 = j1 + 0.5D - camZ;
								float f3 = (float) Math.sqrt(d2 * d2 + d4 * d4) / l;
								float f4 = ((1.0F - f3 * f3) * 0.5F + 0.5F) * f;
								blockpos$mutableblockpos.set(k1, l2, j1);
								int j3 = getLightColor(level, blockpos$mutableblockpos);
								bufferbuilder.vertex(k1 - camX - d0 + 0.5D, k2 - camY, j1 - camZ - d1 + 0.5D).uv(0.0F, j2 * 0.1F + f2).color(1.0F, 1.0F, 1.0F, f4).uv2(j3).endVertex();
								bufferbuilder.vertex(k1 - camX + d0 + 0.5D, k2 - camY, j1 - camZ + d1 + 0.5D).uv(1.0F, j2 * 0.1F + f2).color(1.0F, 1.0F, 1.0F, f4).uv2(j3).endVertex();
								bufferbuilder.vertex(k1 - camX + d0 + 0.5D, j2 - camY, j1 - camZ + d1 + 0.5D).uv(1.0F, k2 * 0.1F + f2).color(1.0F, 1.0F, 1.0F, f4).uv2(j3).endVertex();
								bufferbuilder.vertex(k1 - camX - d0 + 0.5D, j2 - camY, j1 - camZ - d1 + 0.5D).uv(0.0F, k2 * 0.1F + f2).color(1.0F, 1.0F, 1.0F, f4).uv2(j3).endVertex();
							}
						}
					}
				}
			}

			if (i1 >= 0) {
				tesselator.end();
			}

			RenderSystem.enableCull();
			RenderSystem.disableBlend();
			lightTexture.turnOffLightLayer();
		}
		return true;
	}

	@Override
	public boolean tickRain(ClientLevel level, int ticks, Camera camera) {
		return true;
	}

	public static int getLightColor(BlockAndTintGetter p_109542_, BlockPos p_109543_) {
		return getLightColor(p_109542_, p_109542_.getBlockState(p_109543_), p_109543_);
	}

	public static int getLightColor(BlockAndTintGetter p_109538_, BlockState p_109539_, BlockPos p_109540_) {
		if (p_109539_.emissiveRendering(p_109538_, p_109540_)) {
			return 15728880;
		} else {
			int i = p_109538_.getBrightness(LightLayer.SKY, p_109540_);
			int j = p_109538_.getBrightness(LightLayer.BLOCK, p_109540_);
			int k = p_109539_.getLightEmission(p_109538_, p_109540_);
			if (j < k) {
				j = k;
			}

			return i << 20 | j << 4;
		}
	}
}