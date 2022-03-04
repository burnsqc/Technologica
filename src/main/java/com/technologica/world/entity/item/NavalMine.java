package com.technologica.world.entity.item;

import java.util.List;

import com.technologica.world.entity.TechnologicaEntityType;
import com.technologica.world.level.block.NavalMineChainBlock;
import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

public class NavalMine extends Entity {
	private static final EntityDataAccessor<Integer> FUSE = SynchedEntityData.defineId(NavalMine.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> DETONATE = SynchedEntityData.defineId(NavalMine.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> CHAINS = SynchedEntityData.defineId(NavalMine.class, EntityDataSerializers.INT);
	private int armingFuse = 100;
	private boolean detonate = false;
	private int chains = 10;

	public NavalMine(EntityType<? extends NavalMine> type, Level worldIn) {
		super(type, worldIn);
		this.blocksBuilding = true;
	}

	public NavalMine(Level worldIn, double x, double y, double z) {
		this(TechnologicaEntityType.NAVAL_MINE.get(), worldIn);
		this.setPos(x, y, z);
		this.setFuse(100);
		this.setChains(10);
		this.xo = x;
		this.yo = y;
		this.zo = z;
	}

	protected void defineSynchedData() {
		this.entityData.define(FUSE, 100);
		this.entityData.define(DETONATE, false);
		this.entityData.define(CHAINS, 10);
	}

	protected boolean isMovementNoisy() {
		return false;
	}

	public boolean canCollideWith(Entity entity) {
		return true;
	}

	public boolean isPickable() {
		return true;
	}
	
	@Override
	public void tick() {
		if (this.getDetonate()) {
			this.discard();
			if (!this.level.isClientSide) {
				this.explode();
			}
		} else {
			if (this.getFuse() > 0) {
				--this.armingFuse;
			} else {
				List<Entity> list = this.level.getEntities(this, this.getBoundingBox().inflate((double) 0.2F, (double) -0.01F, (double) 0.2F), null);
				for (Entity entry : list) {
					if (!(entry instanceof ItemEntity)) {
						this.setDetonate(true);
					}
				}
			}
		}
		
		if (this.getChains() == 0 && !(this.level.getBlockState(this.blockPosition()).getBlock() instanceof NavalMineChainBlock) && this.level.getBlockState(this.blockPosition().above()).getFluidState().is(FluidTags.WATER)) {
			Vec3 vector3d = this.getDeltaMovement().add(0.0D, 0.1D, 0.0D);
			this.move(MoverType.SELF, vector3d);
		}
			
			
		if (this.getChains() > 0 && this.level.getBlockState(this.blockPosition().above()).getFluidState().is(FluidTags.WATER)) {
			Vec3 vector3d = this.getDeltaMovement().add(0.0D, 0.1D, 0.0D);
			this.move(MoverType.SELF, vector3d);
			
			
			if (!(this.level.getBlockState(this.blockPosition()).getBlock() instanceof NavalMineChainBlock)) {
				this.level.setBlockAndUpdate(this.blockPosition(), TechnologicaBlocks.NAVAL_MINE_CHAIN.get().defaultBlockState());
				this.level.sendBlockUpdated(this.blockPosition(), this.level.getBlockState(this.blockPosition()), TechnologicaBlocks.NAVAL_MINE_CHAIN.get().defaultBlockState(), 3);
				this.setChains(this.getChains() - 1);
			}	
		}
	
	}
	
	public boolean hurt(DamageSource source, float amount) {
		this.setDetonate(true);
		return true;
	}

	protected void explode() {
		this.level.explode(this, this.getX(), this.getY(), this.getZ(), 8.0F, Explosion.BlockInteraction.BREAK);
	}

	protected void addAdditionalSaveData(CompoundTag compound) {
		compound.putShort("Fuse", (short) this.getFuse());
		compound.putBoolean("Detonate", this.getDetonate());
		compound.putShort("Chains", (short) this.getChains());
	}

	protected void readAdditionalSaveData(CompoundTag compound) {
		this.setFuse(compound.getShort("Fuse"));
		this.setDetonate(compound.getBoolean("Detonate"));
		this.setChains(compound.getShort("Chains"));
	}

	public void setFuse(int fuseIn) {
		this.entityData.set(FUSE, fuseIn);
		this.armingFuse = fuseIn;
	}
	
	public void setDetonate(boolean detonateIn) {
		this.entityData.set(DETONATE, detonateIn);
		this.detonate = detonateIn;
	}
	
	public void setChains(int chainsIn) {
		this.entityData.set(CHAINS, chainsIn);
		this.chains = chainsIn;
	}

	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> key) {
		if (FUSE.equals(key)) {
			this.armingFuse = this.getFuseDataManager();
		}
		if (DETONATE.equals(key)) {
			this.detonate = this.getDetonateDataManager();
		}
		if (CHAINS.equals(key)) {
			this.chains = this.getChainsDataManager();
		}
	}

	public int getFuseDataManager() {
		return this.entityData.get(FUSE);
	}
	
	public boolean getDetonateDataManager() {
		return this.entityData.get(DETONATE);
	}
	
	public int getChainsDataManager() {
		return this.entityData.get(CHAINS);
	}
	

	public int getFuse() {
		return this.armingFuse;
	}
	
	public boolean getDetonate() {
		return this.detonate;
	}

	public int getChains() {
		return this.chains;
	}
	
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}