package com.technologica.entity.passive;

import java.util.UUID;

import javax.annotation.Nullable;

import com.technologica.entity.TechnologicaEntityType;

import net.minecraft.block.SoundType;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.passive.horse.CoatColors;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
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

public class GiraffeEntity extends AbstractHorseEntity {
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.ACACIA_LEAVES);
	private static final UUID ARMOR_MODIFIER_UUID = UUID.fromString("556E1665-8B10-40C8-8F9D-CF9B1667F295");
	private static final DataParameter<Integer> HORSE_VARIANT = EntityDataManager.createKey(GiraffeEntity.class,DataSerializers.VARINT);
	public int earCounter;

	public GiraffeEntity(EntityType<? extends GiraffeEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public void func_230273_eI_() {
		this.getAttribute(Attributes.MAX_HEALTH).setBaseValue((double) this.getModifiedMaxHealth());
		this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(this.getModifiedMovementSpeed());
		this.getAttribute(Attributes.HORSE_JUMP_STRENGTH).setBaseValue(this.getModifiedJumpStrength());
	}

	// Register Attributes, Goals, and Data
	// Attributes are registered inside AbstractHourseEntity with method
	// func_234237_fg_
	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(HORSE_VARIANT, 0);
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
	public void livingTick() {
		if (this.rand.nextInt(200) == 1) {
			this.moveEars();
		}

		super.livingTick();
	}

	@Override
	public void tick() {
		if (this.earCounter > 0 && ++this.earCounter > 8) {
			this.earCounter = 0;
		}
		
		super.tick();
	}

	public ItemStack func_213803_dV() {
		return this.getItemStackFromSlot(EquipmentSlotType.CHEST);
	}

	private void func_213805_k(ItemStack p_213805_1_) {
		this.setItemStackToSlot(EquipmentSlotType.CHEST, p_213805_1_);
		this.setDropChance(EquipmentSlotType.CHEST, 0.0F);
	}

	@Override
	protected void func_230275_fc_() {
		if (!this.world.isRemote) {
			super.func_230275_fc_();
			this.func_213804_l(this.horseChest.getStackInSlot(1));
			this.setDropChance(EquipmentSlotType.CHEST, 0.0F);
		}
	}

	private void func_213804_l(ItemStack p_213804_1_) {
		this.func_213805_k(p_213804_1_);
		if (!this.world.isRemote) {
			this.getAttribute(Attributes.ARMOR).removeModifier(ARMOR_MODIFIER_UUID);
			if (this.isArmor(p_213804_1_)) {
				int i = ((HorseArmorItem) p_213804_1_.getItem()).getArmorValue();
				if (i != 0) {
					this.getAttribute(Attributes.ARMOR)
							.applyNonPersistentModifier(new AttributeModifier(ARMOR_MODIFIER_UUID, "Horse armor bonus",
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
	public void onInventoryChanged(IInventory invBasic) {
		ItemStack itemstack = this.func_213803_dV();
		super.onInventoryChanged(invBasic);
		ItemStack itemstack1 = this.func_213803_dV();
		if (this.ticksExisted > 20 && this.isArmor(itemstack1) && itemstack != itemstack1) {
			this.playSound(SoundEvents.ENTITY_HORSE_ARMOR, 0.5F, 1.0F);
		}

	}

	@Override
	protected void playGallopSound(SoundType p_190680_1_) {
		super.playGallopSound(p_190680_1_);
		if (this.rand.nextInt(10) == 0) {
			this.playSound(SoundEvents.ENTITY_HORSE_BREATHE, p_190680_1_.getVolume() * 0.6F, p_190680_1_.getPitch());
		}

		ItemStack stack = this.horseChest.getStackInSlot(1);
		if (isArmor(stack))
			stack.onHorseArmorTick(world, this);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		super.getAmbientSound();
		return SoundEvents.ENTITY_HORSE_AMBIENT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		super.getDeathSound();
		return SoundEvents.ENTITY_HORSE_DEATH;
	}

	@Override
	@Nullable
	protected SoundEvent func_230274_fe_() {
		return SoundEvents.ENTITY_HORSE_EAT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		super.getHurtSound(damageSourceIn);
		return SoundEvents.ENTITY_HORSE_HURT;
	}

	@Override
	protected SoundEvent getAngrySound() {
		super.getAngrySound();
		return SoundEvents.ENTITY_HORSE_ANGRY;
	}

	@Override
	public ActionResultType getEntityInteractionResult(PlayerEntity playerIn, Hand hand) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		if (!this.isChild()) {
			if (this.isTame() && playerIn.isSecondaryUseActive()) {
				this.openGUI(playerIn);
				return ActionResultType.func_233537_a_(this.world.isRemote);
			}

			if (this.isBeingRidden()) {
				return super.getEntityInteractionResult(playerIn, hand);
			}
		}

		if (!itemstack.isEmpty()) {
			if (this.isBreedingItem(itemstack)) {
				return this.func_241395_b_(playerIn, itemstack);
			}

			ActionResultType actionresulttype = itemstack.interactWithEntity(playerIn, this, hand);
			if (actionresulttype.isSuccessOrConsume()) {
				return actionresulttype;
			}

			if (!this.isTame()) {
				this.makeMad();
				return ActionResultType.func_233537_a_(this.world.isRemote);
			}

			boolean flag = !this.isChild() && !this.isHorseSaddled() && itemstack.getItem() == Items.SADDLE;
			if (this.isArmor(itemstack) || flag) {
				this.openGUI(playerIn);
				return ActionResultType.func_233537_a_(this.world.isRemote);
			}
		}

		if (this.isChild()) {
			return super.getEntityInteractionResult(playerIn, hand);
		} else {
			this.mountTo(playerIn);
			return ActionResultType.func_233537_a_(this.world.isRemote);
		}
	}

	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return TEMPTATION_ITEMS.test(stack);
	}
	
	@Override
	public AgeableEntity createChild(ServerWorld world, AgeableEntity mate) {
		return TechnologicaEntityType.GIRAFFE.get().create(world);
	}

	@Override
	public boolean func_230276_fq_() {
		return true;
	}

	@Override
	public boolean isArmor(ItemStack stack) {
		return stack.getItem() instanceof HorseArmorItem;
	}

	@Override
	@Nullable
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			@Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		CoatColors coatcolors;
		if (spawnDataIn instanceof GiraffeEntity.HorseData) {
			coatcolors = ((GiraffeEntity.HorseData) spawnDataIn).variant;
		} else {
			coatcolors = Util.getRandomObject(CoatColors.values(), this.rand);
			spawnDataIn = new GiraffeEntity.HorseData(coatcolors);
		}

		
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	public static class HorseData extends AgeableEntity.AgeableData {
		public final CoatColors variant;

		public HorseData(CoatColors p_i231557_1_) {
			super(true);
			this.variant = p_i231557_1_;
		}
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		
		if (!this.horseChest.getStackInSlot(1).isEmpty()) {
			compound.put("ArmorItem", this.horseChest.getStackInSlot(1).write(new CompoundNBT()));
		}

	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		
		if (compound.contains("ArmorItem", 10)) {
			ItemStack itemstack = ItemStack.read(compound.getCompound("ArmorItem"));
			if (!itemstack.isEmpty() && this.isArmor(itemstack)) {
				this.horseChest.setInventorySlotContents(1, itemstack);
			}
		}

		this.func_230275_fc_();
	}
}
