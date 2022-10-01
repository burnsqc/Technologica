package com.technologica.listeners.forgebus;

import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import com.technologica.world.entity.ai.behavior.TechnologicaVillagerGoalPackages;

import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.schedule.Activity;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ReplaceFarmerBrain {

	@SubscribeEvent
	public void onEntityJoinWorldEvent(EntityJoinLevelEvent event) {
		if (event.getEntity() instanceof Villager) {
			Villager villager = (Villager) event.getEntity();
			VillagerProfession villagerProfession = villager.getVillagerData().getProfession();
			Brain<Villager> p_35425_ = villager.getBrain();
			if (!villager.isBaby() && villagerProfession.equals(VillagerProfession.FARMER)) {
				p_35425_.addActivityWithConditions(Activity.WORK, TechnologicaVillagerGoalPackages.getWorkPackage(villagerProfession, 0.5F), ImmutableSet.of(Pair.of(MemoryModuleType.JOB_SITE, MemoryStatus.VALUE_PRESENT)));
			}
		}
	}
}