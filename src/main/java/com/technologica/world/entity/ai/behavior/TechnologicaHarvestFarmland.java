package com.technologica.world.entity.ai.behavior;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.technologica.world.item.TechnologicaItems;
import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.behavior.BlockPosTracker;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.memory.WalkTarget;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;

public class TechnologicaHarvestFarmland extends Behavior<Villager> {
	public static final float SPEED_MODIFIER = 0.5F;
	@Nullable
	private BlockPos aboveFarmlandPos;
	private long nextOkStartTime;
	private int timeWorkedSoFar;
	private final List<BlockPos> validFarmlandAroundVillager = Lists.newArrayList();

	public TechnologicaHarvestFarmland() {
		super(ImmutableMap.of(MemoryModuleType.LOOK_TARGET, MemoryStatus.VALUE_ABSENT, MemoryModuleType.WALK_TARGET,
				MemoryStatus.VALUE_ABSENT, MemoryModuleType.SECONDARY_JOB_SITE, MemoryStatus.VALUE_PRESENT));
	}

	protected boolean checkExtraStartConditions(ServerLevel p_23174_, Villager p_23175_) {
		if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(p_23174_, p_23175_)) {
			return false;
		} else if (p_23175_.getVillagerData().getProfession() != VillagerProfession.FARMER) {
			return false;
		} else {
			BlockPos.MutableBlockPos blockpos$mutableblockpos = p_23175_.blockPosition().mutable();
			this.validFarmlandAroundVillager.clear();
			for (int i = -1; i <= 1; ++i) {
				for (int j = -1; j <= 1; ++j) {
					for (int k = -1; k <= 1; ++k) {
						blockpos$mutableblockpos.set(p_23175_.getX() + (double) i, p_23175_.getY() + (double) j, p_23175_.getZ() + (double) k);
						if (this.validPos(blockpos$mutableblockpos, p_23174_)) {
							this.validFarmlandAroundVillager.add(new BlockPos(blockpos$mutableblockpos));
						}
					}
				}
			}
			this.aboveFarmlandPos = this.getValidFarmland(p_23174_);
			return this.aboveFarmlandPos != null;
		}
	}

	@Nullable
	private BlockPos getValidFarmland(ServerLevel p_23165_) {
		return this.validFarmlandAroundVillager.isEmpty() ? null : this.validFarmlandAroundVillager.get(p_23165_.getRandom().nextInt(this.validFarmlandAroundVillager.size()));
	}

	private boolean validPos(BlockPos p_23181_, ServerLevel p_23182_) {
		BlockState blockstate = p_23182_.getBlockState(p_23181_);
		Block block = blockstate.getBlock();
		Block block1 = p_23182_.getBlockState(p_23181_.below()).getBlock();
		return block instanceof CropBlock && ((CropBlock) block).isMaxAge(blockstate) || blockstate.isAir() && block1 instanceof FarmBlock;
	}

	protected void start(ServerLevel p_23177_, Villager p_23178_, long p_23179_) {
		if (p_23179_ > this.nextOkStartTime && this.aboveFarmlandPos != null) {
			p_23178_.getBrain().setMemory(MemoryModuleType.LOOK_TARGET, new BlockPosTracker(this.aboveFarmlandPos));
			p_23178_.getBrain().setMemory(MemoryModuleType.WALK_TARGET, new WalkTarget(new BlockPosTracker(this.aboveFarmlandPos), 0.5F, 1));
		}

	}

	protected void stop(ServerLevel p_23188_, Villager p_23189_, long p_23190_) {
		p_23189_.getBrain().eraseMemory(MemoryModuleType.LOOK_TARGET);
		p_23189_.getBrain().eraseMemory(MemoryModuleType.WALK_TARGET);
		this.timeWorkedSoFar = 0;
		this.nextOkStartTime = p_23190_ + 40L;
	}

	protected void tick(ServerLevel p_23196_, Villager villagerIn, long p_23198_) {
		if (this.aboveFarmlandPos == null || this.aboveFarmlandPos.closerToCenterThan(villagerIn.position(), 1.0D)) {
			if (this.aboveFarmlandPos != null && p_23198_ > this.nextOkStartTime) {
				BlockState blockstate = p_23196_.getBlockState(this.aboveFarmlandPos);
				Block block = blockstate.getBlock();
				Block block1 = p_23196_.getBlockState(this.aboveFarmlandPos.below()).getBlock();
				if (block instanceof CropBlock && ((CropBlock) block).isMaxAge(blockstate)) {
					p_23196_.destroyBlock(this.aboveFarmlandPos, true, villagerIn);
				}

				if (blockstate.isAir() && block1 instanceof FarmBlock && this.hasFarmSeeds(villagerIn)) {
					SimpleContainer simplecontainer = villagerIn.getInventory();

					for (int i = 0; i < simplecontainer.getContainerSize(); ++i) {
						ItemStack itemstack = simplecontainer.getItem(i);
						boolean flag = false;
						if (!itemstack.isEmpty()) {
							if (itemstack.is(Items.WHEAT_SEEDS)) {
		                        p_23196_.setBlock(this.aboveFarmlandPos, Blocks.WHEAT.defaultBlockState(), 3);
		                        flag = true;
							} else if (itemstack.is(Items.POTATO)) {
								p_23196_.setBlock(this.aboveFarmlandPos, Blocks.POTATOES.defaultBlockState(), 3);
								flag = true;
							} else if (itemstack.is(Items.CARROT)) {
								p_23196_.setBlock(this.aboveFarmlandPos, Blocks.CARROTS.defaultBlockState(), 3);
								flag = true;
							} else if (itemstack.is(Items.BEETROOT_SEEDS)) {
								p_23196_.setBlock(this.aboveFarmlandPos, Blocks.BEETROOTS.defaultBlockState(), 3);
								flag = true;
							} else if (itemstack.is(TechnologicaItems.BARLEY_SEEDS.get())) {
								p_23196_.setBlock(this.aboveFarmlandPos, TechnologicaBlocks.BARLEY.get().defaultBlockState(), 3);
								flag = true;
							} else if (itemstack.is(TechnologicaItems.OATS_SEEDS.get())) {
								p_23196_.setBlock(this.aboveFarmlandPos, TechnologicaBlocks.OATS.get().defaultBlockState(), 3);
								flag = true;
							} else if (itemstack.is(TechnologicaItems.RYE_SEEDS.get())) {
								p_23196_.setBlock(this.aboveFarmlandPos, TechnologicaBlocks.RYE.get().defaultBlockState(), 3);
								flag = true;
							} else if (itemstack.is(TechnologicaItems.SWEET_POTATO.get())) {
								p_23196_.setBlock(this.aboveFarmlandPos, TechnologicaBlocks.SWEET_POTATOES.get().defaultBlockState(), 3);
								flag = true;
							} else if (itemstack.getItem() instanceof net.minecraftforge.common.IPlantable) {
								if (((net.minecraftforge.common.IPlantable) itemstack.getItem()).getPlantType(p_23196_,
										aboveFarmlandPos) == net.minecraftforge.common.PlantType.CROP) {
									p_23196_.setBlock(aboveFarmlandPos,
											((net.minecraftforge.common.IPlantable) itemstack.getItem())
													.getPlant(p_23196_, aboveFarmlandPos),
											3);
									flag = true;
								}
							}
						}

						if (flag) {
							p_23196_.playSound((Player) null, (double) this.aboveFarmlandPos.getX(),
									(double) this.aboveFarmlandPos.getY(), (double) this.aboveFarmlandPos.getZ(),
									SoundEvents.CROP_PLANTED, SoundSource.BLOCKS, 1.0F, 1.0F);
							itemstack.shrink(1);
							if (itemstack.isEmpty()) {
								simplecontainer.setItem(i, ItemStack.EMPTY);
							}
							break;
						}
					}
				}

				if (block instanceof CropBlock && !((CropBlock) block).isMaxAge(blockstate)) {
					this.validFarmlandAroundVillager.remove(this.aboveFarmlandPos);
					this.aboveFarmlandPos = this.getValidFarmland(p_23196_);
					if (this.aboveFarmlandPos != null) {
						this.nextOkStartTime = p_23198_ + 20L;
						villagerIn.getBrain().setMemory(MemoryModuleType.WALK_TARGET,
								new WalkTarget(new BlockPosTracker(this.aboveFarmlandPos), 0.5F, 1));
						villagerIn.getBrain().setMemory(MemoryModuleType.LOOK_TARGET,
								new BlockPosTracker(this.aboveFarmlandPos));
					}
				}
			}

			++this.timeWorkedSoFar;
		}
	}

	protected boolean canStillUse(ServerLevel p_23204_, Villager p_23205_, long p_23206_) {
		return this.timeWorkedSoFar < 200;
	}

	public boolean hasFarmSeeds(Villager p_23197_) {
		return p_23197_.getInventory().hasAnyOf(ImmutableSet.of(TechnologicaItems.BARLEY_SEEDS.get(), TechnologicaItems.OATS_SEEDS.get(), TechnologicaItems.RYE_SEEDS.get(), TechnologicaItems.SWEET_POTATO.get()));
	}
}
