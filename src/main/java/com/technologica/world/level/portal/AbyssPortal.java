package com.technologica.world.level.portal;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;

import javax.annotation.Nullable;

import com.technologica.Technologica;
import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.registration.deferred.TechnologicaPOITypes;
import com.technologica.registration.dynamic.TechnologicaDimensions;
import com.technologica.world.level.block.AbyssPortalFrameBlock;

import net.minecraft.BlockUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.TicketType;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.ITeleporter;

public class AbyssPortal implements ITeleporter {
	protected final ServerLevel sourceLevel;
	protected BlockPos portalEntrancePos;
	protected Entity entity;

	public AbyssPortal(ServerLevel serverLevel, BlockPos blockPos, Entity entity) {
		this.sourceLevel = serverLevel;
		this.portalEntrancePos = blockPos.immutable();
		this.entity = entity;
	}

	@Override
	public PortalInfo getPortalInfo(Entity entity, ServerLevel destinationLevel, Function<ServerLevel, PortalInfo> defaultPortalInfo) {
		this.entity = entity;
		return findDimensionEntryPoint(destinationLevel);
	}

	@Override
	public boolean playTeleportSound(ServerPlayer player, ServerLevel sourceWorld, ServerLevel destWorld) {
		Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forLocalAmbience(SoundEvents.BUBBLE_COLUMN_WHIRLPOOL_AMBIENT, sourceLevel.random.nextFloat() * 0.4F + 0.8F, 0.25F));
		return false;
	}

	/*
	 * ServerPlayer
	 */

	@Nullable
	protected PortalInfo findDimensionEntryPoint(ServerLevel destinationLevel) {
		PortalInfo portalinfo = superfindDimensionEntryPoint(destinationLevel);
		if (portalinfo != null) {
			if (sourceLevel.dimension() == Level.OVERWORLD && destinationLevel.dimension() == Registries.levelStemToLevel(TechnologicaDimensions.ABYSS_STEM)) {
				Vec3 vec3 = portalinfo.pos.add(0.0D, 10.0D, 0.0D);
				return new PortalInfo(vec3, Vec3.ZERO, 90.0F, 0.0F);
			} else {
				Vec3 vec3 = portalinfo.pos.add(0.0D, -5.0D, 0.0D);
				return new PortalInfo(vec3, Vec3.ZERO, 90.0F, 0.0F);
			}
		} else {
			return portalinfo;
		}
	}

	/*
	 * Entity
	 */

	@Nullable
	protected PortalInfo superfindDimensionEntryPoint(ServerLevel destinationLevel) {
		boolean isGoingToAbyss = destinationLevel.dimension() == Registries.levelStemToLevel(TechnologicaDimensions.ABYSS_STEM);
		// if (sourceLevel.dimension() != Registries.levelStemToLevel(TechnologicaDimensions.CHALLENGER_DEEP_STEM) && !isGoingToAbyss) {
		// return null;
		// } else {
			WorldBorder worldborder = destinationLevel.getWorldBorder();
			double d0 = DimensionType.getTeleportationScale(sourceLevel.dimensionType(), destinationLevel.dimensionType());
			BlockPos blockpos1 = worldborder.clampToBounds(entity.getX() * d0, 240, entity.getZ() * d0);
			return this.getExitPortal(destinationLevel, blockpos1, isGoingToAbyss, worldborder).map((p_258249_) -> {
				BlockState blockstate = sourceLevel.getBlockState(this.portalEntrancePos);
				Direction.Axis direction$axis;
				Vec3 vec3;
				int launch = 0;
				if (blockstate.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
					direction$axis = blockstate.getValue(BlockStateProperties.HORIZONTAL_AXIS);
					BlockUtil.FoundRectangle blockutil$foundrectangle = BlockUtil.getLargestRectangleAround(this.portalEntrancePos, direction$axis, 21, Direction.Axis.Y, 21, (p_284700_) -> {
						return sourceLevel.getBlockState(p_284700_) == blockstate;
						});
					vec3 = this.getRelativePortalPosition(direction$axis, blockutil$foundrectangle);
				} else {
					direction$axis = Direction.Axis.X;

					if (isGoingToAbyss) {
						vec3 = new Vec3(0.0D, -2.0D, 0.0D);

					} else {
						vec3 = new Vec3(0.0D, -20.0D, 0.0D);
						launch = -10;
					}
				}

				return PortalShape.createPortalInfo(destinationLevel, p_258249_, direction$axis, vec3, entity, entity.getDeltaMovement().add(new Vec3(launch, launch, launch)), entity.getYRot(), entity.getXRot());
			}).orElse((PortalInfo) null);
			// }
	}

	/*
	 * ServerPlayer
	 */

	protected Optional<BlockUtil.FoundRectangle> getExitPortal(ServerLevel serverLevel, BlockPos blockPos, boolean isGoingToAbyss, WorldBorder worldBorder) {
		Optional<BlockUtil.FoundRectangle> existingPortal = findPortalAround(blockPos, isGoingToAbyss, worldBorder);
		if (existingPortal.isPresent()) {
			return existingPortal;
		} else {
			Optional<BlockUtil.FoundRectangle> newPortal = this.createPortal(blockPos, Direction.Axis.X);
			if (!newPortal.isPresent()) {
				Technologica.LOGGER.error("Unable to create a portal, likely target out of worldborder");
			}
			return newPortal;
		}
	}

	/*
	 * Entity
	 */

	protected Vec3 getRelativePortalPosition(Direction.Axis p_20045_, BlockUtil.FoundRectangle p_20046_) {
		return PortalShape.getRelativePosition(p_20046_, p_20045_, entity.position(), entity.getDimensions(entity.getPose()));
	}

	public Optional<BlockUtil.FoundRectangle> findPortalAround(BlockPos blockPos, boolean isGoingToAbyss, WorldBorder worldBorder) {
		PoiManager poimanager = sourceLevel.getPoiManager();
		int i = isGoingToAbyss ? 16 : 128;
		poimanager.ensureLoadedAndValid(sourceLevel, blockPos, i);
		Optional<PoiRecord> optional = poimanager.getInSquare((poiType) -> {
			return poiType.is(TechnologicaPOITypes.ABYSS_PORTAL.getKey());
		}, blockPos, i, PoiManager.Occupancy.ANY).filter((poiRecord) -> {
			return worldBorder.isWithinBounds(poiRecord.getPos());
		}).sorted(Comparator.<PoiRecord>comparingDouble((poiRecord) -> {
			return poiRecord.getPos().distSqr(blockPos);
		}).thenComparingInt((poiRecord) -> {
			return poiRecord.getPos().getY();
		}))// .filter((poiRecord) -> {
		//	return sourceLevel.getBlockState(poiRecord.getPos()).hasProperty(TechnologicaBlockStateProperties.KEY);
				.findFirst();
		return optional.map((poiRecord) -> {
			BlockPos blockpos = poiRecord.getPos();
			sourceLevel.getChunkSource().addRegionTicket(TicketType.PORTAL, new ChunkPos(blockpos), 3, blockpos);
			BlockState blockstate = sourceLevel.getBlockState(blockpos);
			return BlockUtil.getLargestRectangleAround(blockpos, Direction.Axis.X, 21, Direction.Axis.Y, 21, (p_192978_) -> {
				return sourceLevel.getBlockState(p_192978_) == blockstate;
			});
		});
	}

	public Optional<BlockUtil.FoundRectangle> createPortal(BlockPos blockPos, Direction.Axis axis) {
		Direction direction = Direction.get(Direction.AxisDirection.POSITIVE, axis);
		double d0 = -1.0D;
		BlockPos blockpos = null;
		double d1 = -1.0D;
		BlockPos blockpos1 = null;
		WorldBorder worldborder = sourceLevel.getWorldBorder();
		int i = Math.min(sourceLevel.getMaxBuildHeight(), sourceLevel.getMinBuildHeight() + sourceLevel.getLogicalHeight()) - 1;
		BlockPos.MutableBlockPos blockpos$mutableblockpos = blockPos.mutable();
		for (BlockPos.MutableBlockPos blockpos$mutableblockpos1 : BlockPos.spiralAround(blockPos, 16, Direction.EAST, Direction.SOUTH)) {
			int j = Math.min(i, sourceLevel.getHeight(Heightmap.Types.MOTION_BLOCKING, blockpos$mutableblockpos1.getX(), blockpos$mutableblockpos1.getZ()));
			if (worldborder.isWithinBounds(blockpos$mutableblockpos1) && worldborder.isWithinBounds(blockpos$mutableblockpos1.move(direction, 1))) {
				blockpos$mutableblockpos1.move(direction.getOpposite(), 1);

				for (int l = j; l >= sourceLevel.getMinBuildHeight(); --l) {
					blockpos$mutableblockpos1.setY(l);
					if (this.canPortalReplaceBlock(blockpos$mutableblockpos1)) {
						int i1;
						for (i1 = l; l > sourceLevel.getMinBuildHeight() && this.canPortalReplaceBlock(blockpos$mutableblockpos1.move(Direction.DOWN)); --l) {
						}
						if (l + 4 <= i) {
							int j1 = i1 - l;
							if (j1 <= 0 || j1 >= 3) {
								blockpos$mutableblockpos1.setY(l);
								if (this.canHostFrame(blockpos$mutableblockpos1, blockpos$mutableblockpos, direction, 0)) {
									double d2 = blockPos.distSqr(blockpos$mutableblockpos1);
									if (this.canHostFrame(blockpos$mutableblockpos1, blockpos$mutableblockpos, direction, -1) && this.canHostFrame(blockpos$mutableblockpos1, blockpos$mutableblockpos, direction, 1) && (d0 == -1.0D || d0 > d2)) {
										d0 = d2;
										blockpos = blockpos$mutableblockpos1.immutable();
									}
									if (d0 == -1.0D && (d1 == -1.0D || d1 > d2)) {
										d1 = d2;
										blockpos1 = blockpos$mutableblockpos1.immutable();
									}
								}
							}
						}
					}
				}
			}
		}
		if (d0 == -1.0D && d1 != -1.0D) {
			blockpos = blockpos1;
			d0 = d1;
		}
		if (d0 == -1.0D) {
			int k1 = Math.max(sourceLevel.getMinBuildHeight() - -1, 246);
			int i2 = i - 9;
			if (i2 < k1) {
				return Optional.empty();
			}
			blockpos = (new BlockPos(blockPos.getX(), Mth.clamp(blockPos.getY(), k1, i2), blockPos.getZ())).immutable();
			if (!worldborder.isWithinBounds(blockpos)) {
				return Optional.empty();
			}
		}

		sourceLevel.setBlock(blockpos.offset(2, 0, 1), TechnologicaBlocks.ABYSS_PORTAL_FRAME.get().defaultBlockState().setValue(AbyssPortalFrameBlock.FACING, Direction.WEST).setValue(AbyssPortalFrameBlock.HAS_KEY, true).setValue(AbyssPortalFrameBlock.WATERLOGGED, true), 3);
		sourceLevel.setBlock(blockpos.offset(2, 0, 0), TechnologicaBlocks.ABYSS_PORTAL_FRAME.get().defaultBlockState().setValue(AbyssPortalFrameBlock.FACING, Direction.WEST).setValue(AbyssPortalFrameBlock.HAS_KEY, true).setValue(AbyssPortalFrameBlock.WATERLOGGED, true), 3);
		sourceLevel.setBlock(blockpos.offset(2, 0, -1), TechnologicaBlocks.ABYSS_PORTAL_FRAME.get().defaultBlockState().setValue(AbyssPortalFrameBlock.FACING, Direction.WEST).setValue(AbyssPortalFrameBlock.HAS_KEY, true).setValue(AbyssPortalFrameBlock.WATERLOGGED, true), 3);

		sourceLevel.setBlock(blockpos.offset(1, 0, 2), TechnologicaBlocks.ABYSS_PORTAL_FRAME.get().defaultBlockState().setValue(AbyssPortalFrameBlock.FACING, Direction.NORTH).setValue(AbyssPortalFrameBlock.HAS_KEY, true).setValue(AbyssPortalFrameBlock.WATERLOGGED, true), 3);
		sourceLevel.setBlock(blockpos.offset(0, 0, 2), TechnologicaBlocks.ABYSS_PORTAL_FRAME.get().defaultBlockState().setValue(AbyssPortalFrameBlock.FACING, Direction.NORTH).setValue(AbyssPortalFrameBlock.HAS_KEY, true).setValue(AbyssPortalFrameBlock.WATERLOGGED, true), 3);
		sourceLevel.setBlock(blockpos.offset(-1, 0, 2), TechnologicaBlocks.ABYSS_PORTAL_FRAME.get().defaultBlockState().setValue(AbyssPortalFrameBlock.FACING, Direction.NORTH).setValue(AbyssPortalFrameBlock.HAS_KEY, true).setValue(AbyssPortalFrameBlock.WATERLOGGED, true), 3);

		sourceLevel.setBlock(blockpos.offset(-2, 0, 1), TechnologicaBlocks.ABYSS_PORTAL_FRAME.get().defaultBlockState().setValue(AbyssPortalFrameBlock.FACING, Direction.EAST).setValue(AbyssPortalFrameBlock.HAS_KEY, true).setValue(AbyssPortalFrameBlock.WATERLOGGED, true), 3);
		sourceLevel.setBlock(blockpos.offset(-2, 0, 0), TechnologicaBlocks.ABYSS_PORTAL_FRAME.get().defaultBlockState().setValue(AbyssPortalFrameBlock.FACING, Direction.EAST).setValue(AbyssPortalFrameBlock.HAS_KEY, true).setValue(AbyssPortalFrameBlock.WATERLOGGED, true), 3);
		sourceLevel.setBlock(blockpos.offset(-2, 0, -1), TechnologicaBlocks.ABYSS_PORTAL_FRAME.get().defaultBlockState().setValue(AbyssPortalFrameBlock.FACING, Direction.EAST).setValue(AbyssPortalFrameBlock.HAS_KEY, true).setValue(AbyssPortalFrameBlock.WATERLOGGED, true), 3);

		sourceLevel.setBlock(blockpos.offset(1, 0, -2), TechnologicaBlocks.ABYSS_PORTAL_FRAME.get().defaultBlockState().setValue(AbyssPortalFrameBlock.FACING, Direction.SOUTH).setValue(AbyssPortalFrameBlock.HAS_KEY, true).setValue(AbyssPortalFrameBlock.WATERLOGGED, true), 3);
		sourceLevel.setBlock(blockpos.offset(0, 0, -2), TechnologicaBlocks.ABYSS_PORTAL_FRAME.get().defaultBlockState().setValue(AbyssPortalFrameBlock.FACING, Direction.SOUTH).setValue(AbyssPortalFrameBlock.HAS_KEY, true).setValue(AbyssPortalFrameBlock.WATERLOGGED, true), 3);
		sourceLevel.setBlock(blockpos.offset(-1, 0, -2), TechnologicaBlocks.ABYSS_PORTAL_FRAME.get().defaultBlockState().setValue(AbyssPortalFrameBlock.FACING, Direction.SOUTH).setValue(AbyssPortalFrameBlock.HAS_KEY, true).setValue(AbyssPortalFrameBlock.WATERLOGGED, true), 3);

		sourceLevel.setBlock(blockpos.offset(1, 0, 1), TechnologicaBlocks.ABYSS_PORTAL.get().defaultBlockState(), 3);
		sourceLevel.setBlock(blockpos.offset(1, 0, 0), TechnologicaBlocks.ABYSS_PORTAL.get().defaultBlockState(), 3);
		sourceLevel.setBlock(blockpos.offset(1, 0, -1), TechnologicaBlocks.ABYSS_PORTAL.get().defaultBlockState(), 3);
		sourceLevel.setBlock(blockpos.offset(0, 0, 1), TechnologicaBlocks.ABYSS_PORTAL.get().defaultBlockState(), 3);
		sourceLevel.setBlock(blockpos.offset(0, 0, 0), TechnologicaBlocks.ABYSS_PORTAL.get().defaultBlockState(), 3);
		sourceLevel.setBlock(blockpos.offset(0, 0, -1), TechnologicaBlocks.ABYSS_PORTAL.get().defaultBlockState(), 3);
		sourceLevel.setBlock(blockpos.offset(-1, 0, 1), TechnologicaBlocks.ABYSS_PORTAL.get().defaultBlockState(), 3);
		sourceLevel.setBlock(blockpos.offset(-1, 0, 0), TechnologicaBlocks.ABYSS_PORTAL.get().defaultBlockState(), 3);
		sourceLevel.setBlock(blockpos.offset(-1, 0, -1), TechnologicaBlocks.ABYSS_PORTAL.get().defaultBlockState(), 3);

		return Optional.of(new BlockUtil.FoundRectangle(blockpos.immutable(), 2, 3));
	}

	private boolean canPortalReplaceBlock(BlockPos.MutableBlockPos mutableBlockPos) {
		return true;
		// BlockState blockstate = sourceLevel.getBlockState(mutableBlockPos);
		// return blockstate.canBeReplaced();
	}

	@SuppressWarnings("deprecation")
	private boolean canHostFrame(BlockPos blockPos, BlockPos.MutableBlockPos mutableBlockPos, Direction p_77664_, int p_77665_) {
		Direction direction = p_77664_.getClockWise();
		for (int i = -1; i < 3; ++i) {
			for (int j = -1; j < 4; ++j) {
				mutableBlockPos.setWithOffset(blockPos, p_77664_.getStepX() * i + direction.getStepX() * p_77665_, j, p_77664_.getStepZ() * i + direction.getStepZ() * p_77665_);
				if (j < 0 && !sourceLevel.getBlockState(mutableBlockPos).isSolid()) {
					return false;
				}
				if (j >= 0 && !this.canPortalReplaceBlock(mutableBlockPos)) {
					return false;
				}
			}
		}
		return true;
	}
}
