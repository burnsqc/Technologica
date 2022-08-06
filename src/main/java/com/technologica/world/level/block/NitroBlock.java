package com.technologica.world.level.block;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class NitroBlock extends Block {
	public static final BooleanProperty UNSTABLE = BlockStateProperties.UNSTABLE;

	public NitroBlock(BlockBehaviour.Properties p_57422_) {
		super(p_57422_);
		this.registerDefaultState(this.defaultBlockState().setValue(UNSTABLE, Boolean.valueOf(false)));
	}

	@Override
	public void onCaughtFire(BlockState state, Level world, BlockPos pos, @Nullable net.minecraft.core.Direction face, @Nullable LivingEntity igniter) {
		explode(world, pos, igniter);
	}

	@Override
	public void onPlace(BlockState p_57466_, Level p_57467_, BlockPos p_57468_, BlockState p_57469_, boolean p_57470_) {
		if (!p_57469_.is(p_57466_.getBlock())) {
			if (p_57467_.hasNeighborSignal(p_57468_)) {
				onCaughtFire(p_57466_, p_57467_, p_57468_, null, null);
				p_57467_.removeBlock(p_57468_, false);
			}
		}
	}

	@Override
	public void neighborChanged(BlockState p_57457_, Level p_57458_, BlockPos p_57459_, Block p_57460_, BlockPos p_57461_, boolean p_57462_) {
		if (p_57458_.hasNeighborSignal(p_57459_)) {
			onCaughtFire(p_57457_, p_57458_, p_57459_, null, null);
			p_57458_.removeBlock(p_57459_, false);
		}
	}

	@Override
	public void playerWillDestroy(Level p_57445_, BlockPos p_57446_, BlockState p_57447_, Player p_57448_) {
		if (!p_57445_.isClientSide() && !p_57448_.isCreative() && p_57447_.getValue(UNSTABLE)) {
			onCaughtFire(p_57447_, p_57445_, p_57446_, null, null);
		}

		super.playerWillDestroy(p_57445_, p_57446_, p_57447_, p_57448_);
	}

	@Override
	public void wasExploded(Level p_57441_, BlockPos p_57442_, Explosion p_57443_) {
		if (!p_57441_.isClientSide) {
			p_57441_.explode(null, p_57442_.getX(), p_57442_.getY(), p_57442_.getZ(), 4.0F, Explosion.BlockInteraction.BREAK);
		}
	}

	@Deprecated // Forge: Prefer using IForgeBlock#catchFire
	public static void explode(Level p_57434_, BlockPos p_57435_) {
		explode(p_57434_, p_57435_, (LivingEntity) null);
	}

	@Deprecated // Forge: Prefer using IForgeBlock#catchFire
	private static void explode(Level p_57437_, BlockPos p_57438_, @Nullable LivingEntity p_57439_) {
		if (!p_57437_.isClientSide) {
			p_57437_.explode(null, p_57438_.getX(), p_57438_.getY(), p_57438_.getZ(), 4.0F, Explosion.BlockInteraction.BREAK);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public InteractionResult use(BlockState p_57450_, Level p_57451_, BlockPos p_57452_, Player p_57453_, InteractionHand p_57454_, BlockHitResult p_57455_) {
		ItemStack itemstack = p_57453_.getItemInHand(p_57454_);
		if (!itemstack.is(Items.FLINT_AND_STEEL) && !itemstack.is(Items.FIRE_CHARGE)) {
			return super.use(p_57450_, p_57451_, p_57452_, p_57453_, p_57454_, p_57455_);
		} else {
			onCaughtFire(p_57450_, p_57451_, p_57452_, p_57455_.getDirection(), p_57453_);
			p_57451_.setBlock(p_57452_, Blocks.AIR.defaultBlockState(), 11);
			Item item = itemstack.getItem();
			if (!p_57453_.isCreative()) {
				if (itemstack.is(Items.FLINT_AND_STEEL)) {
					itemstack.hurtAndBreak(1, p_57453_, (p_57425_) -> {
						p_57425_.broadcastBreakEvent(p_57454_);
					});
				} else {
					itemstack.shrink(1);
				}
			}

			p_57453_.awardStat(Stats.ITEM_USED.get(item));
			return InteractionResult.sidedSuccess(p_57451_.isClientSide);
		}
	}

	@Override
	public void onProjectileHit(Level p_57429_, BlockState p_57430_, BlockHitResult p_57431_, Projectile p_57432_) {
		BlockPos pos = p_57431_.getBlockPos();
		if (!p_57429_.isClientSide) {
			p_57429_.explode(null, pos.getX(), pos.getY(), pos.getZ(), 4.0F, Explosion.BlockInteraction.BREAK);
		}
	}

	@Override
	public void entityInside(BlockState p_49314_, Level p_49315_, BlockPos p_49316_, Entity p_49317_) {
		if (!p_49315_.isClientSide) {
			p_49315_.explode(null, p_49316_.getX(), p_49316_.getY(), p_49316_.getZ(), 4.0F, Explosion.BlockInteraction.BREAK);

		}
	}

	@Override
	public boolean dropFromExplosion(Explosion p_57427_) {
		return false;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_57464_) {
		p_57464_.add(UNSTABLE);
	}

	@Override
	public int getFlammability(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
		return 100;
	}

	@Override
	public int getFireSpreadSpeed(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
		return 100;
	}
}
