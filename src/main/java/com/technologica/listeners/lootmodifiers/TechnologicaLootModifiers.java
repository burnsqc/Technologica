package com.technologica.listeners.lootmodifiers;

import com.mojang.serialization.Codec;
import com.technologica.Technologica;

import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TechnologicaLootModifiers {
	public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Technologica.MODID);

	public static int init() {
		GLOBAL_LOOT_MODIFIER_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
		return GLOBAL_LOOT_MODIFIER_SERIALIZERS.getEntries().size();
	}

	/*
	 * BLOCKS
	 */
	public static final RegistryObject<Codec<FernLootModifier>> FERN_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("blocks/fern", FernLootModifier.CODEC);
	public static final RegistryObject<Codec<GrassLootModifier>> GRASS_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("blocks/grass", GrassLootModifier.CODEC);
	public static final RegistryObject<Codec<LargeFernLootModifier>> LARGE_FERN_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("blocks/large_fern", LargeFernLootModifier.CODEC);
	public static final RegistryObject<Codec<TallGrassLootModifier>> TALL_GRASS_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("blocks/tall_grass", TallGrassLootModifier.CODEC);

	/*
	 * CHESTS
	 */
	public static final RegistryObject<Codec<AbandonedMineshaftLootModifier>> ABANDONED_MINESHAFT_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("chests/abandoned_mineshaft", AbandonedMineshaftLootModifier.CODEC);
	public static final RegistryObject<Codec<EndCityTreasureLootModifier>> END_CITY_TREASURE_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("chests/end_city_treasure", EndCityTreasureLootModifier.CODEC);
	public static final RegistryObject<Codec<IglooLootModifier>> IGLOO_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("chests/igloo", IglooLootModifier.CODEC);
	public static final RegistryObject<Codec<PillagerOutpostLootModifier>> PILLAGER_OUTPOST_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("chests/pillager_outpost", PillagerOutpostLootModifier.CODEC);
	public static final RegistryObject<Codec<ShipwreckSupplyLootModifier>> SHIPWRECK_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("chests/shipwreck_supply", ShipwreckSupplyLootModifier.CODEC);
	public static final RegistryObject<Codec<SimpleDungeonLootModifier>> SIMPLE_DUNGEON_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("chests/simple_dungeon", SimpleDungeonLootModifier.CODEC);
	public static final RegistryObject<Codec<UnderwaterRuinBigLootModifier>> UNDERWATER_RUIN_BIG_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("chests/underwater_ruin_big", UnderwaterRuinBigLootModifier.CODEC);
	public static final RegistryObject<Codec<UnderwaterRuinSmallLootModifier>> UNDERWATER_RUIN_SMALL_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("chests/underwater_ruin_small", UnderwaterRuinSmallLootModifier.CODEC);
	public static final RegistryObject<Codec<WoodlandMansionLootModifier>> WOODLAND_MANSION_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("chests/woodland_mansion", WoodlandMansionLootModifier.CODEC);

	/*
	 * VILLAGE CHESTS
	 */
	public static final RegistryObject<Codec<VillageButcherLootModifier>> VILLAGE_BUTCHER_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("chests/village/village_butcher", VillageButcherLootModifier.CODEC);
	public static final RegistryObject<Codec<VillageFisherLootModifier>> VILLAGE_FISHER_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("chests/village/village_fisher", VillageFisherLootModifier.CODEC);
	public static final RegistryObject<Codec<VillageShepherdLootModifier>> VILLAGE_SHEPHARD_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("chests/village/village_shepherd", VillageShepherdLootModifier.CODEC);
	public static final RegistryObject<Codec<VillageDesertHouseLootModifier>> VILLAGE_DESERT_HOUSE_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("chests/village/village_desert_house", VillageDesertHouseLootModifier.CODEC);
	public static final RegistryObject<Codec<VillagePlainsHouseLootModifier>> VILLAGE_PLAINS_HOUSE_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("chests/village/village_plains_house", VillagePlainsHouseLootModifier.CODEC);
	public static final RegistryObject<Codec<VillageSavannaHouseLootModifier>> VILLAGE_SAVANNA_HOUSE_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("chests/village/village_savanna_house", VillageSavannaHouseLootModifier.CODEC);
	public static final RegistryObject<Codec<VillageSnowyHouseLootModifier>> VILLAGE_SNOWY_HOUSE_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("chests/village/village_snowy_house", VillageSnowyHouseLootModifier.CODEC);
	public static final RegistryObject<Codec<VillageTaigaHouseLootModifier>> VILLAGE_TAIGA_HOUSE_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("chests/village/village_taiga_house", VillageTaigaHouseLootModifier.CODEC);

	/*
	 * ENTITIES
	 */
	public static final RegistryObject<Codec<HuskLootModifier>> HUSK_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("husk", HuskLootModifier.CODEC);
	public static final RegistryObject<Codec<ZombieLootModifier>> ZOMBIE_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("zombie", ZombieLootModifier.CODEC);
	public static final RegistryObject<Codec<ZombieVillagerLootModifier>> ZOMBIE_VILLAGER_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("zombie_villager", ZombieVillagerLootModifier.CODEC);
}
