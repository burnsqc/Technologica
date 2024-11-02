package com.technologica.world.level.block.entity;

import com.technologica.registration.deferred.TechnologicaBlockEntityTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class LandMineBlockEntity extends BlockEntity {
	private BlockState previousBlockState = Blocks.AIR.defaultBlockState();
	private boolean isArmed = false;

	public LandMineBlockEntity(BlockPos p_155700_, BlockState p_155701_) {
		super(TechnologicaBlockEntityTypes.LAND_MINE.get(), p_155700_, p_155701_);
	}

	public BlockState getPreviousBlockState() {
		return previousBlockState;
	}

	public void setPreviousBlockState(BlockState previousBlockStateIn) {
		this.previousBlockState = previousBlockStateIn;
		setChanged();
		if (level != null) {
			level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 2);
		}
	}

	public Boolean getArmed() {
		return isArmed;
	}

	public void setArmed() {
		isArmed = true;
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

	public void serverTick() {
		if (isArmed) {
			if (this.level.getEntities(null, new AABB(this.getBlockPos()).expandTowards(0.0D, 1.0D, 0.0D)).isEmpty()) {
				level.explode(null, worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), 2.0F, Level.ExplosionInteraction.TNT);
			}
		}
	}

	@Override
	public void load(CompoundTag compoundTag) {
		super.load(compoundTag);
		@SuppressWarnings("deprecation")
		HolderGetter<Block> holdergetter = this.level != null ? this.level.holderLookup(Registries.BLOCK) : BuiltInRegistries.BLOCK.asLookup();
		if (compoundTag.contains("previousState")) {
			this.setPreviousBlockState(NbtUtils.readBlockState(holdergetter, compoundTag.getCompound("previousState")));
		}
	}

	@Override
	public void saveAdditional(CompoundTag compoundTag) {
		super.saveAdditional(compoundTag);
		compoundTag.put("previousState", NbtUtils.writeBlockState(getPreviousBlockState()));
	}
}
