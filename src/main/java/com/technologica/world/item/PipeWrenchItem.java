package com.technologica.world.item;

import javax.annotation.Nullable;

import com.technologica.capabilities.item.link.Link;
import com.technologica.capabilities.item.link.LinkProvider;
import com.technologica.listeners.mod.common.RegisterCapabilitiesEventListener;
import com.technologica.registration.deferred.TechnologicaBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class PipeWrenchItem extends DiggerItem {
	public PipeWrenchItem(Tier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder) {
		super(attackDamageIn, attackSpeedIn, tier, BlockTags.MINEABLE_WITH_PICKAXE, builder);
	}

	@Override
	public boolean isCorrectToolForDrops(BlockState blockIn) {
		return true;
	}

	@Override
	public float getDestroySpeed(ItemStack stack, BlockState state) {
		return this.speed;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		Level world = context.getLevel();
		if (!world.isClientSide) {
			BlockPos pos = context.getClickedPos();
			BlockState state = world.getBlockState(pos);
			if (state.is(TechnologicaBlocks.LINE_SHAFT_HANGER.get())) {
				Player player = context.getPlayer();
				ItemStack stack = player.getItemInHand(context.getHand());
				Link linkCapability = stack.getCapability(RegisterCapabilitiesEventListener.LINK_INSTANCE).orElseThrow(NullPointerException::new);
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
		return InteractionResult.PASS;
	}

	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
		return new LinkProvider();
	}
}
