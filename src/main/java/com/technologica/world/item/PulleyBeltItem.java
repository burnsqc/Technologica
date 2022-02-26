package com.technologica.world.item;

import javax.annotation.Nullable;

import com.technologica.capabilities.ILink;
import com.technologica.capabilities.LinkProvider;
import com.technologica.util.Radius;
import com.technologica.world.level.block.LineShaftBlock;
import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResult;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class PulleyBeltItem extends Item {

	public PulleyBeltItem() {
		super(new Item.Properties().stacksTo(1).tab(TechnologicaItemGroup.MACHINERY));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
   		Level world = context.getLevel();
   		if (!world.isClientSide) {
   			BlockPos pos = context.getClickedPos();
   			BlockState state = world.getBlockState(pos);
   			if (state.is(TechnologicaBlocks.LINE_SHAFT.get()) && state.getValue(LineShaftBlock.RADIUS) != Radius.NONE) {
   				Player player = context.getPlayer();
   	   			ItemStack stack = player.getItemInHand(context.getHand());
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
   		return InteractionResult.PASS;  
   	}
	
	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
		return new LinkProvider();
	}
}
