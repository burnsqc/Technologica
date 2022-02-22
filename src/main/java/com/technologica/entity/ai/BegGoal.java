package com.technologica.entity.ai;

import java.util.EnumSet;

import com.technologica.entity.passive.RaccoonEntity;

import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class BegGoal extends Goal {
	private final AnimalEntity animal;
	private PlayerEntity player;
	private final World world;
	private final float minPlayerDistance;
	private final EntityPredicate playerPredicate;

	public BegGoal(AnimalEntity animalIn, float minDistance) {
		this.animal = animalIn;
		this.world = animalIn.level;
		this.minPlayerDistance = minDistance;
		this.playerPredicate = (new EntityPredicate()).range((double) minDistance).allowInvulnerable().allowSameTeam().allowNonAttackable();
		this.setFlags(EnumSet.of(Goal.Flag.LOOK));
	}

	public boolean canUse() {
		this.player = this.world.getNearestPlayer(this.playerPredicate, this.animal);
		return this.player == null ? false : this.hasTemptationItemInHand(this.player);
	}

	public boolean canContinueToUse() {
		if (!this.player.isAlive()) {
			return false;
		} else if (this.animal.distanceToSqr(this.player) > (double) (this.minPlayerDistance * this.minPlayerDistance)) {
			return false;
		} else {
			ItemStack itemstack = this.animal.getItemBySlot(EquipmentSlotType.MAINHAND);
			return this.hasTemptationItemInHand(this.player) && !itemstack.isEmpty();
		}
	}

	public void start() {
		if (animal instanceof RaccoonEntity) {
			((RaccoonEntity) animal).setBegging(true);
		}
	}

	public void stop() {
		if (animal instanceof RaccoonEntity) {
			((RaccoonEntity) animal).setBegging(false);
			this.player = null;
		}
	}

	public void tick() {
		this.animal.getLookControl().setLookAt(this.player.getX(), this.player.getEyeY(), this.player.getZ(), 10.0F, (float) this.animal.getMaxHeadXRot());	
	}

	public boolean hasTemptationItemInHand(PlayerEntity player) {
		for (Hand hand : Hand.values()) {
			ItemStack itemstack = player.getItemInHand(hand);
			if (itemstack != ItemStack.EMPTY) {
				return true;
			}	
		}
		return false;
	}
}