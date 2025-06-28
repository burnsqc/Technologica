package com.technologica.world.level.block;

import javax.annotation.Nullable;

import com.technologica.world.level.block.entity.PotionBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class PotionLeavesBlock extends LeavesBlock implements EntityBlock {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_7;
	private int potionType;

	public PotionLeavesBlock(int potionIn) {
		super(BlockBehaviour.Properties.of().strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion());
		this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(DISTANCE, 7).setValue(PERSISTENT, false));
		potionType = potionIn;
	}

	@Override
	public void randomTick(BlockState stateIn, ServerLevel worldIn, BlockPos posIn, RandomSource randomIn) {
		PotionBlockEntity potionBlockEntity = (PotionBlockEntity) worldIn.getBlockEntity(posIn);
		if (stateIn.getValue(DISTANCE) == 7) {
			dropResources(stateIn, worldIn, posIn);
			worldIn.removeBlock(posIn, false);
		} else if (worldIn.isEmptyBlock(posIn.below()) && stateIn.getValue(AGE) <= 6) {
			worldIn.setBlock(posIn, stateIn.setValue(AGE, Integer.valueOf(stateIn.getValue(AGE) + 1)), 7);
			if (stateIn.getValue(AGE) == 6) {
				if (potionType == 1) {
					int potionSubType = randomIn.nextInt(11);
					if (potionSubType == 0) {
						potionBlockEntity.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LONG_NIGHT_VISION));
					} else if (potionSubType == 1) {
						potionBlockEntity.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LONG_INVISIBILITY));
					} else if (potionSubType == 2) {
						potionBlockEntity.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LONG_LEAPING));
					} else if (potionSubType == 3) {
						potionBlockEntity.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LONG_FIRE_RESISTANCE));
					} else if (potionSubType == 4) {
						potionBlockEntity.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LONG_SWIFTNESS));
					} else if (potionSubType == 5) {
						potionBlockEntity.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LONG_WATER_BREATHING));
					} else if (potionSubType == 6) {
						potionBlockEntity.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.STRONG_HEALING));
					} else if (potionSubType == 7) {
						potionBlockEntity.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LONG_REGENERATION));
					} else if (potionSubType == 8) {
						potionBlockEntity.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LONG_STRENGTH));
					} else if (potionSubType == 9) {
						potionBlockEntity.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LUCK));
					} else if (potionSubType == 10) {
						potionBlockEntity.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LONG_SLOW_FALLING));
					}
				} else if (potionType == 2) {
					int potionSubType = randomIn.nextInt(4) + 11;
					if (potionSubType == 11) {
						potionBlockEntity.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LONG_SLOWNESS));
					} else if (potionSubType == 12) {
						potionBlockEntity.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.STRONG_HARMING));
					} else if (potionSubType == 13) {
						potionBlockEntity.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LONG_POISON));
					} else if (potionSubType == 14) {
						potionBlockEntity.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LONG_WEAKNESS));
					}
				}
			}
		}
	}

	@Override
	public boolean isRandomlyTicking(BlockState stateIn) {
		return !stateIn.getValue(PERSISTENT);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builderIn) {
		builderIn.add(AGE);
		super.createBlockStateDefinition(builderIn);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
		return new PotionBlockEntity(blockPos, blockState);
	}

	@Override
	@Nullable
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
		if (level.isClientSide()) {
			return null;
		}
		return (lvl, pos, blockState2, t) -> {
			if (t instanceof PotionBlockEntity potionBlockEntity) {
				potionBlockEntity.tick();
			}
		};
	}

	@Override
	public int getFlammability(BlockState blockState, BlockGetter worldIn, BlockPos blockPos, Direction faceIn) {
		return 30;
	}

	@Override
	public int getFireSpreadSpeed(BlockState blockState, BlockGetter worldIn, BlockPos blockPos, Direction faceIn) {
		return 60;
	}
}
