package com.technologica.world.level.block.entity;

import javax.annotation.Nullable;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.RecipeHolder;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SawmillTileEntity extends BlockEntity implements WorldlyContainer, RecipeHolder, StackedContentsCompatible {
	private boolean blade = false;
	private ItemStack log = ItemStack.EMPTY;
	private int sawTime;
	private double logPos;
	protected NonNullList<ItemStack> items = NonNullList.withSize(3, ItemStack.EMPTY);
	private final Object2IntOpenHashMap<ResourceLocation> recipes = new Object2IntOpenHashMap<>();

	public SawmillTileEntity(BlockPos p_155700_, BlockState p_155701_) {
		super(TechnologicaBlockEntityType.SAWMILL_TILE.get(), p_155700_, p_155701_);
	}

	public boolean getBlade() {
		return blade;
	}

	public void setBlade(boolean bladeIn) {
		blade = bladeIn;
	}

	public ItemStack getLog() {
		return log;
	}

	public void setLog(ItemStack logIn) {
		log = logIn;
		this.sawTime = 100;
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
		if (nbt.contains("blade")) {
			blade = nbt.getBoolean("blade");
		}
		if (nbt.contains("sawTime")) {
			this.sawTime = nbt.getInt("sawTime");
		}
		if (nbt.contains("log")) {
			this.setLog(ItemStack.of(nbt.getCompound("log")));
		}
	}

	@Override
	public void saveAdditional(CompoundTag compound) {
		super.saveAdditional(compound);
		compound.putBoolean("blade", blade);
		compound.putInt("sawTime", this.sawTime);
		compound.put("log", this.getLog().save(new CompoundTag()));
	}

	public void tick() {
		if (level.isClientSide() && this.sawTime > 0F) {
			logPos = 1.0 - 4.0 * (sawTime / 200);
			sawTime--;
		} else if (!log.isEmpty()) {
			setLog(ItemStack.EMPTY);
		}
	}

	@SuppressWarnings("unused")
	private void saw(@Nullable Recipe<?> recipe) {
		if (recipe != null && this.canSaw(recipe)) {
			ItemStack itemstack = this.items.get(0);
			@SuppressWarnings("unchecked")
			ItemStack itemstack1 = ((Recipe<WorldlyContainer>) recipe).assemble(this);
			ItemStack itemstack2 = this.items.get(2);
			if (itemstack2.isEmpty()) {
				this.items.set(2, itemstack1.copy());
			} else if (itemstack2.getItem() == itemstack1.getItem()) {
				itemstack2.grow(itemstack1.getCount());
			}

			if (!this.level.isClientSide) {
				this.setRecipeUsed(recipe);
			}

			itemstack.shrink(1);
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
		for(ItemStack itemstack : this.items) {
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
		for(ItemStack itemstack : this.items) {
			if (!itemstack.isEmpty()) {
				return false;
			}
		}

		return true;
	}

	@Override
	public ItemStack getItem(int index) {
		return this.items.get(index);
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
			//this.sawTimeTotal = this.getSawTime();
			this.sawTime = 0;
			this.setChanged();
		}
		
	}

	@Override
	public boolean stillValid(Player player) {
		if (this.level.getBlockEntity(this.worldPosition) != this) {
			return false;
		} else {
			return player.distanceToSqr((double)this.worldPosition.getX() + 0.5D, (double)this.worldPosition.getY() + 0.5D, (double)this.worldPosition.getZ() + 0.5D) <= 64.0D;
		}
	}

	@Override
	public void clearContent() {
		this.items.clear();
	}

	@Override
	public int[] getSlotsForFace(Direction side) {
		return null;
	}

	@Override
	public boolean canPlaceItemThroughFace(int index, ItemStack itemStackIn, Direction direction) {
		return false;
	}

	@Override
	public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
		return false;
	}
}