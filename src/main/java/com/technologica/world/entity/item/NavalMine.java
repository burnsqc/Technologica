package com.technologica.world.entity.item;

import java.util.List;

import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.registration.deferred.TechnologicaEntityTypes;
import com.technologica.world.level.block.NavalMineChainBlock;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

public class NavalMine extends Entity {
	private static final EntityDataAccessor<Boolean> ASCENDING = SynchedEntityData.defineId(NavalMine.class, EntityDataSerializers.BOOLEAN);
	private boolean ascending = false;
	private boolean detonate = false;
	private int armingFuse = 100;
	public int chains;

	public NavalMine(EntityType<? extends NavalMine> type, Level worldIn) {
		super(type, worldIn);
		blocksBuilding = true;
	}

	public NavalMine(Level worldIn, double x, double y, double z, int chains) {
		this(TechnologicaEntityTypes.NAVAL_MINE.get(), worldIn);
		this.setPos(x, y, z);
		this.armingFuse = 100;
		this.chains = chains;
		this.xo = x;
		this.yo = y;
		this.zo = z;
	}

	@Override
	protected void defineSynchedData() {
		this.entityData.define(ASCENDING, false);
	}

	@Override
	public boolean canCollideWith(Entity entity) {
		return true;
	}

	@Override
	public boolean isPickable() {
		return true;
	}

	@Override
	public void tick() {
		Level level = this.level();
		if (!level.isClientSide) {
			if (detonate) {
				discard();
				explode();
				if (level().getBlockState(blockPosition()).getBlock() instanceof NavalMineChainBlock chain) {
					level().scheduleTick(blockPosition(), chain, 1);
				}
			} else {
				if (armingFuse > 0) {
					--armingFuse;
				} else {
					List<Entity> list = level().getEntities(this, getBoundingBox().inflate(0.2F, 0.2F, 0.2F));
					for (Entity entity : list) {
						if (!(entity instanceof ItemEntity) && !(entity instanceof WaterAnimal)) {
							this.detonate = true;
						}
					}
				}
			}

			/*
			 * Ascension logic
			 */
			boolean waterAbove = level().getBlockState(this.blockPosition().above().above()).getFluidState().is(FluidTags.WATER);
			boolean chainIn = level().getBlockState(this.blockPosition()).is(TechnologicaBlocks.NAVAL_MINE_CHAIN.get());

			if (waterAbove) {
				if (this.chains == 0) { // Out of chains
					if (chainIn) {
						this.entityData.set(ASCENDING, false);
					} else {
						this.entityData.set(ASCENDING, true);
					}
				} else { // Has chains
					this.entityData.set(ASCENDING, true);
					if (!chainIn) {
						level().setBlockAndUpdate(this.blockPosition(), TechnologicaBlocks.NAVAL_MINE_CHAIN.get().defaultBlockState());
						level().sendBlockUpdated(this.blockPosition(), level().getBlockState(this.blockPosition()), TechnologicaBlocks.NAVAL_MINE_CHAIN.get().defaultBlockState(), 3);
						this.chains--;
					}
				}
			} else {
				this.entityData.set(ASCENDING, false);
			}
		}

		// Render the ascension smoothly for the client in sync with server
		if (this.ascending) {
			Vec3 vector3d = this.getDeltaMovement().add(0.0D, 0.1D, 0.0D);
			this.move(MoverType.SELF, vector3d);
		} else if (this.position().y < (this.blockPosition().getY() + 0.5)) { // Round out the final position so it stop in the middle of a block. This is preferred so that too much of the mine won't be above water level.
			Vec3 vector3d = this.getDeltaMovement().add(0.0D, 0.1D, 0.0D);
			this.move(MoverType.SELF, vector3d);
		}
	}

	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> key) {
		if (ASCENDING.equals(key)) {
			this.ascending = this.entityData.get(ASCENDING);
		}
	}

	public boolean getAscendingDataManager() {
		return this.entityData.get(ASCENDING);
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		this.detonate = true;
		return true;
	}

	protected void explode() {
		this.level().explode(this, this.getX(), this.getY(), this.getZ(), 8.0F, Level.ExplosionInteraction.TNT);
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag compound) {
		compound.putShort("Fuse", (short) this.armingFuse);
		compound.putBoolean("Detonate", this.detonate);
		compound.putShort("Chains", (short) this.chains);
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag compound) {
		this.armingFuse = compound.getShort("Fuse");
		this.detonate = compound.getBoolean("Detonate");
		this.chains = compound.getShort("Chains");
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}
