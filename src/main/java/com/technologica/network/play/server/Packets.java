package com.technologica.network.play.server;

import com.technologica.Technologica;
import com.technologica.network.play.client.CUpdateAnnunciatorPacket;
import com.technologica.network.play.client.CUpdateMonitorPacket;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class Packets {
	private static final String PROTOCOL_VERSION = "1";
	public static SimpleChannel INSTANCE;
	private static int ID = 0;

	public static void onCommonSetupEvent() {
		INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(Technologica.MODID, "main"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
		register();
	}

	public static int nextID() {
		return ID++;
	}

	public static void register() {
		INSTANCE.registerMessage(nextID(), CUpdateAnnunciatorPacket.class, CUpdateAnnunciatorPacket::encode, CUpdateAnnunciatorPacket::decode, CUpdateAnnunciatorPacket::handle);
		INSTANCE.registerMessage(nextID(), CUpdateMonitorPacket.class, CUpdateMonitorPacket::encode, CUpdateMonitorPacket::decode, CUpdateMonitorPacket::handle);
		if (FMLEnvironment.dist.isClient()) {
			INSTANCE.registerMessage(nextID(), SUpdateAirCapabilityPacket.class, SUpdateAirCapabilityPacket::encode, SUpdateAirCapabilityPacket::decode, SUpdateAirCapabilityPacket::handle);
		}
	}
}