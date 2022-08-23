package com.technologica.world.inventory;

import static com.technologica.Technologica.LOGGER;

import com.technologica.Technologica;

import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TechnologicaContainerType {
	private static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Technologica.MODID);
	
	public static void init() {
		LOGGER.info("INITIALIZING CONTAINERS");
		CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
		LOGGER.info(CONTAINERS.getEntries().size() + " CONTAINERS INITIALIZED");
	}
	
	public static final RegistryObject<MenuType<AnnunciatorContainer>> ANNUNCIATOR = CONTAINERS.register("annunciator_container", () -> IForgeMenuType.create((windowId, inv, data) -> {
		BlockPos pos = data.readBlockPos();
		Level world = inv.player.getCommandSenderWorld();
		return new AnnunciatorContainer(windowId, world, pos, inv);
	}));
}
