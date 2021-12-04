package com.technologica.data;

import java.util.function.Consumer;

import com.technologica.Technologica;
import com.technologica.block.TechnologicaBlocks;
import com.technologica.item.TechnologicaItems;
import com.technologica.tags.TechnologicaItemTags;
import com.technologica.util.DisablePlankConditionFactory;
import com.technologica.util.EnablePlankConditionFactory;

import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.ConditionalRecipe;

public class ModRecipeProvider extends RecipeProvider {

	public ModRecipeProvider(DataGenerator generatorIn) {
		super(generatorIn);
	}
	
	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		vanillaPlanks(consumer, Blocks.OAK_PLANKS, ItemTags.OAK_LOGS);
		vanillaPlanks(consumer, Blocks.SPRUCE_PLANKS, ItemTags.SPRUCE_LOGS);
		vanillaPlanks(consumer, Blocks.BIRCH_PLANKS, ItemTags.BIRCH_LOGS);
		vanillaPlanks(consumer, Blocks.JUNGLE_PLANKS, ItemTags.JUNGLE_LOGS);
		vanillaPlanks(consumer, Blocks.ACACIA_PLANKS, ItemTags.ACACIA_LOGS);
		vanillaPlanks(consumer, Blocks.DARK_OAK_PLANKS, ItemTags.DARK_OAK_LOGS);
		vanillaPlanks(consumer, Blocks.CRIMSON_PLANKS, ItemTags.CRIMSON_STEMS);
		vanillaPlanks(consumer, Blocks.WARPED_PLANKS, ItemTags.WARPED_STEMS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.APRICOT_PLANKS.get(), TechnologicaItemTags.APRICOT_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.ASPEN_PLANKS.get(), TechnologicaItemTags.ASPEN_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.AVOCADO_PLANKS.get(), TechnologicaItemTags.AVOCADO_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.BANANA_PLANKS.get(), TechnologicaItemTags.BANANA_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.CHERRY_PLANKS.get(), TechnologicaItemTags.CHERRY_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.CHESTNUT_PLANKS.get(), TechnologicaItemTags.CHESTNUT_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.CINNAMON_PLANKS.get(), TechnologicaItemTags.CINNAMON_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.COCONUT_PLANKS.get(), TechnologicaItemTags.COCONUT_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.EBONY_PLANKS.get(), TechnologicaItemTags.EBONY_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.KIWI_PLANKS.get(), TechnologicaItemTags.KIWI_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.LEMON_PLANKS.get(), TechnologicaItemTags.LEMON_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.LIME_PLANKS.get(), TechnologicaItemTags.LIME_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.MAHOGANY_PLANKS.get(), TechnologicaItemTags.MAHOGANY_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.MAPLE_PLANKS.get(), TechnologicaItemTags.MAPLE_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.OLIVE_PLANKS.get(), TechnologicaItemTags.OLIVE_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.ORANGE_PLANKS.get(), TechnologicaItemTags.ORANGE_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.PEACH_PLANKS.get(), TechnologicaItemTags.PEACH_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.PEAR_PLANKS.get(), TechnologicaItemTags.PEAR_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.PLUM_PLANKS.get(), TechnologicaItemTags.PLUM_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.REDWOOD_PLANKS.get(), TechnologicaItemTags.REDWOOD_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.ROSEWOOD_PLANKS.get(), TechnologicaItemTags.ROSEWOOD_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.RUBBER_PLANKS.get(), TechnologicaItemTags.RUBBER_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.TEAK_PLANKS.get(), TechnologicaItemTags.TEAK_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.WALNUT_PLANKS.get(), TechnologicaItemTags.WALNUT_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.ZEBRAWOOD_PLANKS.get(), TechnologicaItemTags.ZEBRAWOOD_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.ALCHEMICAL_PLANKS.get(), TechnologicaItemTags.ALCHEMICAL_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.BENEVOLENT_PLANKS.get(), TechnologicaItemTags.BENEVOLENT_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.CONDUCTIVE_PLANKS.get(), TechnologicaItemTags.CONDUCTIVE_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.FROSTBITTEN_PLANKS.get(), TechnologicaItemTags.FROSTBITTEN_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.FRUITFUL_PLANKS.get(), TechnologicaItemTags.FRUITFUL_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.INFERNAL_PLANKS.get(), TechnologicaItemTags.INFERNAL_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.MALEVOLENT_PLANKS.get(), TechnologicaItemTags.MALEVOLENT_LOGS);
		
