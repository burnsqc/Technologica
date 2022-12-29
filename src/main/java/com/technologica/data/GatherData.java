package com.technologica.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import com.technologica.Technologica;
import com.technologica.data.advancements.TechnologicaAdvancementProvider;
import com.technologica.data.loot.TechnologicaLootTableProvider;
import com.technologica.data.recipes.TechnologicaRecipeProvider;
import com.technologica.data.tags.TechnologicaBlockTagsProvider;
import com.technologica.data.tags.TechnologicaFluidTagsProvider;
import com.technologica.data.tags.TechnologicaItemTagsProvider;
import com.technologica.world.entity.TechnologicaEntityType;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.JsonCodecProvider;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class GatherData {
	RegistryAccess registryAccess;
	
	public static void onGatherDataEvent(final GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();
		RegistryAccess registryAccess = RegistryAccess.builtinCopy();
		RegistryOps<JsonElement> registryOps = RegistryOps.create(JsonOps.INSTANCE, registryAccess);

		generator.addProvider(event.includeClient(), new TechnologicaLanguageProvider(generator));
		generator.addProvider(event.includeClient(), new TechnologicaBlockStateProvider(generator, helper));
		generator.addProvider(event.includeClient(), new TechnologicaItemModelProvider(generator, helper));

		generator.addProvider(event.includeServer(), new TechnologicaFluidTagsProvider(generator, helper));
		TechnologicaBlockTagsProvider technologicaBlockTagsProvider = new TechnologicaBlockTagsProvider(generator, helper);
		generator.addProvider(event.includeServer(), technologicaBlockTagsProvider);
		generator.addProvider(event.includeServer(), new TechnologicaItemTagsProvider(generator, technologicaBlockTagsProvider, helper));
		generator.addProvider(event.includeServer(), new TechnologicaRecipeProvider(generator));
		generator.addProvider(event.includeServer(), new TechnologicaAdvancementProvider(generator, helper));
		generator.addProvider(event.includeServer(), new TechnologicaLootTableProvider(generator));
		
		//PROTOTYPING
		//This all changes in 1.19.3 so don't bother making any of it pretty
		Function<ResourceKey<Biome>, Holder<Biome>> func = x -> registryAccess.registryOrThrow(Registry.BIOME_REGISTRY).getHolder(x).get();

		ResourceLocation alligator = new ResourceLocation(Technologica.MODID, "spawn_alligator");
		ResourceLocation beaver = new ResourceLocation(Technologica.MODID, "spawn_beaver");
		ResourceLocation buffalo = new ResourceLocation(Technologica.MODID, "spawn_buffalo");
		ResourceLocation camel = new ResourceLocation(Technologica.MODID, "spawn_camel");
		ResourceLocation cobra = new ResourceLocation(Technologica.MODID, "spawn_cobra");
		ResourceLocation cottonmouth = new ResourceLocation(Technologica.MODID, "spawn_cottonmouth");
		ResourceLocation coyote = new ResourceLocation(Technologica.MODID, "spawn_coyote");
		ResourceLocation crab = new ResourceLocation(Technologica.MODID, "spawn_crab");
		ResourceLocation deer = new ResourceLocation(Technologica.MODID, "spawn_deer");
		ResourceLocation duck = new ResourceLocation(Technologica.MODID, "spawn_duck");
		ResourceLocation elephant = new ResourceLocation(Technologica.MODID, "spawn_elephant");
		ResourceLocation figureEightPufferfish= new ResourceLocation(Technologica.MODID, "spawn_figure_eight_pufferfish");
		ResourceLocation flamingo = new ResourceLocation(Technologica.MODID, "spawn_flamingo");
		ResourceLocation giraffe = new ResourceLocation(Technologica.MODID, "spawn_giraffe");
		ResourceLocation gorilla = new ResourceLocation(Technologica.MODID, "spawn_gorilla");
		ResourceLocation grizzlyBear = new ResourceLocation(Technologica.MODID, "spawn_grizzly_bear");
		ResourceLocation jaguar = new ResourceLocation(Technologica.MODID, "spawn_jaguar");
		ResourceLocation kingCrab = new ResourceLocation(Technologica.MODID, "spawn_king_crab");
		ResourceLocation leopardSeal = new ResourceLocation(Technologica.MODID, "spawn_leopard_seal");
		ResourceLocation lion = new ResourceLocation(Technologica.MODID, "spawn_lion");
		ResourceLocation lizard = new ResourceLocation(Technologica.MODID, "spawn_lizard");
		ResourceLocation moose = new ResourceLocation(Technologica.MODID, "spawn_moose");
		ResourceLocation narwhal = new ResourceLocation(Technologica.MODID, "spawn_narwhal");
		ResourceLocation octopus = new ResourceLocation(Technologica.MODID, "spawn_octopus");
		ResourceLocation ostrich = new ResourceLocation(Technologica.MODID, "spawn_ostrich");
		ResourceLocation owl = new ResourceLocation(Technologica.MODID, "spawn_owl");
		ResourceLocation penguin = new ResourceLocation(Technologica.MODID, "spawn_penguin");
		ResourceLocation piranha = new ResourceLocation(Technologica.MODID, "spawn_piranha");
		ResourceLocation poisonDartFrog = new ResourceLocation(Technologica.MODID, "spawn_poison_dart_frog");
		ResourceLocation raccoon = new ResourceLocation(Technologica.MODID, "spawn_raccoon");
		ResourceLocation scorpion = new ResourceLocation(Technologica.MODID, "spawn_scorpion");
		ResourceLocation shark = new ResourceLocation(Technologica.MODID, "spawn_shark");
		ResourceLocation sloth = new ResourceLocation(Technologica.MODID, "spawn_sloth");
		ResourceLocation stingray = new ResourceLocation(Technologica.MODID, "spawn_stingray");
		ResourceLocation turkey = new ResourceLocation(Technologica.MODID, "spawn_turkey");
		ResourceLocation vulture = new ResourceLocation(Technologica.MODID, "spawn_vulture");
		ResourceLocation zebra = new ResourceLocation(Technologica.MODID, "spawn_zebra");
		ResourceLocation mummy = new ResourceLocation(Technologica.MODID, "spawn_mummy");
		
		BiomeModifier alligatorSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.SWAMP)), List.of(new SpawnerData(TechnologicaEntityType.ALLIGATOR.get(), 100, 1, 2)));
		BiomeModifier beaverSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.FOREST), func.apply(Biomes.RIVER), func.apply(Biomes.SNOWY_SLOPES), func.apply(Biomes.SNOWY_TAIGA), func.apply(Biomes.STONY_PEAKS), func.apply(Biomes.TAIGA), func.apply(Biomes.WINDSWEPT_FOREST), func.apply(Biomes.WINDSWEPT_HILLS)), List.of(new SpawnerData(TechnologicaEntityType.BEAVER.get(), 100, 1, 2)));
		BiomeModifier buffaloSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.PLAINS)), List.of(new SpawnerData(TechnologicaEntityType.BUFFALO.get(), 100, 1, 2)));
		BiomeModifier camelSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.DESERT)), List.of(new SpawnerData(TechnologicaEntityType.CAMEL.get(), 100, 1, 2)));
		BiomeModifier cobraSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.DESERT)), List.of(new SpawnerData(TechnologicaEntityType.COBRA.get(), 100, 1, 2)));
		BiomeModifier cottonmouthSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.SWAMP)), List.of(new SpawnerData(TechnologicaEntityType.COTTONMOUTH.get(), 100, 1, 2)));
		BiomeModifier coyoteSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.BADLANDS)), List.of(new SpawnerData(TechnologicaEntityType.COYOTE.get(), 100, 1, 2)));
		BiomeModifier crabSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.BEACH)), List.of(new SpawnerData(TechnologicaEntityType.CRAB.get(), 100, 1, 2)));
		BiomeModifier deerSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.BIRCH_FOREST), func.apply(Biomes.FOREST), func.apply(Biomes.SNOWY_SLOPES), func.apply(Biomes.SNOWY_TAIGA), func.apply(Biomes.STONY_PEAKS), func.apply(Biomes.WINDSWEPT_FOREST), func.apply(Biomes.WINDSWEPT_HILLS)), List.of(new SpawnerData(TechnologicaEntityType.DEER.get(), 100, 1, 2)));
		BiomeModifier duckSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.RIVER)), List.of(new SpawnerData(TechnologicaEntityType.DUCK.get(), 100, 1, 2)));
		BiomeModifier elephantSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.SAVANNA)), List.of(new SpawnerData(TechnologicaEntityType.ELEPHANT.get(), 100, 1, 2)));
		BiomeModifier figureEightPufferfishSpawnerSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.MANGROVE_SWAMP)), List.of(new SpawnerData(TechnologicaEntityType.FIGURE_EIGHT_PUFFERFISH.get(), 100, 1, 2)));
		BiomeModifier flamingoSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.SWAMP)), List.of(new SpawnerData(TechnologicaEntityType.FLAMINGO.get(), 100, 1, 2)));
		BiomeModifier giraffeSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.SAVANNA)), List.of(new SpawnerData(TechnologicaEntityType.ELEPHANT.get(), 100, 1, 2)));
		BiomeModifier gorillaSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.JUNGLE)), List.of(new SpawnerData(TechnologicaEntityType.GORILLA.get(), 100, 1, 2)));
		BiomeModifier grizzlyBearSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.FOREST), func.apply(Biomes.SNOWY_SLOPES), func.apply(Biomes.SNOWY_TAIGA), func.apply(Biomes.STONY_PEAKS), func.apply(Biomes.TAIGA), func.apply(Biomes.WINDSWEPT_FOREST), func.apply(Biomes.WINDSWEPT_HILLS)), List.of(new SpawnerData(TechnologicaEntityType.GRIZZLY_BEAR.get(), 100, 1, 2)));
		BiomeModifier jaguarSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.MANGROVE_SWAMP)), List.of(new SpawnerData(TechnologicaEntityType.JAGUAR.get(), 100, 3, 5)));
		BiomeModifier kingCrabSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.FROZEN_OCEAN)), List.of(new SpawnerData(TechnologicaEntityType.KING_CRAB.get(), 100, 1, 2)));
		BiomeModifier leopardSealSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.FROZEN_OCEAN)), List.of(new SpawnerData(TechnologicaEntityType.LEOPARD_SEAL.get(), 100, 1, 2)));
		BiomeModifier lionSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.SAVANNA)), List.of(new SpawnerData(TechnologicaEntityType.LION.get(), 100, 3, 5)));
		BiomeModifier lizardSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.BADLANDS)), List.of(new SpawnerData(TechnologicaEntityType.LIZARD.get(), 100, 3, 5)));
		BiomeModifier mooseSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.TAIGA)), List.of(new SpawnerData(TechnologicaEntityType.MOOSE.get(), 100, 3, 5)));
		BiomeModifier narwhalSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.FROZEN_OCEAN)), List.of(new SpawnerData(TechnologicaEntityType.NARWHAL.get(), 100, 3, 5)));
		BiomeModifier octopusSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.WARM_OCEAN)), List.of(new SpawnerData(TechnologicaEntityType.OCTOPUS.get(), 100, 3, 5)));
		BiomeModifier ostrichSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.SAVANNA)), List.of(new SpawnerData(TechnologicaEntityType.OSTRICH.get(), 100, 1, 2)));
		BiomeModifier owlSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.TAIGA)), List.of(new SpawnerData(TechnologicaEntityType.OWL.get(), 100, 3, 5)));
		BiomeModifier penguinSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.ICE_SPIKES)), List.of(new SpawnerData(TechnologicaEntityType.PENGUIN.get(), 100, 3, 5)));
		BiomeModifier piranhaSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.RIVER)), List.of(new SpawnerData(TechnologicaEntityType.PIRANHA.get(), 100, 3, 5)));
		BiomeModifier poisonDartFrogSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.MANGROVE_SWAMP)), List.of(new SpawnerData(TechnologicaEntityType.POISON_DART_FROG.get(), 100, 3, 5)));
		BiomeModifier raccoonSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.BIRCH_FOREST), func.apply(Biomes.FOREST)), List.of(new SpawnerData(TechnologicaEntityType.RACCOON.get(), 100, 1, 2)));
		BiomeModifier scorpionSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.BADLANDS)), List.of(new SpawnerData(TechnologicaEntityType.SCORPION.get(), 100, 1, 2)));
		BiomeModifier sharkSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.OCEAN)), List.of(new SpawnerData(TechnologicaEntityType.SHARK.get(), 100, 1, 2)));
		BiomeModifier slothSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.JUNGLE)), List.of(new SpawnerData(TechnologicaEntityType.SLOTH.get(), 100, 1, 2)));
		BiomeModifier stingraySpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.MANGROVE_SWAMP), func.apply(Biomes.SWAMP)), List.of(new SpawnerData(TechnologicaEntityType.STINGRAY.get(), 100, 1, 2)));
		BiomeModifier turkeySpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.BIRCH_FOREST), func.apply(Biomes.SNOWY_SLOPES), func.apply(Biomes.SNOWY_TAIGA), func.apply(Biomes.STONY_PEAKS), func.apply(Biomes.WINDSWEPT_FOREST), func.apply(Biomes.WINDSWEPT_HILLS)), List.of(new SpawnerData(TechnologicaEntityType.TURKEY.get(), 100, 1, 2)));
		BiomeModifier vultureSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.BADLANDS)), List.of(new SpawnerData(TechnologicaEntityType.VULTURE.get(), 100, 1, 2)));
		BiomeModifier zebraSpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.SAVANNA)), List.of(new SpawnerData(TechnologicaEntityType.ZEBRA.get(), 100, 1, 2)));
		BiomeModifier mummySpawner = new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes(func.apply(Biomes.DESERT)), List.of(new SpawnerData(TechnologicaEntityType.MUMMY.get(), 100, 1, 1)));
	
		Map<ResourceLocation, BiomeModifier> map = new HashMap<>();
		map.put(alligator, alligatorSpawner);
		map.put(beaver, beaverSpawner);
		map.put(buffalo, buffaloSpawner);
		map.put(camel, camelSpawner);
		map.put(cobra, cobraSpawner);
		map.put(cottonmouth, cottonmouthSpawner);
		map.put(coyote, coyoteSpawner);
		map.put(crab, crabSpawner);
		map.put(deer, deerSpawner);
		map.put(duck, duckSpawner);
		map.put(elephant, elephantSpawner);
		map.put(figureEightPufferfish, figureEightPufferfishSpawnerSpawner);
		map.put(flamingo, flamingoSpawner);
		map.put(giraffe, giraffeSpawner);
		map.put(gorilla, gorillaSpawner);
		map.put(grizzlyBear, grizzlyBearSpawner);
		map.put(jaguar, jaguarSpawner);
		map.put(kingCrab, kingCrabSpawner);
		map.put(leopardSeal, leopardSealSpawner);
		map.put(lion, lionSpawner);
		map.put(lizard, lizardSpawner);
		map.put(moose, mooseSpawner);
		map.put(narwhal, narwhalSpawner);
		map.put(octopus, octopusSpawner);
		map.put(ostrich, ostrichSpawner);
		map.put(owl, owlSpawner);
		map.put(penguin, penguinSpawner);
		map.put(piranha, piranhaSpawner);
		map.put(poisonDartFrog, poisonDartFrogSpawner);
		map.put(raccoon, raccoonSpawner);
		map.put(scorpion, scorpionSpawner);
		map.put(shark, sharkSpawner);
		map.put(sloth, slothSpawner);
		map.put(stingray, stingraySpawner);
		map.put(turkey, turkeySpawner);
		map.put(vulture, vultureSpawner);
		map.put(zebra, zebraSpawner);
		map.put(mummy, mummySpawner);

		JsonCodecProvider<BiomeModifier> provider = JsonCodecProvider.forDatapackRegistry(generator, helper, Technologica.MODID, registryOps, ForgeRegistries.Keys.BIOME_MODIFIERS, map);
		
		generator.addProvider(event.includeServer(), provider);
	}
	
	@SafeVarargs
	private static HolderSet<Biome> biomes(Holder<Biome>... holders) {
		return HolderSet.direct(holders);
	}
}