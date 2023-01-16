package com.technologica.world.level.block;

import java.util.Optional;

import com.mojang.datafixers.util.Either;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.util.Unit;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.event.ForgeEventFactory;

public class SleepingBagBlock extends BedBlock {
	protected static final VoxelShape BASE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D);

	public SleepingBagBlock(DyeColor p_49454_, Properties p_49455_) {
		super(p_49454_, p_49455_);
	}

	@Override
	public VoxelShape getShape(BlockState p_49547_, BlockGetter p_49548_, BlockPos p_49549_, CollisionContext p_49550_) {
		return BASE;
	}

	@Override
	public RenderShape getRenderShape(BlockState p_49545_) {
		return RenderShape.MODEL;
	}

	@Override
	public InteractionResult use(BlockState p_49515_, Level p_49516_, BlockPos p_49517_, Player p_49518_, InteractionHand p_49519_, BlockHitResult p_49520_) {
		if (p_49516_.isClientSide) {
			return InteractionResult.CONSUME;
		} else {
			if (p_49515_.getValue(PART) != BedPart.HEAD) {
				p_49517_ = p_49517_.relative(p_49515_.getValue(FACING));
				p_49515_ = p_49516_.getBlockState(p_49517_);
				if (!p_49515_.is(this)) {
					return InteractionResult.CONSUME;
				}
			}

			if (p_49515_.getValue(OCCUPIED)) {
				return InteractionResult.SUCCESS;
			} else {
				startSleepInBed((ServerPlayer) p_49518_, p_49517_).ifLeft((sleepResult) -> {
					if (sleepResult != null && sleepResult.getMessage() != null) {
						p_49518_.displayClientMessage(sleepResult.getMessage(), true);
					}
				});
				return InteractionResult.SUCCESS;
			}
		}
	}

	public Either<Player.BedSleepingProblem, Unit> startSleepInBed(ServerPlayer player, BlockPos pos) {
		Player.BedSleepingProblem ret = net.minecraftforge.event.ForgeEventFactory.onPlayerSleepInBed(player, Optional.empty());
		if (ret != null) {
			return Either.left(ret);
		}

		if (player.isSleeping() || !player.isAlive()) {
			return Either.left(Player.BedSleepingProblem.OTHER_PROBLEM);
		}

		if (!player.level.dimensionType().natural()) {
			return Either.left(Player.BedSleepingProblem.NOT_POSSIBLE_HERE);
		}
		if (player.level.isDay()) {
			return Either.left(Player.BedSleepingProblem.NOT_POSSIBLE_NOW);
		}

		if (!ForgeEventFactory.fireSleepingTimeCheck(player, Optional.empty())) {
			return Either.left(Player.BedSleepingProblem.NOT_POSSIBLE_NOW);
		}

		player.resetStat(Stats.CUSTOM.get(Stats.TIME_SINCE_REST));
		if (player.isPassenger()) {
			player.stopRiding();
		}

		player.setPose(Pose.SLEEPING);
		player.setSleepingPos(pos);
		player.setDeltaMovement(Vec3.ZERO);
		player.hasImpulse = true;
		player.sleepCounter = 0;

		player.awardStat(Stats.SLEEP_IN_BED);
		CriteriaTriggers.SLEPT_IN_BED.trigger(player);

		((ServerLevel) player.level).updateSleepingPlayerList();
		return Either.right(Unit.INSTANCE);
	}
}
