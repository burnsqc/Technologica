package com.technologica.setup;

import java.util.function.Predicate;

import com.technologica.world.entity.animal.GrizzlyBearEntity;
import com.technologica.world.entity.animal.SharkEntity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class VanillaEntityModifier {

	private VanillaEntityModifier() {
		// hide constructor for class with only static members
	}

	public static void init(final EntityJoinWorldEvent event) {
		Entity entity = event.getEntity();
		if (entity instanceof Bee) {
			Bee beeEntity = (Bee) entity;
			beeEntity.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(beeEntity, GrizzlyBearEntity.class, 10, true, true, (Predicate<LivingEntity>)null));
	    }
		if (entity instanceof TropicalFish) {
			TropicalFish tropicalFishEntity = (TropicalFish) entity;
			tropicalFishEntity.goalSelector.addGoal(1, new AvoidEntityGoal<>(tropicalFishEntity, SharkEntity.class, 8.0F, 1.5D, 2.0D));
	    }
	}
}
