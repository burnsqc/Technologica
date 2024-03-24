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
		BlockEntity tileentity = world.getBlockEntity(packet.getPos());
		BlockState blockstate = world.getBlockState(packet.getPos());

		if (tileentity instanceof AnnunciatorBlockEntity) {
			for (int i = 0; i < 8; ++i) {
				((AnnunciatorBlockEntity) tileentity).setText(i, Component.nullToEmpty(packet.getLines()[i]));
			}
			tileentity.setChanged();
			world.sendBlockUpdated(packet.getPos(), blockstate, blockstate, 3);
		}
	}

	public static void handleUpdateMonitor(UpdateMonitor packet, final Supplier<NetworkEvent.Context> context) {
		Technologica.LOGGER.debug("HANDLING PACKET - SERVERBOUND - UPDATE MONITOR");
		Level world = context.get().getSender().level();
		BlockEntity tileentity = world.getBlockEntity(packet.getPos());
		BlockState blockstate = world.getBlockState(packet.getPos());
		if (tileentity instanceof MonitorBlockEntity) {
			for (int i = 0; i < 16; ++i) {
				((MonitorBlockEntity) tileentity).setText(i, Component.nullToEmpty(packet.getLines()[i]));
			}
			tileentity.setChanged();
			world.sendBlockUpdated(packet.getPos(), blockstate, blockstate, 3);
		}
	}
}