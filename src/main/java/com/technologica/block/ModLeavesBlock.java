package com.technologica.block;
import java.util.Random;

import com.technologica.setup.Registration;
import com.technologica.tileentity.FruitTileEntity;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class ModLeavesBlock extends LeavesBlock {
	private int fruitType;
	private boolean randomFruit;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_7;

	public ModLeavesBlock(int fruitIn) {
		super(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid());
		this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)).with(DISTANCE, Integer.valueOf(7)).with(PERSISTENT, Boolean.valueOf(false)));
		if (fruitIn != 10) {
			fruitType = fruitIn;
		} else {
			randomFruit = true;
		}
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new FruitTileEntity();
	}
	
	public FruitTileEntity getTileEntity(World world, BlockPos pos) {
        return (FruitTileEntity) world.getTileEntity(pos);
    }

	public boolean ticksRandomly(BlockState state) {
		return !state.get(PERSISTENT);
	}

	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		FruitTileEntity tile = getTileEntity(worldIn, pos);
		if (state.get(DISTANCE) == 7) {
			spawnDrops(state, worldIn, pos);
			worldIn.removeBlock(pos, false);
		} else if (worldIn.isAirBlock(pos.down()) && state.get(AGE) <= 6) {
			if (fruitType != 1 && fruitType != 3) {
				worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(state.get(AGE) + 1)), 4);
			} else {
				if (state.get(DISTANCE) == 1) {
					worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(state.get(AGE) + 1)), 4);
				}
			}			
			if (state.get(AGE) == 6) {
				if (randomFruit == true) {
					fruitType = random.nextInt(9) + 1;
				}
				if (fruitType == 1) {
					if (state.get(DISTANCE) == 1 || randomFruit == true) {
						tile.setFruitStack(new ItemStack(Registration.BANANA.get()));
					}
				} else if (fruitType == 2) {
					tile.setFruitStack(new ItemStack(Registration.CHERRY.get()));
				} else if (fruitType == 3) {
					if (state.get(DISTANCE) == 1 || randomFruit == true) {
						tile.setFruitStack(new ItemStack(Registration.COCONUT.get()));
					}
				} else if (fruitType == 4) {
					tile.setFruitStack(new ItemStack(Registration.KIWI.get()));
				} else if (fruitType == 5) {
					tile.setFruitStack(new ItemStack(Registration.LEMON.get()));
				} else if (fruitType == 6) {
					tile.setFruitStack(new ItemStack(Registration.LIME.get()));
				} else if (fruitType == 7) {
					tile.setFruitStack(new ItemStack(Registration.ORANGE.get()));
				} else if (fruitType == 8) {
					tile.setFruitStack(new ItemStack(Registration.PEACH.get()));
				} else if (fruitType == 9) {
					tile.setFruitStack(new ItemStack(Registration.PEAR.get()));
				} else if (fruitType == 11) {
					int potionType = random.nextInt(15);
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
				}
			}
		}	
	}

	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		FruitTileEntity tile = getTileEntity(worldIn, pos);
		if (state.get(AGE) == 7) {
			if (fruitType <= 10) {
				spawnAsEntity(worldIn, pos.down(), new ItemStack(tile.getFruitStack().getItem(), 1).getStack());
				tile.clear();
				worldIn.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
				worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(0)), 4);
				return ActionResultType.func_233537_a_(worldIn.isRemote);
			} else {
				spawnAsEntity(worldIn, pos.down(), tile.getFruitStack());
				tile.clear();
				worldIn.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
				worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(0)), 4);
				return ActionResultType.func_233537_a_(worldIn.isRemote);
			}
		} else {
			return ActionResultType.FAIL;
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