		proPlanks(consumer, Blocks.OAK_PLANKS, ItemTags.OAK_LOGS);
		proPlanks(consumer, Blocks.SPRUCE_PLANKS, ItemTags.SPRUCE_LOGS);
		proPlanks(consumer, Blocks.BIRCH_PLANKS, ItemTags.BIRCH_LOGS);
		proPlanks(consumer, Blocks.JUNGLE_PLANKS, ItemTags.JUNGLE_LOGS);
		proPlanks(consumer, Blocks.ACACIA_PLANKS, ItemTags.ACACIA_LOGS);
		proPlanks(consumer, Blocks.DARK_OAK_PLANKS, ItemTags.DARK_OAK_LOGS);
		proPlanks(consumer, Blocks.CRIMSON_PLANKS, ItemTags.CRIMSON_STEMS);
		proPlanks(consumer, Blocks.WARPED_PLANKS, ItemTags.WARPED_STEMS);
		proPlanks(consumer, TechnologicaBlocks.APRICOT_PLANKS.get(), TechnologicaItemTags.APRICOT_LOGS);
		
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.BANANAS_FOSTER.get(), 1).addIngredient(TechnologicaItems.BANANA.get()).addIngredient(Items.ICE).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_banana", hasItem(TechnologicaItems.BANANA.get())).build(consumer, new ResourceLocation(Technologica.MODID, "bananas_foster"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.BLACK_FOREST_CAKE.get(), 1).addIngredient(TechnologicaItems.CHERRY.get()).addIngredient(Items.EGG).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addIngredient(Items.COCOA_BEANS).addCriterion("has_cherry", hasItem(TechnologicaItems.CHERRY.get())).build(consumer, new ResourceLocation(Technologica.MODID, "black_forest_cake"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.BLUEBERRY_CHEESECAKE.get(), 1).addIngredient(TechnologicaItems.BLUEBERRY.get()).addIngredient(Items.COOKIE).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_blueberry", hasItem(TechnologicaItems.BLUEBERRY.get())).build(consumer, new ResourceLocation(Technologica.MODID, "blueberry_cheesecake"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.COCONUT_CREAM_PIE.get(), 1).addIngredient(TechnologicaItems.COCONUT.get()).addIngredient(Items.EGG).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_coconut", hasItem(TechnologicaItems.COCONUT.get())).build(consumer, new ResourceLocation(Technologica.MODID, "coconut_cream_pie"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.GRAPE_SHAVED_ICE.get(), 1).addIngredient(TechnologicaItems.GRAPE.get()).addIngredient(Items.SNOWBALL).addCriterion("has_grape", hasItem(TechnologicaItems.GRAPE.get())).build(consumer, new ResourceLocation(Technologica.MODID, "grape_shaved_ice"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.KEY_LIME_MOUSSE.get(), 1).addIngredient(TechnologicaItems.LIME.get()).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_lime", hasItem(TechnologicaItems.LIME.get())).build(consumer, new ResourceLocation(Technologica.MODID, "key_lime_mousse"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.KIWI_SORBET.get(), 1).addIngredient(TechnologicaItems.KIWI.get()).addIngredient(Items.SNOWBALL).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_kiwi", hasItem(TechnologicaItems.KIWI.get())).build(consumer, new ResourceLocation(Technologica.MODID, "kiwi_sorbet"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.LEMON_BAR.get(), 1).addIngredient(TechnologicaItems.LEMON.get()).addIngredient(Items.EGG).addIngredient(Items.SUGAR).addCriterion("has_lemon", hasItem(TechnologicaItems.LEMON.get())).build(consumer, new ResourceLocation(Technologica.MODID, "lemon_bar"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.ORANGE_DREAMSICLE.get(), 1).addIngredient(TechnologicaItems.ORANGE.get()).addIngredient(Items.ICE).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_orange", hasItem(TechnologicaItems.ORANGE.get())).build(consumer, new ResourceLocation(Technologica.MODID, "orange_dreamsicle"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.PEACH_COBBLER.get(), 1).addIngredient(TechnologicaItems.PEACH.get()).addIngredient(Items.WHEAT).addIngredient(Items.SUGAR).addCriterion("has_peach", hasItem(TechnologicaItems.PEACH.get())).build(consumer, new ResourceLocation(Technologica.MODID, "peach_cobbler"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.PEAR_TART.get(), 1).addIngredient(TechnologicaItems.PEAR.get()).addIngredient(Items.WHEAT).addIngredient(Items.SUGAR).addCriterion("has_pear", hasItem(TechnologicaItems.PEAR.get())).build(consumer, new ResourceLocation(Technologica.MODID, "pear_tart"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.STRAWBERRY_SHORTCAKE.get(), 1).addIngredient(TechnologicaItems.STRAWBERRY.get()).addIngredient(Items.EGG).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addIngredient(Items.WHEAT).addCriterion("has_strawberry", hasItem(TechnologicaItems.STRAWBERRY.get())).build(consumer, new ResourceLocation(Technologica.MODID, "strawberry_shortcake"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.TAPENADE.get(), 1).addIngredient(TechnologicaItems.OLIVE.get()).addIngredient(TechnologicaItems.GARLIC.get()).addCriterion("has_olive", hasItem(TechnologicaItems.OLIVE.get())).build(consumer, new ResourceLocation(Technologica.MODID, "tapenade"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.CINNAMON_ROLL.get(), 1).addIngredient(TechnologicaItems.CINNAMON.get()).addIngredient(Items.EGG).addIngredient(Items.SUGAR).addIngredient(Items.MILK_BUCKET).addCriterion("has_cinnamon", hasItem(TechnologicaItems.CINNAMON.get())).build(consumer, new ResourceLocation(Technologica.MODID, "cinnamon_roll"));
		
//		sawmillRecipe(Ingredient.fromTag(TechnologicaItemTags.APRICOT_LOGS), TechnologicaItems.APRICOT_PLANKS_ITEM.get(), 1).build(consumer, new ResourceLocation(Technologica.MODID, "apricot_planks_from_apricot_logs_sawmill"));
//		sawmillRecipe(Ingredient.fromTag(TechnologicaItemTags.ASPEN_LOGS), TechnologicaItems.ASPEN_PLANKS_ITEM.get(), 1).build(consumer, new ResourceLocation(Technologica.MODID, "aspen_planks_from_aspen_logs_sawmill"));
	}	
	
	private static void vanillaPlanks(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider output, ITag<Item> input) {
		ConditionalRecipe.builder().addCondition(new EnablePlankConditionFactory()).addRecipe((consumer2) -> ShapelessRecipeBuilder.shapelessRecipe(output, 4).addIngredient(input).setGroup("planks").addCriterion("has_log", hasItem(input)).build(consumer2)).build(recipeConsumer, new ResourceLocation(output.asItem().getRegistryName().getPath()));
	}
	
	private static void vanillaLikePlanks(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider output, ITag<Item> input) {
		ConditionalRecipe.builder().addCondition(new EnablePlankConditionFactory()).addRecipe((consumer2) -> ShapelessRecipeBuilder.shapelessRecipe(output, 4).addIngredient(input).setGroup("planks").addCriterion("has_log", hasItem(input)).build(consumer2)).build(recipeConsumer, new ResourceLocation(Technologica.MODID, output.asItem().getRegistryName().getPath()));
	}
	
	private static void proPlanks(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider output, ITag<Item> input) {
		ConditionalRecipe.builder().addCondition(new DisablePlankConditionFactory()).addRecipe((consumer2) -> ShapelessRecipeBuilder.shapelessRecipe(output, 1).addIngredient(input).addIngredient(TechnologicaItems.SAW.get()).setGroup("planks").addCriterion("has_saw", hasItem(TechnologicaItems.SAW.get())).build(consumer2)).build(recipeConsumer, new ResourceLocation(Technologica.MODID, output.asItem().getRegistryName().getPath() + "_pro"));
	}
	
//	public static SingleItemRecipeBuilder sawmillRecipe(Ingredient ingredientIn, IItemProvider resultIn, int countIn) {
//		return new SingleItemRecipeBuilder(TechnologicaRecipeSerializer.SAWMILL.get(), ingredientIn, resultIn, countIn).addCriterion("has_logs", hasItem(TechnologicaItemTags.APRICOT_LOGS));
//	}
}
