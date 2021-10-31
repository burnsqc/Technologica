package com.technologica.block;

import java.util.Map;
import java.util.function.Supplier;

import com.google.common.collect.ImmutableMap.Builder;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

/**
 * Identical in behavior to vanilla Minecraft logs.  
 * Created to handle flammability and log stripping.
 */
public class VanillaLogBlock extends RotatedPillarBlock {
	protected static final Map<String, Supplier<Block>> BLOCK_STRIPPING_MAP = (new Builder<String, Supplier<Block>>())
			.put("apricot_log", TechnologicaBlocks.STRIPPED_APRICOT_LOG)
			.put("aspen_log", TechnologicaBlocks.STRIPPED_ASPEN_LOG)
			.put("avocado_log", TechnologicaBlocks.STRIPPED_AVOCADO_LOG)
			.put("banana_log", TechnologicaBlocks.STRIPPED_BANANA_LOG)
			.put("cherry_log", TechnologicaBlocks.STRIPPED_CHERRY_LOG)
			.put("chestnut_log", TechnologicaBlocks.STRIPPED_CHESTNUT_LOG)
			.put("cinnamon_log", TechnologicaBlocks.STRIPPED_CINNAMON_LOG)
			.put("coconut_log", TechnologicaBlocks.STRIPPED_COCONUT_LOG)
			.put("ebony_log", TechnologicaBlocks.STRIPPED_EBONY_LOG)
			.put("kiwi_log", TechnologicaBlocks.STRIPPED_KIWI_LOG)
			.put("lemon_log", TechnologicaBlocks.STRIPPED_LEMON_LOG)
			.put("lime_log", TechnologicaBlocks.STRIPPED_LIME_LOG)
			.put("mahogany_log", TechnologicaBlocks.STRIPPED_MAHOGANY_LOG)
			.put("maple_log", TechnologicaBlocks.STRIPPED_MAPLE_LOG)
			.put("olive_log", TechnologicaBlocks.STRIPPED_OLIVE_LOG)
			.put("orange_log", TechnologicaBlocks.STRIPPED_ORANGE_LOG)
			.put("peach_log", TechnologicaBlocks.STRIPPED_PEACH_LOG)
			.put("pear_log", TechnologicaBlocks.STRIPPED_PEAR_LOG)
			.put("plum_log", TechnologicaBlocks.STRIPPED_PLUM_LOG)
			.put("redwood_log", TechnologicaBlocks.STRIPPED_REDWOOD_LOG)
			.put("rosewood_log", TechnologicaBlocks.STRIPPED_ROSEWOOD_LOG)
			.put("rubber_log", TechnologicaBlocks.STRIPPED_RUBBER_LOG)
			.put("teak_log", TechnologicaBlocks.STRIPPED_TEAK_LOG)
			.put("walnut_log", TechnologicaBlocks.STRIPPED_WALNUT_LOG)
			.put("zebrawood_log", TechnologicaBlocks.STRIPPED_ZEBRAWOOD_LOG)
			.put("apricot_wood", TechnologicaBlocks.STRIPPED_APRICOT_WOOD)
			.put("aspen_wood", TechnologicaBlocks.STRIPPED_ASPEN_WOOD)
			.put("avocado_wood", TechnologicaBlocks.STRIPPED_AVOCADO_WOOD)
			.put("banana_wood", TechnologicaBlocks.STRIPPED_BANANA_WOOD)
			.put("cherry_wood", TechnologicaBlocks.STRIPPED_CHERRY_WOOD)
			.put("chestnut_wood", TechnologicaBlocks.STRIPPED_CHESTNUT_WOOD)
			.put("cinnamon_wood", TechnologicaBlocks.STRIPPED_CINNAMON_WOOD)
			.put("coconut_wood", TechnologicaBlocks.STRIPPED_COCONUT_WOOD)
			.put("ebony_wood", TechnologicaBlocks.STRIPPED_EBONY_WOOD)
			.put("kiwi_wood", TechnologicaBlocks.STRIPPED_KIWI_WOOD)
			.put("lemon_wood", TechnologicaBlocks.STRIPPED_LEMON_WOOD)
			.put("lime_wood", TechnologicaBlocks.STRIPPED_LIME_WOOD)
			.put("mahogany_wood", TechnologicaBlocks.STRIPPED_MAHOGANY_WOOD)
			.put("maple_wood", TechnologicaBlocks.STRIPPED_MAPLE_WOOD)
			.put("olive_wood", TechnologicaBlocks.STRIPPED_OLIVE_WOOD)
			.put("orange_wood", TechnologicaBlocks.STRIPPED_ORANGE_WOOD)
			.put("peach_wood", TechnologicaBlocks.STRIPPED_PEACH_WOOD)
			.put("pear_wood", TechnologicaBlocks.STRIPPED_PEAR_WOOD)
			.put("plum_wood", TechnologicaBlocks.STRIPPED_PLUM_WOOD)
			.put("redwood_wood", TechnologicaBlocks.STRIPPED_REDWOOD_WOOD)
			.put("rosewood_wood", TechnologicaBlocks.STRIPPED_ROSEWOOD_WOOD)
			.put("rubber_wood", TechnologicaBlocks.STRIPPED_RUBBER_WOOD)
			.put("teak_wood", TechnologicaBlocks.STRIPPED_TEAK_WOOD)
			.put("walnut_wood", TechnologicaBlocks.STRIPPED_WALNUT_WOOD)
			.put("zebrawood_wood", TechnologicaBlocks.STRIPPED_ZEBRAWOOD_WOOD).build();
	
	public VanillaLogBlock() {
		super(Properties.create(Material.WOOD, state -> state.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.OBSIDIAN).harvestLevel(0).harvestTool(ToolType.AXE).setRequiresTool().hardnessAndResistance(2.0F).sound(SoundType.WOOD));
	}

	/*
	 * Minecraft Methods
	 */
	
	@Override
	public ActionResultType onBlockActivated(BlockState stateIn, World worldIn, BlockPos posIn, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult hitIn) {
		Item item = playerIn.getHeldItem(handIn).getItem();
		
		if (item instanceof AxeItem & !stateIn.getBlock().getRegistryName().getPath().contains("stripped")) {
			Axis axis = stateIn.get(AXIS);
			worldIn.playSound(playerIn, posIn, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
	        if (!worldIn.isRemote) {
	        	Block strippedLog = BLOCK_STRIPPING_MAP.get(stateIn.getBlock().getRegistryName().getPath()).get();
	        	worldIn.setBlockState(posIn, strippedLog.getDefaultState().with(AXIS, axis), 11);
	            if (playerIn != null) {
	            	playerIn.getHeldItem(handIn).damageItem(1, playerIn, (player) -> {
	            		player.sendBreakAnimation(handIn);
	            	});
	            }
	        }
	        return ActionResultType.func_233537_a_(worldIn.isRemote);
		} else {
			return ActionResultType.FAIL;
		}
	}
	
	/*
	 * Forge Methods
	 */
	
	@Override
	public int getFlammability(BlockState stateIn, IBlockReader worldIn, BlockPos posIn, Direction faceIn) {
		return 5;
	}

	@Override
	public int getFireSpreadSpeed(BlockState stateIn, IBlockReader worldIn, BlockPos posIn, Direction faceIn) {
		return 5;
	}

}
