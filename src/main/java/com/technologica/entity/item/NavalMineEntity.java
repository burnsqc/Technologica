package com.technologica.entity.item;

import java.util.List;

import com.technologica.block.NavalMineChainBlock;
import com.technologica.block.TechnologicaBlocks;
import com.technologica.entity.TechnologicaEntityType;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class NavalMineEntity extends Entity {
	private static final DataParameter<Integer> FUSE = EntityDataManager.defineId(NavalMineEntity.class, DataSerializers.INT);
	private static final DataParameter<Boolean> DETONATE = EntityDataManager.defineId(NavalMineEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Integer> CHAINS = EntityDataManager.defineId(NavalMineEntity.class, DataSerializers.INT);
	private int armingFuse = 100;
	private boolean detonate = false;
	private int chains = 10;

	public NavalMineEntity(EntityType<? extends NavalMineEntity> type, World worldIn) {
		super(type, worldIn);
		this.blocksBuilding = true;
	}

	public NavalMineEntity(World worldIn, double x, double y, double z) {
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
			this.remove();
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
			Vector3d vector3d = this.getDeltaMovement().add(0.0D, 0.1D, 0.0D);
			this.move(MoverType.SELF, vector3d);
		}
			
			
		if (this.getChains() > 0 && this.level.getBlockState(this.blockPosition().above()).getFluidState().is(FluidTags.WATER)) {
			Vector3d vector3d = this.getDeltaMovement().add(0.0D, 0.1D, 0.0D);
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
		this.level.explode(this, this.getX(), this.getY(), this.getZ(), 8.0F, Explosion.Mode.BREAK);
	}

	protected void addAdditionalSaveData(CompoundNBT compound) {
		compound.putShort("Fuse", (short) this.getFuse());
		compound.putBoolean("Detonate", this.getDetonate());
		compound.putShort("Chains", (short) this.getChains());
	}

	protected void readAdditionalSaveData(CompoundNBT compound) {
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
	public void onSyncedDataUpdated(DataParameter<?> key) {
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
	
	public IPacket<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}