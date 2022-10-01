package com.technologica.listeners.forgebus;

import java.util.function.Predicate;

import com.technologica.world.entity.animal.GrizzlyBear;
import com.technologica.world.entity.animal.Shark;
import com.technologica.world.item.TechnologicaItems;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class VanillaEntityModifier {

	@SubscribeEvent
	public void onEntityJoinLevelEvent(final EntityJoinLevelEvent event) {
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
	}
}