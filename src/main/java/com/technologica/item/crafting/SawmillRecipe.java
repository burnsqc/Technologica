package com.technologica.item.crafting;

import com.google.gson.JsonObject;
import com.technologica.item.TechnologicaItems;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.SingleItemRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class SawmillRecipe extends SingleItemRecipe {

	public SawmillRecipe(ResourceLocation id, String group, Ingredient ingredient, ItemStack result) {
		super(TechnologicaRecipeType.SAWMILL, TechnologicaRecipeSerializer.SAWMILL.get(), id, group, ingredient, result);
	}

	@Override
	public boolean matches(IInventory inv, World worldIn) {
		return this.ingredient.test(inv.getItem(0));
	}

	public ItemStack getToastSymbol() {
		return new ItemStack(TechnologicaItems.SAWBLADE.get());
	}

	public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<SawmillRecipe> {

		@Override
		public SawmillRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
			String s = JSONUtils.getAsString(json, "group", "");
			Ingredient ingredient;
			if (JSONUtils.isArrayNode(json, "ingredient")) {
				ingredient = Ingredient.fromJson(JSONUtils.getAsJsonArray(json, "ingredient"));
			} else {
				ingredient = Ingredient.fromJson(JSONUtils.getAsJsonObject(json, "ingredient"));
			}

			String s1 = JSONUtils.getAsString(json, "result");
			int i = JSONUtils.getAsInt(json, "count");

			ItemStack itemstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(s1)), i);
			return new SawmillRecipe(recipeId, s, ingredient, itemstack);
		}

		@Override
		public SawmillRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
			String s = buffer.readUtf(32767);
			Ingredient ingredient = Ingredient.fromNetwork(buffer);
			ItemStack itemstack = buffer.readItem();
			return new SawmillRecipe(recipeId, s, ingredient, itemstack);
		}

		@Override
		public void toNetwork(PacketBuffer buffer, SawmillRecipe recipe) {
			buffer.writeUtf(recipe.group);
			recipe.ingredient.toNetwork(buffer);
			buffer.writeItem(recipe.result);
		}
	}
}
