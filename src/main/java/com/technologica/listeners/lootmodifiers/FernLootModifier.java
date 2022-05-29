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

public class FernLootModifier extends LootModifier {
	private final Item addition;
	private final List<Item> grainSeeds = List.of(Items.WHEAT_SEEDS, TechnologicaItems.BARLEY_SEEDS.get(), TechnologicaItems.OATS_SEEDS.get(), TechnologicaItems.RYE_SEEDS.get());

	protected FernLootModifier(LootItemCondition[] conditionsIn, Item addition) {
		super(conditionsIn);
		this.addition = addition;
	}

	@Nonnull
	@Override
	protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
		if (generatedLoot.removeIf((itemStack) -> itemStack.getItem().equals(Items.WHEAT_SEEDS))) {
			generatedLoot.add(new ItemStack(grainSeeds.get(context.getRandom().nextInt(grainSeeds.size()))));
		}
		return generatedLoot;
	}

	public static class Serializer extends GlobalLootModifierSerializer<FernLootModifier> {
		@Override
		public FernLootModifier read(ResourceLocation name, JsonObject object, LootItemCondition[] conditionsIn) {
			Item addition = ForgeRegistries.ITEMS.getValue(new ResourceLocation(GsonHelper.getAsString(object, "addition")));
			return new FernLootModifier(conditionsIn, addition);
		}

		@Override
		public JsonObject write(FernLootModifier instance) {
			JsonObject json = makeConditions(instance.conditions);
			json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
			return json;
		}
	}
}