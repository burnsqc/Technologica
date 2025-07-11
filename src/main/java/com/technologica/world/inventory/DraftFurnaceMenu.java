package com.technologica.world.inventory;

import com.technologica.registration.deferred.TechnologicaMenuTypes;
import com.technologica.world.level.block.entity.DraftFurnaceBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;

public class DraftFurnaceMenu extends AbstractInventoryContainerMenu {
	private final DraftFurnaceBlockEntity draftFurnaceBlockEntity;

	public DraftFurnaceMenu(int containerId, Level level, BlockPos blockPos, Inventory inventory) {
		super(TechnologicaMenuTypes.DRAFT_FURNACE.get(), containerId, level, blockPos, inventory);
		draftFurnaceBlockEntity = (DraftFurnaceBlockEntity) level.getBlockEntity(blockPos);
		if (draftFurnaceBlockEntity != null) {
			draftFurnaceBlockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(itemHandler -> {
				addSlot(new SlotItemHandler(itemHandler, slotNumber++, 124, 35));

				addSlot(new SlotItemHandler(itemHandler, slotNumber++, 116, 8));
				addSlot(new SlotItemHandler(itemHandler, slotNumber++, 134, 8));
				addSlot(new SlotItemHandler(itemHandler, slotNumber++, 152, 8));

				addSlot(new SlotItemHandler(itemHandler, slotNumber++, 30, 17));
				addSlot(new SlotItemHandler(itemHandler, slotNumber++, 48, 17));
				addSlot(new SlotItemHandler(itemHandler, slotNumber++, 66, 17));
				addSlot(new SlotItemHandler(itemHandler, slotNumber++, 30, 35));
				addSlot(new SlotItemHandler(itemHandler, slotNumber++, 48, 35));
				addSlot(new SlotItemHandler(itemHandler, slotNumber++, 66, 35));
				addSlot(new SlotItemHandler(itemHandler, slotNumber++, 30, 53));
				addSlot(new SlotItemHandler(itemHandler, slotNumber++, 48, 53));
				addSlot(new SlotItemHandler(itemHandler, slotNumber++, 66, 53));
			});
		}
		addInventorySlots(8, 84);
	}

	@Override
	public boolean stillValid(Player pPlayer) {
		return true;
	}
}
