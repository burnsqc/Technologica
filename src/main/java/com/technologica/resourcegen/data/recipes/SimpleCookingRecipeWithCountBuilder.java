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

public class SimpleCookingRecipeWithCountBuilder implements RecipeBuilder {
	private final RecipeCategory category;
	private final CookingBookCategory bookCategory;
	private final Item result;
	private final int count;
	private final Ingredient ingredient;
	private final float experience;
	private final int cookingTime;
	private final Advancement.Builder advancement = Advancement.Builder.recipeAdvancement();
	@Nullable
	private String group;
	private final RecipeSerializer<? extends AbstractCookingRecipe> serializer;

	private SimpleCookingRecipeWithCountBuilder(RecipeCategory p_251345_, CookingBookCategory p_251607_, ItemLike p_252112_, int count, Ingredient p_250362_, float p_251204_, int p_250189_, RecipeSerializer<? extends AbstractCookingRecipe> p_249915_) {
		this.category = p_251345_;
		this.bookCategory = p_251607_;
		this.result = p_252112_.asItem();
		this.count = count;
		this.ingredient = p_250362_;
		this.experience = p_251204_;
		this.cookingTime = p_250189_;
		this.serializer = p_249915_;
	}

	public static SimpleCookingRecipeWithCountBuilder generic(Ingredient p_250999_, RecipeCategory p_248815_, ItemLike p_249766_, int count, float p_251320_, int p_248693_, RecipeSerializer<? extends AbstractCookingRecipe> p_250921_) {
		return new SimpleCookingRecipeWithCountBuilder(p_248815_, determineRecipeCategory(p_250921_, p_249766_), p_249766_, count, p_250999_, p_251320_, p_248693_, p_250921_);
	}

	@Override
	public SimpleCookingRecipeWithCountBuilder unlockedBy(String p_126255_, CriterionTriggerInstance p_126256_) {
		this.advancement.addCriterion(p_126255_, p_126256_);
		return this;
	}

	@Override
	public SimpleCookingRecipeWithCountBuilder group(@Nullable String p_176795_) {
		this.group = p_176795_;
		return this;
	}

	@Override
	public Item getResult() {
		return this.result;
	}

	@Override
	public void save(Consumer<FinishedRecipe> p_126263_, ResourceLocation p_126264_) {
		this.ensureValid(p_126264_);
		this.advancement.parent(ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(p_126264_)).rewards(AdvancementRewards.Builder.recipe(p_126264_)).requirements(RequirementsStrategy.OR);
		p_126263_.accept(new SimpleCookingRecipeWithCountBuilder.Result(p_126264_, this.group == null ? "" : this.group, this.bookCategory, this.ingredient, this.result, this.count, this.experience, this.cookingTime, this.advancement, p_126264_.withPrefix("recipes/" + this.category.getFolderName() + "/"), this.serializer));
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

	private static CookingBookCategory determineRecipeCategory(RecipeSerializer<? extends AbstractCookingRecipe> p_251261_, ItemLike p_249582_) {
		if (p_251261_ == RecipeSerializer.SMELTING_RECIPE) {
			return determineSmeltingRecipeCategory(p_249582_);
		} else if (p_251261_ == RecipeSerializer.BLASTING_RECIPE) {
			return determineBlastingRecipeCategory(p_249582_);
		} else if (p_251261_ != RecipeSerializer.SMOKING_RECIPE && p_251261_ != RecipeSerializer.CAMPFIRE_COOKING_RECIPE) {
			throw new IllegalStateException("Unknown cooking recipe type");
		} else {
			return CookingBookCategory.FOOD;
		}
	}

	private void ensureValid(ResourceLocation p_126266_) {
		if (this.advancement.getCriteria().isEmpty()) {
			throw new IllegalStateException("No way of obtaining recipe " + p_126266_);
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

		public Result(ResourceLocation p_252275_, String p_248665_, CookingBookCategory p_251944_, Ingredient p_249473_, Item p_252028_, int count, float p_249206_, int p_251002_, Advancement.Builder p_249151_, ResourceLocation p_252090_, RecipeSerializer<? extends AbstractCookingRecipe> p_249537_) {
			this.id = p_252275_;
			this.group = p_248665_;
			this.category = p_251944_;
			this.ingredient = p_249473_;
			this.result = p_252028_;
			this.count = count;
			this.experience = p_249206_;
			this.cookingTime = p_251002_;
			this.advancement = p_249151_;
			this.advancementId = p_252090_;
			this.serializer = p_249537_;
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
