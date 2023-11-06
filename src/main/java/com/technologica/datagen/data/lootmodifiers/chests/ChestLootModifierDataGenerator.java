package com.technologica.datagen.data.lootmodifiers.chests;

import com.technologica.Technologica;
import com.technologica.listeners.lootmodifiers.TechnologicaChestLootModifier;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ChestLootModifierDataGenerator extends GlobalLootModifierProvider {

	public ChestLootModifierDataGenerator(PackOutput output) {
		super(output, Technologica.MODID);
	}

	@Override
	protected void start() {
		add("chests/technologica_modifier", new TechnologicaChestLootModifier(new LootItemCondition[] { LootTableIdCondition.builder(new ResourceLocation("chests/abandoned_mineshaft")).or(LootTableIdCondition.builder(new ResourceLocation("chests/ancient_city"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/ancient_city_ice_box"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/bastion_bridge"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/bastion_hoglin_stable"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/bastion_other"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/bastion_treasure"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/buried_treasure"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/desert_pyramid"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/end_city_treasure"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/igloo_chest"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/jungle_temple"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/jungle_temple_dispenser"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/nether_bridge"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/pillager_outpost"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/ruined_portal"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/shipwreck_map"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/shipwreck_supply"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/shipwreck_tresure"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/simple_dungeon"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/spawn_bonus_chest"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/stronghold_corridor"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/stronghold_crossing"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/stronghold_library"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/underwater_ruin_big"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/underwater_ruin_small"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/woodland_mansion"))).build() }));
	}
}