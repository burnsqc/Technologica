package com.technologica.world.level.block;

import java.util.function.ToIntFunction;

import javax.annotation.Nullable;

import com.technologica.util.AnnunciatorOverlay;
import com.technologica.world.inventory.AnnunciatorMenu;
import com.technologica.world.level.block.entity.AnnunciatorBlockEntity;
import com.technologica.world.level.block.state.properties.TechnologicaBlockStateProperties;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;

public class AnnunciatorBlock extends BaseEntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty LIT = BlockStateProperties.LIT;
	public static final EnumProperty<AnnunciatorOverlay> OVERLAY = TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY;

	public AnnunciatorBlock() {
		super(BlockBehaviour.Properties.of(Material.METAL).lightLevel(getLightValueLit(15)).strength(1.0F).sound(SoundType.METAL));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, false).setValue(OVERLAY, AnnunciatorOverlay.INFO));
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(LIT, Boolean.valueOf(context.getLevel().hasNeighborSignal(context.getClickedPos())));
	}

	@Override
	public void neighborChanged(BlockState p_55666_, Level p_55667_, BlockPos p_55668_, Block p_55669_, BlockPos p_55670_, boolean p_55671_) {
		if (!p_55667_.isClientSide) {
			boolean flag = p_55666_.getValue(LIT);
			if (flag != p_55667_.hasNeighborSignal(p_55668_)) {
				if (flag) {
					p_55667_.scheduleTick(p_55668_, this, 4);
				} else {
					p_55667_.setBlock(p_55668_, p_55666_.cycle(LIT), 2);
				}
			}

		}
	}

	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
		if (!worldIn.isClientSide()) {
			BlockEntity tileEntity = worldIn.getBlockEntity(pos);

			if (tileEntity instanceof AnnunciatorBlockEntity) {
				MenuProvider containerProvider = createContainerProvider(worldIn, pos);
				NetworkHooks.openScreen(((ServerPlayer) player), containerProvider, tileEntity.getBlockPos());
			}
		}
		return InteractionResult.SUCCESS;
	}

	private MenuProvider createContainerProvider(Level worldIn, BlockPos pos) {
		return new MenuProvider() {
			@Override
			public Component getDisplayName() {
				return Component.translatable("screen.annunciator");
			}

			@Nullable
			@Override
			public AbstractContainerMenu createMenu(int i, Inventory playerInventory, Player playerEntity) {
				return new AnnunciatorMenu(i, worldIn, pos, playerInventory);
			}
		};
	}

	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		if (state.getValue(LIT) && !worldIn.hasNeighborSignal(pos)) {
			worldIn.setBlock(pos, state.cycle(LIT), 2);
		}
	}

	/*
	 * Forge Methods
	 */

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, LIT, OVERLAY);
	}

	@Override
	public RenderShape getRenderShape(BlockState iBlockState) {
		return RenderShape.MODEL;
	}

	private static ToIntFunction<BlockState> getLightValueLit(int lightValue) {
		return (state) -> {
			return state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
		};
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
		return new AnnunciatorBlockEntity(p_153215_, p_153216_);
	}
}