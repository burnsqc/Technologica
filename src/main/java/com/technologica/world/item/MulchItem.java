package com.technologica.world.item;

import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.world.level.block.entity.MulchTileEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class MulchItem extends Item {

	public MulchItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		Level world = context.getLevel();
		if (!world.isClientSide) {
			BlockPos pos = context.getClickedPos();
			BlockState state = world.getBlockState(pos);

			if (state.is(Blocks.GRASS_BLOCK) || state.is(Blocks.DIRT) || state.is(Blocks.COARSE_DIRT) || state.is(Blocks.PODZOL)) {

				world.setBlock(pos, TechnologicaBlocks.MULCH.get().defaultBlockState(), 3);
				MulchTileEntity mulchTileEntity = (MulchTileEntity) world.getBlockEntity(pos);
				mulchTileEntity.setPreviousBlockState(state);
				world.playSound((Player) null, pos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
				if (!context.getPlayer().getAbilities().instabuild) {
					context.getItemInHand().shrink(1);
				}
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.PASS;
	}
}