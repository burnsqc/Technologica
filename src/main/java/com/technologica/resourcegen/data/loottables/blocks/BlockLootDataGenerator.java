package com.technologica.resourcegen.data.loottables.blocks;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.registration.deferred.TechnologicaItems;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.PotatoBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

public class BlockLootDataGenerator extends BlockLootSubProvider {
	private static final Set<Item> EXPLOSION_RESISTANT = Stream.of(Blocks.DRAGON_EGG, Blocks.BEACON, Blocks.CONDUIT, Blocks.SKELETON_SKULL, Blocks.WITHER_SKELETON_SKULL, Blocks.PLAYER_HEAD, Blocks.ZOMBIE_HEAD, Blocks.CREEPER_HEAD, Blocks.DRAGON_HEAD, Blocks.PIGLIN_HEAD, Blocks.SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX).map(ItemLike::asItem).collect(Collectors.toSet());
	private static final float[] DEFAULT_SAPLING_DROP_RATES = new float[] { 0.05F, 0.0625F, 0.083333336F, 0.1F };

	public BlockLootDataGenerator() {
		super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags());
	}

	@Override
	protected void generate() {
		this.add(TechnologicaBlocks.BARLEY.get(), createCropDrops(TechnologicaBlocks.BARLEY.get(), TechnologicaItems.BARLEY.get(), TechnologicaItems.BARLEY_SEEDS.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.BARLEY.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		this.add(TechnologicaBlocks.OATS.get(), createCropDrops(TechnologicaBlocks.OATS.get(), TechnologicaItems.OATS.get(), TechnologicaItems.OATS_SEEDS.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.OATS.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		this.add(TechnologicaBlocks.RYE.get(), createCropDrops(TechnologicaBlocks.RYE.get(), TechnologicaItems.RYE.get(), TechnologicaItems.RYE_SEEDS.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.RYE.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		this.add(TechnologicaBlocks.CORN.get(), createCropDrops(TechnologicaBlocks.CORN.get(), TechnologicaItems.CORN.get(), TechnologicaItems.CORN_SEEDS.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.CORN.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		this.add(TechnologicaBlocks.RICE.get(), createCropDrops(TechnologicaBlocks.RICE.get(), TechnologicaItems.RICE.get(), TechnologicaItems.RICE_SEEDS.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.RICE.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));

		this.add(TechnologicaBlocks.ASPARAGUS.get(), applyExplosionDecay(TechnologicaBlocks.ASPARAGUS.get(), LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(TechnologicaItems.ASPARAGUS.get()))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.ASPARAGUS.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PotatoBlock.AGE, 7))).add(LootItem.lootTableItem(TechnologicaItems.ASPARAGUS.get()).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))));
		this.add(TechnologicaBlocks.CHILI_PEPPERS.get(), applyExplosionDecay(TechnologicaBlocks.CHILI_PEPPERS.get(), LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(TechnologicaItems.CHILI_PEPPER.get()))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.CHILI_PEPPERS.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PotatoBlock.AGE, 7))).add(LootItem.lootTableItem(TechnologicaItems.CHILI_PEPPER.get()).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))));
		this.add(TechnologicaBlocks.COFFEE.get(), applyExplosionDecay(TechnologicaBlocks.COFFEE.get(), LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(TechnologicaItems.COFFEE_BEANS.get()))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.COFFEE.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PotatoBlock.AGE, 7))).add(LootItem.lootTableItem(TechnologicaItems.COFFEE_BEANS.get()).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))));
		this.add(TechnologicaBlocks.GARLIC.get(), applyExplosionDecay(TechnologicaBlocks.GARLIC.get(), LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(TechnologicaItems.GARLIC.get()))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.GARLIC.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PotatoBlock.AGE, 7))).add(LootItem.lootTableItem(TechnologicaItems.GARLIC.get()).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))));
		this.add(TechnologicaBlocks.GINGER.get(), applyExplosionDecay(TechnologicaBlocks.GINGER.get(), LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(TechnologicaItems.GINGER.get()))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.GINGER.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PotatoBlock.AGE, 7))).add(LootItem.lootTableItem(TechnologicaItems.GINGER.get()).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))));
		this.add(TechnologicaBlocks.PEAS.get(), applyExplosionDecay(TechnologicaBlocks.PEAS.get(), LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(TechnologicaItems.PEAS.get()))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.PEAS.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PotatoBlock.AGE, 7))).add(LootItem.lootTableItem(TechnologicaItems.PEAS.get()).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))));
		this.add(TechnologicaBlocks.PEANUTS.get(), applyExplosionDecay(TechnologicaBlocks.PEANUTS.get(), LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(TechnologicaItems.PEANUT.get()))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.PEANUTS.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PotatoBlock.AGE, 7))).add(LootItem.lootTableItem(TechnologicaItems.PEANUT.get()).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))));
		this.add(TechnologicaBlocks.RED_BEANS.get(), applyExplosionDecay(TechnologicaBlocks.RED_BEANS.get(), LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(TechnologicaItems.RED_BEANS.get()))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.RED_BEANS.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PotatoBlock.AGE, 7))).add(LootItem.lootTableItem(TechnologicaItems.RED_BEANS.get()).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))));
		this.add(TechnologicaBlocks.SOY_BEANS.get(), applyExplosionDecay(TechnologicaBlocks.SOY_BEANS.get(), LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(TechnologicaItems.SOY_BEANS.get()))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.SOY_BEANS.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PotatoBlock.AGE, 7))).add(LootItem.lootTableItem(TechnologicaItems.SOY_BEANS.get()).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))));
		this.add(TechnologicaBlocks.SWEET_POTATOES.get(), applyExplosionDecay(TechnologicaBlocks.SWEET_POTATOES.get(), LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(TechnologicaItems.SWEET_POTATO.get()))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.SWEET_POTATOES.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PotatoBlock.AGE, 7))).add(LootItem.lootTableItem(TechnologicaItems.SWEET_POTATO.get()).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))));

		this.add(TechnologicaBlocks.BROCCOLI.get(), createCropDrops(TechnologicaBlocks.BROCCOLI.get(), TechnologicaItems.BROCCOLI.get(), TechnologicaItems.BROCCOLI_SEEDS.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.BROCCOLI.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BeetrootBlock.AGE, 3))));
		this.add(TechnologicaBlocks.CELERY.get(), createCropDrops(TechnologicaBlocks.CELERY.get(), TechnologicaItems.CELERY.get(), TechnologicaItems.CELERY_SEEDS.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.CELERY.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BeetrootBlock.AGE, 3))));
		this.add(TechnologicaBlocks.LETTUCE.get(), createCropDrops(TechnologicaBlocks.LETTUCE.get(), TechnologicaItems.LETTUCE.get(), TechnologicaItems.LETTUCE_SEEDS.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.LETTUCE.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BeetrootBlock.AGE, 3))));
		this.add(TechnologicaBlocks.MUSTARD_GREENS.get(), createCropDrops(TechnologicaBlocks.MUSTARD_GREENS.get(), TechnologicaItems.MUSTARD_GREENS.get(), TechnologicaItems.MUSTARD_SEEDS.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.MUSTARD_GREENS.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BeetrootBlock.AGE, 3))));
		this.add(TechnologicaBlocks.PURPLE_CABBAGE.get(), createCropDrops(TechnologicaBlocks.PURPLE_CABBAGE.get(), TechnologicaItems.PURPLE_CABBAGE.get(), TechnologicaItems.PURPLE_CABBAGE_SEEDS.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.PURPLE_CABBAGE.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BeetrootBlock.AGE, 3))));
		this.add(TechnologicaBlocks.PINEAPPLES.get(), createCropDrops(TechnologicaBlocks.PINEAPPLES.get(), TechnologicaItems.PINEAPPLE.get(), TechnologicaItems.PINEAPPLE_SEEDS.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.PINEAPPLES.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BeetrootBlock.AGE, 3))));
		this.add(TechnologicaBlocks.ONIONS.get(), createCropDrops(TechnologicaBlocks.ONIONS.get(), TechnologicaItems.ONION.get(), TechnologicaItems.ONION_SEEDS.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.ONIONS.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BeetrootBlock.AGE, 3))));
		this.add(TechnologicaBlocks.RADISHES.get(), createCropDrops(TechnologicaBlocks.RADISHES.get(), TechnologicaItems.RADISH.get(), TechnologicaItems.RADISH_SEEDS.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.RADISHES.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BeetrootBlock.AGE, 3))));
		this.add(TechnologicaBlocks.TEA.get(), createCropDrops(TechnologicaBlocks.TEA.get(), TechnologicaItems.TEA_LEAF.get(), TechnologicaItems.TEA_SEEDS.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.TEA.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BeetrootBlock.AGE, 3))));
		this.add(TechnologicaBlocks.TURNIPS.get(), createCropDrops(TechnologicaBlocks.TURNIPS.get(), TechnologicaItems.TURNIP.get(), TechnologicaItems.TURNIP_SEEDS.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.TURNIPS.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BeetrootBlock.AGE, 3))));

		this.add(TechnologicaBlocks.BLACKBERRY_BUSH.get(), (bush) -> {
			return applyExplosionDecay(bush, LootTable.lootTable().withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(bush).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))).add(LootItem.lootTableItem(TechnologicaItems.BLACKBERRY.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(bush).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))).add(LootItem.lootTableItem(TechnologicaItems.BLACKBERRY.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
		});
		this.add(TechnologicaBlocks.BLUEBERRY_BUSH.get(), (bush) -> {
			return applyExplosionDecay(bush, LootTable.lootTable().withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(bush).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))).add(LootItem.lootTableItem(TechnologicaItems.BLUEBERRY.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(bush).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))).add(LootItem.lootTableItem(TechnologicaItems.BLUEBERRY.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
		});
		this.add(TechnologicaBlocks.RASPBERRY_BUSH.get(), (bush) -> {
			return applyExplosionDecay(bush, LootTable.lootTable().withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(bush).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))).add(LootItem.lootTableItem(TechnologicaItems.RASPBERRY.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(bush).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))).add(LootItem.lootTableItem(TechnologicaItems.RASPBERRY.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
		});
		this.add(TechnologicaBlocks.STRAWBERRY_BUSH.get(), (bush) -> {
			return applyExplosionDecay(bush, LootTable.lootTable().withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(bush).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))).add(LootItem.lootTableItem(TechnologicaItems.STRAWBERRY.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(bush).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))).add(LootItem.lootTableItem(TechnologicaItems.STRAWBERRY.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
		});

		this.add(TechnologicaBlocks.CUCUMBERS.get(), applyExplosionDecay(TechnologicaBlocks.CUCUMBERS.get(), LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(TechnologicaItems.CUCUMBER.get()))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(TechnologicaItems.CUCUMBER.get()).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))));
		this.add(TechnologicaBlocks.CUCUMBER_STEM.get(), (p_124319_) -> {
			return createStemDrops(p_124319_, TechnologicaItems.CUCUMBER_SEEDS.get());
		});
		this.add(TechnologicaBlocks.ATTACHED_CUCUMBER_STEM.get(), (p_124317_) -> {
			return createAttachedStemDrops(p_124317_, TechnologicaItems.CUCUMBER_SEEDS.get());
		});

		this.add(TechnologicaBlocks.SQUASH.get(), applyExplosionDecay(TechnologicaBlocks.SQUASH.get(), LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(TechnologicaItems.SQUASH.get()))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(TechnologicaItems.SQUASH.get()).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))));
		this.add(TechnologicaBlocks.SQUASH_STEM.get(), (p_124319_) -> {
			return createStemDrops(p_124319_, TechnologicaItems.SQUASH_SEEDS.get());
		});
		this.add(TechnologicaBlocks.ATTACHED_SQUASH_STEM.get(), (p_124317_) -> {
			return createAttachedStemDrops(p_124317_, TechnologicaItems.SQUASH_SEEDS.get());
		});

		this.add(TechnologicaBlocks.ZUCCHINI.get(), applyExplosionDecay(TechnologicaBlocks.ZUCCHINI.get(), LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(TechnologicaItems.ZUCCHINI.get()))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(TechnologicaItems.ZUCCHINI.get()).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))));
		this.add(TechnologicaBlocks.ZUCCHINI_STEM.get(), (p_124319_) -> {
			return createStemDrops(p_124319_, TechnologicaItems.ZUCCHINI_SEEDS.get());
		});
		this.add(TechnologicaBlocks.ATTACHED_ZUCCHINI_STEM.get(), (p_124317_) -> {
			return createAttachedStemDrops(p_124317_, TechnologicaItems.ZUCCHINI_SEEDS.get());
		});

		add(TechnologicaBlocks.COTTON_BUSH.get(), createCropDrops(TechnologicaBlocks.COTTON_BUSH.get(), TechnologicaItems.COTTON.get(), TechnologicaBlocks.COTTON_BUSH.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.COTTON_BUSH.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.CRANBERRY_CROP.get(), createCropDrops(TechnologicaBlocks.CRANBERRY_CROP.get(), TechnologicaItems.CRANBERRY.get(), TechnologicaBlocks.CRANBERRY_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.CRANBERRY_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.GRAPES.get(), createCropDrops(TechnologicaBlocks.GRAPES.get(), TechnologicaItems.GRAPE.get(), TechnologicaBlocks.GRAPES.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.GRAPES.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.PEPPERCORNS.get(), createCropDrops(TechnologicaBlocks.PEPPERCORNS.get(), TechnologicaItems.PEPPERCORNS.get(), TechnologicaBlocks.PEPPERCORNS.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.PEPPERCORNS.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.TOMATOES.get(), createCropDrops(TechnologicaBlocks.TOMATOES.get(), TechnologicaItems.TOMATO.get(), TechnologicaBlocks.TOMATOES.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.TOMATOES.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));

		dropSelf(TechnologicaBlocks.APRICOT_SAPLING.get());
		dropSelf(TechnologicaBlocks.ASPEN_SAPLING.get());
		dropSelf(TechnologicaBlocks.AVOCADO_SAPLING.get());
		dropSelf(TechnologicaBlocks.BANANA_SAPLING.get());
		dropSelf(TechnologicaBlocks.CHERRY_SAPLING.get());
		dropSelf(TechnologicaBlocks.CHESTNUT_SAPLING.get());
		dropSelf(TechnologicaBlocks.CINNAMON_SAPLING.get());
		dropSelf(TechnologicaBlocks.COCONUT_SAPLING.get());
		dropSelf(TechnologicaBlocks.EBONY_SAPLING.get());
		dropSelf(TechnologicaBlocks.KIWI_SAPLING.get());
		dropSelf(TechnologicaBlocks.LEMON_SAPLING.get());
		dropSelf(TechnologicaBlocks.LIME_SAPLING.get());
		dropSelf(TechnologicaBlocks.MAHOGANY_SAPLING.get());
		dropSelf(TechnologicaBlocks.MAPLE_SAPLING.get());
		dropSelf(TechnologicaBlocks.OLIVE_SAPLING.get());
		dropSelf(TechnologicaBlocks.ORANGE_SAPLING.get());
		dropSelf(TechnologicaBlocks.PEACH_SAPLING.get());
		dropSelf(TechnologicaBlocks.PEAR_SAPLING.get());
		dropSelf(TechnologicaBlocks.PLUM_SAPLING.get());
		dropSelf(TechnologicaBlocks.REDWOOD_SAPLING.get());
		dropSelf(TechnologicaBlocks.ROSEWOOD_SAPLING.get());
		dropSelf(TechnologicaBlocks.RUBBER_SAPLING.get());
		dropSelf(TechnologicaBlocks.TEAK_SAPLING.get());
		dropSelf(TechnologicaBlocks.WALNUT_SAPLING.get());
		dropSelf(TechnologicaBlocks.ZEBRAWOOD_SAPLING.get());
		dropSelf(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_SAPLING.get());
		dropSelf(TechnologicaBlocks.BENEVOLENT_APOTHECARY_SAPLING.get());
		dropSelf(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_SAPLING.get());
		dropSelf(TechnologicaBlocks.CRYOGENIC_SPIRE_SAPLING.get());
		dropSelf(TechnologicaBlocks.ANCIENT_AMBROSIA_SAPLING.get());
		dropSelf(TechnologicaBlocks.TOWERING_INFERNO_SAPLING.get());
		dropSelf(TechnologicaBlocks.MALEVOLENT_APOTHECARY_SAPLING.get());
		dropSelf(TechnologicaBlocks.NECROTIC_SAPLING.get());

		dropPottedContents(TechnologicaBlocks.POTTED_APRICOT_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_ASPEN_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_AVOCADO_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_BANANA_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_CHERRY_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_CHESTNUT_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_CINNAMON_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_COCONUT_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_EBONY_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_KIWI_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_LEMON_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_LIME_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_MAHOGANY_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_MAPLE_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_OLIVE_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_ORANGE_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_PEACH_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_PEAR_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_PLUM_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_REDWOOD_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_ROSEWOOD_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_RUBBER_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_TEAK_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_WALNUT_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_ZEBRAWOOD_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_SERENDIPITOUS_APOTHECARY_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_BENEVOLENT_APOTHECARY_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_THUNDEROUS_CONDUCTOR_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_CRYOGENIC_SPIRE_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_ANCIENT_AMBROSIA_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_TOWERING_INFERNO_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_MALEVOLENT_APOTHECARY_SAPLING.get());
		dropPottedContents(TechnologicaBlocks.POTTED_NECROTIC_SAPLING.get());

		add(TechnologicaBlocks.APRICOT_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.APRICOT_LEAVES.get(), TechnologicaBlocks.APRICOT_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.ASPEN_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.ASPEN_LEAVES.get(), TechnologicaBlocks.ASPEN_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.AVOCADO_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.AVOCADO_LEAVES.get(), TechnologicaBlocks.AVOCADO_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.BANANA_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.BANANA_LEAVES.get(), TechnologicaBlocks.BANANA_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.CHERRY_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.CHERRY_LEAVES.get(), TechnologicaBlocks.CHERRY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.CHESTNUT_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.CHESTNUT_LEAVES.get(), TechnologicaBlocks.CHESTNUT_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.CINNAMON_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.CINNAMON_LEAVES.get(), TechnologicaBlocks.CINNAMON_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.COCONUT_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.COCONUT_LEAVES.get(), TechnologicaBlocks.COCONUT_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.EBONY_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.EBONY_LEAVES.get(), TechnologicaBlocks.EBONY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.KIWI_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.KIWI_LEAVES.get(), TechnologicaBlocks.KIWI_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.LEMON_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.LEMON_LEAVES.get(), TechnologicaBlocks.LEMON_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.LIME_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.LIME_LEAVES.get(), TechnologicaBlocks.LIME_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.MAHOGANY_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.MAHOGANY_LEAVES.get(), TechnologicaBlocks.MAHOGANY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.MAPLE_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.MAPLE_LEAVES.get(), TechnologicaBlocks.MAPLE_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.OLIVE_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.OLIVE_LEAVES.get(), TechnologicaBlocks.OLIVE_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.ORANGE_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.ORANGE_LEAVES.get(), TechnologicaBlocks.ORANGE_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.PEACH_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.PEACH_LEAVES.get(), TechnologicaBlocks.PEACH_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.PEAR_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.PEAR_LEAVES.get(), TechnologicaBlocks.PEAR_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.PLUM_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.PLUM_LEAVES.get(), TechnologicaBlocks.PLUM_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.REDWOOD_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.REDWOOD_LEAVES.get(), TechnologicaBlocks.REDWOOD_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.ROSEWOOD_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.ROSEWOOD_LEAVES.get(), TechnologicaBlocks.ROSEWOOD_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.RUBBER_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.RUBBER_LEAVES.get(), TechnologicaBlocks.RUBBER_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.TEAK_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.TEAK_LEAVES.get(), TechnologicaBlocks.TEAK_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.WALNUT_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.WALNUT_LEAVES.get(), TechnologicaBlocks.WALNUT_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.ZEBRAWOOD_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.ZEBRAWOOD_LEAVES.get(), TechnologicaBlocks.ZEBRAWOOD_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.ALCHEMICAL_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.ALCHEMICAL_LEAVES.get(), TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.BENEVOLENT_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.BENEVOLENT_LEAVES.get(), TechnologicaBlocks.BENEVOLENT_APOTHECARY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.CONDUCTIVE_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.CONDUCTIVE_LEAVES.get(), TechnologicaBlocks.THUNDEROUS_CONDUCTOR_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.FROSTBITTEN_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.FROSTBITTEN_LEAVES.get(), TechnologicaBlocks.CRYOGENIC_SPIRE_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.FRUITFUL_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.FRUITFUL_LEAVES.get(), TechnologicaBlocks.ANCIENT_AMBROSIA_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.MALEVOLENT_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.MALEVOLENT_LEAVES.get(), TechnologicaBlocks.MALEVOLENT_APOTHECARY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		add(TechnologicaBlocks.CURSED_LEAVES.get(), createLeavesDrops(TechnologicaBlocks.CURSED_LEAVES.get(), TechnologicaBlocks.NECROTIC_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));

		this.add(TechnologicaBlocks.GLUE.get(), noDrop());
		this.add(TechnologicaBlocks.LAND_MINE.get(), noDrop());

		dropOther(TechnologicaBlocks.MULCH.get(), Blocks.DIRT);
		dropSelf(TechnologicaBlocks.TRELLIS.get());

		dropSelf(TechnologicaBlocks.SALT.get());
		add(TechnologicaBlocks.LITHIUM_CLAY.get(), (clay) -> createSingleItemTableWithSilkTouch(clay, TechnologicaItems.LITHIUM_CLAY_BALL.get(), ConstantValue.exactly(4)));
		add(TechnologicaBlocks.OILY_COARSE_DIRT.get(), (clay) -> createSingleItemTableWithSilkTouch(clay, Items.COARSE_DIRT, ConstantValue.exactly(1)));
		add(TechnologicaBlocks.OILY_GRAVEL.get(), (clay) -> createSingleItemTableWithSilkTouch(clay, Items.GRAVEL, ConstantValue.exactly(1)));
		add(TechnologicaBlocks.OILY_RED_SAND.get(), (clay) -> createSingleItemTableWithSilkTouch(clay, Items.RED_SAND, ConstantValue.exactly(1)));
		add(TechnologicaBlocks.OILY_SAND.get(), (clay) -> createSingleItemTableWithSilkTouch(clay, Items.SAND, ConstantValue.exactly(1)));

		dropSelf(TechnologicaBlocks.MOON_ROCK.get());
		dropSelf(TechnologicaBlocks.MOON_DUST.get());

		dropSelf(TechnologicaBlocks.APATITE_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_APATITE_ORE.get());
		dropSelf(TechnologicaBlocks.ARGENTITE_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_ARGENTITE_ORE.get());
		dropSelf(TechnologicaBlocks.NETHER_ARGENTITE_ORE.get());
		dropSelf(TechnologicaBlocks.ARSENOPYRITE_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_ARSENOPYRITE_ORE.get());
		dropSelf(TechnologicaBlocks.BASTNAESITE_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_BASTNAESITE_ORE.get());
		dropSelf(TechnologicaBlocks.BAUXITE_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_BAUXITE_ORE.get());
		dropSelf(TechnologicaBlocks.BORAX_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_BORAX_ORE.get());
		dropSelf(TechnologicaBlocks.CASSITERITE_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_CASSITERITE_ORE.get());
		dropSelf(TechnologicaBlocks.CHROMITE_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_CHROMITE_ORE.get());
		dropSelf(TechnologicaBlocks.CINNABAR_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_CINNABAR_ORE.get());
		dropSelf(TechnologicaBlocks.COBALTITE_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_COBALTITE_ORE.get());
		dropSelf(TechnologicaBlocks.CROOKESITE_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_CROOKESITE_ORE.get());
		dropSelf(TechnologicaBlocks.GADOLINITE_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_GADOLINITE_ORE.get());
		dropSelf(TechnologicaBlocks.GALENA_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_GALENA_ORE.get());
		dropSelf(TechnologicaBlocks.GARNIERITE_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_GARNIERITE_ORE.get());
		dropSelf(TechnologicaBlocks.ILMENITE_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_ILMENITE_ORE.get());
		dropSelf(TechnologicaBlocks.LEPIDOLITE_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_LEPIDOLITE_ORE.get());
		dropSelf(TechnologicaBlocks.MAGNESITE_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_MAGNESITE_ORE.get());
		dropSelf(TechnologicaBlocks.MOLYBDENITE_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_MOLYBDENITE_ORE.get());
		dropSelf(TechnologicaBlocks.OSMIRIDIUM_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_OSMIRIDIUM_ORE.get());
		dropSelf(TechnologicaBlocks.NETHER_OSMIRIDIUM_ORE.get());
		dropSelf(TechnologicaBlocks.PATRONITE_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_PATRONITE_ORE.get());
		dropSelf(TechnologicaBlocks.PENTLANDITE_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_PENTLANDITE_ORE.get());
		dropSelf(TechnologicaBlocks.PHOSPHORITE_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_PHOSPHORITE_ORE.get());
		dropSelf(TechnologicaBlocks.PLATINUM_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_PLATINUM_ORE.get());
		dropSelf(TechnologicaBlocks.NETHER_PLATINUM_ORE.get());
		dropSelf(TechnologicaBlocks.PYROLUSITE_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_PYROLUSITE_ORE.get());
		this.add(TechnologicaBlocks.RUBY_ORE.get(), (block) -> {
			return this.createOreDrop(block, TechnologicaItems.RUBY.get());
		});
		this.add(TechnologicaBlocks.DEEPSLATE_RUBY_ORE.get(), (block) -> {
			return this.createOreDrop(block, TechnologicaItems.RUBY.get());
		});
		this.add(TechnologicaBlocks.SAPPHIRE_ORE.get(), (block) -> {
			return this.createOreDrop(block, TechnologicaItems.SAPPHIRE.get());
		});
		this.add(TechnologicaBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), (block) -> {
			return this.createOreDrop(block, TechnologicaItems.SAPPHIRE.get());
		});
		dropSelf(TechnologicaBlocks.SPODUMENE_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_SPODUMENE_ORE.get());
		dropSelf(TechnologicaBlocks.SYLVANITE_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_SYLVANITE_ORE.get());
		dropSelf(TechnologicaBlocks.NETHER_SYLVANITE_ORE.get());
		dropSelf(TechnologicaBlocks.TANTALITE_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_TANTALITE_ORE.get());
		dropSelf(TechnologicaBlocks.THORIANITE_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_THORIANITE_ORE.get());
		this.add(TechnologicaBlocks.TOPAZ_ORE.get(), (block) -> {
			return this.createOreDrop(block, TechnologicaItems.TOPAZ.get());
		});
		this.add(TechnologicaBlocks.DEEPSLATE_TOPAZ_ORE.get(), (block) -> {
			return this.createOreDrop(block, TechnologicaItems.TOPAZ.get());
		});
		dropSelf(TechnologicaBlocks.URANINITE_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_URANINITE_ORE.get());
		dropSelf(TechnologicaBlocks.WOLFRAMITE_ORE.get());
		dropSelf(TechnologicaBlocks.DEEPSLATE_WOLFRAMITE_ORE.get());

		dropSelf(TechnologicaBlocks.AUTUNITE_CRYSTAL.get());
		dropSelf(TechnologicaBlocks.AQUAMARINE_CRYSTAL.get());
		dropSelf(TechnologicaBlocks.BARYTE_CRYSTAL.get());
		dropSelf(TechnologicaBlocks.BISMITHUNITE_CRYSTAL.get());
		dropSelf(TechnologicaBlocks.CELESTINE_CRYSTAL.get());
		dropSelf(TechnologicaBlocks.COLUMBITE_CRYSTAL.get());
		dropSelf(TechnologicaBlocks.DOLOMITE_CRYSTAL.get());
		dropSelf(TechnologicaBlocks.FLUORITE_CRYSTAL.get());
		dropSelf(TechnologicaBlocks.HUTCHINSONITE_CRYSTAL.get());
		dropSelf(TechnologicaBlocks.MONAZITE_CRYSTAL.get());
		dropSelf(TechnologicaBlocks.POLLUCITE_CRYSTAL.get());
		dropSelf(TechnologicaBlocks.RUTILE_CRYSTAL.get());
		dropSelf(TechnologicaBlocks.SCHEELITE_CRYSTAL.get());
		dropSelf(TechnologicaBlocks.SPHALERITE_CRYSTAL.get());
		dropSelf(TechnologicaBlocks.STIBNITE_CRYSTAL.get());
		dropSelf(TechnologicaBlocks.STRONTIANITE_CRYSTAL.get());
		dropSelf(TechnologicaBlocks.TELLURITE_CRYSTAL.get());
		dropSelf(TechnologicaBlocks.ULEXITE_CRYSTAL.get());
		dropSelf(TechnologicaBlocks.VANADINITE_CRYSTAL.get());
		dropSelf(TechnologicaBlocks.WULFENITE_CRYSTAL.get());
		dropSelf(TechnologicaBlocks.XENOTIME_CRYSTAL.get());
		dropSelf(TechnologicaBlocks.ZIRCON_CRYSTAL.get());

		dropSelf(TechnologicaBlocks.BLOCK_OF_RUBY.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_SAPPHIRE.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_TOPAZ.get());

		dropSelf(TechnologicaBlocks.BLOCK_OF_LITHIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_BERYLLIUM.get());

		dropSelf(TechnologicaBlocks.BLOCK_OF_ALUMINUM.get());

		dropSelf(TechnologicaBlocks.BLOCK_OF_TITANIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_VANADIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_CHROMIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_MANGANESE.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_COBALT.get());

		dropSelf(TechnologicaBlocks.BLOCK_OF_NICKEL.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_ZINC.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_GALLIUM.get());

		dropSelf(TechnologicaBlocks.BLOCK_OF_ZIRCONIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_NIOBIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_MOLYBDENUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_TECHNETIUM.get());

		dropSelf(TechnologicaBlocks.BLOCK_OF_RUTHENIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_RHODIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_PALLADIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_SILVER.get());

		dropSelf(TechnologicaBlocks.BLOCK_OF_CADMIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_INDIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_TIN.get());

		dropSelf(TechnologicaBlocks.BLOCK_OF_HAFNIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_TANTALUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_TUNGSTEN.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_RHENIUM.get());

		dropSelf(TechnologicaBlocks.BLOCK_OF_OSMIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_IRIDIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_PLATINUM.get());

		dropSelf(TechnologicaBlocks.BLOCK_OF_THALLUIM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_LEAD.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_BISMUTH.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_POLONIUM.get());

		dropSelf(TechnologicaBlocks.BLOCK_OF_ACTINIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_THORIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_PROTACTINIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_URANIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_NEPTUNIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_PLUTONIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_AMERICIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_CURIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_BERKELLIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_CALIFORNIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_EINSTEINIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_FERMIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_LAWRENCIUM.get());

		dropSelf(TechnologicaBlocks.BLOCK_OF_BRONZE.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_BRASS.get());

		dropSelf(TechnologicaBlocks.BLOCK_OF_BORON.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_CARBON.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_SILICON.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_PHOSPHORUS.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_SULFUR.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_GERMANIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_ARSENIC.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_SELENIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_ANTIMONY.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_TELLURIUM.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_IODINE.get());
		dropSelf(TechnologicaBlocks.BLOCK_OF_ASTATINE.get());

		dropSelf(TechnologicaBlocks.APRICOT_LOG.get());
		dropSelf(TechnologicaBlocks.ASPEN_LOG.get());
		dropSelf(TechnologicaBlocks.AVOCADO_LOG.get());
		dropSelf(TechnologicaBlocks.BANANA_LOG.get());
		dropSelf(TechnologicaBlocks.CHERRY_LOG.get());
		dropSelf(TechnologicaBlocks.CHESTNUT_LOG.get());
		dropSelf(TechnologicaBlocks.CINNAMON_LOG.get());
		dropSelf(TechnologicaBlocks.COCONUT_LOG.get());
		dropSelf(TechnologicaBlocks.EBONY_LOG.get());
		dropSelf(TechnologicaBlocks.KIWI_LOG.get());
		dropSelf(TechnologicaBlocks.LEMON_LOG.get());
		dropSelf(TechnologicaBlocks.LIME_LOG.get());
		dropSelf(TechnologicaBlocks.MAHOGANY_LOG.get());
		dropSelf(TechnologicaBlocks.MAPLE_LOG.get());
		dropSelf(TechnologicaBlocks.OLIVE_LOG.get());
		dropSelf(TechnologicaBlocks.ORANGE_LOG.get());
		dropSelf(TechnologicaBlocks.PEACH_LOG.get());
		dropSelf(TechnologicaBlocks.PEAR_LOG.get());
		dropSelf(TechnologicaBlocks.PLUM_LOG.get());
		dropSelf(TechnologicaBlocks.REDWOOD_LOG.get());
		dropSelf(TechnologicaBlocks.ROSEWOOD_LOG.get());
		dropSelf(TechnologicaBlocks.RUBBER_LOG.get());
		dropSelf(TechnologicaBlocks.TEAK_LOG.get());
		dropSelf(TechnologicaBlocks.WALNUT_LOG.get());
		dropSelf(TechnologicaBlocks.ZEBRAWOOD_LOG.get());
		dropSelf(TechnologicaBlocks.ALCHEMICAL_LOG.get());
		dropSelf(TechnologicaBlocks.BENEVOLENT_LOG.get());
		dropSelf(TechnologicaBlocks.CONDUCTIVE_LOG.get());
		dropSelf(TechnologicaBlocks.FROSTBITTEN_LOG.get());
		dropSelf(TechnologicaBlocks.FRUITFUL_LOG.get());
		dropSelf(TechnologicaBlocks.INFERNAL_LOG.get());
		dropSelf(TechnologicaBlocks.MALEVOLENT_LOG.get());
		dropSelf(TechnologicaBlocks.NECROTIC_LOG.get());

		dropSelf(TechnologicaBlocks.STRIPPED_APRICOT_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_ASPEN_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_AVOCADO_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_BANANA_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_CHERRY_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_CHESTNUT_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_CINNAMON_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_COCONUT_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_EBONY_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_KIWI_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_LEMON_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_LIME_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_MAHOGANY_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_MAPLE_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_OLIVE_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_ORANGE_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_PEACH_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_PEAR_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_PLUM_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_REDWOOD_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_ROSEWOOD_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_RUBBER_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_TEAK_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_WALNUT_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_ZEBRAWOOD_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_ALCHEMICAL_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_BENEVOLENT_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_CONDUCTIVE_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_FROSTBITTEN_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_FRUITFUL_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_INFERNAL_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_MALEVOLENT_LOG.get());
		dropSelf(TechnologicaBlocks.STRIPPED_NECROTIC_LOG.get());

		dropSelf(TechnologicaBlocks.APRICOT_WOOD.get());
		dropSelf(TechnologicaBlocks.ASPEN_WOOD.get());
		dropSelf(TechnologicaBlocks.AVOCADO_WOOD.get());
		dropSelf(TechnologicaBlocks.BANANA_WOOD.get());
		dropSelf(TechnologicaBlocks.CHERRY_WOOD.get());
		dropSelf(TechnologicaBlocks.CHESTNUT_WOOD.get());
		dropSelf(TechnologicaBlocks.CINNAMON_WOOD.get());
		dropSelf(TechnologicaBlocks.COCONUT_WOOD.get());
		dropSelf(TechnologicaBlocks.EBONY_WOOD.get());
		dropSelf(TechnologicaBlocks.KIWI_WOOD.get());
		dropSelf(TechnologicaBlocks.LEMON_WOOD.get());
		dropSelf(TechnologicaBlocks.LIME_WOOD.get());
		dropSelf(TechnologicaBlocks.MAHOGANY_WOOD.get());
		dropSelf(TechnologicaBlocks.MAPLE_WOOD.get());
		dropSelf(TechnologicaBlocks.OLIVE_WOOD.get());
		dropSelf(TechnologicaBlocks.ORANGE_WOOD.get());
		dropSelf(TechnologicaBlocks.PEACH_WOOD.get());
		dropSelf(TechnologicaBlocks.PEAR_WOOD.get());
		dropSelf(TechnologicaBlocks.PLUM_WOOD.get());
		dropSelf(TechnologicaBlocks.REDWOOD_WOOD.get());
		dropSelf(TechnologicaBlocks.ROSEWOOD_WOOD.get());
		dropSelf(TechnologicaBlocks.RUBBER_WOOD.get());
		dropSelf(TechnologicaBlocks.TEAK_WOOD.get());
		dropSelf(TechnologicaBlocks.WALNUT_WOOD.get());
		dropSelf(TechnologicaBlocks.ZEBRAWOOD_WOOD.get());
		dropSelf(TechnologicaBlocks.ALCHEMICAL_WOOD.get());
		dropSelf(TechnologicaBlocks.BENEVOLENT_WOOD.get());
		dropSelf(TechnologicaBlocks.CONDUCTIVE_WOOD.get());
		dropSelf(TechnologicaBlocks.FROSTBITTEN_WOOD.get());
		dropSelf(TechnologicaBlocks.FRUITFUL_WOOD.get());
		dropSelf(TechnologicaBlocks.INFERNAL_WOOD.get());
		dropSelf(TechnologicaBlocks.MALEVOLENT_WOOD.get());
		dropSelf(TechnologicaBlocks.NECROTIC_WOOD.get());

		dropSelf(TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_ASPEN_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_AVOCADO_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_BANANA_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_CHERRY_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_CHESTNUT_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_CINNAMON_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_COCONUT_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_EBONY_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_KIWI_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_LEMON_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_LIME_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_MAHOGANY_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_MAPLE_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_OLIVE_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_ORANGE_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_PEACH_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_PEAR_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_PLUM_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_REDWOOD_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_ROSEWOOD_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_RUBBER_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_TEAK_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_WALNUT_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_ZEBRAWOOD_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_ALCHEMICAL_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_BENEVOLENT_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_CONDUCTIVE_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_FROSTBITTEN_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_FRUITFUL_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_INFERNAL_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_MALEVOLENT_WOOD.get());
		dropSelf(TechnologicaBlocks.STRIPPED_NECROTIC_WOOD.get());

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

		this.add(TechnologicaBlocks.APRICOT_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.ASPEN_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.AVOCADO_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.BANANA_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.CHERRY_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.CHESTNUT_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.CINNAMON_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.COCONUT_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.EBONY_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.KIWI_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.LEMON_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.LIME_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.MAHOGANY_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.MAPLE_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.OLIVE_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.ORANGE_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.PEACH_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.PEAR_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.PLUM_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.REDWOOD_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.ROSEWOOD_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.RUBBER_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.TEAK_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.WALNUT_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.ZEBRAWOOD_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.ALCHEMICAL_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.BENEVOLENT_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.CONDUCTIVE_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.FROSTBITTEN_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.FRUITFUL_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.INFERNAL_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.MALEVOLENT_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});
		this.add(TechnologicaBlocks.NECROTIC_SLAB.get(), (p_251629_) -> {
			return this.createSlabItemTable(p_251629_);
		});

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

		add(TechnologicaBlocks.SPRUCE_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.BIRCH_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.JUNGLE_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.ACACIA_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.DARK_OAK_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.CRIMSON_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.WARPED_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.APRICOT_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.ASPEN_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.AVOCADO_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.BANANA_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.CHERRY_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.CHESTNUT_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.CINNAMON_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.COCONUT_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.EBONY_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.KIWI_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.LEMON_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.LIME_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.MAHOGANY_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.MAPLE_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.OLIVE_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.ORANGE_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.PEACH_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.PEAR_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.PLUM_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.REDWOOD_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.ROSEWOOD_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.RUBBER_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.TEAK_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.WALNUT_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.ZEBRAWOOD_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.ALCHEMICAL_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.BENEVOLENT_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.CONDUCTIVE_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.FROSTBITTEN_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.FRUITFUL_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.INFERNAL_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.MALEVOLENT_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
		add(TechnologicaBlocks.NECROTIC_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));

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

		this.add(TechnologicaBlocks.APRICOT_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.ASPEN_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.AVOCADO_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.BANANA_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.CHERRY_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.CHESTNUT_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.CINNAMON_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.COCONUT_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.EBONY_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.KIWI_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.LEMON_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.LIME_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.MAHOGANY_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.MAPLE_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.OLIVE_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.ORANGE_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.PEACH_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.PEAR_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.PLUM_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.REDWOOD_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.ROSEWOOD_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.RUBBER_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.TEAK_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.WALNUT_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.ZEBRAWOOD_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.ALCHEMICAL_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.BENEVOLENT_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.CONDUCTIVE_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.FROSTBITTEN_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.FRUITFUL_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.INFERNAL_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.MALEVOLENT_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});
		this.add(TechnologicaBlocks.NECROTIC_DOOR.get(), (p_251623_) -> {
			return this.createDoorTable(p_251623_);
		});

		dropSelf(TechnologicaBlocks.APRICOT_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.ASPEN_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.AVOCADO_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.BANANA_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.CHERRY_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.CHESTNUT_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.CINNAMON_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.COCONUT_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.EBONY_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.KIWI_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.LEMON_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.LIME_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.MAHOGANY_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.MAPLE_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.OLIVE_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.ORANGE_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.PEACH_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.PEAR_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.PLUM_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.REDWOOD_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.ROSEWOOD_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.RUBBER_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.TEAK_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.WALNUT_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.ZEBRAWOOD_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.ALCHEMICAL_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.BENEVOLENT_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.CONDUCTIVE_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.FROSTBITTEN_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.FRUITFUL_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.INFERNAL_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.MALEVOLENT_TRAPDOOR.get());
		dropSelf(TechnologicaBlocks.NECROTIC_TRAPDOOR.get());

		dropSelf(TechnologicaBlocks.APRICOT_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.ASPEN_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.AVOCADO_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.BANANA_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.CHERRY_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.CHESTNUT_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.CINNAMON_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.COCONUT_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.EBONY_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.KIWI_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.LEMON_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.LIME_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.MAHOGANY_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.MAPLE_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.OLIVE_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.ORANGE_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.PEACH_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.PEAR_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.PLUM_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.REDWOOD_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.ROSEWOOD_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.RUBBER_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.TEAK_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.WALNUT_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.ZEBRAWOOD_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.ALCHEMICAL_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.BENEVOLENT_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.CONDUCTIVE_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.FROSTBITTEN_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.FRUITFUL_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.INFERNAL_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.MALEVOLENT_PRESSURE_PLATE.get());
		dropSelf(TechnologicaBlocks.NECROTIC_PRESSURE_PLATE.get());

		dropSelf(TechnologicaBlocks.APRICOT_BUTTON.get());
		dropSelf(TechnologicaBlocks.ASPEN_BUTTON.get());
		dropSelf(TechnologicaBlocks.AVOCADO_BUTTON.get());
		dropSelf(TechnologicaBlocks.BANANA_BUTTON.get());
		dropSelf(TechnologicaBlocks.CHERRY_BUTTON.get());
		dropSelf(TechnologicaBlocks.CHESTNUT_BUTTON.get());
		dropSelf(TechnologicaBlocks.CINNAMON_BUTTON.get());
		dropSelf(TechnologicaBlocks.COCONUT_BUTTON.get());
		dropSelf(TechnologicaBlocks.EBONY_BUTTON.get());
		dropSelf(TechnologicaBlocks.KIWI_BUTTON.get());
		dropSelf(TechnologicaBlocks.LEMON_BUTTON.get());
		dropSelf(TechnologicaBlocks.LIME_BUTTON.get());
		dropSelf(TechnologicaBlocks.MAHOGANY_BUTTON.get());
		dropSelf(TechnologicaBlocks.MAPLE_BUTTON.get());
		dropSelf(TechnologicaBlocks.OLIVE_BUTTON.get());
		dropSelf(TechnologicaBlocks.ORANGE_BUTTON.get());
		dropSelf(TechnologicaBlocks.PEACH_BUTTON.get());
		dropSelf(TechnologicaBlocks.PEAR_BUTTON.get());
		dropSelf(TechnologicaBlocks.PLUM_BUTTON.get());
		dropSelf(TechnologicaBlocks.REDWOOD_BUTTON.get());
		dropSelf(TechnologicaBlocks.ROSEWOOD_BUTTON.get());
		dropSelf(TechnologicaBlocks.RUBBER_BUTTON.get());
		dropSelf(TechnologicaBlocks.TEAK_BUTTON.get());
		dropSelf(TechnologicaBlocks.WALNUT_BUTTON.get());
		dropSelf(TechnologicaBlocks.ZEBRAWOOD_BUTTON.get());
		dropSelf(TechnologicaBlocks.ALCHEMICAL_BUTTON.get());
		dropSelf(TechnologicaBlocks.BENEVOLENT_BUTTON.get());
		dropSelf(TechnologicaBlocks.CONDUCTIVE_BUTTON.get());
		dropSelf(TechnologicaBlocks.FROSTBITTEN_BUTTON.get());
		dropSelf(TechnologicaBlocks.FRUITFUL_BUTTON.get());
		dropSelf(TechnologicaBlocks.INFERNAL_BUTTON.get());
		dropSelf(TechnologicaBlocks.MALEVOLENT_BUTTON.get());
		dropSelf(TechnologicaBlocks.NECROTIC_BUTTON.get());

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

		dropSelf(TechnologicaBlocks.LINE_SHAFT_HANGER.get());
		dropOther(TechnologicaBlocks.LINE_SHAFT.get(), TechnologicaItems.STEEL_SHAFT.get());

		dropSelf(TechnologicaBlocks.SMALL_PULLEY.get());
		dropSelf(TechnologicaBlocks.MEDIUM_PULLEY.get());
		dropSelf(TechnologicaBlocks.LARGE_PULLEY.get());
		dropSelf(TechnologicaBlocks.MOTOR_1HP.get());
		dropSelf(TechnologicaBlocks.MOTOR_5HP.get());
		dropSelf(TechnologicaBlocks.MOTOR_20HP.get());
		dropSelf(TechnologicaBlocks.TREE_TAP.get());
		dropOther(TechnologicaBlocks.SAWMILL_CORE.get(), TechnologicaBlocks.SAWMILL.get());
		dropSelf(TechnologicaBlocks.SAWMILL.get());
		dropSelf(TechnologicaBlocks.FAST_HOPPER.get());

		dropSelf(TechnologicaBlocks.OAK_CHAIR.get());
		dropSelf(TechnologicaBlocks.SPRUCE_CHAIR.get());
		dropSelf(TechnologicaBlocks.BIRCH_CHAIR.get());
		dropSelf(TechnologicaBlocks.JUNGLE_CHAIR.get());
		dropSelf(TechnologicaBlocks.ACACIA_CHAIR.get());
		dropSelf(TechnologicaBlocks.DARK_OAK_CHAIR.get());
		dropSelf(TechnologicaBlocks.CRIMSON_CHAIR.get());
		dropSelf(TechnologicaBlocks.WARPED_CHAIR.get());
		dropSelf(TechnologicaBlocks.APRICOT_CHAIR.get());
		dropSelf(TechnologicaBlocks.ASPEN_CHAIR.get());
		dropSelf(TechnologicaBlocks.AVOCADO_CHAIR.get());
		dropSelf(TechnologicaBlocks.BANANA_CHAIR.get());
		dropSelf(TechnologicaBlocks.CHERRY_CHAIR.get());
		dropSelf(TechnologicaBlocks.CHESTNUT_CHAIR.get());
		dropSelf(TechnologicaBlocks.CINNAMON_CHAIR.get());
		dropSelf(TechnologicaBlocks.COCONUT_CHAIR.get());
		dropSelf(TechnologicaBlocks.EBONY_CHAIR.get());
		dropSelf(TechnologicaBlocks.KIWI_CHAIR.get());
		dropSelf(TechnologicaBlocks.LEMON_CHAIR.get());
		dropSelf(TechnologicaBlocks.LIME_CHAIR.get());
		dropSelf(TechnologicaBlocks.MAHOGANY_CHAIR.get());
		dropSelf(TechnologicaBlocks.MAPLE_CHAIR.get());
		dropSelf(TechnologicaBlocks.OLIVE_CHAIR.get());
		dropSelf(TechnologicaBlocks.ORANGE_CHAIR.get());
		dropSelf(TechnologicaBlocks.PEACH_CHAIR.get());
		dropSelf(TechnologicaBlocks.PEAR_CHAIR.get());
		dropSelf(TechnologicaBlocks.PLUM_CHAIR.get());
		dropSelf(TechnologicaBlocks.REDWOOD_CHAIR.get());
		dropSelf(TechnologicaBlocks.ROSEWOOD_CHAIR.get());
		dropSelf(TechnologicaBlocks.RUBBER_CHAIR.get());
		dropSelf(TechnologicaBlocks.TEAK_CHAIR.get());
		dropSelf(TechnologicaBlocks.WALNUT_CHAIR.get());
		dropSelf(TechnologicaBlocks.ZEBRAWOOD_CHAIR.get());
		dropSelf(TechnologicaBlocks.ALCHEMICAL_CHAIR.get());
		dropSelf(TechnologicaBlocks.BENEVOLENT_CHAIR.get());
		dropSelf(TechnologicaBlocks.CONDUCTIVE_CHAIR.get());
		dropSelf(TechnologicaBlocks.FROSTBITTEN_CHAIR.get());
		dropSelf(TechnologicaBlocks.FRUITFUL_CHAIR.get());
		dropSelf(TechnologicaBlocks.INFERNAL_CHAIR.get());
		dropSelf(TechnologicaBlocks.MALEVOLENT_CHAIR.get());
		dropSelf(TechnologicaBlocks.NECROTIC_CHAIR.get());

		dropSelf(TechnologicaBlocks.OAK_TABLE.get());
		dropSelf(TechnologicaBlocks.SPRUCE_TABLE.get());
		dropSelf(TechnologicaBlocks.BIRCH_TABLE.get());
		dropSelf(TechnologicaBlocks.JUNGLE_TABLE.get());
		dropSelf(TechnologicaBlocks.ACACIA_TABLE.get());
		dropSelf(TechnologicaBlocks.DARK_OAK_TABLE.get());
		dropSelf(TechnologicaBlocks.CRIMSON_TABLE.get());
		dropSelf(TechnologicaBlocks.WARPED_TABLE.get());
		dropSelf(TechnologicaBlocks.APRICOT_TABLE.get());
		dropSelf(TechnologicaBlocks.ASPEN_TABLE.get());
		dropSelf(TechnologicaBlocks.AVOCADO_TABLE.get());
		dropSelf(TechnologicaBlocks.BANANA_TABLE.get());
		dropSelf(TechnologicaBlocks.CHERRY_TABLE.get());
		dropSelf(TechnologicaBlocks.CHESTNUT_TABLE.get());
		dropSelf(TechnologicaBlocks.CINNAMON_TABLE.get());
		dropSelf(TechnologicaBlocks.COCONUT_TABLE.get());
		dropSelf(TechnologicaBlocks.EBONY_TABLE.get());
		dropSelf(TechnologicaBlocks.KIWI_TABLE.get());
		dropSelf(TechnologicaBlocks.LEMON_TABLE.get());
		dropSelf(TechnologicaBlocks.LIME_TABLE.get());
		dropSelf(TechnologicaBlocks.MAHOGANY_TABLE.get());
		dropSelf(TechnologicaBlocks.MAPLE_TABLE.get());
		dropSelf(TechnologicaBlocks.OLIVE_TABLE.get());
		dropSelf(TechnologicaBlocks.ORANGE_TABLE.get());
		dropSelf(TechnologicaBlocks.PEACH_TABLE.get());
		dropSelf(TechnologicaBlocks.PEAR_TABLE.get());
		dropSelf(TechnologicaBlocks.PLUM_TABLE.get());
		dropSelf(TechnologicaBlocks.REDWOOD_TABLE.get());
		dropSelf(TechnologicaBlocks.ROSEWOOD_TABLE.get());
		dropSelf(TechnologicaBlocks.RUBBER_TABLE.get());
		dropSelf(TechnologicaBlocks.TEAK_TABLE.get());
		dropSelf(TechnologicaBlocks.WALNUT_TABLE.get());
		dropSelf(TechnologicaBlocks.ZEBRAWOOD_TABLE.get());
		dropSelf(TechnologicaBlocks.ALCHEMICAL_TABLE.get());
		dropSelf(TechnologicaBlocks.BENEVOLENT_TABLE.get());
		dropSelf(TechnologicaBlocks.CONDUCTIVE_TABLE.get());
		dropSelf(TechnologicaBlocks.FROSTBITTEN_TABLE.get());
		dropSelf(TechnologicaBlocks.FRUITFUL_TABLE.get());
		dropSelf(TechnologicaBlocks.INFERNAL_TABLE.get());
		dropSelf(TechnologicaBlocks.MALEVOLENT_TABLE.get());
		dropSelf(TechnologicaBlocks.NECROTIC_TABLE.get());

		dropSelf(TechnologicaBlocks.DISPLAY_CASE.get());
		dropSelf(TechnologicaBlocks.ANNUNCIATOR.get());

		dropSelf(TechnologicaBlocks.NITROGLYCERIN.get());
		this.add(TechnologicaBlocks.NAVAL_MINE_CHAIN.get(), noDrop());

		this.add(TechnologicaBlocks.SLEEPING_BAG.get(), (p_251275_) -> {
			return this.createSinglePropConditionTable(p_251275_, BedBlock.PART, BedPart.HEAD);
		});

		dropSelf(TechnologicaBlocks.TAPE_DRIVE.get());
		dropSelf(TechnologicaBlocks.MONITOR.get());
		dropSelf(TechnologicaBlocks.KEYBOARD.get());
		dropSelf(TechnologicaBlocks.BASIN.get());
		dropSelf(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get());
		dropSelf(TechnologicaBlocks.RUBBER_RESIN_BASIN.get());

	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return TechnologicaBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
	}
}