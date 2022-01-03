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
import com.technologica.util.text.StringHelper;

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
		
		registerLootTable(TechnologicaBlocks.CORN_CROP.get(), droppingAndBonusWhen(TechnologicaBlocks.CORN_CROP.get(), TechnologicaItems.CORN.get(), TechnologicaBlocks.CORN_CROP.get().asItem(), BlockStateProperty.builder(TechnologicaBlocks.CORN_CROP.get()).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withIntProp(CropsBlock.AGE, 7))));
		registerLootTable(TechnologicaBlocks.PEPPERCORN_CROP.get(), droppingAndBonusWhen(TechnologicaBlocks.PEPPERCORN_CROP.get(), TechnologicaItems.PEPPERCORNS.get(), TechnologicaBlocks.PEPPERCORN_CROP.get().asItem(), BlockStateProperty.builder(TechnologicaBlocks.PEPPERCORN_CROP.get()).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withIntProp(CropsBlock.AGE, 7))));
		
		registerLootTable(TechnologicaBlocks.LITHIUM_CLAY.get(), (clay) -> droppingWithSilkTouchOrRandomly(clay, TechnologicaItems.LITHIUM_CLAY_BALL.get(), ConstantRange.of(4)));
		registerDropSelfLootTable(TechnologicaBlocks.SALT.get());
		
		registerDropSelfLootTable(TechnologicaBlocks.LINE_SHAFT_HANGER.get());
		registerDropping(TechnologicaBlocks.LINE_SHAFT.get(), TechnologicaItems.STEEL_SHAFT.get());
		registerDropSelfLootTable(TechnologicaBlocks.SMALL_PULLEY.get());
		registerDropSelfLootTable(TechnologicaBlocks.MEDIUM_PULLEY.get());
		registerDropSelfLootTable(TechnologicaBlocks.LARGE_PULLEY.get());
		registerDropSelfLootTable(TechnologicaBlocks.MOTOR_1HP.get());
		registerDropSelfLootTable(TechnologicaBlocks.MOTOR_5HP.get());
		registerDropSelfLootTable(TechnologicaBlocks.MOTOR_20HP.get());
		
		registerDropSelfLootTable(TechnologicaBlocks.DISPLAY_CASE.get());
		registerDropSelfLootTable(TechnologicaBlocks.ANNUNCIATOR.get());
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
			String path = StringHelper.getPath(block);
			
			if (block.getClass().equals(VanillaLogBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(SapLogBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(SaplingBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(FlowerPotBlock.class)) registerFlowerPot(block);
			else if (block.getClass().equals(VanillaPlanksBlock.class)) registerDropSelfLootTable(block);
			else if (block.getTranslationKey().contains("bookshelf")) registerLootTable(block, (bookshelf) -> droppingWithSilkTouchOrRandomly(bookshelf, Items.BOOK, ConstantRange.of(3)));
			else if (block.getClass().equals(VanillaSlabBlock.class)) registerLootTable(block, BlockLootTables::droppingSlab);
			else if (block.getClass().equals(VanillaStairsBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(VanillaFenceBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(VanillaFenceGateBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(DoorBlock.class)) registerLootTable(block, BlockLootTables::registerDoor);
			else if (block.getClass().equals(TrapDoorBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(PressurePlateBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(WoodButtonBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(VanillaStandingSignBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(VanillaWallSignBlock.class)) registerDropSelfLootTable(block);
			else if (block.getRegistryName().getPath().contains("ore")) registerDropSelfLootTable(block);
			else if (block.getClass().equals(TwentyFourDirectionBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(SapLogBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(ChairBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(TableBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(TreeTapBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(TreeTapBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(SawmillBlock.class)) registerDropSelfLootTable(block);
			
			else if (block.getClass().equals(VanillaCropsBlock.class) || block.getClass().equals(WaterCropsBlock.class)) {
				Collection<RegistryObject<Item>> itemCollection = TechnologicaItems.ITEMS.getEntries();
				Item yield = Items.WHEAT;
				
				for(Supplier<? extends Item> itemSupplier:itemCollection) {
					if (block.getRegistryName().getPath().contains(itemSupplier.get().getRegistryName().getPath())) yield = itemSupplier.get();
				}
				
				registerLootTable(block, droppingAndBonusWhen(block, yield, block.asItem(), BlockStateProperty.builder(block).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withIntProp(CropsBlock.AGE, 7))));
			}
			
			else if (block.getClass().equals(FruitingLeavesBlock.class) || block.getClass().equals(VanillaLeavesBlock.class)) {
				Block sapling = Blocks.OAK_SAPLING;
				for(Supplier<? extends Block> blockSupplier2:blockCollection) {
					Block block2 = blockSupplier2.get();
					if (StringHelper.replace(block.getRegistryName().getPath(), "leaves", "sapling").equals(block2.getRegistryName().getPath())) sapling = block2;
				}	
				registerLootTable(block, droppingWithChancesAndSticks(block, sapling, DEFAULT_SAPLING_DROP_RATES));
			} else if (!block.getClass().equals(FruitingLeavesBlock.class) && !block.getClass().equals(LeavesBlock.class) && block instanceof LeavesBlock) {
				registerDropSelfLootTable(block);
			} else if (path.contains("moon")) {
				registerDropSelfLootTable(block);
			}
		}
	}
	
	@Override
	protected Iterable<Block> getKnownBlocks() {
		return TechnologicaBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
	}
}
