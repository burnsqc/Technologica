package com.technologica.world.level.block;

import java.util.function.Supplier;

import com.technologica.registration.deferred.TechnologicaItems;
import com.technologica.world.level.block.entity.FruitBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
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
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

/**
 * Special one-off class for fruiting leaves. Created to add the age property as well as handle player interaction and associated tile entity.
 */
public class FruitingLeavesBlock extends LeavesBlock implements EntityBlock {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_15;
	private Supplier<Item>[] fruit;

	@SafeVarargs
	public FruitingLeavesBlock(Supplier<Item>... fruitIn) {
		super(BlockBehaviour.Properties.of().strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion());
		this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(DISTANCE, 7).setValue(PERSISTENT, false));
		fruit = fruitIn;
	}

	/*
	 * Technologica Methods
	 */

	public FruitBlockEntity getTileEntity(Level worldIn, BlockPos posIn) {
		return (FruitBlockEntity) worldIn.getBlockEntity(posIn);
	}

	/*
	 * Minecraft Methods
	 */

	@Override
	public void onRemove(BlockState stateIn, Level worldIn, BlockPos posIn, BlockState newStateIn, boolean isMovingIn) {
		if (!stateIn.is(newStateIn.getBlock())) {
			FruitBlockEntity tile = getTileEntity(worldIn, posIn);
			popResource(worldIn, posIn.below(), tile.getFruitStack());
		}
	}

	@Override
	public InteractionResult use(BlockState stateIn, Level worldIn, BlockPos posIn, Player playerIn, InteractionHand handIn, BlockHitResult hitIn) {
		FruitBlockEntity tile = getTileEntity(worldIn, posIn);
		if (stateIn.getValue(AGE) == 15) {
			popResource(worldIn, posIn.below(), tile.getFruitStack());
			tile.setFruitStack(ItemStack.EMPTY);
			worldIn.playSound((Player) null, posIn, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + worldIn.random.nextFloat() * 0.4F);
			worldIn.setBlock(posIn, stateIn.setValue(AGE, 0), 4);
			return InteractionResult.sidedSuccess(worldIn.isClientSide);
		} else {
			return InteractionResult.FAIL;
		}
	}

	@Override
	public void randomTick(BlockState stateIn, ServerLevel worldIn, BlockPos posIn, RandomSource randomIn) {
		FruitBlockEntity tile = getTileEntity(worldIn, posIn);

		if (stateIn.getValue(DISTANCE) == 7) {
			dropResources(stateIn, worldIn, posIn);
			worldIn.removeBlock(posIn, false);
		} else if (worldIn.isEmptyBlock(posIn.below()) && stateIn.getValue(AGE) <= 14) {
			if (fruit[0].get().equals(TechnologicaItems.BANANA.get()) || fruit[0].get().equals(TechnologicaItems.COCONUT.get())) {
				if (stateIn.getValue(DISTANCE) == 1) {
					worldIn.setBlock(posIn, stateIn.setValue(AGE, stateIn.getValue(AGE) + 1), 7);
				}
			} else {
				worldIn.setBlock(posIn, stateIn.setValue(AGE, stateIn.getValue(AGE) + 1), 7);
			}

			if (stateIn.getValue(AGE) == 14) {
				if (fruit[0].get().equals(Items.POTION)) {
					int potionType = randomIn.nextInt(15);

					if (potionType == 0) {
						tile.setFruitStack(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LONG_NIGHT_VISION));
					} else if (potionType == 1) {
						tile.setFruitStack(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LONG_INVISIBILITY));
					} else if (potionType == 2) {
						tile.setFruitStack(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LONG_LEAPING));
					} else if (potionType == 3) {
						tile.setFruitStack(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LONG_FIRE_RESISTANCE));
					} else if (potionType == 4) {
						tile.setFruitStack(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LONG_SWIFTNESS));
					} else if (potionType == 5) {
						tile.setFruitStack(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LONG_WATER_BREATHING));
					} else if (potionType == 6) {
						tile.setFruitStack(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.STRONG_HEALING));
					} else if (potionType == 7) {
						tile.setFruitStack(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LONG_REGENERATION));
					} else if (potionType == 8) {
						tile.setFruitStack(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LONG_STRENGTH));
					} else if (potionType == 9) {
						tile.setFruitStack(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LUCK));
					} else if (potionType == 10) {
						tile.setFruitStack(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LONG_SLOW_FALLING));
					} else if (potionType == 11) {
						tile.setFruitStack(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LONG_SLOWNESS));
					} else if (potionType == 12) {
						tile.setFruitStack(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.STRONG_HARMING));
					} else if (potionType == 13) {
						tile.setFruitStack(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LONG_POISON));
					} else if (potionType == 14) {
						tile.setFruitStack(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LONG_WEAKNESS));
					}
				} else {
					tile.setFruitStack(new ItemStack(fruit[randomIn.nextInt(fruit.length)].get()));
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
		return new FruitBlockEntity(p_153215_, p_153216_);
	}

	@Override
	public int getFlammability(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
		return 30;
	}

	@Override
	public int getFireSpreadSpeed(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
		return 60;
	}
}
