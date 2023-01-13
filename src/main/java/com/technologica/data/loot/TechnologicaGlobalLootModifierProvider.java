package com.technologica.data.loot;

import com.technologica.Technologica;
import com.technologica.listeners.lootmodifiers.AbandonedMineshaftLootModifier;
import com.technologica.listeners.lootmodifiers.EndCityTreasureLootModifier;
import com.technologica.listeners.lootmodifiers.FernLootModifier;
import com.technologica.listeners.lootmodifiers.GrassLootModifier;
import com.technologica.listeners.lootmodifiers.HuskLootModifier;
import com.technologica.listeners.lootmodifiers.IglooLootModifier;
import com.technologica.listeners.lootmodifiers.LargeFernLootModifier;
import com.technologica.listeners.lootmodifiers.PillagerOutpostLootModifier;
import com.technologica.listeners.lootmodifiers.ShipwreckSupplyLootModifier;
import com.technologica.listeners.lootmodifiers.SimpleDungeonLootModifier;
import com.technologica.listeners.lootmodifiers.TallGrassLootModifier;
import com.technologica.listeners.lootmodifiers.UnderwaterRuinBigLootModifier;
import com.technologica.listeners.lootmodifiers.UnderwaterRuinSmallLootModifier;
import com.technologica.listeners.lootmodifiers.VillageButcherLootModifier;
import com.technologica.listeners.lootmodifiers.VillageDesertHouseLootModifier;
import com.technologica.listeners.lootmodifiers.VillageFisherLootModifier;
import com.technologica.listeners.lootmodifiers.VillagePlainsHouseLootModifier;
import com.technologica.listeners.lootmodifiers.VillageSavannaHouseLootModifier;
import com.technologica.listeners.lootmodifiers.VillageShepherdLootModifier;
import com.technologica.listeners.lootmodifiers.VillageSnowyHouseLootModifier;
import com.technologica.listeners.lootmodifiers.VillageTaigaHouseLootModifier;
import com.technologica.listeners.lootmodifiers.WoodlandMansionLootModifier;
import com.technologica.listeners.lootmodifiers.ZombieLootModifier;
import com.technologica.listeners.lootmodifiers.ZombieVillagerLootModifier;

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
		this.add("blocks/fern", new FernLootModifier(new LootItemCondition[] {
				LootTableIdCondition.builder(new ResourceLocation("blocks/fern")).build()
		}));
		this.add("blocks/grass", new GrassLootModifier(new LootItemCondition[] {
				LootTableIdCondition.builder(new ResourceLocation("blocks/grass")).build()
		}));
		this.add("blocks/large_fern", new LargeFernLootModifier(new LootItemCondition[] {
				LootTableIdCondition.builder(new ResourceLocation("blocks/large_fern")).build()
		}));
		this.add("blocks/tall_grass", new TallGrassLootModifier(new LootItemCondition[] {
				LootTableIdCondition.builder(new ResourceLocation("blocks/tall_grass")).build()
		}));
		/*
		 * CHESTS
		 */
		this.add("chests/abandoned_mineshaft", new AbandonedMineshaftLootModifier(new LootItemCondition[] {
				LootTableIdCondition.builder(new ResourceLocation("chests/abandoned_mineshaft")).build()
		}));
		this.add("chests/end_city_treasure", new EndCityTreasureLootModifier(new LootItemCondition[] {
				LootTableIdCondition.builder(new ResourceLocation("chests/end_city_treasure")).build()
		}));
		this.add("chests/igloo_chest", new IglooLootModifier(new LootItemCondition[] {
				LootTableIdCondition.builder(new ResourceLocation("chests/igloo_chest")).build()
		}));
		this.add("chests/pillager_outpost", new PillagerOutpostLootModifier(new LootItemCondition[] {
				LootTableIdCondition.builder(new ResourceLocation("chests/pillager_outpost")).build()
		}));
		this.add("chests/shipwreck_supply", new ShipwreckSupplyLootModifier(new LootItemCondition[] {
				LootTableIdCondition.builder(new ResourceLocation("chests/shipwreck_supply")).build()
		}));
		this.add("chests/simple_dungeon", new SimpleDungeonLootModifier(new LootItemCondition[] {
				LootTableIdCondition.builder(new ResourceLocation("chests/simple_dungeon")).build()
		}));
		this.add("chests/underwater_ruin_big", new UnderwaterRuinBigLootModifier(new LootItemCondition[] {
				LootTableIdCondition.builder(new ResourceLocation("chests/underwater_ruin_big")).build()
		}));
		this.add("chests/underwater_ruin_small", new UnderwaterRuinSmallLootModifier(new LootItemCondition[] {
				LootTableIdCondition.builder(new ResourceLocation("chests/underwater_ruin_small")).build()
		}));
		this.add("chests/woodland_mansion", new WoodlandMansionLootModifier(new LootItemCondition[] {
				LootTableIdCondition.builder(new ResourceLocation("chests/woodland_mansion")).build()
		}));
		/*
		 * VILLAGE CHESTS	
		 */
		this.add("chests/village/village_butcher", new VillageButcherLootModifier(new LootItemCondition[] {
				LootTableIdCondition.builder(new ResourceLocation("chests/village/village_butcher")).build()
		}));
		this.add("chests/village/village_desert_house", new VillageDesertHouseLootModifier(new LootItemCondition[] {
				LootTableIdCondition.builder(new ResourceLocation("chests/village/village_desert_house")).build()
		}));
		this.add("chests/village/village_fisher", new VillageFisherLootModifier(new LootItemCondition[] {
				LootTableIdCondition.builder(new ResourceLocation("chests/village/village_fisher")).build()
		}));
		this.add("chests/village/village_plains_house", new VillagePlainsHouseLootModifier(new LootItemCondition[] {
				LootTableIdCondition.builder(new ResourceLocation("chests/village/village_plains_house")).build()
		}));
		this.add("chests/village/village_savanna_house", new VillageSavannaHouseLootModifier(new LootItemCondition[] {
				LootTableIdCondition.builder(new ResourceLocation("chests/village/village_savanna_house")).build()
		}));
		this.add("chests/village/village_shepherd", new VillageShepherdLootModifier(new LootItemCondition[] {
				LootTableIdCondition.builder(new ResourceLocation("chests/village/village_shepherd")).build()
		}));
		this.add("chests/village/village_snowy_house", new VillageSnowyHouseLootModifier(new LootItemCondition[] {
				LootTableIdCondition.builder(new ResourceLocation("chests/village/village_snowy_house")).build()
		}));
		this.add("chests/village/village_taiga_house", new VillageTaigaHouseLootModifier(new LootItemCondition[] {
				LootTableIdCondition.builder(new ResourceLocation("chests/village/village_taiga_house")).build()
		}));
		/*
		 * ENTITIES
		 */
		this.add("entities/husk", new HuskLootModifier(new LootItemCondition[] {
				LootTableIdCondition.builder(new ResourceLocation("entities/husk")).build()
		}));
		this.add("entities/zombie", new ZombieLootModifier(new LootItemCondition[] {
				LootTableIdCondition.builder(new ResourceLocation("entities/zombie")).build()
		}));
		this.add("entities/zombie_villager", new ZombieVillagerLootModifier(new LootItemCondition[] {
				LootTableIdCondition.builder(new ResourceLocation("entities/zombie_villager")).build()
		}));
	}
}
