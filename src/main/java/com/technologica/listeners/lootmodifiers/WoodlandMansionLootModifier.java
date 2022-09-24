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

public class WoodlandMansionLootModifier extends LootModifier {
	private final List<Item> grain = List.of(Items.WHEAT, TechnologicaItems.BARLEY.get(), TechnologicaItems.CORN.get(), TechnologicaItems.OATS.get(), TechnologicaItems.RICE.get(), TechnologicaItems.RYE.get());
	private final List<Item> vegetableSeeds = List.of(Items.BEETROOT_SEEDS, TechnologicaItems.BROCCOLI_SEEDS.get(), TechnologicaItems.CELERY_SEEDS.get(), TechnologicaItems.LETTUCE_SEEDS.get(), TechnologicaItems.MUSTARD_SEEDS.get(), TechnologicaItems.ONION_SEEDS.get(), TechnologicaItems.PEPPERCORNS.get(), TechnologicaItems.PURPLE_CABBAGE_SEEDS.get(), TechnologicaItems.RADISH_SEEDS.get(), TechnologicaItems.TEA_SEEDS.get(), TechnologicaItems.TOMATO_SEEDS.get(), TechnologicaItems.TURNIP_SEEDS.get());
	private final List<Item> fruitSeeds = List.of(Items.MELON_SEEDS, TechnologicaItems.CRANBERRY_SEEDS.get(), TechnologicaItems.GRAPE_SEEDS.get(), TechnologicaItems.PINEAPPLE_SEEDS.get());
	private final List<Item> gourdSeeds = List.of(Items.PUMPKIN_SEEDS, TechnologicaItems.CUCUMBER_SEEDS.get(), TechnologicaItems.SQUASH_SEEDS.get(), TechnologicaItems.ZUCCHINI_SEEDS.get());

	public static final Supplier<Codec<WoodlandMansionLootModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.create(inst -> codecStart(inst).apply(inst, WoodlandMansionLootModifier::new)));

	protected WoodlandMansionLootModifier(LootItemCondition[] conditionsIn) {
		super(conditionsIn);
	}

	@Nonnull
	@Override
	protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
		int count = 0;
		for (int i = 0; i < generatedLoot.size(); i++) {
			if (generatedLoot.get(i).getItem().equals(Items.WHEAT)) {
				count = generatedLoot.get(i).getCount();
				generatedLoot.set(i, new ItemStack(grain.get(context.getRandom().nextInt(grain.size())), count));
			} else if (generatedLoot.get(i).getItem().equals(Items.BEETROOT_SEEDS)) {
				count = generatedLoot.get(i).getCount();
				generatedLoot.set(i, new ItemStack(vegetableSeeds.get(context.getRandom().nextInt(vegetableSeeds.size())), count));
			} else if (generatedLoot.get(i).getItem().equals(Items.MELON_SEEDS)) {
				count = generatedLoot.get(i).getCount();
				generatedLoot.set(i, new ItemStack(fruitSeeds.get(context.getRandom().nextInt(fruitSeeds.size())), count));
			} else if (generatedLoot.get(i).getItem().equals(Items.PUMPKIN_SEEDS)) {
				count = generatedLoot.get(i).getCount();
				generatedLoot.set(i, new ItemStack(gourdSeeds.get(context.getRandom().nextInt(gourdSeeds.size())), count));
			}
		}
		return generatedLoot;
	}

	@Override
	public Codec<? extends IGlobalLootModifier> codec() {
		return CODEC.get();
	}
}