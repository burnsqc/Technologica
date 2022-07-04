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

public class PillagerOutpostLootModifier extends LootModifier {
	private final Item addition;
	private final List<Item> grain = List.of(Items.WHEAT, TechnologicaItems.BARLEY.get(), TechnologicaItems.CORN.get(), TechnologicaItems.OATS.get(), TechnologicaItems.RICE.get(), TechnologicaItems.RYE.get());
	private final List<Item> vegetables = List.of(Items.POTATO, TechnologicaItems.ASPARAGUS.get(), TechnologicaItems.BROCCOLI.get(), TechnologicaItems.CELERY.get(), TechnologicaItems.CHILI_PEPPER.get(), TechnologicaItems.COFFEE_BEANS.get(), TechnologicaItems.CUCUMBER.get(), TechnologicaItems.GARLIC.get(), TechnologicaItems.GINGER.get(), TechnologicaItems.LETTUCE.get(), TechnologicaItems.MUSTARD_GREENS.get(), TechnologicaItems.ONION.get(), TechnologicaItems.PEAS.get(), TechnologicaItems.PEANUT.get(), TechnologicaItems.PEPPERCORNS.get(), TechnologicaItems.PURPLE_CABBAGE.get(), TechnologicaItems.RADISH.get(), TechnologicaItems.RED_BEANS.get(), TechnologicaItems.SOY_BEANS.get(), TechnologicaItems.SQUASH.get(), TechnologicaItems.SWEET_POTATO.get(), TechnologicaItems.TEA_LEAF.get(), TechnologicaItems.TOMATO.get(), TechnologicaItems.TURNIP.get(), TechnologicaItems.ZUCCHINI.get());

	protected PillagerOutpostLootModifier(LootItemCondition[] conditionsIn, Item addition) {
		super(conditionsIn);
		this.addition = addition;
	}

	@Nonnull
	@Override
	protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
		int count = 0;
		for (int i = 0; i < generatedLoot.size(); i++) {
			if (generatedLoot.get(i).getItem().equals(Items.WHEAT)) {
				count = generatedLoot.get(i).getCount();
				generatedLoot.set(i, new ItemStack(grain.get(context.getRandom().nextInt(grain.size())), count));
			} else if (generatedLoot.get(i).getItem().equals(Items.CARROT) || generatedLoot.get(i).getItem().equals(Items.POTATO)) {
				count = generatedLoot.get(i).getCount();
				generatedLoot.set(i, new ItemStack(vegetables.get(context.getRandom().nextInt(vegetables.size())), count));
			}
		}
		return generatedLoot;
	}

	public static class Serializer extends GlobalLootModifierSerializer<PillagerOutpostLootModifier> {
		@Override
		public PillagerOutpostLootModifier read(ResourceLocation name, JsonObject object, LootItemCondition[] conditionsIn) {
			Item addition = ForgeRegistries.ITEMS.getValue(new ResourceLocation(GsonHelper.getAsString(object, "addition")));
			return new PillagerOutpostLootModifier(conditionsIn, addition);
		}

		@Override
		public JsonObject write(PillagerOutpostLootModifier instance) {
			JsonObject json = makeConditions(instance.conditions);
			json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
			return json;
		}
	}
}