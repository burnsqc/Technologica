package com.technologica.entity.passive;

import java.util.UUID;

import javax.annotation.Nullable;

import net.minecraft.block.SoundType;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.passive.horse.CoatColors;
import net.minecraft.entity.passive.horse.CoatTypes;
import net.minecraft.entity.passive.horse.DonkeyEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.HorseArmorItem;
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
import net.minecraft.util.Util;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class ZebraEntity extends AbstractHorseEntity {
	private static final UUID ARMOR_MODIFIER_UUID = UUID.fromString("556E1665-8B10-40C8-8F9D-CF9B1667F295");
	private static final DataParameter<Integer> HORSE_VARIANT = EntityDataManager.defineId(ZebraEntity.class,
			DataSerializers.INT);

	public ZebraEntity(EntityType<? extends ZebraEntity> type, World worldIn) {
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
		return this.getItemBySlot(EquipmentSlotType.CHEST);
	}

	private void setArmor(ItemStack p_213805_1_) {
		this.setItemSlot(EquipmentSlotType.CHEST, p_213805_1_);
		this.setDropChance(EquipmentSlotType.CHEST, 0.0F);
	}

	private void setTypeVariant(int p_234242_1_) {
		this.entityData.set(HORSE_VARIANT, p_234242_1_);
	}

	private int getTypeVariant() {
		return this.entityData.get(HORSE_VARIANT);
	}

	private void setVariantAndMarkings(CoatColors p_234238_1_, CoatTypes p_234238_2_) {
		this.setTypeVariant(p_234238_1_.getId() & 255 | p_234238_2_.getId() << 8 & '\uff00');
	}

	public CoatColors getVariant() {
		return CoatColors.byId(this.getTypeVariant() & 255);
	}

	public CoatTypes getMarkings() {
		return CoatTypes.byId((this.getTypeVariant() & '\uff00') >> 8);
	}

	@Override
	protected void updateContainerEquipment() {
		if (!this.level.isClientSide) {
			super.updateContainerEquipment();
			this.setArmorEquipment(this.inventory.getItem(1));
			this.setDropChance(EquipmentSlotType.CHEST, 0.0F);
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
	public void containerChanged(IInventory invBasic) {
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
	public ActionResultType mobInteract(PlayerEntity playerIn, Hand hand) {
		ItemStack itemstack = playerIn.getItemInHand(hand);
		if (!this.isBaby()) {
			if (this.isTamed() && playerIn.isSecondaryUseActive()) {
				this.openInventory(playerIn);
				return ActionResultType.sidedSuccess(this.level.isClientSide);
			}

			if (this.isVehicle()) {
				return super.mobInteract(playerIn, hand);
			}
		}

		if (!itemstack.isEmpty()) {
			if (this.isFood(itemstack)) {
				return this.fedFood(playerIn, itemstack);
			}

			ActionResultType actionresulttype = itemstack.interactLivingEntity(playerIn, this, hand);
			if (actionresulttype.consumesAction()) {
				return actionresulttype;
			}

			if (!this.isTamed()) {
				this.makeMad();
				return ActionResultType.sidedSuccess(this.level.isClientSide);
			}

			boolean flag = !this.isBaby() && !this.isSaddled() && itemstack.getItem() == Items.SADDLE;
			if (this.isArmor(itemstack) || flag) {
				this.openInventory(playerIn);
				return ActionResultType.sidedSuccess(this.level.isClientSide);
			}
		}

		if (this.isBaby()) {
			return super.mobInteract(playerIn, hand);
		} else {
			this.doPlayerRide(playerIn);
			return ActionResultType.sidedSuccess(this.level.isClientSide);
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
	public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity mate) {
		AbstractHorseEntity abstracthorseentity;
		if (mate instanceof DonkeyEntity) {
			abstracthorseentity = EntityType.MULE.create(world);
		} else {
			ZebraEntity horseentity = (ZebraEntity) mate;
			abstracthorseentity = EntityType.HORSE.create(world);
			int i = this.random.nextInt(9);
			CoatColors coatcolors;
			if (i < 4) {
				coatcolors = this.getVariant();
			} else if (i < 8) {
				coatcolors = horseentity.getVariant();
			} else {
				coatcolors = Util.getRandom(CoatColors.values(), this.random);
			}

			int j = this.random.nextInt(5);
			CoatTypes coattypes;
			if (j < 2) {
				coattypes = this.getMarkings();
			} else if (j < 4) {
				coattypes = horseentity.getMarkings();
			} else {
				coattypes = Util.getRandom(CoatTypes.values(), this.random);
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
	public ILivingEntityData finalizeSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			@Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		CoatColors coatcolors;
		if (spawnDataIn instanceof ZebraEntity.HorseData) {
			coatcolors = ((ZebraEntity.HorseData) spawnDataIn).variant;
		} else {
			coatcolors = Util.getRandom(CoatColors.values(), this.random);
			spawnDataIn = new ZebraEntity.HorseData(coatcolors);
		}

		this.setVariantAndMarkings(coatcolors, Util.getRandom(CoatTypes.values(), this.random));
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	public static class HorseData extends AgeableEntity.AgeableData {
		public final CoatColors variant;

		public HorseData(CoatColors p_i231557_1_) {
			super(true);
			this.variant = p_i231557_1_;
		}
	}

	@Override
	public void addAdditionalSaveData(CompoundNBT compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("Variant", this.getTypeVariant());
		if (!this.inventory.getItem(1).isEmpty()) {
			compound.put("ArmorItem", this.inventory.getItem(1).save(new CompoundNBT()));
		}

	}

	@Override
	public void readAdditionalSaveData(CompoundNBT compound) {
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
