package com.technologica.resourcegen.data.recipes;

import java.util.function.Consumer;

import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.registration.deferred.TechnologicaItems;
import com.technologica.registration.deferred.TechnologicaRecipeSerializers;
import com.technologica.registration.key.TechnologicaItemTags;
import com.technologica.util.DisablePlankConditionFactory;
import com.technologica.util.EnablePlankConditionFactory;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.registries.ForgeRegistries;

public class RecipeDataGenerator extends RecipeProvider {

	public RecipeDataGenerator(PackOutput generatorIn) {
		super(generatorIn);
	}

	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
		casualOrProPlanksVanilla(consumer, Blocks.OAK_PLANKS, ItemTags.OAK_LOGS);
		casualOrProPlanksVanilla(consumer, Blocks.SPRUCE_PLANKS, ItemTags.SPRUCE_LOGS);
		casualOrProPlanksVanilla(consumer, Blocks.BIRCH_PLANKS, ItemTags.BIRCH_LOGS);
		casualOrProPlanksVanilla(consumer, Blocks.JUNGLE_PLANKS, ItemTags.JUNGLE_LOGS);
		casualOrProPlanksVanilla(consumer, Blocks.ACACIA_PLANKS, ItemTags.ACACIA_LOGS);
		casualOrProPlanksVanilla(consumer, Blocks.DARK_OAK_PLANKS, ItemTags.DARK_OAK_LOGS);
		casualOrProPlanksVanilla(consumer, Blocks.CRIMSON_PLANKS, ItemTags.CRIMSON_STEMS);
		casualOrProPlanksVanilla(consumer, Blocks.WARPED_PLANKS, ItemTags.WARPED_STEMS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.APRICOT_PLANKS.get(), TechnologicaItemTags.APRICOT_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.ASPEN_PLANKS.get(), TechnologicaItemTags.ASPEN_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.AVOCADO_PLANKS.get(), TechnologicaItemTags.AVOCADO_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.BANANA_PLANKS.get(), TechnologicaItemTags.BANANA_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.CHERRY_PLANKS.get(), TechnologicaItemTags.CHERRY_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.CHESTNUT_PLANKS.get(), TechnologicaItemTags.CHESTNUT_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.CINNAMON_PLANKS.get(), TechnologicaItemTags.CINNAMON_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.COCONUT_PLANKS.get(), TechnologicaItemTags.COCONUT_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.EBONY_PLANKS.get(), TechnologicaItemTags.EBONY_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.KIWI_PLANKS.get(), TechnologicaItemTags.KIWI_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.LEMON_PLANKS.get(), TechnologicaItemTags.LEMON_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.LIME_PLANKS.get(), TechnologicaItemTags.LIME_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.MAHOGANY_PLANKS.get(), TechnologicaItemTags.MAHOGANY_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.MAPLE_PLANKS.get(), TechnologicaItemTags.MAPLE_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.OLIVE_PLANKS.get(), TechnologicaItemTags.OLIVE_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.ORANGE_PLANKS.get(), TechnologicaItemTags.ORANGE_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.PEACH_PLANKS.get(), TechnologicaItemTags.PEACH_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.PEAR_PLANKS.get(), TechnologicaItemTags.PEAR_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.PLUM_PLANKS.get(), TechnologicaItemTags.PLUM_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.REDWOOD_PLANKS.get(), TechnologicaItemTags.REDWOOD_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.ROSEWOOD_PLANKS.get(), TechnologicaItemTags.ROSEWOOD_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.RUBBER_PLANKS.get(), TechnologicaItemTags.RUBBER_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.TEAK_PLANKS.get(), TechnologicaItemTags.TEAK_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.WALNUT_PLANKS.get(), TechnologicaItemTags.WALNUT_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.ZEBRAWOOD_PLANKS.get(), TechnologicaItemTags.ZEBRAWOOD_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.ALCHEMICAL_PLANKS.get(), TechnologicaItemTags.ALCHEMICAL_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.BENEVOLENT_PLANKS.get(), TechnologicaItemTags.BENEVOLENT_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.CONDUCTIVE_PLANKS.get(), TechnologicaItemTags.CONDUCTIVE_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.FROSTBITTEN_PLANKS.get(), TechnologicaItemTags.FROSTBITTEN_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.FRUITFUL_PLANKS.get(), TechnologicaItemTags.FRUITFUL_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.INFERNAL_PLANKS.get(), TechnologicaItemTags.INFERNAL_LOGS);
		casualOrProPlanksTechnologica(consumer, TechnologicaBlocks.MALEVOLENT_PLANKS.get(), TechnologicaItemTags.MALEVOLENT_LOGS);
		
