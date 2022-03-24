package com.technologica.data.loot;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.util.text.ResourceLocationHelper;
import com.technologica.world.item.TechnologicaItems;
import com.technologica.world.level.block.ChairBlock;
import com.technologica.world.level.block.FruitingLeavesBlock;
import com.technologica.world.level.block.SapLogBlock;
import com.technologica.world.level.block.SawmillBlock;
import com.technologica.world.level.block.TableBlock;
import com.technologica.world.level.block.TechnologicaBlocks;
import com.technologica.world.level.block.TreeTapBlock;
import com.technologica.world.level.block.TwentyFourDirectionBlock;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;

public class TechnologicaBlockLoot extends BlockLoot {
	private static final float[] DEFAULT_SAPLING_DROP_RATES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
	
	@Override
	protected void addTables() {
		add(TechnologicaBlocks.ASPARAGUS_CROP.get(), createCropDrops(TechnologicaBlocks.ASPARAGUS_CROP.get(), TechnologicaItems.ASPARAGUS.get(), TechnologicaBlocks.ASPARAGUS_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.ASPARAGUS_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.BARLEY_CROP.get(), createCropDrops(TechnologicaBlocks.BARLEY_CROP.get(), TechnologicaItems.BARLEY.get(), TechnologicaBlocks.BARLEY_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.BARLEY_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.BLACKBERRY_CROP.get(), createCropDrops(TechnologicaBlocks.BLACKBERRY_CROP.get(), TechnologicaItems.BLACKBERRY.get(), TechnologicaBlocks.BLACKBERRY_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.BLACKBERRY_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.BLUEBERRY_CROP.get(), createCropDrops(TechnologicaBlocks.BLUEBERRY_CROP.get(), TechnologicaItems.BLUEBERRY.get(), TechnologicaBlocks.BLUEBERRY_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.BLUEBERRY_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.BROCCOLI_CROP.get(), createCropDrops(TechnologicaBlocks.BROCCOLI_CROP.get(), TechnologicaItems.BROCCOLI.get(), TechnologicaBlocks.BROCCOLI_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.BROCCOLI_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.CELERY_CROP.get(), createCropDrops(TechnologicaBlocks.CELERY_CROP.get(), TechnologicaItems.CELERY.get(), TechnologicaBlocks.CELERY_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.CELERY_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.CHILI_PEPPER_CROP.get(), createCropDrops(TechnologicaBlocks.CHILI_PEPPER_CROP.get(), TechnologicaItems.CHILI_PEPPER.get(), TechnologicaBlocks.CHILI_PEPPER_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.CHILI_PEPPER_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.COFFEE_BEAN_CROP.get(), createCropDrops(TechnologicaBlocks.COFFEE_BEAN_CROP.get(), TechnologicaItems.COFFEE_BEANS.get(), TechnologicaBlocks.COFFEE_BEAN_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.COFFEE_BEAN_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.CORN_CROP.get(), createCropDrops(TechnologicaBlocks.CORN_CROP.get(), TechnologicaItems.CORN.get(), TechnologicaBlocks.CORN_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.CORN_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.COTTON_CROP.get(), createCropDrops(TechnologicaBlocks.COTTON_CROP.get(), TechnologicaItems.COTTON.get(), TechnologicaBlocks.COTTON_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.COTTON_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.CRANBERRY_CROP.get(), createCropDrops(TechnologicaBlocks.CRANBERRY_CROP.get(), TechnologicaItems.CRANBERRY.get(), TechnologicaBlocks.CRANBERRY_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.CRANBERRY_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.CUCUMBER_CROP.get(), createCropDrops(TechnologicaBlocks.CUCUMBER_CROP.get(), TechnologicaItems.CUCUMBER.get(), TechnologicaBlocks.CUCUMBER_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.CUCUMBER_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.GARLIC_CROP.get(), createCropDrops(TechnologicaBlocks.GARLIC_CROP.get(), TechnologicaItems.GARLIC.get(), TechnologicaBlocks.GARLIC_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.GARLIC_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.GINGER_CROP.get(), createCropDrops(TechnologicaBlocks.GINGER_CROP.get(), TechnologicaItems.GINGER.get(), TechnologicaBlocks.GINGER_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.GINGER_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.GRAPE_CROP.get(), createCropDrops(TechnologicaBlocks.GRAPE_CROP.get(), TechnologicaItems.GRAPE.get(), TechnologicaBlocks.GRAPE_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.GRAPE_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.LETTUCE_CROP.get(), createCropDrops(TechnologicaBlocks.LETTUCE_CROP.get(), TechnologicaItems.LETTUCE.get(), TechnologicaBlocks.LETTUCE_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.LETTUCE_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.MUSTARD_GREENS_CROP.get(), createCropDrops(TechnologicaBlocks.MUSTARD_GREENS_CROP.get(), TechnologicaItems.MUSTARD_GREENS.get(), TechnologicaBlocks.MUSTARD_GREENS_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.MUSTARD_GREENS_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.OATS_CROP.get(), createCropDrops(TechnologicaBlocks.OATS_CROP.get(), TechnologicaItems.OATS.get(), TechnologicaBlocks.OATS_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.OATS_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.ONION_CROP.get(), createCropDrops(TechnologicaBlocks.ONION_CROP.get(), TechnologicaItems.ONION.get(), TechnologicaBlocks.ONION_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.ONION_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.PEA_CROP.get(), createCropDrops(TechnologicaBlocks.PEA_CROP.get(), TechnologicaItems.PEAS.get(), TechnologicaBlocks.PEA_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.PEA_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.PEANUT_CROP.get(), createCropDrops(TechnologicaBlocks.PEANUT_CROP.get(), TechnologicaItems.PEANUT.get(), TechnologicaBlocks.PEANUT_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.PEANUT_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.PEPPERCORN_CROP.get(), createCropDrops(TechnologicaBlocks.PEPPERCORN_CROP.get(), TechnologicaItems.PEPPERCORNS.get(), TechnologicaBlocks.PEPPERCORN_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.PEPPERCORN_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.PINEAPPLE_CROP.get(), createCropDrops(TechnologicaBlocks.PINEAPPLE_CROP.get(), TechnologicaItems.PINEAPPLE.get(), TechnologicaBlocks.PINEAPPLE_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.PINEAPPLE_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.PURPLE_CABBAGE_CROP.get(), createCropDrops(TechnologicaBlocks.PURPLE_CABBAGE_CROP.get(), TechnologicaItems.PURPLE_CABBAGE.get(), TechnologicaBlocks.PURPLE_CABBAGE_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.PURPLE_CABBAGE_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.RADISH_CROP.get(), createCropDrops(TechnologicaBlocks.RADISH_CROP.get(), TechnologicaItems.RADISH.get(), TechnologicaBlocks.RADISH_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.RADISH_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.RASPBERRY_CROP.get(), createCropDrops(TechnologicaBlocks.RASPBERRY_CROP.get(), TechnologicaItems.RASPBERRY.get(), TechnologicaBlocks.RASPBERRY_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.RASPBERRY_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.RED_BEAN_CROP.get(), createCropDrops(TechnologicaBlocks.RED_BEAN_CROP.get(), TechnologicaItems.RED_BEANS.get(), TechnologicaBlocks.RED_BEAN_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.RED_BEAN_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.RICE_CROP.get(), createCropDrops(TechnologicaBlocks.RICE_CROP.get(), TechnologicaItems.RICE.get(), TechnologicaBlocks.RICE_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.RICE_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.RYE_CROP.get(), createCropDrops(TechnologicaBlocks.RYE_CROP.get(), TechnologicaItems.RYE.get(), TechnologicaBlocks.RYE_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.RYE_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.SOYBEAN_CROP.get(), createCropDrops(TechnologicaBlocks.SOYBEAN_CROP.get(), TechnologicaItems.SOYBEANS.get(), TechnologicaBlocks.SOYBEAN_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.SOYBEAN_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.SQUASH_CROP.get(), createCropDrops(TechnologicaBlocks.SQUASH_CROP.get(), TechnologicaItems.SQUASH.get(), TechnologicaBlocks.SQUASH_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.SQUASH_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.STRAWBERRY_CROP.get(), createCropDrops(TechnologicaBlocks.STRAWBERRY_CROP.get(), TechnologicaItems.STRAWBERRY.get(), TechnologicaBlocks.STRAWBERRY_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.STRAWBERRY_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.SWEET_POTATO_CROP.get(), createCropDrops(TechnologicaBlocks.SWEET_POTATO_CROP.get(), TechnologicaItems.SWEET_POTATO.get(), TechnologicaBlocks.SWEET_POTATO_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.SWEET_POTATO_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.TEA_CROP.get(), createCropDrops(TechnologicaBlocks.TEA_CROP.get(), TechnologicaItems.TEA_LEAF.get(), TechnologicaBlocks.TEA_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.TEA_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.TOMATO_CROP.get(), createCropDrops(TechnologicaBlocks.TOMATO_CROP.get(), TechnologicaItems.TOMATO.get(), TechnologicaBlocks.TOMATO_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.TOMATO_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.TURNIP_CROP.get(), createCropDrops(TechnologicaBlocks.TURNIP_CROP.get(), TechnologicaItems.TURNIP.get(), TechnologicaBlocks.TURNIP_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.TURNIP_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.ZUCCHINI_CROP.get(), createCropDrops(TechnologicaBlocks.ZUCCHINI_CROP.get(), TechnologicaItems.ZUCCHINI.get(), TechnologicaBlocks.ZUCCHINI_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.ZUCCHINI_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		
		dropSelf(TechnologicaItems.ASPARAGUS_SEEDS.get());
		dropSelf(TechnologicaItems.BARLEY_SEEDS.get());
		dropSelf(TechnologicaItems.BLACKBERRY_SEEDS.get());
		dropSelf(TechnologicaItems.BLUEBERRY_SEEDS.get());
		dropSelf(TechnologicaItems.BROCCOLI_SEEDS.get());
		dropSelf(TechnologicaItems.CELERY_SEEDS.get());
		dropSelf(TechnologicaItems.CHILI_PEPPER_SEEDS.get());
		dropSelf(TechnologicaItems.COFFEE_BEANS.get());
		dropSelf(TechnologicaItems.CORN_SEEDS.get());
		dropSelf(TechnologicaItems.COTTON_SEEDS.get());
		dropSelf(TechnologicaItems.CRANBERRY_SEEDS.get());
		dropSelf(TechnologicaItems.CUCUMBER_SEEDS.get());
		dropSelf(TechnologicaItems.GARLIC_SEEDS.get());
		dropSelf(TechnologicaItems.GINGER_SEEDS.get());
		dropSelf(TechnologicaItems.GRAPE_SEEDS.get());
		dropSelf(TechnologicaItems.LETTUCE_SEEDS.get());
		dropSelf(TechnologicaItems.MUSTARD_GREENS.get());
		dropSelf(TechnologicaItems.OATS_SEEDS.get());
		dropSelf(TechnologicaItems.ONION_SEEDS.get());
		dropSelf(TechnologicaItems.PEA_SEEDS.get());
		dropSelf(TechnologicaItems.PEANUT_SEEDS.get());
		dropSelf(TechnologicaItems.PEPPERCORN_SEEDS.get());
		dropSelf(TechnologicaItems.PINEAPPLE_SEEDS.get());
		dropSelf(TechnologicaItems.PURPLE_CABBAGE_SEEDS.get());
		dropSelf(TechnologicaItems.RADISH_SEEDS.get());
		dropSelf(TechnologicaItems.RASPBERRY_SEEDS.get());
		dropSelf(TechnologicaItems.RED_BEANS.get());
		dropSelf(TechnologicaItems.RICE_SEEDS.get());
		dropSelf(TechnologicaItems.RYE_SEEDS.get());
		dropSelf(TechnologicaItems.SOYBEANS.get());
		dropSelf(TechnologicaItems.SQUASH_SEEDS.get());
		dropSelf(TechnologicaItems.STRAWBERRY_SEEDS.get());
		dropSelf(TechnologicaItems.SWEET_POTATO_SEEDS.get());
		dropSelf(TechnologicaItems.TEA_SEEDS.get());
		dropSelf(TechnologicaItems.TOMATO_SEEDS.get());
		dropSelf(TechnologicaItems.TURNIP_SEEDS.get());
		dropSelf(TechnologicaItems.ZUCCHINI_SEEDS.get());
		
		dropSelf(TechnologicaBlocks.APRICOT_PLANKS.get());
		dropSelf(TechnologicaBlocks.ASPEN_PLANKS.get());
		dropSelf(TechnologicaBlocks.AVOCADO_PLANKS.get());
		dropSelf(TechnologicaBlocks.BANANA_PLANKS.get());
		dropSelf(TechnologicaBlocks.CHERRY_PLANKS.get());
		dropSelf(TechnologicaBlocks.CHESTNUT_PLANKS.get());
		dropSelf(TechnologicaBlocks.CINNAMON_PLANKS.get());
		dropSelf(TechnologicaBlocks.COCONUT_PLANKS.get());
		dropSelf(TechnologicaBlocks.EBONY_PLANKS.get());
		dropSelf(TechnologicaBlocks.KIWI_PLANKS.get());
		dropSelf(TechnologicaBlocks.LEMON_PLANKS.get());
		dropSelf(TechnologicaBlocks.LIME_PLANKS.get());
		dropSelf(TechnologicaBlocks.MAHOGANY_PLANKS.get());
		dropSelf(TechnologicaBlocks.MAPLE_PLANKS.get());
		dropSelf(TechnologicaBlocks.OLIVE_PLANKS.get());
		dropSelf(TechnologicaBlocks.ORANGE_PLANKS.get());
		dropSelf(TechnologicaBlocks.PEACH_PLANKS.get());
		dropSelf(TechnologicaBlocks.PEAR_PLANKS.get());
		dropSelf(TechnologicaBlocks.PLUM_PLANKS.get());
		dropSelf(TechnologicaBlocks.REDWOOD_PLANKS.get());
		dropSelf(TechnologicaBlocks.ROSEWOOD_PLANKS.get());
		dropSelf(TechnologicaBlocks.RUBBER_PLANKS.get());
		dropSelf(TechnologicaBlocks.TEAK_PLANKS.get());
		dropSelf(TechnologicaBlocks.WALNUT_PLANKS.get());
		dropSelf(TechnologicaBlocks.ZEBRAWOOD_PLANKS.get());
		dropSelf(TechnologicaBlocks.ALCHEMICAL_PLANKS.get());
		dropSelf(TechnologicaBlocks.BENEVOLENT_PLANKS.get());
		dropSelf(TechnologicaBlocks.CONDUCTIVE_PLANKS.get());
		dropSelf(TechnologicaBlocks.FROSTBITTEN_PLANKS.get());
		dropSelf(TechnologicaBlocks.FRUITFUL_PLANKS.get());
		dropSelf(TechnologicaBlocks.INFERNAL_PLANKS.get());
		dropSelf(TechnologicaBlocks.MALEVOLENT_PLANKS.get());
		dropSelf(TechnologicaBlocks.NECROTIC_PLANKS.get());
		
		add((TechnologicaBlocks.APRICOT_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.ASPEN_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.AVOCADO_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.BANANA_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.CHERRY_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.CHESTNUT_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.CINNAMON_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.COCONUT_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.EBONY_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.KIWI_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.LEMON_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.LIME_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.MAHOGANY_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.MAPLE_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.OLIVE_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.ORANGE_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.PEACH_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.PEAR_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.PLUM_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.REDWOOD_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.ROSEWOOD_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.RUBBER_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.TEAK_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.WALNUT_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.ZEBRAWOOD_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.ALCHEMICAL_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.BENEVOLENT_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.CONDUCTIVE_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.FROSTBITTEN_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.FRUITFUL_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.INFERNAL_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.MALEVOLENT_SLAB.get()), BlockLoot::createSlabItemTable);
		add((TechnologicaBlocks.NECROTIC_SLAB.get()), BlockLoot::createSlabItemTable);
		
		dropSelf(TechnologicaBlocks.APRICOT_STAIRS.get());
		dropSelf(TechnologicaBlocks.ASPEN_STAIRS.get());
		dropSelf(TechnologicaBlocks.AVOCADO_STAIRS.get());
		dropSelf(TechnologicaBlocks.BANANA_STAIRS.get());
		dropSelf(TechnologicaBlocks.CHERRY_STAIRS.get());
		dropSelf(TechnologicaBlocks.CHESTNUT_STAIRS.get());
		dropSelf(TechnologicaBlocks.CINNAMON_STAIRS.get());
		dropSelf(TechnologicaBlocks.COCONUT_STAIRS.get());
		dropSelf(TechnologicaBlocks.EBONY_STAIRS.get());
		dropSelf(TechnologicaBlocks.KIWI_STAIRS.get());
		dropSelf(TechnologicaBlocks.LEMON_STAIRS.get());
		dropSelf(TechnologicaBlocks.LIME_STAIRS.get());
		dropSelf(TechnologicaBlocks.MAHOGANY_STAIRS.get());
		dropSelf(TechnologicaBlocks.MAPLE_STAIRS.get());
		dropSelf(TechnologicaBlocks.OLIVE_STAIRS.get());
		dropSelf(TechnologicaBlocks.ORANGE_STAIRS.get());
		dropSelf(TechnologicaBlocks.PEACH_STAIRS.get());
		dropSelf(TechnologicaBlocks.PEAR_STAIRS.get());
		dropSelf(TechnologicaBlocks.PLUM_STAIRS.get());
		dropSelf(TechnologicaBlocks.REDWOOD_STAIRS.get());
		dropSelf(TechnologicaBlocks.ROSEWOOD_STAIRS.get());
		dropSelf(TechnologicaBlocks.RUBBER_STAIRS.get());
		dropSelf(TechnologicaBlocks.TEAK_STAIRS.get());
		dropSelf(TechnologicaBlocks.WALNUT_STAIRS.get());
		dropSelf(TechnologicaBlocks.ZEBRAWOOD_STAIRS.get());
		dropSelf(TechnologicaBlocks.ALCHEMICAL_STAIRS.get());
		dropSelf(TechnologicaBlocks.BENEVOLENT_STAIRS.get());
		dropSelf(TechnologicaBlocks.CONDUCTIVE_STAIRS.get());
		dropSelf(TechnologicaBlocks.FROSTBITTEN_STAIRS.get());
		dropSelf(TechnologicaBlocks.FRUITFUL_STAIRS.get());
		dropSelf(TechnologicaBlocks.INFERNAL_STAIRS.get());
		dropSelf(TechnologicaBlocks.MALEVOLENT_STAIRS.get());
		dropSelf(TechnologicaBlocks.NECROTIC_STAIRS.get());
		
		dropSelf(TechnologicaBlocks.APRICOT_FENCE.get());
		dropSelf(TechnologicaBlocks.ASPEN_FENCE.get());
		dropSelf(TechnologicaBlocks.AVOCADO_FENCE.get());
		dropSelf(TechnologicaBlocks.BANANA_FENCE.get());
		dropSelf(TechnologicaBlocks.CHERRY_FENCE.get());
		dropSelf(TechnologicaBlocks.CHESTNUT_FENCE.get());
		dropSelf(TechnologicaBlocks.CINNAMON_FENCE.get());
		dropSelf(TechnologicaBlocks.COCONUT_FENCE.get());
		dropSelf(TechnologicaBlocks.EBONY_FENCE.get());
		dropSelf(TechnologicaBlocks.KIWI_FENCE.get());
		dropSelf(TechnologicaBlocks.LEMON_FENCE.get());
		dropSelf(TechnologicaBlocks.LIME_FENCE.get());
		dropSelf(TechnologicaBlocks.MAHOGANY_FENCE.get());
		dropSelf(TechnologicaBlocks.MAPLE_FENCE.get());
		dropSelf(TechnologicaBlocks.OLIVE_FENCE.get());
		dropSelf(TechnologicaBlocks.ORANGE_FENCE.get());
		dropSelf(TechnologicaBlocks.PEACH_FENCE.get());
		dropSelf(TechnologicaBlocks.PEAR_FENCE.get());
		dropSelf(TechnologicaBlocks.PLUM_FENCE.get());
		dropSelf(TechnologicaBlocks.REDWOOD_FENCE.get());
		dropSelf(TechnologicaBlocks.ROSEWOOD_FENCE.get());
		dropSelf(TechnologicaBlocks.RUBBER_FENCE.get());
		dropSelf(TechnologicaBlocks.TEAK_FENCE.get());
		dropSelf(TechnologicaBlocks.WALNUT_FENCE.get());
		dropSelf(TechnologicaBlocks.ZEBRAWOOD_FENCE.get());
		dropSelf(TechnologicaBlocks.ALCHEMICAL_FENCE.get());
		dropSelf(TechnologicaBlocks.BENEVOLENT_FENCE.get());
		dropSelf(TechnologicaBlocks.CONDUCTIVE_FENCE.get());
		dropSelf(TechnologicaBlocks.FROSTBITTEN_FENCE.get());
		dropSelf(TechnologicaBlocks.FRUITFUL_FENCE.get());
		dropSelf(TechnologicaBlocks.INFERNAL_FENCE.get());
		dropSelf(TechnologicaBlocks.MALEVOLENT_FENCE.get());
		dropSelf(TechnologicaBlocks.NECROTIC_FENCE.get());
	
		dropSelf(TechnologicaBlocks.APRICOT_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.ASPEN_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.AVOCADO_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.BANANA_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.CHERRY_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.CHESTNUT_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.CINNAMON_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.COCONUT_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.EBONY_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.KIWI_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.LEMON_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.LIME_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.MAHOGANY_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.MAPLE_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.OLIVE_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.ORANGE_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.PEACH_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.PEAR_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.PLUM_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.REDWOOD_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.ROSEWOOD_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.RUBBER_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.TEAK_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.WALNUT_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.ZEBRAWOOD_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.ALCHEMICAL_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.BENEVOLENT_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.CONDUCTIVE_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.FROSTBITTEN_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.FRUITFUL_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.INFERNAL_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.MALEVOLENT_FENCE_GATE.get());
		dropSelf(TechnologicaBlocks.NECROTIC_FENCE_GATE.get());
		
		dropSelf(TechnologicaBlocks.APRICOT_SIGN.get());
		dropSelf(TechnologicaBlocks.ASPEN_SIGN.get());
		dropSelf(TechnologicaBlocks.AVOCADO_SIGN.get());
		dropSelf(TechnologicaBlocks.BANANA_SIGN.get());
		dropSelf(TechnologicaBlocks.CHERRY_SIGN.get());
		dropSelf(TechnologicaBlocks.CHESTNUT_SIGN.get());
		dropSelf(TechnologicaBlocks.CINNAMON_SIGN.get());
		dropSelf(TechnologicaBlocks.COCONUT_SIGN.get());
		dropSelf(TechnologicaBlocks.EBONY_SIGN.get());
		dropSelf(TechnologicaBlocks.KIWI_SIGN.get());
		dropSelf(TechnologicaBlocks.LEMON_SIGN.get());
		dropSelf(TechnologicaBlocks.LIME_SIGN.get());
		dropSelf(TechnologicaBlocks.MAHOGANY_SIGN.get());
		dropSelf(TechnologicaBlocks.MAPLE_SIGN.get());
		dropSelf(TechnologicaBlocks.OLIVE_SIGN.get());
		dropSelf(TechnologicaBlocks.ORANGE_SIGN.get());
		dropSelf(TechnologicaBlocks.PEACH_SIGN.get());
		dropSelf(TechnologicaBlocks.PEAR_SIGN.get());
		dropSelf(TechnologicaBlocks.PLUM_SIGN.get());
		dropSelf(TechnologicaBlocks.REDWOOD_SIGN.get());
		dropSelf(TechnologicaBlocks.ROSEWOOD_SIGN.get());
		dropSelf(TechnologicaBlocks.RUBBER_SIGN.get());
		dropSelf(TechnologicaBlocks.TEAK_SIGN.get());
		dropSelf(TechnologicaBlocks.WALNUT_SIGN.get());
		dropSelf(TechnologicaBlocks.ZEBRAWOOD_SIGN.get());
		dropSelf(TechnologicaBlocks.ALCHEMICAL_SIGN.get());
		dropSelf(TechnologicaBlocks.BENEVOLENT_SIGN.get());
		dropSelf(TechnologicaBlocks.CONDUCTIVE_SIGN.get());
		dropSelf(TechnologicaBlocks.FROSTBITTEN_SIGN.get());
		dropSelf(TechnologicaBlocks.FRUITFUL_SIGN.get());
		dropSelf(TechnologicaBlocks.INFERNAL_SIGN.get());
		dropSelf(TechnologicaBlocks.MALEVOLENT_SIGN.get());
		dropSelf(TechnologicaBlocks.NECROTIC_SIGN.get());
		
		dropSelf(TechnologicaBlocks.APRICOT_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.ASPEN_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.AVOCADO_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.BANANA_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.CHERRY_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.CHESTNUT_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.CINNAMON_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.COCONUT_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.EBONY_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.KIWI_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.LEMON_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.LIME_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.MAHOGANY_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.MAPLE_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.OLIVE_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.ORANGE_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.PEACH_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.PEAR_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.PLUM_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.REDWOOD_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.ROSEWOOD_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.RUBBER_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.TEAK_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.WALNUT_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.ZEBRAWOOD_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.ALCHEMICAL_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.BENEVOLENT_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.CONDUCTIVE_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.FROSTBITTEN_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.FRUITFUL_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.INFERNAL_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.MALEVOLENT_WALL_SIGN.get());
		dropSelf(TechnologicaBlocks.NECROTIC_WALL_SIGN.get());
		
		automaticLootTable(TechnologicaBlocks.BLOCKS.getEntries());
		
		
		
		add(TechnologicaBlocks.LITHIUM_CLAY.get(), (clay) -> createSingleItemTableWithSilkTouch(clay, TechnologicaItems.LITHIUM_CLAY_BALL.get(), ConstantValue.exactly(4)));
		dropSelf(TechnologicaBlocks.SALT.get());
		dropOther(TechnologicaBlocks.MULCH.get(), Blocks.DIRT);
		
		dropSelf(TechnologicaBlocks.LINE_SHAFT_HANGER.get());
		dropOther(TechnologicaBlocks.LINE_SHAFT.get(), TechnologicaItems.STEEL_SHAFT.get());
		dropOther(TechnologicaBlocks.NAVAL_MINE_CHAIN.get(), Items.CHAIN);
		dropSelf(TechnologicaBlocks.SMALL_PULLEY.get());
		dropSelf(TechnologicaBlocks.MEDIUM_PULLEY.get());
		dropSelf(TechnologicaBlocks.LARGE_PULLEY.get());
		dropSelf(TechnologicaBlocks.MOTOR_1HP.get());
		dropSelf(TechnologicaBlocks.MOTOR_5HP.get());
		dropSelf(TechnologicaBlocks.MOTOR_20HP.get());
		
		dropSelf(TechnologicaBlocks.DISPLAY_CASE.get());
		dropSelf(TechnologicaBlocks.ANNUNCIATOR.get());
	}
	
	private void dropSelf(Item item) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Iterates through a deferred register of blocks, generating loot tables for each applicable entry.
	 * This is primarily only intended as a time save for two use cases: 
	 * mod blocks with loot tables which replicate vanilla loot tables 
	 * and mod blocks which have multiple entries with identically formatted loot tables.  
	 * All other cases should be handled as exceptions.
	 * Primary evaluation criteria is a block's class, with secondary evaluation criteria being translation key when the primary criteria is not enough to positively identify the appropriate loot table. 
	 * @param collection a collection of block deferred registry entries
	 */
	
	private final void automaticLootTable(Collection<RegistryObject<Block>> blockCollection) {
		for(Supplier<? extends Block> blockSupplier:blockCollection) {
			Block block = blockSupplier.get();
			String path = ResourceLocationHelper.getPath(block);
			
			if (block instanceof RotatedPillarBlock) dropSelf(block);
			else if (block.getClass().equals(SaplingBlock.class)) dropSelf(block);
			else if (block.getClass().equals(FlowerPotBlock.class)) dropPottedContents(block);
			else if (block.getDescriptionId().contains("bookshelf")) add(block, (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
			else if (block.getClass().equals(DoorBlock.class)) add(block, BlockLoot::createDoorTable);
			else if (block.getClass().equals(TrapDoorBlock.class)) dropSelf(block);
			else if (block.getClass().equals(PressurePlateBlock.class)) dropSelf(block);
			else if (block.getClass().equals(WoodButtonBlock.class)) dropSelf(block);
			else if (block.getRegistryName().getPath().contains("ore")) dropSelf(block);
			else if (block.getClass().equals(TwentyFourDirectionBlock.class)) dropSelf(block);
			else if (block.getClass().equals(SapLogBlock.class)) dropSelf(block);
			else if (block.getClass().equals(ChairBlock.class)) dropSelf(block);
			else if (block.getClass().equals(TableBlock.class)) dropSelf(block);
			else if (block.getClass().equals(TreeTapBlock.class)) dropSelf(block);
			else if (block.getClass().equals(TreeTapBlock.class)) dropSelf(block);
			else if (block.getClass().equals(SawmillBlock.class)) dropSelf(block);
			
			
			else if (block.getClass().equals(FruitingLeavesBlock.class) || block.getClass().equals(LeavesBlock.class)) {
				Block sapling = Blocks.OAK_SAPLING;
				for(Supplier<? extends Block> blockSupplier2:blockCollection) {
					Block block2 = blockSupplier2.get();
					if (ResourceLocationHelper.replace(block.getRegistryName().getPath(), "leaves", "sapling").equals(block2.getRegistryName().getPath())) sapling = block2;
				}	
				add(block, createLeavesDrops(block, sapling, DEFAULT_SAPLING_DROP_RATES));
			} else if (!block.getClass().equals(FruitingLeavesBlock.class) && !block.getClass().equals(LeavesBlock.class) && block instanceof LeavesBlock) {
				dropSelf(block);
			} else if (path.contains("moon")) {
				dropSelf(block);
			}
		}
	}
	
	@Override
	protected Iterable<Block> getKnownBlocks() {
		return TechnologicaBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
	}
}
