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
import com.technologica.world.level.block.VanillaCropsBlock;
import com.technologica.world.level.block.VanillaFenceBlock;
import com.technologica.world.level.block.VanillaFenceGateBlock;
import com.technologica.world.level.block.VanillaLeavesBlock;
import com.technologica.world.level.block.VanillaLogBlock;
import com.technologica.world.level.block.VanillaPlanksBlock;
import com.technologica.world.level.block.VanillaSlabBlock;
import com.technologica.world.level.block.VanillaStairsBlock;
import com.technologica.world.level.block.VanillaStandingSignBlock;
import com.technologica.world.level.block.VanillaWallSignBlock;
import com.technologica.world.level.block.WaterCropsBlock;

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
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot {
	private static final float[] DEFAULT_SAPLING_DROP_RATES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
	
	@Override
	protected void addTables() {
		automaticLootTable(TechnologicaBlocks.BLOCKS.getEntries());
		
		add(TechnologicaBlocks.CORN_CROP.get(), createCropDrops(TechnologicaBlocks.CORN_CROP.get(), TechnologicaItems.CORN.get(), TechnologicaBlocks.CORN_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.CORN_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		add(TechnologicaBlocks.PEPPERCORN_CROP.get(), createCropDrops(TechnologicaBlocks.PEPPERCORN_CROP.get(), TechnologicaItems.PEPPERCORNS.get(), TechnologicaBlocks.PEPPERCORN_CROP.get().asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(TechnologicaBlocks.PEPPERCORN_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
		
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
			
			if (block instanceof VanillaLogBlock) dropSelf(block);
			else if (block.getClass().equals(SaplingBlock.class)) dropSelf(block);
			else if (block.getClass().equals(FlowerPotBlock.class)) dropPottedContents(block);
			else if (block.getClass().equals(VanillaPlanksBlock.class)) dropSelf(block);
			else if (block.getDescriptionId().contains("bookshelf")) add(block, (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
			else if (block.getClass().equals(VanillaSlabBlock.class)) add(block, BlockLoot::createSlabItemTable);
			else if (block.getClass().equals(VanillaStairsBlock.class)) dropSelf(block);
			else if (block.getClass().equals(VanillaFenceBlock.class)) dropSelf(block);
			else if (block.getClass().equals(VanillaFenceGateBlock.class)) dropSelf(block);
			else if (block.getClass().equals(DoorBlock.class)) add(block, BlockLoot::createDoorTable);
			else if (block.getClass().equals(TrapDoorBlock.class)) dropSelf(block);
			else if (block.getClass().equals(PressurePlateBlock.class)) dropSelf(block);
			else if (block.getClass().equals(WoodButtonBlock.class)) dropSelf(block);
			else if (block.getClass().equals(VanillaStandingSignBlock.class)) dropSelf(block);
			else if (block.getClass().equals(VanillaWallSignBlock.class)) dropSelf(block);
			else if (block.getRegistryName().getPath().contains("ore")) dropSelf(block);
			else if (block.getClass().equals(TwentyFourDirectionBlock.class)) dropSelf(block);
			else if (block.getClass().equals(SapLogBlock.class)) dropSelf(block);
			else if (block.getClass().equals(ChairBlock.class)) dropSelf(block);
			else if (block.getClass().equals(TableBlock.class)) dropSelf(block);
			else if (block.getClass().equals(TreeTapBlock.class)) dropSelf(block);
			else if (block.getClass().equals(TreeTapBlock.class)) dropSelf(block);
			else if (block.getClass().equals(SawmillBlock.class)) dropSelf(block);
			
			else if (block.getClass().equals(VanillaCropsBlock.class) || block.getClass().equals(WaterCropsBlock.class)) {
				Collection<RegistryObject<Item>> itemCollection = TechnologicaItems.ITEMS.getEntries();
				Item yield = Items.WHEAT;
				
				for(Supplier<? extends Item> itemSupplier:itemCollection) {
					if (block.getRegistryName().getPath().contains(itemSupplier.get().getRegistryName().getPath())) yield = itemSupplier.get();
				}
				
				add(block, createCropDrops(block, yield, block.asItem(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
			}
			
			else if (block.getClass().equals(FruitingLeavesBlock.class) || block.getClass().equals(VanillaLeavesBlock.class)) {
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
