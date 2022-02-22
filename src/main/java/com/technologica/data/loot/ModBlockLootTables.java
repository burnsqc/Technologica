package com.technologica.data.loot;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.block.ChairBlock;
import com.technologica.block.FruitingLeavesBlock;
import com.technologica.block.SapLogBlock;
import com.technologica.block.SawmillBlock;
import com.technologica.block.TableBlock;
import com.technologica.block.TechnologicaBlocks;
import com.technologica.block.TreeTapBlock;
import com.technologica.block.TwentyFourDirectionBlock;
import com.technologica.block.VanillaCropsBlock;
import com.technologica.block.VanillaFenceBlock;
import com.technologica.block.VanillaFenceGateBlock;
import com.technologica.block.VanillaLeavesBlock;
import com.technologica.block.VanillaLogBlock;
import com.technologica.block.VanillaPlanksBlock;
import com.technologica.block.VanillaSlabBlock;
import com.technologica.block.VanillaStairsBlock;
import com.technologica.block.VanillaStandingSignBlock;
import com.technologica.block.VanillaWallSignBlock;
import com.technologica.block.WaterCropsBlock;
import com.technologica.item.TechnologicaItems;
import com.technologica.util.text.ResourceLocationHelper;

import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.block.WoodButtonBlock;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.conditions.BlockStateProperty;
import net.minecraftforge.fml.RegistryObject;

public class ModBlockLootTables extends BlockLootTables {
	private static final float[] DEFAULT_SAPLING_DROP_RATES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
	
	@Override
	protected void addTables() {
		automaticLootTable(TechnologicaBlocks.BLOCKS.getEntries());
		
		add(TechnologicaBlocks.CORN_CROP.get(), createCropDrops(TechnologicaBlocks.CORN_CROP.get(), TechnologicaItems.CORN.get(), TechnologicaBlocks.CORN_CROP.get().asItem(), BlockStateProperty.hasBlockStateProperties(TechnologicaBlocks.CORN_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropsBlock.AGE, 7))));
		add(TechnologicaBlocks.PEPPERCORN_CROP.get(), createCropDrops(TechnologicaBlocks.PEPPERCORN_CROP.get(), TechnologicaItems.PEPPERCORNS.get(), TechnologicaBlocks.PEPPERCORN_CROP.get().asItem(), BlockStateProperty.hasBlockStateProperties(TechnologicaBlocks.PEPPERCORN_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropsBlock.AGE, 7))));
		
		add(TechnologicaBlocks.LITHIUM_CLAY.get(), (clay) -> createSingleItemTableWithSilkTouch(clay, TechnologicaItems.LITHIUM_CLAY_BALL.get(), ConstantRange.exactly(4)));
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
			else if (block.getDescriptionId().contains("bookshelf")) add(block, (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantRange.exactly(3)));
			else if (block.getClass().equals(VanillaSlabBlock.class)) add(block, BlockLootTables::createSlabItemTable);
			else if (block.getClass().equals(VanillaStairsBlock.class)) dropSelf(block);
			else if (block.getClass().equals(VanillaFenceBlock.class)) dropSelf(block);
			else if (block.getClass().equals(VanillaFenceGateBlock.class)) dropSelf(block);
			else if (block.getClass().equals(DoorBlock.class)) add(block, BlockLootTables::createDoorTable);
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
				
				add(block, createCropDrops(block, yield, block.asItem(), BlockStateProperty.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropsBlock.AGE, 7))));
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
