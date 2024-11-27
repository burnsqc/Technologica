package com.technologica.listeners.forge;

import java.util.function.Predicate;

import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import com.technologica.registration.deferred.TechnologicaItems;
import com.technologica.world.entity.ai.behavior.TechnologicaVillagerGoalPackages;
import com.technologica.world.entity.animal.GrizzlyBear;
import com.technologica.world.entity.animal.Shark;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.schedule.Activity;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE)
public class ModifyMobGoals {

	@SubscribeEvent
	public static void onEntityJoinLevelEvent(final EntityJoinLevelEvent event) {
		if (!event.getLevel().isClientSide()) {
			if (event.getEntity() instanceof Mob) {
				Mob mob = (Mob) event.getEntity();
				if (mob instanceof Bee) {
					mob.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(mob, GrizzlyBear.class, 10, true, true, (Predicate<LivingEntity>) null));
				}
				if (mob instanceof Cow) {
					mob.goalSelector.addGoal(3, new TemptGoal((Cow) mob, 1.25D, Ingredient.of(TechnologicaItems.BARLEY.get(), TechnologicaItems.OATS.get(), TechnologicaItems.RYE.get(), TechnologicaItems.CORN.get()), false));
				}
				if (mob instanceof Sheep) {
					mob.goalSelector.addGoal(3, new TemptGoal((Sheep) mob, 1.1D, Ingredient.of(TechnologicaItems.BARLEY.get(), TechnologicaItems.OATS.get(), TechnologicaItems.RYE.get(), TechnologicaItems.CORN.get()), false));
				}
				if (mob instanceof TropicalFish) {
					mob.goalSelector.addGoal(1, new AvoidEntityGoal<>((TropicalFish) mob, Shark.class, 8.0F, 1.5D, 2.0D));
				}

				if (mob instanceof Villager) {
					Villager villager = (Villager) mob;
					VillagerProfession villagerProfession = villager.getVillagerData().getProfession();
					Brain<Villager> brain = villager.getBrain();
					if (!villager.isBaby() && villagerProfession.equals(VillagerProfession.FARMER)) {
						brain.addActivityWithConditions(Activity.WORK, TechnologicaVillagerGoalPackages.getWorkPackage(villagerProfession, 0.5F), ImmutableSet.of(Pair.of(MemoryModuleType.JOB_SITE, MemoryStatus.VALUE_PRESENT)));
					}
				}
			}
		}
	}
}
