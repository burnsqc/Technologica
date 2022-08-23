package com.technologica.listeners.lootmodifiers;

import static com.technologica.Technologica.LOGGER;

import com.mojang.serialization.Codec;
import com.technologica.Technologica;

import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LootModifierListener {
	public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLM = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Technologica.MODID);

	public static void init() {
		GLM.register(FMLJavaModLoadingContext.get().getModEventBus());
		LOGGER.info("BLOCKS INITIALIZED: " + GLM.getEntries().size() + " OUT OF ?");
	}

	public static final RegistryObject<Codec<GrassLootModifier>> GRASS_LOOT_MODIFIER = GLM.register("technologica_seeds_from_grass", GrassLootModifier.CODEC);
	public static final RegistryObject<Codec<TallGrassLootModifier>> TALL_GRASS_LOOT_MODIFIER = GLM.register("technologica_seeds_from_tall_grass", TallGrassLootModifier.CODEC);
	public static final RegistryObject<Codec<FernLootModifier>> FERN_LOOT_MODIFIER = GLM.register("technologica_seeds_from_fern", FernLootModifier.CODEC);
	public static final RegistryObject<Codec<LargeFernLootModifier>> LARGE_FERN_LOOT_MODIFIER = GLM.register("technologica_seeds_from_large_fern", LargeFernLootModifier.CODEC);

	public static final RegistryObject<Codec<HuskLootModifier>> HUSK_LOOT_MODIFIER = GLM.register("technologica_foods_from_husk", HuskLootModifier.CODEC);
	public static final RegistryObject<Codec<ZombieLootModifier>> ZOMBIE_LOOT_MODIFIER = GLM.register("technologica_foods_from_zombie", ZombieLootModifier.CODEC);
	public static final RegistryObject<Codec<ZombieVillagerLootModifier>> ZOMBIE_VILLAGER_LOOT_MODIFIER = GLM.register("technologica_foods_from_zombie_villager", ZombieVillagerLootModifier.CODEC);

	public static final RegistryObject<Codec<AbandonedMineshaftLootModifier>> ABANDONED_MINESHAFT_LOOT_MODIFIER = GLM.register("technologica_seeds_from_abandoned_mineshaft_chest", AbandonedMineshaftLootModifier.CODEC);
	public static final RegistryObject<Codec<EndCityTreasureLootModifier>> END_CITY_TREASURE_LOOT_MODIFIER = GLM.register("technologica_seeds_from_end_city_treasure_chest", EndCityTreasureLootModifier.CODEC);
	public static final RegistryObject<Codec<IglooChestLootModifier>> IGLOO_CHEST_LOOT_MODIFIER = GLM.register("technologica_seeds_from_igloo_chest", IglooChestLootModifier.CODEC);
	public static final RegistryObject<Codec<PillagerOutpostLootModifier>> PILLAGER_OUTPOST_LOOT_MODIFIER = GLM.register("technologica_seeds_from_pillager_outpost_chest", PillagerOutpostLootModifier.CODEC);
	public static final RegistryObject<Codec<ShipwreckSupplyLootModifier>> SHIPWRECK_LOOT_MODIFIER = GLM.register("technologica_seeds_from_shipwreck_supply_chest", ShipwreckSupplyLootModifier.CODEC);
	public static final RegistryObject<Codec<SimpleDungeonLootModifier>> SIMPLE_DUNGEON_LOOT_MODIFIER = GLM.register("technologica_seeds_from_simple_dungeon_chest", SimpleDungeonLootModifier.CODEC);
	public static final RegistryObject<Codec<UnderwaterRuinBigLootModifier>> UNDERWATER_RUIN_BIG_LOOT_MODIFIER = GLM.register("technologica_seeds_from_underwater_ruin_big_chest", UnderwaterRuinBigLootModifier.CODEC);
	public static final RegistryObject<Codec<UnderwaterRuinSmallLootModifier>> UNDERWATER_RUIN_SMALL_LOOT_MODIFIER = GLM.register("technologica_seeds_from_underwater_ruin_small_chest", UnderwaterRuinSmallLootModifier.CODEC);
	public static final RegistryObject<Codec<VillageButcherLootModifier>> VILLAGE_BUTCHER_LOOT_MODIFIER = GLM.register("technologica_seeds_from_village_butcher_chest", VillageButcherLootModifier.CODEC);
	public static final RegistryObject<Codec<VillageFisherLootModifier>> VILLAGE_FISHER_LOOT_MODIFIER = GLM.register("technologica_seeds_from_village_fisher_chest", VillageFisherLootModifier.CODEC);
	public static final RegistryObject<Codec<VillageShepherdLootModifier>> VILLAGE_SHEPHARD_LOOT_MODIFIER = GLM.register("technologica_seeds_from_village_shepherd_chest", VillageShepherdLootModifier.CODEC);
	public static final RegistryObject<Codec<VillageDesertHouseLootModifier>> VILLAGE_DESERT_HOUSE_LOOT_MODIFIER = GLM.register("technologica_seeds_from_village_desert_house_chest", VillageDesertHouseLootModifier.CODEC);
	public static final RegistryObject<Codec<VillagePlainsHouseLootModifier>> VILLAGE_PLAINS_HOUSE_LOOT_MODIFIER = GLM.register("technologica_seeds_from_village_plains_house_chest", VillagePlainsHouseLootModifier.CODEC);
	public static final RegistryObject<Codec<VillageSavannaHouseLootModifier>> VILLAGE_SAVANNA_HOUSE_LOOT_MODIFIER = GLM.register("technologica_seeds_from_village_savanna_house_chest", VillageSavannaHouseLootModifier.CODEC);
	public static final RegistryObject<Codec<VillageSnowyHouseLootModifier>> VILLAGE_SNOWY_HOUSE_LOOT_MODIFIER = GLM.register("technologica_seeds_from_village_snowy_house_chest", VillageSnowyHouseLootModifier.CODEC);
	public static final RegistryObject<Codec<VillageTaigaHouseLootModifier>> VILLAGE_TAIGA_HOUSE_LOOT_MODIFIER = GLM.register("technologica_seeds_from_village_taiga_house_chest", VillageTaigaHouseLootModifier.CODEC);
	public static final RegistryObject<Codec<WoodlandMansionLootModifier>> WOODLAND_MANSION_LOOT_MODIFIER = GLM.register("technologica_seeds_from_woodland_mansion_chest", WoodlandMansionLootModifier.CODEC);
}