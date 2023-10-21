package com.technologica.world.entity.ai.goal;

import java.util.EnumSet;

import com.technologica.world.entity.animal.Raccoon;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BegGoal extends Goal {
	private final Animal animal;
	private Player player;
	private final Level world;
	private final float minPlayerDistance;
	private final TargetingConditions playerPredicate;

	public BegGoal(Animal animalIn, float minDistance) {
		this.animal = animalIn;
		this.world = animalIn.level();
		this.minPlayerDistance = minDistance;
		this.playerPredicate = TargetingConditions.forNonCombat().range(minDistance);
		this.setFlags(EnumSet.of(Goal.Flag.LOOK));
	}

	@Override
	public boolean canUse() {
		this.player = this.world.getNearestPlayer(this.playerPredicate, this.animal);
		return this.player == null ? false : this.hasTemptationItemInHand(this.player);
	}

	@Override
	public boolean canContinueToUse() {
		if (!this.player.isAlive()) {
			return false;
		} else if (this.animal.distanceToSqr(this.player) > this.minPlayerDistance * this.minPlayerDistance) {
			return false;
		} else {
			ItemStack itemstack = this.animal.getItemBySlot(EquipmentSlot.MAINHAND);
			return this.hasTemptationItemInHand(this.player) && !itemstack.isEmpty();
		}
	}

	@Override
	public void start() {
		if (animal instanceof Raccoon) {
			((Raccoon) animal).setBegging(true);
		}
	}

	@Override
	public void stop() {
		if (animal instanceof Raccoon) {
			((Raccoon) animal).setBegging(false);
			this.player = null;
		}
	}

	@Override
	public void tick() {
		this.animal.getLookControl().setLookAt(this.player.getX(), this.player.getEyeY(), this.player.getZ(), 10.0F, this.animal.getMaxHeadXRot());
	}

	public boolean hasTemptationItemInHand(Player player) {
		for (InteractionHand hand : InteractionHand.values()) {
			ItemStack itemstack = player.getItemInHand(hand);
			if (itemstack != ItemStack.EMPTY) {
				return true;
			}
		}
		return false;
	}
}