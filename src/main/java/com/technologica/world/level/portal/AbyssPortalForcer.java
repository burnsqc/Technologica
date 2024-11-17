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
		Optional<PoiRecord> optional = poimanager.getInSquare((p_230634_) -> {
			return p_230634_.is(TechnologicaPoiTypes.ABYSS_PORTAL.getKey());
		}, blockPos, i, PoiManager.Occupancy.ANY).filter((p_192981_) -> {
			return worldBorder.isWithinBounds(p_192981_.getPos());
		}).sorted(Comparator.<PoiRecord>comparingDouble((p_192984_) -> {
			return p_192984_.getPos().distSqr(blockPos);
		}).thenComparingInt((p_192992_) -> {
			return p_192992_.getPos().getY();
		})).filter((p_192990_) -> {
			return this.level.getBlockState(p_192990_.getPos()).hasProperty(BlockStateProperties.HORIZONTAL_AXIS);
		}).findFirst();
		return optional.map((p_192975_) -> {
			BlockPos blockpos = p_192975_.getPos();
			this.level.getChunkSource().addRegionTicket(TicketType.PORTAL, new ChunkPos(blockpos), 3, blockpos);
			BlockState blockstate = this.level.getBlockState(blockpos);
			return BlockUtil.getLargestRectangleAround(blockpos, blockstate.getValue(BlockStateProperties.HORIZONTAL_AXIS), 21, Direction.Axis.Y, 21, (p_192978_) -> {
				return this.level.getBlockState(p_192978_) == blockstate;
			});
		});
	}

	public Optional<BlockUtil.FoundRectangle> createPortal(BlockPos p_77667_, Direction.Axis p_77668_) {
		Direction direction = Direction.get(Direction.AxisDirection.POSITIVE, p_77668_);
		double d0 = -1.0D;
		BlockPos blockpos = null;
		double d1 = -1.0D;
		BlockPos blockpos1 = null;
		WorldBorder worldborder = this.level.getWorldBorder();
		int i = Math.min(this.level.getMaxBuildHeight(), this.level.getMinBuildHeight() + this.level.getLogicalHeight()) - 1;
		BlockPos.MutableBlockPos blockpos$mutableblockpos = p_77667_.mutable();

		for (BlockPos.MutableBlockPos blockpos$mutableblockpos1 : BlockPos.spiralAround(p_77667_, 16, Direction.EAST, Direction.SOUTH)) {
			int j = Math.min(i, this.level.getHeight(Heightmap.Types.MOTION_BLOCKING, blockpos$mutableblockpos1.getX(), blockpos$mutableblockpos1.getZ()));
			if (worldborder.isWithinBounds(blockpos$mutableblockpos1) && worldborder.isWithinBounds(blockpos$mutableblockpos1.move(direction, 1))) {
				blockpos$mutableblockpos1.move(direction.getOpposite(), 1);

				for (int l = j; l >= this.level.getMinBuildHeight(); --l) {
					blockpos$mutableblockpos1.setY(l);
					if (this.canPortalReplaceBlock(blockpos$mutableblockpos1)) {
						int i1;
						for (i1 = l; l > this.level.getMinBuildHeight() && this.canPortalReplaceBlock(blockpos$mutableblockpos1.move(Direction.DOWN)); --l) {
						}

						if (l + 4 <= i) {
							int j1 = i1 - l;
							if (j1 <= 0 || j1 >= 3) {
								blockpos$mutableblockpos1.setY(l);
								if (this.canHostFrame(blockpos$mutableblockpos1, blockpos$mutableblockpos, direction, 0)) {
									double d2 = p_77667_.distSqr(blockpos$mutableblockpos1);
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
			int k1 = Math.max(this.level.getMinBuildHeight() - -1, 70);
			int i2 = i - 9;
			if (i2 < k1) {
				return Optional.empty();
			}

			blockpos = (new BlockPos(p_77667_.getX(), Mth.clamp(p_77667_.getY(), k1, i2), p_77667_.getZ())).immutable();
			Direction direction1 = direction.getClockWise();
			if (!worldborder.isWithinBounds(blockpos)) {
				return Optional.empty();
			}

			for (int i3 = -1; i3 < 2; ++i3) {
				for (int j3 = 0; j3 < 2; ++j3) {
					for (int k3 = -1; k3 < 3; ++k3) {
						BlockState blockstate1 = k3 < 0 ? Blocks.PRISMARINE.defaultBlockState() : Blocks.AIR.defaultBlockState();
						blockpos$mutableblockpos.setWithOffset(blockpos, j3 * direction.getStepX() + i3 * direction1.getStepX(), k3, j3 * direction.getStepZ() + i3 * direction1.getStepZ());
						this.level.setBlockAndUpdate(blockpos$mutableblockpos, blockstate1);
					}
				}
			}
		}

		for (int l1 = -1; l1 < 3; ++l1) {
			for (int j2 = -1; j2 < 4; ++j2) {
				if (l1 == -1 || l1 == 2 || j2 == -1 || j2 == 3) {
					blockpos$mutableblockpos.setWithOffset(blockpos, l1 * direction.getStepX(), j2, l1 * direction.getStepZ());
					this.level.setBlock(blockpos$mutableblockpos, Blocks.PRISMARINE.defaultBlockState(), 3);
				}
			}
		}

		BlockState blockstate = TechnologicaBlocks.ABYSS_PORTAL.get().defaultBlockState().setValue(AbyssPortalBlock.AXIS, p_77668_);

		for (int k2 = 0; k2 < 2; ++k2) {
			for (int l2 = 0; l2 < 3; ++l2) {
				blockpos$mutableblockpos.setWithOffset(blockpos, k2 * direction.getStepX(), l2, k2 * direction.getStepZ());
				this.level.setBlock(blockpos$mutableblockpos, blockstate, 18);
			}
		}

		return Optional.of(new BlockUtil.FoundRectangle(blockpos.immutable(), 2, 3));
	}

	private boolean canPortalReplaceBlock(BlockPos.MutableBlockPos mutableBlockPos) {
		BlockState blockstate = level.getBlockState(mutableBlockPos);
		return blockstate.canBeReplaced();
	}

	@SuppressWarnings("deprecation")
	private boolean canHostFrame(BlockPos blockPos, BlockPos.MutableBlockPos mutableBlockPos, Direction direction, int p_77665_) {
		Direction clockWiseDirection = direction.getClockWise();
		for (int i = -1; i < 3; ++i) {
			for (int j = -1; j < 4; ++j) {
				mutableBlockPos.setWithOffset(blockPos, direction.getStepX() * i + clockWiseDirection.getStepX() * p_77665_, j, direction.getStepZ() * i + clockWiseDirection.getStepZ() * p_77665_);
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
