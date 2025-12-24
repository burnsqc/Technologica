package com.technologica.world.level.block;

import com.technologica.capabilities.item.link.PortalHook;
import com.technologica.registration.deferred.TechnologicaSoundEvents;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class AbyssPortalBlock extends NetherPortalBlock {

	public AbyssPortalBlock(BlockBehaviour.Properties properties) {
		super(properties);
	}

	@Override
	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {

	}

	@Override
	public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
		if (entity.canChangeDimensions()) {
			PortalHook portalHook = entity.getCapability(PortalHook.PORTAL_HOOK_INSTANCE).orElseThrow(NullPointerException::new);
			portalHook.handleInsidePortal(blockPos, entity);
			portalHook.handleAbyssPortal();
		}
	}

	@Override
	public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
		if (randomSource.nextInt(100) == 0) {
			level.playLocalSound(blockPos.getX() + 0.5D, blockPos.getY() + 0.5D, blockPos.getZ() + 0.5D, TechnologicaSoundEvents.ABYSS_PORTAL_AMBIENT.get(), SoundSource.BLOCKS, 0.5F, randomSource.nextFloat() * 0.4F + 0.8F, false);
		}
		for (int i = 0; i < 4; ++i) {
			double d0 = blockPos.getX() + randomSource.nextDouble();
			double d1 = blockPos.getY() + randomSource.nextDouble();
			double d2 = blockPos.getZ() + randomSource.nextDouble();
			double d3 = (randomSource.nextFloat() - 0.5D) * 0.5D;
			double d4 = (randomSource.nextFloat() - 0.5D) * 0.5D;
			double d5 = (randomSource.nextFloat() - 0.5D) * 0.5D;
			int j = randomSource.nextInt(2) * 2 - 1;
			if (!level.getBlockState(blockPos.west()).is(this) && !level.getBlockState(blockPos.east()).is(this)) {
				d0 = blockPos.getX() + 0.5D + 0.25D * j;
				d3 = randomSource.nextFloat() * 2.0F * j;
			} else {
				d2 = blockPos.getZ() + 0.5D + 0.25D * j;
				d5 = randomSource.nextFloat() * 2.0F * j;
			}
			level.addParticle(ParticleTypes.DRIPPING_DRIPSTONE_WATER, d0, d1, d2, d3, d4, d5);
		}
	}
}
