package com.technologica.world.entity.ai.behavior;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.BehaviorControl;
import net.minecraft.world.entity.ai.behavior.DoNothing;
import net.minecraft.world.entity.ai.behavior.GiveGiftToHero;
import net.minecraft.world.entity.ai.behavior.RunOne;
import net.minecraft.world.entity.ai.behavior.SetEntityLookTarget;
import net.minecraft.world.entity.ai.behavior.SetLookAndInteract;
import net.minecraft.world.entity.ai.behavior.SetWalkTargetFromBlockMemory;
import net.minecraft.world.entity.ai.behavior.ShowTradesToPlayer;
import net.minecraft.world.entity.ai.behavior.StrollAroundPoi;
import net.minecraft.world.entity.ai.behavior.StrollToPoi;
import net.minecraft.world.entity.ai.behavior.StrollToPoiList;
import net.minecraft.world.entity.ai.behavior.UpdateActivityFromSchedule;
import net.minecraft.world.entity.ai.behavior.UseBonemeal;
import net.minecraft.world.entity.ai.behavior.WorkAtPoi;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;

public class TechnologicaVillagerGoalPackages {
	public static ImmutableList<Pair<Integer, ? extends BehaviorControl<? super Villager>>> getWorkPackage(VillagerProfession p_24590_, float p_24591_) {
		WorkAtPoi workatpoi;
		if (p_24590_ == VillagerProfession.FARMER) {
			workatpoi = new TechnologicaWorkAtComposter();
		} else {
			workatpoi = new WorkAtPoi();
		}

		return ImmutableList.of(getMinimalLookBehavior(), Pair.of(5, new RunOne<>(ImmutableList.of(Pair.of(workatpoi, 7), Pair.of(StrollAroundPoi.create(MemoryModuleType.JOB_SITE, 0.4F, 4), 2), Pair.of(StrollToPoi.create(MemoryModuleType.JOB_SITE, 0.4F, 1, 10), 5), Pair.of(StrollToPoiList.create(MemoryModuleType.SECONDARY_JOB_SITE, p_24591_, 1, 6, MemoryModuleType.JOB_SITE), 5), Pair.of(new TechnologicaHarvestFarmland(), p_24590_ == VillagerProfession.FARMER ? 2 : 5), Pair.of(new UseBonemeal(), p_24590_ == VillagerProfession.FARMER ? 4 : 7)))), Pair.of(10, new ShowTradesToPlayer(400, 1600)), Pair.of(10, SetLookAndInteract.create(EntityType.PLAYER, 4)), Pair.of(2, SetWalkTargetFromBlockMemory.create(MemoryModuleType.JOB_SITE, p_24591_, 9, 100, 1200)), Pair.of(3, new GiveGiftToHero(100)), Pair.of(99, UpdateActivityFromSchedule.create()));
	}

	private static Pair<Integer, BehaviorControl<LivingEntity>> getMinimalLookBehavior() {
		return Pair.of(5, new RunOne<>(ImmutableList.of(Pair.of(SetEntityLookTarget.create(EntityType.VILLAGER, 8.0F), 2), Pair.of(SetEntityLookTarget.create(EntityType.PLAYER, 8.0F), 2), Pair.of(new DoNothing(30, 60), 8))));
	}
}