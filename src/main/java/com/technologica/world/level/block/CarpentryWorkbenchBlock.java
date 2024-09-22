package com.technologica.world.level.block;

import javax.annotation.Nullable;

import com.technologica.world.inventory.CarpentryWorkbenchMenu;
import com.technologica.world.level.block.entity.CarpentryWorkbenchBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;

public class CarpentryWorkbenchBlock extends BaseEntityBlock {

	public CarpentryWorkbenchBlock() {
		super(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.WOOD));
	}

	public CarpentryWorkbenchBlockEntity getTileEntity(Level level, BlockPos blockPos) {
		return (CarpentryWorkbenchBlockEntity) level.getBlockEntity(blockPos);
	}

	@Override
	public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
		if (level.isClientSide()) {
			return InteractionResult.SUCCESS;
		} else {
			MenuProvider containerProvider = createContainerProvider(level, blockPos);
			NetworkHooks.openScreen((ServerPlayer) player, containerProvider, blockPos);
			return InteractionResult.CONSUME;
		}
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
		return new CarpentryWorkbenchBlockEntity(blockPos, blockState);
	}

	private MenuProvider createContainerProvider(Level level, BlockPos blockPos) {
		return new MenuProvider() {
			@Override
			public Component getDisplayName() {
				return Component.translatable("screen.carpentryworkbench");
			}

			@Nullable
			@Override
			public AbstractContainerMenu createMenu(int windowId, Inventory inventory, Player player) {
				return new CarpentryWorkbenchMenu(windowId, level, blockPos, inventory);
			}
		};
	}
}
