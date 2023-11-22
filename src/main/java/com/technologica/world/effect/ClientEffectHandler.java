package com.technologica.world.effect;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;

public class ClientEffectHandler {

	public static void handleParalysis() {
		KeyMapping.releaseAll();
		Minecraft mc = Minecraft.getInstance();
		mc.mouseHandler.releaseMouse();
	}

}
