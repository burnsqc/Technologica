package com.technologica.data.loot;

import com.technologica.Technologica;
import com.technologica.listeners.lootmodifiers.TechnologicaChestLootModifier;
import com.technologica.listeners.lootmodifiers.blocks.FernLootModifier;
import com.technologica.listeners.lootmodifiers.blocks.GrassLootModifier;
import com.technologica.listeners.lootmodifiers.blocks.LargeFernLootModifier;
import com.technologica.listeners.lootmodifiers.blocks.TallGrassLootModifier;
import com.technologica.listeners.lootmodifiers.entities.HuskLootModifier;
import com.technologica.listeners.lootmodifiers.entities.ZombieLootModifier;
import com.technologica.listeners.lootmodifiers.entities.ZombieVillagerLootModifier;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class TechnologicaGlobalLootModifierProvider extends GlobalLootModifierProvider {

	public TechnologicaGlobalLootModifierProvider(PackOutput output) {
		super(output, Technologica.MODID);
	}

	@Override
	protected void start() {
		/*
		 * BLOCKS
		 */
		this.add("blocks/fern", new FernLootModifier(new LootItemCondition[] { LootTableIdCondition.builder(new ResourceLocation("blocks/fern")).build() }));
		this.add("blocks/grass", new GrassLootModifier(new LootItemCondition[] { LootTableIdCondition.builder(new ResourceLocation("blocks/grass")).build() }));
		this.add("blocks/large_fern", new LargeFernLootModifier(new LootItemCondition[] { LootTableIdCondition.builder(new ResourceLocation("blocks/large_fern")).build() }));
		this.add("blocks/tall_grass", new TallGrassLootModifier(new LootItemCondition[] { LootTableIdCondition.builder(new ResourceLocation("blocks/tall_grass")).build() }));

		/*
		 * ENTITIES
		 */
		this.add("entities/husk", new HuskLootModifier(new LootItemCondition[] { LootTableIdCondition.builder(new ResourceLocation("entities/husk")).build() }));
		this.add("entities/zombie", new ZombieLootModifier(new LootItemCondition[] { LootTableIdCondition.builder(new ResourceLocation("entities/zombie")).build() }));
		this.add("entities/zombie_villager", new ZombieVillagerLootModifier(new LootItemCondition[] { LootTableIdCondition.builder(new ResourceLocation("entities/zombie_villager")).build() }));

		/*
		 * CHESTS
		 */

		this.add("chests/technologica_modifier", new TechnologicaChestLootModifier(new LootItemCondition[] { LootTableIdCondition.builder(new ResourceLocation("chests/abandoned_mineshaft")).or(LootTableIdCondition.builder(new ResourceLocation("chests/ancient_city"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/ancient_city_ice_box"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/bastion_bridge"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/bastion_hoglin_stable"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/bastion_other"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/bastion_treasure"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/buried_treasure"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/desert_pyramid"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/end_city_treasure"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/igloo_chest"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/jungle_temple"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/jungle_temple_dispenser"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/nether_bridge"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/pillager_outpost"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/ruined_portal"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/shipwreck_map"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/shipwreck_supply"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/shipwreck_tresure"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/simple_dungeon"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/spawn_bonus_chest"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/stronghold_corridor"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/stronghold_crossing"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/stronghold_library"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/underwater_ruin_big"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/underwater_ruin_small"))).or(LootTableIdCondition.builder(new ResourceLocation("chests/woodland_mansion"))).build() }));
	}
}