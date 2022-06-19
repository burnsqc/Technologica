package com.technologica.world.item;

import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.LevelChunkSection;

public class GlueBottleItem extends Item implements Vanishable {

	public GlueBottleItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		Level world = context.getLevel();
		if (!world.isClientSide) {
			BlockPos pos = context.getClickedPos();
			ItemStack stack = context.getItemInHand();
			LivingEntity player = context.getPlayer();

			this.setBlockStateGlued(pos.relative(context.getClickedFace()), TechnologicaBlocks.GLUE.get().getStateForPlacement(new BlockPlaceContext(context)), false, world);

			world.playSound((Player) null, pos, SoundEvents.SLIME_JUMP, SoundSource.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);

			stack.hurtAndBreak(1, player, (p_40992_) -> {
				p_40992_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
			});

			return InteractionResult.SUCCESS;

		}
		return InteractionResult.PASS;
	}

	public BlockState setBlockStateGlued(BlockPos p_62865_, BlockState p_62866_, boolean p_62867_, Level worldIn) {

		LevelChunk levelchunk = worldIn.getChunkAt(p_62865_);

		int i = p_62865_.getY();
		LevelChunkSection levelchunksection = levelchunk.getSection(levelchunk.getSectionIndex(i));
		boolean flag = levelchunksection.hasOnlyAir();
		if (flag && p_62866_.isAir()) {
			return null;
		} else {
			int j = p_62865_.getX() & 15;
			int k = i & 15;
			int l = p_62865_.getZ() & 15;
			BlockState blockstate = levelchunksection.setBlockState(j, k, l, p_62866_);
			if (blockstate == p_62866_) {
				return null;
			} else {
				Block block = p_62866_.getBlock();

				boolean flag1 = levelchunksection.hasOnlyAir();
				if (flag != flag1) {
					worldIn.getChunkSource().getLightEngine().updateSectionStatus(p_62865_, flag1);
				}

				boolean flag2 = blockstate.hasBlockEntity();
				if (!worldIn.isClientSide) {
					blockstate.onRemove(worldIn, p_62865_, p_62866_, p_62867_);
				} else if ((!blockstate.is(block) || !p_62866_.hasBlockEntity()) && flag2) {
					levelchunk.removeBlockEntity(p_62865_);
				}

				if (!levelchunksection.getBlockState(j, k, l).is(block)) {
					return null;
				} else {
					if (!worldIn.isClientSide && !worldIn.captureBlockSnapshots) {
					}

					if (p_62866_.hasBlockEntity()) {
						BlockEntity blockentity = levelchunk.getBlockEntity(p_62865_, LevelChunk.EntityCreationType.CHECK);
						if (blockentity == null) {
							blockentity = ((EntityBlock) block).newBlockEntity(p_62865_, p_62866_);
							if (blockentity != null) {
								levelchunk.addAndRegisterBlockEntity(blockentity);
							}
						} else {
							blockentity.setBlockState(p_62866_);
						}
					}

					worldIn.markAndNotifyBlock(p_62865_, levelchunk, blockstate, p_62866_, 0, 0);
					return blockstate;
				}
			}
		}
	}
}