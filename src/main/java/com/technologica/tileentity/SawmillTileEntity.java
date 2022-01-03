package com.technologica.tileentity;

import javax.annotation.Nullable;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IRecipeHelperPopulator;
import net.minecraft.inventory.IRecipeHolder;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipeItemHelper;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class SawmillTileEntity extends TileEntity implements ISidedInventory, IRecipeHolder, IRecipeHelperPopulator, ITickableTileEntity {
	private boolean blade = false;
	private ItemStack log = ItemStack.EMPTY;
	private int sawTime;
	//private int sawTimeTotal;
	private double logPos;
	protected NonNullList<ItemStack> items = NonNullList.withSize(3, ItemStack.EMPTY);
	private final Object2IntOpenHashMap<ResourceLocation> recipes = new Object2IntOpenHashMap<>();

	public SawmillTileEntity() {
		super(TechnologicaTileEntities.SAWMILL_TILE.get());
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
	@Nullable
	public SUpdateTileEntityPacket getUpdatePacket() {
		return new SUpdateTileEntityPacket(this.pos, 10, this.getUpdateTag());
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		BlockState blockState = world.getBlockState(pos);
		read(blockState, pkt.getNbtCompound());
	}

	@Override
	public CompoundNBT getUpdateTag() {
		return this.write(new CompoundNBT());
	}

	@Override
	public void handleUpdateTag(BlockState blockState, CompoundNBT parentNBTTagCompound) {
		this.read(blockState, parentNBTTagCompound);
	}

	@Override
	public void read(BlockState state, CompoundNBT nbt) {
		super.read(state, nbt);
		if (nbt.contains("blade")) {
			blade = nbt.getBoolean("blade");
		}
		if (nbt.contains("sawTime")) {
			this.sawTime = nbt.getInt("sawTime");
		}
		if (nbt.contains("log")) {
			this.setLog(ItemStack.read(nbt.getCompound("log")));
		}
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		compound.putBoolean("blade", blade);
		compound.putInt("sawTime", this.sawTime);
		compound.put("log", this.getLog().write(new CompoundNBT()));
		return compound;
	}

	@Override
	public void tick() {
		if (world.isRemote() && this.sawTime > 0F) {
			logPos = 1.0 - 4.0 * (sawTime / 200);
			sawTime--;
		} else if (!log.isEmpty()) {
			setLog(ItemStack.EMPTY);
		}
	}

	@SuppressWarnings("unused")
	private void saw(@Nullable IRecipe<?> recipe) {
		if (recipe != null && this.canSaw(recipe)) {
			ItemStack itemstack = this.items.get(0);
			@SuppressWarnings("unchecked")
			ItemStack itemstack1 = ((IRecipe<ISidedInventory>) recipe).getCraftingResult(this);
			ItemStack itemstack2 = this.items.get(2);
			if (itemstack2.isEmpty()) {
				this.items.set(2, itemstack1.copy());
			} else if (itemstack2.getItem() == itemstack1.getItem()) {
				itemstack2.grow(itemstack1.getCount());
			}

			if (!this.world.isRemote) {
				this.setRecipeUsed(recipe);
			}

			itemstack.shrink(1);
		}
	}

	protected boolean canSaw(@Nullable IRecipe<?> recipeIn) {
		if (!this.items.get(0).isEmpty() && recipeIn != null) {
			@SuppressWarnings("unchecked")
			ItemStack itemstack = ((IRecipe<ISidedInventory>) recipeIn).getCraftingResult(this);
			if (itemstack.isEmpty()) {
				return false;
			} else {
				ItemStack itemstack1 = this.items.get(2);
				if (itemstack1.isEmpty()) {
					return true;
				} else if (!itemstack1.isItemEqual(itemstack)) {
					return false;
				} else if (itemstack1.getCount() + itemstack.getCount() <= this.getInventoryStackLimit() && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize()) { 																																								
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
	public void fillStackedContents(RecipeItemHelper helper) {
		for(ItemStack itemstack : this.items) {
	         helper.accountStack(itemstack);
	      }
	}

	@Override
	public void setRecipeUsed(IRecipe<?> recipe) {
		if (recipe != null) {
			ResourceLocation resourcelocation = recipe.getId();
			this.recipes.addTo(resourcelocation, 1);
		}	
	}

	@Override
	public IRecipe<?> getRecipeUsed() {
		return null;
	}

	@Override
	public int getSizeInventory() {
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
	public ItemStack getStackInSlot(int index) {
		return this.items.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		return ItemStackHelper.getAndSplit(this.items, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(this.items, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		ItemStack itemstack = this.items.get(index);
		boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
		this.items.set(index, stack);
		if (stack.getCount() > this.getInventoryStackLimit()) {
			stack.setCount(this.getInventoryStackLimit());
		}
		
		if (index == 0 && !flag) {
			//this.sawTimeTotal = this.getSawTime();
			this.sawTime = 0;
			this.markDirty();
		}
		
	}

	@Override
	public boolean isUsableByPlayer(PlayerEntity player) {
		if (this.world.getTileEntity(this.pos) != this) {
			return false;
		} else {
			return player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
		}
	}

	@Override
	public void clear() {
		this.items.clear();
	}

	@Override
	public int[] getSlotsForFace(Direction side) {
		return null;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, Direction direction) {
		return false;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
		return false;
	}
}