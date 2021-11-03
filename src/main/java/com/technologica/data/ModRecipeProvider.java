package com.technologica.data;

import java.util.function.Consumer;

import com.technologica.Technologica;
import com.technologica.item.TechnologicaItems;
import com.technologica.util.ConditionFactory;

import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.ConditionalRecipe;

public class ModRecipeProvider extends RecipeProvider {

	public ModRecipeProvider(DataGenerator generatorIn) {
		super(generatorIn);
	}
	
	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.BANANAS_FOSTER.get(), 1).addIngredient(TechnologicaItems.BANANA.get()).addIngredient(Items.ICE).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_banana", hasItem(TechnologicaItems.BANANA.get())).build(consumer, "bananas_foster_from_banana");
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.BLACK_FOREST_CAKE.get(), 1).addIngredient(TechnologicaItems.CHERRY.get()).addIngredient(Items.EGG).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addIngredient(Items.COCOA_BEANS).addCriterion("has_cherry", hasItem(TechnologicaItems.CHERRY.get())).build(consumer, "black_forest_cake_from_cherry");
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.BLUEBERRY_CHEESECAKE.get(), 1).addIngredient(TechnologicaItems.BLUEBERRY.get()).addIngredient(Items.COOKIE).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_blueberry", hasItem(TechnologicaItems.BLUEBERRY.get())).build(consumer, "blueberry_cheesecake_from_blueberry");
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.COCONUT_CREAM_PIE.get(), 1).addIngredient(TechnologicaItems.COCONUT.get()).addIngredient(Items.EGG).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_coconut", hasItem(TechnologicaItems.COCONUT.get())).build(consumer, "coconut_cream_pie_from_coconut");
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.GRAPE_SHAVED_ICE.get(), 1).addIngredient(TechnologicaItems.GRAPE.get()).addIngredient(Items.SNOWBALL).addCriterion("has_grape", hasItem(TechnologicaItems.GRAPE.get())).build(consumer, "grape_shaved_ice_from_grape");
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.KEY_LIME_MOUSSE.get(), 1).addIngredient(TechnologicaItems.LIME.get()).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_lime", hasItem(TechnologicaItems.LIME.get())).build(consumer, "key_lime_mousse_from_lime");
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.KIWI_SORBET.get(), 1).addIngredient(TechnologicaItems.KIWI.get()).addIngredient(Items.SNOWBALL).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_kiwi", hasItem(TechnologicaItems.KIWI.get())).build(consumer, "kiwi_sorbet_from_kiwi");
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.LEMON_BAR.get(), 1).addIngredient(TechnologicaItems.LEMON.get()).addIngredient(Items.EGG).addIngredient(Items.SUGAR).addCriterion("has_lemon", hasItem(TechnologicaItems.LEMON.get())).build(consumer, "lemon_bar_from_lemon");
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.ORANGE_DREAMSICLE.get(), 1).addIngredient(TechnologicaItems.ORANGE.get()).addIngredient(Items.ICE).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_orange", hasItem(TechnologicaItems.ORANGE.get())).build(consumer, "orange_dreamsicle_from_orange");
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.PEACH_COBBLER.get(), 1).addIngredient(TechnologicaItems.PEACH.get()).addIngredient(Items.WHEAT).addIngredient(Items.SUGAR).addCriterion("has_peach", hasItem(TechnologicaItems.PEACH.get())).build(consumer, "peach_cobbler_from_peach");
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.PEAR_TART.get(), 1).addIngredient(TechnologicaItems.PEAR.get()).addIngredient(Items.WHEAT).addIngredient(Items.SUGAR).addCriterion("has_pear", hasItem(TechnologicaItems.PEAR.get())).build(consumer, "pear_tart_from_pear");
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.STRAWBERRY_SHORTCAKE.get(), 1).addIngredient(TechnologicaItems.STRAWBERRY.get()).addIngredient(Items.EGG).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addIngredient(Items.WHEAT).addCriterion("has_strawberry", hasItem(TechnologicaItems.STRAWBERRY.get())).build(consumer, "strawberry_shortcake_from_strawberry");
		
		ConditionalRecipe.builder()
        	.addCondition(new ConditionFactory())
        	.addRecipe((consumer2) -> ShapelessRecipeBuilder.shapelessRecipe(Blocks.OAK_PLANKS, 1).addIngredient(ItemTags.OAK_LOGS).addIngredient(TechnologicaItems.SAW.get()).setGroup("planks").addCriterion("has_log", hasItem(ItemTags.OAK_LOGS)).build(consumer2))
        	.build(consumer, new ResourceLocation(Technologica.MODID, "oak_planks"));
		ConditionalRecipe.builder()
	    	.addCondition(new ConditionFactory())
	    	.addRecipe((consumer2) -> ShapelessRecipeBuilder.shapelessRecipe(Blocks.OAK_SLAB, 2).addIngredient(Blocks.OAK_PLANKS).addIngredient(TechnologicaItems.SAW.get()).setGroup("wooden_slab").addCriterion("has_planks", hasItem(Blocks.OAK_PLANKS)).build(consumer2))
	    	.build(consumer, new ResourceLocation(Technologica.MODID, "oak_slab"));
	}		
}