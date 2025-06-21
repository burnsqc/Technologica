package com.technologica.world.item;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.technologica.registration.deferred.TechnologicaItems;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.DispensibleContainerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper;

public class CeramicJarItem extends BucketItem implements DispensibleContainerItem {
	public CeramicJarItem(Supplier<? extends Fluid> supplier, Item.Properties builder) {
		super(supplier, builder);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
		ItemStack itemstack = pPlayer.getItemInHand(pHand);
		BlockHitResult blockhitresult = getPlayerPOVHitResult(pLevel, pPlayer, getFluid() == Fluids.EMPTY ? ClipContext.Fluid.SOURCE_ONLY : ClipContext.Fluid.NONE);
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
				if (getFluid() == Fluids.EMPTY) {
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
	public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
		if (this.getClass() == CeramicJarItem.class) {
			return (new FluidBucketWrapper(stack) {
				@Override
				public boolean canFillFluidType(FluidStack fluid) {
					if (fluid.getFluid() == Fluids.WATER) {
						return true;
					}
					return !fluid.getFluid().getFluidType().getBucket(fluid).isEmpty();
				}
			});
		} else {
			return super.initCapabilities(stack, nbt);
		}
	}
}
