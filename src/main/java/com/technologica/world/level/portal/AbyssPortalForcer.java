package com.technologica.world.level.portal;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;

import com.technologica.capabilities.item.link.PortalHook;
import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.registration.deferred.TechnologicaPoiTypes;
import com.technologica.world.level.block.AbyssPortalBlock;

import net.minecraft.BlockUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.TicketType;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraftforge.common.util.ITeleporter;

public class AbyssPortalForcer implements ITeleporter {
	protected ServerLevel level;
	protected BlockPos portalEntrancePos;
	protected Entity entity;

	public AbyssPortalForcer(ServerLevel serverLevel) {
		this.level = serverLevel;
	}

	@Override
	public PortalInfo getPortalInfo(Entity entity, ServerLevel destinationLevel, Function<ServerLevel, PortalInfo> defaultPortalInfo) {
		this.entity = entity;
		this.level = destinationLevel;
		PortalHook portalHook = entity.getCapability(PortalHook.PORTAL_HOOK_INSTANCE).orElseThrow(NullPointerException::new);
		return portalHook.findDimensionEntryPoint(destinationLevel);
	}

	@Override
	public boolean playTeleportSound(ServerPlayer player, ServerLevel sourceWorld, ServerLevel destWorld) {
		Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forLocalAmbience(SoundEvents.BUBBLE_COLUMN_WHIRLPOOL_AMBIENT, level.random.nextFloat() * 0.4F + 0.8F, 0.25F));
		return false;
	}

	public Optional<BlockUtil.FoundRectangle> findPortalAround(BlockPos blockPos, boolean isGoingToAbyss, WorldBorder worldBorder) {
		PoiManager poimanager = this.level.getPoiManager();
		int i = isGoingToAbyss ? 16 : 128;
		poimanager.ensureLoadedAndValid(this.level, blockPos, i);
		Optional<PoiRecord> optional = poimanager.getInSquare((poiType) -> {
			return poiType.is(TechnologicaPoiTypes.ABYSS_PORTAL.getKey());
		}, blockPos, i, PoiManager.Occupancy.ANY).filter((poiRecord) -> {
			return worldBorder.isWithinBounds(poiRecord.getPos());
		}).sorted(Comparator.<PoiRecord>comparingDouble((poiRecord) -> {
			return poiRecord.getPos().distSqr(blockPos);
		}).thenComparingInt((poiRecord) -> {
			return poiRecord.getPos().getY();
		})).filter((poiRecord) -> {
			return this.level.getBlockState(poiRecord.getPos()).hasProperty(BlockStateProperties.HORIZONTAL_AXIS);
		}).findFirst();
		return optional.map((poiRecord) -> {
			BlockPos blockpos = poiRecord.getPos();
			this.level.getChunkSource().addRegionTicket(TicketType.PORTAL, new ChunkPos(blockpos), 3, blockpos);
			BlockState blockState = this.level.getBlockState(blockpos);
			return BlockUtil.getLargestRectangleAround(blockpos, blockState.getValue(BlockStateProperties.HORIZONTAL_AXIS), 21, Direction.Axis.Y, 21, (blockPos2) -> {
				return this.level.getBlockState(blockPos2) == blockState;
			});
		});
	}

	public Optional<BlockUtil.FoundRectangle> createPortal(BlockPos blockPos, Direction.Axis axis) {
		Direction direction = Direction.get(Direction.AxisDirection.POSITIVE, axis);
		double d0 = -1.0D;
		BlockPos blockpos = null;
		double d1 = -1.0D;
		BlockPos blockpos1 = null;
		WorldBorder worldborder = this.level.getWorldBorder();
		int i = Math.min(this.level.getMaxBuildHeight(), this.level.getMinBuildHeight() + this.level.getLogicalHeight()) - 1;
		BlockPos.MutableBlockPos mutableBlockPos = blockPos.mutable();

		for (BlockPos.MutableBlockPos mutableBlockPos2 : BlockPos.spiralAround(blockPos, 16, Direction.EAST, Direction.SOUTH)) {
			int j = Math.min(i, this.level.getHeight(Heightmap.Types.MOTION_BLOCKING, mutableBlockPos2.getX(), mutableBlockPos2.getZ()));
			if (worldborder.isWithinBounds(mutableBlockPos2) && worldborder.isWithinBounds(mutableBlockPos2.move(direction, 1))) {
				mutableBlockPos2.move(direction.getOpposite(), 1);

				for (int l = j; l >= this.level.getMinBuildHeight(); --l) {
					mutableBlockPos2.setY(l);
					if (this.canPortalReplaceBlock(mutableBlockPos2)) {
						int i1;
						for (i1 = l; l > this.level.getMinBuildHeight() && this.canPortalReplaceBlock(mutableBlockPos2.move(Direction.DOWN)); --l) {
						}

						if (l + 4 <= i) {
							int j1 = i1 - l;
							if (j1 <= 0 || j1 >= 3) {
								mutableBlockPos2.setY(l);
								if (this.canHostFrame(mutableBlockPos2, mutableBlockPos, direction, 0)) {
									double d2 = blockPos.distSqr(mutableBlockPos2);
									if (this.canHostFrame(mutableBlockPos2, mutableBlockPos, direction, -1) && this.canHostFrame(mutableBlockPos2, mutableBlockPos, direction, 1) && (d0 == -1.0D || d0 > d2)) {
										d0 = d2;
										blockpos = mutableBlockPos2.immutable();
									}

									if (d0 == -1.0D && (d1 == -1.0D || d1 > d2)) {
										d1 = d2;
										blockpos1 = mutableBlockPos2.immutable();
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
			int k1 = Math.max(this.level.getMinBuildHeight() - -1, 70);
			int i2 = i - 9;
			if (i2 < k1) {
				return Optional.empty();
			}

			blockpos = (new BlockPos(blockPos.getX(), Mth.clamp(blockPos.getY(), k1, i2), blockPos.getZ())).immutable();
			Direction direction1 = direction.getClockWise();
			if (!worldborder.isWithinBounds(blockpos)) {
				return Optional.empty();
			}

			for (int i3 = -1; i3 < 2; ++i3) {
				for (int j3 = 0; j3 < 2; ++j3) {
					for (int k3 = -1; k3 < 3; ++k3) {
						BlockState blockState = k3 < 0 ? Blocks.PRISMARINE.defaultBlockState() : Blocks.AIR.defaultBlockState();
						mutableBlockPos.setWithOffset(blockpos, j3 * direction.getStepX() + i3 * direction1.getStepX(), k3, j3 * direction.getStepZ() + i3 * direction1.getStepZ());
						this.level.setBlockAndUpdate(mutableBlockPos, blockState);
					}
				}
			}
		}

		for (int l1 = -1; l1 < 3; ++l1) {
			for (int j2 = -1; j2 < 4; ++j2) {
				if (l1 == -1 || l1 == 2 || j2 == -1 || j2 == 3) {
					mutableBlockPos.setWithOffset(blockpos, l1 * direction.getStepX(), j2, l1 * direction.getStepZ());
					this.level.setBlock(mutableBlockPos, Blocks.PRISMARINE.defaultBlockState(), 3);
				}
			}
		}

		BlockState blockState = TechnologicaBlocks.ABYSS_PORTAL.get().defaultBlockState().setValue(AbyssPortalBlock.AXIS, axis);

		for (int k2 = 0; k2 < 2; ++k2) {
			for (int l2 = 0; l2 < 3; ++l2) {
				mutableBlockPos.setWithOffset(blockpos, k2 * direction.getStepX(), l2, k2 * direction.getStepZ());
				this.level.setBlock(mutableBlockPos, blockState, 18);
			}
		}

		return Optional.of(new BlockUtil.FoundRectangle(blockpos.immutable(), 2, 3));
	}

	private boolean canPortalReplaceBlock(BlockPos.MutableBlockPos mutableBlockPos) {
		BlockState blockState = level.getBlockState(mutableBlockPos);
		return blockState.canBeReplaced();
	}

	@SuppressWarnings("deprecation")
	private boolean canHostFrame(BlockPos blockPos, BlockPos.MutableBlockPos mutableBlockPos, Direction direction, int offset) {
		Direction clockWiseDirection = direction.getClockWise();
		for (int i = -1; i < 3; ++i) {
			for (int j = -1; j < 4; ++j) {
				mutableBlockPos.setWithOffset(blockPos, direction.getStepX() * i + clockWiseDirection.getStepX() * offset, j, direction.getStepZ() * i + clockWiseDirection.getStepZ() * offset);
				if (j < 0 && !level.getBlockState(mutableBlockPos).isSolid()) {
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
