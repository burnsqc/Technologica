package com.technologica.world.level.block.entity;

import com.technologica.registration.deferred.TechnologicaBlockEntityTypes;
import com.technologica.world.inventory.DraftFurnaceMenu;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DraftFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
	int litTime;
	int litDuration;
	int cookingProgress;
	int cookingTotalTime;
	protected final ContainerData dataAccess = new ContainerData() {
		@Override
		public int get(int p_58431_) {
			switch (p_58431_) {
			case 0:
				return DraftFurnaceBlockEntity.this.litTime;
			case 1:
				return DraftFurnaceBlockEntity.this.litDuration;
			case 2:
				return DraftFurnaceBlockEntity.this.cookingProgress;
			case 3:
				return DraftFurnaceBlockEntity.this.cookingTotalTime;
			default:
				return 0;
			}
		}

		@Override
		public void set(int p_58433_, int p_58434_) {
			switch (p_58433_) {
			case 0:
				DraftFurnaceBlockEntity.this.litTime = p_58434_;
				break;
			case 1:
				DraftFurnaceBlockEntity.this.litDuration = p_58434_;
				break;
			case 2:
				DraftFurnaceBlockEntity.this.cookingProgress = p_58434_;
				break;
			case 3:
				DraftFurnaceBlockEntity.this.cookingTotalTime = p_58434_;
			}

		}

		@Override
		public int getCount() {
			return 4;
		}
	};

	public DraftFurnaceBlockEntity(BlockPos pPos, BlockState pBlockState) {
		super(TechnologicaBlockEntityTypes.DRAFT_FURNACE.get(), pPos, pBlockState, RecipeType.SMELTING);
	}

	@Override
	protected Component getDefaultName() {
		return Component.translatable("container.draft_furnace");
	}

	@Override
	protected AbstractContainerMenu createMenu(int pId, Inventory pPlayer) {
		return new DraftFurnaceMenu(pId, this.level, this.getBlockPos(), pPlayer);
	}
}
