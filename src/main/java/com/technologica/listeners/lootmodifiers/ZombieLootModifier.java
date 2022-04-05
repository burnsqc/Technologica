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

public class ZombieLootModifier extends LootModifier {
	private final Item addition;
	private final List<Item> root_vegetables = List.of(Items.CARROT, TechnologicaItems.GARLIC.get(), TechnologicaItems.ONION.get(), TechnologicaItems.RADISH.get(), TechnologicaItems.TURNIP.get());
	private final List<Item> tubers = List.of(Items.POTATO, TechnologicaItems.SWEET_POTATO.get());

	protected ZombieLootModifier(LootItemCondition[] conditionsIn, Item addition) {
		super(conditionsIn);
		this.addition = addition;
	}

	@Nonnull
	@Override
	protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
		if (generatedLoot.removeIf((itemStack) -> itemStack.getItem().equals(Items.CARROT))) {
			generatedLoot.add(new ItemStack(root_vegetables.get(context.getRandom().nextInt(root_vegetables.size()))));
		} else if (generatedLoot.removeIf((itemStack) -> itemStack.getItem().equals(Items.POTATO))) { 
			generatedLoot.add(new ItemStack(tubers.get(context.getRandom().nextInt(tubers.size()))));
		}
		return generatedLoot;
	}

	public static class Serializer extends GlobalLootModifierSerializer<ZombieLootModifier> {
		@Override
		public ZombieLootModifier read(ResourceLocation name, JsonObject object, LootItemCondition[] conditionsIn) {
			Item addition = ForgeRegistries.ITEMS.getValue(new ResourceLocation(GsonHelper.getAsString(object, "addition")));
			return new ZombieLootModifier(conditionsIn, addition);
		}

		@Override
		public JsonObject write(ZombieLootModifier instance) {
			JsonObject json = makeConditions(instance.conditions);
			json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
			return json;
		}
	}
}