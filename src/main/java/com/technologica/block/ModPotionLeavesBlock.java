package com.technologica.block;
import java.util.Random;

import com.technologica.tileentity.PotionTileEntity;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class ModPotionLeavesBlock extends LeavesBlock {
	private int potionType;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_7;

	public ModPotionLeavesBlock(int potionIn) {
		super(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid());
		this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)).with(DISTANCE, Integer.valueOf(7)).with(PERSISTENT, Boolean.valueOf(false)));
		potionType = potionIn;
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new PotionTileEntity();
	}
	
	public PotionTileEntity getTileEntity(World world, BlockPos pos) {
		return (PotionTileEntity) world.getTileEntity(pos);
    }

	public boolean ticksRandomly(BlockState state) {
		return !state.get(PERSISTENT);
	}
	
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		PotionTileEntity tile = getTileEntity(worldIn, pos);
		if (state.get(DISTANCE) == 7) {
			spawnDrops(state, worldIn, pos);
			worldIn.removeBlock(pos, false);
		} else if (worldIn.isAirBlock(pos.down()) && state.get(AGE) <= 6) {
			worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(state.get(AGE) + 1)), 4);	
			if (state.get(AGE) == 6) {
				if (potionType == 1) {
					int potionSubType = random.nextInt(11);
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
					int potionSubType = random.nextInt(4) + 11;
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
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		return 30;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		return 60;
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(AGE);
		super.fillStateContainer(builder);
	}
}