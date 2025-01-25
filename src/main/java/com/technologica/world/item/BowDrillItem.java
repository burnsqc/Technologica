package com.technologica.world.item;

import com.technologica.resourcegen.data.advancements.TechnologicaCriterionTriggers;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class BowDrillItem extends Item {
	public BowDrillItem(Item.Properties pProperties) {
		super(pProperties);
	}

	@Override
	public InteractionResult useOn(UseOnContext pContext) {
		Player player = pContext.getPlayer();
		if (player != null && this.calculateHitResult(player).getType() == HitResult.Type.BLOCK) {
			BlockPos blockpos = pContext.getClickedPos();
			BlockState blockstate = pContext.getLevel().getBlockState(blockpos);

			if (!blockstate.is(Blocks.FIRE)) {
				if (blockstate.is(Blocks.CAMPFIRE)) {
					if (CampfireBlock.canLight(blockstate)) {
						player.startUsingItem(pContext.getHand());
					}
				} else {
					if (pContext.getClickedFace() == Direction.UP) {
						player.startUsingItem(pContext.getHand());
					}
				}
			}
		}
		return InteractionResult.CONSUME;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack pStack) {
		return UseAnim.BRUSH;
	}

	@Override
	public int getUseDuration(ItemStack pStack) {
		return 600;
	}

	@Override
	public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
		if (pLivingEntity instanceof Player player) {
			HitResult hitresult = this.calculateHitResult(pLivingEntity);
			if (hitresult instanceof BlockHitResult blockhitresult) {
				if (hitresult.getType() == HitResult.Type.BLOCK) {
					int i = this.getUseDuration(pStack) - pRemainingUseDuration + 1;
					boolean flag = i % 6 == 3;
					boolean flag2 = i % 5 == 0;
					boolean flag3 = i % 4 == 0;

					BlockPos blockpos = blockhitresult.getBlockPos();
					BlockState blockstate = pLevel.getBlockState(blockpos);
					boolean isCampfire = blockstate.is(Blocks.CAMPFIRE);

					float particleY = isCampfire ? 0.1F : 1.0F;

					if (pRemainingUseDuration >= 400) {
						if (flag) {
							pLevel.addParticle(ParticleTypes.SMOKE, blockpos.getX() + 0.5F, blockpos.getY() + particleY, blockpos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
							pLevel.playSound(player, blockpos, SoundEvents.WOOL_BREAK, SoundSource.BLOCKS, 0.5F + pLevel.random.nextInt(10) / 20.0F, 1.0F + pLevel.random.nextInt(10) / 40.0F);
						}
					} else if (pRemainingUseDuration >= 200) {
						if (flag2) {
							pLevel.addParticle(ParticleTypes.SMOKE, blockpos.getX() + 0.5F, blockpos.getY() + particleY, blockpos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
							pLevel.addParticle(ParticleTypes.SMALL_FLAME, blockpos.getX() + 0.5F, blockpos.getY() + particleY, blockpos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
							pLevel.playSound(player, blockpos, SoundEvents.WOOL_BREAK, SoundSource.BLOCKS, 0.5F + pLevel.random.nextInt(10) / 20.0F, 1.2F + pLevel.random.nextInt(10) / 40.0F);
						}
					} else if (pRemainingUseDuration > 1) {
						if (flag3) {
							pLevel.addParticle(ParticleTypes.SMOKE, blockpos.getX() + 0.5F, blockpos.getY() + particleY, blockpos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
							pLevel.addParticle(ParticleTypes.FLAME, blockpos.getX() + 0.5F, blockpos.getY() + particleY, blockpos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
							pLevel.playSound(player, blockpos, SoundEvents.WOOL_BREAK, SoundSource.BLOCKS, 0.5F + pLevel.random.nextInt(10) / 20.0F, 1.4F + pLevel.random.nextInt(10) / 40.0F);
						}
					} else {
						this.startFire(pLevel, player, blockpos, blockstate, pStack, blockhitresult);
						pRemainingUseDuration = 0;
					}
				} else {
					pLivingEntity.releaseUsingItem();
				}
			}
		} else {
			pLivingEntity.releaseUsingItem();
		}
	}

	private void startFire(Level pLevel, Player player, BlockPos blockpos, BlockState blockstate, ItemStack pStack, BlockHitResult blockhitresult) {
		EquipmentSlot equipmentslot = pStack.equals(player.getItemBySlot(EquipmentSlot.OFFHAND)) ? EquipmentSlot.OFFHAND : EquipmentSlot.MAINHAND;

		if (CampfireBlock.canLight(blockstate)) {
			pLevel.playSound(player, blockpos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, pLevel.getRandom().nextFloat() * 0.4F + 0.8F);
			pLevel.setBlock(blockpos, blockstate.setValue(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);
			pLevel.gameEvent(player, GameEvent.BLOCK_CHANGE, blockpos);
			if (player != null) {
				pStack.hurtAndBreak(1, player, (p_41300_) -> {
					p_41300_.broadcastBreakEvent(equipmentslot);
				});
				if (player instanceof ServerPlayer serverplayer) {
					TechnologicaCriterionTriggers.LIGHT_CAMPFIRE.trigger(serverplayer, pStack);
				}
			}
		} else {
			Direction direction = blockhitresult.getDirection();
			Direction horizontalDirection = player.getDirection();
			BlockPos blockpos1 = blockpos.relative(direction);
			if (BaseFireBlock.canBePlacedAt(pLevel, blockpos1, horizontalDirection)) {
				BlockState blockstate1 = BaseFireBlock.getState(pLevel, blockpos1);
				pLevel.playSound(player, blockpos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, pLevel.getRandom().nextFloat() * 0.4F + 0.8F);
				pLevel.setBlock(blockpos1, blockstate1, 11);
				pLevel.gameEvent(player, GameEvent.BLOCK_PLACE, blockpos);
				if (player instanceof ServerPlayer) {
					CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer) player, blockpos1, pStack);
					pStack.hurtAndBreak(1, player, (p_41300_) -> {
						p_41300_.broadcastBreakEvent(equipmentslot);
					});
				}
			}
		}
	}

	private HitResult calculateHitResult(LivingEntity pEntity) {
		return ProjectileUtil.getHitResultOnViewVector(pEntity, (p_281111_) -> {
			return !p_281111_.isSpectator() && p_281111_.isPickable();
		}, 5);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack p_42923_, Level p_42924_, LivingEntity livingEntity) {
		if (livingEntity instanceof ServerPlayer serverplayer) {
			CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, p_42923_);
		}
		return super.finishUsingItem(p_42923_, p_42924_, livingEntity);
	}
}