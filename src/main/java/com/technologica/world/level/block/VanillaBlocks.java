package com.technologica.world.level.block;

import java.util.function.Supplier;

import org.jetbrains.annotations.Nullable;

import com.technologica.world.level.block.entity.TechnologicaSignBlockEntity;
import com.technologica.world.level.block.entity.VanillaSignBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.PotatoBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.BlockHitResult;

public class VanillaBlocks {

	static CropBlock grainCropBlock(Supplier<Item> seeds) {
		return new CropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)) {
			@Override
			protected ItemLike getBaseSeedId() {
				return seeds.get();
			}
		};
	}

	static PotatoBlock replantableCropBlock(Supplier<Item> seeds) {
		return new PotatoBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)) {
			@Override
			protected ItemLike getBaseSeedId() {
				return seeds.get();
			}
		};
	}

	static BeetrootBlock seededCropBlock(Supplier<Item> seeds) {
		return new BeetrootBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)) {
			@Override
			protected ItemLike getBaseSeedId() {
				return seeds.get();
			}
		};
	}

	static SweetBerryBushBlock bushCropBlock(Supplier<Item> clone) {
		return new SweetBerryBushBlock(BlockBehaviour.Properties.of(Material.PLANT).randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH)) {
			@Override
			public ItemStack getCloneItemStack(BlockGetter p_57256_, BlockPos p_57257_, BlockState p_57258_) {
				return new ItemStack(clone.get());
			}

			@Override
			public InteractionResult use(BlockState p_57275_, Level p_57276_, BlockPos p_57277_, Player p_57278_, InteractionHand p_57279_, BlockHitResult p_57280_) {
				int i = p_57275_.getValue(AGE);
				boolean flag = i == 3;
				if (!flag && p_57278_.getItemInHand(p_57279_).is(Items.BONE_MEAL)) {
					return InteractionResult.PASS;
				} else if (i > 1) {
					int j = 1 + p_57276_.random.nextInt(2);
					popResource(p_57276_, p_57277_, new ItemStack(clone.get(), j + (flag ? 1 : 0)));
					p_57276_.playSound((Player) null, p_57277_, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + p_57276_.random.nextFloat() * 0.4F);
					p_57276_.setBlock(p_57277_, p_57275_.setValue(AGE, Integer.valueOf(1)), 2);
					return InteractionResult.sidedSuccess(p_57276_.isClientSide);
				} else {
					return super.use(p_57275_, p_57276_, p_57277_, p_57278_, p_57279_, p_57280_);
				}
			}

			@Override
			public BlockPathTypes getBlockPathType(BlockState state, BlockGetter level, BlockPos pos, @Nullable Mob mob) {
				return BlockPathTypes.DAMAGE_OTHER;
			}

			@Override
			public BlockPathTypes getAdjacentBlockPathType(BlockState state, BlockGetter level, BlockPos pos, @Nullable Mob mob, BlockPathTypes originalType) {
				return BlockPathTypes.DANGER_OTHER;
			}

			@Override
			public int getFlammability(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 60;
			}

			@Override
			public int getFireSpreadSpeed(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 100;
			}
		};
	}

	static LeavesBlock leavesBlock() {
		return new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()) {
			@Override
			public int getFlammability(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 30;
			}

			@Override
			public int getFireSpreadSpeed(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 60;
			}
		};
	}

	static RotatedPillarBlock logBlock(MaterialColor p_50789_, MaterialColor p_50790_) {
		return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (p_152624_) -> {
			return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? p_50789_ : p_50790_;
		}).strength(2.0F).sound(SoundType.WOOD)) {
			@Override
			public int getFlammability(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 5;
			}

			@Override
			public int getFireSpreadSpeed(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 5;
			}
		};
	}

	static Block planksBlock() {
		return new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)) {
			@Override
			public int getFlammability(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 5;
			}

			@Override
			public int getFireSpreadSpeed(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 20;
			}
		};
	}

	static SlabBlock slabBlock() {
		return new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)) {
			@Override
			public int getFlammability(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 5;
			}

			@Override
			public int getFireSpreadSpeed(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 20;
			}
		};
	}

	static StairBlock stairBlock(Supplier<BlockState> state) {
		return new StairBlock(state, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)) {
			@Override
			public int getFlammability(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 5;
			}

			@Override
			public int getFireSpreadSpeed(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 20;
			}
		};
	}

	static Block bookshelfBlock() {
		return new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(1.5F).sound(SoundType.WOOD)) {
			@Override
			public int getFlammability(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 30;
			}

			@Override
			public int getFireSpreadSpeed(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 20;
			}
		};
	}

	static FenceBlock fenceBlock() {
		return new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)) {
			@Override
			public int getFlammability(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 5;
			}

			@Override
			public int getFireSpreadSpeed(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 20;
			}
		};
	}

	static FenceGateBlock fenceGateBlock() {
		return new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD), SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN) {
			@Override
			public int getFlammability(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 5;
			}

			@Override
			public int getFireSpreadSpeed(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 20;
			}
		};
	}

	static StandingSignBlock standingSignBlock(WoodType typeIn) {
		return new StandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), typeIn) {
			@Override
			public BlockEntity newBlockEntity(BlockPos p_154556_, BlockState p_154557_) {
				return new VanillaSignBlockEntity(p_154556_, p_154557_);
			}
		};
	}

	static WallSignBlock wallSignBlock(WoodType typeIn) {
		return new WallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), typeIn) {
			@Override
			public BlockEntity newBlockEntity(BlockPos p_154556_, BlockState p_154557_) {
				return new VanillaSignBlockEntity(p_154556_, p_154557_);
			}
		};
	}

	static StandingSignBlock technologicaStandingSignBlock(WoodType typeIn) {
		return new StandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), typeIn) {
			@Override
			public BlockEntity newBlockEntity(BlockPos p_154556_, BlockState p_154557_) {
				return new TechnologicaSignBlockEntity(p_154556_, p_154557_);
			}
		};
	}

	static WallSignBlock technologicaWallSignBlock(WoodType typeIn) {
		return new WallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), typeIn) {
			@Override
			public BlockEntity newBlockEntity(BlockPos p_154556_, BlockState p_154557_) {
				return new TechnologicaSignBlockEntity(p_154556_, p_154557_);
			}
		};
	}

	static ButtonBlock woodenButton() {
		return woodenButton(SoundType.WOOD, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON);
	}

	private static ButtonBlock woodenButton(SoundType p_249282_, SoundEvent p_251988_, SoundEvent p_251887_) {
		return new ButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(p_249282_), 30, true, p_251988_, p_251887_);
	}

	static Boolean never(BlockState p_50779_, BlockGetter p_50780_, BlockPos p_50781_, EntityType<?> p_50782_) {
		return (boolean) false;
	}
}
