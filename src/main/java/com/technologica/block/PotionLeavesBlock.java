package com.technologica.block;
import java.util.Random;

import com.technologica.tileentity.PotionTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

/**
 * Special one-off class for potion leaves.
 * Created to spawn splash potions when player is nearby.
 */
public class PotionLeavesBlock extends VanillaLeavesBlock {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_7;
	private int potionType;

	public PotionLeavesBlock(int potionIn) {
		super();
		this.setDefaultState(this.stateContainer.getBaseState().with(AGE, 0).with(DISTANCE, 7).with(PERSISTENT, false));
		potionType = potionIn;
	}

	/*
	 * Technologica Methods
	 */
	
	public PotionTileEntity getTileEntity(World worldIn, BlockPos posIn) {
		return (PotionTileEntity) worldIn.getTileEntity(posIn);
    }
	
	/*
	 * Minecraft Methods
	 */
	
	@Override
	public void randomTick(BlockState stateIn, ServerWorld worldIn, BlockPos posIn, Random randomIn) {
		PotionTileEntity tile = getTileEntity(worldIn, posIn);
		if (stateIn.get(DISTANCE) == 7) {
			spawnDrops(stateIn, worldIn, posIn);
			worldIn.removeBlock(posIn, false);
		} else if (worldIn.isAirBlock(posIn.down()) && stateIn.get(AGE) <= 6) {
			worldIn.setBlockState(posIn, stateIn.with(AGE, Integer.valueOf(stateIn.get(AGE) + 1)), 7);	
			if (stateIn.get(AGE) == 6) {
				if (potionType == 1) {
					int potionSubType = randomIn.nextInt(11);
					if (potionSubType == 0) {
						tile.setPotionStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), Potions.LONG_NIGHT_VISION));
					} else if (potionSubType == 1) {
						tile.setPotionStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), Potions.LONG_INVISIBILITY));
					} else if (potionSubType == 2) {
						tile.setPotionStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), Potions.LONG_LEAPING));
					} else if (potionSubType == 3) {
						tile.setPotionStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), Potions.LONG_FIRE_RESISTANCE));
					} else if (potionSubType == 4) {
						tile.setPotionStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), Potions.LONG_SWIFTNESS));
					} else if (potionSubType == 5) {
						tile.setPotionStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), Potions.LONG_WATER_BREATHING));
					} else if (potionSubType == 6) {
						tile.setPotionStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), Potions.STRONG_HEALING));
					} else if (potionSubType == 7) {
						tile.setPotionStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), Potions.LONG_REGENERATION));
					} else if (potionSubType == 8) {
						tile.setPotionStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), Potions.LONG_STRENGTH));
					} else if (potionSubType == 9) {
						tile.setPotionStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), Potions.LUCK));
					} else if (potionSubType == 10) {
						tile.setPotionStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), Potions.LONG_SLOW_FALLING));
					}
				} else if (potionType == 2) {
					int potionSubType = randomIn.nextInt(4) + 11;
					if (potionSubType == 11) {
						tile.setPotionStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), Potions.LONG_SLOWNESS));
					} else if (potionSubType == 12) {
						tile.setPotionStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), Potions.STRONG_HARMING));
					} else if (potionSubType == 13) {
						tile.setPotionStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), Potions.LONG_POISON));
					} else if (potionSubType == 14) {
						tile.setPotionStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), Potions.LONG_WEAKNESS));
					}				
				}
			}
		}	
	}
	
	@Override
	public boolean ticksRandomly(BlockState stateIn) {
		return !stateIn.get(PERSISTENT);
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builderIn) {
		builderIn.add(AGE);
		super.fillStateContainer(builderIn);
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
		return new PotionTileEntity();
	}
}
