package com.technologica.tileentity;

import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.technologica.state.properties.TechnologicaBlockStateProperties;
import com.technologica.util.AnnunciatorOverlay;

import net.minecraft.block.BlockState;
import net.minecraft.command.CommandSource;
import net.minecraft.command.ICommandSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class AnnunciatorTileEntity extends TileEntity {
	private ITextComponent[] signText = new ITextComponent[] { StringTextComponent.EMPTY,
			StringTextComponent.EMPTY, StringTextComponent.EMPTY, StringTextComponent.EMPTY, StringTextComponent.EMPTY,
			StringTextComponent.EMPTY, StringTextComponent.EMPTY, StringTextComponent.EMPTY };
	private final ItemStackHandler itemHandler = createHandler();
	private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
	private final IReorderingProcessor[] renderText = new IReorderingProcessor[8];

	public AnnunciatorTileEntity() {
		super(TechnologicaTileEntities.ANNUNCIATOR_TILE.get());
	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(1) {
			@Override
			protected void onContentsChanged(int slot) {
				setChanged();
				BlockState state = level.getBlockState(worldPosition);

				if (this.getStackInSlot(0).isEmpty()) {
					level.setBlock(worldPosition,
							state.setValue(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO),
							7);
				} else if (this.getStackInSlot(0).getItem().getRegistryName().getPath().contains("fail")) {
					level.setBlock(worldPosition,
							state.setValue(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL),
							7);
				} else if (this.getStackInSlot(0).getItem().getRegistryName().getPath().contains("pass")) {
					level.setBlock(worldPosition,
							state.setValue(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS),
							7);
				} else if (this.getStackInSlot(0).getItem().getRegistryName().getPath().contains("warn")) {
					level.setBlock(worldPosition,
							state.setValue(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN),
							7);
				}
			}

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
				return stack.getItem().getRegistryName().getPath().contains("overlay");
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

	@Override
	public TileEntityType<?> getType() {
		return TechnologicaTileEntities.ANNUNCIATOR_TILE.get();
	}

	public void setEditable(boolean isEditableIn) {
		if (!isEditableIn) {
		}

	}

	public void setText(int line, ITextComponent signText) {
		this.signText[line] = signText;
		this.renderText[line] = null;
		this.setChanged();
		level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 7); 
	}

	public ITextComponent getText(int line) {
		return this.signText[line];
	}

	public CommandSource getCommandSource(@Nullable ServerPlayerEntity playerIn) {
		String s = playerIn == null ? "Sign" : playerIn.getName().getString();
		ITextComponent itextcomponent = (ITextComponent) (playerIn == null ? new StringTextComponent("Sign")
				: playerIn.getDisplayName());
		return new CommandSource(ICommandSource.NULL, Vector3d.atCenterOf(this.worldPosition), Vector2f.ZERO,
				(ServerWorld) this.level, 2, s, itextcomponent, this.level.getServer(), playerIn);
	}

	public IReorderingProcessor reorderText(int row,
			Function<ITextComponent, IReorderingProcessor> textProcessorFunction) {
		if (this.renderText[row] == null && this.signText[row] != null) {
			this.renderText[row] = textProcessorFunction.apply(this.signText[row]);
		}

		return this.renderText[row];
	}

	@Nullable
	public SUpdateTileEntityPacket getUpdatePacket() {
		return new SUpdateTileEntityPacket(this.worldPosition, 9, this.getUpdateTag());
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
	public void handleUpdateTag(BlockState blockState, CompoundNBT parentNBTTagCompound)
	{
		this.load(blockState, parentNBTTagCompound);
	}
	
	@Override
	public void load(BlockState state, CompoundNBT nbt) {
		super.load(state, nbt);
		itemHandler.deserializeNBT(nbt.getCompound("overlay"));
		
		for (int i = 0; i < 8; ++i) {
			String s = nbt.getString("Text" + (i + 1));
			ITextComponent itextcomponent = ITextComponent.Serializer.fromJson(s.isEmpty() ? "\"\"" : s);
			if (this.level instanceof ServerWorld) {
				try {
					this.signText[i] = TextComponentUtils.updateForEntity(this.getCommandSource((ServerPlayerEntity) null), itextcomponent, (Entity) null, 0);
				} catch (CommandSyntaxException commandsyntaxexception) {
					this.signText[i] = itextcomponent;
				}
			} else {
				this.signText[i] = itextcomponent;
			}
			this.renderText[i] = null;
		}
	}

	@Override
	public CompoundNBT save(CompoundNBT compound) {
		super.save(compound);
		compound.put("overlay", itemHandler.serializeNBT());

		for (int i = 0; i < 8; ++i) {
			String s = ITextComponent.Serializer.toJson(this.signText[i]);
			compound.putString("Text" + (i + 1), s);
		}
		
		return compound;
	}
}