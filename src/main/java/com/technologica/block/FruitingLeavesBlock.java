package com.technologica.block;

import java.util.Random;
import java.util.function.Supplier;

import com.technologica.item.TechnologicaItems;
import com.technologica.tileentity.FruitTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

/**
 * Special one-off class for fruiting leaves.    
 * Created to add the age property as well as handle player interaction and associated tile entity.
 */
public class FruitingLeavesBlock extends VanillaLeavesBlock {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_15;
	private Supplier<Item>[] fruit;
	
	@SafeVarargs
	public FruitingLeavesBlock(Supplier<Item>... fruitIn) {
		super();
		this.setDefaultState(this.stateContainer.getBaseState().with(AGE, 0).with(DISTANCE, 7).with(PERSISTENT, false));
		fruit = fruitIn;
	}

	/*
	 * Technologica Methods
	 */
	
	public FruitTileEntity getTileEntity(World worldIn, BlockPos posIn) {
		return (FruitTileEntity) worldIn.getTileEntity(posIn);
	}

	/*
	 * Minecraft Methods
	 */

	@Override
	public void onReplaced(BlockState stateIn, World worldIn, BlockPos posIn, BlockState newStateIn, boolean isMovingIn) {
		if (!stateIn.matchesBlock(newStateIn.getBlock())) {
			FruitTileEntity tile = getTileEntity(worldIn, posIn);
			spawnAsEntity(worldIn, posIn.down(), tile.getFruitStack());
		}
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState stateIn, World worldIn, BlockPos posIn, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult hitIn) {
		FruitTileEntity tile = getTileEntity(worldIn, posIn);
		if (stateIn.get(AGE) == 15) {
			spawnAsEntity(worldIn, posIn.down(), tile.getFruitStack());
			tile.clear();
			worldIn.playSound((PlayerEntity) null, posIn, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
			worldIn.setBlockState(posIn, stateIn.with(AGE, 0), 4);
			return ActionResultType.func_233537_a_(worldIn.isRemote);
		} else {
			return ActionResultType.FAIL;
		}
	}

	@Override
	public void randomTick(BlockState stateIn, ServerWorld worldIn, BlockPos posIn, Random randomIn) {
		FruitTileEntity tile = getTileEntity(worldIn, posIn);

		if (stateIn.get(DISTANCE) == 7) {
			spawnDrops(stateIn, worldIn, posIn);
			worldIn.removeBlock(posIn, false);
		} else if (worldIn.isAirBlock(posIn.down()) && stateIn.get(AGE) <= 14) {
			if (fruit[0].get().equals(TechnologicaItems.BANANA.get()) || fruit[0].get().equals(TechnologicaItems.COCONUT.get())) {
				if (stateIn.get(DISTANCE) == 1) {
					worldIn.setBlockState(posIn, stateIn.with(AGE, stateIn.get(AGE) + 1), 7);
				}
			} else {
				worldIn.setBlockState(posIn, stateIn.with(AGE, stateIn.get(AGE) + 1), 7);
			}
				
			if (stateIn.get(AGE) == 14) {
				if (fruit[0].get().equals(Items.POTION)) {
					int potionType = randomIn.nextInt(15);
					
					if (potionType == 0) {
						tile.setFruitStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.LONG_NIGHT_VISION));
					} else if (potionType == 1) {
						tile.setFruitStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.LONG_INVISIBILITY));
					} else if (potionType == 2) {
						tile.setFruitStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.LONG_LEAPING));
					} else if (potionType == 3) {
						tile.setFruitStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.LONG_FIRE_RESISTANCE));
					} else if (potionType == 4) {
						tile.setFruitStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.LONG_SWIFTNESS));
					} else if (potionType == 5) {
						tile.setFruitStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.LONG_WATER_BREATHING));
					} else if (potionType == 6) {
						tile.setFruitStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.STRONG_HEALING));
					} else if (potionType == 7) {
						tile.setFruitStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.LONG_REGENERATION));
					} else if (potionType == 8) {
						tile.setFruitStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.LONG_STRENGTH));
					} else if (potionType == 9) {
						tile.setFruitStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.LUCK));
					} else if (potionType == 10) {
						tile.setFruitStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.LONG_SLOW_FALLING));
					} else if (potionType == 11) {
						tile.setFruitStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.LONG_SLOWNESS));
					} else if (potionType == 12) {
						tile.setFruitStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.STRONG_HARMING));
					} else if (potionType == 13) {
						tile.setFruitStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.LONG_POISON));
					} else if (potionType == 14) {
						tile.setFruitStack(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.LONG_WEAKNESS));
					}
				} else {
					tile.setFruitStack(new ItemStack(fruit[randomIn.nextInt(fruit.length)].get()));
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
		return new FruitTileEntity();
	}
}
