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
		return new SUpdateTileEntityPacket(this.worldPosition, 10, this.getUpdateTag());
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		BlockState blockState = level.getBlockState(worldPosition);
		load(blockState, pkt.getTag());
	}

	@Override
	public CompoundNBT getUpdateTag() {
		return this.save(new CompoundNBT());
	}

	@Override
	public void handleUpdateTag(BlockState blockState, CompoundNBT parentNBTTagCompound) {
		this.load(blockState, parentNBTTagCompound);
	}

	@Override
	public void load(BlockState state, CompoundNBT nbt) {
		super.load(state, nbt);
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
	public CompoundNBT save(CompoundNBT compound) {
		super.save(compound);
		compound.putBoolean("blade", blade);
		compound.putInt("sawTime", this.sawTime);
		compound.put("log", this.getLog().save(new CompoundNBT()));
		return compound;
	}

	@Override
	public void tick() {
		if (level.isClientSide() && this.sawTime > 0F) {
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
			ItemStack itemstack1 = ((IRecipe<ISidedInventory>) recipe).assemble(this);
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

	protected boolean canSaw(@Nullable IRecipe<?> recipeIn) {
		if (!this.items.get(0).isEmpty() && recipeIn != null) {
			@SuppressWarnings("unchecked")
			ItemStack itemstack = ((IRecipe<ISidedInventory>) recipeIn).assemble(this);
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
		return ItemStackHelper.removeItem(this.items, index, count);
	}

	@Override
	public ItemStack removeItemNoUpdate(int index) {
		return ItemStackHelper.takeItem(this.items, index);
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
	public boolean stillValid(PlayerEntity player) {
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