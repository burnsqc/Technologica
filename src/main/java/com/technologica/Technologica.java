package com.technologica;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.technologica.core.particles.TechnologicaParticleTypes;
import com.technologica.listeners.BadLuckBananaWhenFishing;
import com.technologica.listeners.DisableLogDrops;
import com.technologica.listeners.DropBarkOnLogStrip;
import com.technologica.listeners.ExtraAirMeter;
import com.technologica.listeners.LunarLowGrav;
import com.technologica.listeners.RegisterEntityAttributes;
import com.technologica.listeners.RegisterEntityRenderers;
import com.technologica.listeners.RegisterLayerDefinitons;
import com.technologica.listeners.RegistrationListener;
import com.technologica.listeners.WaterWalk;
import com.technologica.setup.ClientSetup;
import com.technologica.setup.CommonSetup;
import com.technologica.setup.Config;
import com.technologica.setup.GatherData;
import com.technologica.setup.ParticleSetup;
import com.technologica.setup.VanillaEntityModifier;
import com.technologica.util.DisablePlankConditionFactory;
import com.technologica.util.EnablePlankConditionFactory;
import com.technologica.util.TechnologicaSoundEvents;
import com.technologica.world.entity.TechnologicaEntityType;
import com.technologica.world.gen.foliageplacer.TechnologicaFoliagePlacers;
import com.technologica.world.inventory.TechnologicaContainerType;
import com.technologica.world.item.TechnologicaItems;
import com.technologica.world.item.crafting.TechnologicaRecipeSerializer;
import com.technologica.world.level.biome.TechnologicaBiomes;
import com.technologica.world.level.block.TechnologicaBlocks;
import com.technologica.world.level.block.entity.TechnologicaBlockEntityType;
import com.technologica.world.level.material.TechnologicaFluids;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.material.Fluid;
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
		TechnologicaBlockEntityType.init();
		TechnologicaEntityType.init();
		TechnologicaFluids.init();
		TechnologicaContainerType.init();
		TechnologicaParticleTypes.init();
		TechnologicaRecipeSerializer.init();
		TechnologicaSoundEvents.init();
		TechnologicaBiomes.init();
//		TechnologicaFeatures.init();
		TechnologicaFoliagePlacers.init();
		
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Block.class, RegistrationListener::onRegisterBlocks);
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Item.class, RegistrationListener::onRegisterItems);
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(BlockEntityType.class, RegistrationListener::onRegisterTileEntities);
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(EntityType.class, RegistrationListener::onRegisterEntities);
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Fluid.class, RegistrationListener::onRegisterFluids);
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(MenuType.class, RegistrationListener::onRegisterContainers);
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(ParticleType.class, RegistrationListener::onRegisterParticles);
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(RecipeSerializer.class, RegistrationListener::onRegisterRecipeSerializers);
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(SoundEvent.class, RegistrationListener::onRegisterSoundEvents);
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Biome.class, RegistrationListener::onRegisterBiomes);
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Feature.class, RegistrationListener::onRegisterFeatures);
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(FoliagePlacerType.class, RegistrationListener::onRegisterFoliagePlacers);
		
		CraftingHelper.register(DisablePlankConditionFactory.Serializer.INSTANCE);
		CraftingHelper.register(EnablePlankConditionFactory.Serializer.INSTANCE);
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(CommonSetup::init);	//1st event during mod lifecycle startup
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);	//2nd event during mod lifecycle startup
		FMLJavaModLoadingContext.get().getModEventBus().addListener(GatherData::init);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::stitch);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ParticleSetup::init);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(RegisterEntityAttributes::onEntityAttributeCreationEvent);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(RegisterEntityRenderers::onRegisterEntityRenderers);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(RegisterLayerDefinitons::on);
		
//		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, VanillaBiomeModifier::init);	
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, VanillaEntityModifier::init);	
		
		MinecraftForge.EVENT_BUS.register(new BadLuckBananaWhenFishing());
		MinecraftForge.EVENT_BUS.register(new LunarLowGrav());
		MinecraftForge.EVENT_BUS.register(new DropBarkOnLogStrip());
		MinecraftForge.EVENT_BUS.register(new DisableLogDrops());
		MinecraftForge.EVENT_BUS.register(new ExtraAirMeter());
		MinecraftForge.EVENT_BUS.register(new WaterWalk());
	}
}
