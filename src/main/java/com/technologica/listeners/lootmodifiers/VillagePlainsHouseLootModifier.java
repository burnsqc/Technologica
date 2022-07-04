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

public class VillagePlainsHouseLootModifier extends LootModifier {
	private final Item addition;
	private final List<Item> vegetables = List.of(Items.POTATO, TechnologicaItems.CORN.get(), TechnologicaItems.LETTUCE.get(), TechnologicaItems.MUSTARD_GREENS.get(), TechnologicaItems.PEAS.get(), TechnologicaItems.TOMATO.get());

	protected VillagePlainsHouseLootModifier(LootItemCondition[] conditionsIn, Item addition) {
		super(conditionsIn);
		this.addition = addition;
	}

	@Nonnull
	@Override
	protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
		int count = 0;
		for (int i = 0; i < generatedLoot.size(); i++) {
			if (generatedLoot.get(i).getItem().equals(Items.POTATO)) {
				count = generatedLoot.get(i).getCount();
				generatedLoot.set(i, new ItemStack(vegetables.get(context.getRandom().nextInt(vegetables.size())), count));
			}
		}
		return generatedLoot;
	}

	public static class Serializer extends GlobalLootModifierSerializer<VillagePlainsHouseLootModifier> {
		@Override
		public VillagePlainsHouseLootModifier read(ResourceLocation name, JsonObject object, LootItemCondition[] conditionsIn) {
			Item addition = ForgeRegistries.ITEMS.getValue(new ResourceLocation(GsonHelper.getAsString(object, "addition")));
			return new VillagePlainsHouseLootModifier(conditionsIn, addition);
		}

		@Override
		public JsonObject write(VillagePlainsHouseLootModifier instance) {
			JsonObject json = makeConditions(instance.conditions);
			json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
			return json;
		}
	}
}