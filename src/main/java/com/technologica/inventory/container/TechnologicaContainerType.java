package com.technologica.inventory.container;

import static com.technologica.Technologica.LOGGER;
import com.technologica.Technologica;

import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TechnologicaContainerType {
	private static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Technologica.MODID);
	
	public static void init() {
		LOGGER.info("INITIALIZING CONTAINERS");
		CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
		LOGGER.info(CONTAINERS.getEntries().size() + " CONTAINERS INITIALIZED");
	}
	
	public static final RegistryObject<ContainerType<AnnunciatorContainer>> ANNUNCIATOR = CONTAINERS.register("annunciator_container", () -> IForgeContainerType.create((windowId, inv, data) -> {
		BlockPos pos = data.readBlockPos();
		World world = inv.player.getCommandSenderWorld();
		return new AnnunciatorContainer(windowId, world, pos, inv);
	}));
}
