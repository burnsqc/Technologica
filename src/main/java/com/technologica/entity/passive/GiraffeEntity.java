package com.technologica.entity.passive;

import java.util.UUID;

import javax.annotation.Nullable;

import com.technologica.entity.TechnologicaEntityType;

import net.minecraft.block.SoundType;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class GiraffeEntity extends AbstractHorseEntity {
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.of(Items.ACACIA_LEAVES);
	private static final UUID ARMOR_MODIFIER_UUID = UUID.fromString("556E1665-8B10-40C8-8F9D-CF9B1667F295");

	public int earCounter;

	public GiraffeEntity(EntityType<? extends GiraffeEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public void randomizeAttributes() {
		this.getAttribute(Attributes.MAX_HEALTH).setBaseValue((double) this.generateRandomMaxHealth());
		this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(this.generateRandomSpeed());
		this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(this.generateRandomJumpStrength());
	}

	// Register Attributes, Goals, and Data
	// Attributes are registered inside AbstractHourseEntity with method
	// createBaseHorseAttributes
	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(3, new TemptGoal(this, 0.75D, false, TEMPTATION_ITEMS));
	}

	@Override
	public boolean canEatGrass() {
		return false;
	}

	private void moveEars() {
		this.earCounter = 1;
	}

	@Override
	public void aiStep() {
		if (this.random.nextInt(200) == 1) {
			this.moveEars();
		}

		super.aiStep();
	}

	@Override
	public void tick() {
		if (this.earCounter > 0 && ++this.earCounter > 8) {
			this.earCounter = 0;
		}

		super.tick();
	}

	public ItemStack getArmor() {
		return this.getItemBySlot(EquipmentSlotType.CHEST);
	}

	private void setArmor(ItemStack p_213805_1_) {
		this.setItemSlot(EquipmentSlotType.CHEST, p_213805_1_);
		this.setDropChance(EquipmentSlotType.CHEST, 0.0F);
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
	protected void playGallopSound(SoundType soundTypeIn) {
		super.playGallopSound(soundTypeIn);

		if (this.random.nextInt(10) == 0) {
			this.playSound(SoundEvents.HORSE_BREATHE, soundTypeIn.getVolume() * 0.6F, soundTypeIn.getPitch());
		}

		ItemStack stack = this.inventory.getItem(1);

		if (isArmor(stack)) {
			stack.onHorseArmorTick(level, this);
		}
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

	@Override
	public boolean isFood(ItemStack stack) {
		return TEMPTATION_ITEMS.test(stack);
	}

	@Override
	protected boolean handleEating(PlayerEntity player, ItemStack stack) {
		boolean flag = false;
		float f = 0.0F;
		int i = 0;
		int j = 0;
		Item item = stack.getItem();
		if (item == Items.ACACIA_LEAVES) {
			f = 2.0F;
			i = 20;
			j = 3;
			if (!this.level.isClientSide && this.isTamed() && this.getAge() == 0 && !this.isInLove()) {
				flag = true;
				this.setInLove(player);
			}
		}

		if (this.getHealth() < this.getMaxHealth() && f > 0.0F) {
			this.heal(f);
			flag = true;
		}

		if (this.isBaby() && i > 0) {
			this.level.addParticle(ParticleTypes.HAPPY_VILLAGER, this.getRandomX(1.0D), this.getRandomY() + 0.5D,
					this.getRandomZ(1.0D), 0.0D, 0.0D, 0.0D);
			if (!this.level.isClientSide) {
				this.ageUp(i);
			}

			flag = true;
		}

		if (j > 0 && (flag || !this.isTamed()) && this.getTemper() < this.getMaxTemper()) {
			flag = true;
			if (!this.level.isClientSide) {
				this.modifyTemper(j);
			}
		}

		if (flag) {
			this.eatingHorse();
		}

		return flag;
	}

	private void eatingHorse() {
		if (!this.isSilent()) {
			SoundEvent soundevent = this.getEatingSound();
			if (soundevent != null) {
				this.level.playSound((PlayerEntity) null, this.getX(), this.getY(), this.getZ(), soundevent,
						this.getSoundSource(), 1.0F, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.2F);
			}
		}

	}

	@Override
	public double getPassengersRidingOffset() {
		return (double) 2.5D;
	}

	@Override
	public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity mate) {
		return TechnologicaEntityType.GIRAFFE.get().create(world);
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
	public void addAdditionalSaveData(CompoundNBT compound) {
		super.addAdditionalSaveData(compound);

		if (!this.inventory.getItem(1).isEmpty()) {
			compound.put("ArmorItem", this.inventory.getItem(1).save(new CompoundNBT()));
		}

	}

	@Override
	public void readAdditionalSaveData(CompoundNBT compound) {
		super.readAdditionalSaveData(compound);

		if (compound.contains("ArmorItem", 10)) {
			ItemStack itemstack = ItemStack.of(compound.getCompound("ArmorItem"));
			if (!itemstack.isEmpty() && this.isArmor(itemstack)) {
				this.inventory.setItem(1, itemstack);
			}
		}

		this.updateContainerEquipment();
	}
}
