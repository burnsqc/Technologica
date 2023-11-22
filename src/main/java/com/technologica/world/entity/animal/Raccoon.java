package com.technologica.world.entity.animal;

import com.technologica.registration.deferred.TechnologicaEntityTypes;
import com.technologica.world.entity.ai.goal.BegGoal;

import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;

public class Raccoon extends Animal {
	private static final EntityDataAccessor<Boolean> BEGGING = SynchedEntityData.defineId(Raccoon.class, EntityDataSerializers.BOOLEAN);

	public Raccoon(EntityType<? extends Raccoon> type, Level worldIn) {
		super(type, worldIn);
		this.setCanPickUpLoot(true);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob mate) {
		return TechnologicaEntityTypes.RACCOON.get().create(world);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(0, new BegGoal(this, 8.0F));
		this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(4, new PanicGoal(this, 1.4D));
		this.goalSelector.addGoal(5, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return AttributeSupplier.builder().add(Attributes.MAX_HEALTH, 10.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.25D)
				.add(Attributes.FOLLOW_RANGE, 16.0D)
				.add(Attributes.ATTACK_KNOCKBACK)
				.add(Attributes.KNOCKBACK_RESISTANCE).add(Attributes.ARMOR)
				.add(Attributes.ARMOR_TOUGHNESS)
				.add(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get())
				.add(net.minecraftforge.common.ForgeMod.NAMETAG_DISTANCE.get())
				.add(net.minecraftforge.common.ForgeMod.ENTITY_GRAVITY.get());
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(BEGGING, false);
	}

	public void setBegging(boolean beg) {
		ItemStack itemstack = this.getItemBySlot(EquipmentSlot.MAINHAND);
		if (itemstack.isEmpty() && beg) {
			this.entityData.set(BEGGING, true);
			this.setXRot(-(float) Math.PI / 4);
		} else {
			this.entityData.set(BEGGING, false);
			this.setXRot(0.0F);
		}
	}

	public boolean isBegging() {
		return this.entityData.get(BEGGING);
	}

	public boolean canHoldItem(ItemStack stack) {
		ItemStack itemstack = this.getItemBySlot(EquipmentSlot.MAINHAND);
		return itemstack.isEmpty();
	}

}
