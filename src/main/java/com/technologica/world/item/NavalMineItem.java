package com.technologica.world.item;

import java.util.Objects;

import com.technologica.registration.deferred.TechnologicaEntityTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class NavalMineItem extends Item {
	public NavalMineItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext p_43223_) {
		Level level = p_43223_.getLevel();
		if (!(level instanceof ServerLevel)) {
			return InteractionResult.SUCCESS;
		} else {
			ItemStack itemstack = p_43223_.getItemInHand();
			BlockPos blockpos = p_43223_.getClickedPos();
			Direction direction = p_43223_.getClickedFace();
			BlockState blockstate = level.getBlockState(blockpos);

			BlockPos blockpos1;
			if (blockstate.getCollisionShape(level, blockpos).isEmpty()) {
				blockpos1 = blockpos;
			} else {
				blockpos1 = blockpos.relative(direction);
			}

			EntityType<?> entitytype = TechnologicaEntityTypes.NAVAL_MINE.get();
			if (entitytype.spawn((ServerLevel) level, itemstack, p_43223_.getPlayer(), blockpos1, MobSpawnType.SPAWN_EGG, true, !Objects.equals(blockpos, blockpos1) && direction == Direction.UP) != null) {
				itemstack.shrink(1);
				level.gameEvent(p_43223_.getPlayer(), GameEvent.ENTITY_PLACE, blockpos);
			}

			return InteractionResult.CONSUME;
		}
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
		ItemStack itemstack = playerIn.getItemInHand(handIn);
		HitResult hitresult = getPlayerPOVHitResult(worldIn, playerIn, ClipContext.Fluid.ANY);
		if (hitresult.getType() != HitResult.Type.BLOCK) {
			return InteractionResultHolder.pass(itemstack);
		} else if (!(worldIn instanceof ServerLevel)) {
			return InteractionResultHolder.success(itemstack);
		} else {
			BlockHitResult blockhitresult = (BlockHitResult) hitresult;
			BlockPos blockpos = blockhitresult.getBlockPos();
			if (!(worldIn.getBlockState(blockpos).getBlock() instanceof LiquidBlock)) {
				return InteractionResultHolder.pass(itemstack);
			} else if (worldIn.mayInteract(playerIn, blockpos) && playerIn.mayUseItemAt(blockpos, blockhitresult.getDirection(), itemstack)) {
				EntityType<?> entitytype = TechnologicaEntityTypes.NAVAL_MINE.get();
				Entity entity = entitytype.spawn((ServerLevel) worldIn, itemstack, playerIn, blockpos, MobSpawnType.SPAWN_EGG, false, false);

				if (entity == null) {
					return InteractionResultHolder.pass(itemstack);
				} else {
					if (!playerIn.getAbilities().instabuild) {
						itemstack.shrink(1);
					}

					playerIn.awardStat(Stats.ITEM_USED.get(this));
					worldIn.gameEvent(playerIn, GameEvent.ENTITY_PLACE, entity.position());
					return InteractionResultHolder.consume(itemstack);
				}
			} else {
				return InteractionResultHolder.fail(itemstack);
			}
		}
	}
}