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
	protected BlockPos portalEntrancePos;
	public static final Capability<PortalHook> PORTAL_HOOK_INSTANCE = CapabilityManager.get(new CapabilityToken<>() {
	});

	/*
	 * Entity
	 */
	@SuppressWarnings("resource")
	public void handleInsidePortal(BlockPos blockPos, Entity entity) {
		this.entity = entity;
		if (entity.isOnPortalCooldown()) {
			entity.setPortalCooldown();
		} else {
			if (!entity.level().isClientSide && !blockPos.equals(this.portalEntrancePos)) {
				this.portalEntrancePos = blockPos.immutable();
			}
			this.isInsidePortal = true;
		}
	}

	/*
	 * Entity
	 */
	public void handleNetherPortal() {
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

	/*
	 * Entity
	 */
	@Nullable
	public PortalInfo findDimensionEntryPoint(ServerLevel destinationServerLevel) {
		boolean isGoingToAbyss = destinationServerLevel.dimension() == Registries.levelStemToLevel(TechnologicaDimensions.ABYSS_STEM);
		if (entity.level().dimension() != Registries.levelStemToLevel(TechnologicaDimensions.ABYSS_STEM) && !isGoingToAbyss) {
			return null;
		} else {
			WorldBorder worldborder = destinationServerLevel.getWorldBorder();
			double d0 = DimensionType.getTeleportationScale(entity.level().dimensionType(), destinationServerLevel.dimensionType());
			BlockPos blockpos1 = worldborder.clampToBounds(entity.getX() * d0, entity.getY(), entity.getZ() * d0);
			return this.getExitPortal(destinationServerLevel, blockpos1, isGoingToAbyss, worldborder).map((p_258249_) -> {
				BlockState blockstate = entity.level().getBlockState(this.portalEntrancePos);
				Direction.Axis direction$axis;
				Vec3 vec3;
				if (blockstate.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
					direction$axis = blockstate.getValue(BlockStateProperties.HORIZONTAL_AXIS);
					BlockUtil.FoundRectangle blockutil$foundrectangle = BlockUtil.getLargestRectangleAround(this.portalEntrancePos, direction$axis, 21, Direction.Axis.Y, 21, (p_284700_) -> {
						return entity.level().getBlockState(p_284700_) == blockstate;
					});
					vec3 = this.getRelativePortalPosition(direction$axis, blockutil$foundrectangle);
				} else {
					direction$axis = Direction.Axis.X;
					vec3 = new Vec3(0.5D, 0.0D, 0.0D);
				}
				return AbyssPortalShape.createPortalInfo(destinationServerLevel, p_258249_, direction$axis, vec3, entity, entity.getDeltaMovement(), entity.getYRot(), entity.getXRot());
			}).orElse((PortalInfo) null);
		}
	}

	protected Optional<BlockUtil.FoundRectangle> getExitPortal(ServerLevel destinationServerLevel, BlockPos blockPos, boolean isGoingToAbyss, WorldBorder worldBorder) {
		Optional<BlockUtil.FoundRectangle> existingPortal = new AbyssPortalForcer(destinationServerLevel).findPortalAround(blockPos, isGoingToAbyss, worldBorder);
		if (existingPortal.isPresent()) {
			return existingPortal;
		} else {
			Direction.Axis direction$axis = entity.level().getBlockState(this.portalEntrancePos).getOptionalValue(AbyssPortalBlock.AXIS).orElse(Direction.Axis.X);
			Optional<BlockUtil.FoundRectangle> newPortal = new AbyssPortalForcer(destinationServerLevel).createPortal(blockPos, direction$axis);
			if (!newPortal.isPresent()) {
				Technologica.LOGGER.error("Unable to create a portal, likely target out of worldborder");
			}
			return newPortal;
		}
	}

	protected Vec3 getRelativePortalPosition(Direction.Axis p_20045_, BlockUtil.FoundRectangle p_20046_) {
		return PortalShape.getRelativePosition(p_20046_, p_20045_, entity.position(), entity.getDimensions(entity.getPose()));
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
