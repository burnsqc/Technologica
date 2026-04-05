package com.technologica.network.packethandlers;

import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.network.packets.serverbound.UpdateAnnunciator;
import com.technologica.network.packets.serverbound.UpdateMonitor;
import com.technologica.world.level.block.entity.AnnunciatorBlockEntity;
import com.technologica.world.level.block.entity.MonitorBlockEntity;

import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.NetworkEvent;

public class ServerboundPacketHandlers {

	public static void handleUpdateAnnunciator(UpdateAnnunciator packet, final Supplier<NetworkEvent.Context> context) {
		Technologica.LOGGER.debug("HANDLING PACKET - SERVERBOUND - UPDATE ANNUNCIATOR");
		Level world = context.get().getSender().level();
		BlockEntity blockEntity = world.getBlockEntity(packet.getPos());
		BlockState blockState = world.getBlockState(packet.getPos());
		if (blockEntity instanceof AnnunciatorBlockEntity) {
			for (int i = 0; i < 8; ++i) {
				((AnnunciatorBlockEntity) blockEntity).setText(i, Component.nullToEmpty(packet.getLines()[i]));
			}
			blockEntity.setChanged();
			world.sendBlockUpdated(packet.getPos(), blockState, blockState, 3);
		}
	}

	public static void handleUpdateMonitor(UpdateMonitor packet, final Supplier<NetworkEvent.Context> context) {
		Technologica.LOGGER.debug("HANDLING PACKET - SERVERBOUND - UPDATE MONITOR");
		Level level = context.get().getSender().level();
		BlockEntity blockEntity = level.getBlockEntity(packet.getBlockPos());
		BlockState blockState = level.getBlockState(packet.getBlockPos());
		if (blockEntity instanceof MonitorBlockEntity) {
			((MonitorBlockEntity) blockEntity).setText(packet.getText());
			blockEntity.setChanged();
			level.sendBlockUpdated(packet.getBlockPos(), blockState, blockState, 3);
		}
	}
}
