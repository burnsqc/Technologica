package com.technologica.network.play.server;

import com.technologica.Technologica;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class Packets {
	private static final String PROTOCOL_VERSION = "1";
	public static SimpleChannel INSTANCE;
	private static int ID = 0;
	
    public static void onCommonSetupEvent() {
	
		INSTANCE = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(Technologica.MODID, "main"), 
			() -> PROTOCOL_VERSION, 
			PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals);
		register();
	}
	
	private static int nextID() {
		return ID++;
	}

	public static void register() {
		INSTANCE.registerMessage(nextID(), SOpenModSignMenuPacket.class, SOpenModSignMenuPacket::encode, SOpenModSignMenuPacket::decode, SOpenModSignMenuPacket::handle);
		INSTANCE.registerMessage(nextID(), SOpenAnnunciatorMenuPacket.class, SOpenAnnunciatorMenuPacket::encode, SOpenAnnunciatorMenuPacket::decode, SOpenAnnunciatorMenuPacket::handle);
	}
}