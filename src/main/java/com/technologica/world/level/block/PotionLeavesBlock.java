package com.technologica.world.level.block;
import java.util.Random;

import com.technologica.world.level.block.entity.PotionTileEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

/**
 * Special one-off class for potion leaves.
 * Created to spawn splash potions when player is nearby.
 */
public class PotionLeavesBlock extends VanillaLeavesBlock implements EntityBlock {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_7;
	private int potionType;

	public PotionLeavesBlock(int potionIn) {
		super();
		this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(DISTANCE, 7).setValue(PERSISTENT, false));
		potionType = potionIn;
	}

	/*
	 * Technologica Methods
	 */
	
	public PotionTileEntity getTileEntity(Level worldIn, BlockPos posIn) {
		return (PotionTileEntity) worldIn.getBlockEntity(posIn);
    }
	
	/*
	 * Minecraft Methods
	 */
	
	@Override
	public void randomTick(BlockState stateIn, ServerLevel worldIn, BlockPos posIn, Random randomIn) {
		PotionTileEntity tile = getTileEntity(worldIn, posIn);
		if (stateIn.getValue(DISTANCE) == 7) {
			dropResources(stateIn, worldIn, posIn);
			worldIn.removeBlock(posIn, false);
		} else if (worldIn.isEmptyBlock(posIn.below()) && stateIn.getValue(AGE) <= 6) {
			worldIn.setBlock(posIn, stateIn.setValue(AGE, Integer.valueOf(stateIn.getValue(AGE) + 1)), 7);	
			if (stateIn.getValue(AGE) == 6) {
				if (potionType == 1) {
					int potionSubType = randomIn.nextInt(11);
					if (potionSubType == 0) {
						tile.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LONG_NIGHT_VISION));
					} else if (potionSubType == 1) {
						tile.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LONG_INVISIBILITY));
					} else if (potionSubType == 2) {
						tile.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LONG_LEAPING));
					} else if (potionSubType == 3) {
						tile.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LONG_FIRE_RESISTANCE));
					} else if (potionSubType == 4) {
						tile.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LONG_SWIFTNESS));
					} else if (potionSubType == 5) {
						tile.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LONG_WATER_BREATHING));
					} else if (potionSubType == 6) {
						tile.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.STRONG_HEALING));
					} else if (potionSubType == 7) {
						tile.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LONG_REGENERATION));
					} else if (potionSubType == 8) {
						tile.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LONG_STRENGTH));
					} else if (potionSubType == 9) {
						tile.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LUCK));
					} else if (potionSubType == 10) {
						tile.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LONG_SLOW_FALLING));
					}
				} else if (potionType == 2) {
					int potionSubType = randomIn.nextInt(4) + 11;
					if (potionSubType == 11) {
						tile.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LONG_SLOWNESS));
					} else if (potionSubType == 12) {
						tile.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.STRONG_HARMING));
					} else if (potionSubType == 13) {
						tile.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LONG_POISON));
					} else if (potionSubType == 14) {
						tile.setPotionStack(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), Potions.LONG_WEAKNESS));
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
	
	/*
	 * Forge Methods
	 */

	@Override
	public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
		return new PotionTileEntity(p_153215_, p_153216_);
	}
}
