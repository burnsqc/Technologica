package com.technologica.world.entity.ai.behavior;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.ImmutableList;
import com.technologica.registration.deferred.TechnologicaItems;

import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.ai.behavior.WorkAtPoi;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.state.BlockState;

public class TechnologicaWorkAtComposter extends WorkAtPoi {
	private static final List<Item> COMPOSTABLE_ITEMS = ImmutableList.of(Items.WHEAT_SEEDS, TechnologicaItems.BARLEY_SEEDS.get(), TechnologicaItems.OATS_SEEDS.get(), TechnologicaItems.RYE_SEEDS.get(), TechnologicaItems.CORN_SEEDS.get(), TechnologicaItems.RICE_SEEDS.get(), Items.BEETROOT_SEEDS, TechnologicaItems.BROCCOLI_SEEDS.get(), TechnologicaItems.CELERY_SEEDS.get(), TechnologicaItems.LETTUCE_SEEDS.get(), TechnologicaItems.MUSTARD_SEEDS.get(), TechnologicaItems.PINEAPPLE_SEEDS.get(), TechnologicaItems.PURPLE_CABBAGE_SEEDS.get(), TechnologicaItems.ONION_SEEDS.get(), TechnologicaItems.RADISH_SEEDS.get(), TechnologicaItems.TEA_SEEDS.get(), TechnologicaItems.TURNIP_SEEDS.get());

	@Override
	protected void useWorkstation(ServerLevel serverLevel, Villager villager) {
		Optional<GlobalPos> optional = villager.getBrain().getMemory(MemoryModuleType.JOB_SITE);
		if (optional.isPresent()) {
			GlobalPos globalpos = optional.get();
			BlockState blockstate = serverLevel.getBlockState(globalpos.pos());
			if (blockstate.is(Blocks.COMPOSTER)) {
				this.makeBread(villager);
				this.compostItems(serverLevel, villager, globalpos, blockstate);
			}

		}
	}

	private void compostItems(ServerLevel serverLevel, Villager villager, GlobalPos globalPos, BlockState blockState) {
		BlockPos blockpos = globalPos.pos();
		if (blockState.getValue(ComposterBlock.LEVEL) == 8) {
			blockState = ComposterBlock.extractProduce(villager, blockState, serverLevel, blockpos);
		}

		int i = 20;
		int[] aint = new int[COMPOSTABLE_ITEMS.size()];
		SimpleContainer simplecontainer = villager.getInventory();
		int k = simplecontainer.getContainerSize();
		BlockState blockstate = blockState;

		for (int l = k - 1; l >= 0 && i > 0; --l) {
			ItemStack itemstack = simplecontainer.getItem(l);
			int i1 = COMPOSTABLE_ITEMS.indexOf(itemstack.getItem());
			if (i1 != -1) {
				int j1 = itemstack.getCount();
				int k1 = aint[i1] + j1;
				aint[i1] = k1;
				int l1 = Math.min(Math.min(k1 - 10, i), j1);
				if (l1 > 0) {
					i -= l1;

					for (int i2 = 0; i2 < l1; ++i2) {
						blockstate = ComposterBlock.insertItem(villager, blockstate, serverLevel, itemstack, blockpos);
						if (blockstate.getValue(ComposterBlock.LEVEL) == 7) {
							this.spawnComposterFillEffects(serverLevel, blockState, blockpos, blockstate);
							return;
						}
					}
				}
			}
		}
		this.spawnComposterFillEffects(serverLevel, blockState, blockpos, blockstate);
	}

	private void spawnComposterFillEffects(ServerLevel serverLevel, BlockState p_24799_, BlockPos p_24800_, BlockState blockState) {
		serverLevel.levelEvent(1500, p_24800_, blockState != p_24799_ ? 1 : 0);
	}

	private void makeBread(Villager villager) {
		SimpleContainer simplecontainer = villager.getInventory();
		if (simplecontainer.countItem(Items.BREAD) <= 36) {
			int i = simplecontainer.countItem(Items.WHEAT);
			int l = Math.min(3, i / 3);
			if (l != 0) {
				int i1 = l * 3;
				simplecontainer.removeItemType(Items.WHEAT, i1);
				ItemStack itemstack = simplecontainer.addItem(new ItemStack(Items.BREAD, l));
				if (!itemstack.isEmpty()) {
					villager.spawnAtLocation(itemstack, 0.5F);
				}
			}
		}
	}
}