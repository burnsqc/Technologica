package com.technologica.world.level.block.entity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.technologica.registration.deferred.TechnologicaBlockEntityTypes;
import com.technologica.registration.deferred.TechnologicaItems;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class CarpentryWorkbenchBlockEntity extends BlockEntity implements WorldlyContainer, RecipeHolder {
	private final ItemStackHandler itemHandler = createHandler();
	private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
	private final Object2IntOpenHashMap<ResourceLocation> recipes = new Object2IntOpenHashMap<>();

	public CarpentryWorkbenchBlockEntity(BlockPos p_155700_, BlockState p_155701_) {
		super(TechnologicaBlockEntityTypes.CARPENTY_WORKBENCH.get(), p_155700_, p_155701_);
	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(13) {
			@Override
			protected void onContentsChanged(int slot) {
				setChanged();
			}

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
				if (slot == 0) {
					return stack.is(TechnologicaItems.SAW.get());
				} else if (slot == 1) {
					return stack.is(TechnologicaItems.SAW.get());
				} else if (slot == 2) {
					return stack.is(TechnologicaItems.CHISEL.get());
				} else if (slot == 3) {
					return stack.is(TechnologicaItems.GLUE_BOTTLE.get());
				}
				return true;
			}
		};
	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capabilityIn, @Nullable Direction sideIn) {
		if (capabilityIn == ForgeCapabilities.ITEM_HANDLER) {
			return handler.cast();
		}
		return super.getCapability(capabilityIn, sideIn);
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
		load(pkt.getTag());
	}

	@Override
	public CompoundTag getUpdateTag() {
		return this.saveWithoutMetadata();
	}

	@Override
	public void handleUpdateTag(CompoundTag parentNBTTagCompound) {
		this.load(parentNBTTagCompound);
	}

	@Override
	public void load(CompoundTag nbt) {
		super.load(nbt);
		if (nbt.contains("handler")) {
			itemHandler.deserializeNBT(nbt.getCompound("handler"));
		}
	}

	@Override
	public void saveAdditional(CompoundTag compound) {
		super.saveAdditional(compound);
		compound.put("handler", itemHandler.serializeNBT());
	}

	@Override
	public void setRecipeUsed(Recipe<?> recipe) {
		if (recipe != null) {
			ResourceLocation resourcelocation = recipe.getId();
			this.recipes.addTo(resourcelocation, 1);
		}
	}

	@Override
	public Recipe<?> getRecipeUsed() {
		return null;
	}

	@Override
	public ItemStack getItem(int index) {
		return this.itemHandler.getStackInSlot(index);
	}

	@Override
	public boolean stillValid(Player player) {
		if (this.level.getBlockEntity(this.worldPosition) != this) {
			return false;
		} else {
			return player.distanceToSqr(this.worldPosition.getX() + 0.5D, this.worldPosition.getY() + 0.5D, this.worldPosition.getZ() + 0.5D) <= 64.0D;
		}
	}

	@Override
	public int[] getSlotsForFace(Direction direction) {
		return null;
	}

	@Override
	public boolean canPlaceItemThroughFace(int index, ItemStack itemStackIn, Direction direction) {
		return false;
	}

	@Override
	public boolean canTakeItemThroughFace(int index, ItemStack itemStackIn, Direction direction) {
		return false;
	}

	@Override
	public int getContainerSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemStack removeItem(int p_18942_, int p_18943_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack removeItemNoUpdate(int p_18951_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setItem(int p_18944_, ItemStack p_18945_) {
		// TODO Auto-generated method stub
	}

	@Override
	public void clearContent() {
		// TODO Auto-generated method stub
	}
}
