package com.technologica.util;

import org.jetbrains.annotations.NotNull;

import com.technologica.world.level.block.entity.FastHopperBlockEntity;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.wrapper.InvWrapper;

public class TechnologicaHopperItemHandler extends InvWrapper {
    private final FastHopperBlockEntity hopper;

    public TechnologicaHopperItemHandler(FastHopperBlockEntity hopper) {
        super(hopper);
        this.hopper = hopper;
    }

    @Override
    @NotNull
    public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
        if (simulate) {
            return super.insertItem(slot, stack, simulate);
        } else {
            boolean wasEmpty = getInv().isEmpty();

            int originalStackSize = stack.getCount();
            stack = super.insertItem(slot, stack, simulate);

            if (wasEmpty && originalStackSize > stack.getCount()) {
                if (!hopper.isOnCustomCooldown()) {
                    hopper.setCooldown(8);
                }
            }
            return stack;
        }
    }
}
