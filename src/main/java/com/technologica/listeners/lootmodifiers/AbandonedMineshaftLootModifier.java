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
	private final List<Item> gourdSeeds = List.of(Items.PUMPKIN_SEEDS, TechnologicaItems.SQUASH_SEEDS.get(), TechnologicaItems.ZUCCHINI_SEEDS.get());

	protected AbandonedMineshaftLootModifier(LootItemCondition[] conditionsIn, Item addition) {
		super(conditionsIn);
		this.addition = addition;
	}

	@Nonnull
	@Override
	protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
		if (generatedLoot.removeIf((itemStack) -> itemStack.getItem().equals(Items.PUMPKIN_SEEDS))) {
			generatedLoot.add(new ItemStack(gourdSeeds.get(context.getRandom().nextInt(gourdSeeds.size()))));
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