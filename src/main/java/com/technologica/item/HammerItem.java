package com.technologica.item;

import com.technologica.block.ModBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HammerItem extends Item {

	public HammerItem() {
		super(new Item.Properties().maxStackSize(1));
	}
	
	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
   		World world = context.getWorld();
   		if (!world.isRemote) {
   			BlockPos pos = context.getPos();
   			BlockState state = world.getBlockState(pos);
   			if (state.matchesBlock(ModBlocks.LINE_SHAFT_HANGER.get())) {
   				
   			}
   		}
   		return ActionResultType.PASS;  
   	}
}