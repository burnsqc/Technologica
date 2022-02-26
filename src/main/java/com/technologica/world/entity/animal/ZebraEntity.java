package com.technologica.world.entity.animal;

import java.util.UUID;

import javax.annotation.Nullable;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.animal.horse.Variant;
import net.minecraft.world.entity.animal.horse.Markings;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.Container;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.Util;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;

public class ZebraEntity extends AbstractHorse {
	private static final UUID ARMOR_MODIFIER_UUID = UUID.fromString("556E1665-8B10-40C8-8F9D-CF9B1667F295");
	private static final EntityDataAccessor<Integer> HORSE_VARIANT = SynchedEntityData.defineId(ZebraEntity.class,
			EntityDataSerializers.INT);

	public ZebraEntity(EntityType<? extends ZebraEntity> type, Level worldIn) {
		super(type, worldIn);
	}

	@Override
	public void randomizeAttributes() {
		this.getAttribute(Attributes.MAX_HEALTH).setBaseValue((double) this.generateRandomMaxHealth());
		this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(this.generateRandomSpeed());
		this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(this.generateRandomJumpStrength());
	}

	//Register Attributes, Goals, and Data
	//Attributes are registered inside AbstractHourseEntity with method createBaseHorseAttributes
	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(HORSE_VARIANT, 0);
	}

	public ItemStack getArmor() {
		return this.getItemBySlot(EquipmentSlot.CHEST);
	}

	private void setArmor(ItemStack p_213805_1_) {
		this.setItemSlot(EquipmentSlot.CHEST, p_213805_1_);
		this.setDropChance(EquipmentSlot.CHEST, 0.0F);
	}

	private void setTypeVariant(int p_234242_1_) {
		this.entityData.set(HORSE_VARIANT, p_234242_1_);
	}

	private int getTypeVariant() {
		return this.entityData.get(HORSE_VARIANT);
	}

	private void setVariantAndMarkings(Variant p_234238_1_, Markings p_234238_2_) {
		this.setTypeVariant(p_234238_1_.getId() & 255 | p_234238_2_.getId() << 8 & '\uff00');
	}

	public Variant getVariant() {
		return Variant.byId(this.getTypeVariant() & 255);
	}

	public Markings getMarkings() {
		return Markings.byId((this.getTypeVariant() & '\uff00') >> 8);
	}

	@Override
	protected void updateContainerEquipment() {
		if (!this.level.isClientSide) {
			super.updateContainerEquipment();
			this.setArmorEquipment(this.inventory.getItem(1));
			this.setDropChance(EquipmentSlot.CHEST, 0.0F);
		}
	}

	private void setArmorEquipment(ItemStack p_213804_1_) {
		this.setArmor(p_213804_1_);
		if (!this.level.isClientSide) {
			this.getAttribute(Attributes.ARMOR).removeModifier(ARMOR_MODIFIER_UUID);
			if (this.isArmor(p_213804_1_)) {
				int i = ((HorseArmorItem) p_213804_1_.getItem()).getProtection();
				if (i != 0) {
					this.getAttribute(Attributes.ARMOR)
							.addTransientModifier(new AttributeModifier(ARMOR_MODIFIER_UUID, "Horse armor bonus",
									(double) i, AttributeModifier.Operation.ADDITION));
				}
			}
		}

	}

	/**
	 * Called by InventoryBasic.onInventoryChanged() on a array that is never
	 * filled.
	 */
	@Override
	public void containerChanged(Container invBasic) {
		ItemStack itemstack = this.getArmor();
		super.containerChanged(invBasic);
		ItemStack itemstack1 = this.getArmor();
		if (this.tickCount > 20 && this.isArmor(itemstack1) && itemstack != itemstack1) {
			this.playSound(SoundEvents.HORSE_ARMOR, 0.5F, 1.0F);
		}

	}

	@Override
	protected void playGallopSound(SoundType p_190680_1_) {
		super.playGallopSound(p_190680_1_);
		if (this.random.nextInt(10) == 0) {
			this.playSound(SoundEvents.HORSE_BREATHE, p_190680_1_.getVolume() * 0.6F, p_190680_1_.getPitch());
		}

		ItemStack stack = this.inventory.getItem(1);
		if (isArmor(stack))
			stack.onHorseArmorTick(level, this);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		super.getAmbientSound();
		return SoundEvents.HORSE_AMBIENT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		super.getDeathSound();
		return SoundEvents.HORSE_DEATH;
	}

	@Override
	@Nullable
	protected SoundEvent getEatingSound() {
		return SoundEvents.HORSE_EAT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		super.getHurtSound(damageSourceIn);
		return SoundEvents.HORSE_HURT;
	}

	@Override
	protected SoundEvent getAngrySound() {
		super.getAngrySound();
		return SoundEvents.HORSE_ANGRY;
	}

	@Override
	public InteractionResult mobInteract(Player playerIn, InteractionHand hand) {
		ItemStack itemstack = playerIn.getItemInHand(hand);
		if (!this.isBaby()) {
			if (this.isTamed() && playerIn.isSecondaryUseActive()) {
				this.openInventory(playerIn);
				return InteractionResult.sidedSuccess(this.level.isClientSide);
			}

			if (this.isVehicle()) {
				return super.mobInteract(playerIn, hand);
			}
		}

		if (!itemstack.isEmpty()) {
			if (this.isFood(itemstack)) {
				return this.fedFood(playerIn, itemstack);
			}

			InteractionResult actionresulttype = itemstack.interactLivingEntity(playerIn, this, hand);
			if (actionresulttype.consumesAction()) {
				return actionresulttype;
			}

			if (!this.isTamed()) {
				this.makeMad();
				return InteractionResult.sidedSuccess(this.level.isClientSide);
			}

			boolean flag = !this.isBaby() && !this.isSaddled() && itemstack.getItem() == Items.SADDLE;
			if (this.isArmor(itemstack) || flag) {
				this.openInventory(playerIn);
				return InteractionResult.sidedSuccess(this.level.isClientSide);
			}
		}

		if (this.isBaby()) {
			return super.mobInteract(playerIn, hand);
		} else {
			this.doPlayerRide(playerIn);
			return InteractionResult.sidedSuccess(this.level.isClientSide);
		}
	}