		casualOrProSlabsVanilla(consumer, Blocks.OAK_SLAB, Blocks.OAK_PLANKS);
		casualOrProSlabsVanilla(consumer, Blocks.SPRUCE_SLAB, Blocks.SPRUCE_PLANKS);
		casualOrProSlabsVanilla(consumer, Blocks.BIRCH_SLAB, Blocks.BIRCH_PLANKS);
		casualOrProSlabsVanilla(consumer, Blocks.JUNGLE_SLAB, Blocks.JUNGLE_PLANKS);
		casualOrProSlabsVanilla(consumer, Blocks.ACACIA_SLAB, Blocks.ACACIA_PLANKS);
		casualOrProSlabsVanilla(consumer, Blocks.DARK_OAK_SLAB, Blocks.DARK_OAK_PLANKS);
		casualOrProSlabsVanilla(consumer, Blocks.CRIMSON_SLAB, Blocks.CRIMSON_PLANKS);
		casualOrProSlabsVanilla(consumer, Blocks.WARPED_SLAB, Blocks.WARPED_PLANKS);
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.APRICOT_SLAB.get(), TechnologicaBlocks.APRICOT_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.ASPEN_SLAB.get(), TechnologicaBlocks.ASPEN_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.AVOCADO_SLAB.get(), TechnologicaBlocks.AVOCADO_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.BANANA_SLAB.get(), TechnologicaBlocks.BANANA_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.CHERRY_SLAB.get(), TechnologicaBlocks.CHERRY_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.CHESTNUT_SLAB.get(), TechnologicaBlocks.CHESTNUT_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.CINNAMON_SLAB.get(), TechnologicaBlocks.CINNAMON_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.COCONUT_SLAB.get(), TechnologicaBlocks.COCONUT_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.EBONY_SLAB.get(), TechnologicaBlocks.EBONY_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.KIWI_SLAB.get(), TechnologicaBlocks.KIWI_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.LEMON_SLAB.get(), TechnologicaBlocks.LEMON_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.LIME_SLAB.get(), TechnologicaBlocks.LIME_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.MAHOGANY_SLAB.get(), TechnologicaBlocks.MAHOGANY_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.MAPLE_SLAB.get(), TechnologicaBlocks.MAPLE_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.OLIVE_SLAB.get(), TechnologicaBlocks.OLIVE_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.ORANGE_SLAB.get(), TechnologicaBlocks.ORANGE_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.PEACH_SLAB.get(), TechnologicaBlocks.PEACH_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.PEAR_SLAB.get(), TechnologicaBlocks.PEAR_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.PLUM_SLAB.get(), TechnologicaBlocks.PLUM_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.REDWOOD_SLAB.get(), TechnologicaBlocks.REDWOOD_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.ROSEWOOD_SLAB.get(), TechnologicaBlocks.ROSEWOOD_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.RUBBER_SLAB.get(), TechnologicaBlocks.RUBBER_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.TEAK_SLAB.get(), TechnologicaBlocks.TEAK_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.WALNUT_SLAB.get(), TechnologicaBlocks.WALNUT_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.ZEBRAWOOD_SLAB.get(), TechnologicaBlocks.ZEBRAWOOD_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.ALCHEMICAL_SLAB.get(), TechnologicaBlocks.ALCHEMICAL_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.BENEVOLENT_SLAB.get(), TechnologicaBlocks.BENEVOLENT_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.CONDUCTIVE_SLAB.get(), TechnologicaBlocks.CONDUCTIVE_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.FROSTBITTEN_SLAB.get(), TechnologicaBlocks.FROSTBITTEN_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.FRUITFUL_SLAB.get(), TechnologicaBlocks.FRUITFUL_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.INFERNAL_SLAB.get(), TechnologicaBlocks.INFERNAL_PLANKS.get());
		casualOrProSlabsTechnologica(consumer, TechnologicaBlocks.MALEVOLENT_SLAB.get(), TechnologicaBlocks.MALEVOLENT_PLANKS.get());

		casualOrProStairsVanilla(consumer, Blocks.OAK_STAIRS, Blocks.OAK_PLANKS);
		casualOrProStairsVanilla(consumer, Blocks.SPRUCE_STAIRS, Blocks.SPRUCE_PLANKS);
		casualOrProStairsVanilla(consumer, Blocks.BIRCH_STAIRS, Blocks.BIRCH_PLANKS);
		casualOrProStairsVanilla(consumer, Blocks.JUNGLE_STAIRS, Blocks.JUNGLE_PLANKS);
		casualOrProStairsVanilla(consumer, Blocks.ACACIA_STAIRS, Blocks.ACACIA_PLANKS);
		casualOrProStairsVanilla(consumer, Blocks.DARK_OAK_STAIRS, Blocks.DARK_OAK_PLANKS);
		casualOrProStairsVanilla(consumer, Blocks.CRIMSON_STAIRS, Blocks.CRIMSON_PLANKS);
		casualOrProStairsVanilla(consumer, Blocks.WARPED_STAIRS, Blocks.WARPED_PLANKS);
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.APRICOT_STAIRS.get(), TechnologicaBlocks.APRICOT_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.ASPEN_STAIRS.get(), TechnologicaBlocks.ASPEN_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.AVOCADO_STAIRS.get(), TechnologicaBlocks.AVOCADO_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.BANANA_STAIRS.get(), TechnologicaBlocks.BANANA_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.CHERRY_STAIRS.get(), TechnologicaBlocks.CHERRY_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.CHESTNUT_STAIRS.get(), TechnologicaBlocks.CHESTNUT_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.CINNAMON_STAIRS.get(), TechnologicaBlocks.CINNAMON_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.COCONUT_STAIRS.get(), TechnologicaBlocks.COCONUT_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.EBONY_STAIRS.get(), TechnologicaBlocks.EBONY_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.KIWI_STAIRS.get(), TechnologicaBlocks.KIWI_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.LEMON_STAIRS.get(), TechnologicaBlocks.LEMON_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.LIME_STAIRS.get(), TechnologicaBlocks.LIME_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.MAHOGANY_STAIRS.get(), TechnologicaBlocks.MAHOGANY_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.MAPLE_STAIRS.get(), TechnologicaBlocks.MAPLE_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.OLIVE_STAIRS.get(), TechnologicaBlocks.OLIVE_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.ORANGE_STAIRS.get(), TechnologicaBlocks.ORANGE_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.PEACH_STAIRS.get(), TechnologicaBlocks.PEACH_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.PEAR_STAIRS.get(), TechnologicaBlocks.PEAR_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.PLUM_STAIRS.get(), TechnologicaBlocks.PLUM_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.REDWOOD_STAIRS.get(), TechnologicaBlocks.REDWOOD_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.ROSEWOOD_STAIRS.get(), TechnologicaBlocks.ROSEWOOD_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.RUBBER_STAIRS.get(), TechnologicaBlocks.RUBBER_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.TEAK_STAIRS.get(), TechnologicaBlocks.TEAK_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.WALNUT_STAIRS.get(), TechnologicaBlocks.WALNUT_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.ZEBRAWOOD_STAIRS.get(), TechnologicaBlocks.ZEBRAWOOD_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.ALCHEMICAL_STAIRS.get(), TechnologicaBlocks.ALCHEMICAL_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.BENEVOLENT_STAIRS.get(), TechnologicaBlocks.BENEVOLENT_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.CONDUCTIVE_STAIRS.get(), TechnologicaBlocks.CONDUCTIVE_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.FROSTBITTEN_STAIRS.get(), TechnologicaBlocks.FROSTBITTEN_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.FRUITFUL_STAIRS.get(), TechnologicaBlocks.FRUITFUL_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.INFERNAL_STAIRS.get(), TechnologicaBlocks.INFERNAL_PLANKS.get());
		casualOrProStairsTechnologica(consumer, TechnologicaBlocks.MALEVOLENT_STAIRS.get(), TechnologicaBlocks.MALEVOLENT_PLANKS.get());

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, TechnologicaItems.BANANAS_FOSTER.get(), 1).requires(TechnologicaItems.BANANA.get()).requires(Items.ICE).requires(Items.MILK_BUCKET).requires(Items.SUGAR).unlockedBy("has_banana", has(TechnologicaItems.BANANA.get())).save(consumer, new TechnologicaLocation("bananas_foster"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, TechnologicaItems.BLACK_FOREST_CAKE.get(), 1).requires(TechnologicaItems.CHERRY.get()).requires(Items.EGG).requires(Items.MILK_BUCKET).requires(Items.SUGAR).requires(Items.COCOA_BEANS).unlockedBy("has_cherry", has(TechnologicaItems.CHERRY.get())).save(consumer, new TechnologicaLocation("black_forest_cake"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, TechnologicaItems.BLUEBERRY_CHEESECAKE.get(), 1).requires(TechnologicaItems.BLUEBERRY.get()).requires(Items.COOKIE).requires(Items.MILK_BUCKET).requires(Items.SUGAR).unlockedBy("has_blueberry", has(TechnologicaItems.BLUEBERRY.get())).save(consumer, new TechnologicaLocation("blueberry_cheesecake"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, TechnologicaItems.COCONUT_CREAM_PIE.get(), 1).requires(TechnologicaItems.COCONUT.get()).requires(Items.EGG).requires(Items.MILK_BUCKET).requires(Items.SUGAR).unlockedBy("has_coconut", has(TechnologicaItems.COCONUT.get())).save(consumer, new TechnologicaLocation("coconut_cream_pie"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, TechnologicaItems.GRAPE_SHAVED_ICE.get(), 1).requires(TechnologicaItems.GRAPE.get()).requires(Items.SNOWBALL).unlockedBy("has_grape", has(TechnologicaItems.GRAPE.get())).save(consumer, new TechnologicaLocation("grape_shaved_ice"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, TechnologicaItems.KEY_LIME_MOUSSE.get(), 1).requires(TechnologicaItems.LIME.get()).requires(Items.MILK_BUCKET).requires(Items.SUGAR).unlockedBy("has_lime", has(TechnologicaItems.LIME.get())).save(consumer, new TechnologicaLocation("key_lime_mousse"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, TechnologicaItems.KIWI_SORBET.get(), 1).requires(TechnologicaItems.KIWI.get()).requires(Items.SNOWBALL).requires(Items.MILK_BUCKET).requires(Items.SUGAR).unlockedBy("has_kiwi", has(TechnologicaItems.KIWI.get())).save(consumer, new TechnologicaLocation("kiwi_sorbet"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, TechnologicaItems.LEMON_BAR.get(), 1).requires(TechnologicaItems.LEMON.get()).requires(Items.EGG).requires(Items.SUGAR).unlockedBy("has_lemon", has(TechnologicaItems.LEMON.get())).save(consumer, new TechnologicaLocation("lemon_bar"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, TechnologicaItems.ORANGE_DREAMSICLE.get(), 1).requires(TechnologicaItems.ORANGE.get()).requires(Items.ICE).requires(Items.MILK_BUCKET).requires(Items.SUGAR).unlockedBy("has_orange", has(TechnologicaItems.ORANGE.get())).save(consumer, new TechnologicaLocation("orange_dreamsicle"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, TechnologicaItems.PEACH_COBBLER.get(), 1).requires(TechnologicaItems.PEACH.get()).requires(Items.WHEAT).requires(Items.SUGAR).unlockedBy("has_peach", has(TechnologicaItems.PEACH.get())).save(consumer, new TechnologicaLocation("peach_cobbler"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, TechnologicaItems.PEAR_TART.get(), 1).requires(TechnologicaItems.PEAR.get()).requires(Items.WHEAT).requires(Items.SUGAR).unlockedBy("has_pear", has(TechnologicaItems.PEAR.get())).save(consumer, new TechnologicaLocation("pear_tart"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, TechnologicaItems.STRAWBERRY_SHORTCAKE.get(), 1).requires(TechnologicaItems.STRAWBERRY.get()).requires(Items.EGG).requires(Items.MILK_BUCKET).requires(Items.SUGAR).requires(Items.WHEAT).unlockedBy("has_strawberry", has(TechnologicaItems.STRAWBERRY.get())).save(consumer, new TechnologicaLocation("strawberry_shortcake"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, TechnologicaItems.TAPENADE.get(), 1).requires(TechnologicaItems.OLIVE.get()).requires(TechnologicaItems.GARLIC.get()).unlockedBy("has_olive", has(TechnologicaItems.OLIVE.get())).save(consumer, new TechnologicaLocation("tapenade"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, TechnologicaItems.CINNAMON_ROLL.get(), 1).requires(TechnologicaItems.CINNAMON.get()).requires(Items.EGG).requires(Items.SUGAR).requires(Items.MILK_BUCKET).unlockedBy("has_cinnamon", has(TechnologicaItems.CINNAMON.get())).save(consumer, new TechnologicaLocation("cinnamon_roll"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, TechnologicaItems.OLIVE_OIL.get(), 1).requires(TechnologicaItems.OLIVE.get()).unlockedBy("has_olive", has(TechnologicaItems.OLIVE.get())).save(consumer, new TechnologicaLocation("olive_oil"));

		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, TechnologicaItems.PRIMITIVE_SHOVEL.get()).define('T', Items.STICK).define('F', Items.FLINT).define('S', Items.STRING).pattern(" F ").pattern(" TS").pattern(" T ").unlockedBy("has_flint", has(Items.FLINT)).save(consumer, new TechnologicaLocation("primitive_shovel"));
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, TechnologicaItems.PRIMITIVE_PICKAXE.get()).define('T', Items.STICK).define('F', Items.FLINT).define('S', Items.STRING).pattern("FFF").pattern(" TS").pattern(" T ").unlockedBy("has_flint", has(Items.FLINT)).save(consumer, new TechnologicaLocation("primitive_pickaxe"));
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, TechnologicaItems.PRIMITIVE_HATCHET.get()).define('T', Items.STICK).define('F', Items.FLINT).define('S', Items.STRING).pattern("FF ").pattern("FTS").pattern(" T ").unlockedBy("has_flint", has(Items.FLINT)).save(consumer, new TechnologicaLocation("primitive_hatchet"));
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, TechnologicaItems.PRIMITIVE_HOE.get()).define('T', Items.STICK).define('F', Items.FLINT).define('S', Items.STRING).pattern("FF ").pattern(" TS").pattern(" T ").unlockedBy("has_flint", has(Items.FLINT)).save(consumer, new TechnologicaLocation("primitive_hoe"));
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, TechnologicaItems.PRIMITIVE_DAGGER.get()).define('T', Items.STICK).define('F', Items.FLINT).define('S', Items.STRING).pattern("F ").pattern("FS").pattern("T ").unlockedBy("has_flint", has(Items.FLINT)).save(consumer, new TechnologicaLocation("primitive_dagger"));

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TechnologicaItems.TRELLIS.get()).define('S', Items.STRING).define('B', Items.IRON_BARS).pattern("SBS").pattern("SBS").unlockedBy("has_iron_bars", has(Items.IRON_BARS)).save(consumer, new TechnologicaLocation("trellis"));

		sawmillRecipe(Ingredient.of(Items.OAK_LOG), Items.STRIPPED_OAK_LOG, 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_oak_log_from_oak_log_sawmill"));
		sawmillRecipe(Ingredient.of(Items.SPRUCE_LOG), Items.STRIPPED_SPRUCE_LOG, 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_spruce_log_from_spruce_log_sawmill"));
		sawmillRecipe(Ingredient.of(Items.BIRCH_LOG), Items.STRIPPED_BIRCH_LOG, 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_birch_log_from_birch_log_sawmill"));
		sawmillRecipe(Ingredient.of(Items.JUNGLE_LOG), Items.STRIPPED_JUNGLE_LOG, 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_jungle_log_from_jungle_log_sawmill"));
		sawmillRecipe(Ingredient.of(Items.ACACIA_LOG), Items.STRIPPED_ACACIA_LOG, 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_acacia_log_from_acacia_log_sawmill"));
		sawmillRecipe(Ingredient.of(Items.DARK_OAK_LOG), Items.STRIPPED_DARK_OAK_LOG, 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_dark_oak_log_from_dark_oak_log_sawmill"));
		sawmillRecipe(Ingredient.of(Items.CRIMSON_STEM), Items.STRIPPED_CRIMSON_STEM, 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_crimson_stem_from_crimson_stem_sawmill"));
		sawmillRecipe(Ingredient.of(Items.WARPED_STEM), Items.STRIPPED_WARPED_STEM, 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_warped_stem_from_warped_stem_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.APRICOT_LOG_ITEM.get()), TechnologicaItems.STRIPPED_APRICOT_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_apricot_log_from_apricot_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.ASPEN_LOG_ITEM.get()), TechnologicaItems.STRIPPED_ASPEN_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_aspen_log_from_aspen_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.AVOCADO_LOG_ITEM.get()), TechnologicaItems.STRIPPED_AVOCADO_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_avocado_log_from_avocado_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.BANANA_LOG_ITEM.get()), TechnologicaItems.STRIPPED_BANANA_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_banana_log_from_banana_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.CHERRY_LOG_ITEM.get()), TechnologicaItems.STRIPPED_CHERRY_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_cherry_log_from_cherry_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.CHESTNUT_LOG_ITEM.get()), TechnologicaItems.STRIPPED_CHESTNUT_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_chestnut_log_from_chestnut_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.CINNAMON_LOG_ITEM.get()), TechnologicaItems.STRIPPED_CINNAMON_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_cinnamon_log_from_cinnamon_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.COCONUT_LOG_ITEM.get()), TechnologicaItems.STRIPPED_COCONUT_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_coconut_log_from_coconut_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.EBONY_LOG_ITEM.get()), TechnologicaItems.STRIPPED_EBONY_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_ebony_log_from_ebony_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.KIWI_LOG_ITEM.get()), TechnologicaItems.STRIPPED_KIWI_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_kiwi_log_from_kiwi_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.LEMON_LOG_ITEM.get()), TechnologicaItems.STRIPPED_LEMON_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_lemon_log_from_lemon_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.LIME_LOG_ITEM.get()), TechnologicaItems.STRIPPED_LIME_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_lime_log_from_lime_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.MAHOGANY_LOG_ITEM.get()), TechnologicaItems.STRIPPED_MAHOGANY_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_mahogany_log_from_mahogany_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.MAPLE_LOG_ITEM.get()), TechnologicaItems.STRIPPED_MAPLE_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_maple_log_from_maple_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.OLIVE_LOG_ITEM.get()), TechnologicaItems.STRIPPED_OLIVE_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_olive_log_from_olive_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.ORANGE_LOG_ITEM.get()), TechnologicaItems.STRIPPED_ORANGE_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_orange_log_from_orange_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.PEACH_LOG_ITEM.get()), TechnologicaItems.STRIPPED_PEACH_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_peach_log_from_peach_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.PEAR_LOG_ITEM.get()), TechnologicaItems.STRIPPED_PEAR_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_pear_log_from_pear_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.PLUM_LOG_ITEM.get()), TechnologicaItems.STRIPPED_PLUM_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_plum_log_from_plum_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.REDWOOD_LOG_ITEM.get()), TechnologicaItems.STRIPPED_REDWOOD_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_redwood_log_from_redwood_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.ROSEWOOD_LOG_ITEM.get()), TechnologicaItems.STRIPPED_ROSEWOOD_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_rosewood_log_from_rosewood_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.RUBBER_LOG_ITEM.get()), TechnologicaItems.STRIPPED_RUBBER_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_rubber_log_from_rubber_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.TEAK_LOG_ITEM.get()), TechnologicaItems.STRIPPED_TEAK_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_teak_log_from_teak_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.WALNUT_LOG_ITEM.get()), TechnologicaItems.STRIPPED_WALNUT_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_walnut_log_from_walnut_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.ZEBRAWOOD_LOG_ITEM.get()), TechnologicaItems.STRIPPED_ZEBRAWOOD_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_zebrawood_log_from_zebrawood_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.FRUITFUL_LOG_ITEM.get()), TechnologicaItems.STRIPPED_FRUITFUL_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_fruitful_log_from_fruitful_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.ALCHEMICAL_LOG_ITEM.get()), TechnologicaItems.STRIPPED_ALCHEMICAL_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_alchemical_log_from_alchemical_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.BENEVOLENT_LOG_ITEM.get()), TechnologicaItems.STRIPPED_BENEVOLENT_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_benevolent_log_from_benevolent_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.MALEVOLENT_LOG_ITEM.get()), TechnologicaItems.STRIPPED_MALEVOLENT_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_malevolent_log_from_malevolent_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.CONDUCTIVE_LOG_ITEM.get()), TechnologicaItems.STRIPPED_CONDUCTIVE_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_conductive_log_from_conductive_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.FROSTBITTEN_LOG_ITEM.get()), TechnologicaItems.STRIPPED_FROSTBITTEN_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_frostbitten_log_from_frostbitten_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.INFERNAL_LOG_ITEM.get()), TechnologicaItems.STRIPPED_INFERNAL_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_infernal_log_from_infernal_log_sawmill"));
		// sawmillRecipe(Ingredient.of(TechnologicaItems.NECROTIC_LOG_ITEM.get()), TechnologicaItems.STRIPPED_NECROTIC_LOG_ITEM.get(), 1, TechnologicaItems.MULCH.get(), 1).save(consumer, new TechnologicaLocation("stripped_necrotic_log_from_necrotic_log_sawmill"));

		sawmillRecipe(Ingredient.of(Items.STRIPPED_OAK_LOG), Items.OAK_PLANKS, 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("oak_planks_from_oak_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(Items.STRIPPED_SPRUCE_LOG), Items.SPRUCE_PLANKS, 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("spruce_planks_from_spruce_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(Items.STRIPPED_BIRCH_LOG), Items.BIRCH_PLANKS, 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("birch_planks_from_birch_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(Items.STRIPPED_JUNGLE_LOG), Items.JUNGLE_PLANKS, 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("jungle_planks_from_jungle_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(Items.STRIPPED_ACACIA_LOG), Items.ACACIA_PLANKS, 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("acacia_planks_from_acacia_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(Items.STRIPPED_DARK_OAK_LOG), Items.DARK_OAK_PLANKS, 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("dark_oak_planks_from_dark_oak_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(Items.STRIPPED_CRIMSON_STEM), Items.CRIMSON_PLANKS, 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("crimson_planks_from_stripped_crimson_stem_sawmill"));
		sawmillRecipe(Ingredient.of(Items.STRIPPED_WARPED_STEM), Items.WARPED_PLANKS, 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("warped_planks_from_stripped_warped_stem_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_APRICOT_LOG_ITEM.get()), TechnologicaItems.APRICOT_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("apricot_planks_from_apricot_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_ASPEN_LOG_ITEM.get()), TechnologicaItems.ASPEN_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("aspen_planks_from_aspen_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_AVOCADO_LOG_ITEM.get()), TechnologicaItems.AVOCADO_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("avocado_planks_from_avocado_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_BANANA_LOG_ITEM.get()), TechnologicaItems.BANANA_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("banana_planks_from_banana_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_CHERRY_LOG_ITEM.get()), TechnologicaItems.CHERRY_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("cherry_planks_from_cherry_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_CHESTNUT_LOG_ITEM.get()), TechnologicaItems.CHESTNUT_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("chestnut_planks_from_chestnut_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_CINNAMON_LOG_ITEM.get()), TechnologicaItems.CINNAMON_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("cinnamon_planks_from_cinnamon_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_COCONUT_LOG_ITEM.get()), TechnologicaItems.COCONUT_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("coconut_planks_from_coconut_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_EBONY_LOG_ITEM.get()), TechnologicaItems.EBONY_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("ebony_planks_from_ebony_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_KIWI_LOG_ITEM.get()), TechnologicaItems.KIWI_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("kiwi_planks_from_kiwi_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_LEMON_LOG_ITEM.get()), TechnologicaItems.LEMON_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("lemon_planks_from_lemon_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_LIME_LOG_ITEM.get()), TechnologicaItems.LIME_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("lime_planks_from_lime_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_MAHOGANY_LOG_ITEM.get()), TechnologicaItems.MAHOGANY_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("mahogany_planks_from_mahogany_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_MAPLE_LOG_ITEM.get()), TechnologicaItems.MAPLE_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("maple_planks_from_maple_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_OLIVE_LOG_ITEM.get()), TechnologicaItems.OLIVE_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("olive_planks_from_olive_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_ORANGE_LOG_ITEM.get()), TechnologicaItems.ORANGE_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("orange_planks_from_orange_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_PEACH_LOG_ITEM.get()), TechnologicaItems.PEACH_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("peach_planks_from_peach_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_PEAR_LOG_ITEM.get()), TechnologicaItems.PEAR_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("pear_planks_from_pear_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_PLUM_LOG_ITEM.get()), TechnologicaItems.PLUM_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("plum_planks_from_plum_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_REDWOOD_LOG_ITEM.get()), TechnologicaItems.REDWOOD_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("redwood_planks_from_redwood_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_ROSEWOOD_LOG_ITEM.get()), TechnologicaItems.ROSEWOOD_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("rosewood_planks_from_rosewood_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_RUBBER_LOG_ITEM.get()), TechnologicaItems.RUBBER_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("rubber_planks_from_rubber_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_TEAK_LOG_ITEM.get()), TechnologicaItems.TEAK_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("teak_planks_from_teak_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_WALNUT_LOG_ITEM.get()), TechnologicaItems.WALNUT_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("walnut_planks_from_walnut_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_ZEBRAWOOD_LOG_ITEM.get()), TechnologicaItems.ZEBRAWOOD_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("zebrawood_planks_from_zebrawood_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_FRUITFUL_LOG_ITEM.get()), TechnologicaItems.FRUITFUL_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("fruitful_planks_from_fruitful_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_ALCHEMICAL_LOG_ITEM.get()), TechnologicaItems.ALCHEMICAL_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("alchemical_planks_from_alchemical_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_BENEVOLENT_LOG_ITEM.get()), TechnologicaItems.BENEVOLENT_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("benevolent_planks_from_benevolent_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_MALEVOLENT_LOG_ITEM.get()), TechnologicaItems.MALEVOLENT_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("malevolent_planks_from_malevolent_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_CONDUCTIVE_LOG_ITEM.get()), TechnologicaItems.CONDUCTIVE_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("conductive_planks_from_conductive_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_FROSTBITTEN_LOG_ITEM.get()), TechnologicaItems.FROSTBITTEN_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("frostbitten_planks_from_frostbitten_stripped_log_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_INFERNAL_LOG_ITEM.get()), TechnologicaItems.INFERNAL_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("infernal_planks_from_infernal_stripped_log_sawmill"));
		// sawmillRecipe(Ingredient.of(TechnologicaItems.STRIPPED_NECROTIC_LOG_ITEM.get()), TechnologicaItems.NECROTIC_PLANKS_ITEM.get(), 1, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("necrotic_planks_from_necrotic_stripped_log_sawmill"));

		sawmillRecipe(Ingredient.of(Items.OAK_PLANKS), Items.OAK_SLAB, 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("oak_slabs_from_oak_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(Items.SPRUCE_PLANKS), Items.SPRUCE_SLAB, 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("spruce_slabs_from_spruce_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(Items.BIRCH_PLANKS), Items.BIRCH_SLAB, 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("birch_slabs_from_birch_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(Items.JUNGLE_PLANKS), Items.JUNGLE_SLAB, 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("jungle_slabs_from_jungle_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(Items.ACACIA_PLANKS), Items.ACACIA_SLAB, 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("acacia_slabs_from_acacia_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(Items.DARK_OAK_PLANKS), Items.DARK_OAK_SLAB, 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("dark_oak_slabs_from_dark_oak_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(Items.CRIMSON_PLANKS), Items.CRIMSON_SLAB, 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("crimson_slab_from_crimson_planks_sawmill"));
		sawmillRecipe(Ingredient.of(Items.WARPED_PLANKS), Items.WARPED_SLAB, 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("warped_slab_from_warped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.APRICOT_PLANKS_ITEM.get()), TechnologicaItems.APRICOT_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("apricot_slabs_from_apricot_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.ASPEN_PLANKS_ITEM.get()), TechnologicaItems.ASPEN_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("aspen_slabs_from_aspen_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.AVOCADO_PLANKS_ITEM.get()), TechnologicaItems.AVOCADO_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("avocado_slabs_from_avocado_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.BANANA_PLANKS_ITEM.get()), TechnologicaItems.BANANA_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("banana_slabs_from_banana_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.CHERRY_PLANKS_ITEM.get()), TechnologicaItems.CHERRY_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("cherry_slabs_from_cherry_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.CHESTNUT_PLANKS_ITEM.get()), TechnologicaItems.CHESTNUT_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("chestnut_slabs_from_chestnut_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.CINNAMON_PLANKS_ITEM.get()), TechnologicaItems.CINNAMON_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("cinnamon_slabs_from_cinnamon_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.COCONUT_PLANKS_ITEM.get()), TechnologicaItems.COCONUT_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("coconut_slabs_from_coconut_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.EBONY_PLANKS_ITEM.get()), TechnologicaItems.EBONY_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("ebony_slabs_from_ebony_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.KIWI_PLANKS_ITEM.get()), TechnologicaItems.KIWI_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("kiwi_slabs_from_kiwi_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.LEMON_PLANKS_ITEM.get()), TechnologicaItems.LEMON_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("lemon_slabs_from_lemon_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.LIME_PLANKS_ITEM.get()), TechnologicaItems.LIME_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("lime_slabs_from_lime_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.MAHOGANY_PLANKS_ITEM.get()), TechnologicaItems.MAHOGANY_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("mahogany_slabs_from_mahogany_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.MAPLE_PLANKS_ITEM.get()), TechnologicaItems.MAPLE_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("maple_slabs_from_maple_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.OLIVE_PLANKS_ITEM.get()), TechnologicaItems.OLIVE_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("olive_slabs_from_olive_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.ORANGE_PLANKS_ITEM.get()), TechnologicaItems.ORANGE_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("orange_slabs_from_orange_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.PEACH_PLANKS_ITEM.get()), TechnologicaItems.PEACH_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("peach_slabs_from_peach_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.PEAR_PLANKS_ITEM.get()), TechnologicaItems.PEAR_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("pear_slabs_from_pear_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.PLUM_PLANKS_ITEM.get()), TechnologicaItems.PLUM_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("plum_slabs_from_plum_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.REDWOOD_PLANKS_ITEM.get()), TechnologicaItems.REDWOOD_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("redwood_slabs_from_redwood_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.ROSEWOOD_PLANKS_ITEM.get()), TechnologicaItems.ROSEWOOD_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("rosewood_slabs_from_rosewood_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.RUBBER_PLANKS_ITEM.get()), TechnologicaItems.RUBBER_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("rubber_slabs_from_rubber_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.TEAK_PLANKS_ITEM.get()), TechnologicaItems.TEAK_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("teak_slabs_from_teak_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.WALNUT_PLANKS_ITEM.get()), TechnologicaItems.WALNUT_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("walnut_slabs_from_walnut_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.ZEBRAWOOD_PLANKS_ITEM.get()), TechnologicaItems.ZEBRAWOOD_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("zebrawood_slabs_from_zebrawood_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.FRUITFUL_PLANKS_ITEM.get()), TechnologicaItems.FRUITFUL_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("fruitful_slabs_from_fruitful_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.ALCHEMICAL_PLANKS_ITEM.get()), TechnologicaItems.ALCHEMICAL_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("alchemical_slabs_from_alchemical_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.BENEVOLENT_PLANKS_ITEM.get()), TechnologicaItems.BENEVOLENT_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("benevolent_slabs_from_benevolent_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.MALEVOLENT_PLANKS_ITEM.get()), TechnologicaItems.MALEVOLENT_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("malevolent_slabs_from_malevolent_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.CONDUCTIVE_PLANKS_ITEM.get()), TechnologicaItems.CONDUCTIVE_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("conductive_slabs_from_conductive_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.FROSTBITTEN_PLANKS_ITEM.get()), TechnologicaItems.FROSTBITTEN_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("frostbitten_slabs_from_frostbitten_stripped_planks_sawmill"));
		sawmillRecipe(Ingredient.of(TechnologicaItems.INFERNAL_PLANKS_ITEM.get()), TechnologicaItems.INFERNAL_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("infernal_slabs_from_infernal_stripped_planks_sawmill"));
		// sawmillRecipe(Ingredient.of(TechnologicaItems.NECROTIC_PLANKS_ITEM.get()), TechnologicaItems.NECROTIC_SLAB_ITEM.get(), 2, TechnologicaItems.SAWDUST.get(), 1).save(consumer, new TechnologicaLocation("necrotic_slabs_from_necrotic_stripped_planks_sawmill"));
	}

	private static void casualOrProPlanksVanilla(Consumer<FinishedRecipe> recipeConsumer, ItemLike output, TagKey<Item> input) {
		ConditionalRecipe.builder().addCondition(new EnablePlankConditionFactory()).addRecipe((consumer2) -> ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, output, 4).requires(input).group("planks").unlockedBy("has_log", has(input)).save(consumer2)).addCondition(new DisablePlankConditionFactory()).addRecipe((consumer2) -> ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, output, 1).requires(input).requires(TechnologicaItems.SAW.get()).group("planks").unlockedBy("has_saw", has(TechnologicaItems.SAW.get())).save(consumer2)).build(recipeConsumer, new ResourceLocation(ForgeRegistries.ITEMS.getKey(output.asItem()).getPath()));
	}

	private static void casualOrProPlanksTechnologica(Consumer<FinishedRecipe> recipeConsumer, ItemLike output, TagKey<Item> input) {
		ConditionalRecipe.builder().addCondition(new EnablePlankConditionFactory()).addRecipe((consumer2) -> ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, output, 4).requires(input).group("planks").unlockedBy("has_log", has(input)).save(consumer2)).addCondition(new DisablePlankConditionFactory()).addRecipe((consumer2) -> ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, output, 1).requires(input).requires(TechnologicaItems.SAW.get()).group("planks").unlockedBy("has_saw", has(TechnologicaItems.SAW.get())).save(consumer2)).build(recipeConsumer, new TechnologicaLocation(ForgeRegistries.ITEMS.getKey(output.asItem()).getPath()));
	}

	private static void casualOrProSlabsVanilla(Consumer<FinishedRecipe> recipeConsumer, ItemLike output, ItemLike input) {
		ConditionalRecipe.builder().addCondition(new EnablePlankConditionFactory()).addRecipe((consumer2) -> ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 6).define('#', input).pattern("###").group("wooden_slab").unlockedBy("has_planks", has(input)).save(consumer2)).addCondition(new DisablePlankConditionFactory()).addRecipe((consumer2) -> ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, output, 2).requires(input).requires(TechnologicaItems.SAW.get()).group("wooden_slab").unlockedBy("has_saw", has(TechnologicaItems.SAW.get())).save(consumer2)).build(recipeConsumer, new ResourceLocation(ForgeRegistries.ITEMS.getKey(output.asItem()).getPath()));
	}

	private static void casualOrProSlabsTechnologica(Consumer<FinishedRecipe> recipeConsumer, ItemLike output, ItemLike input) {
		ConditionalRecipe.builder().addCondition(new EnablePlankConditionFactory()).addRecipe((consumer2) -> ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 6).define('#', input).pattern("###").group("wooden_slab").unlockedBy("has_planks", has(input)).save(consumer2)).addCondition(new DisablePlankConditionFactory()).addRecipe((consumer2) -> ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, output, 2).requires(input).requires(TechnologicaItems.SAW.get()).group("wooden_slab").unlockedBy("has_saw", has(TechnologicaItems.SAW.get())).save(consumer2)).build(recipeConsumer, new TechnologicaLocation(ForgeRegistries.ITEMS.getKey(output.asItem()).getPath()));
	}

	private static void casualOrProStairsVanilla(Consumer<FinishedRecipe> recipeConsumer, ItemLike output, ItemLike input) {
		ConditionalRecipe.builder().addCondition(new EnablePlankConditionFactory()).addRecipe((consumer2) -> ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 4).define('#', input).pattern("#  ").pattern("## ").pattern("###").group("wooden_stairs").unlockedBy("has_planks", has(input)).save(consumer2)).addCondition(new DisablePlankConditionFactory()).addRecipe((consumer2) -> ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, output, 1).requires(input).requires(TechnologicaItems.CHISEL.get()).group("wooden_slab").unlockedBy("has_chisel", has(TechnologicaItems.CHISEL.get())).save(consumer2)).build(recipeConsumer, new ResourceLocation(ForgeRegistries.ITEMS.getKey(output.asItem()).getPath()));
	}

	private static void casualOrProStairsTechnologica(Consumer<FinishedRecipe> recipeConsumer, ItemLike output, ItemLike input) {
		ConditionalRecipe.builder().addCondition(new EnablePlankConditionFactory()).addRecipe((consumer2) -> ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 4).define('#', input).pattern("#  ").pattern("## ").pattern("###").group("wooden_stairs").unlockedBy("has_planks", has(input)).save(consumer2)).addCondition(new DisablePlankConditionFactory()).addRecipe((consumer2) -> ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, output, 1).requires(input).requires(TechnologicaItems.CHISEL.get()).group("wooden_slab").unlockedBy("has_chisel", has(TechnologicaItems.CHISEL.get())).save(consumer2)).build(recipeConsumer, new TechnologicaLocation(ForgeRegistries.ITEMS.getKey(output.asItem()).getPath()));
	}

	public static MultipleOutputRecipeBuilder sawmillRecipe(Ingredient ingredientIn, ItemLike output, int countIn, ItemLike output2, int count2) {
		return new MultipleOutputRecipeBuilder(RecipeCategory.BUILDING_BLOCKS, TechnologicaRecipeSerializers.SAWMILL.get(), ingredientIn, output, countIn, output2, count2).unlockedBy("has_logs", has(TechnologicaItemTags.APRICOT_LOGS));
	}
}