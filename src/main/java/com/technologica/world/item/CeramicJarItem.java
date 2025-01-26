package com.technologica.world.item;

import java.util.Optional;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.technologica.registration.deferred.TechnologicaItems;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DispensibleContainerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper;

public class CeramicJarItem extends Item implements DispensibleContainerItem {
	private final Supplier<? extends Fluid> fluidSupplier;

	public CeramicJarItem(Supplier<? extends Fluid> supplier, Item.Properties builder) {
		super(builder);
		this.fluidSupplier = supplier;
	}

	/**
	 * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see {@link #onItemUse}.
	 */
	@Override
	public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
		ItemStack itemstack = pPlayer.getItemInHand(pHand);
		BlockHitResult blockhitresult = getPlayerPOVHitResult(pLevel, pPlayer, this.fluidSupplier.get() == Fluids.EMPTY ? ClipContext.Fluid.SOURCE_ONLY : ClipContext.Fluid.NONE);
		InteractionResultHolder<ItemStack> ret = ForgeEventFactory.onBucketUse(pPlayer, pLevel, itemstack, blockhitresult);
		if (ret != null)
			return ret;
		if (blockhitresult.getType() == HitResult.Type.MISS) {
			return InteractionResultHolder.pass(itemstack);
		} else if (blockhitresult.getType() != HitResult.Type.BLOCK) {
			return InteractionResultHolder.pass(itemstack);
		} else {
			BlockPos blockpos = blockhitresult.getBlockPos();
			Direction direction = blockhitresult.getDirection();
			BlockPos blockpos1 = blockpos.relative(direction);
			if (pLevel.mayInteract(pPlayer, blockpos) && pPlayer.mayUseItemAt(blockpos1, direction, itemstack)) {
				if (this.fluidSupplier.get() == Fluids.EMPTY) {
					BlockState blockstate1 = pLevel.getBlockState(blockpos);
					if (blockstate1.getBlock() instanceof BucketPickup) {
						BucketPickup bucketpickup = (BucketPickup) blockstate1.getBlock();
						ItemStack itemstack1 = bucketpickup.pickupBlock(pLevel, blockpos, blockstate1);
						if (!itemstack1.isEmpty()) {
							pPlayer.awardStat(Stats.ITEM_USED.get(this));
							bucketpickup.getPickupSound(blockstate1).ifPresent((p_150709_) -> {
								pPlayer.playSound(p_150709_, 1.0F, 1.0F);
							});
							pLevel.gameEvent(pPlayer, GameEvent.FLUID_PICKUP, blockpos);

							ItemStack itemstack2 = new ItemStack(TechnologicaItems.FILLED_CERAMIC_JAR.get());
							itemstack2.setDamageValue(itemstack.getDamageValue());
							if (!pLevel.isClientSide) {
								CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayer) pPlayer, itemstack2);
								itemstack2.hurtAndBreak(1, pPlayer, (player) -> {
									player.broadcastBreakEvent(EquipmentSlot.MAINHAND);
								});
							}

							return InteractionResultHolder.sidedSuccess(itemstack2, pLevel.isClientSide());
						}
					}

					return InteractionResultHolder.fail(itemstack);
				} else {
					BlockState blockstate = pLevel.getBlockState(blockpos);
					BlockPos blockpos2 = canBlockContainFluid(pLevel, blockpos, blockstate) ? blockpos : blockpos1;
					if (this.emptyContents(pPlayer, pLevel, blockpos2, blockhitresult, itemstack)) {
						this.checkExtraContent(pPlayer, pLevel, itemstack, blockpos2);
						if (pPlayer instanceof ServerPlayer) {
							CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer) pPlayer, blockpos2, itemstack);
						}

