package com.technologica.world.entity.animal;

import java.util.function.Predicate;

import com.technologica.registration.key.TechnologicaBiomeTags;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Pufferfish;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;

public class FigureEightPufferfish extends Pufferfish {
	int inflateCounter;
	int deflateTimer;
	private static final Predicate<LivingEntity> SCARY_MOB = (p_29634_) -> {
		if (p_29634_ instanceof Player && ((Player) p_29634_).isCreative()) {
			return false;
		} else {
			return p_29634_.getType() == EntityType.AXOLOTL || p_29634_.getMobType() != MobType.WATER;
		}
	};
	static final TargetingConditions targetingConditions = TargetingConditions.forNonCombat().ignoreInvisibilityTesting().ignoreLineOfSight().selector(SCARY_MOB);
	public static final int STATE_SMALL = 0;
	public static final int STATE_MID = 1;
	public static final int STATE_FULL = 2;

	public FigureEightPufferfish(EntityType<? extends FigureEightPufferfish> p_29602_, Level p_29603_) {
		super(p_29602_, p_29603_);
	}

	public static boolean checkFigureEightPufferfishSpawnRules(EntityType<FigureEightPufferfish> figureEightPufferfish, LevelAccessor levelAccessor, MobSpawnType mobSpawnType, BlockPos blockPos, RandomSource randomSource) {
		return levelAccessor.getFluidState(blockPos.below()).is(FluidTags.WATER) && levelAccessor.getBlockState(blockPos.above()).is(Blocks.WATER) && (levelAccessor.getBiome(blockPos).is(TechnologicaBiomeTags.ALLOWS_PUFFERFISH_SPAWNS_AT_ANY_HEIGHT) || WaterAnimal.checkSurfaceWaterAnimalSpawnRules(figureEightPufferfish, levelAccessor, mobSpawnType, blockPos, randomSource));
	}
}