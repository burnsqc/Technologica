package com.technologica.entity.monster;

import com.technologica.entity.ai.PickupItemGoal;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class SweeperEntity extends MonsterEntity {
	private static final DataParameter<Integer> STATE = EntityDataManager.defineId(SweeperEntity.class, DataSerializers.INT);
	private static final DataParameter<Boolean> POWERED = EntityDataManager.defineId(SweeperEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IGNITED = EntityDataManager.defineId(SweeperEntity.class, DataSerializers.BOOLEAN);

	private int droppedSkulls;

	public SweeperEntity(EntityType<? extends SweeperEntity> type, World worldIn) {
		super(type, worldIn);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new PickupItemGoal(this));
		this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 1.0D));
	}

	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return MonsterEntity.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 0.25D);
	}

	/**
	 * The maximum height from where the entity is alowed to jump (used in
	 * pathfinder)
	 */
	public int getMaxFallDistance() {
		return this.getTarget() == null ? 3 : 3 + (int) (this.getHealth() - 1.0F);
	}

	public boolean causeFallDamage(float distance, float damageMultiplier) {
		boolean flag = super.causeFallDamage(distance, damageMultiplier);
		return flag;
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(STATE, -1);
		this.entityData.define(POWERED, false);
		this.entityData.define(IGNITED, false);
	}

	public void addAdditionalSaveData(CompoundNBT compound) {
		super.addAdditionalSaveData(compound);
		if (this.entityData.get(POWERED)) {
			compound.putBoolean("powered", true);
		}
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readAdditionalSaveData(CompoundNBT compound) {
		super.readAdditionalSaveData(compound);
		this.entityData.set(POWERED, compound.getBoolean("powered"));
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void tick() {
		super.tick();
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.CREEPER_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.CREEPER_DEATH;
	}

	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		Entity entity = source.getEntity();
		if (entity != this && entity instanceof SweeperEntity) {
			SweeperEntity creeperentity = (SweeperEntity) entity;
			if (creeperentity.ableToCauseSkullDrop()) {
				creeperentity.incrementDroppedSkulls();
				this.spawnAtLocation(Items.CREEPER_HEAD);
			}
		}

	}

	public boolean doHurtTarget(Entity entityIn) {
		return true;
	}

	public boolean isCharged() {
		return this.entityData.get(POWERED);
	}

	/**
	 * Returns the current state of creeper, -1 is idle, 1 is 'in fuse'
	 */
	public int getCreeperState() {
		return this.entityData.get(STATE);
	}

	/**
	 * Sets the state of creeper, -1 to idle and 1 to be 'in fuse'
	 */
	public void setCreeperState(int state) {
		this.entityData.set(STATE, state);
	}

	public void thunderHit(ServerWorld world, LightningBoltEntity lightning) {
		super.thunderHit(world, lightning);
		this.entityData.set(POWERED, true);
	}

	protected ActionResultType mobInteract(PlayerEntity playerIn, Hand hand) {
		ItemStack itemstack = playerIn.getItemInHand(hand);
		if (itemstack.getItem() == Items.FLINT_AND_STEEL) {
			this.level.playSound(playerIn, this.getX(), this.getY(), this.getZ(),
					SoundEvents.FLINTANDSTEEL_USE, this.getSoundSource(), 1.0F,
					this.random.nextFloat() * 0.4F + 0.8F);
			if (!this.level.isClientSide) {
				this.ignite();
				itemstack.hurtAndBreak(1, playerIn, (player) -> {
					player.broadcastBreakEvent(hand);
				});
			}

			return ActionResultType.sidedSuccess(this.level.isClientSide);
		} else {
			return super.mobInteract(playerIn, hand);
		}
	}

	public boolean hasIgnited() {
		return this.entityData.get(IGNITED);
	}

	public void ignite() {
		this.entityData.set(IGNITED, true);
	}

	/**
	 * Returns true if an entity is able to drop its skull due to being blown up by
	 * this creeper.
	 * 
	 * Does not test if this creeper is charged" the caller must do that. However,
	 * does test the doMobLoot gamerule.
	 */
	public boolean ableToCauseSkullDrop() {
		return this.isCharged() && this.droppedSkulls < 1;
	}

	public void incrementDroppedSkulls() {
		++this.droppedSkulls;
	}
}
