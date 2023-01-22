package com.technologica.world.level.block;

import javax.annotation.Nullable;

import com.technologica.util.MiddleEnd;
import com.technologica.world.inventory.SawmillMenu;
import com.technologica.world.level.block.entity.SawmillBlockEntity;
import com.technologica.world.level.block.state.properties.TechnologicaBlockStateProperties;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;

/**
 * Special one-off class for the sawmill. Created to handle player interaction and associated tile entity.
 */
public class SawmillBlock extends FourDirectionBlock implements EntityBlock {
	public static final BooleanProperty BOTTOM = BlockStateProperties.BOTTOM;
	public static final EnumProperty<MiddleEnd> MIDDLE_END = TechnologicaBlockStateProperties.MIDDLE_END;

	protected SawmillBlock() {
		super(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.ANVIL).noOcclusion());
		this.registerDefaultState(this.stateDefinition.any().setValue(NESW_FACING, Direction.NORTH).setValue(BOTTOM, false).setValue(MIDDLE_END, MiddleEnd.MIDDLE));
	}

	/*
	 * Technologica Methods
	 */

	public SawmillBlockEntity getTileEntity(Level worldIn, BlockPos posIn) {
		return (SawmillBlockEntity) worldIn.getBlockEntity(posIn);
	}

	/*
	 * Minecraft Methods
	 */

	@Override
	public InteractionResult use(BlockState stateIn, Level worldIn, BlockPos posIn, Player playerIn, InteractionHand handIn, BlockHitResult hitIn) {
		if (!worldIn.isClientSide()) {
			BlockEntity tileEntity = worldIn.getBlockEntity(posIn);
			if (tileEntity instanceof SawmillBlockEntity) {
				MenuProvider containerProvider = createContainerProvider(worldIn, posIn);
				NetworkHooks.openScreen(((ServerPlayer) playerIn), containerProvider, tileEntity.getBlockPos());
			}
		}
		return InteractionResult.SUCCESS;

	}

	@Override
	public void animateTick(BlockState stateIn, Level worldIn, BlockPos posIn, RandomSource randomIn) {
		if (getTileEntity(worldIn, posIn).isSawing()) {
			double d0 = posIn.getX() + randomIn.nextDouble();
			double d1 = posIn.getY() + 2.0D;
			double d2 = posIn.getZ() + randomIn.nextDouble();
			worldIn.addParticle(ParticleTypes.POOF, d0, d1, d2, 0.0D, 0.0D, 0.0D);
			worldIn.addParticle(new BlockParticleOption(ParticleTypes.FALLING_DUST, stateIn), d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
	}

	/*
	 * Forge Methods
	 */

	@Override
	public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
		return new SawmillBlockEntity(p_153215_, p_153216_);
	}

	@Override
	@Nullable
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> type) {
		return level.isClientSide ? null : (lvl, pos, blockState2, t) -> {
			if (t instanceof SawmillBlockEntity tile) {
				tile.serverTick();
			}
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builderIn) {
		builderIn.add(BOTTOM);
		builderIn.add(MIDDLE_END);
		super.createBlockStateDefinition(builderIn);
	}

	private MenuProvider createContainerProvider(Level worldIn, BlockPos pos) {
		return new MenuProvider() {
			@Override
			public Component getDisplayName() {
				return Component.translatable("screen.sawmill");
			}

			@Nullable
			@Override
			public AbstractContainerMenu createMenu(int i, Inventory playerInventory, Player playerEntity) {
				return new SawmillMenu(i, worldIn, pos, playerInventory);
			}
		};
	}
}