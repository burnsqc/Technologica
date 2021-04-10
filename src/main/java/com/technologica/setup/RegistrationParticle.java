package com.technologica.setup;

import com.technologica.MainMod;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MainMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistrationParticle 
{  
	@SubscribeEvent
    public void registerFactories(ParticleFactoryRegisterEvent event) {    	
//    	Minecraft.getInstance().particles.registerFactory(Registration.BANANA_PARTICLE.get(), new BananaParticle.Factory());
//    	Minecraft.getInstance().particles.registerFactory(Registration.CHERRY_PARTICLE.get(), new CherryParticle.Factory());
//   	Minecraft.getInstance().particles.registerFactory(Registration.COCONUT_PARTICLE.get(), new CoconutParticle.Factory());
//    	Minecraft.getInstance().particles.registerFactory(Registration.LEMON_PARTICLE.get(), new LemonParticle.Factory());
//   	Minecraft.getInstance().particles.registerFactory(Registration.LIME_PARTICLE.get(), new LimeParticle.Factory());
//    	Minecraft.getInstance().particles.registerFactory(Registration.ORANGE_PARTICLE.get(), new OrangeParticle.Factory());
//    	Minecraft.getInstance().particles.registerFactory(Registration.PEACH_PARTICLE.get(), new PeachParticle.Factory());
//    	Minecraft.getInstance().particles.registerFactory(Registration.PEAR_PARTICLE.get(), new PearParticle.Factory());
     }
}