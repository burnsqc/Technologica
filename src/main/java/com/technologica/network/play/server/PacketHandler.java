package com.technologica.network.play.server;

import com.technologica.Technologica;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PacketHandler {
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
		INSTANCE.registerMessage(nextID(), ModSOpenSignMenuPacket.class, ModSOpenSignMenuPacket::encode,
				ModSOpenSignMenuPacket::decode, ModSOpenSignMenuPacket::handle);
	}
}