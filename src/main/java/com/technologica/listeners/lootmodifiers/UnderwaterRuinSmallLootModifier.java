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

public class UnderwaterRuinSmallLootModifier extends LootModifier {
	private final List<Item> grain = List.of(Items.WHEAT, TechnologicaItems.BARLEY.get(), TechnologicaItems.CORN.get(), TechnologicaItems.OATS.get(), TechnologicaItems.RICE.get(), TechnologicaItems.RYE.get());

	public static final Supplier<Codec<UnderwaterRuinSmallLootModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.create(inst -> codecStart(inst).apply(inst, UnderwaterRuinSmallLootModifier::new)));

	protected UnderwaterRuinSmallLootModifier(LootItemCondition[] conditionsIn) {
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
			}
		}
		return generatedLoot;
	}

	@Override
	public Codec<? extends IGlobalLootModifier> codec() {
		return CODEC.get();
	}
}