package com.technologica.listeners.lootmodifiers;

import java.util.List;
import java.util.function.Supplier;

import javax.annotation.Nonnull;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.technologica.world.item.TechnologicaItems;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;

public class TechnologicaChestLootModifier extends LootModifier {
	private final List<Item> fruitSeeds = List.of(Items.MELON_SEEDS, TechnologicaItems.CRANBERRY_SEEDS.get(), TechnologicaItems.GRAPE_SEEDS.get(), TechnologicaItems.PINEAPPLE_SEEDS.get());
	private final List<Item> gourdSeeds = List.of(Items.PUMPKIN_SEEDS, TechnologicaItems.CUCUMBER_SEEDS.get(), TechnologicaItems.SQUASH_SEEDS.get(), TechnologicaItems.ZUCCHINI_SEEDS.get());
	private final List<Item> vegetableSeeds = List.of(Items.BEETROOT_SEEDS, TechnologicaItems.BROCCOLI_SEEDS.get(), TechnologicaItems.CELERY_SEEDS.get(), TechnologicaItems.LETTUCE_SEEDS.get(), TechnologicaItems.MUSTARD_SEEDS.get(), TechnologicaItems.ONION_SEEDS.get(), TechnologicaItems.PEPPERCORNS.get(), TechnologicaItems.PURPLE_CABBAGE_SEEDS.get(), TechnologicaItems.RADISH_SEEDS.get(), TechnologicaItems.TEA_SEEDS.get(), TechnologicaItems.TOMATO_SEEDS.get(), TechnologicaItems.TURNIP_SEEDS.get());
	private final List<Item> grains = List.of(Items.WHEAT, TechnologicaItems.BARLEY.get(), TechnologicaItems.CORN.get(), TechnologicaItems.OATS.get(), TechnologicaItems.RICE.get(), TechnologicaItems.RYE.get());
	private final List<Item> vegetables = List.of(Items.CARROT, Items.POTATO, TechnologicaItems.ASPARAGUS.get(), TechnologicaItems.BROCCOLI.get(), TechnologicaItems.CELERY.get(), TechnologicaItems.CHILI_PEPPER.get(), TechnologicaItems.COFFEE_BEANS.get(), TechnologicaItems.CUCUMBER.get(), TechnologicaItems.GARLIC.get(), TechnologicaItems.GINGER.get(), TechnologicaItems.LETTUCE.get(), TechnologicaItems.MUSTARD_GREENS.get(), TechnologicaItems.ONION.get(), TechnologicaItems.PEAS.get(), TechnologicaItems.PEANUT.get(), TechnologicaItems.PEPPERCORNS.get(), TechnologicaItems.PURPLE_CABBAGE.get(), TechnologicaItems.RADISH.get(), TechnologicaItems.RED_BEANS.get(), TechnologicaItems.SOY_BEANS.get(), TechnologicaItems.SQUASH.get(), TechnologicaItems.SWEET_POTATO.get(), TechnologicaItems.TEA_LEAF.get(), TechnologicaItems.TOMATO.get(), TechnologicaItems.TURNIP.get(), TechnologicaItems.ZUCCHINI.get());
	private final List<Item> gems = List.of(Items.EMERALD, TechnologicaItems.RUBY.get(), TechnologicaItems.SAPPHIRE.get(), TechnologicaItems.TOPAZ.get());
	private final List<Item> metals = List.of(Items.IRON_INGOT, TechnologicaItems.TITANIUM_INGOT.get(), TechnologicaItems.VANADIUM_INGOT.get(), TechnologicaItems.CHROMIUM_INGOT.get(), TechnologicaItems.MANGANESE_INGOT.get(), TechnologicaItems.COBALT_INGOT.get(), TechnologicaItems.ZIRCONIUM_INGOT.get(), TechnologicaItems.NIOBIUM_INGOT.get(), TechnologicaItems.MOLYBDENUM_INGOT.get(), TechnologicaItems.HAFNIUM_INGOT.get(), TechnologicaItems.TANTALUM_INGOT.get(), TechnologicaItems.TUNGSTEN_INGOT.get(), TechnologicaItems.RHENIUM_INGOT.get());
	private final List<Item> nobleMetals = List.of(Items.GOLD_INGOT, TechnologicaItems.RUTHENIUM_INGOT.get(), TechnologicaItems.RHODIUM_INGOT.get(), TechnologicaItems.PALLADIUM_INGOT.get(), TechnologicaItems.SILVER_INGOT.get(), TechnologicaItems.OSMIUM_INGOT.get(), TechnologicaItems.IRIDIUM_INGOT.get(), TechnologicaItems.PLATINUM_INGOT.get());

	public static final Supplier<Codec<TechnologicaChestLootModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.create(inst -> codecStart(inst).apply(inst, TechnologicaChestLootModifier::new)));

	public TechnologicaChestLootModifier(final LootItemCondition[] conditionsIn) {
		super(conditionsIn);
	}

	@Nonnull
	@Override
	protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
		int count = 0;
		for (int i = 0; i < generatedLoot.size(); i++) {
			if (generatedLoot.get(i).getItem().equals(Items.MELON_SEEDS)) {
				count = generatedLoot.get(i).getCount();
				generatedLoot.set(i, new ItemStack(fruitSeeds.get(context.getRandom().nextInt(fruitSeeds.size())), count));
			} else if (generatedLoot.get(i).getItem().equals(Items.PUMPKIN_SEEDS)) {
				count = generatedLoot.get(i).getCount();
				generatedLoot.set(i, new ItemStack(gourdSeeds.get(context.getRandom().nextInt(gourdSeeds.size())), count));
			} else if (generatedLoot.get(i).getItem().equals(Items.BEETROOT_SEEDS)) {
				count = generatedLoot.get(i).getCount();
				generatedLoot.set(i, new ItemStack(vegetableSeeds.get(context.getRandom().nextInt(vegetableSeeds.size())), count));
			} else if (generatedLoot.get(i).getItem().equals(Items.WHEAT)) {
				count = generatedLoot.get(i).getCount();
				generatedLoot.set(i, new ItemStack(grains.get(context.getRandom().nextInt(grains.size())), count));
			} else if (generatedLoot.get(i).getItem().equals(Items.CARROT) || generatedLoot.get(i).getItem().equals(Items.POTATO)) {
				count = generatedLoot.get(i).getCount();
				generatedLoot.set(i, new ItemStack(vegetables.get(context.getRandom().nextInt(vegetables.size())), count));
			} else if (generatedLoot.get(i).getItem().equals(Items.EMERALD)) {
				count = generatedLoot.get(i).getCount();
				generatedLoot.set(i, new ItemStack(gems.get(context.getRandom().nextInt(gems.size())), count));
			} else if (generatedLoot.get(i).getItem().equals(Items.IRON_INGOT)) {
				count = generatedLoot.get(i).getCount();
				generatedLoot.set(i, new ItemStack(metals.get(context.getRandom().nextInt(metals.size())), count));
			} else if (generatedLoot.get(i).getItem().equals(Items.GOLD_INGOT)) {
				count = generatedLoot.get(i).getCount();
				generatedLoot.set(i, new ItemStack(nobleMetals.get(context.getRandom().nextInt(nobleMetals.size())), count));
			}
		}
		return generatedLoot;
	}

	@Override
	public Codec<? extends IGlobalLootModifier> codec() {
		return CODEC.get();
	}
}