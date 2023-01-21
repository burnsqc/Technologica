package com.technologica.world.level.block.entity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import com.technologica.world.item.TechnologicaItems;
import com.technologica.world.item.crafting.SawmillRecipe;
import com.technologica.world.item.crafting.TechnologicaRecipeType;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Container;
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
import net.minecraftforge.registries.ForgeRegistries;

public class SawmillBlockEntity extends BlockEntity implements WorldlyContainer, RecipeHolder {
	private boolean blade;
	private int sawingTicks;
	private double sawingProgress;
	private double rpm = 1.0D;
	private final ItemStackHandler itemHandler = createHandler();
	private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
	private final Object2IntOpenHashMap<ResourceLocation> recipes = new Object2IntOpenHashMap<>();

	public SawmillBlockEntity(BlockPos p_155700_, BlockState p_155701_) {
		super(TechnologicaBlockEntityType.SAWMILL_TILE.get(), p_155700_, p_155701_);
	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(5) {
			@Override
			protected void onContentsChanged(int slot) {
				setChanged();
				if (slot == 0) {
					setBlade(this.getStackInSlot(slot).is(TechnologicaItems.SAWBLADE.get()));
				}
			}

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
				if (slot == 0) {
					return stack.is(TechnologicaItems.SAWBLADE.get());
				} else if (slot == 1) {
					return ForgeRegistries.ITEMS.tags().getTag(ItemTags.LOGS).contains(stack.getItem()) || ForgeRegistries.ITEMS.tags().getTag(ItemTags.PLANKS).contains(stack.getItem());
				}
				return true;
			}

			@Override
			@NotNull
			public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
				if (!isItemValid(slot, stack)) {
					return stack;
				}
				if (slot == 1) {
					setLog(stack);
				}

				return super.insertItem(slot, stack, simulate);
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

	public void setLog(ItemStack logIn) {
		setChanged();
	}

	public ItemStack getLog() {
		return getItem(1);
	}

	public boolean isSawing() {
		return this.sawingTicks > 0;
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
		if (nbt.contains("sawBlade")) {
			this.blade = nbt.getBoolean("sawBlade");
		}
		if (nbt.contains("sawingTicks")) {
			this.sawingTicks = nbt.getInt("sawingTicks");
		}
		if (nbt.contains("logPos")) {
			this.sawingProgress = nbt.getDouble("logPos");
		}
		if (nbt.contains("handler")) {
			itemHandler.deserializeNBT(nbt.getCompound("handler"));
		}
	}

	@Override
	public void saveAdditional(CompoundTag compound) {
		super.saveAdditional(compound);
		compound.putBoolean("sawBlade", this.blade);
		compound.putInt("sawingTicks", this.sawingTicks);
		compound.putDouble("logPos", this.sawingProgress);
		compound.put("handler", itemHandler.serializeNBT());
	}

	public void serverTick() {
		if (this.sawingProgress < 100.0D && !getItem(1).isEmpty()) {
			this.sawingProgress = this.sawingTicks * this.rpm;
			this.sawingTicks++;
			level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
		} else if (!getItem(1).isEmpty()) {
			Recipe<Container> recipe = this.level.getRecipeManager().getRecipeFor(TechnologicaRecipeType.SAWMILL.get(), this, this.level).orElse(null);
			if (recipe != null) {
				ItemStack output = ((SawmillRecipe) recipe).getResultItem1();
				ItemStack output2 = ((SawmillRecipe) recipe).getResultItem2();

				itemHandler.insertItem(2, output, false);

				if (output2.getItem() == TechnologicaItems.MULCH.get()) {
					itemHandler.insertItem(3, output2, false);
				} else if (output2.getItem() == TechnologicaItems.SAWDUST.get()) {
					itemHandler.insertItem(4, output2, false);
				}

				itemHandler.extractItem(1, 1, false);
				if (!itemHandler.getStackInSlot(1).isEmpty()) {
					// this.sawTime = 100;
				}
				setRecipeUsed(recipe);
				this.sawingProgress = 0.0D;
				this.sawingTicks = 0;
				// level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
			}
		} else {
			this.sawingProgress = 0.0D;
			this.sawingTicks = 0;
			level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
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

	public int getSawingTicks() {
		return this.sawingTicks;
	}

	public double getSawingProgress() {
		return this.sawingProgress;
	}

	public void setBlade(boolean bladeIn) {
		this.blade = bladeIn;
	}

	public boolean getBlade() {
		return this.blade;
	}
}
