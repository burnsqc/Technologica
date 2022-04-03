package com.technologica.setup;

import java.util.function.Predicate;

import com.technologica.world.entity.ai.goal.PickupTechnologicaSeedsGoal;
import com.technologica.world.entity.animal.GrizzlyBear;
import com.technologica.world.entity.animal.Shark;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class VanillaEntityModifier {

	private VanillaEntityModifier() {
	}

	public static void init(final EntityJoinWorldEvent event) {
		Entity entity = event.getEntity();
		if (entity instanceof Bee) {
			Bee beeEntity = (Bee) entity;
			beeEntity.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(beeEntity, GrizzlyBear.class, 10, true, true, (Predicate<LivingEntity>)null));
	    }
		if (entity instanceof TropicalFish) {
			TropicalFish tropicalFishEntity = (TropicalFish) entity;
			tropicalFishEntity.goalSelector.addGoal(1, new AvoidEntityGoal<>(tropicalFishEntity, Shark.class, 8.0F, 1.5D, 2.0D));
	    }
		
		if (entity instanceof Villager) {
			Villager villagerEntity = (Villager) entity;
			if (villagerEntity.getVillagerData().getProfession().equals(VillagerProfession.FARMER)) {
				villagerEntity.goalSelector.addGoal(1, new PickupTechnologicaSeedsGoal(villagerEntity));
			}
	    }
	}
}