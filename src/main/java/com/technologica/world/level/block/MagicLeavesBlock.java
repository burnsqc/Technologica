package com.technologica.world.level.block;

import java.util.Random;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.server.level.ServerLevel;

/**
 * Special one-off class for magic leaves.
 * Created to spawn entities on random ticks.
 */
public class MagicLeavesBlock extends LeavesBlock {
	private int leavesType;

	public MagicLeavesBlock(int leavesTypeIn) {
		super(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion());
		leavesType = leavesTypeIn;
	}

	/*
	 * Minecraft Methods
	 */

	@Override
	public void randomTick(BlockState stateIn, ServerLevel worldIn, BlockPos posIn, Random randomIn) {
		if (leavesType == 1) {
			LightningBolt lightningboltentity = EntityType.LIGHTNING_BOLT.create(worldIn);
			lightningboltentity.moveTo(Vec3.atBottomCenterOf(posIn));
			worldIn.addFreshEntity(lightningboltentity);
			worldIn.removeBlock(posIn, false);
		} else if (leavesType == 2) {
			SnowGolem snowgolementity = EntityType.SNOW_GOLEM.create(worldIn);
			snowgolementity.moveTo(Vec3.atBottomCenterOf(posIn));
			worldIn.addFreshEntity(snowgolementity);
			worldIn.removeBlock(posIn, false);
		}
	}
	
	@Override
	public boolean isRandomlyTicking(BlockState stateIn) {
		return !stateIn.getValue(PERSISTENT);
	}
}
