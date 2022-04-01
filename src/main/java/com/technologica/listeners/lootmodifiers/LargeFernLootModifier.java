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

public class LargeFernLootModifier extends LootModifier {
	private final Item addition;
	private final List<Item> additions = List.of(Items.WHEAT_SEEDS, TechnologicaItems.PEPPERCORN_SEEDS.get());

	protected LargeFernLootModifier(LootItemCondition[] conditionsIn, Item addition) {
		super(conditionsIn);
		this.addition = addition;
	}

	@Nonnull
	@Override
	protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
		if (!generatedLoot.isEmpty()) {
			if (generatedLoot.get(0).getItem().equals(Items.WHEAT_SEEDS)) {
				int index = context.getRandom().nextInt(additions.size());
				generatedLoot.remove(0);
				generatedLoot.add(new ItemStack(additions.get(index)));
			}
		}
		return generatedLoot;
	}

	public static class Serializer extends GlobalLootModifierSerializer<LargeFernLootModifier> {
		@Override
		public LargeFernLootModifier read(ResourceLocation name, JsonObject object, LootItemCondition[] conditionsIn) {
			Item addition = ForgeRegistries.ITEMS.getValue(new ResourceLocation(GsonHelper.getAsString(object, "addition")));
			return new LargeFernLootModifier(conditionsIn, addition);
		}

		@Override
		public JsonObject write(LargeFernLootModifier instance) {
			JsonObject json = makeConditions(instance.conditions);
			json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
			return json;
		}
	}
}