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

public class AbandonedMineshaftLootModifier extends LootModifier {
	private final Item addition;
	private final List<Item> gourdSeeds = List.of(Items.PUMPKIN_SEEDS, TechnologicaItems.CUCUMBER_SEEDS.get(), TechnologicaItems.SQUASH_SEEDS.get(), TechnologicaItems.ZUCCHINI_SEEDS.get());
	private final List<Item> vegetableSeeds = List.of(Items.BEETROOT_SEEDS, TechnologicaItems.BROCCOLI_SEEDS.get(), TechnologicaItems.CELERY_SEEDS.get(), TechnologicaItems.LETTUCE_SEEDS.get(), TechnologicaItems.MUSTARD_SEEDS.get(), TechnologicaItems.ONION_SEEDS.get(), TechnologicaItems.PEPPERCORN_SEEDS.get(), TechnologicaItems.PURPLE_CABBAGE_SEEDS.get(), TechnologicaItems.RADISH_SEEDS.get(), TechnologicaItems.TEA_SEEDS.get(), TechnologicaItems.TOMATO_SEEDS.get(), TechnologicaItems.TURNIP_SEEDS.get());
	private final List<Item> fruitSeeds = List.of(Items.MELON_SEEDS, TechnologicaItems.CRANBERRY_SEEDS.get(), TechnologicaItems.GRAPE_SEEDS.get(), TechnologicaItems.PINEAPPLE_SEEDS.get());

	protected AbandonedMineshaftLootModifier(LootItemCondition[] conditionsIn, Item addition) {
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

	public static class Serializer extends GlobalLootModifierSerializer<AbandonedMineshaftLootModifier> {
		@Override
		public AbandonedMineshaftLootModifier read(ResourceLocation name, JsonObject object, LootItemCondition[] conditionsIn) {
			Item addition = ForgeRegistries.ITEMS.getValue(new ResourceLocation(GsonHelper.getAsString(object, "addition")));
			return new AbandonedMineshaftLootModifier(conditionsIn, addition);
		}

		@Override
		public JsonObject write(AbandonedMineshaftLootModifier instance) {
			JsonObject json = makeConditions(instance.conditions);
			json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
			return json;
		}
	}
}