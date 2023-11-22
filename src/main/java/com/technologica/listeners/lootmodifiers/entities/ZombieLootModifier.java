package com.technologica.listeners.lootmodifiers.entities;

import java.util.List;
import java.util.function.Supplier;

import javax.annotation.Nonnull;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.technologica.registration.deferred.TechnologicaItems;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;

public class ZombieLootModifier extends LootModifier {
	private final List<Item> root_vegetables = List.of(Items.CARROT, TechnologicaItems.GARLIC.get(), TechnologicaItems.ONION.get(), TechnologicaItems.RADISH.get(), TechnologicaItems.TURNIP.get());
	private final List<Item> tubers = List.of(Items.POTATO, TechnologicaItems.SWEET_POTATO.get());

	public static final Supplier<Codec<ZombieLootModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.create(inst -> codecStart(inst).apply(inst, ZombieLootModifier::new)));

	public ZombieLootModifier(LootItemCondition[] conditionsIn) {
		super(conditionsIn);
	}

	@Nonnull
	@Override
	protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
		if (generatedLoot.removeIf((itemStack) -> itemStack.getItem().equals(Items.CARROT))) {
			generatedLoot.add(new ItemStack(root_vegetables.get(context.getRandom().nextInt(root_vegetables.size()))));
		} else if (generatedLoot.removeIf((itemStack) -> itemStack.getItem().equals(Items.POTATO))) {
			generatedLoot.add(new ItemStack(tubers.get(context.getRandom().nextInt(tubers.size()))));
		}
		return generatedLoot;
	}

	@Override
	public Codec<? extends IGlobalLootModifier> codec() {
		return CODEC.get();
	}
}