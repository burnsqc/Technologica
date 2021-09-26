package com.technologica.data.loot;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.block.ChairBlock;
import com.technologica.block.CrystalBlock;
import com.technologica.block.FruitingLeavesBlock;
import com.technologica.block.ModBlocks;
import com.technologica.block.ModCropsBlock;
import com.technologica.block.ModFenceBlock;
import com.technologica.block.ModFenceGateBlock;
import com.technologica.block.ModLogBlock;
import com.technologica.block.ModPlanksBlock;
import com.technologica.block.ModSlabBlock;
import com.technologica.block.ModStairsBlock;
import com.technologica.block.ModStandingSignBlock;
import com.technologica.block.ModWallSignBlock;
import com.technologica.block.SapLogBlock;
<<<<<<< HEAD
=======
import com.technologica.block.SawmillBlock;
>>>>>>> f6f2af2a47e9af4c8bedb4d348a7ed5620e35a9e
import com.technologica.block.TallCropsBlock;
import com.technologica.block.TreeTapBlock;
import com.technologica.block.WaterCropsBlock;
import com.technologica.item.ModItems;

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
		automaticBlockState(ModBlocks.BLOCKS.getEntries());
		
		registerLootTable(ModBlocks.LITHIUM_CLAY.get(), (clay) -> droppingWithSilkTouchOrRandomly(clay, ModItems.LITHIUM_CLAY_BALL.get(), ConstantRange.of(4)));
		registerDropSelfLootTable(ModBlocks.SALT.get());
		
		registerDropSelfLootTable(ModBlocks.LINE_SHAFT_HANGER.get());
		registerDropping(ModBlocks.LINE_SHAFT.get(), ModItems.STEEL_SHAFT.get());
		registerDropSelfLootTable(ModBlocks.SMALL_PULLEY.get());
		registerDropSelfLootTable(ModBlocks.MEDIUM_PULLEY.get());
		registerDropSelfLootTable(ModBlocks.LARGE_PULLEY.get());
		registerDropSelfLootTable(ModBlocks.MOTOR_1HP.get());
		registerDropSelfLootTable(ModBlocks.MOTOR_5HP.get());
		registerDropSelfLootTable(ModBlocks.MOTOR_20HP.get());
		
		registerDropSelfLootTable(ModBlocks.DISPLAY_CASE.get());
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
	
	private final void automaticBlockState(Collection<RegistryObject<Block>> blockCollection) {
		for(Supplier<? extends Block> blockSupplier:blockCollection) {
			Block block = blockSupplier.get();
			
			if (block.getClass().equals(ModLogBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(SapLogBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(SaplingBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(FlowerPotBlock.class)) registerFlowerPot(block);
			else if (block.getClass().equals(ModPlanksBlock.class)) registerDropSelfLootTable(block);
			else if (block.getTranslationKey().contains("bookshelf")) registerLootTable(block, (bookshelf) -> droppingWithSilkTouchOrRandomly(bookshelf, Items.BOOK, ConstantRange.of(3)));
			else if (block.getClass().equals(ModSlabBlock.class)) registerLootTable(block, BlockLootTables::droppingSlab);
			else if (block.getClass().equals(ModStairsBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(ModFenceBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(ModFenceGateBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(DoorBlock.class)) registerLootTable(block, BlockLootTables::registerDoor);
			else if (block.getClass().equals(TrapDoorBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(PressurePlateBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(WoodButtonBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(ModStandingSignBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(ModWallSignBlock.class)) registerDropSelfLootTable(block);
			else if (block.getRegistryName().getPath().contains("ore")) registerDropSelfLootTable(block);
			else if (block.getClass().equals(CrystalBlock.class)) registerDropSelfLootTable(block);
<<<<<<< HEAD
			else if (block.getClass().equals(FourDirectionBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(SapLogBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(ChairBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(TreeTapBlock.class)) registerDropSelfLootTable(block);
=======
			else if (block.getClass().equals(TreeTapBlock.class)) registerDropSelfLootTable(block);
			else if (block.getClass().equals(SawmillBlock.class)) registerDropSelfLootTable(block);
>>>>>>> f6f2af2a47e9af4c8bedb4d348a7ed5620e35a9e
			
			else if (block.getClass().equals(ModCropsBlock.class) || block.getClass().equals(TallCropsBlock.class) || block.getClass().equals(WaterCropsBlock.class)) {
				Collection<RegistryObject<Item>> itemCollection = ModItems.ITEMS.getEntries();
				Item yield = Items.WHEAT;
				
				for(Supplier<? extends Item> itemSupplier:itemCollection) {
					if (block.getRegistryName().getPath().contains(itemSupplier.get().getRegistryName().getPath())) yield = itemSupplier.get();
				}
				
				registerLootTable(block, droppingAndBonusWhen(block, yield, block.asItem(), BlockStateProperty.builder(block).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withIntProp(CropsBlock.AGE, 7))));
			}
			
			else if (block.getClass().equals(FruitingLeavesBlock.class) || block.getClass().equals(LeavesBlock.class)) {
				Block sapling = Blocks.OAK_SAPLING;
				for(Supplier<? extends Block> blockSupplier2:blockCollection) {
					Block block2 = blockSupplier2.get();
					if (replace(block.getRegistryName().getPath(), "leaves", "sapling").equals(block2.getRegistryName().getPath())) sapling = block2;
				}	
				registerLootTable(block, droppingWithChancesAndSticks(block, sapling, DEFAULT_SAPLING_DROP_RATES));
			} else if (!block.getClass().equals(FruitingLeavesBlock.class) && !block.getClass().equals(LeavesBlock.class) && block instanceof LeavesBlock) {
				registerDropSelfLootTable(block);
			}
		}
	}
	
	private String replace(String original, String regex, String replacement) {
        return new String(original.replaceAll(regex, replacement));
    }
	
	@Override
	protected Iterable<Block> getKnownBlocks() {
		return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
	}
}
