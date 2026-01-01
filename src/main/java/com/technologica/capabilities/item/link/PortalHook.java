package com.technologica.capabilities.item.link;

import java.util.Optional;

import javax.annotation.Nullable;

import com.technologica.Technologica;
import com.technologica.registration.dynamic.TechnologicaDimensions;
import com.technologica.world.level.block.AbyssPortalBlock;
import com.technologica.world.level.portal.AbyssPortalForcer;
import com.technologica.world.level.portal.AbyssPortalShape;

import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.util.INBTSerializable;

public class PortalHook implements INBTSerializable<CompoundTag> {
	private Entity entity;
	private boolean isInsidePortal;
	protected int portalTime;
	protected BlockPos blockPosEntrance;
	public static final Capability<PortalHook> PORTAL_HOOK_INSTANCE = CapabilityManager.get(new CapabilityToken<>() {
	});

	@SuppressWarnings("resource")
	public void handleInsidePortal(BlockPos blockPos, Entity entity) {
		this.entity = entity;
		if (entity.isOnPortalCooldown()) {
			entity.setPortalCooldown();
		} else {
			if (!entity.level().isClientSide && !blockPos.equals(this.blockPosEntrance)) {
				this.blockPosEntrance = blockPos.immutable();
			}
			this.isInsidePortal = true;
		}
	}

	public void handleAbyssPortal() {
		if (entity.level() instanceof ServerLevel) {
			int i = entity.getPortalWaitTime();
			ServerLevel serverlevel = (ServerLevel) entity.level();
			if (this.isInsidePortal) {
				MinecraftServer minecraftserver = serverlevel.getServer();
				ResourceKey<Level> resourcekey = entity.level().dimension() == Registries.levelStemToLevel(TechnologicaDimensions.ABYSS_STEM) ? Level.OVERWORLD : Registries.levelStemToLevel(TechnologicaDimensions.ABYSS_STEM);
				ServerLevel serverlevel1 = minecraftserver.getLevel(resourcekey);
				if (serverlevel1 != null && minecraftserver.isNetherEnabled() && !entity.isPassenger() && this.portalTime++ >= i) {
					entity.level().getProfiler().push("portal");
					this.portalTime = i;
					entity.setPortalCooldown();
					entity.changeDimension(serverlevel1, new AbyssPortalForcer(serverlevel1));
					entity.level().getProfiler().pop();
				}
				this.isInsidePortal = false;
			} else {
				if (this.portalTime > 0) {
					this.portalTime -= 4;
				}
				if (this.portalTime < 0) {
					this.portalTime = 0;
				}
			}
			entity.processPortalCooldown();
		}
	}

	@Nullable
	public PortalInfo findDimensionEntryPoint(ServerLevel serverLevel) {
		boolean isGoingToAbyss = serverLevel.dimension() == Registries.levelStemToLevel(TechnologicaDimensions.ABYSS_STEM);
		if (entity.level().dimension() != Registries.levelStemToLevel(TechnologicaDimensions.ABYSS_STEM) && !isGoingToAbyss) {
			return null;
		} else {
			WorldBorder worldborder = serverLevel.getWorldBorder();
			double d0 = DimensionType.getTeleportationScale(entity.level().dimensionType(), serverLevel.dimensionType());
			BlockPos blockpos1 = worldborder.clampToBounds(entity.getX() * d0, entity.getY(), entity.getZ() * d0);
			return this.getExitPortal(serverLevel, blockpos1, isGoingToAbyss, worldborder).map((rectangle) -> {
				BlockState blockState = entity.level().getBlockState(this.blockPosEntrance);
				Direction.Axis axis;
				Vec3 vec3;
				if (blockState.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
					axis = blockState.getValue(BlockStateProperties.HORIZONTAL_AXIS);
					BlockUtil.FoundRectangle foundRectangle = BlockUtil.getLargestRectangleAround(this.blockPosEntrance, axis, 21, Direction.Axis.Y, 21, (blockPos) -> {
						return entity.level().getBlockState(blockPos) == blockState;
					});
					vec3 = this.getRelativePortalPosition(axis, foundRectangle);
				} else {
					axis = Direction.Axis.X;
					vec3 = new Vec3(0.5D, 0.0D, 0.0D);
				}
				return AbyssPortalShape.createPortalInfo(serverLevel, rectangle, axis, vec3, entity, entity.getDeltaMovement(), entity.getYRot(), entity.getXRot());
			}).orElse((PortalInfo) null);
		}
	}

	protected Optional<BlockUtil.FoundRectangle> getExitPortal(ServerLevel serverLevel, BlockPos blockPos, boolean isGoingToAbyss, WorldBorder worldBorder) {
		Optional<BlockUtil.FoundRectangle> existingPortal = new AbyssPortalForcer(serverLevel).findPortalAround(blockPos, isGoingToAbyss, worldBorder);
		if (existingPortal.isPresent()) {
			return existingPortal;
		} else {
			Direction.Axis axis = entity.level().getBlockState(this.blockPosEntrance).getOptionalValue(AbyssPortalBlock.AXIS).orElse(Direction.Axis.X);
			Optional<BlockUtil.FoundRectangle> newPortal = new AbyssPortalForcer(serverLevel).createPortal(blockPos, axis);
			if (!newPortal.isPresent()) {
				Technologica.LOGGER.error("Unable to create a portal, likely target out of worldborder");
			}
			return newPortal;
		}
	}

	protected Vec3 getRelativePortalPosition(Direction.Axis axis, BlockUtil.FoundRectangle foundRectangle) {
		return PortalShape.getRelativePosition(foundRectangle, axis, entity.position(), entity.getDimensions(entity.getPose()));
	}

	@Override
	public CompoundTag serializeNBT() {
		final CompoundTag compoundTag = new CompoundTag();
		return compoundTag;
	}

	@Override
	public void deserializeNBT(CompoundTag compoundTag) {
	}
}
