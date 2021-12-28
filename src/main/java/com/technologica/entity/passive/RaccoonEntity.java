package com.technologica.entity.passive;

import com.technologica.entity.ai.BegGoal;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class RaccoonEntity extends AnimalEntity {
	private static final DataParameter<Boolean> BEGGING = EntityDataManager.createKey(RaccoonEntity.class, DataSerializers.BOOLEAN);

	public RaccoonEntity(EntityType<? extends RaccoonEntity> type, World worldIn) {
		super(type, worldIn);
		this.setCanPickUpLoot(true);
	}

	@Override
	public AgeableEntity createChild(ServerWorld world, AgeableEntity mate) {
		return null;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(0, new BegGoal(this, 8.0F));
		this.goalSelector.addGoal(1, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(4, new PanicGoal(this, 1.4D));
		this.goalSelector.addGoal(5, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
	}

	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return AttributeModifierMap.createMutableAttribute().createMutableAttribute(Attributes.MAX_HEALTH, 10.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D)
				.createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0D)
				.createMutableAttribute(Attributes.ATTACK_KNOCKBACK)
				.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE).createMutableAttribute(Attributes.ARMOR)
				.createMutableAttribute(Attributes.ARMOR_TOUGHNESS)
				.createMutableAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get())
				.createMutableAttribute(net.minecraftforge.common.ForgeMod.NAMETAG_DISTANCE.get())
				.createMutableAttribute(net.minecraftforge.common.ForgeMod.ENTITY_GRAVITY.get());
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(BEGGING, false);
	}

	public void setBegging(boolean beg) {
		ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
		if (itemstack.isEmpty() && beg) {
			this.dataManager.set(BEGGING, true);
			this.rotationPitch = -(float) Math.PI / 4;
		} else {
			this.dataManager.set(BEGGING, false);
			this.rotationPitch = 0;
		}
	}

	public boolean isBegging() {
		return this.dataManager.get(BEGGING);
	}

	public boolean canEquipItem(ItemStack stack) {
		ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
		return itemstack.isEmpty();
	}

}
