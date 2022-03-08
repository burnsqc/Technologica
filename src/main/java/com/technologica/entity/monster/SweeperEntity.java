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
	private static final DataParameter<Integer> STATE = EntityDataManager.createKey(SweeperEntity.class, DataSerializers.VARINT);
	private static final DataParameter<Boolean> POWERED = EntityDataManager.createKey(SweeperEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IGNITED = EntityDataManager.createKey(SweeperEntity.class, DataSerializers.BOOLEAN);

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
		return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D);
	}

	/**
	 * The maximum height from where the entity is alowed to jump (used in
	 * pathfinder)
	 */
	public int getMaxFallHeight() {
		return this.getAttackTarget() == null ? 3 : 3 + (int) (this.getHealth() - 1.0F);
	}

	public boolean onLivingFall(float distance, float damageMultiplier) {
		boolean flag = super.onLivingFall(distance, damageMultiplier);
		return flag;
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(STATE, -1);
		this.dataManager.register(POWERED, false);
		this.dataManager.register(IGNITED, false);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		if (this.dataManager.get(POWERED)) {
			compound.putBoolean("powered", true);
		}
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.dataManager.set(POWERED, compound.getBoolean("powered"));
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void tick() {
		super.tick();
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_CREEPER_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_CREEPER_DEATH;
	}

	protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropSpecialItems(source, looting, recentlyHitIn);
		Entity entity = source.getTrueSource();
		if (entity != this && entity instanceof SweeperEntity) {
			SweeperEntity creeperentity = (SweeperEntity) entity;
			if (creeperentity.ableToCauseSkullDrop()) {
				creeperentity.incrementDroppedSkulls();
				this.entityDropItem(Items.CREEPER_HEAD);
			}
		}

	}

	public boolean attackEntityAsMob(Entity entityIn) {
		return true;
	}

	public boolean isCharged() {
		return this.dataManager.get(POWERED);
	}

	/**
	 * Returns the current state of creeper, -1 is idle, 1 is 'in fuse'
	 */
	public int getCreeperState() {
		return this.dataManager.get(STATE);
	}

	/**
	 * Sets the state of creeper, -1 to idle and 1 to be 'in fuse'
	 */
	public void setCreeperState(int state) {
		this.dataManager.set(STATE, state);
	}

	public void causeLightningStrike(ServerWorld world, LightningBoltEntity lightning) {
		super.causeLightningStrike(world, lightning);
		this.dataManager.set(POWERED, true);
	}

	protected ActionResultType getEntityInteractionResult(PlayerEntity playerIn, Hand hand) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		if (itemstack.getItem() == Items.FLINT_AND_STEEL) {
			this.world.playSound(playerIn, this.getPosX(), this.getPosY(), this.getPosZ(),
					SoundEvents.ITEM_FLINTANDSTEEL_USE, this.getSoundCategory(), 1.0F,
					this.rand.nextFloat() * 0.4F + 0.8F);
			if (!this.world.isRemote) {
				this.ignite();
				itemstack.damageItem(1, playerIn, (player) -> {
					player.sendBreakAnimation(hand);
				});
			}

			return ActionResultType.func_233537_a_(this.world.isRemote);
		} else {
			return super.getEntityInteractionResult(playerIn, hand);
		}
	}

	public boolean hasIgnited() {
		return this.dataManager.get(IGNITED);
	}

	public void ignite() {
		this.dataManager.set(IGNITED, true);
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
