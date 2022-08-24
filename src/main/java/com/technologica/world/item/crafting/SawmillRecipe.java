package com.technologica.world.item.crafting;

import com.google.gson.JsonObject;
import com.technologica.world.item.TechnologicaItems;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

public class SawmillRecipe extends SingleItemRecipe {

	public SawmillRecipe(ResourceLocation id, String group, Ingredient ingredient, ItemStack result) {
		super(TechnologicaRecipeType.SAWMILL.get(), TechnologicaRecipeSerializer.SAWMILL.get(), id, group, ingredient, result);
	}

	@Override
	public boolean matches(Container inv, Level worldIn) {
		return this.ingredient.test(inv.getItem(1));
	}

	@Override
	public ItemStack getToastSymbol() {
		return new ItemStack(TechnologicaItems.SAWBLADE.get());
	}

	@Override
	public RecipeType<?> getType() {
		return TechnologicaRecipeType.SAWMILL.get();
	}

	public static class Serializer implements RecipeSerializer<SawmillRecipe> {

		@Override
		public SawmillRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
			String s = GsonHelper.getAsString(json, "group", "");
			Ingredient ingredient;
			if (GsonHelper.isArrayNode(json, "ingredient")) {
				ingredient = Ingredient.fromJson(GsonHelper.getAsJsonArray(json, "ingredient"));
			} else {
				ingredient = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "ingredient"));
			}

			String s1 = GsonHelper.getAsString(json, "result");
			int i = GsonHelper.getAsInt(json, "count");

			ItemStack itemstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(s1)), i);
			return new SawmillRecipe(recipeId, s, ingredient, itemstack);
		}

		@Override
		public SawmillRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
			String s = buffer.readUtf(32767);
			Ingredient ingredient = Ingredient.fromNetwork(buffer);
			ItemStack itemstack = buffer.readItem();
			return new SawmillRecipe(recipeId, s, ingredient, itemstack);
		}

		@Override
		public void toNetwork(FriendlyByteBuf buffer, SawmillRecipe recipe) {
			buffer.writeUtf(recipe.group);
			recipe.ingredient.toNetwork(buffer);
			buffer.writeItem(recipe.result);
		}
	}
}