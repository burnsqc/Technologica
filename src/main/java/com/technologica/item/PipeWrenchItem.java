package com.technologica.item;

import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableSet;
import com.technologica.block.TechnologicaBlocks;
import com.technologica.capabilities.ILink;
import com.technologica.capabilities.LinkProvider;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ToolItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class PipeWrenchItem extends ToolItem {

	private static final Set<Block> EFFECTIVE_ON = ImmutableSet.of(TechnologicaBlocks.LINE_SHAFT_HANGER.get());

	public PipeWrenchItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder) {
		super((float) attackDamageIn, attackSpeedIn, tier, EFFECTIVE_ON, builder.addToolType(net.minecraftforge.common.ToolType.PICKAXE, tier.getLevel()));
	}

	@Override
	public boolean isCorrectToolForDrops(BlockState blockIn) {
		int i = this.getTier().getLevel();
		if (blockIn.getHarvestTool() == net.minecraftforge.common.ToolType.PICKAXE) {
			return i >= blockIn.getHarvestLevel();
		}
		Material material = blockIn.getMaterial();
		return material == Material.STONE || material == Material.METAL || material == Material.HEAVY_METAL;
	}

	@Override
	public float getDestroySpeed(ItemStack stack, BlockState state) {
		Material material = state.getMaterial();
		return material != Material.METAL && material != Material.HEAVY_METAL && material != Material.STONE
				? super.getDestroySpeed(stack, state)
				: this.speed;
	}

	@Override
	public ActionResultType useOn(ItemUseContext context) {
   		World world = context.getLevel();
   		if (!world.isClientSide) {
   			BlockPos pos = context.getClickedPos();
   			BlockState state = world.getBlockState(pos);
   			if (state.is(TechnologicaBlocks.LINE_SHAFT_HANGER.get())) {
   				PlayerEntity player = context.getPlayer();
   	   			ItemStack stack = player.getItemInHand(context.getHand());
   	   			ILink linkCapability = stack.getCapability(LinkProvider.LINK_CAP).orElseThrow(NullPointerException::new);
   				if (!linkCapability.getLinking()) {
   					linkCapability.startLink(world, pos, state, player);
   				} else {
   					linkCapability.stopLink(pos, state);
   					if (linkCapability.checkAxis() && linkCapability.checkInlinePos() && linkCapability.checkObstructed() && linkCapability.checkDistance() && linkCapability.checkMaterial()) {
   						linkCapability.createLineShaft();
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
