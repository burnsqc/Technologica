package com.technologica;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.technologica.block.TechnologicaBlocks;
import com.technologica.entity.TechnologicaEntityType;
import com.technologica.fluid.TechnologicaFluids;
import com.technologica.inventory.container.TechnologicaContainerType;
import com.technologica.item.TechnologicaItems;
import com.technologica.item.crafting.TechnologicaRecipeSerializer;
import com.technologica.listeners.BadLuckBananaWhenFishing;
import com.technologica.listeners.DisableLogDrops;
import com.technologica.listeners.DropBarkOnLogStrip;
import com.technologica.listeners.ExtraAirMeter;
import com.technologica.listeners.LunarLowGrav;
import com.technologica.listeners.RegisterEntityAttributes;
import com.technologica.listeners.RegistrationListener;
import com.technologica.listeners.WaterWalk;
import com.technologica.particles.TechnologicaParticleTypes;
import com.technologica.setup.ClientSetup;
import com.technologica.setup.CommonSetup;
import com.technologica.setup.Config;
import com.technologica.setup.GatherData;
import com.technologica.setup.ParticleSetup;
import com.technologica.setup.VanillaBiomeModifier;
import com.technologica.setup.VanillaEntityModifier;
import com.technologica.tileentity.TechnologicaTileEntities;
import com.technologica.util.DisablePlankConditionFactory;
import com.technologica.util.EnablePlankConditionFactory;
import com.technologica.util.TechnologicaSoundEvents;
import com.technologica.world.biome.TechnologicaBiomes;
import com.technologica.world.gen.feature.TechnologicaFeatures;
import com.technologica.world.gen.foliageplacer.TechnologicaFoliagePlacers;
import com.technologica.world.gen.surfacebuilders.TechnologicaSurfaceBuilders;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.particles.ParticleType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Technologica.MODID)
public class Technologica {
	public static final String MODID = "technologica";
	public static final Logger LOGGER = LogManager.getLogger();
	
	public Technologica() {
		ModLoadingContext.get().registerConfig(Type.COMMON, Config.SPEC, "technologica-common.toml");
		
		TechnologicaBlocks.init();
		TechnologicaItems.init();
		TechnologicaTileEntities.init();
		TechnologicaEntityType.init();
		TechnologicaFluids.init();
		TechnologicaContainerType.init();
		TechnologicaParticleTypes.init();
		TechnologicaRecipeSerializer.init();
		TechnologicaSoundEvents.init();
		TechnologicaBiomes.init();
		TechnologicaFeatures.init();
		TechnologicaFoliagePlacers.init();
		TechnologicaSurfaceBuilders.init();
		
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Block.class, RegistrationListener::onRegisterBlocks);
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Item.class, RegistrationListener::onRegisterItems);
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(TileEntityType.class, RegistrationListener::onRegisterTileEntities);
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(EntityType.class, RegistrationListener::onRegisterEntities);
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Fluid.class, RegistrationListener::onRegisterFluids);
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(ContainerType.class, RegistrationListener::onRegisterContainers);
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(ParticleType.class, RegistrationListener::onRegisterParticles);
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(IRecipeSerializer.class, RegistrationListener::onRegisterRecipeSerializers);
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(SoundEvent.class, RegistrationListener::onRegisterSoundEvents);
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Biome.class, RegistrationListener::onRegisterBiomes);
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Feature.class, RegistrationListener::onRegisterFeatures);
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(FoliagePlacerType.class, RegistrationListener::onRegisterFoliagePlacers);
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(SurfaceBuilder.class, RegistrationListener::onRegisterSurfaceBuilders);
		
		CraftingHelper.register(DisablePlankConditionFactory.Serializer.INSTANCE);
		CraftingHelper.register(EnablePlankConditionFactory.Serializer.INSTANCE);
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(CommonSetup::init);	//1st event during mod lifecycle startup
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);	//2nd event during mod lifecycle startup
		FMLJavaModLoadingContext.get().getModEventBus().addListener(GatherData::init);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::stitch);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ParticleSetup::init);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(RegisterEntityAttributes::onEntityAttributeCreationEvent);
		
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, VanillaBiomeModifier::init);	
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, VanillaEntityModifier::init);	
		
		MinecraftForge.EVENT_BUS.register(new BadLuckBananaWhenFishing());
		MinecraftForge.EVENT_BUS.register(new LunarLowGrav());
		MinecraftForge.EVENT_BUS.register(new DropBarkOnLogStrip());
		MinecraftForge.EVENT_BUS.register(new DisableLogDrops());
		MinecraftForge.EVENT_BUS.register(new ExtraAirMeter());
		MinecraftForge.EVENT_BUS.register(new WaterWalk());
	}
}
