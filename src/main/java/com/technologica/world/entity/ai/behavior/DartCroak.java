package com.technologica.world.entity.ai.behavior;

import com.google.common.collect.ImmutableMap;
import com.technologica.world.entity.animal.PoisonDartFrog;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;

public class DartCroak extends Behavior<PoisonDartFrog> {
	private int croakCounter;

	public DartCroak() {
		super(ImmutableMap.of(MemoryModuleType.WALK_TARGET, MemoryStatus.VALUE_ABSENT), 100);
	}

	@Override
	protected boolean checkExtraStartConditions(ServerLevel p_217151_, PoisonDartFrog p_217152_) {
		return p_217152_.getPose() == Pose.STANDING;
	}

	@Override
	protected boolean canStillUse(ServerLevel p_217154_, PoisonDartFrog p_217155_, long p_217156_) {
		return this.croakCounter < 60;
	}

	@Override
	protected void start(ServerLevel p_217162_, PoisonDartFrog p_217163_, long p_217164_) {
		if (!p_217163_.isInWaterOrBubble() && !p_217163_.isInLava()) {
			p_217163_.setPose(Pose.CROAKING);
			this.croakCounter = 0;
		}
	}

	@Override
	protected void stop(ServerLevel p_217170_, PoisonDartFrog p_217171_, long p_217172_) {
		p_217171_.setPose(Pose.STANDING);
	}

	@Override
	protected void tick(ServerLevel p_217178_, PoisonDartFrog p_217179_, long p_217180_) {
		++this.croakCounter;
	}
}