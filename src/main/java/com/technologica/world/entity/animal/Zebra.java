package com.technologica.world.entity.animal;

import java.util.UUID;

import javax.annotation.Nullable;

import com.technologica.registration.deferred.TechnologicaEntityTypes;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;

public class Zebra extends AbstractHorse {
	private static final UUID ARMOR_MODIFIER_UUID = UUID.fromString("E07161C6-FB78-445C-AFB6-17198A2C11B7");

	public Zebra(EntityType<? extends Zebra> randomSource, Level level) {
		super(randomSource, level);
	}

	@Override
	public void randomizeAttributes(RandomSource randomSource) {
		this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(generateMaxHealth(randomSource::nextInt));
		this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(generateSpeed(randomSource::nextDouble));
		this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(generateJumpStrength(randomSource::nextDouble));
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
	}

	public ItemStack getArmor() {
		return this.getItemBySlot(EquipmentSlot.CHEST);
	}

	private void setArmor(ItemStack itemStack) {
		this.setItemSlot(EquipmentSlot.CHEST, itemStack);
		this.setDropChance(EquipmentSlot.CHEST, 0.0F);
	}

	@SuppressWarnings("resource")
	@Override
	protected void updateContainerEquipment() {
		if (!this.level().isClientSide) {
			super.updateContainerEquipment();
			this.setArmorEquipment(this.inventory.getItem(1));
			this.setDropChance(EquipmentSlot.CHEST, 0.0F);
		}
	}

	@SuppressWarnings("resource")
	private void setArmorEquipment(ItemStack itemStack) {
		this.setArmor(itemStack);
		if (!this.level().isClientSide) {
			this.getAttribute(Attributes.ARMOR).removeModifier(ARMOR_MODIFIER_UUID);
			if (this.isArmor(itemStack)) {
				int i = ((HorseArmorItem) itemStack.getItem()).getProtection();
				if (i != 0) {
					this.getAttribute(Attributes.ARMOR).addTransientModifier(new AttributeModifier(ARMOR_MODIFIER_UUID, "Zebra armor bonus", i, AttributeModifier.Operation.ADDITION));
				}
			}
		}

	}

	@Override
	public void containerChanged(Container container) {
		ItemStack itemstack = this.getArmor();
		super.containerChanged(container);
		ItemStack itemstack1 = this.getArmor();
		if (this.tickCount > 20 && this.isArmor(itemstack1) && itemstack != itemstack1) {
			this.playSound(SoundEvents.HORSE_ARMOR, 0.5F, 1.0F);
		}

	}

	@Override
	protected void playGallopSound(SoundType soundType) {
		super.playGallopSound(soundType);
		if (this.random.nextInt(10) == 0) {
			this.playSound(SoundEvents.HORSE_BREATHE, soundType.getVolume() * 0.6F, soundType.getPitch());
		}

		ItemStack stack = this.inventory.getItem(1);
		if (isArmor(stack)) {
			stack.onHorseArmorTick(level(), this);
		}
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.HORSE_AMBIENT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.HORSE_DEATH;
	}

	@Override
	@Nullable
	protected SoundEvent getEatingSound() {
		return SoundEvents.HORSE_EAT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSource) {
		return SoundEvents.HORSE_HURT;
	}

	@Override
	protected SoundEvent getAngrySound() {
		return SoundEvents.HORSE_ANGRY;
	}

	@SuppressWarnings("resource")
	@Override
	public InteractionResult mobInteract(Player player, InteractionHand interactionHand) {
		boolean flag = !this.isBaby() && this.isTamed() && player.isSecondaryUseActive();
		if (!this.isVehicle() && !flag) {
			ItemStack itemstack = player.getItemInHand(interactionHand);
			if (!itemstack.isEmpty()) {
				if (this.isFood(itemstack)) {
					return this.fedFood(player, itemstack);
				}

				if (!this.isTamed()) {
					this.makeMad();
					return InteractionResult.sidedSuccess(this.level().isClientSide);
				}
			}

			return super.mobInteract(player, interactionHand);
		} else {
			return super.mobInteract(player, interactionHand);
		}
	}

	@Override
	public boolean canMate(Animal animal) {
		if (animal != this && animal instanceof Zebra zebra) {
			if (this.canParent() && zebra.canParent()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob mate) {
		return TechnologicaEntityTypes.ZEBRA.get().create(serverLevel);
	}

	@Override
	public boolean canWearArmor() {
		return true;
	}

	@Override
	public boolean isArmor(ItemStack itemStack) {
		return itemStack.getItem() instanceof HorseArmorItem;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compoundTag) {
		super.addAdditionalSaveData(compoundTag);
		if (!this.inventory.getItem(1).isEmpty()) {
			compoundTag.put("ArmorItem", this.inventory.getItem(1).save(new CompoundTag()));
		}

	}

	@Override
	public void readAdditionalSaveData(CompoundTag compoundTag) {
		super.readAdditionalSaveData(compoundTag);
		if (compoundTag.contains("ArmorItem", 10)) {
			ItemStack itemstack = ItemStack.of(compoundTag.getCompound("ArmorItem"));
			if (!itemstack.isEmpty() && this.isArmor(itemstack)) {
				this.inventory.setItem(1, itemstack);
			}
		}
		this.updateContainerEquipment();
	}
}
