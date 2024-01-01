package com.technologica.world.level.block.entity;

import java.util.function.Function;

import javax.annotation.Nullable;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.technologica.registration.deferred.TechnologicaBlockEntityTypes;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentUtils;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class MonitorBlockEntity extends BlockEntity {
	private Component[] signText = new Component[] { Component.empty(), Component.empty(), Component.empty(), Component.empty(), Component.empty(), Component.empty(), Component.empty(), Component.empty(), Component.empty(), Component.empty(), Component.empty(), Component.empty(), Component.empty(), Component.empty(), Component.empty(), Component.empty(), Component.empty(), Component.empty(), Component.empty(), Component.empty() };
	private final FormattedCharSequence[] renderText = new FormattedCharSequence[16];

	public MonitorBlockEntity(BlockPos p_155700_, BlockState p_155701_) {
		super(TechnologicaBlockEntityTypes.MONITOR_TILE.get(), p_155700_, p_155701_);
	}

	@Override
	public BlockEntityType<?> getType() {
		return TechnologicaBlockEntityTypes.MONITOR_TILE.get();
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

		for (int i = 0; i < 16; ++i) {
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

		for (int i = 0; i < 16; ++i) {
			String s = Component.Serializer.toJson(this.signText[i]);
			compound.putString("Text" + (i + 1), s);
		}
	}
}