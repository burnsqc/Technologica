package com.technologica.setup;

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
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.crafting.Ingredient;
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
			/*
			
			try {
				Field wanted_items = ObfuscationReflectionHelper.findField(Villager.class, "WANTED_ITEMS");
				wanted_items.setAccessible(true);
				Set<Item> wanted_set = (Set<Item>) wanted_items.get(null);
				Set<Item> WANTED_ITEMS_TEMP = Set.copyOf(wanted_set);
				
				Set<Item> WANTED_ITEMS_NEW = (Set<Item>) ImmutableSet.builder().add(WANTED_ITEMS_TEMP).add(TechnologicaItems.BARLEY.get());
				wanted_items.set(null, WANTED_ITEMS_NEW);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
			*/
	    }
	    
		if (entity instanceof Sheep) {
			Sheep sheep = (Sheep) entity;
			sheep.goalSelector.addGoal(3, new TemptGoal(sheep, 1.1D, Ingredient.of(TechnologicaItems.BARLEY.get(), TechnologicaItems.OATS.get(), TechnologicaItems.RYE.get(), TechnologicaItems.CORN.get()), false));
	    }
	}
}