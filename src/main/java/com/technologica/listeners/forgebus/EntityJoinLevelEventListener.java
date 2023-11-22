package com.technologica.listeners.forgebus;

import java.util.UUID;
import java.util.function.Predicate;

import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import com.technologica.registration.deferred.TechnologicaItems;
import com.technologica.world.entity.ai.behavior.TechnologicaVillagerGoalPackages;
import com.technologica.world.entity.animal.GrizzlyBear;
import com.technologica.world.entity.animal.Shark;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
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

public class EntityJoinLevelEventListener {
	private static final UUID LUNAR_GRAVITY_ID = UUID.fromString("297dcaec-6b7d-11ee-b962-0242ac120002");
	private static final AttributeModifier LUNAR_GRAVITY = new AttributeModifier(LUNAR_GRAVITY_ID, "Lunar gravity reduction", -0.07, AttributeModifier.Operation.ADDITION);

	@SubscribeEvent
	public void onEntityJoinLevelEvent(EntityJoinLevelEvent event) {
		Entity entity = event.getEntity();

		if (entity instanceof Bee) {
			Bee beeEntity = (Bee) entity;
			beeEntity.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(beeEntity, GrizzlyBear.class, 10, true, true, (Predicate<LivingEntity>) null));
		}
		if (entity instanceof Cow) {
			Cow cow = (Cow) entity;
			cow.goalSelector.addGoal(3, new TemptGoal(cow, 1.25D, Ingredient.of(TechnologicaItems.BARLEY.get(), TechnologicaItems.OATS.get(), TechnologicaItems.RYE.get(), TechnologicaItems.CORN.get()), false));
		}
		if (entity instanceof Sheep) {
			Sheep sheep = (Sheep) entity;
			sheep.goalSelector.addGoal(3, new TemptGoal(sheep, 1.1D, Ingredient.of(TechnologicaItems.BARLEY.get(), TechnologicaItems.OATS.get(), TechnologicaItems.RYE.get(), TechnologicaItems.CORN.get()), false));
		}
		if (entity instanceof TropicalFish) {
			TropicalFish tropicalFish = (TropicalFish) entity;
			tropicalFish.goalSelector.addGoal(1, new AvoidEntityGoal<>(tropicalFish, Shark.class, 8.0F, 1.5D, 2.0D));
		}
		if (event.getEntity() instanceof Villager) {
			Villager villager = (Villager) event.getEntity();
			VillagerProfession villagerProfession = villager.getVillagerData().getProfession();
			Brain<Villager> p_35425_ = villager.getBrain();
			if (!villager.isBaby() && villagerProfession.equals(VillagerProfession.FARMER)) {
				p_35425_.addActivityWithConditions(Activity.WORK, TechnologicaVillagerGoalPackages.getWorkPackage(villagerProfession, 0.5F), ImmutableSet.of(Pair.of(MemoryModuleType.JOB_SITE, MemoryStatus.VALUE_PRESENT)));
			}
		}

		if (entity instanceof LivingEntity) {
			LivingEntity livingEntity = (LivingEntity) entity;
			if (entity.level().dimension().toString().contains("technologica:moon")) {
				if (!livingEntity.getAttribute(net.minecraftforge.common.ForgeMod.ENTITY_GRAVITY.get()).hasModifier(LUNAR_GRAVITY)) {
					livingEntity.getAttribute(net.minecraftforge.common.ForgeMod.ENTITY_GRAVITY.get()).addTransientModifier(LUNAR_GRAVITY);
				}
			} else {
				if (livingEntity.getAttribute(net.minecraftforge.common.ForgeMod.ENTITY_GRAVITY.get()).hasModifier(LUNAR_GRAVITY)) {
					livingEntity.getAttribute(net.minecraftforge.common.ForgeMod.ENTITY_GRAVITY.get()).removeModifier(LUNAR_GRAVITY_ID);
				}
			}

		}
	}
}