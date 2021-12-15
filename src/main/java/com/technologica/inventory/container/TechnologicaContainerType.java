package com.technologica.inventory.container;

import com.technologica.Technologica;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TechnologicaContainerType {
	private static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Technologica.MODID);
	
	public static final RegistryObject<ContainerType<AnnunciatorContainer>> ANNUNCIATOR = CONTAINERS.register("annunciator_container", () -> IForgeContainerType.create(AnnunciatorContainer::new));
	
	public static void register() {
		CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}