						pPlayer.awardStat(Stats.ITEM_USED.get(this));
						return InteractionResultHolder.sidedSuccess(getEmptySuccessItem(itemstack, pPlayer), pLevel.isClientSide());
					} else {
						return InteractionResultHolder.fail(itemstack);
					}
				}
			} else {
				return InteractionResultHolder.fail(itemstack);
			}
		}
	}

	public static ItemStack getEmptySuccessItem(ItemStack pBucketStack, Player pPlayer) {
		ItemStack damagedJar = new ItemStack(TechnologicaItems.CERAMIC_JAR.get());
		damagedJar.setDamageValue(pBucketStack.getDamageValue());
		damagedJar.hurtAndBreak(1, pPlayer, (player) -> {
			player.broadcastBreakEvent(EquipmentSlot.MAINHAND);
		});
		return !pPlayer.getAbilities().instabuild ? damagedJar : pBucketStack;
	}

	@Override
	@Deprecated // Forge: use the ItemStack sensitive version
	public boolean emptyContents(@Nullable Player pPlayer, Level pLevel, BlockPos pPos, @Nullable BlockHitResult pResult) {
		return this.emptyContents(pPlayer, pLevel, pPos, pResult, null);
	}

	@Override
	public boolean emptyContents(@Nullable Player pPlayer, Level pLevel, BlockPos pPos, @Nullable BlockHitResult pResult, @Nullable ItemStack container) {
		if (!(this.fluidSupplier.get() instanceof FlowingFluid)) {
			return false;
		} else {
			BlockState blockstate = pLevel.getBlockState(pPos);
			Block block = blockstate.getBlock();
			boolean flag = blockstate.canBeReplaced(this.fluidSupplier.get());
			boolean flag1 = blockstate.isAir() || flag || block instanceof LiquidBlockContainer && ((LiquidBlockContainer) block).canPlaceLiquid(pLevel, pPos, blockstate, this.fluidSupplier.get());
			Optional<FluidStack> containedFluidStack = Optional.ofNullable(container).flatMap(FluidUtil::getFluidContained);
			if (!flag1) {
				return pResult != null && this.emptyContents(pPlayer, pLevel, pResult.getBlockPos().relative(pResult.getDirection()), (BlockHitResult) null, container);
			} else if (containedFluidStack.isPresent() && this.fluidSupplier.get().getFluidType().isVaporizedOnPlacement(pLevel, pPos, containedFluidStack.get())) {
				this.fluidSupplier.get().getFluidType().onVaporize(pPlayer, pLevel, pPos, containedFluidStack.get());
				return true;
			} else if (pLevel.dimensionType().ultraWarm() && this.fluidSupplier.get().is(FluidTags.WATER)) {
				int i = pPos.getX();
				int j = pPos.getY();
				int k = pPos.getZ();
				pLevel.playSound(pPlayer, pPos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 0.5F, 2.6F + (pLevel.random.nextFloat() - pLevel.random.nextFloat()) * 0.8F);

				for (int l = 0; l < 8; ++l) {
					pLevel.addParticle(ParticleTypes.LARGE_SMOKE, i + Math.random(), j + Math.random(), k + Math.random(), 0.0D, 0.0D, 0.0D);
				}

				return true;
			} else if (block instanceof LiquidBlockContainer && ((LiquidBlockContainer) block).canPlaceLiquid(pLevel, pPos, blockstate, fluidSupplier.get())) {
				((LiquidBlockContainer) block).placeLiquid(pLevel, pPos, blockstate, ((FlowingFluid) this.fluidSupplier.get()).getSource(false));
				this.playEmptySound(pPlayer, pLevel, pPos);
				return true;
			} else {
				if (!pLevel.isClientSide && flag && !blockstate.liquid()) {
					pLevel.destroyBlock(pPos, true);
				}

				if (!pLevel.setBlock(pPos, this.fluidSupplier.get().defaultFluidState().createLegacyBlock(), 11) && !blockstate.getFluidState().isSource()) {
					return false;
				} else {
					this.playEmptySound(pPlayer, pLevel, pPos);
					return true;
				}
			}
		}
	}

	protected void playEmptySound(@Nullable Player pPlayer, LevelAccessor pLevel, BlockPos pPos) {
		SoundEvent soundevent = this.fluidSupplier.get().getFluidType().getSound(pPlayer, pLevel, pPos, SoundActions.BUCKET_EMPTY);
		if (soundevent == null) {
			soundevent = SoundEvents.BUCKET_EMPTY;
		}
		pLevel.playSound(pPlayer, pPos, soundevent, SoundSource.BLOCKS, 1.0F, 1.0F);
		pLevel.gameEvent(pPlayer, GameEvent.FLUID_PLACE, pPos);
	}

	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
		if (this.getClass() == CeramicJarItem.class)
			return new FluidBucketWrapper(stack);
		else
			return super.initCapabilities(stack, nbt);
	}

	public Fluid getFluid() {
		return fluidSupplier.get();
	}

	protected boolean canBlockContainFluid(Level worldIn, BlockPos posIn, BlockState blockstate) {
		return blockstate.getBlock() instanceof LiquidBlockContainer && ((LiquidBlockContainer) blockstate.getBlock()).canPlaceLiquid(worldIn, posIn, blockstate, this.fluidSupplier.get());
	}
}
