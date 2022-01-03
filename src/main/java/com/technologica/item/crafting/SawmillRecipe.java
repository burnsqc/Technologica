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
		return this.ingredient.test(inv.getStackInSlot(0));
	}

	public ItemStack getIcon() {
		return new ItemStack(TechnologicaItems.SAWBLADE.get());
	}

	public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<SawmillRecipe> {

		@Override
		public SawmillRecipe read(ResourceLocation recipeId, JsonObject json) {
			String s = JSONUtils.getString(json, "group", "");
			Ingredient ingredient;
			if (JSONUtils.isJsonArray(json, "ingredient")) {
				ingredient = Ingredient.deserialize(JSONUtils.getJsonArray(json, "ingredient"));
			} else {
				ingredient = Ingredient.deserialize(JSONUtils.getJsonObject(json, "ingredient"));
			}

			String s1 = JSONUtils.getString(json, "result");
			int i = JSONUtils.getInt(json, "count");

			ItemStack itemstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(s1)), i);
			return new SawmillRecipe(recipeId, s, ingredient, itemstack);
		}

		@Override
		public SawmillRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
			String s = buffer.readString(32767);
			Ingredient ingredient = Ingredient.read(buffer);
			ItemStack itemstack = buffer.readItemStack();
			return new SawmillRecipe(recipeId, s, ingredient, itemstack);
		}

		@Override
		public void write(PacketBuffer buffer, SawmillRecipe recipe) {
			buffer.writeString(recipe.group);
			recipe.ingredient.write(buffer);
			buffer.writeItemStack(recipe.result);
		}
	}
}
