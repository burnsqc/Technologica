package com.technologica.registration.deferred;

import com.mojang.serialization.Codec;
import com.technologica.Technologica;
import com.technologica.listeners.lootmodifiers.TechnologicaChestLootModifier;
import com.technologica.listeners.lootmodifiers.blocks.FernLootModifier;
import com.technologica.listeners.lootmodifiers.blocks.GrassLootModifier;
import com.technologica.listeners.lootmodifiers.blocks.LargeFernLootModifier;
import com.technologica.listeners.lootmodifiers.blocks.TallGrassLootModifier;
import com.technologica.listeners.lootmodifiers.entities.HuskLootModifier;
import com.technologica.listeners.lootmodifiers.entities.ZombieLootModifier;
import com.technologica.listeners.lootmodifiers.entities.ZombieVillagerLootModifier;

import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaGlobalLootModifierSerializers {
	public static final RegistryObject<Codec<FernLootModifier>> FERN_LOOT_MODIFIER = Technologica.GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("blocks/fern", FernLootModifier.CODEC);
	public static final RegistryObject<Codec<GrassLootModifier>> GRASS_LOOT_MODIFIER = Technologica.GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("blocks/grass", GrassLootModifier.CODEC);
	public static final RegistryObject<Codec<LargeFernLootModifier>> LARGE_FERN_LOOT_MODIFIER = Technologica.GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("blocks/large_fern", LargeFernLootModifier.CODEC);
	public static final RegistryObject<Codec<TallGrassLootModifier>> TALL_GRASS_LOOT_MODIFIER = Technologica.GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("blocks/tall_grass", TallGrassLootModifier.CODEC);
	public static final RegistryObject<Codec<HuskLootModifier>> HUSK_LOOT_MODIFIER = Technologica.GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("husk", HuskLootModifier.CODEC);
	public static final RegistryObject<Codec<ZombieLootModifier>> ZOMBIE_LOOT_MODIFIER = Technologica.GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("zombie", ZombieLootModifier.CODEC);
	public static final RegistryObject<Codec<ZombieVillagerLootModifier>> ZOMBIE_VILLAGER_LOOT_MODIFIER = Technologica.GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("zombie_villager", ZombieVillagerLootModifier.CODEC);
	public static final RegistryObject<Codec<TechnologicaChestLootModifier>> TECHNOLOGICA_CHEST_LOOT_MODIFIER = Technologica.GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("technologica_chest_loot_modifier", TechnologicaChestLootModifier.CODEC);
}
