package com.technologica.listeners.lootmodifiers;

import java.util.List;

import javax.annotation.Nonnull;

import com.google.gson.JsonObject;
import com.technologica.world.item.TechnologicaItems;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

public class VillageSnowyHouseLootModifier extends LootModifier {
	private final Item addition;
	private final List<Item> vegetableSeeds = List.of(Items.BEETROOT_SEEDS, TechnologicaItems.BROCCOLI_SEEDS.get(), TechnologicaItems.CELERY_SEEDS.get(), TechnologicaItems.LETTUCE_SEEDS.get(), TechnologicaItems.MUSTARD_SEEDS.get(), TechnologicaItems.ONION_SEEDS.get(), TechnologicaItems.PEPPERCORN_SEEDS.get(), TechnologicaItems.PURPLE_CABBAGE_SEEDS.get(), TechnologicaItems.RADISH_SEEDS.get(), TechnologicaItems.TEA_SEEDS.get(), TechnologicaItems.TOMATO_SEEDS.get(), TechnologicaItems.TURNIP_SEEDS.get());
	private final List<Item> vegetables = List.of(Items.POTATO, TechnologicaItems.RADISH.get(), TechnologicaItems.TURNIP.get());

	protected VillageSnowyHouseLootModifier(LootItemCondition[] conditionsIn, Item addition) {
		super(conditionsIn);
		this.addition = addition;
	}

	@Nonnull
	@Override
	protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
		int count = 0;
		for (int i = 0; i < generatedLoot.size(); i++) {
			if (generatedLoot.get(i).getItem().equals(Items.BEETROOT_SEEDS)) {
				count = generatedLoot.get(i).getCount();
				generatedLoot.set(i, new ItemStack(vegetableSeeds.get(context.getRandom().nextInt(vegetableSeeds.size())), count));
			} else if (generatedLoot.get(i).getItem().equals(Items.POTATO)) {
				count = generatedLoot.get(i).getCount();
				generatedLoot.set(i, new ItemStack(vegetables.get(context.getRandom().nextInt(vegetables.size())), count));
			}
		}
		return generatedLoot;
	}

	public static class Serializer extends GlobalLootModifierSerializer<VillageSnowyHouseLootModifier> {
		@Override
		public VillageSnowyHouseLootModifier read(ResourceLocation name, JsonObject object, LootItemCondition[] conditionsIn) {
			Item addition = ForgeRegistries.ITEMS.getValue(new ResourceLocation(GsonHelper.getAsString(object, "addition")));
			return new VillageSnowyHouseLootModifier(conditionsIn, addition);
		}

		@Override
		public JsonObject write(VillageSnowyHouseLootModifier instance) {
			JsonObject json = makeConditions(instance.conditions);
			json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
			return json;
		}
	}
}