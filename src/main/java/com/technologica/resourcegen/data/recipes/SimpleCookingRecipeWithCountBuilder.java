package com.technologica.resourcegen.data.recipes;

import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

public final class SimpleCookingRecipeWithCountBuilder implements RecipeBuilder {
	private final RecipeCategory recipeCategory;
	private final CookingBookCategory cookingBookCategory;
	private final Item result;
	private final int count;
	private final Ingredient ingredient;
	private final float experience;
	private final int cookingTime;
	private final Advancement.Builder advancement = Advancement.Builder.recipeAdvancement();
	@Nullable
	private String group;
	private final RecipeSerializer<? extends AbstractCookingRecipe> serializer;

	private SimpleCookingRecipeWithCountBuilder(RecipeCategory recipeCategory, CookingBookCategory cookingBookCategory, ItemLike itemLike, int count, Ingredient ingedient, float experience, int cookingTime, RecipeSerializer<? extends AbstractCookingRecipe> serializer) {
		this.recipeCategory = recipeCategory;
		this.cookingBookCategory = cookingBookCategory;
		this.result = itemLike.asItem();
		this.count = count;
		this.ingredient = ingedient;
		this.experience = experience;
		this.cookingTime = cookingTime;
		this.serializer = serializer;
	}

	public static SimpleCookingRecipeWithCountBuilder generic(Ingredient ingedient, RecipeCategory recipeCategory, ItemLike p_249766_, int count, float p_251320_, int p_248693_, RecipeSerializer<? extends AbstractCookingRecipe> serializer) {
		return new SimpleCookingRecipeWithCountBuilder(recipeCategory, determineRecipeCategory(serializer, p_249766_), p_249766_, count, ingedient, p_251320_, p_248693_, serializer);
	}

	@Override
	public SimpleCookingRecipeWithCountBuilder unlockedBy(String p_126255_, CriterionTriggerInstance criterionTriggerInstance) {
		this.advancement.addCriterion(p_126255_, criterionTriggerInstance);
		return this;
	}

	@Override
	public SimpleCookingRecipeWithCountBuilder group(@Nullable String group) {
		this.group = group;
		return this;
	}

	@Override
	public Item getResult() {
		return this.result;
	}

	@Override
	public void save(Consumer<FinishedRecipe> consumer, ResourceLocation id) {
		this.ensureValid(id);
		this.advancement.parent(ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id)).rewards(AdvancementRewards.Builder.recipe(id)).requirements(RequirementsStrategy.OR);
		consumer.accept(new SimpleCookingRecipeWithCountBuilder.Result(id, this.group == null ? "" : this.group, this.cookingBookCategory, this.ingredient, this.result, this.count, this.experience, this.cookingTime, this.advancement, id.withPrefix("recipes/" + this.recipeCategory.getFolderName() + "/"), this.serializer));
	}

	private static CookingBookCategory determineSmeltingRecipeCategory(ItemLike p_251938_) {
		if (p_251938_.asItem().isEdible()) {
			return CookingBookCategory.FOOD;
		} else {
			return p_251938_.asItem() instanceof BlockItem ? CookingBookCategory.BLOCKS : CookingBookCategory.MISC;
		}
	}

	private static CookingBookCategory determineBlastingRecipeCategory(ItemLike p_249047_) {
		return p_249047_.asItem() instanceof BlockItem ? CookingBookCategory.BLOCKS : CookingBookCategory.MISC;
	}

	private static CookingBookCategory determineRecipeCategory(RecipeSerializer<? extends AbstractCookingRecipe> serializer, ItemLike p_249582_) {
		if (serializer == RecipeSerializer.SMELTING_RECIPE) {
			return determineSmeltingRecipeCategory(p_249582_);
		} else if (serializer == RecipeSerializer.BLASTING_RECIPE) {
			return determineBlastingRecipeCategory(p_249582_);
		} else if (serializer != RecipeSerializer.SMOKING_RECIPE && serializer != RecipeSerializer.CAMPFIRE_COOKING_RECIPE) {
			throw new IllegalStateException("Unknown cooking recipe type");
		} else {
			return CookingBookCategory.FOOD;
		}
	}

	private void ensureValid(ResourceLocation id) {
		if (this.advancement.getCriteria().isEmpty()) {
			throw new IllegalStateException("No way of obtaining recipe " + id);
		}
	}

	static class Result implements FinishedRecipe {
		private final ResourceLocation id;
		private final String group;
		private final CookingBookCategory category;
		private final Ingredient ingredient;
		private final Item result;
		private final int count;
		private final float experience;
		private final int cookingTime;
		private final Advancement.Builder advancement;
		private final ResourceLocation advancementId;
		private final RecipeSerializer<? extends AbstractCookingRecipe> serializer;

		public Result(ResourceLocation id, String group, CookingBookCategory category, Ingredient ingredient, Item result, int count, float experience, int cookingTime, Advancement.Builder advancement, ResourceLocation advancementId, RecipeSerializer<? extends AbstractCookingRecipe> serializer) {
			this.id = id;
			this.group = group;
			this.category = category;
			this.ingredient = ingredient;
			this.result = result;
			this.count = count;
			this.experience = experience;
			this.cookingTime = cookingTime;
			this.advancement = advancement;
			this.advancementId = advancementId;
			this.serializer = serializer;
		}

		@SuppressWarnings("deprecation")
		@Override
		public void serializeRecipeData(JsonObject jsonObject) {
			if (!this.group.isEmpty()) {
				jsonObject.addProperty("group", this.group);
			}
			jsonObject.addProperty("category", this.category.getSerializedName());
			jsonObject.add("ingredient", this.ingredient.toJson());
			JsonObject resultJsonObject = new JsonObject();
			resultJsonObject.addProperty("item", BuiltInRegistries.ITEM.getKey(this.result).toString());
			if (this.count > 1) {
				resultJsonObject.addProperty("count", this.count);
			}
			jsonObject.add("result", resultJsonObject);
			jsonObject.addProperty("experience", this.experience);
			jsonObject.addProperty("cookingtime", this.cookingTime);
		}

		@Override
		public RecipeSerializer<?> getType() {
			return this.serializer;
		}

		@Override
		public ResourceLocation getId() {
			return this.id;
		}

		@Override
		@Nullable
		public JsonObject serializeAdvancement() {
			return this.advancement.serializeToJson();
		}

		@Override
		@Nullable
		public ResourceLocation getAdvancementId() {
			return this.advancementId;
		}
	}
}
