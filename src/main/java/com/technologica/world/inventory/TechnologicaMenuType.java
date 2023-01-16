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

public class TechnologicaMenuType {
	private static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Technologica.MODID);

	public static void init() {
		MENU_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
		LOGGER.info("MENU TYPES INITIALIZED: " + MENU_TYPES.getEntries().size() + " OF 2");
	}

	public static final RegistryObject<MenuType<AnnunciatorMenu>> ANNUNCIATOR = MENU_TYPES.register("annunciator_container", () -> IForgeMenuType.create((windowId, inv, data) -> {
		BlockPos pos = data.readBlockPos();
		Level world = inv.player.getCommandSenderWorld();
		return new AnnunciatorMenu(windowId, world, pos, inv);
	}));

	public static final RegistryObject<MenuType<SawmillMenu>> SAWMILL = MENU_TYPES.register("sawmill_container", () -> IForgeMenuType.create((windowId, inv, data) -> {
		BlockPos pos = data.readBlockPos();
		Level world = inv.player.getCommandSenderWorld();
		return new SawmillMenu(windowId, world, pos, inv);
	}));
}