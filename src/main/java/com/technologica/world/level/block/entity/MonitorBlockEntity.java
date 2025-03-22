package com.technologica.world.level.block.entity;

import java.util.Collections;

import javax.annotation.Nullable;

import com.technologica.registration.deferred.TechnologicaBlockEntityTypes;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class MonitorBlockEntity extends BlockEntity {
	private String[] text = Collections.nCopies(40, " ").toArray(new String[0]);

	public MonitorBlockEntity(BlockPos blockPos, BlockState blockState) {
		super(TechnologicaBlockEntityTypes.MONITOR.get(), blockPos, blockState);
	}

	@Override
	public BlockEntityType<?> getType() {
		return TechnologicaBlockEntityTypes.MONITOR.get();
	}

	public void setEditable(boolean isEditableIn) {
		if (!isEditableIn) {
		}
	}

	public void setText(String[] text) {
		this.text = text;
		this.setChanged();
		level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 7);
	}

	public String[] getText() {
		return this.text;
	}

	public CommandSourceStack getCommandSource(@Nullable ServerPlayer playerIn) {
		String s = playerIn == null ? "Sign" : playerIn.getName().getString();
		Component itextcomponent = playerIn == null ? Component.literal("Sign") : playerIn.getDisplayName();
		return new CommandSourceStack(CommandSource.NULL, Vec3.atCenterOf(this.worldPosition), Vec2.ZERO, (ServerLevel) this.level, 2, s, itextcomponent, this.level.getServer(), playerIn);
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
	public void load(CompoundTag compoundTag) {
		super.load(compoundTag);
		for (int row = 0; row < text.length; ++row) {
			text[row] = compoundTag.getString("Line" + (row + 1));
		}
	}

	@Override
	protected void saveAdditional(CompoundTag compoundTag) {
		super.saveAdditional(compoundTag);
		for (int row = 0; row < text.length; ++row) {
			compoundTag.putString("Line" + (row + 1), this.text[row]);
		}
	}
}
