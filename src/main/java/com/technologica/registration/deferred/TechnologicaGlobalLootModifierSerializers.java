package com.technologica.registration.deferred;

import com.mojang.serialization.Codec;
import com.technologica.Technologica;
import com.technologica.api.tlregen.registration.MasterDeferredRegistrar;
import com.technologica.listeners.lootmodifiers.TechnologicaChestLootModifier;
import com.technologica.listeners.lootmodifiers.blocks.FernLootModifier;
import com.technologica.listeners.lootmodifiers.blocks.GrassLootModifier;
import com.technologica.listeners.lootmodifiers.blocks.LargeFernLootModifier;
import com.technologica.listeners.lootmodifiers.blocks.TallGrassLootModifier;
import com.technologica.listeners.lootmodifiers.entities.HuskLootModifier;
import com.technologica.listeners.lootmodifiers.entities.ZombieLootModifier;
import com.technologica.listeners.lootmodifiers.entities.ZombieVillagerLootModifier;

import net.minecraftforge.registries.RegistryObject;

/**
 * <p>
 * This class contains Registry Objects for Global Loot Modifier Serializers.
 * The {@link #init} method is called by {@link Technologica#initDeferredRegisters} and returns a head-count to later be checked during registration and other setup activities.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaGlobalLootModifierSerializers extends MasterDeferredRegistrar {
	public static final RegistryObject<Codec<FernLootModifier>> FERN_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("blocks/fern", FernLootModifier.CODEC);
	public static final RegistryObject<Codec<GrassLootModifier>> GRASS_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("blocks/grass", GrassLootModifier.CODEC);
	public static final RegistryObject<Codec<LargeFernLootModifier>> LARGE_FERN_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("blocks/large_fern", LargeFernLootModifier.CODEC);
	public static final RegistryObject<Codec<TallGrassLootModifier>> TALL_GRASS_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("blocks/tall_grass", TallGrassLootModifier.CODEC);
	public static final RegistryObject<Codec<HuskLootModifier>> HUSK_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("husk", HuskLootModifier.CODEC);
	public static final RegistryObject<Codec<ZombieLootModifier>> ZOMBIE_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("zombie", ZombieLootModifier.CODEC);
	public static final RegistryObject<Codec<ZombieVillagerLootModifier>> ZOMBIE_VILLAGER_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("zombie_villager", ZombieVillagerLootModifier.CODEC);
	public static final RegistryObject<Codec<TechnologicaChestLootModifier>> TECHNOLOGICA_CHEST_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("technologica_chest_loot_modifier", TechnologicaChestLootModifier.CODEC);
}
