package com.technologica.world.level.block.state.properties;

import java.util.Map;

import com.google.common.collect.Maps;
import com.technologica.registration.deferred.TechnologicaItems;

import net.minecraft.world.item.Item;

public class TechnologicaCompostables {
	public static final Map<Item, Float> COMPOSTABLES = Maps.newHashMap();

	static {
		register(TechnologicaItems.CUCUMBER_SEEDS.get(), 0.3F);
		register(TechnologicaItems.GRAPE_SEEDS.get(), 0.3F);
		register(TechnologicaItems.SQUASH_SEEDS.get(), 0.3F);
		register(TechnologicaItems.TOMATO_SEEDS.get(), 0.3F);
		register(TechnologicaItems.ZUCCHINI_SEEDS.get(), 0.3F);
		register(TechnologicaItems.CRANBERRY_SEEDS.get(), 0.3F);
		register(TechnologicaItems.BARLEY_SEEDS.get(), 0.3F);
		register(TechnologicaItems.CORN_SEEDS.get(), 0.3F);
		register(TechnologicaItems.OATS_SEEDS.get(), 0.3F);
		register(TechnologicaItems.RYE_SEEDS.get(), 0.3F);
		register(TechnologicaItems.RICE_SEEDS.get(), 0.3F);
		register(TechnologicaItems.BROCCOLI_SEEDS.get(), 0.3F);
		register(TechnologicaItems.CELERY_SEEDS.get(), 0.3F);
		register(TechnologicaItems.COFFEE_BEANS.get(), 0.3F);
		register(TechnologicaItems.LETTUCE_SEEDS.get(), 0.3F);
		register(TechnologicaItems.MUSTARD_SEEDS.get(), 0.3F);
		register(TechnologicaItems.ONION_SEEDS.get(), 0.3F);
		register(TechnologicaItems.PEAS.get(), 0.3F);
		register(TechnologicaItems.PINEAPPLE_SEEDS.get(), 0.3F);
		register(TechnologicaItems.PURPLE_CABBAGE_SEEDS.get(), 0.3F);
		register(TechnologicaItems.RADISH_SEEDS.get(), 0.3F);
		register(TechnologicaItems.RED_BEANS.get(), 0.3F);
		register(TechnologicaItems.SOY_BEANS.get(), 0.3F);
		register(TechnologicaItems.TEA_SEEDS.get(), 0.3F);
		register(TechnologicaItems.TURNIP_SEEDS.get(), 0.3F);
		register(TechnologicaItems.PEPPERCORNS.get(), 0.3F);
		register(TechnologicaItems.BARLEY.get(), 0.65F);
		register(TechnologicaItems.OATS.get(), 0.65F);
		register(TechnologicaItems.RYE.get(), 0.65F);
		register(TechnologicaItems.CORN.get(), 0.65F);
		register(TechnologicaItems.RICE.get(), 0.65F);
		register(TechnologicaItems.ASPARAGUS.get(), 0.65F);
		register(TechnologicaItems.CHILI_PEPPER.get(), 0.65F);
		register(TechnologicaItems.GARLIC.get(), 0.65F);
		register(TechnologicaItems.GINGER.get(), 0.65F);
		register(TechnologicaItems.SWEET_POTATO.get(), 0.65F);
		register(TechnologicaItems.PEANUT.get(), 0.65F);
		register(TechnologicaItems.BROCCOLI.get(), 0.65F);
		register(TechnologicaItems.CELERY.get(), 0.65F);
		register(TechnologicaItems.LETTUCE.get(), 0.65F);
		register(TechnologicaItems.MUSTARD_GREENS.get(), 0.65F);
		register(TechnologicaItems.PINEAPPLE.get(), 0.65F);
		register(TechnologicaItems.PURPLE_CABBAGE.get(), 0.65F);
		register(TechnologicaItems.ONION.get(), 0.65F);
		register(TechnologicaItems.RADISH.get(), 0.65F);
		register(TechnologicaItems.TEA_LEAF.get(), 0.65F);
		register(TechnologicaItems.TURNIP.get(), 0.65F);
		register(TechnologicaItems.CRANBERRY.get(), 0.65F);
		register(TechnologicaItems.BLACKBERRY.get(), 0.65F);
		register(TechnologicaItems.BLUEBERRY.get(), 0.65F);
		register(TechnologicaItems.RASPBERRY.get(), 0.65F);
		register(TechnologicaItems.STRAWBERRY.get(), 0.65F);
		register(TechnologicaItems.GRAPE.get(), 0.65F);
		register(TechnologicaItems.TOMATO.get(), 0.65F);
		register(TechnologicaItems.CUCUMBER.get(), 0.65F);
		register(TechnologicaItems.SQUASH.get(), 0.65F);
		register(TechnologicaItems.ZUCCHINI.get(), 0.65F);
		register(TechnologicaItems.APRICOT.get(), 0.65F);
		register(TechnologicaItems.AVOCADO.get(), 0.65F);
		register(TechnologicaItems.BANANA.get(), 0.65F);
		register(TechnologicaItems.CHERRY.get(), 0.65F);
		register(TechnologicaItems.CHESTNUT.get(), 0.65F);
		register(TechnologicaItems.CINNAMON.get(), 0.65F);
		register(TechnologicaItems.COCONUT.get(), 0.65F);
		register(TechnologicaItems.KIWI.get(), 0.65F);
		register(TechnologicaItems.LEMON.get(), 0.65F);
		register(TechnologicaItems.LIME.get(), 0.65F);
		register(TechnologicaItems.OLIVE.get(), 0.65F);
		register(TechnologicaItems.ORANGE.get(), 0.65F);
		register(TechnologicaItems.PEACH.get(), 0.65F);
		register(TechnologicaItems.PEAR.get(), 0.65F);
		register(TechnologicaItems.PLUM.get(), 0.65F);
		register(TechnologicaItems.WALNUT.get(), 0.65F);
	}

	private static void register(Item item, Float value) {
		COMPOSTABLES.put(item, value);
	}
}
