package com.technologica.world.entity.monster;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.PowerableMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class Weeper extends Monster implements PowerableMob {
	private static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(Weeper.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> POWERED = SynchedEntityData.defineId(Weeper.class, EntityDataSerializers.BOOLEAN);
	private int droppedSkulls;

	public Weeper(EntityType<? extends Weeper> type, Level worldIn) {
		super(type, worldIn);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 32.0F));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1.0D));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 0.25D);
	}

	/**
	 * The maximum height from where the entity is alowed to jump (used in
	 * pathfinder)
	 */
	@Override
	public int getMaxFallDistance() {
		return this.getTarget() == null ? 3 : 3 + (int) (this.getHealth() - 1.0F);
	}

	@Override
	public boolean causeFallDamage(float p_149687_, float p_149688_, DamageSource p_149689_) {
		boolean flag = super.causeFallDamage(p_149687_, p_149688_, p_149689_);
		return flag;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(STATE, -1);
		this.entityData.define(POWERED, false);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		if (this.entityData.get(POWERED)) {
			compound.putBoolean("powered", true);
		}
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.entityData.set(POWERED, compound.getBoolean("powered"));
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.CREEPER_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.CREEPER_DEATH;
	}

	@Override
	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		Entity entity = source.getEntity();
		if (entity != this && entity instanceof Weeper) {
			Weeper creeperentity = (Weeper) entity;
			if (creeperentity.ableToCauseSkullDrop()) {
				creeperentity.incrementDroppedSkulls();
				this.spawnAtLocation(Items.CREEPER_HEAD);
			}
		}

	}

	@Override
	public boolean doHurtTarget(Entity entityIn) {
		return true;
	}

	@Override
	public boolean isPowered() {
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

	@Override
	public void thunderHit(ServerLevel world, LightningBolt lightning) {
		super.thunderHit(world, lightning);
		this.entityData.set(POWERED, true);
	}

	@Override
	protected InteractionResult mobInteract(Player playerIn, InteractionHand hand) {
		ItemStack itemstack = playerIn.getItemInHand(hand);
		if (itemstack.getItem() == Items.FLINT_AND_STEEL) {
			this.level().playSound(playerIn, this.getX(), this.getY(), this.getZ(), SoundEvents.FLINTANDSTEEL_USE, this.getSoundSource(), 1.0F, this.random.nextFloat() * 0.4F + 0.8F);
			if (!this.level().isClientSide) {
				itemstack.hurtAndBreak(1, playerIn, (player) -> {
					player.broadcastBreakEvent(hand);
				});
			}

			return InteractionResult.sidedSuccess(this.level().isClientSide);
		} else {
			return super.mobInteract(playerIn, hand);
		}
	}

	/**
	 * Returns true if an entity is able to drop its skull due to being blown up by
	 * this creeper.
	 * 
	 * Does not test if this creeper is charged" the caller must do that. However,
	 * does test the doMobLoot gamerule.
	 */
	public boolean ableToCauseSkullDrop() {
		return this.isPowered() && this.droppedSkulls < 1;
	}

	public void incrementDroppedSkulls() {
		++this.droppedSkulls;
	}
}
