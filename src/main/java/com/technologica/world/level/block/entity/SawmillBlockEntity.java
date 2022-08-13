package com.technologica.world.level.block.entity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.technologica.world.item.TechnologicaItems;
import com.technologica.world.item.crafting.TechnologicaRecipeType;
import com.technologica.world.level.block.SawmillBlock;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.RecipeHolder;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class SawmillBlockEntity extends BlockEntity implements WorldlyContainer, RecipeHolder, StackedContentsCompatible {
	private final ItemStackHandler itemHandler = createHandler();
	private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
	private int sawTime;
	private double logPos;
	protected NonNullList<ItemStack> items = NonNullList.withSize(3, ItemStack.EMPTY);
	private final Object2IntOpenHashMap<ResourceLocation> recipes = new Object2IntOpenHashMap<>();

	public SawmillBlockEntity(BlockPos p_155700_, BlockState p_155701_) {
		super(TechnologicaBlockEntityType.SAWMILL_TILE.get(), p_155700_, p_155701_);
	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(3) {
			@Override
			protected void onContentsChanged(int slot) {
				setChanged();
			}

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
				if (slot == 0) {
					return stack.getItem().getRegistryName().getPath().contains("sawblade");
				} else if (slot == 2) {
					return stack.getItem().getRegistryName().getPath().contains("planks") || stack.isEmpty();
				}
				return stack.getItem().getRegistryName().getPath().contains("log");
			}

			@Override
			public int getSlotLimit(int slot) {
				return 1;
			}

			@Nonnull
			@Override
			public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
				if (!isItemValid(slot, stack)) {
					return stack;
				}

				return super.insertItem(slot, stack, simulate);
			}
		};
	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return handler.cast();
		}
		return super.getCapability(cap, side);
	}

	public boolean getBlade() {
		if (getItem(0) != ItemStack.EMPTY) {
			return true;
		}
		return false;
	}

	public void setBlade(boolean bladeIn) {
		if (bladeIn) {
			itemHandler.insertItem(0, new ItemStack(TechnologicaItems.SAWBLADE.get(), 1), false);
		} else {
			itemHandler.insertItem(0, ItemStack.EMPTY, false);
		}
	}

	public ItemStack getLog() {
		return getItem(1);
	}

	public void setLog(ItemStack logIn) {
		if (!ItemStack.matches(logIn, ItemStack.EMPTY)) {
			this.sawTime = 100;
			itemHandler.insertItem(1, logIn, false);
		} else {
			itemHandler.setStackInSlot(1, logIn);
		}

	}

	public boolean isSawing() {
		return this.sawTime > 0;
	}

	public double getLogPos() {
		return logPos;
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
		if (nbt.contains("sawTime")) {
			this.sawTime = nbt.getInt("sawTime");
		}
		if (nbt.contains("logPos")) {
			this.logPos = nbt.getDouble("logPos");
		}
	}

	@Override
	public void saveAdditional(CompoundTag compound) {
		super.saveAdditional(compound);
		compound.putInt("sawTime", this.sawTime);
		compound.putDouble("logPos", this.logPos);
	}

	public void serverTick() {
		if (this.sawTime > 0F) {
			this.sawTime--;
		} else if (!getItem(1).isEmpty()) {
			Recipe<?> recipe = this.level.getRecipeManager().getRecipeFor(TechnologicaRecipeType.SAWMILL, this, this.level).orElse(null);
			if (recipe != null) {
				ItemStack output = recipe.getResultItem();
				if (!output.isEmpty()) {
					setLog(ItemStack.EMPTY);
					itemHandler.insertItem(2, output, false);
					Vec3i offset = this.getBlockState().getValue(SawmillBlock.NESW_FACING).getNormal().multiply(2);
					this.level.addFreshEntity(new ItemEntity(level, this.worldPosition.offset(offset).getX(), this.worldPosition.getY() + 1, this.worldPosition.offset(offset).getZ(), output));
				}
			}
		}
	}

	public void clientTick() {
		if (this.sawTime > 0F) {
			this.logPos = 2.0D - 4.0D * (sawTime / 100.0D);
			this.sawTime--;
		} else if (!getItem(1).isEmpty()) {
			setLog(ItemStack.EMPTY);
		}
	}

	protected boolean canSaw(@Nullable Recipe<?> recipeIn) {
		if (!this.items.get(0).isEmpty() && recipeIn != null) {
			@SuppressWarnings("unchecked")
			ItemStack itemstack = ((Recipe<WorldlyContainer>) recipeIn).assemble(this);
			if (itemstack.isEmpty()) {
				return false;
			} else {
				ItemStack itemstack1 = this.items.get(2);
				if (itemstack1.isEmpty()) {
					return true;
				} else if (!itemstack1.sameItem(itemstack)) {
					return false;
				} else if (itemstack1.getCount() + itemstack.getCount() <= this.getMaxStackSize() && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize()) {
					return true;
				} else {
					return itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize();
				}
			}
		} else {
			return false;
		}
	}

	public int getSawTime() {
		return this.sawTime;
	}

	@Override
	public void fillStackedContents(StackedContents helper) {
		for (ItemStack itemstack : this.items) {
			helper.accountStack(itemstack);
		}
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
	public int getContainerSize() {
		return this.items.size();
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack itemstack : this.items) {
			if (!itemstack.isEmpty()) {
				return false;
			}
		}

		return true;
	}

	@Override
	public ItemStack getItem(int index) {
		return this.itemHandler.getStackInSlot(index);
	}

	@Override
	public ItemStack removeItem(int index, int count) {
		return ContainerHelper.removeItem(this.items, index, count);
	}

	@Override
	public ItemStack removeItemNoUpdate(int index) {
		return ContainerHelper.takeItem(this.items, index);
	}

	@Override
	public void setItem(int index, ItemStack stack) {
		ItemStack itemstack = this.items.get(index);
		boolean flag = !stack.isEmpty() && stack.sameItem(itemstack) && ItemStack.tagMatches(stack, itemstack);
		this.items.set(index, stack);
		if (stack.getCount() > this.getMaxStackSize()) {
			stack.setCount(this.getMaxStackSize());
		}

		if (index == 0 && !flag) {
			this.sawTime = 0;
			this.setChanged();
		}

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
	public void clearContent() {
		this.items.clear();
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
}