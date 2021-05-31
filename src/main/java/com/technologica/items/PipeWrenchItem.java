package com.technologica.items;

import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableSet;
import com.technologica.block.ModBlocks;
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

	private static final Set<Block> EFFECTIVE_ON = ImmutableSet.of(ModBlocks.LINE_SHAFT_HANGER.get());

	public PipeWrenchItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder) {
		super((float) attackDamageIn, attackSpeedIn, tier, EFFECTIVE_ON, builder.addToolType(net.minecraftforge.common.ToolType.PICKAXE, tier.getHarvestLevel()));
	}

	public boolean canHarvestBlock(BlockState blockIn) {
		int i = this.getTier().getHarvestLevel();
		if (blockIn.getHarvestTool() == net.minecraftforge.common.ToolType.PICKAXE) {
			return i >= blockIn.getHarvestLevel();
		}
		Material material = blockIn.getMaterial();
		return material == Material.ROCK || material == Material.IRON || material == Material.ANVIL;
	}

	public float getDestroySpeed(ItemStack stack, BlockState state) {
		Material material = state.getMaterial();
		return material != Material.IRON && material != Material.ANVIL && material != Material.ROCK
				? super.getDestroySpeed(stack, state)
				: this.efficiency;
	}

	public ActionResultType onItemUse(ItemUseContext context) {
   		World world = context.getWorld();
   		BlockPos blockpos = context.getPos();
   		BlockState blockstate = world.getBlockState(blockpos);
   		PlayerEntity player = context.getPlayer();
       
   		ItemStack stack = player.getHeldItem(context.getHand());
   		
   		ILink linkcapability = (ILink) stack.getCapability(LinkProvider.LINK_CAP);
   		
   		if (blockstate.matchesBlock(ModBlocks.LINE_SHAFT_HANGER.get())) {
   			linkcapability.setLink(blockpos, blockstate, player);
   		}
   		
   		return ActionResultType.PASS;  
   	}
	
	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
		return new LinkProvider();
	}
}