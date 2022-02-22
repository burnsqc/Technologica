package com.technologica.block;

import java.util.Random;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.server.ServerWorld;

/**
 * Special one-off class for magic leaves.
 * Created to spawn entities on random ticks.
 */
public class MagicLeavesBlock extends LeavesBlock {
	private int leavesType;

	public MagicLeavesBlock(int leavesTypeIn) {
		super(AbstractBlock.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion());
		leavesType = leavesTypeIn;
	}

	/*
	 * Minecraft Methods
	 */

	@Override
	public void randomTick(BlockState stateIn, ServerWorld worldIn, BlockPos posIn, Random randomIn) {
		if (leavesType == 1) {
			LightningBoltEntity lightningboltentity = EntityType.LIGHTNING_BOLT.create(worldIn);
			lightningboltentity.moveTo(Vector3d.atBottomCenterOf(posIn));
			worldIn.addFreshEntity(lightningboltentity);
			worldIn.removeBlock(posIn, false);
		} else if (leavesType == 2) {
			SnowGolemEntity snowgolementity = EntityType.SNOW_GOLEM.create(worldIn);
			snowgolementity.moveTo(Vector3d.atBottomCenterOf(posIn));
			worldIn.addFreshEntity(snowgolementity);
			worldIn.removeBlock(posIn, false);
		}
	}
	
	@Override
	public boolean isRandomlyTicking(BlockState stateIn) {
		return !stateIn.getValue(PERSISTENT);
	}
}
