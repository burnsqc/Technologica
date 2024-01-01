package com.technologica.listeners.lootmodifiers.blocks;

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

public class FernLootModifier extends LootModifier {
	private final List<Item> grainSeeds = List.of(Items.WHEAT_SEEDS, TechnologicaItems.BARLEY_SEEDS.get(), TechnologicaItems.OATS_SEEDS.get(), TechnologicaItems.RYE_SEEDS.get());

	public static final Supplier<Codec<FernLootModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.create(inst -> codecStart(inst).apply(inst, FernLootModifier::new)));

	public FernLootModifier(LootItemCondition[] conditionsIn) {
		super(conditionsIn);
	}

	@Nonnull
	@Override
	protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
		if (generatedLoot.removeIf((itemStack) -> itemStack.getItem().equals(Items.WHEAT_SEEDS))) {
			generatedLoot.add(new ItemStack(grainSeeds.get(context.getRandom().nextInt(grainSeeds.size()))));
		}
		return generatedLoot;
	}

	@Override
	public Codec<? extends IGlobalLootModifier> codec() {
		return CODEC.get();
	}
}