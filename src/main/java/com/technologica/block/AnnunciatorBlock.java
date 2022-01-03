package com.technologica.block;

import java.util.Random;
import java.util.function.ToIntFunction;

import javax.annotation.Nullable;

import com.technologica.inventory.container.AnnunciatorContainer;
import com.technologica.state.properties.TechnologicaBlockStateProperties;
import com.technologica.tileentity.AnnunciatorTileEntity;
import com.technologica.util.AnnunciatorOverlay;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkHooks;

public class AnnunciatorBlock extends ContainerBlock {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	public static final BooleanProperty LIT = BlockStateProperties.LIT;
	public static final EnumProperty<AnnunciatorOverlay> OVERLAY = TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY;

	public AnnunciatorBlock() {
		super(AbstractBlock.Properties.create(Material.IRON).setLightLevel(getLightValueLit(15)).hardnessAndResistance(1.0F).sound(SoundType.METAL));
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(LIT, false)
				.with(OVERLAY, AnnunciatorOverlay.INFO));
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite()).with(LIT,
				Boolean.valueOf(context.getWorld().isBlockPowered(context.getPos())));
	}

	@Override
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos,
			boolean isMoving) {
		if (!worldIn.isRemote) {
			boolean flag = state.get(LIT);
			if (flag != worldIn.isBlockPowered(pos)) {
				if (flag) {
					worldIn.getPendingBlockTicks().scheduleTick(pos, this, 4);
				} else {
					worldIn.setBlockState(pos, state.cycleValue(LIT), 2);
				}
			}

		}
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		if (!worldIn.isRemote()) {
			TileEntity tileEntity = worldIn.getTileEntity(pos);

			if (tileEntity instanceof AnnunciatorTileEntity) {
				INamedContainerProvider containerProvider = createContainerProvider(worldIn, pos);
				NetworkHooks.openGui(((ServerPlayerEntity) player), containerProvider, tileEntity.getPos());
			}
		}
		return ActionResultType.SUCCESS;
	}

	private INamedContainerProvider createContainerProvider(World worldIn, BlockPos pos) {
		return new INamedContainerProvider() {
			@Override
			public ITextComponent getDisplayName() {
				return new TranslationTextComponent("screen.annunciator");
			}

			@Nullable
			@Override
			public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
				return new AnnunciatorContainer(i, worldIn, pos, playerInventory);
			}
		};
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		if (state.get(LIT) && !worldIn.isBlockPowered(pos)) {
			worldIn.setBlockState(pos, state.cycleValue(LIT), 2);
		}
	}

	/*
	 * Forge Methods
	 */

	@Override
	public boolean hasTileEntity(BlockState stateIn) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState stateIn, IBlockReader worldIn) {
		return new AnnunciatorTileEntity();
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING, LIT, OVERLAY);
	}

	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return new AnnunciatorTileEntity();
	}

	@Override
	public BlockRenderType getRenderType(BlockState iBlockState) {
		return BlockRenderType.MODEL;
	}
	
	private static ToIntFunction<BlockState> getLightValueLit(int lightValue) {
		return (state) -> {
			return state.get(BlockStateProperties.LIT) ? lightValue : 0;
		};
	}
}