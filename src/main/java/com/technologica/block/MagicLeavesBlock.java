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

public class MagicLeavesBlock extends LeavesBlock {
	private int leavesType;

	public MagicLeavesBlock(int leavesTypeIn) {
		super(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid());
		this.setDefaultState(this.stateContainer.getBaseState().with(DISTANCE, 7).with(PERSISTENT, Boolean.FALSE));
		leavesType = leavesTypeIn;
	}

	@Override
	public boolean ticksRandomly(BlockState state) {
		return !state.get(PERSISTENT);
	}

	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		if (leavesType == 1) {
			LightningBoltEntity lightningboltentity = EntityType.LIGHTNING_BOLT.create(worldIn);
			lightningboltentity.moveForced(Vector3d.copyCenteredHorizontally(pos));
			worldIn.addEntity(lightningboltentity);
			worldIn.removeBlock(pos, false);	
		} else if (leavesType == 2) {
			SnowGolemEntity snowgolementity = EntityType.SNOW_GOLEM.create(worldIn);
			snowgolementity.moveForced(Vector3d.copyCenteredHorizontally(pos));
			worldIn.addEntity(snowgolementity);
			worldIn.removeBlock(pos, false);
		}			
	}     	      
}
