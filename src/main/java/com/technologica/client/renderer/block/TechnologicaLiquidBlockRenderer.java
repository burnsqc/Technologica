package com.technologica.client.renderer.block;

import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.block.LiquidBlockRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TechnologicaLiquidBlockRenderer extends LiquidBlockRenderer {
	private final TextureAtlasSprite[] lavaIcons = new TextureAtlasSprite[2];
	private final TextureAtlasSprite[] waterIcons = new TextureAtlasSprite[2];
	private TextureAtlasSprite waterOverlay;

	@SuppressWarnings("deprecation")
	@Override
	protected void setupSprites() {
		this.lavaIcons[0] = Minecraft.getInstance().getModelManager().getBlockModelShaper().getBlockModel(Blocks.LAVA.defaultBlockState()).getParticleIcon();
		this.lavaIcons[1] = ModelBakery.LAVA_FLOW.sprite();
		this.waterIcons[0] = Minecraft.getInstance().getModelManager().getBlockModelShaper().getBlockModel(Blocks.WATER.defaultBlockState()).getParticleIcon();
		this.waterIcons[1] = ModelBakery.WATER_FLOW.sprite();
		this.waterOverlay = ModelBakery.WATER_OVERLAY.sprite();
	}

	private static boolean isNeighborSameFluid(FluidState fluidState, FluidState fluidStateNeighbor) {
		return fluidStateNeighbor.getType().isSame(fluidState.getType());
	}

	private static boolean isFaceOccludedByState(BlockGetter blockGetter, Direction direction, float height, BlockPos blockPos, BlockState blockState) {
		if (blockState.canOcclude()) {
			VoxelShape voxelshape = Shapes.box(0.0D, 1.0D - height, 0.0D, 1.0D, 1.0D, 1.0D);
			VoxelShape voxelshape1 = blockState.getOcclusionShape(blockGetter, blockPos);
			return Shapes.blockOccudes(voxelshape, voxelshape1, direction);
		} else {
			return false;
		}
	}

	private static boolean isFaceOccludedByNeighbor(BlockGetter blockGetter, BlockPos blockPos, Direction direction, float height, BlockState blockState) {
		return isFaceOccludedByState(blockGetter, direction, height, blockPos.relative(direction), blockState);
	}

	private static boolean isFaceOccludedBySelf(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState, Direction direction) {
		return isFaceOccludedByState(blockGetter, direction.getOpposite(), 1.0F, blockPos, blockState);
	}

	public static boolean shouldRenderFace(BlockAndTintGetter blockAndTintGetter, BlockPos blockPos, FluidState fluidState, BlockState blockState, Direction direction, FluidState fluidStateNeighbor) {
		return !isFaceOccludedBySelf(blockAndTintGetter, blockPos, blockState, direction) && !isNeighborSameFluid(fluidState, fluidStateNeighbor);
	}

	@Override
	public void tesselate(BlockAndTintGetter blockAndTintGetter, BlockPos blockPos, VertexConsumer vertexConsumer, BlockState blockState, FluidState fluidState) {
		if (!fluidState.getFluidType().isLighterThanAir()) {
			super.tesselate(blockAndTintGetter, blockPos, vertexConsumer, blockState, fluidState);
		} else {

			/*
			 * TEXTURE/COLOR
			 */
			TextureAtlasSprite[] textureAtlasSprites = net.minecraftforge.client.ForgeHooksClient.getFluidSprites(blockAndTintGetter, blockPos, fluidState);
			int tintColor = net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions.of(fluidState).getTintColor(fluidState, blockAndTintGetter, blockPos);
			float alpha = (tintColor >> 24 & 255) / 255.0F;
			float red = (tintColor >> 16 & 255) / 255.0F;
			float green = (tintColor >> 8 & 255) / 255.0F;
			float blue = (tintColor & 255) / 255.0F;

			/*
			 * ADJACENT BLOCK/FLUID STATES
			 */
			BlockState blockStateDown = blockAndTintGetter.getBlockState(blockPos.relative(Direction.DOWN));
			BlockState blockStateUp = blockAndTintGetter.getBlockState(blockPos.relative(Direction.UP));
			BlockState blockStateNorth = blockAndTintGetter.getBlockState(blockPos.relative(Direction.NORTH));
			BlockState blockStateSouth = blockAndTintGetter.getBlockState(blockPos.relative(Direction.SOUTH));
			BlockState blockStateWest = blockAndTintGetter.getBlockState(blockPos.relative(Direction.WEST));
			BlockState blockStateEast = blockAndTintGetter.getBlockState(blockPos.relative(Direction.EAST));
			FluidState fluidStateDown = blockStateDown.getFluidState();
			FluidState fluidStateUp = blockStateUp.getFluidState();
			FluidState fluidStateNorth = blockStateNorth.getFluidState();
			FluidState fluidStateSouth = blockStateSouth.getFluidState();
			FluidState fluidStateWest = blockStateWest.getFluidState();
			FluidState fluidStateEast = blockStateEast.getFluidState();

			/*
			 * FACE RENDER FLAGS
			 */
			boolean shouldRenderUp = !isNeighborSameFluid(fluidState, fluidStateDown);
			boolean shouldRenderTop = shouldRenderFace(blockAndTintGetter, blockPos, fluidState, blockState, Direction.UP, fluidStateUp) && !isFaceOccludedByNeighbor(blockAndTintGetter, blockPos, Direction.UP, 0.8888889F, blockStateUp);
			boolean shouldRenderNorth = shouldRenderFace(blockAndTintGetter, blockPos, fluidState, blockState, Direction.NORTH, fluidStateNorth);
			boolean shouldRenderSouth = shouldRenderFace(blockAndTintGetter, blockPos, fluidState, blockState, Direction.SOUTH, fluidStateSouth);
			boolean shouldRenderWest = shouldRenderFace(blockAndTintGetter, blockPos, fluidState, blockState, Direction.WEST, fluidStateWest);
			boolean shouldRenderEast = shouldRenderFace(blockAndTintGetter, blockPos, fluidState, blockState, Direction.EAST, fluidStateEast);

			if (shouldRenderUp || shouldRenderTop || shouldRenderNorth || shouldRenderSouth || shouldRenderWest || shouldRenderEast) {

				/*
				 * SHADING
				 */
				float shadeBelow = blockAndTintGetter.getShade(Direction.DOWN, true);
				float shadeAbove = blockAndTintGetter.getShade(Direction.UP, true);
				float shadeZAxis = blockAndTintGetter.getShade(Direction.NORTH, true);
				float shadeXAxis = blockAndTintGetter.getShade(Direction.WEST, true);

				/*
				 * HEIGHT
				 */
				Fluid fluid = fluidState.getType();
				float height = this.getHeight(blockAndTintGetter, fluid, blockPos, blockState, fluidState);
				float heightNorthEast;
				float heightNorthWest;
				float heightSouthEast;
				float heightSouthWest;
				if (height >= 1.0F) {
					heightNorthEast = 1.0F;
					heightNorthWest = 1.0F;
					heightSouthEast = 1.0F;
					heightSouthWest = 1.0F;
				} else {
					float heightNorth = this.getHeight(blockAndTintGetter, fluid, blockPos.north(), blockStateNorth, fluidStateNorth);
					float heightSouth = this.getHeight(blockAndTintGetter, fluid, blockPos.south(), blockStateSouth, fluidStateSouth);
					float heightEast = this.getHeight(blockAndTintGetter, fluid, blockPos.east(), blockStateEast, fluidStateEast);
					float heightWest = this.getHeight(blockAndTintGetter, fluid, blockPos.west(), blockStateWest, fluidStateWest);
					heightNorthEast = this.calculateAverageHeight(blockAndTintGetter, fluid, height, heightNorth, heightEast, blockPos.relative(Direction.NORTH).relative(Direction.EAST));
					heightNorthWest = this.calculateAverageHeight(blockAndTintGetter, fluid, height, heightNorth, heightWest, blockPos.relative(Direction.NORTH).relative(Direction.WEST));
					heightSouthEast = this.calculateAverageHeight(blockAndTintGetter, fluid, height, heightSouth, heightEast, blockPos.relative(Direction.SOUTH).relative(Direction.EAST));
					heightSouthWest = this.calculateAverageHeight(blockAndTintGetter, fluid, height, heightSouth, heightWest, blockPos.relative(Direction.SOUTH).relative(Direction.WEST));
				}

				/*
				 * SECTION POSITIONS
				 */
				double sectionX = blockPos.getX() & 15;
				double sectionY = blockPos.getY() & 15;
				double sectionZ = blockPos.getZ() & 15;

				float antiZFightShim = shouldRenderUp ? 0.001F : 0.0F;

				/*
				 * BOTTOM-UP
				 */
				if (shouldRenderUp && !isFaceOccludedByNeighbor(blockAndTintGetter, blockPos, Direction.DOWN, Math.min(Math.min(heightNorthWest, heightSouthWest), Math.min(heightSouthEast, heightNorthEast)), blockStateUp)) {
					Vec3 flowDirection = fluidState.getFlow(blockAndTintGetter, blockPos);

					heightNorthWest -= 0.001F;
					heightSouthWest -= 0.001F;
					heightSouthEast -= 0.001F;
					heightNorthEast -= 0.001F;

					float f18;
					float f19;
					float f20;
					float f21;
					float f22;
					float f23;
					float f24;
					float f25;

					if (flowDirection.x == 0.0D && flowDirection.z == 0.0D) { // STILL FLUID
						TextureAtlasSprite textureAtlasSprite = textureAtlasSprites[0];
						f18 = textureAtlasSprite.getU(0.0D);
						f19 = f18;
						f22 = textureAtlasSprite.getV(0.0D);
						f25 = f22;
						f23 = textureAtlasSprite.getV(16.0D);
						f24 = f23;
						f20 = textureAtlasSprite.getU(16.0D);
						f21 = f20;
					} else { // FLOWING FLUID
						TextureAtlasSprite textureAtlasSprite = textureAtlasSprites[1];
						float textureRotationAngle = (float) Mth.atan2(flowDirection.z, flowDirection.x) - ((float) Math.PI / 2F);
						float f27 = Mth.sin(textureRotationAngle) * 0.25F;
						float f28 = Mth.cos(textureRotationAngle) * 0.25F;
						f18 = textureAtlasSprite.getU(8.0F + (-f28 - f27) * 16.0F);
						f22 = textureAtlasSprite.getV(8.0F + (-f28 + f27) * 16.0F);
						f19 = textureAtlasSprite.getU(8.0F + (-f28 + f27) * 16.0F);
						f23 = textureAtlasSprite.getV(8.0F + (f28 + f27) * 16.0F);
						f20 = textureAtlasSprite.getU(8.0F + (f28 + f27) * 16.0F);
						f24 = textureAtlasSprite.getV(8.0F + (f28 - f27) * 16.0F);
						f21 = textureAtlasSprite.getU(8.0F + (f28 - f27) * 16.0F);
						f25 = textureAtlasSprite.getV(8.0F + (-f28 - f27) * 16.0F);
					}

					float f49 = (f18 + f19 + f20 + f21) / 4.0F;
					float f50 = (f22 + f23 + f24 + f25) / 4.0F;
					float f51 = textureAtlasSprites[0].uvShrinkRatio();

					f18 = Mth.lerp(f51, f18, f49);
					f19 = Mth.lerp(f51, f19, f49);
					f20 = Mth.lerp(f51, f20, f49);
					f21 = Mth.lerp(f51, f21, f49);
					f22 = Mth.lerp(f51, f22, f50);
					f23 = Mth.lerp(f51, f23, f50);
					f24 = Mth.lerp(f51, f24, f50);
					f25 = Mth.lerp(f51, f25, f50);

					float shadeBelowRed = shadeBelow * red;
					float shadeBelowGreen = shadeBelow * green;
					float shadeBelowBlue = shadeBelow * blue;
					int lightColorBelow = this.getLightColor(blockAndTintGetter, blockPos);

					this.vertex(vertexConsumer, sectionX + 1.0D, sectionY - heightNorthEast + 1.0D, sectionZ + 0.0D, shadeBelowRed, shadeBelowGreen, shadeBelowBlue, alpha, f21, f25, lightColorBelow);
					this.vertex(vertexConsumer, sectionX + 1.0D, sectionY - heightSouthEast + 1.0D, sectionZ + 1.0D, shadeBelowRed, shadeBelowGreen, shadeBelowBlue, alpha, f20, f24, lightColorBelow);
					this.vertex(vertexConsumer, sectionX + 0.0D, sectionY - heightSouthWest + 1.0D, sectionZ + 1.0D, shadeBelowRed, shadeBelowGreen, shadeBelowBlue, alpha, f19, f23, lightColorBelow);
					this.vertex(vertexConsumer, sectionX + 0.0D, sectionY - heightNorthWest + 1.0D, sectionZ + 0.0D, shadeBelowRed, shadeBelowGreen, shadeBelowBlue, alpha, f18, f22, lightColorBelow);

					/*
					 * TOP SIDE OF BOTTOM FACE, INSIDE LOOKING DOWN
					 */
					if (fluidState.shouldRenderBackwardUpFace(blockAndTintGetter, blockPos.above())) {
						this.vertex(vertexConsumer, sectionX + 1.0D, sectionY - heightNorthEast + 1.0D, sectionZ + 0.0D, shadeBelowRed, shadeBelowGreen, shadeBelowBlue, alpha, f21, f25, lightColorBelow);
						this.vertex(vertexConsumer, sectionX + 0.0D, sectionY - heightNorthWest + 1.0D, sectionZ + 0.0D, shadeBelowRed, shadeBelowGreen, shadeBelowBlue, alpha, f18, f22, lightColorBelow);
						this.vertex(vertexConsumer, sectionX + 0.0D, sectionY - heightSouthWest + 1.0D, sectionZ + 1.0D, shadeBelowRed, shadeBelowGreen, shadeBelowBlue, alpha, f19, f23, lightColorBelow);
						this.vertex(vertexConsumer, sectionX + 1.0D, sectionY - heightSouthEast + 1.0D, sectionZ + 1.0D, shadeBelowRed, shadeBelowGreen, shadeBelowBlue, alpha, f20, f24, lightColorBelow);
					}
				}

				/*
				 * TOP FACE
				 */
				if (shouldRenderTop) {
					float u0 = textureAtlasSprites[0].getU0();
					float u1 = textureAtlasSprites[0].getU1();
					float v0 = textureAtlasSprites[0].getV0();
					float v1 = textureAtlasSprites[0].getV1();

					float shadeAboveRed = shadeAbove * red;
					float shadeUpGreen = shadeAbove * green;
					float shadeUpBlue = shadeAbove * blue;
					int lightColor = this.getLightColor(blockAndTintGetter, blockPos);

					this.vertex(vertexConsumer, sectionX + 0.0D, sectionY - antiZFightShim + 1.0D, sectionZ + 0.0D, shadeAboveRed, shadeUpGreen, shadeUpBlue, alpha, u0, v1, lightColor);
					this.vertex(vertexConsumer, sectionX + 0.0D, sectionY - antiZFightShim + 1.0D, sectionZ + 1.0D, shadeAboveRed, shadeUpGreen, shadeUpBlue, alpha, u0, v0, lightColor);
					this.vertex(vertexConsumer, sectionX + 1.0D, sectionY - antiZFightShim + 1.0D, sectionZ + 1.0D, shadeAboveRed, shadeUpGreen, shadeUpBlue, alpha, u1, v0, lightColor);
					this.vertex(vertexConsumer, sectionX + 1.0D, sectionY - antiZFightShim + 1.0D, sectionZ + 0.0D, shadeAboveRed, shadeUpGreen, shadeUpBlue, alpha, u1, v1, lightColor);
				}

				/*
				 * HORIZONTAL RENDERING
				 */
				int lightColor = this.getLightColor(blockAndTintGetter, blockPos);
				for (Direction direction : Direction.Plane.HORIZONTAL) {
					float heightCorner1;
					float heightCorner2;
					double sectionXShimmed1;
					double sectionZShimmed1;
					double sectionXShimmed2;
					double sectionZShimmed2;
					boolean shouldRenderHorizontal;

					switch (direction) {
						case NORTH:
							heightCorner1 = heightNorthWest;
							heightCorner2 = heightNorthEast;
							sectionXShimmed1 = sectionX;
							sectionXShimmed2 = sectionX + 1.0D;
							sectionZShimmed1 = sectionZ + 0.001F;
							sectionZShimmed2 = sectionZ + 0.001F;
							shouldRenderHorizontal = shouldRenderNorth;
							break;
						case SOUTH:
							heightCorner1 = heightSouthEast;
							heightCorner2 = heightSouthWest;
							sectionXShimmed1 = sectionX + 1.0D;
							sectionXShimmed2 = sectionX;
							sectionZShimmed1 = sectionZ + 1.0D - 0.001F;
							sectionZShimmed2 = sectionZ + 1.0D - 0.001F;
							shouldRenderHorizontal = shouldRenderSouth;
							break;
						case WEST:
							heightCorner1 = heightSouthWest;
							heightCorner2 = heightNorthWest;
							sectionXShimmed1 = sectionX + 0.001F;
							sectionXShimmed2 = sectionX + 0.001F;
							sectionZShimmed1 = sectionZ + 1.0D;
							sectionZShimmed2 = sectionZ;
							shouldRenderHorizontal = shouldRenderWest;
							break;
						default:
							heightCorner1 = heightNorthEast;
							heightCorner2 = heightSouthEast;
							sectionXShimmed1 = sectionX + 1.0D - 0.001F;
							sectionXShimmed2 = sectionX + 1.0D - 0.001F;
							sectionZShimmed1 = sectionZ;
							sectionZShimmed2 = sectionZ + 1.0D;
							shouldRenderHorizontal = shouldRenderEast;
					}

					if (shouldRenderHorizontal && !isFaceOccludedByNeighbor(blockAndTintGetter, blockPos, direction, Math.max(heightCorner1, heightCorner2), blockAndTintGetter.getBlockState(blockPos.relative(direction)))) {
						BlockPos blockpos = blockPos.relative(direction);
						TextureAtlasSprite texture2 = textureAtlasSprites[1];

						if (textureAtlasSprites[2] != null) {
							if (blockAndTintGetter.getBlockState(blockpos).shouldDisplayFluidOverlay(blockAndTintGetter, blockpos, fluidState)) {
								texture2 = textureAtlasSprites[2];
							}
						}

						float f53 = texture2.getU(0.0D);
						float f32 = texture2.getU(8.0D);
						float f33 = texture2.getV((1.0F - heightCorner1) * 16.0F * 0.5F);
						float f34 = texture2.getV((1.0F - heightCorner2) * 16.0F * 0.5F);
						float f35 = texture2.getV(8.0D);

						float shadeHorizontal = direction.getAxis() == Direction.Axis.Z ? shadeZAxis : shadeXAxis;
						float shadeHorizontalRed = shadeAbove * shadeHorizontal * red;
						float shadeHorizontalGreen = shadeAbove * shadeHorizontal * green;
						float shadeHorizontalBlue = shadeAbove * shadeHorizontal * blue;

						this.vertex(vertexConsumer, sectionXShimmed1, sectionY - antiZFightShim + 1.0D, sectionZShimmed1, shadeHorizontalRed, shadeHorizontalGreen, shadeHorizontalBlue, alpha, f53, f35, lightColor);
						this.vertex(vertexConsumer, sectionXShimmed2, sectionY - antiZFightShim + 1.0D, sectionZShimmed2, shadeHorizontalRed, shadeHorizontalGreen, shadeHorizontalBlue, alpha, f32, f35, lightColor);
						this.vertex(vertexConsumer, sectionXShimmed2, sectionY - heightCorner2 + 1.0D, sectionZShimmed2, shadeHorizontalRed, shadeHorizontalGreen, shadeHorizontalBlue, alpha, f32, f34, lightColor);
						this.vertex(vertexConsumer, sectionXShimmed1, sectionY - heightCorner1 + 1.0D, sectionZShimmed1, shadeHorizontalRed, shadeHorizontalGreen, shadeHorizontalBlue, alpha, f53, f33, lightColor);

						if (texture2 != this.waterOverlay) {
							this.vertex(vertexConsumer, sectionXShimmed1, sectionY - heightCorner1 + 1.0D, sectionZShimmed1, shadeHorizontalRed, shadeHorizontalGreen, shadeHorizontalBlue, alpha, f53, f33, lightColor);
							this.vertex(vertexConsumer, sectionXShimmed2, sectionY - heightCorner2 + 1.0D, sectionZShimmed2, shadeHorizontalRed, shadeHorizontalGreen, shadeHorizontalBlue, alpha, f32, f34, lightColor);
							this.vertex(vertexConsumer, sectionXShimmed2, sectionY - antiZFightShim + 1.0D, sectionZShimmed2, shadeHorizontalRed, shadeHorizontalGreen, shadeHorizontalBlue, alpha, f32, f35, lightColor);
							this.vertex(vertexConsumer, sectionXShimmed1, sectionY - antiZFightShim + 1.0D, sectionZShimmed1, shadeHorizontalRed, shadeHorizontalGreen, shadeHorizontalBlue, alpha, f53, f35, lightColor);
						}
					}
				}
			}
		}
	}

	private float calculateAverageHeight(BlockAndTintGetter blockAndTintGetter, Fluid fluid, float height, float height1, float height2, BlockPos blockPos) {
		if (!(height2 >= 1.0F) && !(height1 >= 1.0F)) {
			float[] afloat = new float[2];
			if (height2 > 0.0F || height1 > 0.0F) {
				float f = this.getHeight(blockAndTintGetter, fluid, blockPos);
				if (f >= 1.0F) {
					return 1.0F;
				}
				this.addWeightedHeight(afloat, f);
			}
			this.addWeightedHeight(afloat, height);
			this.addWeightedHeight(afloat, height2);
			this.addWeightedHeight(afloat, height1);
			return afloat[0] / afloat[1];
		} else {
			return 1.0F;
		}
	}

	private void addWeightedHeight(float[] output, float height) {
		if (height >= 0.8F) {
			output[0] += height * 10.0F;
			output[1] += 10.0F;
		} else if (height >= 0.0F) {
			output[0] += height;
			output[1] += 1.0F;
		}

	}

	private float getHeight(BlockAndTintGetter blockAndTintGetter, Fluid fluid, BlockPos blockPos) {
		BlockState blockState = blockAndTintGetter.getBlockState(blockPos);
		return this.getHeight(blockAndTintGetter, fluid, blockPos, blockState, blockState.getFluidState());
	}

	@SuppressWarnings("deprecation")
	private float getHeight(BlockAndTintGetter blockAndTintGetter, Fluid fluid, BlockPos blockPos, BlockState blockState, FluidState fluidState) {
		if (fluid.isSame(fluidState.getType())) {
			BlockState blockState2 = blockAndTintGetter.getBlockState(blockPos.below());
			return fluid.isSame(blockState2.getFluidState().getType()) ? 1.0F : fluidState.getOwnHeight();
		} else {
			return !blockState.isSolid() ? 0.0F : -1.0F;
		}
	}

	private void vertex(VertexConsumer vertexConsumer, double posX, double posY, double posZ, float red, float green, float blue, float alpha, float u, float v, int packedLight) {
		vertexConsumer.vertex(posX, posY, posZ).color(red, green, blue, alpha).uv(u, v).uv2(packedLight).normal(0.0F, 1.0F, 0.0F).endVertex();
	}

	private int getLightColor(BlockAndTintGetter blockAndTintGetter, BlockPos blockPos) {
		int i = LevelRenderer.getLightColor(blockAndTintGetter, blockPos);
		int j = LevelRenderer.getLightColor(blockAndTintGetter, blockPos.above());
		int k = i & 255;
		int l = j & 255;
		int i1 = i >> 16 & 255;
		int j1 = j >> 16 & 255;
		return (k > l ? k : l) | (i1 > j1 ? i1 : j1) << 16;
	}
}
