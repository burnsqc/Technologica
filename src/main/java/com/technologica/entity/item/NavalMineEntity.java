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
	private static final DataParameter<Integer> FUSE = EntityDataManager.createKey(NavalMineEntity.class, DataSerializers.VARINT);
	private static final DataParameter<Boolean> DETONATE = EntityDataManager.createKey(NavalMineEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Integer> CHAINS = EntityDataManager.createKey(NavalMineEntity.class, DataSerializers.VARINT);
	private int armingFuse = 100;
	private boolean detonate = false;
	private int chains = 10;

	public NavalMineEntity(EntityType<? extends NavalMineEntity> type, World worldIn) {
		super(type, worldIn);
		this.preventEntitySpawning = true;
	}

	public NavalMineEntity(World worldIn, double x, double y, double z) {
		this(TechnologicaEntityType.NAVAL_MINE.get(), worldIn);
		this.setPosition(x, y, z);
		this.setFuse(100);
		this.setChains(10);
		this.prevPosX = x;
		this.prevPosY = y;
		this.prevPosZ = z;
	}

	protected void registerData() {
		this.dataManager.register(FUSE, 100);
		this.dataManager.register(DETONATE, false);
		this.dataManager.register(CHAINS, 10);
	}

	protected boolean canTriggerWalking() {
		return false;
	}

	public boolean canCollide(Entity entity) {
		return true;
	}

	public boolean canBeCollidedWith() {
		return true;
	}
	
	@Override
	public void tick() {
		if (this.getDetonate()) {
			this.remove();
			if (!this.world.isRemote) {
				this.explode();
			}
		} else {
			if (this.getFuse() > 0) {
				--this.armingFuse;
			} else {
				List<Entity> list = this.world.getEntitiesInAABBexcluding(this, this.getBoundingBox().grow((double) 0.2F, (double) -0.01F, (double) 0.2F), null);
				for (Entity entry : list) {
					if (!(entry instanceof ItemEntity)) {
						this.setDetonate(true);
					}
				}
			}
		}
		
		if (this.getChains() == 0 && !(this.world.getBlockState(this.getPosition()).getBlock() instanceof NavalMineChainBlock) && this.world.getBlockState(this.getPosition().up()).getFluidState().isTagged(FluidTags.WATER)) {
			Vector3d vector3d = this.getMotion().add(0.0D, 0.1D, 0.0D);
			this.move(MoverType.SELF, vector3d);
		}
			
			
		if (this.getChains() > 0 && this.world.getBlockState(this.getPosition().up()).getFluidState().isTagged(FluidTags.WATER)) {
			Vector3d vector3d = this.getMotion().add(0.0D, 0.1D, 0.0D);
			this.move(MoverType.SELF, vector3d);
			
			
			if (!(this.world.getBlockState(this.getPosition()).getBlock() instanceof NavalMineChainBlock)) {
				this.world.setBlockState(this.getPosition(), TechnologicaBlocks.NAVAL_MINE_CHAIN.get().getDefaultState());
				this.world.notifyBlockUpdate(this.getPosition(), this.world.getBlockState(this.getPosition()), TechnologicaBlocks.NAVAL_MINE_CHAIN.get().getDefaultState(), 3);
				this.setChains(this.getChains() - 1);
			}	
		}
	
	}
	
	public boolean attackEntityFrom(DamageSource source, float amount) {
		this.setDetonate(true);
		return true;
	}

	protected void explode() {
		this.world.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), 8.0F, Explosion.Mode.BREAK);
	}

	protected void writeAdditional(CompoundNBT compound) {
		compound.putShort("Fuse", (short) this.getFuse());
		compound.putBoolean("Detonate", this.getDetonate());
		compound.putShort("Chains", (short) this.getChains());
	}

	protected void readAdditional(CompoundNBT compound) {
		this.setFuse(compound.getShort("Fuse"));
		this.setDetonate(compound.getBoolean("Detonate"));
		this.setChains(compound.getShort("Chains"));
	}

	public void setFuse(int fuseIn) {
		this.dataManager.set(FUSE, fuseIn);
		this.armingFuse = fuseIn;
	}
	
	public void setDetonate(boolean detonateIn) {
		this.dataManager.set(DETONATE, detonateIn);
		this.detonate = detonateIn;
	}
	
	public void setChains(int chainsIn) {
		this.dataManager.set(CHAINS, chainsIn);
		this.chains = chainsIn;
	}

	@Override
	public void notifyDataManagerChange(DataParameter<?> key) {
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
		return this.dataManager.get(FUSE);
	}
	
	public boolean getDetonateDataManager() {
		return this.dataManager.get(DETONATE);
	}
	
	public int getChainsDataManager() {
		return this.dataManager.get(CHAINS);
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
	
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}