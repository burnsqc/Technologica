package com.technologica.world.level.block.entity;

import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.technologica.util.AnnunciatorOverlay;
import com.technologica.world.level.block.state.properties.TechnologicaBlockStateProperties;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentUtils;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.registries.ForgeRegistries;

public class AnnunciatorBlockEntity extends BlockEntity {
	private Component[] signText = new Component[] { Component.empty(), Component.empty(), Component.empty(), Component.empty(), Component.empty(), Component.empty(), Component.empty(), Component.empty() };
	private final ItemStackHandler itemHandler = createHandler();
	private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
	private final FormattedCharSequence[] renderText = new FormattedCharSequence[8];

	public AnnunciatorBlockEntity(BlockPos p_155700_, BlockState p_155701_) {
		super(TechnologicaBlockEntityType.ANNUNCIATOR_TILE.get(), p_155700_, p_155701_);
	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(1) {
			@Override
			protected void onContentsChanged(int slot) {
				setChanged();
				BlockState state = level.getBlockState(worldPosition);

				if (this.getStackInSlot(0).isEmpty()) {
					level.setBlock(worldPosition, state.setValue(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO), 7);
				} else if (ForgeRegistries.ITEMS.getKey(this.getStackInSlot(0).getItem()).getPath().contains("fail")) {
					level.setBlock(worldPosition, state.setValue(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL), 7);
				} else if (ForgeRegistries.ITEMS.getKey(this.getStackInSlot(0).getItem()).getPath().contains("pass")) {
					level.setBlock(worldPosition, state.setValue(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS), 7);
				} else if (ForgeRegistries.ITEMS.getKey(this.getStackInSlot(0).getItem()).getPath().contains("warn")) {
					level.setBlock(worldPosition, state.setValue(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN), 7);
				}
			}

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
				return ForgeRegistries.ITEMS.getKey(stack.getItem()).getPath().contains("overlay");
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
		if (cap == ForgeCapabilities.ITEM_HANDLER) {
			return handler.cast();
		}
		return super.getCapability(cap, side);
	}

	@Override
	public BlockEntityType<?> getType() {
		return TechnologicaBlockEntityType.ANNUNCIATOR_TILE.get();
	}

	public void setEditable(boolean isEditableIn) {
		if (!isEditableIn) {
		}

	}

	public void setText(int line, Component signText) {
		this.signText[line] = signText;
		this.renderText[line] = null;
		this.setChanged();
		level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 7);
	}

	public Component getText(int line) {
		return this.signText[line];
	}

	public CommandSourceStack getCommandSource(@Nullable ServerPlayer playerIn) {
		String s = playerIn == null ? "Sign" : playerIn.getName().getString();
		Component itextcomponent = playerIn == null ? Component.literal("Sign") : playerIn.getDisplayName();
		return new CommandSourceStack(CommandSource.NULL, Vec3.atCenterOf(this.worldPosition), Vec2.ZERO, (ServerLevel) this.level, 2, s, itextcomponent, this.level.getServer(), playerIn);
	}

	public FormattedCharSequence reorderText(int row, Function<Component, FormattedCharSequence> textProcessorFunction) {
		if (this.renderText[row] == null && this.signText[row] != null) {
			this.renderText[row] = textProcessorFunction.apply(this.signText[row]);
		}

		return this.renderText[row];
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
	public void load(CompoundTag p_155716_) {
		super.load(p_155716_);
		itemHandler.deserializeNBT(p_155716_.getCompound("overlay"));

		for (int i = 0; i < 8; ++i) {
			String s = p_155716_.getString("Text" + (i + 1));
			Component itextcomponent = Component.Serializer.fromJson(s.isEmpty() ? "\"\"" : s);
			if (this.level instanceof ServerLevel) {
				try {
					this.signText[i] = ComponentUtils.updateForEntity(this.getCommandSource((ServerPlayer) null), itextcomponent, (Entity) null, 0);
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
	protected void saveAdditional(CompoundTag compound) {
		super.saveAdditional(compound);
		compound.put("overlay", itemHandler.serializeNBT());

		for (int i = 0; i < 8; ++i) {
			String s = Component.Serializer.toJson(this.signText[i]);
			compound.putString("Text" + (i + 1), s);
		}
	}
}