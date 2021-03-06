package com.technologica.item;

import javax.annotation.Nullable;

import com.technologica.block.LineShaftBlock;
import com.technologica.block.TechnologicaBlocks;
import com.technologica.capabilities.ILink;
import com.technologica.capabilities.LinkProvider;
import com.technologica.util.Radius;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class PulleyBeltItem extends Item {

	public PulleyBeltItem() {
		super(new Item.Properties().maxStackSize(1).group(TechnologicaItemGroup.MACHINERY));
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
   		World world = context.getWorld();
   		if (!world.isRemote) {
   			BlockPos pos = context.getPos();
   			BlockState state = world.getBlockState(pos);
   			if (state.matchesBlock(TechnologicaBlocks.LINE_SHAFT.get()) && state.get(LineShaftBlock.RADIUS) != Radius.NONE) {
   				PlayerEntity player = context.getPlayer();
   	   			ItemStack stack = player.getHeldItem(context.getHand());
   	   			ILink linkCapability = stack.getCapability(LinkProvider.LINK_CAP).orElseThrow(NullPointerException::new);
   				if (!linkCapability.getLinking()) {
   					linkCapability.startLink(world, pos, state, player);
   				} else {
   					linkCapability.stopLink(pos, state);
   					if (linkCapability.checkAxis() && linkCapability.checkPlanarPos()) {
   						linkCapability.createBelt();
   					}
   				}
   			}
   		}
   		return ActionResultType.PASS;  
   	}
	
	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
		return new LinkProvider();
	}
}
