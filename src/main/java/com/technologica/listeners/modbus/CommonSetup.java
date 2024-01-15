package com.technologica.listeners.modbus;

import static com.technologica.Technologica.LOGGER;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableSet;
import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.registration.deferred.TechnologicaItems;

import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * <p>
 * This class listens for FMLCommonSetupEvent which is fired on the mod-specific event bus.
 * When the event is intercepted, various common setup tasks are performed.
 * </p>
 * 
 * @tl.status YELLOW
 */

public class CommonSetup {

	public static void onFMLCommonSetupEvent(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			addToComposter();
			addToFlowerPot();
			addToVillagerWantedItems();
		});
	}

	private static void addToComposter() {
		int before = ComposterBlock.COMPOSTABLES.size();
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.CUCUMBER_SEEDS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.GRAPE_SEEDS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.SQUASH_SEEDS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.TOMATO_SEEDS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.ZUCCHINI_SEEDS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.CRANBERRY_SEEDS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.BARLEY_SEEDS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.CORN_SEEDS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.OATS_SEEDS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.RYE_SEEDS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.RICE_SEEDS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.BROCCOLI_SEEDS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.CELERY_SEEDS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.COFFEE_BEANS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.LETTUCE_SEEDS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.MUSTARD_SEEDS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.ONION_SEEDS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.PEAS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.PINEAPPLE_SEEDS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.PURPLE_CABBAGE_SEEDS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.RADISH_SEEDS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.RED_BEANS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.SOY_BEANS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.TEA_SEEDS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.TURNIP_SEEDS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.PEPPERCORNS.get().asItem(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.BARLEY.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.OATS.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.RYE.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.CORN.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.RICE.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.ASPARAGUS.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.CHILI_PEPPER.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.GARLIC.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.GINGER.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.SWEET_POTATO.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.PEANUT.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.BROCCOLI.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.CELERY.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.LETTUCE.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.MUSTARD_GREENS.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.PINEAPPLE.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.PURPLE_CABBAGE.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.ONION.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.RADISH.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.TEA_LEAF.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.TURNIP.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.CRANBERRY.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.BLACKBERRY.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.BLUEBERRY.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.RASPBERRY.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.STRAWBERRY.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.GRAPE.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.TOMATO.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.CUCUMBER.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.SQUASH.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.ZUCCHINI.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.APRICOT.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.AVOCADO.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.BANANA.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.CHERRY.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.CHESTNUT.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.CINNAMON.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.COCONUT.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.KIWI.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.LEMON.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.LIME.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.OLIVE.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.ORANGE.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.PEACH.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.PEAR.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.PLUM.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TechnologicaItems.WALNUT.get().asItem(), 0.65F);
		int after = ComposterBlock.COMPOSTABLES.size();
		LOGGER.info("FML COMMON SETUP - ADD TO COMPOSTER - " + (after - before));
	}

	private static void addToFlowerPot() {
		FlowerPotBlock flowerPotBlock = (FlowerPotBlock) Blocks.FLOWER_POT;
		int before = flowerPotBlock.getFullPotsView().size();
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.APRICOT_SAPLING.get()), TechnologicaBlocks.POTTED_APRICOT_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.ASPEN_SAPLING.get()), TechnologicaBlocks.POTTED_ASPEN_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.AVOCADO_SAPLING.get()), TechnologicaBlocks.POTTED_AVOCADO_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.BANANA_SAPLING.get()), TechnologicaBlocks.POTTED_BANANA_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.CHERRY_SAPLING.get()), TechnologicaBlocks.POTTED_CHERRY_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.CHESTNUT_SAPLING.get()), TechnologicaBlocks.POTTED_CHESTNUT_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.CINNAMON_SAPLING.get()), TechnologicaBlocks.POTTED_CINNAMON_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.COCONUT_SAPLING.get()), TechnologicaBlocks.POTTED_COCONUT_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.EBONY_SAPLING.get()), TechnologicaBlocks.POTTED_EBONY_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.KIWI_SAPLING.get()), TechnologicaBlocks.POTTED_KIWI_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.LEMON_SAPLING.get()), TechnologicaBlocks.POTTED_LEMON_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.LIME_SAPLING.get()), TechnologicaBlocks.POTTED_LIME_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.MAHOGANY_SAPLING.get()), TechnologicaBlocks.POTTED_MAHOGANY_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.MAPLE_SAPLING.get()), TechnologicaBlocks.POTTED_MAPLE_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.OLIVE_SAPLING.get()), TechnologicaBlocks.POTTED_OLIVE_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.ORANGE_SAPLING.get()), TechnologicaBlocks.POTTED_ORANGE_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.PEACH_SAPLING.get()), TechnologicaBlocks.POTTED_PEACH_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.PEAR_SAPLING.get()), TechnologicaBlocks.POTTED_PEAR_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.PLUM_SAPLING.get()), TechnologicaBlocks.POTTED_PLUM_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.REDWOOD_SAPLING.get()), TechnologicaBlocks.POTTED_REDWOOD_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.ROSEWOOD_SAPLING.get()), TechnologicaBlocks.POTTED_ROSEWOOD_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.RUBBER_SAPLING.get()), TechnologicaBlocks.POTTED_RUBBER_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.TEAK_SAPLING.get()), TechnologicaBlocks.POTTED_TEAK_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.WALNUT_SAPLING.get()), TechnologicaBlocks.POTTED_WALNUT_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.ZEBRAWOOD_SAPLING.get()), TechnologicaBlocks.POTTED_ZEBRAWOOD_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.ANCIENT_AMBROSIA_SAPLING.get()), TechnologicaBlocks.POTTED_ANCIENT_AMBROSIA_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.BENEVOLENT_APOTHECARY_SAPLING.get()), TechnologicaBlocks.POTTED_BENEVOLENT_APOTHECARY_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.CRYOGENIC_SPIRE_SAPLING.get()), TechnologicaBlocks.POTTED_CRYOGENIC_SPIRE_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.MALEVOLENT_APOTHECARY_SAPLING.get()), TechnologicaBlocks.POTTED_MALEVOLENT_APOTHECARY_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.NECROTIC_SAPLING.get()), TechnologicaBlocks.POTTED_NECROTIC_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_SAPLING.get()), TechnologicaBlocks.POTTED_SERENDIPITOUS_APOTHECARY_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_SAPLING.get()), TechnologicaBlocks.POTTED_THUNDEROUS_CONDUCTOR_SAPLING);
		flowerPotBlock.addPlant(ForgeRegistries.BLOCKS.getKey(TechnologicaBlocks.TOWERING_INFERNO_SAPLING.get()), TechnologicaBlocks.POTTED_TOWERING_INFERNO_SAPLING);
		int after = flowerPotBlock.getFullPotsView().size();
		LOGGER.info("FML COMMON SETUP - ADD TO FLOWER POT - " + (after - before));
	}

	/*
	 * ACCESS TRANSFORMER REQUIRED TO CHANGE WANTED ITEMS FROM PRIVATE FINAL TO PUBLIC
	 */
	private static void addToVillagerWantedItems() {
		int before = Villager.WANTED_ITEMS.size();
		Stream<Item> vanillaWantedItems = Villager.WANTED_ITEMS.stream();
		Stream<Item> technologicaWantedItems = Stream.of(TechnologicaItems.BARLEY.get(), TechnologicaItems.BARLEY_SEEDS.get(), TechnologicaItems.OATS.get(), TechnologicaItems.OATS_SEEDS.get(), TechnologicaItems.RYE.get(), TechnologicaItems.RYE_SEEDS.get(), TechnologicaItems.CORN.get(), TechnologicaItems.CORN_SEEDS.get(), TechnologicaItems.RICE.get(), TechnologicaItems.RICE_SEEDS.get(), TechnologicaItems.ASPARAGUS.get(), TechnologicaItems.CHILI_PEPPER.get(), TechnologicaItems.COFFEE_BEANS.get(), TechnologicaItems.GARLIC.get(), TechnologicaItems.GINGER.get(), TechnologicaItems.PEAS.get(), TechnologicaItems.PEANUT.get(), TechnologicaItems.RED_BEANS.get(), TechnologicaItems.SOY_BEANS.get(), TechnologicaItems.SWEET_POTATO.get(), TechnologicaItems.BROCCOLI.get(), TechnologicaItems.BROCCOLI_SEEDS.get(), TechnologicaItems.CELERY.get(), TechnologicaItems.CELERY_SEEDS.get(), TechnologicaItems.LETTUCE.get(), TechnologicaItems.LETTUCE_SEEDS.get(), TechnologicaItems.MUSTARD_GREENS.get(), TechnologicaItems.MUSTARD_SEEDS.get(), TechnologicaItems.PINEAPPLE.get(), TechnologicaItems.PINEAPPLE_SEEDS.get(), TechnologicaItems.PURPLE_CABBAGE.get(), TechnologicaItems.PURPLE_CABBAGE_SEEDS.get(), TechnologicaItems.ONION.get(), TechnologicaItems.ONION_SEEDS.get(), TechnologicaItems.RADISH.get(), TechnologicaItems.RADISH_SEEDS.get(), TechnologicaItems.TEA_LEAF.get(), TechnologicaItems.TEA_SEEDS.get(), TechnologicaItems.TURNIP.get(), TechnologicaItems.TURNIP_SEEDS.get());
		Villager.WANTED_ITEMS = ImmutableSet.copyOf(Stream.concat(vanillaWantedItems, technologicaWantedItems).collect(Collectors.toSet()));
		int after = Villager.WANTED_ITEMS.size();
		LOGGER.info("FML COMMON SETUP - ADD TO VILLAGER WANTED ITEMS - " + (after - before));
	}
}
