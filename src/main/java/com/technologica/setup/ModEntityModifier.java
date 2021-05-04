package com.technologica.setup;

import java.util.function.Predicate;

import com.technologica.entity.monster.SharkEntity;
import com.technologica.entity.passive.GrizzlyBearEntity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class ModEntityModifier {

	public static void init(final EntityJoinWorldEvent event) {
		Entity entity = event.getEntity();
		if (entity instanceof BeeEntity) {
			BeeEntity beeEntity = (BeeEntity) entity;
			beeEntity.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(beeEntity, GrizzlyBearEntity.class, 10, true, true, (Predicate<LivingEntity>)null));
	    }
		if (entity instanceof TropicalFishEntity) {
			TropicalFishEntity tropicalFishEntity = (TropicalFishEntity) entity;
			tropicalFishEntity.goalSelector.addGoal(1, new AvoidEntityGoal<>(tropicalFishEntity, SharkEntity.class, 8.0F, 1.5D, 2.0D));
	    }
	}
}