//   public boolean canMateWith(AnimalEntity otherAnimal) {
//      if (otherAnimal == this) {
//         return false;
//      } else if (!(otherAnimal instanceof DonkeyEntity) && !(otherAnimal instanceof ZebraEntity)) {
//         return false;
//         return this.canMate() && ((AbstractHorseEntity)otherAnimal).canMate();
//      }
//   }

	@Override
	public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob mate) {
		AbstractHorse abstracthorseentity;
		if (mate instanceof Donkey) {
			abstracthorseentity = EntityType.MULE.create(world);
		} else {
			ZebraEntity horseentity = (ZebraEntity) mate;
			abstracthorseentity = EntityType.HORSE.create(world);
			int i = this.random.nextInt(9);
			Variant coatcolors;
			if (i < 4) {
				coatcolors = this.getVariant();
			} else if (i < 8) {
				coatcolors = horseentity.getVariant();
			} else {
				coatcolors = Util.getRandom(Variant.values(), this.random);
			}

			int j = this.random.nextInt(5);
			Markings coattypes;
			if (j < 2) {
				coattypes = this.getMarkings();
			} else if (j < 4) {
				coattypes = horseentity.getMarkings();
			} else {
				coattypes = Util.getRandom(Markings.values(), this.random);
			}

			((ZebraEntity) abstracthorseentity).setVariantAndMarkings(coatcolors, coattypes);
		}

		this.setOffspringAttributes(mate, abstracthorseentity);
		return abstracthorseentity;
	}

	@Override
	public boolean canWearArmor() {
		return true;
	}

	@Override
	public boolean isArmor(ItemStack stack) {
		return stack.getItem() instanceof HorseArmorItem;
	}

	@Override
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason,
			@Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		Variant coatcolors;
		if (spawnDataIn instanceof ZebraEntity.HorseData) {
			coatcolors = ((ZebraEntity.HorseData) spawnDataIn).variant;
		} else {
			coatcolors = Util.getRandom(Variant.values(), this.random);
			spawnDataIn = new ZebraEntity.HorseData(coatcolors);
		}

		this.setVariantAndMarkings(coatcolors, Util.getRandom(Markings.values(), this.random));
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	public static class HorseData extends AgeableMob.AgeableMobGroupData {
		public final Variant variant;

		public HorseData(Variant p_i231557_1_) {
			super(true);
			this.variant = p_i231557_1_;
		}
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("Variant", this.getTypeVariant());
		if (!this.inventory.getItem(1).isEmpty()) {
			compound.put("ArmorItem", this.inventory.getItem(1).save(new CompoundTag()));
		}

	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setTypeVariant(compound.getInt("Variant"));
		if (compound.contains("ArmorItem", 10)) {
			ItemStack itemstack = ItemStack.of(compound.getCompound("ArmorItem"));
			if (!itemstack.isEmpty() && this.isArmor(itemstack)) {
				this.inventory.setItem(1, itemstack);
			}
		}

		this.updateContainerEquipment();
	}
}
