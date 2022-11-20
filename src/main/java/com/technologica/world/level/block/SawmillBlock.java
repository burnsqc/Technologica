package com.technologica.world.level.block;

import javax.annotation.Nullable;

import com.technologica.util.MiddleEnd;
import com.technologica.world.item.TechnologicaItems;
import com.technologica.world.level.block.entity.SawmillBlockEntity;
import com.technologica.world.level.block.state.properties.TechnologicaBlockStateProperties;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
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
import net.minecraftforge.registries.ForgeRegistries;

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
		SawmillBlockEntity tile = getTileEntity(worldIn, posIn);
		ItemStack itemstack = playerIn.getItemInHand(handIn);
		Item item = playerIn.getItemInHand(handIn).getItem();

		if (tile.getLog().isEmpty()) {
			if (item == TechnologicaItems.SAWBLADE.get()) {
				tile.setBlade(true);
				worldIn.playSound((Player) null, posIn, SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 0.25F, 1.0F + worldIn.random.nextFloat() * 0.4F);
				itemstack.shrink(1);
			} else if (ForgeRegistries.ITEMS.tags().getTag(ItemTags.LOGS).contains(itemstack.getItem())) {
				tile.setLog(new ItemStack(itemstack.getItem(), 1));
				worldIn.playSound((Player) null, posIn, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 0.25F, 1.0F + worldIn.random.nextFloat() * 0.4F);
				itemstack.shrink(1);
				playerIn.getInventory().setItem(playerIn.getInventory().selected, itemstack);
				playerIn.containerMenu.broadcastChanges();
			} else if (item == TechnologicaItems.SAWMILL_BLUEPRINT.get()) {
				if (stateIn.getValue(NESW_FACING) == Direction.NORTH) {
					if (worldIn.getBlockState(posIn.below()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.south()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.south().south()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.north()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.north().north()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.below().south()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.below().south().south()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.below().north()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.below().north().north()).getBlock() instanceof SawmillBlock) {
						worldIn.setBlock(posIn, stateIn.setValue(MIDDLE_END, MiddleEnd.MIDDLE), UPDATE_ALL);
						worldIn.setBlock(posIn.north(), stateIn.setValue(MIDDLE_END, MiddleEnd.MIDDLE), UPDATE_ALL);
						worldIn.setBlock(posIn.north().north(), stateIn.setValue(MIDDLE_END, MiddleEnd.RIGHT), UPDATE_ALL);
						worldIn.setBlock(posIn.south(), stateIn.setValue(MIDDLE_END, MiddleEnd.MIDDLE), UPDATE_ALL);
						worldIn.setBlock(posIn.south().south(), stateIn.setValue(MIDDLE_END, MiddleEnd.LEFT), UPDATE_ALL);
						worldIn.setBlock(posIn.below(), stateIn.setValue(BOTTOM, true), UPDATE_ALL);
						worldIn.setBlock(posIn.below().north(), stateIn.setValue(BOTTOM, true), UPDATE_ALL);
						worldIn.setBlock(posIn.below().north().north(), stateIn.setValue(BOTTOM, true), UPDATE_ALL);
						worldIn.setBlock(posIn.below().south(), stateIn.setValue(BOTTOM, true), UPDATE_ALL);
						worldIn.setBlock(posIn.below().south().south(), stateIn.setValue(BOTTOM, true), UPDATE_ALL);
					}
				}
				if (stateIn.getValue(NESW_FACING) == Direction.EAST) {
					if (worldIn.getBlockState(posIn.below()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.west()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.west().west()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.east()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.east().east()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.below().west()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.below().west().west()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.below().east()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.below().east().east()).getBlock() instanceof SawmillBlock) {
						worldIn.setBlock(posIn, stateIn.setValue(MIDDLE_END, MiddleEnd.MIDDLE), UPDATE_ALL);
						worldIn.setBlock(posIn.east(), stateIn.setValue(MIDDLE_END, MiddleEnd.MIDDLE), UPDATE_ALL);
						worldIn.setBlock(posIn.east().east(), stateIn.setValue(MIDDLE_END, MiddleEnd.RIGHT), UPDATE_ALL);
						worldIn.setBlock(posIn.west(), stateIn.setValue(MIDDLE_END, MiddleEnd.MIDDLE), UPDATE_ALL);
						worldIn.setBlock(posIn.west().west(), stateIn.setValue(MIDDLE_END, MiddleEnd.LEFT), UPDATE_ALL);
						worldIn.setBlock(posIn.below(), stateIn.setValue(BOTTOM, true), UPDATE_ALL);
						worldIn.setBlock(posIn.below().east(), stateIn.setValue(BOTTOM, true), UPDATE_ALL);
						worldIn.setBlock(posIn.below().east().east(), stateIn.setValue(BOTTOM, true), UPDATE_ALL);
						worldIn.setBlock(posIn.below().west(), stateIn.setValue(BOTTOM, true), UPDATE_ALL);
						worldIn.setBlock(posIn.below().west().west(), stateIn.setValue(BOTTOM, true), UPDATE_ALL);
					}
				}
				if (stateIn.getValue(NESW_FACING) == Direction.SOUTH) {
					if (worldIn.getBlockState(posIn.below()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.south()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.south().south()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.north()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.north().north()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.below().south()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.below().south().south()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.below().north()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.below().north().north()).getBlock() instanceof SawmillBlock) {
						worldIn.setBlock(posIn, stateIn.setValue(MIDDLE_END, MiddleEnd.MIDDLE), UPDATE_ALL);
						worldIn.setBlock(posIn.north(), stateIn.setValue(MIDDLE_END, MiddleEnd.MIDDLE), UPDATE_ALL);
						worldIn.setBlock(posIn.north().north(), stateIn.setValue(MIDDLE_END, MiddleEnd.RIGHT), UPDATE_ALL);
						worldIn.setBlock(posIn.south(), stateIn.setValue(MIDDLE_END, MiddleEnd.MIDDLE), UPDATE_ALL);
						worldIn.setBlock(posIn.south().south(), stateIn.setValue(MIDDLE_END, MiddleEnd.LEFT), UPDATE_ALL);
						worldIn.setBlock(posIn.below(), stateIn.setValue(BOTTOM, true), UPDATE_ALL);
						worldIn.setBlock(posIn.below().north(), stateIn.setValue(BOTTOM, true), UPDATE_ALL);
						worldIn.setBlock(posIn.below().north().north(), stateIn.setValue(BOTTOM, true), UPDATE_ALL);
						worldIn.setBlock(posIn.below().south(), stateIn.setValue(BOTTOM, true), UPDATE_ALL);
						worldIn.setBlock(posIn.below().south().south(), stateIn.setValue(BOTTOM, true), UPDATE_ALL);
					}
				}
				if (stateIn.getValue(NESW_FACING) == Direction.WEST) {
					if (worldIn.getBlockState(posIn.below()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.west()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.west().west()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.east()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.east().east()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.below().west()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.below().west().west()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.below().east()).getBlock() instanceof SawmillBlock && worldIn.getBlockState(posIn.below().east().east()).getBlock() instanceof SawmillBlock) {
						worldIn.setBlock(posIn, stateIn.setValue(MIDDLE_END, MiddleEnd.MIDDLE), UPDATE_ALL);
						worldIn.setBlock(posIn.east(), stateIn.setValue(MIDDLE_END, MiddleEnd.MIDDLE), UPDATE_ALL);
						worldIn.setBlock(posIn.east().east(), stateIn.setValue(MIDDLE_END, MiddleEnd.RIGHT), UPDATE_ALL);
						worldIn.setBlock(posIn.west(), stateIn.setValue(MIDDLE_END, MiddleEnd.MIDDLE), UPDATE_ALL);
						worldIn.setBlock(posIn.west().west(), stateIn.setValue(MIDDLE_END, MiddleEnd.LEFT), UPDATE_ALL);
						worldIn.setBlock(posIn.below(), stateIn.setValue(BOTTOM, true), UPDATE_ALL);
						worldIn.setBlock(posIn.below().east(), stateIn.setValue(BOTTOM, true), UPDATE_ALL);
						worldIn.setBlock(posIn.below().east().east(), stateIn.setValue(BOTTOM, true), UPDATE_ALL);
						worldIn.setBlock(posIn.below().west(), stateIn.setValue(BOTTOM, true), UPDATE_ALL);
						worldIn.setBlock(posIn.below().west().west(), stateIn.setValue(BOTTOM, true), UPDATE_ALL);
					}
				}
				itemstack.shrink(1);
			}
		}
		return InteractionResult.sidedSuccess(worldIn.isClientSide);
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
		if (level.isClientSide()) {
			return (lvl, pos, blockState2, t) -> {
				if (t instanceof SawmillBlockEntity tile) {
					tile.clientTick();
				}
			};
		}
		return (lvl, pos, blockState2, t) -> {
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
}