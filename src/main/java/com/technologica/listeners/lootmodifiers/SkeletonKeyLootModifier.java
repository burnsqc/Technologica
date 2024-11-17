package com.technologica.listeners.lootmodifiers;

import java.util.function.Supplier;

import javax.annotation.Nonnull;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.technologica.registration.deferred.TechnologicaItems;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;

public class SkeletonKeyLootModifier extends LootModifier {
	public static final Supplier<Codec<SkeletonKeyLootModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.create(inst -> codecStart(inst).apply(inst, SkeletonKeyLootModifier::new)));

	public SkeletonKeyLootModifier(final LootItemCondition[] conditionsIn) {
		super(conditionsIn);
	}

	@Nonnull
	@Override
	protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
		if (context.getRandom().nextInt(10) == 0) {
			generatedLoot.add(new ItemStack(TechnologicaItems.SKELETON_KEY.get(), 1));
		}
		return generatedLoot;
	}

	@Override
	public Codec<? extends IGlobalLootModifier> codec() {
		return CODEC.get();
	}
}